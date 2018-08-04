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

		hp.goHomePageAndVerifyTitle();

	}

	@Test(priority = 2, description = "Check Profile State option")

	public void stateUrl() {
		
		BrowserUtils.waitFor(1);
		hp.goToProfileToStateVerifyUrl();

	}

	@Test(priority = 3, description = "Check number of results")
	public void numberOfResults() {

		BrowserUtils.waitFor(1);

		String resultLeftCorner = psp.LeftCornerResult.getText().replaceAll("[ results]", "");

		String resultCounted = String.valueOf(psp.statesAwardedAmount.size());

		Assert.assertEquals(resultLeftCorner, resultCounted);

	}

}
