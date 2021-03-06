package com.utilities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonVariables {

	public String headLineContent;
	public ArrayList<String> paperworkData = new ArrayList<String>();
	public int paperworkDataRow;
	public boolean paperworkDataAvailable;
	public static boolean userAvailability;
	public static LinkedHashMap<String, String> userData = new LinkedHashMap<String, String>();
	public String kitName;
	public static String casenumber;
	public static String vendorName;
	public static String users ="Users";
	public static String ourteam ="Our Team";
	public static String blogs ="Blogs";
	public static String faqs ="FAQs";
	public static String events ="Events";
	public static String pages ="Pages";
	public static String iptracker ="IP Tracker";
	public static String settings ="Settings";
	public static String testimonial ="Testimonials";
	public static String changepwd ="Changepwd";
	public static String categories ="Categories";
	public static String email ="Email";
	public static String allStrings ="All Strings";
	public static String tableColumns ="Table Columns";
	public static String contactus ="Contact Us";
	public static String contactinquiries ="Contact inquiries";
	public static String contactsetting ="Contactsetting";
	public static String Homeslider ="Home Page Sliders";
	public static String galleries ="Galleries";
	public static String Numrecord ="";
	public static String txtSearchCmnVar = "";
	public static String pagetitle = "";
	public static String changename = "";
	public static String adminauthor = "";
	public static String frontURL = "";
	public static String adminURL = "";
	public static String loginEmail = "";
	public static String loginPwd = "";
	public static List<String> strArray = new ArrayList<String>();
	public static String publishdate = "";
	public static boolean deleteRecord = false;
	public static boolean saveandcontinue = false;
	public static boolean OurTeam = false;
	public static String inactive = "";
	ReadPropFile readPropFile;
	public static String browserName = "";
	public static ArrayList<String> step = new ArrayList<String>();
	public static ArrayList<String> stepResult = new ArrayList<String>();
	
	@FindBy(xpath = "//div[@class='loader']")
	public static List<WebElement> elementList;
	
	@FindBy(id = "first_name")
	public static WebElement userFirstName;

	@FindBy(xpath = "//div[@class='loader']")
	public static WebElement element;

	WebDriver driver;

	public CommonVariables(WebDriver driver) {
		this.driver = driver;
		readPropFile = new ReadPropFile();
		readPropFile.readProp();
		browserName = readPropFile.prop.getProperty("browser");
		PageFactory.initElements(driver, this);
	}

}