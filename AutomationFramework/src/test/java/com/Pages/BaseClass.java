package com.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.BroswerFactory;
import com.utilities.CustomLib;
import com.utilities.ExcelDataProvider;
import com.utilities.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider exceldatap;
	Helper helper;
	CustomLib lib;
	public ExtentReports extReport;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpsuit()
	{
		Reporter.log("Setting up all reports and test is ready ",true);
		exceldatap=new ExcelDataProvider();
		helper=new Helper();
		lib=new CustomLib();
		ExtentSparkReporter spark = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/report.html"));
		extReport=new ExtentReports();
		extReport.attachReporter(spark);
		
		Reporter.log("Setting Done--Test case is ready to run",true);
	}
	
    @BeforeClass
	public void startbroswer()
	{
    	Reporter.log("Broswer is ready to up ",true);
		driver=BroswerFactory.StartApplication(driver,helper.getdatafromconfig("Chrome"),helper.getdatafromconfig("getsiteurl"));
		Reporter.log("Broswer up sucessfully ",true);
	}
  @AfterClass
	public void closebroswer()
	{
		BroswerFactory.closeapp(driver);
	}
  
  
@SuppressWarnings("static-access")
public void getscreenshots(ITestResult result)
  {
	  if (result.getStatus()==result.FAILURE)
	  {
		  lib.capturedscreenshots(driver);
		  logger.fail("fail",MediaEntityBuilder.createScreenCaptureFromPath(lib.capturedscreenshots(driver)).build());
	  }
	  if (result.getStatus()==result.SUCCESS)
	  {
		  lib.capturedscreenshots(driver);
		  logger.pass("Pass",MediaEntityBuilder.createScreenCaptureFromPath(lib.capturedscreenshots(driver)).build());
	  }
	  extReport.flush();
  
}}
