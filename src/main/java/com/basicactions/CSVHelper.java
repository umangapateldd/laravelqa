package com.basicactions;

import com.chilkatsoft.CkCsv;

public class CSVHelper {

	public static void changeValueCSV(String path, String changeVal, int row, int col) {
		CkCsv csv = new CkCsv();
		// Prior to loading the CSV file, indicate that the 1st row
		// should be treated as column names:
		csv.put_HasColumnNames(true);

		// Load the CSV records from the file:
		boolean success;
		success = csv.LoadFile(path);
		if (success != true) {
			System.out.println(csv.lastErrorText());
			return;
		}

		// first 0 is row and second 0 is col
		success = csv.SetCell(row, col, changeVal);

		// Save the CSV to a file:
		success = csv.SaveFile(path);
		if (success != true) {
			System.out.println(csv.lastErrorText());
		}
	}
}
