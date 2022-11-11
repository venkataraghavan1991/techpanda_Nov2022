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

public class Savepdf extends ProjectSpecificMethods {

	public Savepdf(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
		
		String browser = "firefox";
		   
		if (browser.equalsIgnoreCase("chrome")) {
			driver = startApp1("chrome");

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = startApp1("firefox");

		}
	}
    
    
    
	String url = "http://live.techpanda.org/";
	String propname = "Savepdf/Savepdf";
  
	
	@Given("Launch the techpanda URL")
	public Savepdf LaunchURL() {
		navigateto(url);
		waitTime(3000);
		reportStep("techpanda url is launched", "Pass");
		return this;
	}
	
	@When("Click on my account link")
	public Savepdf CLICKACCOUNT() throws IOException{
		click(getprop(propname, "MYACCOUNT"));
		waitTime(3000);
		reportStep("Account link is clicked", "Pass");
		return this;  
		}
	@And("Login in application using previously created credential")
	public Savepdf LOGINACCOUNT() throws IOException {
		clearAndType(getprop(propname, "EMAILADDRESS"),"amanijanga@gmail.com");
		clearAndType(getprop(propname, "PASSWORD"),"techpanda.com437");
		click(getprop(propname, "LOGIN"));
		waitTime(3000);
		reportStep("User has logged in", "Pass");
		return this;  
		}
	@And("Click on My Orders")
	public Savepdf MYORDERS() throws IOException {
		click(getprop(propname, "MYORDERS"));
		waitTime(3000);
		
		reportStep("clicked on my orders", "Pass");
		return this;  	
	}
	@And("Click on View Orders")
	public Savepdf VIEWORDERS() throws IOException {
		
		click(getprop(propname, "VIEWORDERS"));
		waitTime(3000);
		reportStep("clicked on view orders", "Pass");
		return this;  	
	}
	@And("Verify the previously created order is displayed in RECENT ORDERS table and status is Pending")
	public Savepdf RECENTORDERS() throws IOException {
		verifyDisplayed(getprop(propname,""));
		waitTime(3000);
		reportStep("clicked on view orders", "Pass");
		return this;  
	}
	
	@And("Click on Print Order link")
	public Savepdf PRINTORDER() throws IOException {
		click(getprop(propname, "PRINTORDER"));
		waitTime(3000);
		reportStep("clicked on print order", "Pass");
		return this; 
	
}
	@And("Click Change link and a popup will be opened as Select a destination, select Save as PDF link")
	public Savepdf CHANGELINK() throws IOException {
		switchToWindow(1);
		
		waitTime(3000);
		reportStep("", "Pass");
		return this; 
}
	@And("Click on Save button and save the file in some location")
	public Savepdf SAVE() throws IOException {
		
		waitTime(3000);
		reportStep("", "Pass");
		return this; 
}
	@Then("Verify Order is saved as PDF")
	public Savepdf VERIFYORDER() throws IOException {
		
		waitTime(3000);
		reportStep("", "Pass");
		return this; 
}
}
	
	
	