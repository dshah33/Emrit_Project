package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement loginPassword;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@name='email']//span[contains(text(),'Email')]")
    public WebElement emailRequired;

    @FindBy(xpath = "//div[@name='password']//span[contains(text(),'your password')]")
    public WebElement passwordRequired;

    @FindBy(css = "div[role='status']")
    public WebElement loginErrorMessage;

}
