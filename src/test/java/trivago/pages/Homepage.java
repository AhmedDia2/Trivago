package trivago.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Homepage {

	public WebDriver driver;
	                                 //////////////////////Search Elements
	private By CloseCookies = By.className("Cookie__button");
	private By Searchbtn = By.xpath("/html/body/div[1]/div[1]/header/div/div/div[2]");
	private By Searchstr = By.xpath("/html/body/div[1]/div[1]/header/div/div/div[4]/div[1]/div[2]/input");
	private By Contactbtn = By.xpath("/html/body/div[1]/footer/div[1]/div[2]/div/div[2]/a");
	private By CloseSearch = By.xpath("/html/body/div[1]/div[1]/header/div/div/div[2]");

	                              ////////////////////////Newsletter Elements
	private By NewsletterCHB = By.id("confirm");
	private By Newsletteremail = By.name("email");
	private By Newsletterbtn = By.xpath("/html/body/div[1]/div[3]/div/div[6]/section/div/div/div[2]/div[3]/div[2]/button");
	
                                    ////////////////////////find destination Elements
	private By LeftMenubtn = By.xpath("/html/body/div[1]/div[1]/header/div/div/div[1]/span[2]");
	private By Destination = By.className("destination-menu");
	
	                                ////////////////////////Change language Elements
	private By Dropdownbtn = By.className("locales-dropdown");
	
	private By Themes = By.xpath("/html/body/div[1]/div[1]/header/div/div/div[3]/div/div/div[2]/div[1]/div/div");
	private By Budget = By.className("theme-menu");

	public Homepage (WebDriver driver)
	{
		this.driver = driver;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private WebElement CloseCookiesbtn()
	{
		return driver.findElement(CloseCookies);
	}
	private WebElement ClickSearchbtn()
	{
		return driver.findElement(Searchbtn);
	}
	private WebElement InsertSearhtext()
	{
		return driver.findElement(Searchstr);
	}
	private WebElement Clickcontactbtn()
	{
		return driver.findElement(Contactbtn);
	}
	private WebElement CloseSearchbtn()
	{
		return driver.findElement(CloseSearch);
	}
	
	
	private WebElement NewsletterCHB()
	{
		return driver.findElement(NewsletterCHB);
	}	
	private WebElement NewsletterEmail()
	{
		return driver.findElement(Newsletteremail);
	}	
	private WebElement ClickNewsletterbtn()
	{
		return driver.findElement(Newsletterbtn);
	}
	
	private WebElement ClickLeftMenubtn()
	{
		return driver.findElement(LeftMenubtn);
	}
	private WebElement SelectDestination()
	{
		return driver.findElement(Destination);
	}
	
	private WebElement OpenDropdownlist()
	{
		return driver.findElement(Dropdownbtn);
	}
	
	private WebElement SelectThemes()
	{
		return driver.findElement(Themes);
	}
	private WebElement Selectbudget()
	{
		return driver.findElement(Budget);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void SearchL(String location)
	{
		CloseCookiesbtn().click();
		ClickSearchbtn().click();
		InsertSearhtext().sendKeys(location);
		InsertSearhtext().sendKeys(Keys.ENTER);
		
	}
	
	public void Opencontactpage() throws InterruptedException
	{
		CloseSearchbtn().click();
		Thread.sleep(4000);
		Clickcontactbtn().click();
		
	}
	
	
	public void Newsletter(String NLEmail)
	{
		NewsletterCHB().click();
		NewsletterEmail().sendKeys(NLEmail);
		ClickNewsletterbtn().click();
	}
	
	public void Navigation() throws InterruptedException
	{
		ClickLeftMenubtn().click();
		Thread.sleep(4000);
		SelectDestination().click();
	}
	
	public void SelectCountry()
	{
		Select country = new Select(OpenDropdownlist());
		country.selectByVisibleText("Canada");
	}
	
	public void SelectThemesbudget() throws InterruptedException
	{
		ClickLeftMenubtn().click();
		Thread.sleep(5000);
		SelectThemes().click();
		Thread.sleep(9000);
		Selectbudget().click();
	}
	
	
}
