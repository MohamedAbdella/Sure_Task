package Listeners;

import BaseTest.baseTest;
import Utalities.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        // Get the driver from the test class
        Object testClass = result.getInstance();
        WebDriver driver = ((baseTest) testClass).getDriver();

        // Capture the screenshot
        ScreenshotUtil.captureScreenshot(driver, result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestSuccess(ITestResult result) {}
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
    @Override
    public void onFinish(ITestContext context) {}
}
