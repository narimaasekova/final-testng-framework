package gov.usd.tests;

import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.utilities.Driver;

public class AllTests extends TestBase {

	

		@Test(description="This is example with reports") //short explanation what to test
		public void positiveloginTest() {
			// name of the test
			extentLogger = report.createTest("Positive login7 test"); //for report, use in every test - change the name inside
			
			
			
			Driver.getDriver().get("https://www.google.com");
			
			
			
			
			
			// pass --> message the tells us what passed
			extentLogger.pass("Verified log out link displayed"); //put right name for report
		}
	
	
	
	
}
