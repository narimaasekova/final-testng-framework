package gov.usd.tests;



	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import gov.usd.TestBase.TestBase;
	import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;
	import gov.usd.utilities.ConfigurationReader;

	
	public class SPA_572_TC extends TestBase{
		
		FederalAccountsPage fap = new FederalAccountsPage();

		HomePage hp=new HomePage();

	
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

		@Test(priority=3,description="Verifying pager buttons")
		public void pagerButton(){
			
			extentLogger = report.createTest("Verifying pager buttons");
			
			fap.nextPagerBtn.click();
			
			BrowserUtils.waitFor(2);
			
			Assert.assertTrue(fap.backPagerBtn.isEnabled());
			
			extentLogger.pass("Verified pager button up");
			
			fap.backPagerBtn.click();
			
			Assert.assertTrue(!fap.backPagerBtn.isEnabled());
			
			extentLogger.pass("Verified pager button down");
		}
		
	}
	

