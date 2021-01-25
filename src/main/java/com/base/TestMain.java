package com.base;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestMain {

	@Test
	public void getAndVerifyTestNgSuiteName() {
		TestNG runner = new TestNG();
		List<String> suitefiles = new ArrayList<String>();

		runner = new TestNG();
		suitefiles = new ArrayList<String>();
		if (Frame.userAddEditDelete == true) {
			suitefiles.add("Suites/UsersSuite.xml");
		}
		if (Frame.PagesAddEditSaveButton == true) {
			suitefiles.add("Suites/PageSuite.xml");
		}
		if (Frame.ourteamAddEditSaveDeleteButton == true) {
			suitefiles.add("Suites/OurteamSuite.xml");
		}
		if (Frame.eventsAddEditDelete == true) {
			suitefiles.add("Suites/EventsSuite.xml");
		}
		if (Frame.CategoriesAddEditSaveDeleteButton == true) {
			suitefiles.add("Suites/CategoriesSuite.xml");
		}
		if (Frame.blogAddEditSaveDeleteButton == true) {
			suitefiles.add("Suites/BlogSuite.xml");
		}
		if (Frame.fAQsAddEditSaveButton == true) {
			suitefiles.add("Suites/FAQsSuite.xml");
		}
		if (Frame.testimonialAddEditSaveDeleteButton == true) {
			suitefiles.add("Suites/Testimonial.xml");
		}
		if (Frame.contactInquiry == true) {
			suitefiles.add("Suites/ContactUS.xml");
		}
		if (Frame.galleryAddEditDelete == true) {
			suitefiles.add("Suites/Gallery.xml");
			Frame.galleryAddEditDelete = false;
		}
		if (Frame.homeSliderAddEditSaveDelete == true) {
			suitefiles.add("Suites/HomesliderSuite.xml");
			Frame.homeSliderAddEditSaveDelete = false;
		}
		
		if(Frame.multiplecategoriesAED) {
			suitefiles.add("Suites/MultipleCategories.xml");
		}

		runner.setTestSuites(suitefiles);
		runner.run();
	}

}
