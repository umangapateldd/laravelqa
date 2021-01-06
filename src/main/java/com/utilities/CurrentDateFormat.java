package com.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CurrentDateFormat {

	public String currentDate() {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate curretDate = LocalDate.now();
		String CDformat = date.format(curretDate);
		return CDformat;
	}

	public String currentDateTimeFormat(String DateTimeFormat) {
		DateFormat df = new SimpleDateFormat(DateTimeFormat);
		Date dateobj = new Date();
		return df.format(dateobj);
	}

}
