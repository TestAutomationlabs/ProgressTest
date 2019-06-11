package com.qa.TestDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	

	public static String getCellData(String sheetname, int rowno, int cellno) throws IOException
	{
		File src= new File( ".\\src\\main\\java\\com\\qa\\TestData\\testData.xlsx");
		FileInputStream file=new FileInputStream(src);
		XSSFWorkbook work=new XSSFWorkbook(file);
		XSSFSheet sheet1=work.getSheet(sheetname);
		XSSFRow row=sheet1.getRow(rowno);
		XSSFCell cell=row.getCell(cellno);
		
		
	
	String data=cell.getStringCellValue();
	String c = data.toString();
	
	if (c != null && c.toString().length() > 0 )
	{
		data = c.toString();
	}
else
{
	data = "  ";
}
	
	System.out.println(" Data from excel " +data);
	return data;
	}
	
	
}