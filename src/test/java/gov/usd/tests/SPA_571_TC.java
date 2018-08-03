package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_571_TC extends TestBase {

	BrowserUtils br = new BrowserUtils();

	FederalAccountsPage fap = new FederalAccountsPage();

	HomePage hp = new HomePage();

	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Home page Title verification")
	public void verifyHomePageTitle() {

		extentLogger = report.createTest("Home page Title verification");

		hp.goHomePageAndVerifyTitle();

		extentLogger.pass("Verified title of the Home Page");
	}
	

	@Test(priority = 2, description = "Hover over the PROFILE to reach Federal Accounts link")
	public void openFederalAccounts() {

		extentLogger = report.createTest("Hover over the PROFILE to reach Federal Accounts link");
		
		fap.goProfileGoFederalAccVerUrl();

		extentLogger.pass("Verify url of the Federal Accounts page");

	}

	@Test(priority = 3, description = "Check ascending order")
	public void ascending() {

		extentLogger = report.createTest("Check ascending order");

		BrowserUtils.waitFor(1);

		fap.clickToGetAscendingOrder.click();

		BrowserUtils.waitFor(1);

		List<Double> actualFederalBudgetaryResources = fap.convertingToDouble();

		List<Double> expectedFederalBudgetaryResourcesAssending = new ArrayList<>();

		expectedFederalBudgetaryResourcesAssending.addAll(actualFederalBudgetaryResources);

		Collections.sort(expectedFederalBudgetaryResourcesAssending);

		Assert.assertEquals(expectedFederalBudgetaryResourcesAssending, actualFederalBudgetaryResources);

		extentLogger.pass("Verified ascending order");
	}
		
		@Test(priority = 4, description = "Check descending order")
		public void descending() {

		fap.clickToGetDescendingOrder.click();

		BrowserUtils.waitFor(1);

		List<Double> actualFederalBudgetaryResources1 = fap.convertingToDouble();

		List<Double> expectedFederalBudgetaryResourcesDescending = new ArrayList<>();

		expectedFederalBudgetaryResourcesDescending.addAll(actualFederalBudgetaryResources1);

		Collections.sort(expectedFederalBudgetaryResourcesDescending);

		Collections.reverse(expectedFederalBudgetaryResourcesDescending);

		Assert.assertEquals(expectedFederalBudgetaryResourcesDescending, actualFederalBudgetaryResources1);

		extentLogger.pass("Verified descending order");

	}

}
