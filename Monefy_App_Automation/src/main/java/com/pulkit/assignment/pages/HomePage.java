package com.pulkit.assignment.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import com.pulkit.assignment.base.BasePage;

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

    @AndroidFindBy(id = "com.monefy.app.lite:id/balance_container")
    private WebElement balanceButton;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return getText(titleText);
    }

    public String getAccountSelectorText() {
        return getText(accountSelectorText);
    }

    public String getIncomeAmount() {
        return getText(incomeAmount);
    }

    public String getExpenseAmount() {
        return getText(expenseAmount);
    }

    public String getBalanceAmount() {
        return getText(balanceAmount);
    }

    public NewExpensePage clickExpenseButton() {
        click(expenseButton, "Expense Button");
        return new NewExpensePage(driver);
    }

    public NewIncomePage clickIncomeButton() {
        click(incomeButton, "Income Button");
        return new NewIncomePage(driver);
    }

    public BalancePage clickBalanceButton() {
        click(balanceButton, "Balance Button");
        return new BalancePage(driver);
    }

    /**
     * Checks if the income button is displayed
     * @return true if the income button is displayed, false otherwise
     */
    public boolean isIncomeButtonDisplayed() {
        try {
            waitForVisibility(incomeButton);
            return incomeButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the expense button is displayed
     * @return true if the expense button is displayed, false otherwise
     */
    public boolean isExpenseButtonDisplayed() {
        try {
            waitForVisibility(expenseButton);
            return expenseButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}