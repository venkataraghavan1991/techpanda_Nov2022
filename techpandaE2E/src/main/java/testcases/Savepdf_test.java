package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ipages.Savepdf;
import projectSpecific.base.ProjectSpecificMethods;

public class Savepdf_test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Verify that you will be able to save previously placed order as a pdf file";
		authors = "Amani";
		category = "Smoke";
	}

	@Test(priority = 0)
	public void Savefiletopdf() throws IOException, InterruptedException {
		node = test.createNode("Verify that you will be able to save previously placed order as a pdf file");
		extent.attachReporter(spark);
		new Savepdf(driver, node, prop, Environment, StageURL, Stage1URL).
		LaunchURL().
		CLICKACCOUNT().LOGINACCOUNT().MYORDERS().VIEWORDERS().PRINTORDER();
		}
}
