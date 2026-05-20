package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.FlightListPage;
import pages.HomePage;
import pages.PurchasePage;

public class PurchaseTest extends BaseTest {

    @Test
    public void verifySuccessfulPurchase() {

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
                "1234567890123456",
                "Preethi"
        );

        purchasePage.clickPurchaseFlight();

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        Assert.assertTrue(
                confirmationPage.isConfirmationDisplayed(),
                "Confirmation page not displayed"
        );

        Assert.assertFalse(
                confirmationPage.getBookingId().isEmpty(),
                "Booking ID not generated"
        );

        Assert.assertTrue(
                confirmationPage.getThankYouMessage()
                        .contains("Thank you"),
                "Thank you message missing"
        );
    }
}
