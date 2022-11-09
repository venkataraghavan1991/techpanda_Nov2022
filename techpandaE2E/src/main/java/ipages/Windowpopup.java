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

public class Windowpopup extends ProjectSpecificMethods {

	public Windowpopup(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "http://live.techpanda.org/";
	String URL;
	
	String propname = "Windowpopup/Windowpopup";
	String mainsony;
	String mainiphone;
	String popupsony;
	String popupiphone;

	@Given("Launch the techpanda URL")
	public Windowpopup LaunchURL() {
		navigateto(url);
		reportStep("techpanda url is launched", "Pass");
		return this;
	}

 @When("Click on Mobile menu")
	public Windowpopup ClickMobileMenu() throws IOException, InterruptedException {
		click(getprop(propname, "MOBILETAB"));
		waitTime(3000);
		reportStep("Mobile menu is clicked", "Pass");
		return this;
}

	@And("In mobile products list , click on Add To Compare for {int} mobiles \\(Sony Xperia & Iphone)") 
	    public Windowpopup CLICKADDTOCOMPARE() throws IOException {
		click(getprop(propname, "ADDTOCOMPARE1"));
		mainsony = getElementText(getprop(propname, "MAINPAGESONY"));
		click(getprop(propname, "ADDTOCOMPARE2"));
		mainiphone = getElementText(getprop(propname, "MAINPAGEIPHONE"));
       return this;
	}
	

	@And("Click on COMPARE button. A popup window opens") 
		 public Windowpopup CLICKCOMPARE() throws IOException {
				click(getprop(propname, "COMPARE"));
			
			    	return this;
	}

	@And("Verify the pop-up window and check that the products are reflected in itHeading COMPARE PRODUCTS with selected products in it.")
	public Windowpopup VERIFYPRODUCTS() throws IOException {
switchToWindow("Products Comparison List - Magento Commerce");
		
verifyExactTextEQLIGNORECASE(getprop(propname, "COMPAREHEADER"),"Compare Products");
		verifyExactText(getprop(propname, "POPUPSONY"),mainsony);
		verifyExactText(getprop(propname, "POPUPIPHONE"),mainiphone);
	
			    	return this;
}

	@Then("Close the Popup Windows")
	public Windowpopup CLOSEWINDOW(){
		driver.close();
		switchToWindow("Mobile");
		//defaultContent();
		driver.close();
		

	return this;  
	}



}
