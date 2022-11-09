package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ipages.AddCart;

import projectSpecific.base.ProjectSpecificMethods;

public class AddCart_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Verify that cost of product in list page and details page are equal";
		authors = "Amani";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void VerifyCart() throws IOException, InterruptedException {
		node = test.createNode("Verify that you cannot add more product in the cart than available in the store");
		extent.attachReporter(spark);
		new AddCart(driver, node, prop, Environment, StageURL, Stage1URL).
		LaunchURL().
		ClickMobileMenu().
		ADDTOCART().
		UPDATECART().
		VERIFYERRORMESSAGE().
		EMPTYCART().
		VERIFYCART();
	}
}

