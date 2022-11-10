Feature: Purchase Products
Scenario: Verify user is able to purchase product using registered email id
Given Launch the techpanda URL
When Click on my account link
And Login in application using previously created credential
And Click on MY WISHLIST link 
And In next page, Click ADD TO CART link
And Enter general shipping country, state/province and zip for the shipping cost estimate
And Click Estimate 
And Verify Shipping cost generated 
And Select Shipping Cost, Update Total 
And Verify shipping cost is added to total 
And Click Proceed to Checkout
And Enter Billing Information, and click Continue
And Enter Shipping Information, and click Continue
And In Shipping Method, Click Continue
And In Payment Information select Check/Money Order radio button. Click Continue
And Click PLACE ORDER button
Then Verify Oder is generated. Note the order number 