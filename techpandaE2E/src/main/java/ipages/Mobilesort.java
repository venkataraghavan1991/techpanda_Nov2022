package ipages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Mobilesort extends ProjectSpecificMethods {

	public Mobilesort(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "";
	String URL;
	
	String propname = "MobileSort/MobileSort";

	@Given("Launch the techpanda URL")
	public Mobilesort LaunchURL() {
		navigateto("http://live.techpanda.org/");
		reportStep("techpanda url is launched", "Pass");
		return this;
	}

	@When("Verify Title of the Page")
	public Mobilesort VerifyHomePageTitle() {
		verifyTitle("Home page");
		reportStep("Title Has been verified", "Pass");
		return this;
	}

	@When("Click on Mobile menu")
	public Mobilesort ClickMobileMenu() throws IOException, InterruptedException {
		click(getprop(propname, "mobiletab"));
		waitTime(3000);
		reportStep("Mobile menu is clicked", "Pass");
		return this;
	}
	
	public Mobilesort VerifyMobilePageTitle() {
		verifyTitle("Mobile");
		reportStep("Title Has been verified", "Pass");
		return this;
	}

	@When("In the List of all mobiles, select sort by dropdown as name")
	public Mobilesort ClickSortasname() throws IOException {
		waitTime(5000);
		selectDropDownUsingText(getprop("MobileSort/MobileSort", "sortdropdown"), "Name");
		reportStep("Dropdown has been selected", "Pass");
		//selectDropDownUsingIndex(driver.findElement(By.xpath("(//select[@title='Sort By'])[1]")), 1);
		return this;
	}

	@Then("Verify all the products are sorted by name")
	public Mobilesort Verifysort() {
		//String[] expected = {"IPHONE", "SAMSUNG GALAXY", "SONY XPERIA"};
		
		List<WebElement> listofproducts= driver.findElements(By.xpath("//*[@class='product-name']"));
		
		String strArry [] = new String[listofproducts.size()];
		for(int i=0;i < listofproducts.size();i++)
		{
			strArry[i]=listofproducts.get(i).getText();
		}
		Arrays.sort(strArry); 
		
//		if (strArry.length != listofproducts.size()) {
//		    System.out.println("fail, wrong number of elements found");
//		}
		
		for (int i = 0; i < strArry.length; i++) {
		    String optionValue = listofproducts.get(i).getText();
		    int j = i+1;
		    if (optionValue.equals(strArry[i])) {
		    	reportStep("Product " +j+ " sorted is Matching with the Expected Text "+ strArry[i] +" and Actual "+ optionValue , "Pass");
		        System.out.println("passed on: " + optionValue);
		    } else {
		    	reportStep("Product " +j+ " sorted did not Match with the Expected Text "+ strArry[i] +" and Actual "+ optionValue , "Fail");
		        System.out.println("failed on: " + optionValue);
		    }
		}
		reportStep("Mobile list is sorted", "Pass");
		return this;
	}
}
