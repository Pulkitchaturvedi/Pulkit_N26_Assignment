package com.pulkit.assignment.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReportManager {
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void info(String message) {
        if (extentTest.get() != null) {
            extentTest.get().log(Status.INFO, message);
        }
        System.out.println("[INFO] " + message);
    }

    public static void warning(String message) {
        if (extentTest.get() != null) {
            extentTest.get().log(Status.WARNING, message);
        }
        System.out.println("[WARNING] " + message);
    }

    public static void step(String message) {
        if (extentTest.get() != null) {
            extentTest.get().log(Status.INFO, "STEP: " + message);
        }
        System.out.println("[STEP] " + message);
    }

    public static void fail(String message) {
        if (extentTest.get() != null) {
            extentTest.get().log(Status.FAIL, message);
        }
        System.err.println("[FAIL] " + message);
    }

    public static void pass(String message) {
        if (extentTest.get() != null) {
            extentTest.get().log(Status.PASS, message);
        }
        System.out.println("[PASS] " + message);
    }
}