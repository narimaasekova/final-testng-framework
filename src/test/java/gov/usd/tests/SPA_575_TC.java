package gov.usd.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;

import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;

public class SPA_575_TC extends TestBase {

	Actions action = new Actions(Driver.getDriver());

	HomePage hp = new HomePage();

	ProfilesStatePage psp = new ProfilesStatePage();

	@Test(priority = 1, description = "Checking the sorter functionality under Percent Total")
	public void titleVerification() {

		// name of the test for the report
		extentLogger = report.createTest("Checking the sorter functionality under Percent Total");

		driver.get(ConfigurationReader.getProperty("urlUSA"));

		// actual title
		String actualTitle = driver.getTitle();

		// expected title
		String expectedTitle = ConfigurationReader.getProperty("title");

		assertEquals(actualTitle, expectedTitle, "Verify title of the home page");

		// name for the verification
		extentLogger.pass("Verified title of the Home Page");

	}

	@Test(priority = 2, description = "Hover over the PROFILE functionality to reach States link")
	public void openState() {

		extentLogger = report.createTest("Hover over the PROFILE functionality to reach States link");

		action.moveToElement(hp.profileMenu).build().perform();

		hp.profilesStateOption.click();

		String actualUrl = driver.getCurrentUrl();

		String expectedUrl = ConfigurationReader.getProperty("urlState");

		assertEquals(actualUrl, expectedUrl, "Verify url of the States page");

		extentLogger.pass("Verify url of the States page");

	}

	@Test(priority = 3, description = "Check after click on arrow button up ascending order")
	public void ascendingOrder() {

		extentLogger = report.createTest("Check after click on arrow button up ascending order"); // report descriptions

		BrowserUtils.waitFor(1); // wait 1 sec before click

		psp.arrowPercentOfTotalUp.click(); // click on arrow button

		List<String> actualResultOfPercent = new ArrayList<>(); // actual list

		// add to actual list all data from webElement
		psp.percentOfTotalAllColumnInfo.stream().forEach(y -> actualResultOfPercent.add(y.getText()));

		List<String> sortedResultOfPercent = new ArrayList<>();

		psp.percentOfTotalAllColumnInfo.stream().forEach(x -> sortedResultOfPercent.add(x.getText()));

		Collections.sort(sortedResultOfPercent);// sorted list

		assertEquals(actualResultOfPercent, sortedResultOfPercent, "verify ascending order");

		extentLogger.pass("Verify ascending order"); // report pass/fail

	}

	@Test(priority = 4, description = "Check after click on arrow button down descending order")
	public void desendingOrder() {

		extentLogger = report.createTest("Check after click on arrow button down descending order"); // report
																										// descriptions

		psp.arrowPercentOfTotalDown.click();

		List<String> actualResultOfPercent = new ArrayList<>();

		psp.percentOfTotalAllColumnInfo.stream().forEach(y -> actualResultOfPercent.add(y.getText()));

		List<String> decendingResultOfPercent = new ArrayList<>();

		psp.percentOfTotalAllColumnInfo.stream().forEach(y -> decendingResultOfPercent.add(y.getText()));

		Collections.sort(decendingResultOfPercent);

		Collections.reverse(decendingResultOfPercent);

		assertEquals(actualResultOfPercent, decendingResultOfPercent);

		extentLogger.pass("Verify descending order"); // report pass/fail

	}

}
