package listeners;

import base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Test Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("Test Execution Completed");
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Running Test : "
                + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Test Passed : "
                + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed : "
                + result.getName());

        System.out.println(
                "Screenshot Method Triggered"
        );

        // Capture Screenshot
        ScreenshotUtils.captureScreenshot(
                BaseTest.driver,
                result.getName()
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("Test Skipped : "
                + result.getName());
    }
}