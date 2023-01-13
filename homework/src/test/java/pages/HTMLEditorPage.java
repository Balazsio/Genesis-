package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class HTMLEditorPage extends PageObject {
    //editor_text

    public HTMLEditorPage(WebDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("/html/body")).sendKeys(text);
    }

    public void makeTextBold() {
        WebElement clickable = driver.findElement(By.cssSelector("body > p"));

        int x = -600;
        new Actions(driver)
                .moveToElement(clickable, x, 0)
                .doubleClick()
                .build()
                .perform();

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("b")
                .perform();
    }

    public void makeTextUnderline() {
        WebElement clickable = driver.findElement(By.cssSelector("body > p"));

        int x = -500;
        new Actions(driver)
                .moveToElement(clickable, x, 0)
                .doubleClick()
                .build()
                .perform();

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("u")
                .perform();
    }

    public void validateTextAppear(String text) {
        WebElement e = driver.findElement(By.cssSelector("body > p"));
        String actualElementText = e.getText();
        String expectedElementText = text;
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual texts are not same");
    }
}
