package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver,
                                           String testName) {

        // Generate timestamp
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        // Create screenshots folder if not exists
        File screenshotDir = new File("screenshots");

        if (!screenshotDir.exists()) {

            screenshotDir.mkdir();
        }

        // Screenshot path
        String screenshotPath =
                "screenshots/" + testName + "_"
                        + timeStamp + ".png";

        // Capture screenshot
        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destFile = new File(screenshotPath);

        try {

            FileUtils.copyFile(srcFile, destFile);

            System.out.println("Screenshot saved: "
                    + screenshotPath);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return screenshotPath;
    }
}