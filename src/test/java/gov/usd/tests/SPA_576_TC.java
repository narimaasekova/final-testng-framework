package gov.usd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;

import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_576_TC extends TestBase {

	BrowserUtils br = new BrowserUtils();

	HomePage hp = new HomePage();

	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Home page Title verification")
	public void verifyHomePageTitle() {

		extentLogger = report.createTest("Home page Title verification");

		hp.goHomePageAndVerifyTitle();

		extentLogger.pass("Verified title of the Home Page");
	}

	@Test(priority = 2, description = "Check Profile State option")

	public void stateUrl() {

		extentLogger = report.createTest("Check Profile State option");

		hp.goToProfileToStateVerifyUrl();

		extentLogger.pass("Verify url of State page");

	}

	@Test(priority = 3, description = "Check number of results")
	public void numberOfResults() {

		extentLogger = report.createTest("Check number of results");

		BrowserUtils.waitFor(1);

		String resultLeftCorner = psp.LeftCornerResult.getText().replaceAll("[ results]", "");

		String resultCounted = String.valueOf(psp.statesAwardedAmount.size());

		Assert.assertEquals(resultLeftCorner, resultCounted);

		extentLogger.pass("Verified number of results");
	}

}
