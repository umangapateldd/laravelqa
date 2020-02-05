package com.basicactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	private WebDriver driver;
	private Logger log = Logger.getLogger(MouseMovement.class);

	public MouseMovement(WebDriver driver) {
		this.driver = driver;
		log.info("********************Created MouseMovement Object********************");
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		log.info("********************Mouse hovering on the element********************");
	}

	public void mouseHoverClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		log.info("********************Clicked on mouse hovering on the element********************");
	}

	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().perform();
		log.info("********************Doubleclick on mouse hovering on the element********************");
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		log.info("********************Dragged and dropped********************");
	}

}
