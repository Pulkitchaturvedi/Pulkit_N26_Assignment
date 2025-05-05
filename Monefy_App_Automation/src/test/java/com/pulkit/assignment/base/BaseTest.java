package com.pulkit.assignment.base;

import com.pulkit.assignment.utils.TestListener;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.net.URL;
import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:udid", "29b18198f51c7ece");
        caps.setCapability("appium:deviceName", "Android Device");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.monefy.app.lite");
        caps.setCapability("appium:appActivity", "com.monefy.activities.main.MainActivity_");
        caps.setCapability("appium:noReset", false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        System.out.println("Initial activity: " + driver.currentActivity());

        // Wait for MainActivity if in LauncherActivity
        if (driver.currentActivity().contains("LauncherActivity")) {
            WebDriverWait activityWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            activityWait.until(d -> driver.currentActivity().contains("MainActivity"));
            System.out.println("Transitioned to activity: " + driver.currentActivity());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}