package gov.usd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;

public class SPA_261_TC extends TestBase {

	HomePage hp = new HomePage();

	@Test(priority = 1, description = "Home page Title verification")
	public void verifyHomePageTitle() {

		hp.goHomePageAndVerifyTitle();

	}

	@Test(priority = 2, description = "Verifing the logo")
	public void logoVerification() {

		boolean logoVerification = hp.logo.isDisplayed();

		Assert.assertTrue(logoVerification);

	}

	@Test(priority = 3, description = "Verifing is the main menu displayed")
	public void mainMenuDisplayed() {

		boolean menuVerification = hp.mainMenu.isDisplayed();

		Assert.assertTrue(menuVerification);

	}
}
