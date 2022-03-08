package test_cases;

import org.testng.annotations.Test;
import utility.BaseClass;
import utility.Pages;

public class PerformanceTest extends BaseClass {

    @Test
    public void partnersPage() {
        common.log("Navigate to " + Pages.MAIN_ROUTE + Pages.PARTNERS + " page");
        driver.navigate().to(Pages.MAIN_ROUTE.toString() + Pages.PARTNERS);
        common.log("Page load time : " + common.getPageLoadTime(driver) + " seconds");
        common.getBrowserErrors(driver);
    }

    @Test
    public void aboutUsPage() {
        common.log("Navigate to " + Pages.MAIN_ROUTE + Pages.ABOUT + " page");
        driver.navigate().to(Pages.MAIN_ROUTE.toString() + Pages.ABOUT);
        common.log("Page load time : " + common.getPageLoadTime(driver) + " seconds");
        common.getBrowserErrors(driver);
    }

}
