Feature: Testcase - ADD TO CART

Scenario: Verify that you cannot add more product in cart than the product available in store
Given Launch the techpanda URL
When Click on Mobile menu
And In the List of all mobile, click on 'ADD TO CART' for sony xperia mobile
And Change 'QTY' value to 1000 and click 'UPDATE' button.
And verify the error message
And Then click on "EMPTY CART" link in the footer of list of all mobiles
Then Verify cart is empty