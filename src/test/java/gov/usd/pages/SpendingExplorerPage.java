package gov.usd.pages;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import gov.usd.utilities.Driver;

	public class SpendingExplorerPage {

		private WebDriver driver;
		public SpendingExplorerPage() {

			driver=Driver.getDriver();

			PageFactory.initElements(driver, this);
		}



		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[2]/div/button")
		public WebElement awardSearchMenu;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[2]/div/div/ul/li[1]/a")
		public WebElement adnvacedSearch;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[2]/div/div/ul/li[2]/a")
		public WebElement keywordSearch;
		
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[3]/div/button")
		public WebElement profilesMenu;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[3]/div/div/ul/li[1]/a")
		public WebElement agencies;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[3]/div/div/ul/li[1]/a")
		public WebElement federalAccounts;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[3]/div/div/ul/li[3]/a")
		public WebElement states;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[3]/div/div/ul/li[4]/a")
		public WebElement recipients;
		
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/button")
		public WebElement downloadCenterMenu;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[1]/a")
		public WebElement awardDataArchive;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[2]/a")
		public WebElement customAwardData;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[3]/a")
		public WebElement customAccountData;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[4]/a")
		public WebElement agencySubmissionFiles;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[5]/a")
		public WebElement databaseDownload;
		
		@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/header/nav/div/div[4]/ul/li[4]/div/div/ul/li[6]/a")
		public WebElement api;
		
		
		@FindBy(xpath="//*[@id=\"header-glossary-button\"]")
		public WebElement glossary;
		
		@FindBy(xpath="//*[@id=\"glossary-title\"]")
		public WebElement glossaryTitle;
		
		
		
	}
	

