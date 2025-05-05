package com.pulkit.assignment.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import com.pulkit.assignment.base.BasePage;

public class EditIncomePage extends BasePage {
    @AndroidFindBy(id = "com.monefy.app.lite:id/amount_text")
    private WebElement amountField;

    @AndroidFindBy(id = "com.monefy.app.lite:id/save_button")
    private WebElement saveButton;

    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonSave")
    private WebElement buttonSave;

    public EditIncomePage(AppiumDriver driver) {
        super(driver);
    }

    public EditIncomePage clickKeyboardButton(String buttonToClick) {
        String locator = constructKeyboardNumber(buttonToClick);
        WebElement element = driver.findElement(By.id(locator));
        click(element, buttonToClick);
        return this;
    }

    public EditIncomePage clickAmount() {
        click(amountField, "Amount Field");
        return this;
    }

    public EditIncomePage chooseCategory(String categoryId) {
        click(chooseCategoryButton, "Choose Category Button");
        return this;
    }

    public EditIncomePage clickSaveButton() {
        click(buttonSave, "Save Button");
        return this;
    }

    private String constructKeyboardNumber(String digit) {
        return "com.monefy.app.lite:id/buttonKeyboard" + digit;
    }

    @AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
    private WebElement chooseCategoryButton;
}