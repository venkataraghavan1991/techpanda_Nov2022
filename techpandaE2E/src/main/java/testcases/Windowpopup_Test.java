package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import ipages.Windowpopup;
import projectSpecific.base.ProjectSpecificMethods;

public class Windowpopup_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Verify that you are able to compare two product";
		authors = "Amani";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void HandlingPopupWindows() throws IOException, InterruptedException {
		node = test.createNode("Verify that you able to compare two product");
		extent.attachReporter(spark);
		new Windowpopup(driver, node, prop, Environment, StageURL, Stage1URL).
		LaunchURL().
		ClickMobileMenu().CLICKADDTOCOMPARE().CLICKCOMPARE().VERIFYPRODUCTS().CLOSEWINDOW();
		
	}
}

