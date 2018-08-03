package gov.usd.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.FederalAccountsPage;
import gov.usd.pages.HomePage;

import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;

public class SPA_567_TC extends TestBase {

	Actions action = new Actions(Driver.getDriver());

	HomePage hp = new HomePage();

	FederalAccountsPage fap = new FederalAccountsPage();

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

	@Test(priority = 3, description = "Check after click on Account Number btn gives descending order")
	public void descendingOrder() {

		extentLogger = report.createTest("Check after click on Account Number btn gives descending order");

		BrowserUtils.waitFor(1);

		fap.accountNumBtn.click();

		BrowserUtils.waitFor(1);

		List<String> actualResultOfNumber = new ArrayList<>();

		fap.accountNumColomn.stream().forEach(y -> actualResultOfNumber.add(y.getText().substring(0, 3)));

		List<String> reverseResultOfNumber = new ArrayList<>();

		fap.accountNumColomn.stream().forEach(x -> reverseResultOfNumber.add(x.getText().substring(0, 3)));

		Collections.sort(reverseResultOfNumber);

		Collections.reverse(reverseResultOfNumber);

		assertEquals(actualResultOfNumber, reverseResultOfNumber, "verify descending order");

		extentLogger.pass("Verify descending order");

	}

	@Test(priority = 4, description = "Check after click on Account Number btn gives ascending order")
	public void desendingOrder() {

		extentLogger = report.createTest("Check after click on Account Number btn gives ascending order"); // report

		fap.accountNumBtn.click();

		BrowserUtils.waitFor(1);

		List<String> actualResultOfNumber = new ArrayList<>();

		fap.accountNumColomn.stream().forEach(y -> actualResultOfNumber.add(y.getText().substring(0, 3)));

		List<String> sortedResultOfNumber = new ArrayList<>();

		fap.accountNumColomn.stream().forEach(x -> sortedResultOfNumber.add(x.getText().substring(0, 3)));

		Collections.sort(sortedResultOfNumber);

		assertEquals(actualResultOfNumber, sortedResultOfNumber, "verify descending order");

		extentLogger.pass("Verify ascending order"); // report pass/fail

	}

}
