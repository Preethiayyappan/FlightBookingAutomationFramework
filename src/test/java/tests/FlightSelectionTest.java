package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightListPage;
import pages.HomePage;
import pages.PurchasePage;

public class FlightSelectionTest extends BaseTest {

    @Test
    public void verifyFlightSelection() {

        HomePage homePage = new HomePage(driver);

        homePage.searchFlight("Boston", "London");

        FlightListPage flightListPage =
                new FlightListPage(driver);

        String flightPrice =
                flightListPage.getFlightPrice();

        flightListPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        Assert.assertTrue(
                purchasePage.getPageTitle()
                        .contains("BlazeDemo Purchase"),
                "Purchase page not loaded"
        );

        Assert.assertTrue(
                purchasePage.getTotalPriceText()
                        .contains("Price"),
                "Price not displayed"
        );
    }
}