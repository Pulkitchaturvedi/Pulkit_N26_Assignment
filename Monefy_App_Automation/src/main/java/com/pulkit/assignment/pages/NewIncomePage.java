package com.pulkit.assignment.pages;

import com.pulkit.assignment.base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewIncomePage extends BasePage {
    @AndroidFindBy(accessibility = "Navigate up") private WebElement backButton;
    @AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button") private WebElement chooseCategoryButton;
    @AndroidFindBy(xpath ="//*[@text='Salary']") private WebElement salaryCategory;
    @AndroidFindBy(id ="com.monefy.app.lite:id/amount_text") private WebElement amountTextBox;

    public NewIncomePage(AppiumDriver driver) {
        super(driver);
    }

    public HomePage clickBackButton() {
        click(backButton, "Back Button");
        return new HomePage(driver);
    }

    public NewIncomePage clickKeyboardButton(String buttonToClick) {
        String locator = constructKeyboardNumber(buttonToClick);
        WebElement element = driver.findElement(By.id(locator));
        click(element, buttonToClick);
        return this;
    }

    public NewIncomePage clickIncomeCategory() {
        click(chooseCategoryButton, "Choose Category Button");
        return this;
    }

    public HomePage clickSalaryCategory() {
        click(salaryCategory, "Salary Category");
        return new HomePage(driver);
    }

    public NewIncomePage clickAmountTextBox(){
        click(amountTextBox, "Amount Text Box");
        return this;
    }

    private String constructKeyboardNumber(String value) {
        return "com.monefy.app.lite:id/buttonKeyboard" + value;
    }
}