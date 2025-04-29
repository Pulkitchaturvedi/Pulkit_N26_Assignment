package com.pulkit.assignment.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Monefy']")
    private WebElement titleText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All accounts']")
    private WebElement accountSelectorText;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_amount_text")
    private WebElement incomeAmount;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_amount_text")
    private WebElement expenseAmount;

    @AndroidFindBy(id = "com.monefy.app.lite:id/balance_amount")
    private WebElement balanceAmount;

    @AndroidFindBy(id = "com.monefy.app.lite:id/expense_button")
    private WebElement expenseButton;

    @AndroidFindBy(id = "com.monefy.app.lite:id/income_button")
    private WebElement incomeButton;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getTitleTextElement() {
        return titleText;
    }

    public String getTitleText() {
        return getText(titleText);
    }

    public WebElement getAccountSelectorTextElement() {
        return accountSelectorText;
    }

    public String getAccountSelectorText() {
        return getText(accountSelectorText);
    }

    public WebElement getIncomeAmountElement() {
        return incomeAmount;
    }

    public String getIncomeAmount() {
        return getText(incomeAmount);
    }

    public WebElement getExpenseAmountElement() {
        return expenseAmount;
    }

    public String getExpenseAmount() {
        return getText(expenseAmount);
    }

    public WebElement getBalanceAmountElement() {
        return balanceAmount;
    }

    public String getBalanceAmount() {
        return getText(balanceAmount);
    }

    public WebElement getExpenseButton() {
        return expenseButton;
    }

    public boolean isExpenseButtonDisplayed() {
        return isDisplayed(expenseButton);
    }

    public WebElement getIncomeButton() {
        return incomeButton;
    }

    public boolean isIncomeButtonDisplayed() {
        return isDisplayed(incomeButton);
    }

    public void clickExpenseButton() {
        click(expenseButton);
    }

    protected boolean isDisplayed(WebElement element) {
        waitForVisibility(element);
        return element.isDisplayed();
    }
}