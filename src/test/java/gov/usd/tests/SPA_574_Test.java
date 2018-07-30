package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.NarimaPage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_574_Test extends TestBase{
	
NarimaPage nari = new NarimaPage();
	
	BrowserUtils br = new BrowserUtils();

	@Test(priority = 1,description = "Verifing current title")
	
	public void verificationTitle() {
		
		extentLogger = report.createTest("Verifing current title"); 
		
		driver.get(ConfigurationReader.getProperty("urlUSA"));
		
		String currentTitle = ConfigurationReader.getProperty("title");
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(currentTitle, actualTitle, "Verifing current title");
		
		extentLogger.pass("Verification of current title is pass");
	}

	@Test(priority = 2, description = "Profiles is clickble")
	
	public void hoverOver() throws InterruptedException {
		
		extentLogger = report.createTest("Profiles is clickble");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(nari.profiles).perform();

		Assert.assertTrue(nari.profilesStateOption.isDisplayed());
		
		nari.profilesStateOption.click();
		
		extentLogger.pass("Profiles is clickble is pass");
	}

	@Test(priority = 3, description = "Verifing state url")
	
	public void statesUrl() {
		
		extentLogger = report.createTest("Verifing state url");
		
		String expectedUrl = ConfigurationReader.getProperty("urlState");
		
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(expectedUrl, actualUrl);
		
		extentLogger.pass("Verification  state url is pass");

	}

	@Test(priority = 4, description = "Verifing assending and decending order of statesAwardedAmount")
	
	public void sortStatesAwardedAmount() {
		
		extentLogger = report.createTest("Verifing assending and decending order of statesAwardedAmount");
		
		BrowserUtils.waitFor(4);
		
		nari.clickToGetAssendingOrder.click();

		List<Double> actualStatesAwardedAmountAssending = nari.convertingToDouble();
		
		List<Double> expectedStatesAwardedAmountAssending = new ArrayList<>();
		
		expectedStatesAwardedAmountAssending.addAll(actualStatesAwardedAmountAssending);
		
			Collections.sort(expectedStatesAwardedAmountAssending);
			
		Assert.assertEquals(expectedStatesAwardedAmountAssending, actualStatesAwardedAmountAssending);

		nari.clickToGetDecendingOrder.click();
		
		List<Double> actualStatesAwardedAmountDecending = nari.convertingToDouble();
		
		Collections.reverse(expectedStatesAwardedAmountAssending);
		
		System.out.println(expectedStatesAwardedAmountAssending);
		
		Assert.assertEquals(expectedStatesAwardedAmountAssending, actualStatesAwardedAmountDecending);
		
		extentLogger.pass("Verification  assending and decending order are pass");
	}
}

