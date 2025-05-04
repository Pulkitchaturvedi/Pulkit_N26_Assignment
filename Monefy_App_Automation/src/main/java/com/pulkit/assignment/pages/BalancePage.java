package com.pulkit.assignment.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BalancePage extends BasePage {
    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewCategoryName")
    private WebElement transactionCategoryLabel;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewWholeAmount")
    private WebElement transactionAmountLabel;

    @AndroidFindBy(id = "com.monefy.app.lite:id/transaction_group_header")
    private WebElement transactionGroupHeader;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewTransactionDate")
    private WebElement transactionDateLabel;

    public BalancePage(AppiumDriver driver) {
        super(driver);
    }

    public String getTransactionCategoryText() {
        return getText(transactionCategoryLabel);
    }

    public String getTransactionAmountText() {
        return getText(transactionAmountLabel);
    }

    public BalancePage tapOnTransactionGroupHeader() {
        click(transactionGroupHeader,"Transaction Group Header");
        return this;
    }

    public EditIncomePage tapOnTransactionDetailToEditIncome() {
        click(transactionDateLabel,"Transaction Detail to Edit Income");
        return new EditIncomePage(driver);
    }
}