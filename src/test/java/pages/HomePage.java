package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "fromPort")
    WebElement departureDropdown;


    @FindBy(name = "toPort")
    WebElement destinationDropdown;


    @FindBy(css = "input[type='submit']")
    WebElement findFlightsButton;


    public void selectDepartureCity(String city) {

        Select select = new Select(departureDropdown);
        select.selectByVisibleText(city);
    }


    public void selectDestinationCity(String city) {

        Select select = new Select(destinationDropdown);
        select.selectByVisibleText(city);
    }


    public void clickFindFlights() {

        clickElement(findFlightsButton);
    }


    public void searchFlight(String fromCity,
                             String toCity) {

        selectDepartureCity(fromCity);
        selectDestinationCity(toCity);
        clickFindFlights();
    }
}