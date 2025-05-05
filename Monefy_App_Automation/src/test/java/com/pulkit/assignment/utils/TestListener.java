package com.pulkit.assignment.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getMethod().getMethodName());

        // Create ExtentTest instance
        ExtentTest extentTest = extent.createTest(
                result.getMethod().getMethodName(),
                result.getMethod().getDescription());

        // Store in ThreadLocal for access in other methods
        test.set(extentTest);
        ReportManager.setTest(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getMethod().getMethodName());
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getMethod().getMethodName());

        // Log failure details
        test.get().log(Status.FAIL, "Test failed");
        test.get().log(Status.FAIL, result.getThrowable());

        // Capture screenshot if possible
        Object testInstance = result.getInstance();
        if (testInstance != null) {
            try {
                AppiumDriver driver = getDriverFromInstance(testInstance);
                if (driver != null) {
                    String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
                    test.get().addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
                }
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getMethod().getMethodName());
        test.get().log(Status.SKIP, "Test skipped");
        test.get().log(Status.SKIP, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite finished: " + context.getName());
        // Generate report
        extent.flush();
    }

    private AppiumDriver getDriverFromInstance(Object instance) {
        try {
            // Use reflection to access the driver field from BaseTest
            return (AppiumDriver) instance.getClass().getSuperclass().getDeclaredField("driver").get(instance);
        } catch (Exception e) {
            System.err.println("Could not access driver: " + e.getMessage());
            return null;
        }
    }

    private String captureScreenshot(AppiumDriver driver, String testName) throws IOException {
        // Create screenshots directory
        File screenshotDir = new File("test-output/screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        // Generate unique filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = testName + "_" + timestamp + ".png";
        String filepath = "test-output/screenshots/" + filename;

        // Take screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get(filepath);
        Files.copy(screenshot.toPath(), destination);

        return filepath;
    }
}