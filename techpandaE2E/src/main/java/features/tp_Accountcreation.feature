Feature: Testcase - Account creation
Scenario: Verify you can create account in E-commerce site and can share wishlist to other people using email
Given Launch the techpanda URL
When Click on my account link
And Click create Account link and fill new user information except email ID
And Click Register
And verify registration is done
And GO to TV menu
And Add product in your wishlist
And Click share wishlist
And In next page enter Email and a message and click SHARE WISHLIST
Then Check wishlist is shared