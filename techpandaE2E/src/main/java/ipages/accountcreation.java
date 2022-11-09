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

public class accountcreation extends ProjectSpecificMethods{

	public accountcreation(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "";
	String URL;
	
	String propname = "accountcreation/accountcreation";
	
	//Random randomGenerator = new Random();
	//int randomInt = randomGenerator. nextInt(1000);
	
	@Given("Launch the techpanda URL")
	public accountcreation LaunchURL() {
		navigateto("http://live.techpanda.org/");
		reportStep("techpanda url is launched", "Pass");
		return this;
	}
	
	@When("Click on my account link")
	public accountcreation Clickmyaccount() throws IOException, InterruptedException {
		click(getprop(propname, "MYACCOUNT"));
		waitTime(3000);
		reportStep("My account link is clicked", "Pass");
		return this;
		
	}
		

	@And("Click create account link and fill new user information except email id")
	public accountcreation FillDetails() throws IOException, InterruptedException {
		
		click(getprop(propname, "CREATEANACCOUNT"));
		waitTime(3000);
	

		TextType(getprop(propname, "FIRSTNAME"),"ramu2");
		TextType(getprop(propname, "MIDDLENAME"),"ma");
		TextType(getprop(propname, "LASTNAME"),"pinky2");
		//TextType(getprop(propname, "EMAILADDRESS"),"ramu"+randomInt+"@gmail.com");
		TextType(getprop(propname, "EMAILADDRESS"),"radha89.madhavi@gmail.com");
		TextType(getprop(propname, "PASSWORD"),"Ramum2990");
		TextType(getprop(propname, "CONFIRMPASSWORD"),"Ramum2990");
		click(getprop(propname, "SIGNUP"));
		
		waitTime(1000);
		reportStep("All Details Entered", "Pass");
		waitTime(1000);
		
		return this;	
	
	}
	
	
	@And("Click register")
	public accountcreation ClickReg() throws IOException, InterruptedException {
		click(getprop(propname, "REGISTER"));
		waitTime(3000);
		reportStep("register link is clicked", "Pass");
		return this;
		
	}
	
	
	
	
	@And("Verify registration is done")
	public accountcreation VerifyReg() throws IOException, InterruptedException {
		click(getprop(propname, "VERIFYMSG"));
		verifyExactText(getprop(propname,"VERIFYMSG"),getPropfile(propname,"VERIFYREGISTRATIONMSG"));
		waitTime(3000);
		
		return this;
		
		//verifyExactText(getprop(propname,"VERIFYMSG"),VERIFYREGISTRATIONMSG);
	}
	
	
	
	
	@And("Go to TV menu")
	public accountcreation ClickTv() throws IOException, InterruptedException {
		click(getprop(propname, "TV"));
		waitTime(3000);
		reportStep("TV Menu is clicked", "Pass");
		return this;
		
	}
	@And("Add product in your wishlist")
	public accountcreation ClickWL() throws IOException, InterruptedException {
		click(getprop(propname, "ADDWISHLIST"));
		waitTime(3000);
		reportStep("Wishlist is clicked", "Pass");
		return this;
		
	}
	
	
	@And("Click share wishlist")
	public accountcreation ClickshareWL() throws IOException, InterruptedException {
		click(getprop(propname, "SHAREWISHLIST"));
		waitTime(3000);
		reportStep("Share Wishlist is clicked", "Pass");
		return this;
		
	}
	
	@And("In next page enter email and a message and click share wishlist")
	public accountcreation Clickdetails() throws IOException, InterruptedException {
		//int randomInt = randomGenerator. nextInt(1000);
		TextType(getprop(propname, "EMAILADDSHARE"), "radham@gmail.com");
		TextType(getprop(propname, "MESINSHARE"), "Check this");
		waitTime(1000);
		click(getprop(propname, "SHAREWL"));
		waitTime(1000);
		reportStep("My account link is clicked", "Pass");
		return this;
		
	}
	@Then("Check wishlist is shared")
	public accountcreation CheckMes() throws IOException, InterruptedException {
	
		verifyExactText(getprop(propname,"WLSHARED"),getPropfile(propname,"WLSHAREDMSG"));
		waitTime(3000);
		
		return this;
	
}
}
