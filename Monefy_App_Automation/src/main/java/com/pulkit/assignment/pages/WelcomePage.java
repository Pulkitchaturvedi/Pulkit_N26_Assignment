package com.pulkit.assignment.pages;

import com.pulkit.assignment.base.BasePage;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;

public class WelcomePage extends BasePage {
    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonContinue") private WebElement continueButton;
    @AndroidFindBy(id = "com.monefy.app.lite:id/buttonClose") private WebElement closeOffer;

    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }

    public WelcomePage clickGetStartedButton(){
        click(continueButton,"Get Started Button");
        return this;
    }

    public WelcomePage clickAmazingButton(){
        click(continueButton,"Amazing Button");
        return this;
    }

    public WelcomePage clickIAmReadyButton(){
        click(continueButton,"I am Ready Button");
        return this;
    }

    public WelcomePage yesPleaseButton(){
        click(continueButton,"Yes Please");
        return this;
    }

    public HomePage closeOfferButton(){
        click(closeOffer,"Close Offer Button");
        return new HomePage(driver);
    }

    /**
     * Checks if the continue button is displayed
     * @return true if the continue button is displayed, false otherwise
     */
    public boolean isContinueButtonDisplayed() {
        try {
            waitForVisibility(continueButton);
            return continueButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}