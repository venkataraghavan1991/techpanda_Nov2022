Feature: Save PDF
Scenario: Verify that you will be able to save previously placed order as a pdf file
Given Launch the techpanda URL
When Click on my account link
And Login in application using previously created credential
And Click on My DasShboard
And Click on View Order
And Verify the previously created order is displayed in RECENT ORDERS table and status is Pending
And Click on Print Order link
And Click Change link and a popup will be opened as Select a destination, select Save as PDF link
And Click on Save button and save the file in some location
Then Verify Order is saved as PDF