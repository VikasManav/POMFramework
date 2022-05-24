package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CustomLib {
	
	//screeshot, iframe,alert,multiple windows,sync issue,javascript file handle
	
	public String capturedscreenshots(WebDriver driver)
	{
		String screenshoppath=System.getProperty("user.dir")+"./Screenshots/"+getCurrentDate()+".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshotFile,new File(screenshoppath));
		} catch (Exception e) {
			System.out.println("Enable to capture the screenshots" + e.getMessage());			
		}
		return screenshoppath;
	}
	
	public String getCurrentDate()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currentdate=new Date();
		return customFormat.format(currentdate);
	}
	
	public void iframe()
	{
		
	}
	public void alerts()
	{
		
	}

}
