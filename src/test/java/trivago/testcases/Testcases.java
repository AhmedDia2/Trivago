package trivago.testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import trivago.pages.Contactpage;
import trivago.pages.Homepage;



public class Testcases {
	
	public WebDriver driver;
	Homepage homepage;
	Contactpage contactpage;
	
	
	@BeforeTest
	public void setup()  //////////initiate browser and open the link
	{
		
		System.setProperty("webdriver.gecko.driver",".\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		homepage = new Homepage(driver);
		contactpage = new Contactpage(driver);
		
		driver.get("http://room5.trivago.com/");	
		driver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void closewindow()
	{
		driver.quit();	
	}
	
	
	@Test(priority=1) ///////////////////////////////////////////////////searching using USA location(TC1)////////////////////////////////////////
	public void Searchlocation () throws InterruptedException  
	{
		homepage.SearchL("USA");
		
		Thread.sleep(3000);
		WebElement SearchResult = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/div[4]/div[1]/div[8]/h3/span"));
		String ActualResult = SearchResult.getText();
		String ExpectedResult = "Search Results";
		
		AssertJUnit.assertEquals(ExpectedResult, ActualResult);
	}
	
	
	@Test(priority=2) //////////////////////////////////////////Contact trivago(TC2)///////////////////////////////////////////////////////////
    public void Contacttrivago () throws InterruptedException
    {
		
		  homepage.Opencontactpage();
                            //////////////////////////////////////Switch Window/////////////////////////
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		          
		          Thread.sleep(9000);
		          contactpage.Contactinfo("Hello Trivago", "Ahmed Diaa", "ahmed.diaa.wasfy@hotmail.com");
		          
		          Thread.sleep(9000);
		          WebElement SuccessMessage = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div/p"));
		          String ActualResult = SuccessMessage.getText();
		          String ExpectedResult = "Message Sent Successfully!";
		          AssertJUnit.assertEquals(ExpectedResult, ActualResult);
		  		  
		          
		         //driver.close(); //closing child window
		         driver.switchTo().window(parentWindow); //cntrl to parent window
		          }
		       }
      }
	
	@Test(priority=3)//////////////////////////////////////////Subscribe Newsletter(TC3)///////////////////////////////////////////////////////////
	public void SubscribeNewsletter() throws InterruptedException
	{
		homepage.Newsletter("ahmed.diaa@hotmail.com");
		Thread.sleep(5000);
		WebElement SuccessMessage = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[6]/section/div/p"));
        String ActualResult = SuccessMessage.getText();
        String ExpectedResult = "You are now checked-in!";
        AssertJUnit.assertEquals(ExpectedResult, ActualResult);
		
	}
	
	@Test(priority=4)//////////////////////////////////////////Select destination(TC4)///////////////////////////////////////////////////////////
	public void NavigateDestination() throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;   ///////////////////to scroll up
		jse.executeScript("window.scrollBy(0,-800)", "");
		Thread.sleep(3000);
		homepage.Navigation();
		Thread.sleep(5000);
		String ActualResult = driver.getCurrentUrl();
        String ExpectedResult = "http://magazine.trivago.com/destination/usa/west/";
        AssertJUnit.assertEquals(ExpectedResult, ActualResult);
		
	}
	
	@Test(priority=5)//////////////////////////////////////////Change Country(TC5)/////////////////////////////////////////////////////////
	public void ChangeCountry() throws InterruptedException
	{
		
		homepage.SelectCountry();
		Thread.sleep(5000);
		String ActualResult = driver.getCurrentUrl();
        String ExpectedResult = "http://magazine.trivago.ca/";
        AssertJUnit.assertEquals(ExpectedResult, ActualResult);
	}
	
	@Test(priority=6)//////////////////////////////////////////Select Themes Budget(TC6)/////////////////////////////////////////////////////////
	public void SelectCouples() throws InterruptedException
	{
		
		homepage.SelectThemesbudget();
		Thread.sleep(5000);
		String ActualResult = driver.getCurrentUrl();
        String ExpectedResult = "http://magazine.trivago.ca/theme/budget/";
        AssertJUnit.assertEquals(ExpectedResult, ActualResult);
	}

}
