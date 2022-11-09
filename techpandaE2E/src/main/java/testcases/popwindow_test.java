package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import ipages.Mobilecannotaddcart;
import ipages.popupwindow;
import projectSpecific.base.ProjectSpecificMethods;

public class popwindow_test extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testCaseName = "Verify that you are able to compare two product";
		authors = "Radha";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void tp01_Verifypopupwindow() throws IOException, InterruptedException {
		node = test.createNode("Verify that you are able to compare two product");
		extent.attachReporter(spark);
		new popupwindow(driver, node, prop, Environment, StageURL, Stage1URL).LaunchURL().ClickMobileMenu()
		.ClickAddToCompare().ClickCompare().VerifyProducts().closewindow();
		

}
}