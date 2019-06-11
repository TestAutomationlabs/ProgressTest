package com.qa.TestDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityForAll {


	public static String getCellData(String sheetname, int rowno, int cellno) throws IOException
	{

		File src= new File( ".\\src\\main\\java\\com\\qa\\TestData\\testData.xlsx");
		FileInputStream file=new FileInputStream(src);
		XSSFWorkbook work=new XSSFWorkbook(file);
		XSSFSheet sheet1=work.getSheet(sheetname);
		XSSFRow row=sheet1.getRow(rowno);
		XSSFCell cell=row.getCell(cellno);
		System.out.println("cell is"+cell);
	
		/*if(cell==null)
		{
			System.out.println("Cell value is blank");
			System.out.println("cell value is"+cell);
			return "";
		}*/
		
		if(cell.getCellType()==cell.CELL_TYPE_STRING)
{
	// " "-> Denotes single space, ""->Denotes blank space
		String cellvalue = "" + cell.getStringCellValue();
		cellvalue=cellvalue.trim();
		System.out.println("cell value of string is "+cellvalue);
		return cell.getStringCellValue();
		
	}
else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
{
	String cellvalue=" " + cell.getNumericCellValue();
	cellvalue=cellvalue.trim();
	System.out.println("cell value of numeric is "+cellvalue);
	return cellvalue;
	
}
		
		if(cell.getCellType()==cell.CELL_TYPE_BLANK)
			{
				System.out.println("Cell value is blank");
				System.out.println("cell value is"+cell);
				return "";
			}




return sheetname;
	}
	
	
	public static void main(String[] args) throws IOException {
		getCellData("Registration", 2, 0);
	}

}