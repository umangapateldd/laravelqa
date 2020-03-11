package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonXpath {

	@FindBy(id = "first_name")
	public WebElement FirstName;
	
	@FindBy(id = "last_name")
	public WebElement LastName;
	
	@FindBy(id = "email")
	public WebElement userEmail;
	
	@FindBy(id = "position")
	WebElement Position;

	@FindBy(id = "linkedin")
	WebElement Linkedin;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;

	@FindBy(id = "meta_title")
	WebElement Metatitle;

	@FindBy(id = "meta_desc")
	WebElement MetaDescription;

	@FindBy(id = "short_bio")
	WebElement ShortBio;

	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement Description;

	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement AdditionalBio;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	WebElement editbutton;

//	@FindBy(xpath = "//input[@type='file']")
	@FindBy(xpath = "//input[@type='file']")
	WebElement Image;

	@FindBy(xpath = "//*[@id='image_alt']")
	WebElement ImageAlt;
	
	WebDriver driver;
	ReadPropFile readPropFile;
	public static String browserName = "";

	public CommonXpath(WebDriver driver) {
		this.driver = driver;
		readPropFile = new ReadPropFile();
		readPropFile.readProp();
		browserName = readPropFile.prop.getProperty("browser");
		PageFactory.initElements(driver, this);
	}

}
