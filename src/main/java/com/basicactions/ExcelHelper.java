package com.basicactions;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import com.utilities.FilesPaths;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelHelper {

	public static Workbook wb;
	public static Sheet sh1;
	public static File src;
	public static Cell c1;
	public static WritableWorkbook workbook1;
	public static WritableSheet sheet1;
	private static Logger log = LogHelper.getLogger(ExcelHelper.class);

	public static void readDataFromXLS(String path, String sheetName) {
		src = new File(path);
		try {
			wb = Workbook.getWorkbook(src);
			sh1 = wb.getSheet(sheetName);

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getData(int col, int row) {
		c1 = sh1.getCell(col, row);
		String data1 = c1.getContents();
		return data1;
	}

	public static int getTotalRowsCount() {
		return sh1.getRows();
	}

	public static int getTotalColsCount() {
		return sh1.getColumns();
	}

	public static void deleteXLS(String path) {
		src = new File(path);
		src.delete();
	}

	public static boolean checkFileExist(String path) throws IOException {
		File tempFile = new File(path);
		boolean exists = tempFile.exists();
		return exists;
	}

	public static void createExcel(String filenameWithoutExtension, String sheetName) throws IOException {
		File outputWorkbook;
		if (System.getProperty("os.name").toLowerCase().equals("linux")) {
			outputWorkbook = new File(FilesPaths.EXTRA_FILES_FOLDER_linux + filenameWithoutExtension + ".xls");
		}else{
			outputWorkbook = new File(FilesPaths.EXTRA_FILES_FOLDER + filenameWithoutExtension + ".xls");	
		}
		
		if (outputWorkbook.exists() != true) {
			workbook1 = Workbook.createWorkbook(outputWorkbook);
			sheet1 = workbook1.createSheet(sheetName, 0);
		} else {
			log.info(filenameWithoutExtension + ".xls file is already exist so not creating excel");
		}
	}

	public static void enterDataExcelCell(int col, int row, String dataVal)
			throws RowsExceededException, WriteException {
		Label label = new Label(col, row, dataVal);
		sheet1.addCell(label);
	}

	public static void closeNewlyCreatedExcel() throws IOException, WriteException {
		workbook1.write();
		workbook1.close();
	}

	public static boolean convertCSVToXLS(String csvfilename, String xlsfilename) throws IOException {
		ArrayList arList = null;
		ArrayList al = null;
		String fName = csvfilename;
		String thisLine;
		int count = 0;
		FileInputStream fis = new FileInputStream(fName);
		DataInputStream myInput = new DataInputStream(fis);
		int i = 0;
		arList = new ArrayList();
		while ((thisLine = myInput.readLine()) != null) {
			al = new ArrayList();
			String strar[] = thisLine.split(",");
			for (int j = 0; j < strar.length; j++) {
				al.add(strar[j]);
			}
			arList.add(al);
			i++;
		}

		try {
			HSSFWorkbook hwb = new HSSFWorkbook();
			HSSFSheet sheet = hwb.createSheet("new sheet");
			for (int k = 0; k < arList.size(); k++) {
				ArrayList ardata = (ArrayList) arList.get(k);
				HSSFRow row = sheet.createRow((short) 0 + k);
				for (int p = 0; p < ardata.size(); p++) {
					HSSFCell cell = row.createCell((short) p);
					String data = ardata.get(p).toString();
					if (data.startsWith("=")) {
						cell.setCellType(CellType.STRING);
						data = data.replaceAll("\"", "");
						data = data.replaceAll("=", "");
						cell.setCellValue(data);
					} else if (data.startsWith("\"")) {
						data = data.replaceAll("\"", "");
						cell.setCellType(CellType.STRING);
						cell.setCellValue(data);
					} else {
						data = data.replaceAll("\"", "");
						cell.setCellType(CellType.NUMERIC);
						cell.setCellValue(data);
					}
					// */
					// cell.setCellValue(ardata.get(p).toString());
				}
			}
			FileOutputStream fileOut = new FileOutputStream(xlsfilename);
			hwb.write(fileOut);
			fileOut.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} // main method ends
	}
}
