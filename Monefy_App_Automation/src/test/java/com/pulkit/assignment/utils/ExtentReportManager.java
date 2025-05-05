package com.pulkit.assignment.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance("test-output/extent-report.html");
        }
        return extent;
    }

    private static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

        // Create report output directory if it doesn't exist
        File reportDir = new File("test-output");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // Configuration
        htmlReporter.config().setDocumentTitle("Monefy App Automation Report");
        htmlReporter.config().setReportName("Test Execution Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Set environment information
        extent.setSystemInfo("QA", System.getProperty("Pulkit Chaturvedi"));
        extent.setSystemInfo("App", "Monefy");
        extent.setSystemInfo("Platform", "Android");

        return extent;
    }
}