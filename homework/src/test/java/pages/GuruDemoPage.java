package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class GuruDemoPage extends PageObject {
    @FindBy(xpath = "html/body/a/img")
    private WebElement Iframe_image;

    public GuruDemoPage(WebDriver driver) {
        super(driver);
    }

    public void clickIFrameAndVerifyNewTabTitle() {
        driver.switchTo().frame("gdpr-consent-notice");
        driver.findElement(By.xpath("//*[@id=\"save\"]")).click();

        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;

        driver.switchTo().frame("a077aa5e"); //switching the frame by ID
        driver.findElement(By.xpath("html/body/a/img")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String expectedTitle = "Selenium Live Project: FREE Real Time Project for Practice";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.close();

        //Switch back to the old tab or window
        driver.switchTo().window(originalWindow);
    }


    public void scrollToMenus() {
        WebElement element = driver.findElement(By.cssSelector(".item118 > a:nth-child(1)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickHoverMenuItem() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.cssSelector(".item118"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html/body/div[4]/header/div[1]/div/div[2]/div/ul/li[2]/div/div/ul/li[3]/a"))).click().build().perform();

        //google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0
        driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
        driver.switchTo().frame("ad_iframe");

        driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

        driver.findElement(By.cssSelector("body > div.fc-consent-root > div.fc-dialog-container > div.fc-dialog.fc-choice-dialog > div.fc-footer-buttons-container > div.fc-footer-buttons > button.fc-button.fc-cta-consent.fc-primary-button")).click();

    }

    public void verifyWideRedButtonIsDisplayed() {
        //There is no 'Join Now' button
    }
}
