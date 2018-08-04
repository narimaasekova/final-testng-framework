package gov.usd.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import gov.usd.TestBase.TestBase;
import gov.usd.pages.AgenciesPage;
import gov.usd.pages.HomePage;
import gov.usd.pages.ProfilesStatePage;
import gov.usd.utilities.BrowserUtils;
import gov.usd.utilities.ConfigurationReader;

public class SPA_538_TC extends TestBase{
	BrowserUtils br = new BrowserUtils();
	AgenciesPage ap=new AgenciesPage();
		HomePage hp = new HomePage();


		ProfilesStatePage psp = new ProfilesStatePage();

		@Test(priority = 1, description = "Verifing current title")

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

			action.moveToElement(hp.profileMenu).perform();

			Assert.assertTrue(hp.profilesAgenciesOption.isDisplayed());

			hp.profilesAgenciesOption.click();

			extentLogger.pass("Profiles is clickble is pass");
		}

		@Test(priority = 3, description = "Verifing agencies descending order")

		public void agenciesDescendingOrder() {

			extentLogger = report.createTest("Verifing agencies descending order");

			ap.agenciesDescending.click();
			
			List<Double> actuaAgenciesDescending= ap.convertingToDouble(ap.agenciesPercentOfTotalList);
			

			List<Double> expectedAgenciesDescending = new ArrayList<>();
			
	expectedAgenciesDescending.addAll(actuaAgenciesDescending);
			Collections.sort(expectedAgenciesDescending);
			
	Assert.assertEquals(expectedAgenciesDescending, actuaAgenciesDescending);

			extentLogger.pass("Verification  agencies descending order is pass");
	}
		@Test(priority = 4, description = "Verifing agencies ascending order")

		public void agengiesAscendingOrder() throws InterruptedException {

			extentLogger = report.createTest("Verifing agencies ascending order");
			br.wait(5);
			
			List<Double> actuaAgenciesDescending= ap.convertingToDouble(ap.agenciesPercentOfTotalList);
			

			List<Double> expectedAgenciesDescending = new ArrayList<>();
			
	expectedAgenciesDescending.addAll(actuaAgenciesDescending);

			Collections.reverse(expectedAgenciesDescending);
			
	Assert.assertEquals(expectedAgenciesDescending, actuaAgenciesDescending);

			extentLogger.pass("Verification  agencies ascending order is pass");
	}
		//@Test(priority = 4, description = "Verifing agencies descending order")

		public void agengies() {

			extentLogger = report.createTest("Verifing agencies descending order");

			ap.agenciesDescending.click();
			
			//List<Double> actuaAgenciesDescending= ap.convertingToDouble(ap.agenciesDescendingList);
			

			List<Double> expectedAgenciesDescending = new ArrayList<>();
			
	////expectedAgenciesDescending.addAll(actuaAgenciesDescending);

			Collections.sort(expectedAgenciesDescending);
			
	//Assert.assertEquals(expectedAgenciesDescending, actuaAgenciesDescending);

			extentLogger.pass("Verification  agencies descending order is pass");
	}
	}
