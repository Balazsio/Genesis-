import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.GuruDemoPage;

import java.util.Arrays;

public class IFrameAndTabTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "IFrameTest (Case4) test")
    public static void IFrameTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList("start-maximized"));
        driver = new ChromeDriver(options);
        driver.get(Utils.GURU_URL);

        GuruDemoPage guruDemoPage = new GuruDemoPage(driver);
        guruDemoPage.clickIFrameAndVerifyNewTabTitle();
        guruDemoPage.scrollToMenus();
        guruDemoPage.clickHoverMenuItem();
        guruDemoPage.verifyWideRedButtonIsDisplayed();
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }

}
