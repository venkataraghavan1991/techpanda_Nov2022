package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ipages.Purchaseproducts;
import projectSpecific.base.ProjectSpecificMethods;

public class Purchaseproducts_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Verify user is able to purchase product using registered email id";
		authors = "Amani";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void Productspurchase() throws IOException, InterruptedException {
		node = test.createNode("Verify user is able to purchase product using registered email id");
		extent.attachReporter(spark);
		new Purchaseproducts(driver, node, prop, Environment, StageURL, Stage1URL).
		LaunchURL().
		CLICKACCOUNT().
		LOGINACCOUNT().
		MYWISHILIST().
		ADDTOCART().
		SHIPPINGESTIMATE().
		CLICKESTIMATE().VERIFYSHIPPINGCOST().UPDATETOTAL().VERIFYTOTAL().CLICKPROCEED().BILLINGINFO().SHIPPINGINFO().
		CLICKSHIPPINGMETHOD().PAYMENT().PLACEORDER().VERIFYORDER();
		
		
	}
}

