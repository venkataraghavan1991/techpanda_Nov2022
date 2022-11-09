Feature: Testcase - Handling Popup Windows

Scenario: Verify that you are able to compare two product
Given Launch the techpanda URL
When Click on Mobile menu
And In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
And Click on ‘COMPARE’ button. A popup window opens
And Verify the pop-up window and check that the products are reflected in it Heading COMPARE PRODUCTS with selected products in it 
   
Then Close the Popup Windows