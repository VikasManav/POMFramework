package com.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Pages.BaseClass;
import com.Pages.LoginPage;
import com.utilities.ExcelDataProvider;


public class LoginTestCase extends BaseClass {
	
	
		@Test
		public void login()
		{
			logger=extReport.createTest("Login Test1233");
			LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);
			logger.info("Start TestCase");
			
			loginpage.logintoCRM(exceldatap.getStringValue("sheet1", "0", "0"),exceldatap.getStringValue("sheet1", "0", "1"));
			
			logger.pass("Login Sucessfully");
			
		}

}
