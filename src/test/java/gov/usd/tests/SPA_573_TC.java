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

public class SPA_573_TC extends TestBase {

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

	@Test(priority = 3, description = "Check ascending order of states")

	public void ascending() {

		List<String> actualStatesAssending = new ArrayList<>();

		List<String> expectedStatesAssending = new ArrayList<>();

		psp.states.stream().limit(9).forEach(x -> actualStatesAssending.add(x.getText()));

		psp.states.stream().limit(9).forEach(x -> expectedStatesAssending.add(x.getText()));

		Collections.sort(expectedStatesAssending);

		Assert.assertEquals(actualStatesAssending,expectedStatesAssending);
		
		
	}
		
	@Test(priority = 4, description = "Check descending order of states")

	public void descending() {

		psp.clickToGetDecendingStatesOrder.click();
		
		List<String> actualStatesAssending = new ArrayList<>();

		List<String> expectedStatesAssending = new ArrayList<>();

		psp.states.stream().limit(9).forEach(x -> actualStatesAssending.add(x.getText().trim()));

		psp.states.stream().limit(9).forEach(x -> expectedStatesAssending.add(x.getText().trim()));

		Collections.reverse(expectedStatesAssending);

		Assert.assertEquals(expectedStatesAssending, actualStatesAssending);
		
	}
}


