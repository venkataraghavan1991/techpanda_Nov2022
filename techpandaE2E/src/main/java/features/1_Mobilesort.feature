Feature: Testcase - Verify Mobile Page

Scenario: Verify item in the Mobile List Page can be sorted by Name
Given Launch the techpanda URL
When Verify Title of the Page
And Click on Mobile menu
And  Verify Title of the Page
And  In the List of all mobiles, select sort by dropdown as name 
Then Verify all the products are sorted by name