package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage1 {
	WebDriver driver;

	By username=By.name("uid");
	By password=By.id("passw");
	By login=By.name("btnSubmit");
	By logo=By.xpath("//a[@id='_ctl0__ctl0_HyperLink1']/img");
	By errorMessage=By.id("_ctl0__ctl0_Content_Main_message");
	public LoginPage1(WebDriver driver){
		this.driver=driver;
		}
	
	// set username
	public void setUsername(String strUsername){
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(strUsername);
		
	}
		
// set Password
	public void setPassword(String strPassword){

		driver.findElement(password).sendKeys(strPassword);
	
    }
// click on login button
	public void clickLogin()
	{
		driver.findElement(login).click();
	}
	
// verify the title
	public String getLoginTitle()
	{
		return driver.getTitle();
	}
	
//verify the Image on Login Page
	
	
	public String getLogoName()
	
	{
		return driver.findElement(logo).getAttribute("src");
	}
	
	

	public String getErrorMessage()
	
	{
		return driver.findElement(errorMessage).getText();
	}
	


}
