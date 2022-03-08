package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(css = "div[class*='hamburger']")
    public WebElement buttonHamburger;

    @FindBy(css = "ul a[href*='sign-up']")
    public WebElement linkSignup;

    @FindBy(css = "a[href*='/login']")
    public WebElement linkLogin;

    @FindBy(css = "a[href*='/partners']")
    public WebElement linkBusiness;

    @FindBy(css = "a[href*='/about']")
    public WebElement linkAbout;

    @FindBy(css = "a[href*='/support']")
    public WebElement linkSupport;

    @FindBy(css = "a[href*='/blog']")
    public WebElement linkBlog;

    @FindBy(xpath = "//div[@data-elementor-type='popup']//nav[not(@aria-hidden)]//a[contains(@href,'faq')]")
    public WebElement linkFAQ;

    @FindBy(css = "a[href*='terms-and-conditions']")
    public WebElement linkTnC;

    @FindBy(css = "a[href*='privacy-policy']")
    public WebElement linkPolicy;

    @FindBy(css = "a[href='/partners/']")
    public WebElement buttonBecomeEnterprisePartner;

    @FindBy(css = "div a[role='button']")
    public WebElement buttonBecomeEnterprisePartner2;

    @FindBy(id = "form-field-name")
    public WebElement firstName;

    @FindBy(id = "form-field-last_name")
    public WebElement lastName;

    @FindBy(id = "form-field-email")
    public WebElement email;

    @FindBy(id = "form-field-company")
    public WebElement company;

    @FindBy(id = "form-field-country")
    public WebElement selectCountry;

    @FindBy(css = "button[type='submit']")
    public WebElement contactUs;

    @FindBy(css = "div[role='alert']")
    public WebElement errorMessage;

}
