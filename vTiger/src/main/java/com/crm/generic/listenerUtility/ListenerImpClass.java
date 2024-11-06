package com.crm.generic.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.webdriverUtility.UtilityClassObject;

/**
 * Provides implementation for ITestListener Interface's default methods and
 * ISuiteListener Interface's abstract methods.
 * 
 * @author Rajani
 *
 */
public class ListenerImpClass implements ITestListener, ISuiteListener {

	ExtentSparkReporter spark;
	ExtentReports report;
	public static ExtentTest test;

	/* ISuiteListener methods implementation */
	@Override
	public void onStart(ISuite suiteInfo) {
		System.out.println("report configuration");
		// configure the report
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.STANDARD);

		// add environment info
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-128");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		report.flush();
	}

	// ITestListener methods implementation

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = report.createTest(result.getMethod().getMethodName());

		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + " ---> STARTED");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + " ---> FAILED");
		test.log(Status.FAIL, result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.INFO, result.getMethod().getMethodName() + " ---> SKIPPED");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, result.getMethod().getMethodName() + " ---> SUCCESS");
	}

}
