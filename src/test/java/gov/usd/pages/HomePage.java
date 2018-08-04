package gov.usd.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.usd.utilities.Driver;

public class HomePage {

	private WebDriver driver;

	public HomePage() {

		driver = Driver.getDriver();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[contains(text(),'Profiles')]")
	public WebElement profileMenu;
	
	@FindBy(linkText="States")
	public WebElement profilesStateOption;
	
	@FindBy(xpath="//ul[@class='nav-children__list']/li/a[.='Federal Accounts']")
	public WebElement profilesFederalAccountsOption;

	@FindBy(xpath = "//div[@id='logo']/a")
	public WebElement logo;
	
	@FindBy(xpath = "//ul[@class='full-menu__list']")
	public WebElement mainMenu;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[1]/a")
	public WebElement spendingExplorer;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[3]/div/div/ul/li[1]/a")
	public WebElement agencies;
	
	
}
