package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCartPage extends PageObject {
    @FindBy(css = "#checkout")
    private WebElement checkout_button;

    public MyCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickShoppingCart() {
        this.checkout_button.click();
    }

}
