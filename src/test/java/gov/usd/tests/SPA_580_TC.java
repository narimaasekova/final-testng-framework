package gov.usd.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.utilities.ConfigurationReader;

public class SPA_580_TC extends TestBase {

	FederalAccountsPage fap = new FederalAccountsPage();

	HomePage hp = new HomePage();

	@Test(priority = 1, description = "Hover over the PROFILE to reach Federal Accounts link")
	public void openFederalAccounts() {

		driver.get(ConfigurationReader.getProperty("urlUSA"));

		fap.goProfileGoFederalAccVerUrl();

	}

	@Test(priority = 2, description = "Check ascending order")
	public void ascending() {
		
		List<Integer> actualList = fap.convertingToInteger();

		List<Integer> expRes = fap.convertingToInteger();

		Collections.sort(expRes);

		fap.descendAccountNumBtn.click();

		extentLogger = report
				.createTest("Before comparing ascending and actual >results from Account Number functionality");

		Assert.assertNotEquals(actualList, expRes);
		
	}
	
	@Test(priority = 3, description = "Check descending order")
	public void descending() {
		
		List<Integer> actualList = fap.convertingToInteger();

		List<Integer> expRes = fap.convertingToInteger();

		Collections.reverse(expRes);
		
		fap.descendAccountNumBtn.click();
	
		Assert.assertEquals(actualList, expRes);
	}
}
