package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class Helper {
	
	Properties pro;
	
	public Helper() {
	File src=new File("./Config/TestData.PROPERTIES");
	try {
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		
	} 
	catch (Exception e) {
		System.out.println("Unable to read Excel file" +e.getMessage());
		
	}

  }
	public String getdatafromconfig(String key)
	{
		return pro.getProperty(key);
	}
}
