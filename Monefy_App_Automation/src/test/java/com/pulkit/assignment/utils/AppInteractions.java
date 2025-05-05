
package com.pulkit.assignment.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;

/**
 * Utility class for common app interactions
 */
public class AppInteractions {

    private static AppiumDriver driver;
    private static final String APP_PACKAGE = "com.monefy.app.lite";

    /**
     * Sets the AppiumDriver instance
     * @param appiumDriver the driver instance
     */
    public static void setDriver(AppiumDriver appiumDriver) {
        driver = appiumDriver;
    }

    /**
     * Launches the application
     */
    public static void launchApp() {
        if (driver != null) {
            if (driver instanceof InteractsWithApps) {
                ((InteractsWithApps) driver).activateApp(APP_PACKAGE);
                System.out.println("App launched successfully");
            } else {
                System.err.println("Driver does not support app interactions");
            }
        } else {
            System.err.println("Driver is not initialized. Cannot launch app.");
        }
    }

    /**
     * Closes the application
     */
    public static void closeApp() {
        if (driver != null) {
            try {
                if (driver instanceof InteractsWithApps) {
                    ((InteractsWithApps) driver).terminateApp(APP_PACKAGE);
                    System.out.println("App closed successfully");
                } else {
                    System.err.println("Driver does not support app interactions");
                }
            } catch (Exception e) {
                System.out.println("App was not running or could not be closed: " + e.getMessage());
            }
        } else {
            System.err.println("Driver is not initialized. Cannot close app.");
        }
    }

    /**
     * Resets the application state by closing and reopening it
     */
    public static void resetApp() {
        if (driver != null) {
            try {
                if (driver instanceof InteractsWithApps) {
                    InteractsWithApps interactsWithApps = (InteractsWithApps) driver;
                    // First terminate the app
                    interactsWithApps.terminateApp(APP_PACKAGE);
                    // Then activate it again
                    interactsWithApps.activateApp(APP_PACKAGE);
                    System.out.println("App reset successfully");
                } else {
                    System.err.println("Driver does not support app interactions");
                }
            } catch (Exception e) {
                System.err.println("Failed to reset app: " + e.getMessage());
            }
        } else {
            System.err.println("Driver is not initialized. Cannot reset app.");
        }
    }
}