package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonXpath {

	@FindBy(xpath = "//input[@id='email']")
	public static WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement password;
	
	@FindBy(xpath = "//*[@id='action_btns']/div/a[3]")
	public static WebElement deletebutton;
	
	@FindBy(xpath = "//*[@id='confirm-action-submit']")
	public static WebElement confirmyesbutton;

	@FindBy(xpath = "//button[@id='dropdownMenu2']")
	public static WebElement profileMainMenu;

	@FindBy(xpath = "//div[@aria-labelledby='dropdownMenu2']/a[1]")
	public static WebElement myProfileMenu;
	
	@FindBy(xpath = "//*[@id='main']/div[3]/form/div/div[2]/div[1]/div/div/div[1]/div/a[3]")
	public static WebElement Slider_DELETE;
	
	@FindBy(xpath = "//*[@id='confirm-slider-delete']")
	public static WebElement Slider_submit;
	
	@FindBy(xpath = "//*[@id='main']/div[3]/form/div/div[2]/div[1]/div/div/div[1]/div/a[3]")
	public static WebElement Gallery_DELETE;
	
	@FindBy(xpath = "//*[@id='main']/div[1]/span")
	public static WebElement Inactive_msg_gallery;
	
	@FindBy(xpath = "//*[@id='action_btns']/div/a[1]")
	public static WebElement Active_button;
	
	@FindBy(xpath = "//*[@id='confirm-gallery-delete']")
	public static WebElement Gallery_Submit;
	
	@FindBy(xpath = "//*[@for='selectAll']")
	public static WebElement Selectcheckbox;
	
	@FindBy(xpath = "//*[@id='action_btns']/div/a[2]")
	public static WebElement Inactive_button;
	
	@FindBy(xpath = "//*[@id='confirm-action-submit']")
	public static WebElement Submit_button;
	
	@FindBy(xpath = "//div[@aria-labelledby='dropdownMenu2']/a[2]")
	public static WebElement changePasswordMenu;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement login;
	
	@FindBy(xpath = "//*[@id='DataTables_Table_0']/thead/tr/th[2]/div")
	public static WebElement selectallcheckbox;
	
	@FindBy(xpath = "//*[@id='main']/div[3]/form/div/div[2]/div[1]/div/div/div[1]/div/a[2]")
	public static WebElement Gallery_Edit;
	
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
	public WebElement MetaTitle;

	@FindBy(id = "meta_desc")
	public WebElement MetaDescription;

	@FindBy(id = "short_bio")
	public WebElement ShortBio;

	@FindBy(xpath = "//body[@id='tinymce']")
	public WebElement Description;
	
	@FindBy(xpath = "//*[@id='meta_description']")
	public WebElement Meta_Description;

	@FindBy(xpath = "//body[@id='tinymce']")
	public WebElement AdditionalBio;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	public WebElement editbutton;

	@FindBy(xpath = "//input[@type='file']")
	public WebElement Image;

	@FindBy(xpath = "//*[@id='image_alt']")
	public WebElement ImageAlt;
	
	@FindBy(xpath = "//*[@id='alt_image_text']")
	public WebElement Slider_ImageAlt;

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
	
	@FindBy(xpath = "//*[@id='search-btn']")
	public WebElement userSearchbutton;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div[1]/form/div/div[1]/input")
	public WebElement usersearchtextbox;

	@FindBy(id = "app_name")
	public WebElement AppName;

	@FindBy(xpath = "//*[@id='contact_title']")
	public WebElement Contact_Title;
	
	@FindBy(xpath = "//*[@id='carouselCaptions']/div[1]/div[1]/div/div/p")
	public WebElement Overlay_Text;

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
	
	@FindBy(xpath = "//*[@id='contact_title']")
	public WebElement Contact_settingTitle;
	
	@FindBy(xpath = "//*[@id='btnsave']")
	public WebElement Contact_Save;
	
	@FindBy(xpath = "//*[@id='contact_thank_you_message']")
	public WebElement Contact_Message;
	
	@FindBy(xpath = "//*[@id='contact_email']")
	public WebElement Contact_email;
	
	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[7]/a")
	public WebElement Settingeditbutton;

	@FindBy(xpath = "//*[@id='site-config-heading-1']/h5/a")
	public WebElement frontEndAccordion;
	
	@FindBy(xpath = "/html/body/nav/ul/li[11]/div/a[2]")
	public WebElement Contactsettingmenu;

	@FindBy(xpath = "//*[@id='site-config-heading-2']/h5/a")
	public WebElement companyAccordion;

	@FindBy(xpath = "//*[@id='site-config-heading-3']/h5/a")
	public WebElement emailAccordion;

	@FindBy(xpath = "//*[@id='site-config-heading-4']/h5/a")
	public WebElement passwordAccordion;

	@FindBy(xpath = "//*[@id='site-config-heading-5']/h5/a")
	public WebElement sociallinkAccordion;
	
	@FindBy(xpath = "//*[@id='normal_btns']/div")
	public WebElement slider_Message;

	@FindBy(xpath = "//*[@id='site-config-heading-6']/h5/a")
	public WebElement googleCaptchaAccordion;

	@FindBy(xpath = "//*[@id='site-config-heading-7']/h5/a")
	public WebElement SEOAccordion;
	
	@FindBy(xpath = "/html/body/main/div[2]/div/div/div/form/h2")
	public WebElement ContactTitle_Home;
	
	@FindBy(xpath = "//*[@id='basic-uploader']/div[3]/table/tbody/tr/td[4]/button[1]")
	public WebElement uploadButton;

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
	public WebElement FromEmail;

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

	@FindBy(xpath = "//*[@id='parent_category']")
	public WebElement BlogCategory;

	@FindBy(id = "author_first_name")
	public WebElement AuthorFirstName;

	@FindBy(id = "author_last_name")
	public WebElement AuthorLastName;

	@FindBy(id = "publish_date")
	public WebElement PublishDate;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[10]/a")
	public WebElement Blogeditbutton;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[7]/div[2]/div[3]/table/tbody/tr[3]/td[2]")
	public WebElement Blogselectdate;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[7]/div[2]/div[2]/table/tbody/tr/td/fieldset[2]/span[5]")
	public WebElement selecttime;
	
	@FindBy(xpath = "//*[@id='display_order_62']/div/div/div[1]/div/a[2]")
	public WebElement slider_hover;
	
	@FindBy(xpath = "//*[@id='overlay_text']")
	public WebElement slider_overlay_Text;
	
	@FindBy(xpath = "//*[@id='alt_image_text']")
	public WebElement slider_image_alt;
	
	@FindBy(xpath = "/html/body/nav/ul/li[7]/div/a[2]")
	public WebElement BlogSettingmenu;
	
	@FindBy(xpath = "//*[@id='carouselCaptions']/div[1]/div[1]/div/div/h3")
	public WebElement Slider_Front_Text;
	
	@FindBy(xpath = "/html/body/nav/ul/li[9]/div/a[2]")
	public WebElement HomeSettingmenu;
	
	@FindBy(xpath = "//*[@id='field_slider_title_display']")
	public WebElement DisplaySlider;
	
	@FindBy(xpath = "//*[@id='btnsave']")
	public WebElement DisplaySlider_save;
	
	@FindBy(xpath = "//*[@id='addimagebtn']")
	public WebElement HomesliderAddbutton;
	
	@FindBy(xpath = "//*[@id='addfiles']/input")
	public WebElement AddFileButton;
	
	@FindBy(xpath = "//*[@id='field_blog_per_page_display']")
	public WebElement Fieldblog;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[2]/div/div[7]/div[2]/div[1]/table/tbody/tr/td/fieldset/span[11]")
	public WebElement time;

	@FindBy(xpath = "//*[@id='main_image_alt']")
	public WebElement BlogImageAlt;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[6]")
	public WebElement date;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr[1]/td[6]/a")
	public WebElement Categorieseditbutton;

	@FindBy(xpath = "//*[@id='question']")
	public WebElement Question;

	@FindBy(xpath = "//*[@id='DataTables_Table_0']/tbody/tr/td[6]/a")
	public WebElement FAQeditbutton;

	@FindBy(xpath = "//body[@id='tinymce']")
	public WebElement Answer;

	@FindBy(xpath = "//*[@id='main']/div[2]/div/div/div[2]/a")
	public WebElement usersMenu;

	@FindBy(xpath = "//*[@id='main']/div[1]/span")
	public WebElement successmsg;
	
	@FindBy(xpath = "//*[@id='search']")
	public WebElement Slider_searchtextbox;
	
	@FindBy(xpath = "//*[@id='search-btn']")
	public WebElement Search_Button;
	
	@FindBy(xpath = "//*[@id='btnsearch']")
	public WebElement Slider_search_button;

	@FindBy(xpath = "//*[@id='frmaddedit']/div[1]/div[1]/h1")
	public WebElement addtitle;

	@FindBy(xpath = "//*[@id='search-btn']")
	public WebElement Homeslider_search;
	
	@FindBy(xpath = "//*[@id='site-config-heading-12']/h5/a")
	public WebElement blogsettingtitle;

	@FindBy(xpath = "//*[@id='site-config-heading-11']/h5/a")
	public WebElement testimonialsettingtitle;

	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]/a[1]/span[1]")
	public WebElement statuscolumn;

	@FindBy(xpath = "//*[@id='current-password']")
	public WebElement currentpwd;

	@FindBy(xpath = "//*[@id='meta_description']")
	public WebElement categories_metadesc;
	
	@FindBy(xpath = "//*[@id='new-password']")
	public WebElement newpwd;
	
	@FindBy(xpath = "//*[@id='password-confirm']")
	public WebElement passwordconfirm;
	
	@FindBy(xpath = "//*[@id='dropdownMenu2']")
	public WebElement profilemenu;
	
	@FindBy(xpath = "/html/body/header/div/div/div[2]/div/div/a[4]")
	public WebElement logoutprofile;
	
	@FindBy(xpath = "/html/body/nav/ul/li[11]/div/a[2]")
	public WebElement contactSetting;
	
	@FindBy(xpath = "//*[@id='frmaddedit']/div[1]/h1")
	public WebElement contactSettingTitle;
	
	@FindBy(xpath = "//*[@id='frmaddedit']/div[1]/h1")
	public WebElement OurteamSettingTitle;
	
	@FindBy(xpath = "//*[@id='comment_moderation']/option[1]")
	public WebElement Commentmoderation;
	
	@FindBy(xpath = "//*[@id='our_team_title']")
	public WebElement OurteamTitle;
	
	@FindBy(xpath = "//*[@id='our_team_sub_title']")
	public WebElement OurteamsubTitle;
	
	@FindBy(xpath = "//*[@id='btnsave']")
	public WebElement OurteamSAVE;
	
	@FindBy(xpath = "/html/body/nav/ul/li[4]/div/a[2]")
	public WebElement OurteamSetting;
	
	
	WebDriver driver;

	public CommonXpath(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
