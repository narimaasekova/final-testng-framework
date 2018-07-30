package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;


public class AllTests extends TestBase {

	
	HomePage hp = new HomePage();
	Actions action = new Actions(Driver.getDriver());

//	@Ignore
	@Test(priority = 1, description="Launching to the home page")
		public void titleVerification() {
		extentLogger = report.createTest("Launch to the home page");
		//Launch the url
		driver.get(ConfigurationReader.getProperty("url"));
		//Verifing the title
		String actualTitle = ConfigurationReader.getProperty("title");
		String currentTitle = driver.getTitle();	
		Assert.assertEquals(currentTitle, actualTitle);
		extentLogger.pass("Verify the title"); 
	}
	@Ignore
	@Test(priority = 2, description="Verifing the logo")	
		public void logoVerification() {
		
		extentLogger = report.createTest("Verifing the logo");
		//Verifing is the logo displayed
		boolean logoVerification = hp.logo.isDisplayed();
		Assert.assertTrue(logoVerification);
		extentLogger.pass("Verify the logo is it displayed"); 
		
	}
	@Ignore	
	@Test(priority = 3, description="Verifing is the main menu displayed")	
	public void mainMenuDisplayed() {
		extentLogger = report.createTest("Verifing is the main menu displayed");
		//Verifing is the logo displayed
		boolean menuVerification = hp.mainMenu.isDisplayed();
		Assert.assertTrue(menuVerification);
		extentLogger.pass("Verify the main menu with WebElements displayed"); 
//---------------------------------
	}
	@Ignore
	@Test(priority = 4, description="Hover over the PROFILE functionality to reach Federal Accounts")
	public void profileFunctionality() {
		extentLogger = report.createTest("Hover over the PROFILE functionality to reach Federal Accounts");
		//Navigate to Profile then Federal Accounts and click on the last 
		action.moveToElement(hp.profileHoverOver).build().perform();
//		action.moveToElement(hp.federalAccounts).build().perform();
		hp.federalAccounts.click();
		extentLogger.pass("Navigate to Profile then Federal Accounts and click on the last"); 
	}
	@Ignore
	@Test(priority = 5, description="Check url and title in order to verify right page")
	public void titleAndUrlVerifing() {
		extentLogger = report.createTest("Check url in order to verify right page");
		//Asserting url
		String currentUrlForFederalAccountProfile = driver.getCurrentUrl();
		String acctualUrlForFederalAccountProfile = ConfigurationReader.getProperty("federalAccountURL");
		Assert.assertEquals(currentUrlForFederalAccountProfile, acctualUrlForFederalAccountProfile);
		extentLogger.pass("Verify the current url is assert to actual url");
		//Asserting title
		extentLogger = report.createTest("Check title in order to verify right page");
		String actualTitle = ConfigurationReader.getProperty("title");
		String currentTitle = driver.getTitle();	
		Assert.assertEquals(currentTitle, actualTitle);
		extentLogger.pass("Verify the current title is assert to actual title on this page");
	}
	@Ignore
	@Test(priority = 6, description="Click on the Managing Agency button, it should sort the results by alphabet or assending order")
	public void managingAgencyFunctionality() throws InterruptedException {
		extentLogger = report.createTest("Click on the Managing Agency button, it should sort the results by alphabet or assending order");
		Thread.sleep(3000);
		hp.managingAgency.click();
		extentLogger.pass("After clicking on the Managing Agency button, it sorted the results by alphabet or assending order");
//-----------------------
	}
	@Test(priority = 7, description="Hover over the PROFILE functionality to reach Federal Accounts")
	public void sortedFunctionality() {
		extentLogger = report.createTest("Hover over the PROFILE functionality to reach Federal Accounts");
		//Navigate to Profile then Federal Accounts and click on the last 
		action.moveToElement(hp.profileHoverOver).build().perform();
		hp.federalAccounts.click();
		extentLogger.pass("Navigate to Profile then Federal Accounts and click on the last"); 

		//Asserting url
		String currentUrlForFederalAccountProfile = driver.getCurrentUrl();
		String acctualUrlForFederalAccountProfile = ConfigurationReader.getProperty("federalAccountURL");
		Assert.assertEquals(currentUrlForFederalAccountProfile, acctualUrlForFederalAccountProfile);
		extentLogger.pass("Verify the current url is assert to actual url");
		
		//Asserting title
		extentLogger = report.createTest("Check title in order to verify right page");
		String actualTitle = ConfigurationReader.getProperty("title");
		String currentTitle = driver.getTitle();	
		Assert.assertEquals(currentTitle, actualTitle);
		extentLogger.pass("Verify the current title is assert to actual title on this page");
		
		//Checking ascending order
		List<Integer> actualList = hp.convertingToInteger();
		List<Integer> expRes = new ArrayList<>();
		expRes.addAll(actualList);
		Collections.sort(expRes);
	
		hp.descendAccountNumBtn.click();
	
		extentLogger = report.createTest("Before comparing ascending and actual >results from Account Number functionality");
		Assert.assertNotEquals(actualList, expRes);
		extentLogger.pass("After comparing ascending and actual results from Account Number functionality and having result");
		
//		//Checking descending order
//		extentLogger = report.createTest("Before comparing descending and actual >results from Account Number functionality");
//		hp.descendAccountNumBtn.click();
//	
//		Assert.assertEquals(actualList, expRes);
//		extentLogger.pass("After comparing descending and actual results from Account Number functionality and having result");
		
	}
}
