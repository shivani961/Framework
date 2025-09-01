package com.automation.utility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
  
     public static WebDriver startApplication(WebDriver driver,String browsername,String appURL)
     {
    	 if(browsername.equals("Chrome"))
    	 {
    		 driver = new ChromeDriver();
    		
    		 
    	 }
    	 else if(browsername.equals("Firefox"))
    	 {
    		 driver = new FirefoxDriver();
    		 
    	 }
    	 else if(browsername.equals("IE")) {
    		 driver = new InternetExplorerDriver();
    	 }
    	 else {
    		 System.out.println("We do not support this browser");
    	 }
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	 driver.manage().window().maximize();
    	 driver.get(appURL);
    	 return driver;
    	 
     }
     
     public static void quitBrowser(WebDriver driver)
     {
    	 driver.quit();
     }
}
