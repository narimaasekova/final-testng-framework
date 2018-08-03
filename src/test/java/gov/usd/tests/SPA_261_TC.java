package gov.usd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.utilities.ConfigurationReader;

public class SPA_261_TC extends TestBase {

	HomePage hp = new HomePage();

	@Test(priority = 1, description = "Home page Title verification")
	public void verifyHomePageTitle() {

		extentLogger = report.createTest("Home page Title verification");

		hp.goHomePageAndVerifyTitle();

		extentLogger.pass("Verified title of the Home Page");
	}

	@Test(priority = 2, description = "Verifing the logo")
	public void logoVerification() {

		extentLogger = report.createTest("Verifing the logo");

		boolean logoVerification = hp.logo.isDisplayed();

		Assert.assertTrue(logoVerification);

		extentLogger.pass("Verify the logo is it displayed");

	}

	@Test(priority = 3, description = "Verifing is the main menu displayed")
	public void mainMenuDisplayed() {

		extentLogger = report.createTest("Verifing is the main menu displayed");

		boolean menuVerification = hp.mainMenu.isDisplayed();

		Assert.assertTrue(menuVerification);

		extentLogger.pass("Verify the main menu with WebElements displayed");

	}
}
