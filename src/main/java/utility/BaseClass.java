package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;
    public CommonClass common = new CommonClass();

    @BeforeMethod
    public void setupDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("incognito");
        option.addArguments("--no-sandbox");
        option.addArguments("--disable-dev-shm-usage");
        //option.addArguments("--headless");

        driver = new ChromeDriver(option);
        driver.get(Pages.MAIN_ROUTE.toString());

        common.log("----------------------- Browser session started -----------------------");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeDriver() {
        common.log("----------------------- Browser session ended -----------------------");
        driver.quit();
    }

}

