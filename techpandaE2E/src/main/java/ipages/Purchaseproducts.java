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

public class Purchaseproducts extends ProjectSpecificMethods {

	public Purchaseproducts(RemoteWebDriver driver, ExtentTest node, Properties prop, String Environment, String StageURL, String Stage1URL) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
		this.Environment = Environment;
		this.StageURL = StageURL;
		this.Stage1URL = Stage1URL;
	}

	String url = "http://live.techpanda.org/";
	String propname = "Purchaseproducts/Purchaseproducts";
  
	
	@Given("Launch the techpanda URL")
	public Purchaseproducts LaunchURL() {
		navigateto(url);
		waitTime(3000);
		reportStep("techpanda url is launched", "Pass");
		return this;
	}
	
	@When("Click on my account link")
	public Purchaseproducts CLICKACCOUNT() throws IOException{
		click(getprop(propname, "MYACCOUNT"));
		waitTime(3000);
		reportStep("Account link is clicked", "Pass");
		return this;  
		}
	@And("Login in application using previously created credential")
	public Purchaseproducts LOGINACCOUNT() throws IOException {
		clearAndType(getprop(propname, "EMAILADDRESS"),"amanijanga@gmail.com");
		clearAndType(getprop(propname, "PASSWORD"),"techpanda.com437");
		click(getprop(propname, "LOGIN"));
		waitTime(3000);
		reportStep("User has logged in", "Pass");
		return this;  
		}
	
    @And("Click on MY WISHLIST link")
	public Purchaseproducts MYWISHILIST() throws IOException {
		click(getprop(propname, "MYWISHLIST"));
		waitTime(3000);
		reportStep("clicked on my wishlist", "Pass");
		return this; 
		}

	@And("In next page, Click ADD TO CART link")
	public Purchaseproducts ADDTOCART() throws IOException {
		click(getprop(propname, "ADDTOCART"));
		waitTime(3000);
		reportStep("clicked on Add to cart", "Pass");
		return this; 	
	}
	

	@And("Enter general shipping country, state/province and zip for the shipping cost estimate")
	public Purchaseproducts SHIPPINGESTIMATE() throws IOException {
		//click(getprop(propname, "SHIPPINGCOUNTRY"));
		selectDropDownUsingText(getprop(propname, "SHIPPINGCOUNTRY"),"United States");
		
		selectDropDownUsingText(getprop(propname, "SHIPPINGSTATE"),"New York");
		
	    clearAndType(getprop(propname, "ZIP"),"542896");
		waitTime(3000);
		reportStep("Shipping general details entered for shipping estimation", "Pass");
		return this; 
	}

	@And("Click Estimate")
	public Purchaseproducts CLICKESTIMATE() throws IOException {
		click(getprop(propname, "ESTIMATE"));
		waitTime(3000);
		reportStep("Estimate is clicked", "Pass");
		return this; 
		}
	
	@And("Verify Shipping cost generated")
	public Purchaseproducts VERIFYSHIPPINGCOST() throws IOException {
		verifyDisplayed(getprop(propname,"FLATRATE"));
		verifyDisplayed(getprop(propname,"SHIPPINGCOST"));
		waitTime(3000);
		reportStep("shipping cost has been generated", "Pass");
		return this;
		}
	

	@And("Select Shipping Cost, Update Total")
	public Purchaseproducts UPDATETOTAL() throws IOException {
		verifySelected(getprop(propname, "SELECTSHIPPINGCOST"));
		click(getprop(propname, "UPDATETOTAL"));
		waitTime(3000);
		reportStep("shipping cost updated", "Pass");
		return this;
		}
	

	@And("Verify shipping cost is added to total")
	public Purchaseproducts VERIFYTOTAL() throws IOException {
		String FLATRATE=getElementText(getprop(propname,"SHIPPINGFLATRATE"));
		String SHIPPINGRATE=getElementText(getprop(propname,"SHIPPINGTOTAL"));
		String SUBTOTAL=getElementText(getprop(propname,"SUBTOTALCOST"));
		String GRANDTOTAL=getElementText(getprop(propname,"GRANDTOTALCOST"));
		if(FLATRATE.equalsIgnoreCase(SHIPPINGRATE)) {
			reportStep("shipping cost is added to total", "Pass");	
			reportStep("subtotal cost is "+SUBTOTAL+" shipping cost is "+SHIPPINGRATE+" total cost "+GRANDTOTAL,"pass");
		}
		else {
			reportStep("shipping cost is not added to total", "fail");
		}
	
		return this;	
	}
	@And("Click Proceed to Checkout")
	public Purchaseproducts CLICKPROCEED() throws IOException {
		click(getprop(propname, "PROCEED"));
		waitTime(3000);
		reportStep("proceed to checkout clicked", "Pass");
		return this;
	}
	

	@And("Enter Billing Information, and click Continue")
	public Purchaseproducts BILLINGINFO() throws IOException {
		selectDropDownUsingText(getprop(propname, "BILLINGNEWADRESS"),"New Address");
		clearAndType(getprop(propname, "BILLINGFIRSTNAME"),"AMANI");
		clearAndType(getprop(propname, "BILLINGLASTNAME"),"KOLIPAKA");
		clearAndType(getprop(propname, "BILLINGADRESS"),"ABC");
		clearAndType(getprop(propname, "BILLINGCITY"),"New York");
		selectDropDownUsingText(getprop(propname, "BILLINGSTATE"),"New York");
		clearAndType(getprop(propname, "BILLINGZIP"),"542896");
		selectDropDownUsingText(getprop(propname, "BILLINGCOUNTRY"),"United States");
		clearAndType(getprop(propname, "BILLINGTELEPHONE"),"12345678");
		//click(getprop(propname, "SHIPTODIFFERENTADDRESS"));
		click(getprop(propname, "BILLINGCONTINUE"));
		
		waitTime(3000);
		reportStep("Billing information entered", "Pass");
		return this;
	}	

	@And("Enter Shipping Information, and click Continue")
	public Purchaseproducts SHIPPINGINFO() throws IOException {
		selectDropDownUsingText(getprop(propname, "SHIPPINGDROPDOWN"),"New Address");
		clearAndType(getprop(propname, "SHIPPINGFIRSTNAME"),"AMANI1");
		clearAndType(getprop(propname, "SHIPPINGLASTNAME"),"KOLIPAKA1");
		clearAndType(getprop(propname, "SHIPPINGADRESS"),"ABC1");
		clearAndType(getprop(propname, "SHIPPINGCITY"),"New York");
		selectDropDownUsingText(getprop(propname, "SHIPPINGSTATE1"),"New York");
		clearAndType(getprop(propname, "SHIPPINGZIP"),"542896");
		selectDropDownUsingText(getprop(propname, "SHIPPINGCOUNTRY1"),"United States");
		clearAndType(getprop(propname, "SHIPPINGTELEPHONE"),"12345678");
		click(getprop(propname, "SHIPPINGCONTINUE"));
		waitTime(3000);
		reportStep("Shipping information entered", "Pass");
		return this;
	}
	
