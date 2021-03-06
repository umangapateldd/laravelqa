package com.basicactions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelperPOI {
	public static FileInputStream fsIP;
	public static HSSFWorkbook wb;
	public static HSSFSheet worksheet;
	public static XSSFSheet sheet;

	public void addDataInExistingExcel(String fileName, String sheetName, String dataVal[]) throws IOException {
		fsIP = new FileInputStream(new File(fileName + ".xls"));
		wb = new HSSFWorkbook(fsIP);
		HSSFSheet worksheet = wb.getSheet(sheetName);

		int rowCount = worksheet.getLastRowNum() - worksheet.getFirstRowNum();
		Row row = worksheet.getRow(0);
		Row newRow = worksheet.createRow(rowCount + 1);
		String data[] = dataVal;
		for (int j = 0; j < row.getLastCellNum(); j++) {
			Cell cell = newRow.createCell(j);
			cell.setCellValue(data[j]);
		}

		closeExistingExcel(fileName);
	}

	public void closeExistingExcel(String fileName) throws IOException {
		fsIP.close();

		FileOutputStream outputStream = new FileOutputStream(fileName + ".xls");
		wb.write(outputStream);
		outputStream.close();
	}

	public static void readExcel(String fileName, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(new File(fileName));
		// Create Workbook instance

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get sheet Name from Workbook
		sheet = workbook.getSheet(sheetName);
	}

	public static void readExcelData(int col, int row) {
//		String data = sheet.get
		int totalRow = sheet.getLastRowNum() + 1;
		System.out.println("totalRow = " + totalRow);
		for (int i = 1; i < 5; i++) {
			XSSFRow r = sheet.getRow(i);
			String ce = r.getCell(1).getStringCellValue();
			System.out.println(ce);
		}
//		return data;
	}

	@SuppressWarnings("resource")
	public static Object[][] getExcelData(String excelLocation, String sheetName) {

		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));

			// Create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet Name from Workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum();
//            System.out.println(totalRow);

			// count active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[totalRow][totalColumn - 1];

			// Iterate Through each Rows one by one.
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				i++;
				// for Every row , we need to iterator over columns
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					if (cell.getStringCellValue().contains("Start")) {
						i = 0;
						break;
					}
					switch (cell.getCellType()) {
					case STRING:
						dataSets[i - 1][j++] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i - 1][j++] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i - 1][j++] = cell.getBooleanCellValue();
					case FORMULA:
						dataSets[i - 1][j++] = cell.getCellFormula();
						break;

					default:
						System.out.println("no matching enum date type found");
						break;
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("resource")
	public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus) {
		try {
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create Workbook instance

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet Name from Workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum() + 1;
			for (int i = 1; i < totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if (ce.contains(testCaseName)) {
					r.createCell(1).setCellValue(testStatus);
					file.close();

					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}
		} catch (Exception e) {

		}

	}

}
