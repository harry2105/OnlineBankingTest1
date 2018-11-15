package Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	
	public class LoginPage {
	
		WebDriver driver;
		@FindBy(name="uid")
		WebElement username;
		@FindBy(name="password")
		WebElement password;
		@FindBy(name="btnSubmit")
		WebElement login;
		@FindBy(xpath=".//a[@id='_ctl0__ctl0_HyperLink1']/img")
		WebElement logo;
		@FindBy(xpath=".//div[@id='wrapper']/table/tbody/tr[1]/td")
		List<WebElement> links;
		@FindBy(xpath=".//*[@id='_ctl0__ctl0_Content_Main_message']")
		WebElement errorMessage;
		//By username=By.name("username");
		//By password=By.id("password");
		//By login=By.xpath(".//*[@id='uiv2-loginform']/button");
		
	
		
		public LoginPage(WebDriver driver){
			this.driver=driver;
			 PageFactory.initElements(driver, this);
			
		}
		
		// set username
		public void setUsername(String strUsername){
			
			
			username.clear();
			username.sendKeys(strUsername);
			
		}
			
	// set Password
		public void setPassword(String strPassword){

			password.sendKeys(strPassword);
		
	    }
	// click on login button
		public void clickLogin()
		{
			login.click();
		}
		
	// verify the title
		public String getLoginTitle()
		{
			return driver.getTitle();
		}
		
	//verify the Image on Login Page
		
		
		public String getLogoName()
		
		{
			return logo.getAttribute("src");
		}
		
		

		public String getErrorMessage()
		
		{
			return errorMessage.getText();
		}
		
		
	}
		
		



	

