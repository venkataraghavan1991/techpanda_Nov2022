package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ipages.Accountcreation;

import projectSpecific.base.ProjectSpecificMethods;

public class Accountcreation_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Verify you can create account in E-commerce site and can share wishlist to other people using email";
		authors = "Amani";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void VERIFYSHARING() throws IOException, InterruptedException {
		node = test.createNode("Verify you can create account in E-commerce site and can share wishlist to other people using email");
		extent.attachReporter(spark);
		new Accountcreation(driver, node, prop, Environment, StageURL, Stage1URL).
		LaunchURL().
		CLICKACCOUNT().
		CLICKCREATE().
		CLICKREGISTER().
		VERIFYREGISTRATION().
		CLICKTV().
		CLICKADDTOWISHLIST().
		SHAREWISHLIST().
		CLICKSHARE().
		VERIFYWISHLIST();
		
	}
}

