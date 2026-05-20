package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(tagName = "h1")
    WebElement thankYouMessage;


    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    WebElement bookingId;


    public String getThankYouMessage() {

        return getElementText(thankYouMessage);
    }


    public String getBookingId() {

        return getElementText(bookingId);
    }

    public boolean isConfirmationDisplayed() {

        return isElementDisplayed(thankYouMessage);
    }
}