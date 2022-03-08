package test_cases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SingUpPage;
import utility.BaseClass;
import utility.Pages;
import utility.RandomData;

import java.time.Duration;

public class SmokeTest extends BaseClass {

    RandomData random = new RandomData();

    @Test(priority = 1)
    public void signup() {

        HomePage home = new HomePage(driver);
        SingUpPage signup = new SingUpPage(driver);

        String email = random.email();
        String firstName = random.firstName();
        String lastName = random.lastName();
        String address = random.address();
        String phone = random.phoneNumber();

        common.log("Click on Hamburger menu");
        common.clickOn(home.buttonHamburger);
        common.log("Click on 'Sign Up' link");
        common.clickOn(home.linkSignup);

        common.log("Email email address : " + email);
        common.type(signup.signupEmail, email);
        common.log("Email First Name : " + firstName);
        common.type(signup.signupFirstName, firstName);
        common.log("Email Last Name : " + lastName);
        common.type(signup.signupLastName, lastName);
        common.log("Email Phone Number : " + phone);
        common.type(signup.signupPhone, phone);
        common.log("Select Country : United States of America");
        common.clickByAction(driver, signup.country);
        common.clickOn(signup.selectCountry("United States of America"));
        common.log("Enter Address and select");
        common.type(signup.address, address);
        common.pause(2);
        common.clickOn(signup.selectAddress(address).get(0));
        common.pause(2);
        common.log("Confirm Age");
        common.clickOn(signup.confirmAge);
        common.log("Confirm Terms and Conditions");
        common.clickByJS(driver, signup.confirmConditions);
        common.log("Click on 'SIGN UP' button");
        common.clickOn(signup.buttonSignup);

        common.log("Verify Sign Up verification screen display");
        Assert.assertTrue(signup.buttonVerify.isDisplayed());

    }

    @Test(priority = 2)
    public void login() {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        String email = common.readProperty("LOGIN_EMAIL");
        String password = common.readProperty("LOGIN_PASSWORD");

        common.log("Click on 'LOGIN' link");
        common.clickOn(home.linkLogin);
        common.log("Click on 'LOGIN' button");
        common.clickOn(login.loginButton);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(login.loginEmail));

        common.log("Verify validation message for the blank email and password");
        Assert.assertEquals(common.textOf(login.emailRequired), "Email is a required field");
        Assert.assertEquals(common.textOf(login.passwordRequired), "Please enter your password");

        common.log("Enter email address :" + email);
        common.type(login.loginEmail, email);
        common.log("Click on 'LOGIN' button");
        common.clickOn(login.loginButton);

        common.log("Verify validation message for the blank password");
        Assert.assertEquals(common.textOf(login.passwordRequired), "Please enter your password");

        common.log("Enter invalid Password");
        common.type(login.loginPassword, random.password());
        common.log("Click on 'LOGIN' button");
        common.clickOn(login.loginButton);

        common.log("Verify validation message for the invalid credentials");
        Assert.assertTrue(login.loginErrorMessage.isDisplayed());

