package com.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BroswerFactory {
	
	

	public static WebDriver StartApplication(WebDriver ldriver,String broswername,String url)
	{
		if (broswername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\\\BeatBlip\\\\chromedriver.exe");
		   ldriver = new ChromeDriver();
		  
		}
		else if (broswername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\\\BeatBlip\\\\iedriver.exe");
		  // ldriver = new EdgeDriver();
		  
		}
		 ldriver.get(url);
		
		 ldriver.manage().window().maximize();
		
		   ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        ldriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
	        ldriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	        return ldriver;
		 
	}

   public static void closeapp(WebDriver ldriver)
   {
	   ldriver.close();
	   
   }

}
