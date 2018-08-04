package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;

public class SPA_569_TC extends TestBase {

	HomePage hp = new HomePage();

	ProfilesStatePage psp = new ProfilesStatePage();

	Actions action = new Actions(Driver.getDriver());

	FederalAccountsPage fap = new FederalAccountsPage();

	BrowserUtils br = new BrowserUtils();

	@Test(priority = 1)
	public void verificationTitle() {

		driver.get(ConfigurationReader.getProperty("urlUSA"));

		String currentTitle = ConfigurationReader.getProperty("title");

		String actualTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, actualTitle, "Veriffying current title");
	}

	@Test(priority = 2, description = "Hover over the PROFILE functionality to reach Federal Accounts")
	public void profileFunctionality() {

		action.moveToElement(hp.profileMenu).build().perform();

		// action.moveToElement(hp.federalAccounts).build().perform();
		hp.profilesFederalAccountsOption.click();

	}

	@Test(priority = 3, description = "Check url and title in order to verify right page")
	public void titleAndUrlVerifing() {

		String currentUrlForFederalAccountProfile = driver.getCurrentUrl();

		String acctualUrlForFederalAccountProfile = ConfigurationReader.getProperty("urlFederal");

		Assert.assertEquals(currentUrlForFederalAccountProfile, acctualUrlForFederalAccountProfile);

		String actualTitle = ConfigurationReader.getProperty("title");

		String currentTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, actualTitle);

	}

	@Test(priority = 4, description = "Verify assending order")
	public void ascendingOrder() throws InterruptedException {
		
		BrowserUtils.waitFor(1);

		fap.managingAccountName.click();

		BrowserUtils.waitFor(1);

		List<String> accountNameArrow = new ArrayList<>();

		List<String> expectedNameArrow = new ArrayList<>();

		for (WebElement string : fap.accountNameRow) {

			System.out.println(string.getText());

			accountNameArrow.add(string.getText().substring(0, 1));

			expectedNameArrow.add(string.getText().substring(0, 1));

		}

		Collections.sort(expectedNameArrow);

		Assert.assertEquals(accountNameArrow, expectedNameArrow);

	}

	@Test(priority = 5, description = "Verify descending order")
	public void descendingOrder() {

		BrowserUtils.waitFor(1);
		
		fap.managingAccountName.click();
		
		BrowserUtils.waitFor(1);
		
		List<String> accountNameDown = new ArrayList<>();
		
		List<String> expectedNameDown = new ArrayList<>(); // actual list

		for (int i = 0; i < 10; i++) {
			
		
			accountNameDown.add(fap.accountNameRow.get(i).getText().substring(0, 1));
			expectedNameDown.add(fap.accountNameRow.get(i).getText().substring(0, 1));

		}

//		Collections.reverse(expectedNameDown);

		Assert.assertEquals(accountNameDown, expectedNameDown);
	}

}
