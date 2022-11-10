package ipages;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Accountcreation extends ProjectSpecificMethods {

	public Accountcreation(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "http://live.techpanda.org/";
	
	String propname = "Accountcreation/Accountcreation";

	Random randomGenerator = new Random();
	int randomInt = randomGenerator. nextInt(10000);
	
	
	@Given("Launch the techpanda URL")
	public Accountcreation LaunchURL() {
		navigateto(url);
		waitTime(3000);
		reportStep("techpanda url is launched", "Pass");
		return this;
	}
	
	@When("Click on my account link")
	public Accountcreation CLICKACCOUNT() throws IOException{
		click(getprop(propname, "MYACCOUNT"));
		waitTime(3000);
		reportStep("Account link is clicked", "Pass");
		return this;  
		}
   @And("Click create Account link and fill new user information except email ID")
	public Accountcreation CLICKCREATE() throws IOException{
		click(getprop(propname, "CREATEACCOUNT"));
		
		Type(getprop(propname, "FIRSTNAME"),"AMANI");
		
		Type(getprop(propname, "LASTNAME"),"K");
		

		Type(getprop(propname, "EMAILADDRESS"),"amani"+randomInt+"@gmail.com");
		Type(getprop(propname, "PASSWORD"),"123456abc");
		Type(getprop(propname, "CONFIRMPASSWORD"),"123456abc");
		reportStep("user details filled","pass");
		return this;  
		 }


@And("Click Register")
	public Accountcreation CLICKREGISTER() throws IOException{
	click(getprop(propname, "REGISTER"));
	waitTime(3000);
	reportStep("Register button clicked", "Pass");
	return this;  
	}


@And("verify registration is done")
	public Accountcreation VERIFYREGISTRATION() throws IOException{
	verifyExactText(getprop(propname,"VERIFYREGISTRATION"),getPropfile(propname,"EXPECTEDVERIFYREGISTRATION"));
	
		return this;  
		}


	@And("GO to TV menu")
	public Accountcreation CLICKTV() throws IOException{
		click(getprop(propname, "TV"));
		waitTime(3000);
		reportStep("TV menu clicked", "Pass");
		return this;  
		}


	@And("Add product in your wishlist")
	public Accountcreation CLICKADDTOWISHLIST() throws IOException{
		click(getprop(propname, "ADDTOWISHLIST"));
		waitTime(3000);
		reportStep("clicked on add to wishlist", "Pass");
		return this;  
		}

	@And("Click share wishlist")
	public Accountcreation SHAREWISHLIST() throws IOException{
		click(getprop(propname, "SHAREWISHLIST"));
		waitTime(3000);
		reportStep("clicked on add to wishlist", "Pass");
		return this;  
		}

	@And("In next page enter Email and a message and click SHARE WISHLIST")
	public Accountcreation CLICKSHARE() throws IOException{
		int randomInt = randomGenerator. nextInt(10000);
		Type(getprop(propname, "EMAIL"),"amani"+randomInt+"@gmail.com");
		Type(getprop(propname, "MESSAGE"),"NEW TV");
		click(getprop(propname,"SHAREWISHLIST1"));
		reportStep("email,message has entered and clicked on sharewishlist","pass");
		return this;  
		}


	@Then("Check wishlist is shared")
	public Accountcreation VERIFYWISHLIST() throws IOException{
		verifyExactText(getprop(propname,"VERIFYSHAREWISHLIST"),(getPropfile(propname,"EXPECTEDVERIFYSHAREWISHLIST")));
		return this;  
		}



}
