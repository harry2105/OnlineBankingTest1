package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MarkSpencer {
	
	
	@Test
	public void testWomenLinks(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hgup22\\IdeaProjects\\FPP_Automation\\src\\main\\resources\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.marksandspencer.com/");  
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-analyticsid='#_Women']")));
		WebElement element=	driver.findElement(By.xpath("//a[@data-analyticsid='#_Women']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='content-replace-holder nav-primary__submenu nav-submenu__six-col-gnav']//a"));
		System.out.println(list.size());
	
		for(WebElement e :list){
			System.out.println(e.getText());
		}
	
	
	
		
		
		
	
		
		
	}
	

	
	

}
