package com.qa.TestDataDriven;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.format.CellTextFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRevertMultiple {
	
	public static String getCellData(String sheetname, int rowno, int cellno) throws IOException
	{
		File src= new File(".\\src\\main\\java\\com\\qa\\TestData\\testData.xlsx");
		FileInputStream file=new FileInputStream(src);
		XSSFWorkbook work=new XSSFWorkbook(file);
		XSSFSheet sheet1=work.getSheet(sheetname);
		int rowcount=sheet1.getLastRowNum();
	
		System.out.println("Total rows"+rowcount);
		try {
		for(int i=0; i<=rowcount; i++)
		{
			
			Row row=sheet1.getRow(i);
			Cell cell=row.getCell(cellno);
			if(cell==null)
			{
				System.out.println("cell is"+cell);
				System.out.println("cell is blank");
				i++;
			}
			else if(cell!=null && cell.getCellType()==cell.CELL_TYPE_STRING)
			{
					String data=sheet1.getRow(i).getCell(0).getStringCellValue();
					System.out.println("Testdata of string value from excel is "+data);
					System.out.println();
				
				
				
				
			}
			
			
			else if(cell!=null && cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			{
				//String cellvalue=" " + cell.getNumericCellValue();
				double data=sheet1.getRow(i).getCell(0).getNumericCellValue();
				System.out.println("Testdata of numeric value from excel is "+data);
				System.out.println();
			}
		
				
			
		
	}
		}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
		return sheetname;
	}
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		{
		
			getCellData("Registration",0,0);
		

	}

}
}
