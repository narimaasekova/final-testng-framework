package gov.usd.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;

import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

//TC #3
public class SPA_576_TC extends TestBase {

	HomePage hp = new HomePage();

	ProfilesStatePage psp = new ProfilesStatePage();

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

		Assert.assertTrue(hp.profilesStateOption.isDisplayed());
		
		hp.profilesStateOption.click();
	}

	@Test(priority = 3, description = "Verifying state url")
	public void statesUrl() {
		
		String expectedUrl = ConfigurationReader.getProperty("urlState");
		
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(expectedUrl, actualUrl);
	}

	@Test(priority = 4, description = "Verifying number of results")
	public void numberOfResults() {
		
		BrowserUtils.waitFor(4);
		
		String resultLeftCorner = psp.LeftCornerResult.getText().replaceAll("[ results]", "");
		
		String resultCounted = String.valueOf(psp.statesAwardedAmount.size());
		
		Assert.assertEquals(resultLeftCorner, resultCounted);
	}
}
