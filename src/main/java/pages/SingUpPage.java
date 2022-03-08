package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class SingUpPage {

    WebDriver driver;

    public SingUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement signupEmail;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement signupFirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement signupLastName;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement signupPhone;

    @FindBy(xpath = "//label[text()='Country']/..//div[contains(@class,'select__value-container')]")
    public WebElement country;

    @FindBy(xpath = "//input[@name='address-search']")
    public WebElement address;

    @FindBy(xpath = "//input[@name='age']/following-sibling::label")
    public WebElement confirmAge;

    @FindBy(xpath = "//input[@name='agreePolicies']/following-sibling::label")
    public WebElement confirmConditions;

    @FindBy(css = "button[type='submit']")
    public WebElement buttonSignup;

    @FindBy(xpath = "//button[text()='Verify']")
    public WebElement buttonVerify;

    public WebElement selectCountry(String country) {
        return driver.findElement(By.xpath("//div[contains(@id,'react-select') and text()='" + country + "']"));
    }

    public List<WebElement> selectAddress(String address) {
        return driver.findElements(By.xpath("//div[@name='address-search']//following-sibling::div//div[contains(text(),'" + address + "')]"));
    }

}
