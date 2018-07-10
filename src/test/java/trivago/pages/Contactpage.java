package trivago.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Contactpage {

public WebDriver driver;
	
	private By Message = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[2]/div/textarea");
	private By FullName = By.xpath("/html/body/div[1]/div[3]/div/div/div[1]/div[3]/div[1]/input");
	private By Email = By.id("contact-email");
	private By Checkbox = By.id("confirm");
	private By Submitbtn = By.className("contact-submit");
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Contactpage (WebDriver driver)
	{
		this.driver = driver;
	}
	private WebElement InsertMessage()
	{
		return driver.findElement(Message);
	}	
	private WebElement InsertFullName()
	{
		return driver.findElement(FullName);
	}	
	private WebElement InsertEmail()
	{
		return driver.findElement(Email);
	}	
	private WebElement ClickCheckbox()
	{
		return driver.findElement(Checkbox);
	}	
	private WebElement ClickSubmitbtn()
	{
		return driver.findElement(Submitbtn);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void Contactinfo (String Message , String Name , String Email)
	{
		InsertMessage().sendKeys(Message);
		InsertFullName().sendKeys(Name);
		InsertEmail().sendKeys(Email);
		ClickCheckbox().click();
		ClickSubmitbtn().click();
		
	}
	

}
