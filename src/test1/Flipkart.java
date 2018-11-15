package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Flipkart {
	
	@Test
	public void testFlipKart(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/hgup22/IdeaProjects/FPP_Automation/src/main/resources/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		WebDriverWait wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//Input[@title='Search for products, brands and more']")));
		driver.findElement(By.name("q")).sendKeys("Laptops");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
		
	}
}
