package gov.usd.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.usd.utilities.Driver;

public class HomePage {

	WebDriver driver;

	public HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='logo']/a")
	public WebElement logo;

	@FindBy(xpath = "//ul[@class='full-menu__list']")
	public WebElement mainMenu;

	@FindBy(xpath = "//div[contains(text(),'Profiles')]")
	public WebElement profileHoverOver;

	@FindBy(xpath = "//a[contains(@class,'nav-children__link')][contains(text(),'Federal Accounts')]")
	public WebElement federalAccounts;

	@FindBy(xpath = "//a[contains(@class,'nav-children__link')][contains(text(),'Federal Accounts')]")
	public WebElement federalAccountsUrl1;

	@FindBy(xpath = "//div[contains(text(),'Managing Agency')]")
	public WebElement managingAgency;

	@FindBy(xpath = "//div[@class='results-table-cell results-table-cell_column_accountNumber']/div")
	public List<WebElement> accountNumColomn;

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

	@FindBy(xpath = "//div[@class='header-icons']/button[2]")
	public WebElement descendAccountNumBtn;
}
