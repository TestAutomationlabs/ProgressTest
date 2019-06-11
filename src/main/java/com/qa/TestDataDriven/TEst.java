package com.qa.TestDataDriven;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TEst {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	
	public static String getExcelData() throws EncryptedDocumentException, InvalidFormatException
	{
	String str = null;
try 
{
	
	File src= new File(".\\src\\main\\java\\com\\qa\\TestData\\testData.xlsx");
	FileInputStream file=new FileInputStream(src);
	XSSFWorkbook work=new XSSFWorkbook(file);
	//XSSFSheet sheet1=work.getSheetAt(0);
	XSSFSheet st=work.getSheet("Registration");
	int rowno=st.getLastRowNum();

//String str="";


for(int i=0; i<rowno; i++)
{
	Row r=st.getRow(i);
	
	int cellno=r.getLastCellNum();
	
	for( int j=0; j<cellno; j++)
	{
		Cell c=r.getCell(j);
		String str1 = c.getStringCellValue();
		System.out.println(str1);
		
		
	}
}
}
catch (FileNotFoundException e) 
{
e.printStackTrace();
}
catch (IOException e1)
{
e1.printStackTrace();
}
catch (NullPointerException e2)
{
	e2.printStackTrace();
}
return str;
}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, NullPointerException {
		// TODO Auto-generated method stub
		getExcelData();
	}
}

