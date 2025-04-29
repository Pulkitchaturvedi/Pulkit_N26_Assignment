package com.pulkit.assignment.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.net.URL;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");

        caps.setCapability("appium:udid",           "29b18198f51c7ece");
        caps.setCapability("appium:deviceName",     "Android Device");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage",     "com.monefy.app.lite");
        caps.setCapability("appium:appActivity",    "com.monefy.app.lite.MainActivity");
        caps.setCapability("appium:noReset",        true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}