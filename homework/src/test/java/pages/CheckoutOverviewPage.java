package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends PageObject {
    @FindBy(css = "#finish")
    private WebElement finish_button;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickFinish() {
        this.finish_button.click();
    }
}
