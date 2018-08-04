package gov.usd.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;

public class SPA_570_TC extends TestBase {

	Actions action = new Actions(Driver.getDriver());

	FederalAccountsPage fap = new FederalAccountsPage();

	HomePage hp = new HomePage();
	
	@Test(priority = 1, description = "Hover over the PROFILE to reach Federal Accounts link")
	public void openFederalAccounts() {

		driver.get(ConfigurationReader.getProperty("urlUSA"));
		
		fap.goProfileGoFederalAccVerUrl();

	}

	@Test(priority = 2, description = "Click on the Managing Agency button, it should sort the results by alphabet or assending order")
	public void managingAgencyFunctionality() {

		BrowserUtils.waitFor(1);

		fap.managingAgency.click();

	}
}
