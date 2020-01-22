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