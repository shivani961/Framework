package com.automation.testcases;

import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;


public class LoginTestHRM extends BaseClass{
  
  @Test(priority=1)
  public void loginApp() {
	  logger= report.createTest("Login to OrangeHRM");
	  LoginPage loginPage= new LoginPage(driver);
      logger.info("Starting Application");
	  loginPage.loginToHRM(excel.getStringData("Sheet1", 0, 0),excel.getStringData("Sheet1", 0, 1));
      logger.pass("Logging done Successfully");
  }
  
}
