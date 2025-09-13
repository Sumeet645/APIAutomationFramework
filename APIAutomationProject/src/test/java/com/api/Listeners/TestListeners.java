package com.api.Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.api.reporting.ExtentReportManager;

public class TestListeners implements ITestListener{
	
	private final static Logger logger=LogManager.getLogger(TestListeners.class);
	
	 public void onTestStart(ITestResult result) {
		 	String testName = result.getMethod().getMethodName();
	        ExtentReportManager.startTest(testName);
	        logger.info("Test Started: {}", result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        logger.info("Test Passed: {}", result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        logger.error("Test Failed: {}", result.getName());
	        logger.error("Exception: ", result.getThrowable());
	    }
	    
	    @Override
	    public void onFinish(ITestContext context) {
	        ExtentReportManager.endTest();
	    }

}
