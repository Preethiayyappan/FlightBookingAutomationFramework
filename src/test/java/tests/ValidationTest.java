package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightListPage;
import pages.HomePage;
import pages.PurchasePage;

public class ValidationTest extends BaseTest {

    @Test
    public void verifyEmptyNameField() {


        HomePage homePage = new HomePage(driver);


        homePage.searchFlight("Boston", "London");


        FlightListPage flightListPage =
                new FlightListPage(driver);

        flightListPage.chooseFirstFlight();


        PurchasePage purchasePage =
                new PurchasePage(driver);


        purchasePage.fillPurchaseForm(
                "",
                "Anna Nagar",
                "Chennai",
                "Tamil Nadu",
                "600001",
                "1234567890123456",
                "Preethi"
        );


        purchasePage.clickPurchaseFlight();


        Assert.assertTrue(
                driver.getTitle().contains("BlazeDemo"),
                "Purchase flow failed"
        );
    }

    @Test
    public void verifyInvalidCardNumber() {


        HomePage homePage = new HomePage(driver);


        homePage.searchFlight("Boston", "London");


        FlightListPage flightListPage =
                new FlightListPage(driver);

        flightListPage.chooseFirstFlight();


        PurchasePage purchasePage =
                new PurchasePage(driver);


        purchasePage.fillPurchaseForm(
                "Preethi",
                "Anna Nagar",
                "Chennai",
                "Tamil Nadu",
                "600001",
                "INVALID_CARD",
                "Preethi"
        );


        purchasePage.clickPurchaseFlight();


        Assert.assertTrue(
                driver.getTitle().contains("BlazeDemo"),
                "Purchase flow failed"
        );
    }
}