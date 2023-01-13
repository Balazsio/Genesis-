package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCheckoutInformationPage extends PageObject {
    @FindBy(css = "#first-name")
    private WebElement firstName_textfield;
    @FindBy(css = "#last-name")
    private WebElement lastName_textfield;

    @FindBy(css = "#postal-code")
    private WebElement postalCode_textfield;

    @FindBy(css = "#continue")
    private WebElement continue_button;

    public MyCheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillFirstName() {
        this.firstName_textfield.sendKeys("Balazs");
    }

    public void fillLastName() {
        this.lastName_textfield.sendKeys("Szabo");
    }

    public void fillPostalCode() {
        this.postalCode_textfield.sendKeys("6000");
    }

    public void fillCustomerData(){
        fillFirstName();
        fillLastName();
        fillPostalCode();
    }

    public void clickContinue() {
        this.continue_button.click();
    }

}
