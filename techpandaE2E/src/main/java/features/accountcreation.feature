Feature: Testcase - Account Creation

Scenario: Verify you can create account in E-commerce site and can share wishlist to other people using email

Given Launch the techpanda URL
When Click on my account link
And Click create account link and fill new user information except email id
And Click register

And Verify registration is done
And Go to TV menu
And Add product in your wishlist
And Click share wishlist
And In next page enter email and a message and click share wishlist

Then Check wishlist is shared