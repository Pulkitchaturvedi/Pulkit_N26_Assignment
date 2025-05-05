package com.pulkit.assignment.pages;

import io.appium.java_client.AppiumDriver;
import com.pulkit.assignment.pages.HomePage;
import com.pulkit.assignment.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewExpensePage extends BasePage {
    @AndroidFindBy(accessibility = "Navigate up") private WebElement backButton;
    @AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button") private WebElement chooseCategoryButton;
//    @AndroidFindBy(xpath ="//*[@text='Food']") private WebElement foodCategory;
@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.monefy.app.lite:id/textCategoryName' and @text='Food']")
private WebElement foodCategory;
    @AndroidFindBy(id ="com.monefy.app.lite:id/amount_text") private WebElement amountTextBox;

    public NewExpensePage(AppiumDriver driver) {
        super(driver);
    }

    public HomePage clickBackButton() {
        click(backButton, "Back Button");
        return new HomePage(driver);
    }

    public NewExpensePage clickKeyboardButton(String buttonToClick) {
        String locator = constructKeyboardNumber(buttonToClick);
        WebElement element = driver.findElement(By.id(locator));
        click(element, buttonToClick);
        return this;
    }

    public NewExpensePage clickExpenseCategory() {
        click(chooseCategoryButton, "Choose Category Button");
        return this;
    }

    public HomePage clickFoodCategory() {
        click(foodCategory, "Food Category");
        return new HomePage(driver);
    }

    public NewExpensePage clickAmountTextBox(){
        click(amountTextBox,"Amount Text Box");
        return this;
    }

    private String constructKeyboardNumber(String value) {
        return "com.monefy.app.lite:id/buttonKeyboard" + value;
    }
}