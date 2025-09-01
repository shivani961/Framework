package com.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   WebDriver driver;
   public LoginPage(WebDriver ldriver) {
	   this.driver = ldriver;
	   PageFactory.initElements(ldriver, this);
   }
   @FindBy(xpath= "//input[@name='username']") WebElement uname;
   @FindBy(xpath= "//input[@name='password']") WebElement pass;
   @FindBy(xpath ="//button[@type='submit']") WebElement loginButton;
   
   
   public void loginToHRM(String usernameApp, String passwordApp)
   {
	   try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   uname.sendKeys(usernameApp);
	   pass.sendKeys(passwordApp);
	   loginButton.click();
   }
}
