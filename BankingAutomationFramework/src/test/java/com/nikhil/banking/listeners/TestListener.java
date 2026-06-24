package com.nikhil.banking.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.nikhil.banking.reports.ExtentManager;
import com.nikhil.banking.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
public void onTestFailure(ITestResult result) {

    if (test == null) {
        test = extent.createTest(result.getName());
    }

    test.fail(result.getThrowable());

    String screenshotPath =
            ScreenshotUtils.captureScreenshotForReport(
                    result.getName());

    try {
        test.addScreenCaptureFromPath(screenshotPath);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}