package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import ipages.Mobilecannotaddcart;
import projectSpecific.base.ProjectSpecificMethods;

public class mobilecannotaddtocart_test extends ProjectSpecificMethods {
	@BeforeTest
	public void setValues() {
		testCaseName = "Verify that you cannot add more product in cart than the product available in store";
		authors = "Radha";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void tp01_VerifyMobilecannotaddmoreproducts() throws IOException, InterruptedException {
		node = test.createNode("Verify that you cannot add more product in cart than the product available in store");
		extent.attachReporter(spark);
		new Mobilecannotaddcart(driver, node, prop, Environment, StageURL, Stage1URL)
		.LaunchURL()
		.ClickMobileMenu()
		.ClickAddToCart().AddQty()
		.ChechErrorMess().ClickEmptyCart().MesDispaly();

}
}