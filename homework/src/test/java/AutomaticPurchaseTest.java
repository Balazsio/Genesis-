import com.google.gson.Gson;
import credential.Credential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class AutomaticPurchaseTest {
    public static WebDriver driverCustomer;

    @BeforeSuite
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Automatic purchase (Case1) test")
    public static void PurchaseTest() throws FileNotFoundException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList("start-maximized"));
        driverCustomer = new ChromeDriver(options);

        driverCustomer.get(Utils.SAUCEDEMO_URL);
        WebFormPage webFormPage = new WebFormPage(driverCustomer);
        Gson gson = new Gson();
        Credential credential = gson.fromJson(new FileReader(Utils.JSON_PATH), Credential.class);

        webFormPage.setCredentials(credential.getUsername(), credential.getPassword());
        webFormPage.pressLoginButton();

        ProductsPage productsPage = new ProductsPage(driverCustomer);
        productsPage.verifyLoginSuccess();
        productsPage.addBackpackToCart();
        productsPage.addFleeceJacketToCart();
        productsPage.verifyShoppingCartItemNumber();
        productsPage.clickShoppingCart();

        MyCartPage myCartPage = new MyCartPage(driverCustomer);
        myCartPage.clickShoppingCart();
        MyCheckoutInformationPage myCheckoutInformationPage = new MyCheckoutInformationPage(driverCustomer);
        myCheckoutInformationPage.fillCustomerData();
        myCheckoutInformationPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driverCustomer);
        checkoutOverviewPage.clickFinish();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driverCustomer);
        checkoutCompletePage.verifyThankYouIsDisplayed();
    }

    @AfterSuite
    public static void tearDown() {
        driverCustomer.quit();
    }
}
