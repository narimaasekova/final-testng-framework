package gov.usd.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.usd.utilities.ConfigurationReader;
import gov.usd.utilities.Driver;

public class FederalAccountsPage {
	
	Actions action=new Actions(Driver.getDriver());
	HomePage hp=new HomePage();

	private WebDriver driver;

	public FederalAccountsPage() {

		driver = Driver.getDriver();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[3]/ul/li[6]/button")
	public WebElement nextPagerBtn;

	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[3]/ul/li[1]/button")
	public WebElement backPagerBtn;

	@FindBy(xpath = "//tbody//tr[@class='results-table__row']/td[4]//div//div")
	public List<WebElement> federalBudgetaryResources;

	@FindBy(xpath = "//*[contains(text(),'Sort table by ascending 2018 Budgetary Resources')]/..")
	public WebElement clickToGetAscendingOrder;

	@FindBy(xpath = "//*[contains(text(),'Sort table by descending 2018 Budgetary Resources')]/..")
	public WebElement clickToGetDescendingOrder;

	@FindBy(xpath = "//div[contains(text(),'Managing Agency')]")
	public WebElement managingAgency;

	@FindBy(xpath = "//div[@class='results-table-cell results-table-cell_column_accountNumber']/div")
	public List<WebElement> accountNumColomn;

	@FindBy(xpath = "//div[contains(text(),'Account Number')]")
	public WebElement accountNumBtn;

	@FindBy(xpath = "//div[@class='header-icons']/button[2]")
	public WebElement descendAccountNumBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Account Name')]")
	public WebElement managingAccountName;
	
	@FindBy(xpath = "//div[@class='results-table-cell results-table-cell_column_accountName']")
	public List<WebElement> accountNameRow;
	

	/*
	 * method to convert String to Integer
	 */
	public List<Integer> convertingToInteger() {
		List<Integer> accountNums = new ArrayList<>();

		for (WebElement price : accountNumColomn) {
			String accNumCol = price.getText().replace("-", "").trim();
			accountNums.add(Integer.valueOf(accNumCol));
		}
		return accountNums;
	}

	/*
	 * method that converting String to double and return List <Double>
	 */
	public List<Double> convertingToDouble() {

		List<Double> prices = new ArrayList<>();
		for (WebElement price : federalBudgetaryResources) {
			String priceStr = price.getText().replace("$", "").replace(",", "");
			if (Double.valueOf(priceStr) == 0)
				prices.add(0d);
			else
				prices.add(Double.valueOf(priceStr));
		}
		System.out.println("Size: " + prices.size());
		return prices;
	}
	
	/*
	 * method hoverover to profile menu and click to Federal Accounts and verify
	 * url
	 */
	
	public void goProfileGoFederalAccVerUrl() {
		
		action.moveToElement(hp.profileMenu).build().perform();

		hp.profilesFederalAccountsOption.click();

		String actualUrl = driver.getCurrentUrl();

		String expectedUrl = ConfigurationReader.getProperty("urlFederal");

		assertEquals(actualUrl, expectedUrl, "Verify url of the Federal Accounts page");
	}

}
