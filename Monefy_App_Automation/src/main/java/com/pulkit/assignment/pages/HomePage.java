package com.pulkit.assignment.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Monefy')]")
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(titleText));
        return titleText;
    }

    public String getTitleText() {
        return getText(getTitleTextElement());
    }

    public WebElement getAccountSelectorTextElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(accountSelectorText));
        return accountSelectorText;
    }

    public String getAccountSelectorText() {
        return getText(getAccountSelectorTextElement());
    }

    public WebElement getIncomeAmountElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(incomeAmount));
        return incomeAmount;
    }

    public String getIncomeAmount() {
        return getText(getIncomeAmountElement());
    }

    public WebElement getExpenseAmountElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(expenseAmount));
        return expenseAmount;
    }

    public String getExpenseAmount() {
        return getText(getExpenseAmountElement());
    }

    public WebElement getBalanceAmountElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(balanceAmount));
        return balanceAmount;
    }

    public String getBalanceAmount() {
        return getText(getBalanceAmountElement());
    }

    public WebElement getExpenseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(expenseButton));
        return expenseButton;
    }

    public boolean isExpenseButtonDisplayed() {
        return isDisplayed(expenseButton);
    }

    public WebElement getIncomeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(incomeButton));
        return incomeButton;
    }

    public boolean isIncomeButtonDisplayed() {
        return isDisplayed(incomeButton);
    }

    public void clickExpenseButton() {
        click(getExpenseButton(), "Expense Button");
    }

    protected boolean isDisplayed(WebElement element) {
        waitForVisibility(element);
        return element.isDisplayed();
    }
}