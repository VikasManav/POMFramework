package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook ws;
	
	public ExcelDataProvider()
	{
		File src=new File("./TestData/testdatafile.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			ws=new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			System.out.println("Unable to read Excel file" +e.getMessage());
			
		}
	}
	public String getStringValue(String sheetname,String row,String column)
	{
		return ws.getSheet(sheetname).getRow(0).getCell(0).getStringCellValue();
	}
	public double getNumricValue(String sheetname,String row,String column)
	{
		return ws.getSheet(sheetname).getRow(0).getCell(0).getNumericCellValue();
	}
	
	public String getStringValue(int sheetindex,String row,String column)
	{
		return ws.getSheetAt(sheetindex).getRow(0).getCell(0).getStringCellValue();
	}

}
