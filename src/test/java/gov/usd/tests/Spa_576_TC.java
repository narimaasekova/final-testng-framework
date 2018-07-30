package gov.usd.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.NarimaPage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

//TC #3
public class Spa_576_TC extends TestBase{

	NarimaPage nari=new NarimaPage();
	BrowserUtils br=new BrowserUtils();

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
		action.moveToElement(nari.profiles).perform();

		Assert.assertTrue(nari.profilesStateOption.isDisplayed());
		nari.profilesStateOption.click();
	}

	@Test(priority=3,description="Verifying state url")
	public void statesUrl(){
		String expectedUrl=ConfigurationReader.getProperty("urlState");
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
	}

	@Test(priority=4,description="Verifying number of results")
	public void numberOfResults(){
		BrowserUtils.waitFor(4);
		String resultLeftCorner = nari.LeftCornerResult.getText().replaceAll("[ results]", "");
		String resultCounted = String.valueOf(nari.statesAwardedAmount.size());		
		Assert.assertEquals(resultLeftCorner, resultCounted);
	}
}
