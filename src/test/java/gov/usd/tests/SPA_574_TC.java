package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;

import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;

public class SPA_574_TC extends TestBase {

	BrowserUtils br = new BrowserUtils();

	HomePage hp = new HomePage();

	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Home page Title verification")
	public void verifyHomePageTitle() {

		hp.goHomePageAndVerifyTitle();

	}

	@Test(priority = 2, description = "Check Profile State option")

	public void stateUrl() {

		hp.goToProfileToStateVerifyUrl();


	}

	@Test(priority = 3, description = "Verifing assending and decending order of statesAwardedAmount")

	public void sortStatesAwardedAmount() {

		BrowserUtils.waitFor(1);

		psp.clickToGetAssendingOrder.click();

		List<Double> actualStatesAwardedAmountAssending = psp.convertingToDouble();

		List<Double> expectedStatesAwardedAmountAssending = new ArrayList<>();

		expectedStatesAwardedAmountAssending.addAll(actualStatesAwardedAmountAssending);

		Collections.sort(expectedStatesAwardedAmountAssending);

		Assert.assertEquals(expectedStatesAwardedAmountAssending, actualStatesAwardedAmountAssending);
		
		extentLogger.pass("Verification  assending order are pass");

		psp.clickToGetDecendingOrder.click();

		List<Double> actualStatesAwardedAmountDecending = psp.convertingToDouble();

		Collections.reverse(expectedStatesAwardedAmountAssending);

		System.out.println(expectedStatesAwardedAmountAssending);

		Assert.assertEquals(expectedStatesAwardedAmountAssending, actualStatesAwardedAmountDecending);

	}

}