        common.log("Enter valid Password");
        common.type(login.loginPassword, password);
        common.log("Click on 'LOGIN' button");
        common.clickOn(login.loginButton);

    }

    @Test(priority = 3)
    public void contactUs() {

        HomePage home = new HomePage(driver);

        String firstName = random.firstName();
        String lastname = random.lastName();
        String email = random.email();
        String company = random.company();

        common.log("Click on 'BECOME AN ENTERPRISE PARTNER' button");
        common.clickOn(home.buttonBecomeEnterprisePartner);

        common.log("Click on 'BECOME AN ENTERPRISE PARTNER' button");
        common.clickOn(home.buttonBecomeEnterprisePartner2);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(home.firstName));

        common.log("Enter First Name : " + firstName);
        common.type(home.firstName, firstName);
        common.log("Enter Last Name : " + lastname);
        common.type(home.lastName, lastname);
        common.log("Enter Email : " + email);
        common.type(home.email, email);
        common.log("Enter Company : " + company);
        common.type(home.company, company);
        common.log("Select Country : " + "United States*");
        common.selectValue(home.selectCountry, "United States*");

        common.log("Click on 'CONTACT US' button");
        common.clickOn(home.contactUs);

        common.log("Verify Contact Us form submitted successfully");
        Assert.assertFalse(home.errorMessage.isDisplayed());

    }

    @Test(priority = 4)
    public void pageLinks() {

        HomePage home = new HomePage(driver);

        common.log("Click on 'EMRIT FOR BUSINESS' link.");
        common.clickOn(home.linkBusiness);
        common.log("Verify 'EMRIT FOR BUSINESS' link redirection working properly");
        Assert.assertEquals(driver.getTitle(), "Build Your Digital Infrastructure Today | Partner with Emrit");
        Assert.assertEquals(driver.getCurrentUrl(), Pages.MAIN_ROUTE + "" + Pages.PARTNERS);

        common.log("Click on 'ABOUT US' link.");
        common.clickOn(home.linkAbout);
        common.log("Verify 'ABOUT US' link redirection working properly");
        Assert.assertEquals(driver.getTitle(), "About - Emrit");
        Assert.assertEquals(driver.getCurrentUrl(), Pages.MAIN_ROUTE + "" + Pages.ABOUT);


        common.log("Click on 'SUPPORT' link.");
        common.clickOn(home.linkSupport);
        common.log("Verify 'SUPPORT' link redirection working properly");
        Assert.assertEquals(driver.getTitle(), "Support : Emrit Support");
        Assert.assertEquals(driver.getCurrentUrl(), Pages.SUPPORT_ROUTE + "" + Pages.SUPPORT);

        driver.navigate().to(Pages.MAIN_ROUTE.toString());
        common.log("Click on 'LOGIN' link.");
        common.clickOn(home.linkLogin);
        common.log("Verify 'LOGIN' link redirection working properly");
        Assert.assertEquals(driver.getTitle(), "Emrit Inc");
        Assert.assertEquals(driver.getCurrentUrl(), Pages.APP_ROUTE + "" + Pages.LOGIN);

        driver.navigate().to(Pages.MAIN_ROUTE.toString());
        common.log("Click on Hamburger menu");
        common.clickOn(home.buttonHamburger);
        common.pause(1);
        common.log("Click on 'SIGN UP' link");
        common.clickOn(home.linkSignup);
        common.pause(3);
        common.log("Verify 'SIGN UP' link redirection working properly");
        Assert.assertEquals(driver.getTitle(), "Emrit Inc");
        Assert.assertEquals(driver.getCurrentUrl(), Pages.APP_ROUTE + "" + Pages.SIGNUP);

        driver.navigate().to(Pages.MAIN_ROUTE.toString());
        common.log("Click on Hamburger menu");
        common.clickOn(home.buttonHamburger);
        common.pause(1);
        common.log("Click on 'BLOG' link");
        common.clickOn(home.linkBlog);
        common.log("Verify 'BLOG' link redirection working properly");
        Assert.assertEquals(driver.getTitle(), "Blog - Emrit");
        Assert.assertEquals(driver.getCurrentUrl(), Pages.MAIN_ROUTE + "" + Pages.BLOG);

        driver.navigate().to(Pages.MAIN_ROUTE.toString());
        common.log("Click on Hamburger menu");
        common.clickOn(home.buttonHamburger);
        common.pause(1);
        common.log("Click on 'FAQ' link.");
        common.clickOn(home.linkFAQ);
        common.log("Verify 'FAQ' link redirection working properly");
        Assert.assertEquals(driver.getTitle(), "FAQ - Emrit");
        Assert.assertEquals(driver.getCurrentUrl(), Pages.MAIN_ROUTE + "" + Pages.FAQ);

        common.log("Click on 'Terms & Conditions' link.");
        common.clickOn(home.linkTnC);
        common.log("Verify 'Terms & Conditions' link redirection working properly");
        Assert.assertEquals(driver.getTitle(), "Terms & Conditions - Emrit");
        Assert.assertEquals(driver.getCurrentUrl(), Pages.MAIN_ROUTE + "" + Pages.TERMS_CONDITIONS);

        common.log("Click on 'Privacy Policy' link.");
        common.clickOn(home.linkPolicy);
        common.log("Verify 'Privacy Policy' link redirection working properly");
        Assert.assertEquals(driver.getTitle(), "Privacy Policy - Emrit");
        Assert.assertEquals(driver.getCurrentUrl(), Pages.MAIN_ROUTE + "" + Pages.PRIVACY_POLICY);

    }

}
