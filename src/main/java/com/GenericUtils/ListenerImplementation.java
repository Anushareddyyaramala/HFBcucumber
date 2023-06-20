package com.GenericUtils;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import hooks.Baseclass;

public class ListenerImplementation implements ITestListener	{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
	
		
		String methodName = result.getMethod().getMethodName();//reflection API
		test = report.createTest(methodName); // test is created which will initialize the individual test execution
		test.log(com.aventstack.extentreports.Status.PASS, methodName);
		Reporter.log(methodName+" => test script execution started",true);
	
	}

	public void onTestSuccess(ITestResult result) {
	
		String methodName = result.getMethod().getMethodName();
		test.log(com.aventstack.extentreports.Status.PASS, "Test passed");
		test.log(com.aventstack.extentreports.Status.INFO, "Test on success");
		
		Reporter.log(methodName+" => is Passed",true);
		
	
	}

	public void onTestFailure(ITestResult result) {
		
		WebdriverUtility wLib = new WebdriverUtility();
		JavaUtility jLib = new JavaUtility();
	
		String methodName = result.getMethod().getMethodName();//reflection api
		String screenShotName = methodName+"-"+jLib.getSystemDateInFormat();
		test.log(com.aventstack.extentreports.Status.FAIL, methodName+ "---> Failed");
		test.log(com.aventstack.extentreports.Status.INFO, "Test Failed");
		test.log(com.aventstack.extentreports.Status.FAIL, result.getThrowable());
		try {
			String path = wLib.takeScreenShot(Baseclass.driver, screenShotName);
			
			test.addScreenCaptureFromPath(path); //Navigate to screenshot path and attach it to the report
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result, String msg) {
		
		
		//String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		test.log(com.aventstack.extentreports.Status.SKIP, methodName +" ---> Skipped");
		test.log(com.aventstack.extentreports.Status.INFO, "test information on skip");
		
		test.log(com.aventstack.extentreports.Status.SKIP, result.getThrowable());
		
		Reporter.log(methodName+" => is skipped because => "+msg,true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		//Start of suite execution
		/*Configure the extent reports*/   
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("project execution report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("orangehrm Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Edge");
		report.setSystemInfo("Base-platform", "Windows");
		report.setSystemInfo("Base-URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "HugsForBugs-A2");
		
	}

	public void onFinish(ITestContext context) {
		
		//End of Suite execution
		
		report.flush(); // consolidate all the test script execution and dump the status into report
		
	}
}
