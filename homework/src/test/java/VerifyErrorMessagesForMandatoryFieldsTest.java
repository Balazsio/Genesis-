import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.WebFormPage;

public class VerifyErrorMessagesForMandatoryFieldsTest {
    public static WebDriver driverCustomer;

    @BeforeSuite
    public void setupTest() {
    System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Verify error messages for mandatory fields (Case2) test")
    public static void VerifyErrorMsgTest() {
        driverCustomer = new ChromeDriver();
        driverCustomer.get(Utils.SAUCEDEMO_URL);
        driverCustomer.manage().window().maximize();
        WebFormPage webFormPage = new WebFormPage(driverCustomer);
        webFormPage.pressLoginButton();
        webFormPage.validateErrorMessage();
        webFormPage.setCredentials(Utils.username, Utils.password);
        webFormPage.pressLoginButton();
        ProductsPage productsPage = new ProductsPage(driverCustomer);
        productsPage.scrollToTheEnd();
        productsPage.validateFooterMessage();
    }

    @AfterSuite
    public static void tearDown() {
        driverCustomer.quit();
    }
}
