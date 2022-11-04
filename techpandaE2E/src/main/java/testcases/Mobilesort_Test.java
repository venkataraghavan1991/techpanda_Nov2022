package testcases;

import org.testng.annotations.Test;

import ipages.Mobilesort;

import java.io.IOException;

import org.testng.annotations.BeforeTest;

import projectSpecific.base.ProjectSpecificMethods;

public class Mobilesort_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Verify item in the Mobile List Page can be sorted by Name";
		authors = "Venkat";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void tp01_VerifyMobilePage() throws IOException, InterruptedException {
		node = test.createNode("Verify item in the Mobile List Page can be sorted by Name");
		extent.attachReporter(spark);
		new Mobilesort(driver, node, prop, Environment, StageURL, Stage1URL)
		.LaunchURL()
		.VerifyHomePageTitle()
		.ClickMobileMenu()
		.VerifyMobilePageTitle()
		.ClickSortasname()
		.Verifysort();
	}

}
