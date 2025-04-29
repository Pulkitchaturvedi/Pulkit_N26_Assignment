package com.pulkit.assignment.tests;

import com.pulkit.assignment.base.BaseTest;
import com.pulkit.assignment.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeScreenTests extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void initializePageObjects() {
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void validateTitleText() {
        String actualTitle = homePage.getTitleText();
        String expectedTitle = "Monefy";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
    }

    @Test(priority=2)
    public void validateAccountSelectorText() {
        String actualAccountSelector = homePage.getAccountSelectorText();
        Assert.assertEquals(actualAccountSelector, "All accounts", "Account Selector text is incorrect!");
    }

    @Test(priority=3)
    public void validateAmountsDisplayed() {
        System.out.println("Income Amount: " + homePage.getIncomeAmount());
        System.out.println("Expense Amount: " + homePage.getExpenseAmount());
        System.out.println("Balance Amount: " + homePage.getBalanceAmount());
    }

    @Test(priority = 4)
    public void validateIncomeAndExpenseButtonsDisplayed() {
        Assert.assertTrue(homePage.isIncomeButtonDisplayed(), "Income button is not visible on Home screen!");
        Assert.assertTrue(homePage.isExpenseButtonDisplayed(), "Expense button is not visible on Home screen!");
    }

    @Test(priority = 5, description = "Validate Back Navigation returns to Home Screen")
    public void validateBackNavigation() {
        homePage.clickExpenseButton();
        homePage.navigateBack();
        Assert.assertTrue(homePage.isExpenseButtonDisplayed(), "Back navigation failed - Expense Button not visible!");
    }
}
