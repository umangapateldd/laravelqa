package com.pages.adminpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

public class Settings {
	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Pages.class);
	boolean verifyDetails = false;

	@FindBy(id = "app_name")
	WebElement AppName;

	@FindBy(id = "footer_title_for_admin")
	WebElement FooterTitleforAdmin;

	@FindBy(xpath = "//*[@id='status']")
	WebElement Status;

	@FindBy(id = "site_title")
	WebElement Sitetitle;

	@FindBy(xpath = "//*[@id='tagline']")
	WebElement Tagline;

	@FindBy(xpath = "//*[@id='btnsave']")
	WebElement Save;

	@FindBy(id = "copyright_text")
	WebElement Copyrighttext;

	@FindBy(id = "meta_description_for_front")
	WebElement Meta_description_for_front;

	@FindBy(xpath = "//*[@id='records_per_page']")
	WebElement NoofRecordsperPage;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	WebElement editbutton;

	@FindBy(xpath = "//*[@id='site-config-heading-1']/h5/a")
	WebElement frontEndAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-2']/h5/a")
	WebElement companyAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-3']/h5/a")
	WebElement emailAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-4']/h5/a")
	WebElement passwordAccordion;

	@FindBy(xpath = "//*[@id='site-config-heading-5']/h5/a")
	WebElement sociallinkAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-6']/h5/a")
	WebElement googleCaptchaAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-7']/h5/a")
	WebElement SEOAccordion;
	
	@FindBy(xpath = "//*[@id='company_name']")
	WebElement CompanyName;

	@FindBy(xpath = "//*[@id='company_address_line1']")
	WebElement Address1;

	@FindBy(xpath = "//*[@id='company_address_line2']")
	WebElement Address2;

	@FindBy(xpath = "//*[@id='company_city']")
	WebElement City;

	@FindBy(xpath = "//*[@id='company_state']")
	WebElement State;

	@FindBy(xpath = "//*[@id='company_country']")
	WebElement Country;

	@FindBy(xpath = "//*[@id='company_zipcode']")
	WebElement Zipcode;

	@FindBy(xpath = "//*[@id='phone']")
	WebElement Phone;

	@FindBy(xpath = "//*[@id='company_email']")
	WebElement Email;
	
	@FindBy(xpath = "//*[@id='from_name']")
	WebElement FromName;

	@FindBy(xpath = "//*[@id='from_email']")
	WebElement FromEmail ;

	@FindBy(xpath = "//*[@id='admin_email']")
	WebElement AdminEmail;
	
	@FindBy(xpath = "//*[@id='password_strength']")
	WebElement PasswordStrength;
	
	@FindBy(xpath = "//*[@id='login_attempt']")
	WebElement Loginattempt;
	
	@FindBy(xpath = "//*[@id='minimum_password_length']")
	WebElement Minpwdlength;
	
	@FindBy(xpath = "//*[@id='user_block_time']")
	WebElement UserBlockTime;
	
	@FindBy(xpath = "//*[@id='facebook_link']")
	WebElement Facebook;
	
	@FindBy(xpath = "//*[@id='googlemap_embedded']")
	WebElement Googlemap;
	
	@FindBy(xpath = "//*[@id='twitter_link']")
	WebElement Twitter;
	
	@FindBy(xpath = "//*[@id='linkedin_link']")
	WebElement LinkedIn;
	
	@FindBy(xpath = "//*[@id='GOOGLE_RECAPTCHA_KEY']")
	WebElement GoogleRecaptchaSiteKey;
	
	@FindBy(xpath = "//*[@id='GOOGLE_RECAPTCHA_SECRET']")
	WebElement GoogleRecaptchaSecertKey;
	
	@FindBy(xpath = "//*[@id='robots_meta_tag']")
	WebElement RobotsMetaTag;
	
	@FindBy(xpath = "//*[@id='google_analytics_code']")
	WebElement GoogleAnalyticsCode;
	
	
	public Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}

	public void enterAppName(String appName) throws InterruptedException {
		log.info("********************Enter the Author Name********************");
		Thread.sleep(2000);
		AppName.clear();
		AppName.sendKeys(appName);
	}

	public String getAppName() {
		return AppName.getAttribute("value");
	}

	public String getnoofRecordsperPage() {
		return NoofRecordsperPage.getAttribute("value");
	}

	public String getfooterTitleforAdmin() {
		return FooterTitleforAdmin.getAttribute("value");
	}
	
	public String getSiteTitle() {
		return Sitetitle.getAttribute("value");
	}
	public String getCopyrighttext() {
		return Copyrighttext.getAttribute("value");
	}
	public String getTagline() {
		
		return Tagline.getAttribute("value");
	}

	public String getMetadescriptionforfront() {
		return Meta_description_for_front.getAttribute("value");
	}
	
	public String getCompanyName() {
		return CompanyName.getAttribute("value");
	}
	public String getAddressLine1() {
		return Address1.getAttribute("value");
	}
	public String getAddressLine2() {
		return Address2.getAttribute("value");
	}
	public String getCity() {
		return City.getAttribute("value");
	}
	public String getState() {
		return State.getAttribute("value");
	}
	public String getCountry() {
		return Country.getAttribute("value");
	}
	public String getZipcode() {
		return Zipcode.getAttribute("value");
	}
	public String getPhone() {
		return Phone.getAttribute("value");
	}
	public String getEmail() {
		return Email.getAttribute("value");
	}
	public String getFromName() {
		return FromName.getAttribute("value");
	}
	public String getFromEmail() {
		return FromEmail.getAttribute("value");
	}
	public String getAdminEmail() {
		return AdminEmail.getAttribute("value");
	}
	
	public String getPasswordStrength() {
		return PasswordStrength.getAttribute("value");
	}
	public String getLoginattempt() {
		return Loginattempt.getAttribute("value");
	}
	public String getMinpwdlength() {
		return Minpwdlength.getAttribute("value");
	}
	public String getUserBlockTime() {
		return UserBlockTime.getAttribute("value");
	}	
	public String getFacebook() {
		return Facebook.getAttribute("value");
	}
	public String getTwitter() {
		return Twitter.getAttribute("value");
	}
	public String getLinkedIn() {
		return LinkedIn.getAttribute("value");
	}
	public String getGooglemap() {
		return Googlemap.getAttribute("value");
	}
	public String getGoogleRecaptchaSiteKey() {
		return GoogleRecaptchaSiteKey.getAttribute("value");
	}
	public String getGoogleRecaptchaSecertKey() {
		return GoogleRecaptchaSecertKey.getAttribute("value");
	}
	
	public String getRobotsMetaTag() {
		return RobotsMetaTag.getAttribute("value");
	}

	public String getGoogleAnalyticsCode() {
		return GoogleAnalyticsCode.getAttribute("value");
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
		frontEndAccordion.click();
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
		companyAccordion.click();
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
		emailAccordion.click();
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
		passwordAccordion.click();
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
		sociallinkAccordion.click();
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
		googleCaptchaAccordion.click();
		Thread.sleep(1000);
		enterGoogleRecaptchaSiteKey(googleRecaptchaSiteKey);
		enterGoogleRecaptchaSecertKey(googleRecaptchaSecertKey);
		
		ClickonSavebutton();
		assert googleRecaptchaSiteKey.equals(getGoogleRecaptchaSiteKey()) ? true : false;
		assert googleRecaptchaSecertKey.equals(getGoogleRecaptchaSecertKey()) ? true : false;	
	}

	public void SEOSettings(String googleAnalyticsCode, String robotsMetaTag)
			throws InterruptedException {
		SEOAccordion.click();
		Thread.sleep(1000);
		enterGoogleAnalyticsCode(googleAnalyticsCode);
		enterRobotsMetaTag(robotsMetaTag);
		
		ClickonSavebutton();
		assert googleAnalyticsCode.equals(getGoogleAnalyticsCode()) ? true : false;
		assert robotsMetaTag.equals(getRobotsMetaTag()) ? true : false;	
	}



	public void enterNoofRecordsperPage(String noofRecordsperPage) {
		log.info("********************Enter the Status********************");
		dropDownHelper.selectVisibleText(NoofRecordsperPage, noofRecordsperPage);

	}

	public void ClickonEditbutton() {
		log.info("********************Click on Edit button********************");
		editbutton.click();
	}

	public void ClickonSavebutton() {
		log.info("********************Click on Save button********************");
		Save.click();
	}

	public void enterFooterTitleforAdmin(String footerTitleforAdmin) throws InterruptedException {
		log.info("********************Enter the Description********************");
		FooterTitleforAdmin.clear();
		FooterTitleforAdmin.sendKeys(footerTitleforAdmin);
		Thread.sleep(2000);
	}

	public void enterSiteTitle(String sitetitle) {
		log.info("********************Enter the Meta Title********************");
		Sitetitle.clear();
		Sitetitle.sendKeys(sitetitle);
	}

	public void enterTagline(String tagline) {
		log.info("********************Enter the Meta Description********************");
		Tagline.clear();
		Tagline.sendKeys(tagline);
		System.out.println("test " + Tagline.getAttribute("value"));
	}

	public void enterCopyrighttext(String copyrighttext) {
		log.info("********************Enter the Meta Description********************");
		Copyrighttext.clear();
		Copyrighttext.sendKeys(copyrighttext);
	}

	public void enterMetadescriptionforfront(String metadescriptionforfront) {
		log.info("********************Enter the Meta Description********************");
		Meta_description_for_front.clear();
		Meta_description_for_front.sendKeys(metadescriptionforfront);
	}
	
	public void enterCompanyName(String companyName) {
		log.info("********************Enter the Meta Description********************");
		CompanyName.clear();
		CompanyName.sendKeys(companyName);
	}
	public void enterAddressLine1(String addressline1) {
		log.info("********************Enter the Meta Description********************");
		Address1.clear();
		Address1.sendKeys(addressline1);
	}
	
	public void enterAddressLine2(String addressline2) {
		log.info("********************Enter the Meta Description********************");
		Address2.clear();
		Address2.sendKeys(addressline2);
	}


	public void enterCity(String city) {
		log.info("********************Enter the Meta Description********************");
		City.clear();
		City.sendKeys(city);
	}

	public void enterState(String state) {
		log.info("********************Enter the Meta Description********************");
		State.clear();
		State.sendKeys(state);
	}

	public void enterCountry(String country) {
		log.info("********************Enter the Meta Description********************");
		Country.clear();
		Country.sendKeys(country);
	}

	public void enterZipcode(String zipcode) {
		log.info("********************Enter the Meta Description********************");
		Zipcode.clear();
		Zipcode.sendKeys(zipcode);
	}

	public void enterPhone(String phone) {
		log.info("********************Enter the Meta Description********************");
		Phone.clear();
		Phone.sendKeys(phone);
	}

	public void enterEmail(String email) {
		log.info("********************Enter the Meta Description********************");
		Email.clear();
		Email.sendKeys(email);
	}

	public void enterFromName(String fromName) {
		log.info("********************Enter the Meta Description********************");
		FromName.clear();
		FromName.sendKeys(fromName);
	}

	public void enterFromEmail(String fromEmail) {
		log.info("********************Enter the Meta Description********************");
		FromEmail.clear();
		FromEmail.sendKeys(fromEmail);
	}

	public void enterAdminEmail(String adminEmail) {
		log.info("********************Enter the Meta Description********************");
		AdminEmail.clear();
		AdminEmail.sendKeys(adminEmail);
	}
	public void enterPasswordStrength(String passwordStrength) {
		log.info("********************Enter the Meta Description********************");
		dropDownHelper.selectVisibleText(PasswordStrength, passwordStrength);
	}
	public void enterLoginattempt(String loginattempt) {
		log.info("********************Enter the Meta Description********************");
		Loginattempt.clear();
		Loginattempt.sendKeys(loginattempt);
	}
	public void enterMinpwdlength(String minpwdlength) {
		log.info("********************Enter the Meta Description********************");
		Minpwdlength.clear();
		Minpwdlength.sendKeys(minpwdlength);
	}
	public void enterUserBlockTime(String userBlockTime) {
		log.info("********************Enter the Meta Description********************");
		UserBlockTime.clear();
		UserBlockTime.sendKeys(userBlockTime);
	}
	
	public void enterFacebook(String facebook) {
		log.info("********************Enter the Meta Description********************");
		Facebook.clear();
		Facebook.sendKeys(facebook);
	}
	public void enterTwitter(String twitter) {
		log.info("********************Enter the Meta Description********************");
		Twitter.clear();
		Twitter.sendKeys(twitter);
	}
	public void enterLinkedIn(String linkedIn) {
		log.info("********************Enter the Meta Description********************");
		LinkedIn.clear();
		LinkedIn.sendKeys(linkedIn);
	}
	
	public void enterGoogleRecaptchaSiteKey(String googleRecaptchaSiteKey) {
		log.info("********************Enter the Meta Description********************");
		GoogleRecaptchaSiteKey.clear();
		GoogleRecaptchaSiteKey.sendKeys(googleRecaptchaSiteKey);
	}
	public void enterGoogleRecaptchaSecertKey(String googleRecaptchaSecertKey) {
		log.info("********************Enter the Meta Description********************");
		GoogleRecaptchaSecertKey.clear();
		GoogleRecaptchaSecertKey.sendKeys(googleRecaptchaSecertKey);
	}
	public void enterGooglemap(String googlemap) {
		log.info("********************Enter the Meta Description********************");
		Googlemap.clear();
		Googlemap.sendKeys(googlemap);
	}
	public void enterRobotsMetaTag(String robotsMetaTag) {
		log.info("********************Enter the Meta Description********************");
		RobotsMetaTag.clear();
		RobotsMetaTag.sendKeys(robotsMetaTag);
	}
	public void enterGoogleAnalyticsCode(String googleAnalyticsCode) {
		log.info("********************Enter the Meta Description********************");
		GoogleAnalyticsCode.clear();
		GoogleAnalyticsCode.sendKeys(googleAnalyticsCode);
	}
}
