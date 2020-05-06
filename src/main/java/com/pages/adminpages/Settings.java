package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.CommonXpath;

public class Settings {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	CommonXpath commonXpath;
	private Logger log = LogHelper.getLogger(Pages.class);
	boolean verifyDetails = false;

	
	public Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		commonXpath = new CommonXpath(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterAppName(String appName) throws InterruptedException {
		log.info("********************Enter the Author Name********************");
		Thread.sleep(2000);
		commonXpath.AppName.clear();
		commonXpath.AppName.sendKeys(appName);
	}

	public String getAppName() {
		return commonXpath.AppName.getAttribute("value");
	}

	public String getnoofRecordsperPage() {
		return commonXpath.NoofRecordsperPage.getAttribute("value");
	}

	public String getfooterTitleforAdmin() {
		return commonXpath.FooterTitleforAdmin.getAttribute("value");
	}
	
	public String getSiteTitle() {
		return commonXpath.Sitetitle.getAttribute("value");
	}
	public String getCopyrighttext() {
		return commonXpath.Copyrighttext.getAttribute("value");
	}
	public String getTagline() {
		
		return commonXpath.Tagline.getAttribute("value");
	}

	public String getMetadescriptionforfront() {
		return commonXpath.Meta_description_for_front.getAttribute("value");
	}
	
	public String getCompanyName() {
		return commonXpath.CompanyName.getAttribute("value");
	}
	public String getAddressLine1() {
		return commonXpath.Address1.getAttribute("value");
	}
	public String getAddressLine2() {
		return commonXpath.Address2.getAttribute("value");
	}
	public String getCity() {
		return commonXpath.City.getAttribute("value");
	}
	public String getState() {
		return commonXpath.State.getAttribute("value");
	}
	public String getCountry() {
		return commonXpath.Country.getAttribute("value");
	}
	public String getZipcode() {
		return commonXpath.Zipcode.getAttribute("value");
	}
	public String getPhone() {
		return commonXpath.Phone.getAttribute("value");
	}
	public String getEmail() {
		return commonXpath.Email.getAttribute("value");
	}
	public String getFromName() {
		return commonXpath.FromName.getAttribute("value");
	}
	public String getFromEmail() {
		return commonXpath.FromEmail.getAttribute("value");
	}
	public String getAdminEmail() {
		return commonXpath.AdminEmail.getAttribute("value");
	}
	
	public String getPasswordStrength() {
		return commonXpath.PasswordStrength.getAttribute("value");
	}
	public String getLoginattempt() {
		return commonXpath.Loginattempt.getAttribute("value");
	}
	public String getMinpwdlength() {
		return commonXpath.Minpwdlength.getAttribute("value");
	}
	public String getUserBlockTime() {
		return commonXpath.UserBlockTime.getAttribute("value");
	}	
	public String getFacebook() {
		return commonXpath.Facebook.getAttribute("value");
	}
	public String getTwitter() {
		return commonXpath.Twitter.getAttribute("value");
	}
	public String getLinkedIn() {
		return commonXpath.LinkedIn.getAttribute("value");
	}
	public String getGooglemap() {
		return commonXpath.Googlemap.getAttribute("value");
	}
	public String getGoogleRecaptchaSiteKey() {
		return commonXpath.GoogleRecaptchaSiteKey.getAttribute("value");
	}
	public String getGoogleRecaptchaSecertKey() {
		return commonXpath.GoogleRecaptchaSecertKey.getAttribute("value");
	}
	
	public String getRobotsMetaTag() {
		return commonXpath.RobotsMetaTag.getAttribute("value");
	}

	public String getGoogleAnalyticsCode() {
		return commonXpath.GoogleAnalyticsCode.getAttribute("value");
	}


	public void adminSettings(String appName, String noofRecordsperPage, String footerTitleforAdmin)
			throws InterruptedException {
		enterAppName(appName);
		enterNoofRecordsperPage(noofRecordsperPage);
		enterFooterTitleforAdmin(footerTitleforAdmin);

		ClickonSavebutton();
		assert appName.equals(getAppName()) ? true : false;
		assert noofRecordsperPage.equals(getnoofRecordsperPage()) ? true : false;
		assert footerTitleforAdmin.equals(getfooterTitleforAdmin()) ? true : false;
	}

	public void frontEndSettings(String sitetitle, String tagline, String copyrightText, String metaDescription)
			throws InterruptedException {
		commonXpath.frontEndAccordion.click();
		Thread.sleep(1000);
		enterSiteTitle(sitetitle);
		enterTagline(tagline);
		enterCopyrighttext(copyrightText);
		enterMetadescriptionforfront(metaDescription);
		
		ClickonSavebutton();
		assert sitetitle.equals(getSiteTitle()) ? true : false;
		assert tagline.equals(getTagline()) ? true : false;
		assert copyrightText.equals(getCopyrighttext()) ? true : false;
		assert metaDescription.equals(getMetadescriptionforfront()) ? true : false;
		
	}

	public void companySettings(String companyName, String addressline1, String addressline2, String city, String state,String country,String zipcode, String phone, String email,String googlemap)
			throws InterruptedException {
		commonXpath.companyAccordion.click();
		Thread.sleep(1000);
		enterCompanyName(companyName);
		enterAddressLine1(addressline1);
		enterAddressLine2(addressline2);
		enterCity(city);
		enterState(state);
		enterCountry(country);
		enterZipcode(zipcode);
		enterPhone(phone);
		enterEmail(email);
		enterGooglemap(googlemap);
		
		ClickonSavebutton();
		assert companyName.equals(getCompanyName()) ? true : false;
		assert addressline1.equals(getAddressLine1()) ? true : false;
		assert addressline2.equals(getAddressLine2()) ? true : false;
		assert city.equals(getCity()) ? true : false;
		assert state.equals(getState()) ? true : false;
		assert country.equals(getCountry()) ? true : false;
		assert zipcode.equals(getZipcode()) ? true : false;
		assert phone.equals(getPhone()) ? true : false;
		assert email.equals(getEmail()) ? true : false;
		assert googlemap.equals(getGooglemap()) ? true : false;
	}
	public void emailSettings(String fromName, String fromEmail, String adminEmail)
			throws InterruptedException {
		commonXpath.emailAccordion.click();
		Thread.sleep(1000);
		enterFromName(fromName);
		enterFromEmail(fromEmail);
		enterAdminEmail(adminEmail);
		
		ClickonSavebutton();
		assert fromName.equals(getFromName()) ? true : false;
		assert fromEmail.equals(getFromEmail()) ? true : false;
		assert adminEmail.equals(getAdminEmail()) ? true : false;
		
	}
	public void passwordSettings(String passwordStrength, String loginattempt, String minpwdlength, String userBlockTime)
			throws InterruptedException {
		commonXpath.passwordAccordion.click();
		Thread.sleep(1000);
		enterPasswordStrength(passwordStrength);
		enterLoginattempt(loginattempt);
		enterMinpwdlength(minpwdlength);
		enterUserBlockTime(userBlockTime);
		
		ClickonSavebutton();
		assert passwordStrength.equals(getPasswordStrength()) ? true : false;
		assert loginattempt.equals(getLoginattempt()) ? true : false;
		assert minpwdlength.equals(getMinpwdlength()) ? true : false;
		assert userBlockTime.equals(getUserBlockTime()) ? true : false;
		
	}
	
	public void sociallinkSettings(String facebook, String twitter, String linkedIn)
			throws InterruptedException {
		commonXpath.sociallinkAccordion.click();
		Thread.sleep(1000);
		enterFacebook(facebook);
		enterTwitter(twitter);
		enterLinkedIn(linkedIn);
		
		ClickonSavebutton();
		assert facebook.equals(getFacebook()) ? true : false;
		assert twitter.equals(getTwitter()) ? true : false;
		assert linkedIn.equals(getLinkedIn()) ? true : false;	
	}
	
	public void googlecaptchaSettings(String googleRecaptchaSiteKey, String googleRecaptchaSecertKey)
			throws InterruptedException {
		commonXpath.googleCaptchaAccordion.click();
		Thread.sleep(1000);
		enterGoogleRecaptchaSiteKey(googleRecaptchaSiteKey);
		enterGoogleRecaptchaSecertKey(googleRecaptchaSecertKey);
		
		ClickonSavebutton();
		assert googleRecaptchaSiteKey.equals(getGoogleRecaptchaSiteKey()) ? true : false;
		assert googleRecaptchaSecertKey.equals(getGoogleRecaptchaSecertKey()) ? true : false;	
	}

	public void SEOSettings(String googleAnalyticsCode, String robotsMetaTag)
			throws InterruptedException {
		commonXpath.SEOAccordion.click();
		Thread.sleep(1000);
		enterGoogleAnalyticsCode(googleAnalyticsCode);
		enterRobotsMetaTag(robotsMetaTag);
		
		ClickonSavebutton();
		assert googleAnalyticsCode.equals(getGoogleAnalyticsCode()) ? true : false;
		assert robotsMetaTag.equals(getRobotsMetaTag()) ? true : false;	
	}



	public void enterNoofRecordsperPage(String noofRecordsperPage) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectVisibleText(commonXpath.NoofRecordsperPage, noofRecordsperPage);

	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		commonXpath.Settingeditbutton.click();
	}

