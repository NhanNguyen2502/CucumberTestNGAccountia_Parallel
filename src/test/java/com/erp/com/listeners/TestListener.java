package com.erp.com.listeners;

import erp.com.constants.ConstantGlobal;
import erp.com.helpers.CaptureHelper;
import erp.com.helpers.PropertiesHelper;
import erp.com.ulitilities.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        PropertiesHelper.loadAllFile();
        Log.info("Starting Suite: " + result.getStartDate());
        if (ConstantGlobal.RECORD_VIDEO.equals("yes")) {
            CaptureHelper.startRecord(result.getName());
        }
    }

    @Override
    public void onFinish(ITestContext result) {
        Log.info("Finish Suite: " + result.getEndDate());
        if (ConstantGlobal.RECORD_VIDEO.equals("yes")) {
            CaptureHelper.stopRecord();
        }
       // ExtentReportManager.getExtentReports().flush(); //Kết thúc và thực thi xuất report ra file
    }

    @Override
    public void onTestStart(ITestResult result) {
     //   ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (ConstantGlobal.SCREENSHOT_PASS.equals("yes")) {
            CaptureHelper.takeScreenshot(result.getName()); //Chụp màn hình khi Fail
        }

        Log.info(result.getName() + " is pass.");
       // ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        if (ConstantGlobal.SCREENSHOT_FAIL.equals("yes")) {
            CaptureHelper.takeScreenshot(result.getName()); //Chụp màn hình khi Fail
        }

        Log.error(result.getThrowable().toString());
        Log.error(result.getName() + " is fail.");

        //Extent Report
//        ExtentTestManager.addScreenShot(result.getName());
//        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
//        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");
//
//        //Allure Report
//        AllureManager.saveTextLog(result.getName() + " is failed.");
//        AllureManager.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (ConstantGlobal.SCREENSHOT_FAIL.equals("yes")) {
            CaptureHelper.takeScreenshot(result.getName()); //Chụp màn hình khi Skip
        }
        Log.warn(result.getName() + " is skipped.");
       // ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

}