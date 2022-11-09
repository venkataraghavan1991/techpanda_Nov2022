package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import ipages.Mobilecannotaddcart;
import ipages.accountcreation;
import projectSpecific.base.ProjectSpecificMethods;

public class accountcreation_test extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testCaseName = "Verify you can create account in E-commerce site and can share wishlist to other people using email";
		authors = "Radha";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void tp01_Verifyaccountcreation() throws IOException, InterruptedException {
		node = test.createNode("Verify you can create account in E-commerce site and can share wishlist to other people using email");
		extent.attachReporter(spark);
		new accountcreation(driver, node, prop, Environment, StageURL, Stage1URL)
		.LaunchURL()
		.Clickmyaccount()
		.FillDetails()
		.ClickReg()
		.VerifyReg()
		.ClickTv()
		.ClickWL()
		.ClickshareWL()
		.Clickdetails()
		.CheckMes();

}
}