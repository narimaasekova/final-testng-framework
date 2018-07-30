package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.NarimaPage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_573_Test extends TestBase {
	
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

	@Test(priority = 4, description = "Verifing assending and decending order of states")
	
	public void sortStates() {
		
		extentLogger = report.createTest("Verifing assending and decending order of states");
		
		BrowserUtils.waitFor(4);
		
	

		List<String> actualStatesAssending = new ArrayList<>();;
		
		List<String> expectedStatesAssending = new ArrayList<>();
		
		nari.states.stream().forEach(x->actualStatesAssending.add(x.getText().trim()));
		
		
		expectedStatesAssending.addAll(actualStatesAssending);
		
			Collections.sort(expectedStatesAssending);
			
		Assert.assertEquals(expectedStatesAssending, actualStatesAssending);
		
		nari.clickToGetDecendingStatesOrder.click();
		
		Collections.reverse(expectedStatesAssending);
		
		Assert.assertEquals(expectedStatesAssending, actualStatesAssending);
		
		extentLogger.pass("Verification of  assending and decending order of states are pass");
	}}

