package tests;

import base.BaseTest;
import dataproviders.FlightDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightListPage;
import pages.HomePage;

public class RouteSearchTest extends BaseTest {

    @Test(dataProvider = "flightData",
            dataProviderClass = FlightDataProvider.class)

    public void verifyDifferentRoutes(String fromCity,
                                      String toCity) {

        HomePage homePage = new HomePage(driver);

        homePage.searchFlight(fromCity, toCity);

        FlightListPage flightListPage =
                new FlightListPage(driver);

        Assert.assertTrue(
                flightListPage.isFlightListDisplayed(),
                "Flights not displayed"
        );

        Assert.assertTrue(
                driver.getTitle().contains("BlazeDemo"),
                "Incorrect page title"
        );
    }
}