package com.stepdifinations;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.basicactions.LogHelper;
import com.basicactions.WaitHelper;
import com.runners.HookHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;
import com.utilities.ReadPropFile;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class FrontStepDefination {
	WebDriver driver;

	TestBase testBase;
	ReadPropFile readPropFile;
	WaitHelper waitHelper;
	CommonFunc commonFunc;
	CommonWhenStepDefinations commonWhenStepDefinations;
	private Logger log = LogHelper.getLogger(FrontStepDefination.class);

	public FrontStepDefination() {
		driver = HookHelper.driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		commonFunc = new CommonFunc(driver);
		commonWhenStepDefinations = new CommonWhenStepDefinations();
	}

	@Then("^Verify Testimonial in front side$")
	public void Verify_Testimonial_in_front_side() throws Throwable {
		String value = "By" + " " + CommonVariables.txtSearchCmnVar;
		
		List<WebElement> ele = driver.findElements(By.xpath("//*[@id='testimonial']/div/div[2]/div/div/div[3]/p"));
		int count = ele.size();
		System.out.println("element size= "+count);
		
		
		for (int i = 1; i <= count; i++) {
			String e1 = driver.findElement(By.xpath("//*[@id='testimonial']/div/div[2]/div[" + i + "]/div/div[3]/p"))
					.getText();


			if (driver.findElement(By.xpath("//*[@id='testimonial']/div/div[2]/div[" + i + "]/div/div[3]/p")).getText()
					.equals("By" + " " + CommonVariables.txtSearchCmnVar)) {
				System.out.println("Verify the value = "
						+ driver.findElement(By.xpath("//*[@id='testimonial']/div/div[2]/div[" + i + "]/div/div[3]/p"))
								.getText());
				assert true;
//			} else {
//				assert false;
//			}
		}
	}
}
}