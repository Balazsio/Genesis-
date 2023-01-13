package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage extends PageObject {
    @FindBy(xpath = "//*[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    private WebElement thankYou_text;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void verifyThankYouIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'THANK YOU FOR YOUR ORDER')]")));
        this.thankYou_text.isDisplayed();
    }

}
