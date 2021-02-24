package com.pedigreeTest.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteData {

	public void putCellValue(String sheetName,String value) throws IOException {
		FileInputStream fi = new  FileInputStream(".\\Excel\\PedigreeData.xlsx");
		File f = new File(".\\Excel\\PedigreeData.xlsx");
		XSSFWorkbook workBook= new XSSFWorkbook(fi);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		sheet.createRow(1).createCell(1).setCellValue(value);
		
		FileOutputStream fo= new FileOutputStream(f);
		workBook.write(fo);
		
	}
	
}
