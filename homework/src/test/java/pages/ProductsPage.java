package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.Year;

public class ProductsPage extends PageObject {
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement productsTitleText;
    @FindBy(xpath = "//*[contains(text(),'2023')]")
    private WebElement copyrightYearText;

    @FindBy(xpath = "//*[contains(text(),'Terms of Service')]")
    private WebElement termsOfServiceText;

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private WebElement add_toCart_Backpack_button;

    @FindBy(css = "#add-to-cart-sauce-labs-fleece-jacket")
    private WebElement add_toCart_FleeceJacket_button;
    @FindBy(css = "#shopping_cart_container > a")
    private WebElement shoppingCart_button;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Products')]")));
        this.productsTitleText.isDisplayed();
    }

    public void verifyShoppingCartItemNumber() {
        WebElement e = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));
        String actualElementText = e.getText();
        String expectedElementText = "2";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual shopping cart items are not same");
    }

    public void clickShoppingCart() {
        this.shoppingCart_button.click();
    }

    public void addBackpackToCart() {
        this.add_toCart_Backpack_button.click();
    }

    public void addFleeceJacketToCart() {
        this.add_toCart_FleeceJacket_button.click();
    }

    public void scrollToTheEnd() {
        WebElement element = driver.findElement(By.cssSelector("#page_wrapper > footer > div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void validateFooterMessage() {
        WebElement e = driver.findElement(By.cssSelector("#page_wrapper > footer > div"));
        String actualElementText = e.getText();
        String expectedYear = String.valueOf(Year.now().getValue());
//        String expectedElementText = "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
//        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual footer messages are not same");
        Assert.assertTrue(actualElementText.contains(expectedYear), "Actual footer message doesn't contain current year");
        Assert.assertTrue(actualElementText.contains("Terms of Service"), "Actual footer message doesn't contain Terms of Service");
    }
}
