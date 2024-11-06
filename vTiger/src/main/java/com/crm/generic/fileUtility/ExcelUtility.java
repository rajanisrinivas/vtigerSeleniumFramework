package com.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rowNo, int cellNo) throws Throwable {

		FileInputStream fisE = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNo);
		String value = row.getCell(cellNo).getStringCellValue();
		wb.close();

		return value;
	}

	public int getRowCount(String sheetName) throws Throwable, IOException {

		FileInputStream fisE = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		int count = wb.getSheet(sheetName).getLastRowNum();
		return count;
	}

	public void setDataToExcel(String sheetName, int rowNo, int cellNo, String data) throws Throwable, IOException {

		FileInputStream fisE = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		wb.getSheet(sheetName).getRow(rowNo).createCell(cellNo, CellType.STRING).setCellValue(data);

		FileOutputStream fosE = new FileOutputStream("");
		wb.write(fosE);
		wb.close();
	}
}
