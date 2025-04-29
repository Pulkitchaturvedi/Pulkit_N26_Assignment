package com.pulkit.assignment.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils {
    public static void waitForElement(AppiumDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}