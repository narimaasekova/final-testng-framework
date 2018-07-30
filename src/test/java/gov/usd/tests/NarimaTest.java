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

public class NarimaTest extends TestBase{

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
	}@Test(priority=3,description="Verifying state url")
	public void statesUrl(){
		String expectedUrl=ConfigurationReader.getProperty("urlState");
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);

	}

	@Test(priority=4,description="Verifying assending and decending order")
	public void sortAwardedAmount() {
		BrowserUtils.waitFor(4);
		nari.clickToGetAssendingOrder.click();

		List <Double> actualStatesAwardedAmount=nari.convertingToDouble();
		List <Double> expectedStatesAwardedAmountAssending=new ArrayList<>();
		expectedStatesAwardedAmountAssending.addAll(actualStatesAwardedAmount);
		System.out.println(actualStatesAwardedAmount);
		System.out.println(expectedStatesAwardedAmountAssending);
		Collections.sort(expectedStatesAwardedAmountAssending);
		Assert.assertEquals(expectedStatesAwardedAmountAssending,actualStatesAwardedAmount);

		nari.clickToGetDecendingOrder.click();
		List <Double> actualStatesAwardedAmount1=nari.convertingToDouble();
		Collections.reverse(expectedStatesAwardedAmountAssending);
		System.out.println(expectedStatesAwardedAmountAssending);
		Assert.assertEquals(expectedStatesAwardedAmountAssending,actualStatesAwardedAmount1);
	}
}