package com.pedigreeTest.Pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static String getCellValue(String sheetName,int rowNum,int cellNum) throws IOException {
		String cellValue;
		
		FileInputStream fp= new FileInputStream(".\\Excel\\PedigreeData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fp);
		XSSFSheet sheet= workBook.getSheet(sheetName);
		XSSFRow row= sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(cellNum);
		cellValue= cell.getStringCellValue();
		return cellValue;
	
	}
	
}
