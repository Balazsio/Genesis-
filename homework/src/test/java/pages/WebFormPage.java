package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.PageObject;

import java.time.Duration;

public class WebFormPage extends PageObject {
    @FindBy(css = "#user-name")
    private WebElement userName;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#login-button")
    private WebElement login_button;

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    public void setCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }

    public void enterUsername(String username) {
        this.userName.sendKeys(username);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void pressLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-button")));
        this.login_button.click();
    }

    public void validateErrorMessage() {
        WebElement e = driver.findElement(By.cssSelector(".error-message-container > h3:nth-child(1)"));
        String actualElementText = e.getText();
        String expectedElementText = "Epic sadface: Username is required";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual error messages are not same");

    }
}