@And("In Shipping Method, Click Continue")
public Purchaseproducts CLICKSHIPPINGMETHOD() throws IOException {
	click(getprop(propname, "SHIPPINGMETHODCONTINUE"));
	waitTime(3000);
	reportStep("Shipping method is clicked", "Pass");
	return this;
}


	@And("In Payment Information select Check/Money Order radio button. Click Continue")
	public Purchaseproducts PAYMENT() throws IOException
	{
		click(getprop(propname, "CHECK/MONEY_RADIO"));
		click(getprop(propname, "PAYMENTCONTINUE"));
		waitTime(3000);
		reportStep("Payment is selected and clicked continue", "Pass");
		return this;
	}
	
	

	@And("Click PLACE ORDER button")
	public Purchaseproducts PLACEORDER() throws IOException {
		click(getprop(propname, "PLACEORDER"));
		waitTime(3000);
		reportStep("Place order button clicked", "Pass");
		return this;
		}
	

	@Then("Verify Oder is generated. Note the order number")
	public Purchaseproducts VERIFYORDER() throws IOException {
		verifyExactTextEQLIGNORECASE(getprop(propname,"ORDER"),(getPropfile(propname,"ORDERMESSAGE")));
		
		String ordernumber=getElementText(getprop(propname,"CONFORMATIONNUMBER"));
		waitTime(3000);
		reportStep("Order verified", "Pass");
		return this;	
	}
}


