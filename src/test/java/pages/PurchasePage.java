package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage extends BasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "inputName")
    WebElement nameField;


    @FindBy(id = "address")
    WebElement addressField;


    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "state")
    WebElement stateField;


    @FindBy(id = "zipCode")
    WebElement zipCodeField;


    @FindBy(id = "creditCardNumber")
    WebElement creditCardField;


    @FindBy(id = "nameOnCard")
    WebElement nameOnCardField;


    @FindBy(css = "input[type='submit']")
    WebElement purchaseButton;

    @FindBy(xpath = "//p[3]")
    WebElement totalPriceText;

    public void enterName(String name) {

        enterText(nameField, name);
    }

    public void fillPurchaseForm(String name,
                                 String address,
                                 String city,
                                 String state,
                                 String zip,
                                 String cardNumber,
                                 String cardName) {

        enterText(nameField, name);
        enterText(addressField, address);
        enterText(cityField, city);
        enterText(stateField, state);
        enterText(zipCodeField, zip);
        enterText(creditCardField, cardNumber);
        enterText(nameOnCardField, cardName);
    }

    public void clickPurchaseFlight() {

        clickElement(purchaseButton);
    }


    public String getTotalPriceText() {

        return getElementText(totalPriceText);
    }
}