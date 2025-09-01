package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public WebDriver driver;
	 public ExcelDataProvider excel;
	 public ConfigDataProvider config;
	 public ExtentReports report;
	 public ExtentTest logger;
	 //Before suite method
	 @BeforeSuite
	 public void setupSuite()
	 {
		 Reporter.log("Setting up reports and Test Started",true);
		 excel = new ExcelDataProvider();
		 config = new ConfigDataProvider();
		 ExtentSparkReporter extent = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/OrangeHRM"+Helper.getCurrentDateTime()+".html");
	     report = new ExtentReports();
	     report.attachReporter(extent);
	     Reporter.log("Setting Done- Test can be started",true);
	     
	 }
	  @BeforeClass
	  public void setup() {
		   
		  Reporter.log("Trying to start Browser and getting application ready",true);
		   driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStringURL());
		   
		   Reporter.log("Browser and Application is up and running",true);
	  }
	   @AfterClass
	  public void tearDown() {
		  BrowserFactory.quitBrowser(driver); 
		  
	  }
	  @AfterMethod
	  public void tearDownMethod(ITestResult result) 
	  {
		     Reporter.log("Test is about to end",true);
		  if(result.getStatus() == ITestResult.FAILURE)
		  {
			  
			  logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		  }
		  else if (result.getStatus()== ITestResult.SUCCESS) {
			  logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		  }
		
		  report.flush();
		     Reporter.log("Test Completed>>> Reports Generated",true);
		   
	  }

}
