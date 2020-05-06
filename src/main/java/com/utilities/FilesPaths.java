package com.utilities;

public class FilesPaths {

	public final static String CONFIG_PROPERTIES_FILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\configfiles\\config.properties";

	public final static String XPATH_PROPERTIES_FILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\configfiles\\xpath.properties";

	public final static String LOG_PROPERTIES_FILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\configfiles\\log4j.properties";

	public final static String CHROME_DRIVER = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\drivers\\chromedriver.exe";

	public final static String GECKO_DRIVER_FF = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\drivers\\geckodriver.exe";

	public final static String IE_DRIVER = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\drivers\\IEDriverServer.exe";

	public final static String TEST_DATA = System.getProperty("user.dir") + "\\src\\test\\resources\\com\\testdata\\";

	public final static String EXTRA_FILES_FOLDER = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\com\\extrafiles\\";

	public final static String project_folder = System.getProperty("user.dir") + "\\";

	public static String excel_data_file_name = EXTRA_FILES_FOLDER + "Laraveldata.xls";

	public static String excel_data_file = EXTRA_FILES_FOLDER + "TestData.xls";

	public final static String CONFIG_PROPERTIES_FILE_linux = "src/main/resources/com/configfiles/config.properties";

	public final static String XPATH_PROPERTIES_FILE_linux = "src/main/resources/com/configfiles/xpath.properties";

	public final static String LOG_PROPERTIES_FILE_linux = "src/main/resources/com/configfiles/log4j.properties";

	public final static String CHROME_DRIVER_linux = "/src/main/resources/com/drivers/chromedriver";

	public final static String TEST_DATA_linux = "src/test/resources/com/testdata/";

	public final static String EXTRA_FILES_FOLDER_linux = "src/main/resources/com/extrafiles/";

	public static String excel_data_file_name_linux = EXTRA_FILES_FOLDER_linux + "Laraveldata.xls";

	public static String excel_data_file_linux = EXTRA_FILES_FOLDER_linux + "TestData.xls";
}