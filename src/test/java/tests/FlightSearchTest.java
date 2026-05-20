package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightListPage;
import pages.HomePage;

public class FlightSearchTest extends BaseTest {

    @Test
    public void verifyFlightSearch() {


        HomePage homePage = new HomePage(driver);

       ]
        homePage.searchFlight("Boston", "London");

        FlightListPage flightListPage =
                new FlightListPage(driver);


        Assert.assertTrue(
                flightListPage.isFlightListDisplayed(),
                "Flight list is not displayed"
        );

        Assert.assertTrue(
                flightListPage.getFlightCount() > 0,
                "No flights found"
        );
    }

    @Test
    public void verifyFlightsPageLoads() {

        HomePage homePage = new HomePage(driver);

        homePage.searchFlight("Boston", "London");


        Assert.assertTrue(
                driver.getCurrentUrl().contains("reserve"),
                "Flights page did not load"
        );
    }
}