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

	HomePage hp = new HomePage();

	ProfilesStatePage psp = new ProfilesStatePage();

	FederalAccountsPage fap = new FederalAccountsPage();

	BrowserUtils br = new BrowserUtils();

	@Test(priority = 1)
	public void verificationTitle() {

		driver.get(ConfigurationReader.getProperty("urlUSA"));

		String currentTitle = ConfigurationReader.getProperty("title");

		String actualTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, actualTitle, "Veriffying current title");
	}

	@Test(priority = 2, description = "Profiles is clickble")
	public void hoverOver() throws InterruptedException {

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesFederalAccountsOption.isDisplayed());

		hp.profilesFederalAccountsOption.click();
	}

	@Test(priority = 3, description = "Verifying federal url")
	public void statesUrl() {

		String expectedUrl = ConfigurationReader.getProperty("urlFederal");

		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actualUrl);

	}

	@Test(priority = 4, description = "Verifying assending and decending order")
	public void sortBudgetaryResources() {

		BrowserUtils.waitFor(4);

		fap.clickToGetAssendingOrder.click();

		BrowserUtils.waitFor(1);

		List<Double> actualFederalBudgetaryResources = fap.convertingToDouble();

		List<Double> expectedFederalBudgetaryResourcesAssending = new ArrayList<>();

		expectedFederalBudgetaryResourcesAssending.addAll(actualFederalBudgetaryResources);

		// System.out.println(actualFederalBudgetaryResources);
		// System.out.println(expectedFederalBudgetaryResourcesAssending);

		Collections.sort(expectedFederalBudgetaryResourcesAssending);

		Assert.assertEquals(expectedFederalBudgetaryResourcesAssending, actualFederalBudgetaryResources);

		fap.clickToGetDecendingOrder.click();

		BrowserUtils.waitFor(1);

		List<Double> actualFederalBudgetaryResources1 = fap.convertingToDouble();

		List<Double> expectedFederalBudgetaryResourcesDescending = new ArrayList<>();

		expectedFederalBudgetaryResourcesDescending.addAll(actualFederalBudgetaryResources1);

		Collections.sort(expectedFederalBudgetaryResourcesDescending);

		Collections.reverse(expectedFederalBudgetaryResourcesDescending);

		// System.out.println(expectedFederalBudgetaryResourcesDescending);
		// System.out.println(actualFederalBudgetaryResources1);

		Assert.assertEquals(expectedFederalBudgetaryResourcesDescending, actualFederalBudgetaryResources1);

	}
}
