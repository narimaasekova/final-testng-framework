package gov.usd.tests;



import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.pages.SpendingExplorerPage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;

public class SPA_511_TC extends TestBase {

	Actions action = new Actions(Driver.getDriver());
	
	HomePage hp = new HomePage();
	
	SpendingExplorerPage sep = new SpendingExplorerPage();

	@Test(priority = 1, description = "Launching to the home page")
	public void titleVerification() {

		extentLogger = report.createTest("Launch to the home page");

		// Launch the url
		driver.get(ConfigurationReader.getProperty("urlUSA"));

		// Verifing the title
		String actualTitle = ConfigurationReader.getProperty("title");

		String currentTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, actualTitle);

		extentLogger.pass("Verify the title");
	}

	@Test(priority = 2, description = "Verifying the explorer page")
	public void explorerTitleVerification() {

		extentLogger = report.createTest("Verifying the explorer page");

		// Launch the url
		driver.get(ConfigurationReader.getProperty("urlExplorer"));

		// Verifing the title
		String actualTitle = ConfigurationReader.getProperty("title");

		String currentTitle = driver.getTitle();

		Assert.assertEquals(currentTitle, actualTitle);

		extentLogger.pass("Verifying the explorer page");

	}

	@Test(priority = 3, description = "Hover over the Award Search functionality to reach submenu")
	public void awardMenuDisplayed() {
		
		BrowserUtils.waitFor(1);

		extentLogger = report.createTest("Hover over the Award Search functionality to reach submenu");

		action.moveToElement(sep.awardSearchMenu).build().perform();

		Assert.assertTrue(sep.adnvacedSearch.isDisplayed());
		
		Assert.assertTrue(sep.keywordSearch.isDisplayed());

		extentLogger.pass("Hover over the Award Search functionality to reach submenu");
		

	}
	
	@Test(priority = 4, description = "Hover over the Profiles functionality to reach submenu")
	public void profilesMenuDisplayed() {
		
		BrowserUtils.waitFor(1);
		
		extentLogger = report.createTest("Hover over the Profiles functionality to reach submenu");

		action.moveToElement(sep.profilesMenu).build().perform();

		Assert.assertTrue(sep.agencies.isDisplayed());
		
		Assert.assertTrue(sep.federalAccounts.isDisplayed());
		
		Assert.assertTrue(sep.states.isDisplayed());
		
		Assert.assertTrue(sep.recipients.isDisplayed());

		extentLogger.pass("Hover over the Profiles functionality to reach submenu");

	}
	
	@Test(priority = 5, description = "Hover over the Download Center functionality to reach submenu")
	public void downloadCenterMenuDisplayed() {
		
		BrowserUtils.waitFor(1);

		extentLogger = report.createTest("Hover over the Download Center functionality to reach submenu");

		action.moveToElement(sep.downloadCenterMenu).build().perform();

		Assert.assertTrue(sep.awardDataArchive.isDisplayed());
		
		Assert.assertTrue(sep.customAwardData.isDisplayed());
		
		Assert.assertTrue(sep.agencySubmissionFiles.isDisplayed());
		
		Assert.assertTrue(sep.databaseDownload.isDisplayed());
		
		Assert.assertTrue(sep.api.isDisplayed());

		extentLogger.pass("Hover over the Download Center functionality to reach submenu");

	}
	
	@Test(priority = 6, description = "Hover over the Glossary functionality to reach submenu")
	public void glossaryMenuDisplayed() {
		
		BrowserUtils.waitFor(1);

		extentLogger = report.createTest("Hover over the Glossary functionality to reach submenu");

		sep.glossary.click();
		
		BrowserUtils.waitFor(1);

		Assert.assertTrue(sep.glossaryTitle.isDisplayed());
		
		extentLogger.pass("Hover over the Glossary functionality to reach submenu");

	}
}
