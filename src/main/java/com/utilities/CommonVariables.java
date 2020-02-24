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
	public static String settings ="Settings";
	public static String testimonial ="Testimonial";
	public static String categories ="Categories";
	public static String txtSearchCmnVar = "";
	public static String pagetitle = "";
	public static String adminauthor = "";
	public static String publishdate = "";
	public static boolean deleteRecord = false;
	public static boolean saveandcontinue = false;
	public static boolean OurTeam = false;
	public static String inactive = "";

	@FindBy(xpath = "//div[@class='loader']")
	public static List<WebElement> elementList;

	@FindBy(xpath = "//div[@class='loader']")
	public static WebElement element;

	WebDriver driver;

	public CommonVariables(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}