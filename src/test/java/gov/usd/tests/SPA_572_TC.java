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

	//TC #7
	public class SPA_572_TC extends TestBase{
		
		HomePage hp=new HomePage();

		ProfilesStatePage psp = new ProfilesStatePage();

	
		FederalAccountsPage fap = new FederalAccountsPage();
		

		@Test(priority=1)
		public void verificationTitle() {
			
			driver.get(ConfigurationReader.getProperty("urlUSA"));
			
			String currentTitle=ConfigurationReader.getProperty("title");
			
			String actualTitle=driver.getTitle();
			
			Assert.assertEquals(currentTitle, actualTitle,"Veriffying current title");
		}

		@Test(priority=2,description="Profiles is clickble")
		public void hoverOver() throws InterruptedException {
			
			Actions action=new Actions(driver);
			
			action.moveToElement(hp.profileMenu).perform();

			Assert.assertTrue(hp.profilesStateOption.isDisplayed());
			
			hp.profilesFederalAccountsOption.click();
		}

		@Test(priority=3,description="Verifying federal url")
		public void statesUrl(){
			
			String expectedUrl=ConfigurationReader.getProperty("urlFederal");
			
			String actualUrl=driver.getCurrentUrl();
			
			Assert.assertEquals(expectedUrl, actualUrl);
		}

		@Test(priority=4,description="Verifying pager buttons")
		public void pagerButton(){
			
			fap.nextPagerBtn.click();
			
			BrowserUtils.waitFor(2);
			
			Assert.assertTrue(fap.backPagerBtn.isEnabled());
			
			fap.backPagerBtn.click();
			
			Assert.assertTrue(!fap.backPagerBtn.isEnabled());
		}
	}
	

