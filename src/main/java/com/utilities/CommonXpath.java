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
	public WebElement Position;

	@FindBy(id = "linkedin")
	public WebElement Linkedin;

	@FindBy(xpath = "//*[@id='status']")
	public WebElement Status;

	@FindBy(id = "meta_title")
	public WebElement Metatitle;

	@FindBy(id = "meta_desc")
	public WebElement MetaDescription;

	@FindBy(id = "short_bio")
	public WebElement ShortBio;

	@FindBy(xpath = "//body[@id='tinymce']")
	public WebElement Description;

	@FindBy(xpath = "//body[@id='tinymce']")
	public WebElement AdditionalBio;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	public WebElement editbutton;

	@FindBy(xpath = "//input[@type='file']")
	public WebElement Image;

	@FindBy(xpath = "//*[@id='image_alt']")
	public WebElement ImageAlt;
	
	@FindBy(id = "title")
	public WebElement Title;

	@FindBy(id = "url")
	public WebElement URL;

	@FindBy(xpath = "//*[@id='description']")
	public WebElement EventDescription;

	@FindBy(xpath = "//*[@id='start_date']")
	public WebElement StartDate;

	@FindBy(xpath = "//*[@id='end_date']")
	public WebElement EndDate;

	@FindBy(xpath = "//*[@id='event_time']")
	public WebElement EventTime;

	@FindBy(xpath = "//*[@id='address1']")
	public WebElement Address1;

	@FindBy(xpath = "//*[@id='address2']")
	public WebElement Address2;

	@FindBy(xpath = "//*[@id='city']")
	public WebElement City;

	@FindBy(xpath = "//*[@id='state']")
	public WebElement State;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[3]/div[2]/div[3]/table/tbody/tr[4]/td[2]")
	public WebElement selectdate;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[4]/div[2]/div[3]/table/tbody/tr[4]/td[6]")
	public WebElement selectenddate;

	@FindBy(xpath = "//*[@id='zipcode']")
	public WebElement Zipcode;

	@FindBy(xpath = "//*[@id='country']")
	public WebElement Country;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[10]/a")
	public WebElement Eventeditbutton;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[5]/div[2]/div[2]/table/tbody/tr/td/fieldset[1]/span[1]")
	public WebElement eventtime;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[5]/div[2]/div[1]/table/tbody/tr/td/fieldset/span[1]")
	public WebElement AMPMtime;

	@FindBy(xpath = "//*[@id='recurrence']")
	public WebElement Recurrence;

	@FindBy(xpath = "//*[@id='field_testimonial_title_display']")
	public WebElement Settingfield;

	@FindBy(xpath = "//*[@id='btnsave']")
	public WebElement Settingsave;

	@FindBy(xpath = "//*[@id='tinymce']")
	public WebElement PageContent;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	public WebElement Pageseditbutton;

	@FindBy(xpath = "//*[@id='status']")
	public WebElement gridStatus;
	
	@FindBy(xpath = "//*[@id='status']/option[3]")
	public WebElement Statusoption;

	@FindBy(xpath = "//*[@id='btnsearch']")
	public WebElement Searchbutton;
	
	@FindBy(id = "app_name")
	public WebElement AppName;

	@FindBy(id = "footer_title_for_admin")
	public WebElement FooterTitleforAdmin;

	@FindBy(id = "site_title")
	public WebElement Sitetitle;

	@FindBy(xpath = "//*[@id='tagline']")
	public WebElement Tagline;

	@FindBy(xpath = "//*[@id='btnsave']")
	public WebElement Save;

	@FindBy(id = "copyright_text")
	public WebElement Copyrighttext;

	@FindBy(id = "meta_description_for_front")
	public WebElement Meta_description_for_front;

	@FindBy(xpath = "//*[@id='records_per_page']")
	public WebElement NoofRecordsperPage;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	public WebElement Settingeditbutton;

	@FindBy(xpath = "//*[@id='site-config-heading-1']/h5/a")
	public WebElement frontEndAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-2']/h5/a")
	public WebElement companyAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-3']/h5/a")
	public WebElement emailAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-4']/h5/a")
	public WebElement passwordAccordion;

	@FindBy(xpath = "//*[@id='site-config-heading-5']/h5/a")
	public WebElement sociallinkAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-6']/h5/a")
	public WebElement googleCaptchaAccordion;
	
	@FindBy(xpath = "//*[@id='site-config-heading-7']/h5/a")
	public WebElement SEOAccordion;
	
	@FindBy(xpath = "//*[@id='company_name']")
	public WebElement CompanyName;

	@FindBy(xpath = "//*[@id='company_address_line1']")
	public WebElement SettingAddress1;

	@FindBy(xpath = "//*[@id='company_address_line2']")
	public WebElement SettingAddress2;

	@FindBy(xpath = "//*[@id='company_city']")
	public WebElement SettingCity;

	@FindBy(xpath = "//*[@id='company_state']")
	public WebElement SettingState;

	@FindBy(xpath = "//*[@id='company_country']")
	public WebElement SettingCountry;

	@FindBy(xpath = "//*[@id='company_zipcode']")
	public WebElement SettingZipcode;

	@FindBy(xpath = "//*[@id='phone']")
	public WebElement Phone;

	@FindBy(xpath = "//*[@id='company_email']")
	public WebElement Email;
	
	@FindBy(xpath = "//*[@id='from_name']")
	public WebElement FromName;

	@FindBy(xpath = "//*[@id='from_email']")
	public WebElement FromEmail ;

	@FindBy(xpath = "//*[@id='admin_email']")
	public WebElement AdminEmail;
	
	@FindBy(xpath = "//*[@id='password_strength']")
	public WebElement PasswordStrength;
	
	@FindBy(xpath = "//*[@id='login_attempt']")
	public WebElement Loginattempt;
	
	@FindBy(xpath = "//*[@id='minimum_password_length']")
	public WebElement Minpwdlength;
	
	@FindBy(xpath = "//*[@id='user_block_time']")
	public WebElement UserBlockTime;
	
	@FindBy(xpath = "//*[@id='facebook_link']")
	public WebElement Facebook;
	
	@FindBy(xpath = "//*[@id='googlemap_embedded']")
	public WebElement Googlemap;
	
	@FindBy(xpath = "//*[@id='twitter_link']")
	public WebElement Twitter;
	
	@FindBy(xpath = "//*[@id='linkedin_link']")
	public WebElement LinkedIn;
	
	@FindBy(xpath = "//*[@id='GOOGLE_RECAPTCHA_KEY']")
	public WebElement GoogleRecaptchaSiteKey;
	
	@FindBy(xpath = "//*[@id='GOOGLE_RECAPTCHA_SECRET']")
	public WebElement GoogleRecaptchaSecertKey;
	
	@FindBy(xpath = "//*[@id='robots_meta_tag']")
	public WebElement RobotsMetaTag;
	
	@FindBy(xpath = "//*[@id='google_analytics_code']")
	public WebElement GoogleAnalyticsCode;
	
	@FindBy(id = "client_name")
	public WebElement AuthorName;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[7]/a")
	public WebElement Testimonialeditbutton;

	@FindBy(xpath = "/html/body/nav/ul/li[6]/div/a[2]")
	public WebElement Settingmenu;

	
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
