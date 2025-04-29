package com.pulkit.assignment.pages;

import com.pulkit.assignment.constants.FrameworkConstants;
import com.pulkit.assignment.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    public String getAttribute(WebElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }
}