package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightListPage extends BasePage {

    WebDriver driver;

    public FlightListPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> flightRows;


    @FindBy(xpath = "(//input[@value='Choose This Flight'])[1]")
    WebElement chooseFlightButton;

    @FindBy(xpath = "(//table/tbody/tr[1]/td)[6]")
    WebElement firstFlightPrice;


    public int getFlightCount() {

        return flightRows.size();
    }


    public boolean isFlightListDisplayed() {

        return flightRows.size() > 0;
    }


    public void chooseFirstFlight() {

        clickElement(chooseFlightButton);
    }


    public String getFlightPrice() {

        return getElementText(firstFlightPrice);
    }
}