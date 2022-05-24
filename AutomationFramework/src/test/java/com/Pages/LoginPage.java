package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	 public LoginPage(WebDriver ldriver)
	 {
		 this.driver=ldriver;
	 }
	 @FindBy(xpath="")WebElement uname;
	 @FindBy(xpath="")WebElement upass;
	 @FindBy(xpath="")WebElement login;
	 
	 public void logintoCRM(String username,String password)
	 {
		 uname.sendKeys(username);
		 upass.sendKeys(password);
		 login.click();
	 }

}
