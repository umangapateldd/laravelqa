package com.runners;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.basicactions.LogHelper;
import com.basicactions.WaitHelper;
import com.utilities.ReadPropFile;
import com.utilities.TimeOutWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookHelper {

	public static WebDriver driver;
	TestBase testBase;
	ReadPropFile readPropFile;
	WaitHelper waitHelper;
	Logger log = LogHelper.getLogger(HookHelper.class);

	@Before
	public void setUp() {
		readPropFile = new ReadPropFile();
		readPropFile.readProp();
		testBase = new TestBase();
		log.info("Open " + readPropFile.prop.getProperty("browser").toString()
				+ " browser from reading properties file");
		driver = testBase.launchBrowser(readPropFile.prop.getProperty("browser"));
		log.info("********************Delete all cookies of browser********************");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
//		log.info("********************Make full screen of window********************");
//		driver.manage().window().fullscreen();
		waitHelper = new WaitHelper(driver);
		waitHelper.pageLoadTime(TimeOutWait.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		waitHelper.setImplicitWait(TimeOutWait.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			log.info("********************Take a screenshot of failed scenario********************");
			final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png", "Fail Image"); // ... and embed it in the report.
		}
		log.info("********************Closing the browser********************");
		TestBase.driver.close();
		TestBase.driver.quit();
	}
}
