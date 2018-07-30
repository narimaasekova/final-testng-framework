package gov.usd.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.usd.utilities.Driver;

public class HomePageIurii {
	protected WebDriver driver;

	public HomePageIurii() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[contains(text(),'Profiles')]")
	public WebElement profileMenu;
	
	@FindBy(linkText="States")
	public WebElement statesBtn;
	
	
	
}
