package gov.usd.tests;



import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.AgenciesPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.ConfigurationReader;


public class SPA_536_TC extends TestBase{

	HomePage hp=new HomePage();

	AgenciesPage ap = new AgenciesPage();


	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Title verification")
	public void verificationTitle() {

		extentLogger = report.createTest("Title verification");

		driver.get(ConfigurationReader.getProperty("urlUSA"));

		String currentTitle = ConfigurationReader.getProperty("title");

		String actualTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, actualTitle, "Veriffying current title");

		extentLogger.pass("Verified title of the Home Page");
	}

	@Test(priority = 2, description = "Profiles is clickble")
	public void hoverOver() throws InterruptedException {

		extentLogger = report.createTest("Profiles is clickble");

		Actions action = new Actions(driver);

		action.moveToElement(hp.profileMenu).perform();

		Assert.assertTrue(hp.profilesFederalAccountsOption.isDisplayed());

		extentLogger.pass("Verified Profile of the Home Page");
	}


	@Test(priority = 3, description = "Verifying POT Down Button Active")
	public void potDownButtonActive() {

		extentLogger = report.createTest("Verifying POT Down Button Active");

		hp.agencies.click();

		String buttonActive = "sort-icon active";

		Assert.assertEquals(ap.potDownBtn.getAttribute("class"), buttonActive);

		extentLogger.pass("Verifying POT Down Button Active");

	}


}


