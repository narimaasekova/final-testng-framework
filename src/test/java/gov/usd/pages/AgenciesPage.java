package gov.usd.pages;




	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import gov.usd.utilities.Driver;

	public class AgenciesPage {

		private WebDriver driver;
		public AgenciesPage() {

			driver=Driver.getDriver();

			PageFactory.initElements(driver, this);
		}



		@FindBy(xpath="//*[@id=\"agency-landing-results\"]/div/div/table/thead/tr/td[3]/div/div/div/div[2]/button[2]")
		public WebElement potDownBtn;
	
	
}
