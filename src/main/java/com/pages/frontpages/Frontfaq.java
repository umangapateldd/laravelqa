package com.pages.frontpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.basicactions.DropDownHelper;
import com.basicactions.LogHelper;
import com.utilities.CommonFunc;
import com.utilities.CommonVariables;

public class Frontfaq {

	WebDriver driver;
	DropDownHelper dropDownHelper;
	CommonFunc commonFunc;
	CommonVariables commonVariables;
	private Logger log = LogHelper.getLogger(Frontfaq.class);
	boolean verifyDetails = false;

	public Frontfaq(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		dropDownHelper = new DropDownHelper(driver);
	}
	public void verifyFAQtitle() {
		log.info("********************Enter the Title********************");

		List<WebElement> ele = driver.findElements(By.xpath("//*[@id='testimonial']/div/div[2]/div/div/div[3]/p"));
		int count = ele.size();
		System.out.println("element size= " + count);
		int tmp = 1;
		
			for (int i = 1; i <= count; i++) {

				if (driver.findElement(By.xpath("//*[@id='testimonial']/div/div[2]/div[" + i + "]/div/div[3]/p"))
						.getText().equals("By" + " " + CommonVariables.txtSearchCmnVar)) {
					System.out.println("Verify the value = " + driver
							.findElement(By.xpath("//*[@id='testimonial']/div/div[2]/div[" + i + "]/div/div[3]/p"))
							.getText());
					tmp = 0;
					break;
				}
			}

			if (tmp == 0) {

			} else {

				assert false;
			}
		}
	}

}
