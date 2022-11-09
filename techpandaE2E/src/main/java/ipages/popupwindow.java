package ipages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class popupwindow extends ProjectSpecificMethods{

	public popupwindow(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "";
	String URL;
	
	String propname = "popupwindow/popupwindow";
String mainsony;
String mainiphone;
String popupsony;
String popupiphone;

	@Given("Launch the techpanda URL")
	public popupwindow LaunchURL() {
		navigateto("http://live.techpanda.org/");
		reportStep("techpanda url is launched", "Pass");
		return this;
	}

	@When("Click on Mobile menu")
	public popupwindow ClickMobileMenu() throws IOException, InterruptedException {
		click(getprop(propname, "mobiletab"));
		waitTime(3000);
		reportStep("Mobile menu is clicked", "Pass");
		return this;
	}
	
	@And("In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)")
	public popupwindow ClickAddToCompare() throws IOException, InterruptedException {
		click(getprop(propname, "ADDTOCOMPARE1"));
		
		mainsony = getElementText(getprop(propname, "MAINSONY"));
		click(getprop(propname, "ADDTOCOMPARE2"));
		mainiphone = getElementText(getprop(propname, "MAINIPHONE"));
		return this;
	}
	@And("Click on ‘COMPARE’ button. A popup window opens")
	public popupwindow ClickCompare() throws IOException, InterruptedException {
		click(getprop(propname, "CLICKCOMPARE"));	
		return this;
	}
	
	
@And("Verify the pop-up window and check that the products are reflected in it Heading COMPARE PRODUCTS with selected products in it")

	
	public popupwindow VerifyProducts() throws IOException, InterruptedException {
			
		switchToWindow("Products Comparison List - Magento Commerce");
		
		verifyExactTextEQLIGNORECASE(getprop(propname, "Comparehedder"),"Compare Products");
		verifyExactText(getprop(propname, "POPUPSONY"),mainsony);
		verifyExactText(getprop(propname, "POPUPIPHONE"),mainiphone);
		
		return this;
}
	
@Then("Close the Popup Windows")
public popupwindow closewindow() throws IOException, InterruptedException {

	driver.close();
	switchToWindow("Mobile");
	driver.close();
	//defaultContent();
	return this;
	
}
}