package com.pulkit.assignment.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pulkit.assignment.base.BaseTest;
import com.pulkit.assignment.pages.HomePage;
import com.pulkit.assignment.utils.ExtentReportManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomeScreenTests extends BaseTest {

    private HomePage homePage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getInstance();
    }

    @BeforeClass
    public void initializePageObjects() {
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void validateTitleText() {
        test = extent.createTest("Validate Title Text");
        try {
            String actualTitle = homePage.getTitleText();
            test.log(Status.INFO, "Fetched title: " + actualTitle);

            Assert.assertEquals(actualTitle, "Monefy", "Title does not match 'Monefy'");
            test.log(Status.PASS, "Title matched 'Monefy'");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Title validation failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.log(Status.FAIL, "Test encountered exception: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 2)
    public void validateAccountSelectorText() {
        test = extent.createTest("Validate Account Selector Text");
        try {
            String actualAccountSelector = homePage.getAccountSelectorText();
            test.log(Status.INFO, "Fetched account selector: " + actualAccountSelector);

            Assert.assertEquals(actualAccountSelector, "All accounts", "Account Selector text is incorrect!");
            test.log(Status.PASS, "Account Selector text matched 'All accounts'");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Account Selector validation failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.log(Status.FAIL, "Test encountered exception: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3)
    public void validateAmountsDisplayed() {
        test = extent.createTest("Validate Amounts Displayed");
        try {
            String incomeAmount = homePage.getIncomeAmount();
            String expenseAmount = homePage.getExpenseAmount();
            String balanceAmount = homePage.getBalanceAmount();

            test.log(Status.INFO, "Income Amount: " + incomeAmount);
            test.log(Status.INFO, "Expense Amount: " + expenseAmount);
            test.log(Status.INFO, "Balance Amount: " + balanceAmount);

            test.log(Status.PASS, "Amounts displayed successfully");
        } catch (Exception e) {
            test.log(Status.FAIL, "Test encountered exception: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4)
    public void validateIncomeAndExpenseButtonsDisplayed() {
        test = extent.createTest("Validate Income and Expense Buttons Displayed");
        try {
            boolean incomeVisible = homePage.isIncomeButtonDisplayed();
            boolean expenseVisible = homePage.isExpenseButtonDisplayed();

            test.log(Status.INFO, "Income Button Visible: " + incomeVisible);
            test.log(Status.INFO, "Expense Button Visible: " + expenseVisible);

            Assert.assertTrue(incomeVisible, "Income button is not visible on Home screen!");
            Assert.assertTrue(expenseVisible, "Expense button is not visible on Home screen!");

            test.log(Status.PASS, "Both Income and Expense buttons are visible");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Button visibility validation failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.log(Status.FAIL, "Test encountered exception: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 5, description = "Validate Back Navigation returns to Home Screen")
    public void validateBackNavigation() {
        test = extent.createTest("Validate Back Navigation");
        try {
            homePage.clickExpenseButton();
            test.log(Status.INFO, "Clicked Expense Button");

            driver.navigate().back();
            test.log(Status.INFO, "Pressed back button");

            WebElement title = homePage.getTitleTextElement();
            boolean expenseVisible = homePage.isExpenseButtonDisplayed();

            test.log(Status.INFO, "Expense button visible after back: " + expenseVisible);

            Assert.assertTrue(expenseVisible, "Back navigation failed - Expense Button not visible!");
            test.log(Status.PASS, "Back navigation successful - Expense Button visible");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Back Navigation validation failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.log(Status.FAIL, "Test encountered exception: " + e.getMessage());
            throw e;
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}
