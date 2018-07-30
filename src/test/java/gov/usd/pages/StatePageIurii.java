package gov.usd.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.usd.utilities.Driver;

public class StatePageIurii {
	
	protected WebDriver driver;
	
	public StatePageIurii() {
		
		this.driver=Driver.getDriver();
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Sort table by ascending percent of total')]/..")
	public WebElement arrowPercentOfTotalUp;
	
	@FindBy(xpath="//*[contains(text(),'Sort table by descending percent of total')]/..")
	public WebElement arrowPercentOfTotalDown;
	
	@FindBy(xpath="//tr[@class='state-list__body-row']/td[3]")
	public List<WebElement> percentOfTotalAllColumnInfo;
	
	
	
	
	
}
