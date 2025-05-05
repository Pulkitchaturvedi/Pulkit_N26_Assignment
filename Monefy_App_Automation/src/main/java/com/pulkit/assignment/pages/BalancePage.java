
package com.pulkit.assignment.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import com.pulkit.assignment.base.BasePage;

public class BalancePage extends BasePage {
    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewCategoryName")
    private WebElement transactionCategoryLabel;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewWholeAmount")
    private WebElement transactionAmountLabel;

    @AndroidFindBy(id = "com.monefy.app.lite:id/transaction_group_header")
    private WebElement transactionGroupHeader;

    @AndroidFindBy(id = "com.monefy.app.lite:id/textViewTransactionDate")
    private WebElement transactionDateLabel;

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement backButton;

    public BalancePage(AppiumDriver driver) {
        super(driver);
    }

    public String getFirstEntryCategory() {
        return getText(transactionCategoryLabel);
    }

    public String getFirstEntryAmount() {
        return getText(transactionAmountLabel);
    }

    public BalancePage tapOnTransactionGroupHeader() {
        click(transactionGroupHeader, "Transaction Group Header");
        return this;
    }

    public HomePage navigateBack() {
        click(backButton, "Back Button");
        return new HomePage(driver);
    }
}