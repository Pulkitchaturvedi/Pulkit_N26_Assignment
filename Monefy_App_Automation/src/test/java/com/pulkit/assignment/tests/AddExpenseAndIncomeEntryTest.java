package com.pulkit.assignment.tests;

import com.pulkit.assignment.base.BaseTest;
import com.pulkit.assignment.pages.BalancePage;
import com.pulkit.assignment.pages.WelcomePage;
import com.pulkit.assignment.pages.HomePage;
import com.pulkit.assignment.pages.NewExpensePage;
import com.pulkit.assignment.pages.NewIncomePage;
import com.pulkit.assignment.utils.AppInteractions;
import com.pulkit.assignment.utils.ReportManager;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/*
 * Test Scenario:
 * 1. Launch the app and skip the welcome tour
 * 2. Add an expense entry
 * 3. Validate that the expense shows in the Balance page
 * 4. Add an income entry
 * 5. Validate that the income shows in the Balance page
 */

public class AddExpenseAndIncomeEntryTest extends BaseTest {

    private WelcomePage welcomePage;
    private HomePage homePage;
    private BalancePage balancePage;
    private NewExpensePage newExpensePage;
    private NewIncomePage newIncomePage;

    @BeforeClass(dependsOnMethods = "setUp")
    public void initTest() {
        ReportManager.info("Setting up test environment");
        AppInteractions.setDriver(driver);
        AppInteractions.closeApp();
        AppInteractions.launchApp();
        System.out.println("App launched fresh for testing");
    }

    @BeforeMethod
    public void initPages() {
        ReportManager.info("Initializing page objects");
        welcomePage = new WelcomePage(driver);
        homePage = new HomePage(driver);
        balancePage = new BalancePage(driver);
        newExpensePage = new NewExpensePage(driver);
        newIncomePage = new NewIncomePage(driver);
    }

    @Test(priority = 0, description = "Skip welcome tour screens")
    public void skipWelcomeTour() {
        ReportManager.info("Starting test: skipWelcomeTour");
        ReportManager.info("Current screen: " + driver.currentActivity());

        if (welcomePage.isContinueButtonDisplayed()) {
            welcomePage.clickGetStartedButton()
                    .clickAmazingButton()
                    .yesPleaseButton()
                    .clickIAmReadyButton()
                    .closeOfferButton();
            ReportManager.info("Successfully completed welcome tour");
        } else {
            System.err.println("Continue button not found! Current page source: " + driver.getPageSource());
            Assert.fail("Failed to find the Continue button on welcome screen");
        }
    }

    @Test(priority = 1, description = "Verify app title is displayed correctly")
    public void verifyAppTitle() {
        // Skip welcome screens if needed
        if (welcomePage.isContinueButtonDisplayed()) {
            welcomePage.clickGetStartedButton()
                    .clickAmazingButton()
                    .clickIAmReadyButton()
                    .closeOfferButton();
        }

        // Verify the app title
        String title = homePage.getTitleText();
        Assert.assertTrue(title.contains("Monefy"), "App title does not contain 'Monefy'");
        ReportManager.info("Validated Monefy App title");
    }

    @Test(priority = 2, description = "Add an expense entry and verify it's saved")
    public void addExpenseEntry() {
        ReportManager.info("Starting test: addExpenseEntry");
        String categoryExpected = "Food";
        String amountExpected = "£21.00";

        ReportManager.step("Adding a new expense entry");

        homePage.clickExpenseButton();
        ReportManager.step("Entering expense amount and category");

        newExpensePage.clickAmountTextBox()
                .clickKeyboardButton("2")
                .clickKeyboardButton("1")
                .clickExpenseCategory()
                .clickFoodCategory();

        ReportManager.step("Navigating to balance page to verify entry");
        balancePage = homePage.clickBalanceButton();

        ReportManager.step("Validating expense entry details");
        String actualCategory = balancePage.getFirstEntryCategory();
        String actualAmount = balancePage.getFirstEntryAmount();


        ReportManager.info("Expected category: " + categoryExpected + ", Actual: " + actualCategory);
        ReportManager.info("Expected amount: " + amountExpected + ", Actual: " + actualAmount);

        Assert.assertEquals(balancePage.getFirstEntryCategory(), categoryExpected, "Expense category doesn't match");
        Assert.assertEquals(balancePage.getFirstEntryAmount(), amountExpected, "Expense amount doesn't match");

        try {
            ReportManager.step("Navigating back to home screen");
            balancePage.navigateBack();
        } catch (Exception ex) {
            ReportManager.warning("Standard navigation failed, using Android back key");
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        }
        ReportManager.info("Expense entry verification successful");
    }

    @Test(priority = 3, description = "Add an income entry and verify it's saved")
    public void addIncomeEntry() {
        String categoryExpected = "Salary";
        String amountExpected = "£23.00";

        System.out.println("Adding a new income entry...");

        homePage.clickIncomeButton();
        newIncomePage.clickAmountTextBox()
                .clickKeyboardButton("2")
                .clickKeyboardButton("3")
                .clickIncomeCategory()
                .clickSalaryCategory();

        balancePage = homePage.clickBalanceButton();

        System.out.println("Validating income entry...");
        Assert.assertEquals(balancePage.getFirstEntryCategory(), categoryExpected, "Income category doesn't match");
        Assert.assertEquals(balancePage.getFirstEntryAmount(), amountExpected, "Income amount doesn't match");
    }
}
