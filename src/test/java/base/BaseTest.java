package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.initializeDriver(
                ConfigReader.getBrowser()
        );

        driver.get(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}