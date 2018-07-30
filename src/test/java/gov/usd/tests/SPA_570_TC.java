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

	HomePage hp=new HomePage();
	
	FederalAccountsPage fap = new FederalAccountsPage();
	
	Actions action = new Actions(Driver.getDriver());
	
	@Test(priority = 1, description = "Hover over the PROFILE functionality to reach Federal Accounts")
	public void profileFunctionality() {
		
		extentLogger = report.createTest("Hover over the PROFILE functionality to reach Federal Accounts");
		// Navigate to Profile then Federal Accounts and click on the last
		
		driver.get(ConfigurationReader.getProperty("urlUSA"));
		
		action.moveToElement(hp.profileMenu).build().perform();
		
		hp.profilesFederalAccountsOption.click();
		
		extentLogger.pass("Navigate to Profile then Federal Accounts and click on the last");
	}


	@Test(priority = 2, description = "Check url and title in order to verify right page")
	public void titleAndUrlVerifing() {
		
		extentLogger = report.createTest("Check url in order to verify right page");
		
		// Asserting url
		String currentUrlForFederalAccountProfile = driver.getCurrentUrl();
		
		String acctualUrlForFederalAccountProfile = ConfigurationReader.getProperty("urlFederal");
		
		Assert.assertEquals(currentUrlForFederalAccountProfile, acctualUrlForFederalAccountProfile);
		
		extentLogger.pass("Verify the current url is assert to actual url");
		
		// Asserting title
		extentLogger = report.createTest("Check title in order to verify right page");
		
		String actualTitle = ConfigurationReader.getProperty("title");
		
		String currentTitle = driver.getTitle();
		
		Assert.assertEquals(currentTitle, actualTitle);
		
		extentLogger.pass("Verify the current title is assert to actual title on this page");
	}


	@Test(priority = 3, description="Click on the Managing Agency button, it should sort the results by alphabet or assending order")
	public void managingAgencyFunctionality() throws InterruptedException {
		
		extentLogger = report.createTest("Click on the Managing Agency button, it should sort the results by alphabet or assending order");
		
		BrowserUtils.waitFor(1);
		
		fap.managingAgency.click();
		
		extentLogger.pass("After clicking on the Managing Agency button, it sorted the results by alphabet or assending order");
	
}
}
