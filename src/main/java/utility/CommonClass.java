package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.logging.Level;

public class CommonClass {

    public void getBrowserErrors(WebDriver driver) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        log("------------------------ LOG ERROR STARTED ------------------------");
        logEntries.forEach(logEntry -> {
            if (logEntry.getLevel().equals(Level.SEVERE)) {
                log(logEntry.getMessage());
            }
        });
        log("------------------------ LOG ERROR ENDED ------------------------");
    }

    public void log(String message) {
        Reporter.log(message + "<br>", true);
    }

    public String textOf(WebElement element) {
        return element.getText();
    }

    public String getPageLoadTime(WebDriver driver) {
        DecimalFormat df = new DecimalFormat("#.####");
        String responseStart = ((JavascriptExecutor) driver).executeScript("return window.performance.timing.responseStart").toString();
        String domComplete = ((JavascriptExecutor) driver).executeScript("return window.performance.timing.domComplete").toString();
        return df.format(Long.parseLong(domComplete) / 1000.00 - Long.parseLong(responseStart) / 1000.00);
    }

    public void type(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void selectValue(WebElement select, String value) {
        Select selection = new Select(select);
        selection.selectByValue(value);
    }

    public void clickOn(WebElement element) {
        element.click();
    }

    public String readProperty(String key) {
        String value = null;
        try {
            FileReader reader = new FileReader(System.getProperty("user.dir")
                    + File.separator + "resources"
                    + File.separator + "config.properties");
            Properties prop = new Properties();
            prop.load(reader);
            value = prop.getProperty(key);
        } catch (Exception ex) {
            log("ERROR : Error while reading property from properties file");
        }
        return value;
    }

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            log("ERROR : Error during pause");
        }
    }

    public void clickByAction(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).click().perform();
    }

    public void clickByJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
