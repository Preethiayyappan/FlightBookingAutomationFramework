package dataproviders;

import org.testng.annotations.DataProvider;

public class FlightDataProvider {

    @DataProvider(name = "flightData")
    public Object[][] getFlightData() {

        return new Object[][]{

                {"Boston", "London"},
                {"Paris", "Rome"},
                {"Portland", "Berlin"}

        };
    }
}