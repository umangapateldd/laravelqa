package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;

public class ContactUS {

	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;

	private Logger log = LogHelper.getLogger(ContactUS.class);
	boolean verifyDetails = false;

	public ContactUS(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);

		dropDownHelper = new DropDownHelper(driver);
	}

	public String getContacttitle() {
		return commonXpath.Contact_Title.getAttribute("value");
	}

	public String getthankyoumessge() {
		return commonXpath.Contact_Message.getAttribute("value");
	}

	public String getcontactemail() {
		return commonXpath.Contact_email.getAttribute("value");
	}

	public void contactSettings(String contacttitle, String contactmessage, String contactemail)
			throws InterruptedException {
		commonXpath.Contactsettingmenu.click();
		Thread.sleep(1000);
		entercontactTitle(contacttitle);
		entercontactmessage(contactmessage);
		entercontactemail(contactemail);
		
		ClickonSavebutton();
		assert contacttitle.equals(getContacttitle()) ? true : false;
		assert contactmessage.equals(getthankyoumessge()) ? true : false;
		assert contactemail.equals(getcontactemail()) ? true : false;

	}
	public void entercontactTitle(String contacttitletle) {
		log.info("********************Enter the contacttitletle ********************");
		commonXpath.Contact_settingTitle.clear();
		commonXpath.Contact_settingTitle.sendKeys(contacttitletle);
	}

	public void entercontactmessage(String contactmessage) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Contact_Message.clear();
		commonXpath.Contact_Message.sendKeys(contactmessage);
		
	}

	public void entercontactemail(String contactemail) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Contact_email.clear();
		commonXpath.Contact_email.sendKeys(contactemail);
	}
	
	public void ClickonSavebutton() {
		log.info("********************Click on Save button********************");
		commonXpath.Contact_Save.click();
	}

}
