package gov.usd.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.usd.utilities.Driver;

public class FederalAccountsPage {

	private WebDriver driver;
	public FederalAccountsPage() {

		driver=Driver.getDriver();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//div[@class='nav-dropdown__parent-label'])[2]")
	public WebElement profiles;

	@FindBy(xpath="//ul[@class='nav-children__list']/li/a[.='Federal Accounts']")
	public WebElement profilesFederalAccountsOption;

	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[3]/ul/li[6]/button")
	public WebElement nextPagerBtn;

	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[3]/ul/li[1]/button")
	public WebElement backPagerBtn;

	@FindBy(xpath="//tbody//tr[@class='results-table__row']/td[4]//div//div")
	public List<WebElement> federalBudgetaryResources;

	@FindBy(xpath="//*[contains(text(),'Sort table by ascending 2018 Budgetary Resources')]/..")
	public WebElement clickToGetAssendingOrder;

	@FindBy(xpath="//*[contains(text(),'Sort table by descending 2018 Budgetary Resources')]/..")
	public WebElement clickToGetDecendingOrder;

	public List<Double> convertingToDouble(){
		System.out.println("First size: " + federalBudgetaryResources.size());
		System.out.println("Index: " + federalBudgetaryResources.get(0).getText());
		System.out.println("Index: " + federalBudgetaryResources.get(4).getText());
		System.out.println("Index: " + federalBudgetaryResources.get(5).getText());
		List <Double> prices = new ArrayList<>();
		for(WebElement price : federalBudgetaryResources) {
			String priceStr = price.getText().replace("$", "").replace(",", "");
			if(Double.valueOf(priceStr) == 0)
				prices.add(0d);
			else
				prices.add(Double.valueOf(priceStr));
		}
		System.out.println("Size: " + prices.size());
		return prices;
	}
}
