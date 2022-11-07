Feature: Testcase - Verify Mobile Price

Scenario: Verify that cost of product in list page and details page are equal
Given Launch the techpanda URL
When Click on Mobile menu
And In the List of all mobiles read the cost of sony xperia mobile. Save this value 
And Click on Sony xperia Mobile
And Read the Sony xperia mobile price from details page
Then Compare value in product page and details page