package com.qa.TestDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	public static String PassedCreateCellData(String sheetname, int rowno, int cellno) throws IOException
	{
	File src= new File( ".\\src\\main\\java\\com\\qa\\TestData\\testData.xlsx");
	FileInputStream file=new FileInputStream(src);
	XSSFWorkbook work=new XSSFWorkbook(file);
	XSSFSheet sheet1=work.getSheet(sheetname);
	XSSFRow row=sheet1.createRow(rowno);
	XSSFCell cell=row.createCell(cellno);
	cell.setCellType(cell.CELL_TYPE_STRING);
	cell.setCellValue("pass");
	FileOutputStream output=new FileOutputStream(src);
	work.write(output);
	return sheetname;

}

	public static String FailedCreateCellData(String sheetname, int rowno, int cellno) throws IOException
	{
	File srcs= new File( ".\\src\\main\\java\\com\\qa\\TestData\\testData.xlsx");
	FileInputStream files=new FileInputStream(srcs);
	XSSFWorkbook work=new XSSFWorkbook(files);
	XSSFSheet sheet2=work.getSheet(sheetname);
	XSSFRow rows=sheet2.createRow(rowno);
	XSSFCell cells=rows.createCell(cellno);
	cells.setCellType(cells.CELL_TYPE_STRING);
	cells.setCellValue("fail");
	FileOutputStream outputs=new FileOutputStream(srcs);
	work.write(outputs);
	return sheetname;

}

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		
//		CreateCellData("TimeLine", 1, 2);
//		System.out.println("write is complted");
//
//}
}