package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ipages.MobilePrice;
import projectSpecific.base.ProjectSpecificMethods;

public class MobilePrice_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Verify that cost of product in list page and details page are equal";
		authors = "Venkat";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void tp01_VerifyMobilePrice() throws IOException, InterruptedException {
		node = test.createNode("Verify that cost of product in list page and details page are equal");
		extent.attachReporter(spark);
		new MobilePrice(driver, node, prop, Environment, StageURL, Stage1URL)
		.launchURL()
		.ClickMobileMenu()
		.readMobileprice()
		.clickonSonyxperia()
		.readSonyxperiaprice()
		.compareprice();
	}

}
