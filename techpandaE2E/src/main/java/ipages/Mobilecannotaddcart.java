package ipages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;


	public class Mobilecannotaddcart extends ProjectSpecificMethods {

		public Mobilecannotaddcart(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
			this.driver = driver;
			this.node = node;
			this.prop = prop;
			this.Environment = Environment;
			this.StageURL = StageURL;
			this.Stage1URL = Stage1URL;
		}

		String url = "";
		String URL;
		
		String propname = "Mpbilecannotaddcart/Mpbilecannotaddcart";

		@Given("Launch the techpanda URL")
		public Mobilecannotaddcart LaunchURL() {
			navigateto("http://live.techpanda.org/");
			reportStep("techpanda url is launched", "Pass");
			return this;
		}

		@When("Click on Mobile menu")
		public Mobilecannotaddcart ClickMobileMenu() throws IOException, InterruptedException {
			click(getprop(propname, "mobiletab"));
			waitTime(3000);
			reportStep("Mobile menu is clicked", "Pass");
			return this;
		}
		@And("In the List of all mobile, click on 'ADD TO CART' for sony xperia mobile")
		public Mobilecannotaddcart ClickAddToCart() throws IOException, InterruptedException {
			click(getprop(propname, "ADDTOCAT"));
			waitTime(3000);
			reportStep("sony xperia mobile Add To Cart is clicked", "Pass");
			return this;
			
		}
		
		@And("Change 'QTY' value to 1000 and click 'UPDATE' button.")
		public Mobilecannotaddcart AddQty() throws IOException, InterruptedException {
			click(getprop(propname, "QTY"));
			driver.findElement(By.xpath("//input[@class='input-text qty']")).sendKeys("1000");
			
			waitTime(3000);
			click(getprop(propname, "UPDATE"));
	     	waitTime(3000);
            reportStep("Update is clicked", "Pass");
			return this;
			
		}
		
		
		@And("verify the error message")
		public Mobilecannotaddcart ChechErrorMess() throws IOException, InterruptedException {
			click(getprop(propname, "ERRORMESSAGE"));
			waitTime(3000);
			reportStep("Got Error Message", "Pass");
			return this;
		}
		
		@And("Then click on \"EMPTY CART\" link in the footer of list of all mobiles")
		public Mobilecannotaddcart ClickEmptyCart() throws IOException, InterruptedException {
			click(getprop(propname, "EMPTYCART"));
			waitTime(3000);
			reportStep("click empty cart", "Pass");
			return this;
		}

		@Then("Verify cart is empty")
		public Mobilecannotaddcart MesDispaly() throws IOException, InterruptedException {
			click(getprop(propname, "CARTISEMPTY"));
			waitTime(3000);
			reportStep("SHOPPING CART IS EMPTY", "Pass");
			return this;
		}
		
	}

