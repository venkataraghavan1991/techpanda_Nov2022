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

public class MobilePrice extends ProjectSpecificMethods {

	public MobilePrice(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "";
	String URL;
	
	String propname = "MobilePrice/MobilePrice";
	String pricefromproductpage;
	String pricefromdetailspage;
	
	@Given("Launch the techpanda URL")
	public MobilePrice launchURL()
	{
		navigateto("http://live.techpanda.org/");
		reportStep("techpanda url is launched", "Pass");
		return this;
	}

	@When("Click on Mobile menu")
	public MobilePrice ClickMobileMenu() throws IOException, InterruptedException {
		click(getprop(propname, "Mobiletab"));
		waitTime(3000);
		reportStep("Mobile menu is clicked", "Pass");
		return this;
	    
	}

	@And("In the List of all mobiles read the cost of sony xperia mobile. Save this value")
	public MobilePrice readMobileprice() throws IOException
	{
		pricefromproductpage = getElementText(getprop(propname,"xperiaprice"));
		reportStep("sony xperia mobile is " + pricefromproductpage, "Pass");
		return this;
	}

	@And("Click on Sony xperia Mobile")
	public MobilePrice clickonSonyxperia() throws IOException
	{		
		click(getprop(propname, "xperiamobile"));
		waitTime(3000);
		String title = driver.getTitle();
		if(title.equalsIgnoreCase("Sony Xperia - Mobile")) {
		reportStep("Sony xperia Mobile is clicked", "Pass");}
		else {
		reportStep("Sony xperia Mobile is not clicked", "Fail");
		}
		return this;
	}

	@And("Read the Sony xperia mobile price from details page")
	public MobilePrice readSonyxperiaprice() throws IOException
	{
		pricefromdetailspage = getElementText(getprop(propname,"xperiadetailprice"));
		reportStep("sony xperia mobile is " + pricefromdetailspage, "Pass");
		return this;
	}
	
	
	@Then("Compare value in product page and details page")
	public MobilePrice compareprice()
	{
		if(pricefromdetailspage.equalsIgnoreCase(pricefromproductpage)) {
			reportStep("product page and details page, price are matching", "Pass");}
			else {
			reportStep("product page and details page, price are not matching", "Fail");
			}
		return this;
	}
}
