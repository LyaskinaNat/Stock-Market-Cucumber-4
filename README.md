# Automation testing Project for a Simple Stock App
## Introduction
This is a Maven project.  
It uses Cucumber 4 automation testing framework with Selenium.  
It is written in Java using IntelliJ IDE on Apple Mac Platform. 

The test cases are written and executed against the working code running here:  
https://nick-dave-turner.github.io/stock-trade-app/  

Tests can be run as follows:    
1. Running each feature file
2. Running Main runner with specified tag(s) 
3. Execute Maven command mvn test
## Reports
Extend report can be found in test-output/HtmlReport/ExtentHtml.html

## Testing details
There are 43 tests in total, 36 pass and 7 fails.   
All of the test scenarios except one assigned with @regression tag.  

The scenario which doesn't have @regression tag is the test which requires 16 min to run   
(in order to test the following requirement:  
"Calculate Volume Weighted Stock Price based on trades in past 15 minutes")  
It has a unique tag: @longrun. It requires 16 min to run and can be initialised by specifying   
@longrun tag in MainRunnar of the project.  

Feature "Record a trade with timestamp, quantity of shares, buy or sell indicator and traded price" 
has an additional tag: @smoke.  

Tests with @smoke tag are run first to ensure that the most important function(s) of the App work. 
The result of this testing is used to decide if a build is stable enough to proceed with further testing.  

Failed tests:  
1. Dividend yield calculation for the stock of Preferred type (GIN) doesn't match the expected value
2. Calculate Volume Weighted Stock Price based on trades in past 15 minutes - no filtering is done 
before Volume Weighted Stock Price is calculated
3. Check for required Record Trade header (Buy or Sell indicator) is failed: Header is not present
4. Check for required Record Trade data field (Buy or Sell indicator) is failed: Field is not present
5. Check for Recording a trade with missing value (Stock) - edge case is failed: Trade is recorded without Stock Input Value
6. Check for Recording a trade with missing value (Price) - edge case is failed: Trade is recorded without Price Input Value
7. Check for Recording a trade with missing value (Quantity) - edge case is failed: Trade is recorded without Quantity Input Value

"Record trade with Buy or Sell" indicator function is not implemented.   
However, test scenarios and test Step definitions were written with an anticipation that this indicator is present   
and then associated code was commented out (for demonstration purposes).  
