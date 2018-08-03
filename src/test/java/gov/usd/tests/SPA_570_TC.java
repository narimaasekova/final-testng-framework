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

		extentLogger = report.createTest("Hover over the PROFILE to reach Federal Accounts link");

		driver.get(ConfigurationReader.getProperty("urlUSA"));
		
		fap.goProfileGoFederalAccVerUrl();

		extentLogger.pass("Verify url of the Federal Accounts page");

	}

	@Test(priority = 2, description = "Click on the Managing Agency button, it should sort the results by alphabet or assending order")
	public void managingAgencyFunctionality() throws InterruptedException {

		extentLogger = report.createTest(
				"Click on the Managing Agency button, it should sort the results by alphabet or assending order");

		BrowserUtils.waitFor(1);

		fap.managingAgency.click();

		extentLogger.pass(
				"After clicking on the Managing Agency button, it sorted the results by alphabet or assending order");

	}
}