	public void ClickonSavebutton() {
		log.info("********************Click on Save button********************");
		commonXpath.Save.click();
	}

	public void enterFooterTitleforAdmin(String footerTitleforAdmin) throws InterruptedException {
		log.info("********************Enter the Description********************");
		commonXpath.FooterTitleforAdmin.clear();
		commonXpath.FooterTitleforAdmin.sendKeys(footerTitleforAdmin);
		Thread.sleep(2000);
	}

	public void enterSiteTitle(String sitetitle) {
		log.info("********************Enter the Meta Title********************");
		commonXpath.Sitetitle.clear();
		commonXpath.Sitetitle.sendKeys(sitetitle);
	}

	public void enterTagline(String tagline) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Tagline.clear();
		commonXpath.Tagline.sendKeys(tagline);
		System.out.println("test " + commonXpath.Tagline.getAttribute("value"));
	}

	public void enterCopyrighttext(String copyrighttext) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Copyrighttext.clear();
		commonXpath.Copyrighttext.sendKeys(copyrighttext);
	}

	public void enterMetadescriptionforfront(String metadescriptionforfront) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Meta_description_for_front.clear();
		commonXpath.Meta_description_for_front.sendKeys(metadescriptionforfront);
	}
	
	public void enterCompanyName(String companyName) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.CompanyName.clear();
		commonXpath.CompanyName.sendKeys(companyName);
	}
	public void enterAddressLine1(String addressline1) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.SettingAddress1.clear();
		commonXpath.SettingAddress1.sendKeys(addressline1);
	}
	
	public void enterAddressLine2(String addressline2) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.SettingAddress2.clear();
		commonXpath.SettingAddress2.sendKeys(addressline2);
	}


	public void enterCity(String city) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.SettingCity.clear();
		commonXpath.SettingCity.sendKeys(city);
	}

	public void enterState(String state) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.SettingState.clear();
		commonXpath.SettingState.sendKeys(state);
	}

	public void enterCountry(String country) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.SettingCountry.clear();
		commonXpath.SettingCountry.sendKeys(country);
	}

	public void enterZipcode(String zipcode) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.SettingZipcode.clear();
		commonXpath.SettingZipcode.sendKeys(zipcode);
	}

	public void enterPhone(String phone) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Phone.clear();
		commonXpath.Phone.sendKeys(phone);
	}

	public void enterEmail(String email) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Email.clear();
		commonXpath.Email.sendKeys(email);
	}

	public void enterFromName(String fromName) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.FromName.clear();
		commonXpath.FromName.sendKeys(fromName);
	}

	public void enterFromEmail(String fromEmail) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.FromEmail.clear();
		commonXpath.FromEmail.sendKeys(fromEmail);
	}

	public void enterAdminEmail(String adminEmail) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.AdminEmail.clear();
		commonXpath.AdminEmail.sendKeys(adminEmail);
	}
	public void enterPasswordStrength(String passwordStrength) {
		log.info("********************Enter the Meta Description********************");
		dropDownHelper.selectVisibleText(commonXpath.PasswordStrength, passwordStrength);
	}
	public void enterLoginattempt(String loginattempt) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Loginattempt.clear();
		commonXpath.Loginattempt.sendKeys(loginattempt);
	}
	public void enterMinpwdlength(String minpwdlength) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Minpwdlength.clear();
		commonXpath.Minpwdlength.sendKeys(minpwdlength);
	}
	public void enterUserBlockTime(String userBlockTime) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.UserBlockTime.clear();
		commonXpath.UserBlockTime.sendKeys(userBlockTime);
	}
	
	public void enterFacebook(String facebook) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Facebook.clear();
		commonXpath.Facebook.sendKeys(facebook);
	}
	public void enterTwitter(String twitter) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Twitter.clear();
		commonXpath.Twitter.sendKeys(twitter);
	}
	public void enterLinkedIn(String linkedIn) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.LinkedIn.clear();
		commonXpath.LinkedIn.sendKeys(linkedIn);
	}
	
	public void enterGoogleRecaptchaSiteKey(String googleRecaptchaSiteKey) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.GoogleRecaptchaSiteKey.clear();
		commonXpath.GoogleRecaptchaSiteKey.sendKeys(googleRecaptchaSiteKey);
	}
	public void enterGoogleRecaptchaSecertKey(String googleRecaptchaSecertKey) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.GoogleRecaptchaSecertKey.clear();
		commonXpath.GoogleRecaptchaSecertKey.sendKeys(googleRecaptchaSecertKey);
	}
	public void enterGooglemap(String googlemap) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.Googlemap.clear();
		commonXpath.Googlemap.sendKeys(googlemap);
	}
	public void enterRobotsMetaTag(String robotsMetaTag) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.RobotsMetaTag.clear();
		commonXpath.RobotsMetaTag.sendKeys(robotsMetaTag);
	}
	public void enterGoogleAnalyticsCode(String googleAnalyticsCode) {
		log.info("********************Enter the Meta Description********************");
		commonXpath.GoogleAnalyticsCode.clear();
		commonXpath.GoogleAnalyticsCode.sendKeys(googleAnalyticsCode);
	}
}
