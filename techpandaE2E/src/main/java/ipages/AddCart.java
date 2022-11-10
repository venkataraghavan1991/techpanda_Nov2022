package ipages;

import java.io.IOException;
import java.util.Properties;

//import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class AddCart extends ProjectSpecificMethods {

	public AddCart(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "http://live.techpanda.org/";
	String URL;
	
	String propname = "AddCart/AddCart";
String Expectederrormessage="Some of the products cannot be ordered in requested quantity.";
String Actualerrormessage;
	@Given("Launch the techpanda URL")
	public AddCart LaunchURL() {
		navigateto(url);
		reportStep("techpanda url is launched", "Pass");
		return this;
	}

 @When("Click on Mobile menu")
	public AddCart ClickMobileMenu() throws IOException, InterruptedException {
		click(getprop(propname, "MOBILETAB"));
		waitTime(3000);
		reportStep("Mobile menu is clicked", "Pass");
		return this;
}
 @And("In the list of all mobile,clik on ADD TO CART for sony xperia mobile") 
	 public AddCart  ADDTOCART() throws IOException {
	
		 click(getprop(propname, "ADDTOCART"));
		 waitTime(3000);
		 reportStep("sony xperia Mobile is added to cart", "Pass");
		 
			return this;
	 }
 
@And("Change QTY value to 1000 and click UPDATE button")
 public AddCart UPDATECART() throws IOException{
	//WebElement QTY=driver.findElement(By.xpath("//input[@class='input-text qty']"));
	//clearAndType(QTY,"1000");
	clearAndType(getprop(propname, "QUANTITY"),"1000");
	 click(getprop(propname, "UPDATE"));
	 waitTime(3000);
	 reportStep("Cart is updated to 1000", "Pass");
	 return this;	
	}


@And("Verify the error message")
	public AddCart VERIFYERRORMESSAGE() throws IOException
	{
	Actualerrormessage=getElementText(getprop(propname,"ERRORMESSAGE"));
	 if(Actualerrormessage.equalsIgnoreCase(Expectederrormessage)) {
		 reportStep("Actual error message "+Actualerrormessage+" & Expected error message "+Expectederrormessage+" is matched","pass"); 
	 }
	 else {
		 reportStep("Actual error message "+Actualerrormessage+" & Expected error message "+Expectederrormessage+" is not matched","fail"); 
	 }
	 
	// verifyExactText(getprop(propname,"ERRORMESSAGE"),Expectederrormessage);

    return this;
	}
	@And("Then click on EMPTY CART")  
	public AddCart EMPTYCART() throws IOException{
		click(getprop(propname, "EMPTYCART"));
		 waitTime(3000);
		 reportStep("Shopping Cart is Empty", "Pass");
		 return this;   
	}

	@Then("Verify cart is empty") 
	public AddCart VERIFYCART() throws IOException {
		verifyExactText(getprop(propname,"EMPTYCARTMESSAGE"),"You have no items in your shopping cart.");
		waitTime(3000);
		 return this;  
	}
}