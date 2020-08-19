# SeleniumDemo
Demo of Selenium on 8/19/20 for associates

There are 3 examples in this repo:
1. Using Google
2. Using http://the-internet.herokuapp.com/dynamic_controls
3. Using https://www.saucedemo.com/index.html

The `GoogleExample` will give you an idea of how to setup and use Selenium, navigate, select elements and manipulate the browser. Note that the setup
logic was refactored into the `SeleniumUtil` class.

Next, `TheInternetDemo` walks through how to deal with asynchronicity in web applications. It navigates to the right page, clicks the button to remove
the checkbox, waits for it to disappear, clicks it again, waits for it to reappear, and then clicks the checkbox. It uses explicit waits to halt execution
until the proper conditions are met and then queries for the right elements.

Finally, we introduce the Page Object Model design pattern with the saucedemo ecommerce site. We create two page objects - Login and Home Page - that encapsulate elements
and functionality on the page. These page objects can then be manipulated by higher-level classes to automate testing of entire features.

If you want more practice with Selenium, here are some challenges:
* Extend the Google demo to write a web scraper to iteratively visit search result pages (up to a certain depth) and log their URLs
* Extend the Dynamic Controls demo by automating the input box - click the button to enable it and then enter "Hello world!"
* Extend the saucedemo example by testing the checkout and logout features of the application (test that items you click actually appear in the cart)
