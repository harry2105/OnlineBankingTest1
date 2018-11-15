package Selenium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class Testa {
	
	//@Test
	public void google(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hgup22\\IdeaProjects\\FPP_Automation\\src\\main\\resources\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Sapient");
		driver.findElement(By.name("q")).submit();
		List<WebElement> element=driver.findElements(By.xpath(".//h3[@class='r']/a"));
		
		if(element.size()>0){
			
			String name=element.get(0).getText();
			System.out.println(name);
			String[] strActual=name.split("\\s");
			
			Assert.assertEquals(strActual[0], "Publicis.Sapient", "Sapient not found");
			
		}
		
		driver.close();
		
	}
	
	
	//@Test
	public void apiTest(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hgup22\\IdeaProjects\\Online Banking\\src\\main\\resources\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		long start = System.currentTimeMillis();
		WebElement element=driver.findElement(By.id("searchDropdownBox"));
		Select select=new Select(element);
		select.selectByVisibleText("Baby");
		driver.findElement(By.className("nav-input")).click();
		//WebElement header=driver.findElement(By.xpath(".//h1[text()='Baby Products']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Baby Products']")));
		long finish = System.currentTimeMillis();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime); 
		boolean flag=totalTime<60000;
		Assert.assertEquals(flag, true);
		driver.close();
	}
	
//	/@Test
	public void amazonOrder(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hgup22\\IdeaProjects\\Online Banking\\src\\main\\resources\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement element1=driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[2]"));
		WebElement element2=driver.findElement(By.xpath(".//*[@id='nav_prefetch_yourorders']/span"));
		Actions action=new Actions(driver);
		action.moveToElement(element1).build().perform();
		element2.click();
	}
	
	@Test
	public void getList(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hgup22\\IdeaProjects\\FPP_Automation\\src\\main\\resources\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		WebElement element=driver.findElement(By.id("searchDropdownBox"));
		Select select=new Select(element);
		List<WebElement> alloptions=select.getOptions();
		ArrayList<String> a=new ArrayList<String>();
		
		for (WebElement ele:alloptions){
			String text=ele.getText();
			a.add(text);
		}
Collections.sort(a);

for(String k:a){
	System.out.println(k);
}
		

	}
	

	
	//@Test
	public void getListDuplicate(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hgup22\\IdeaProjects\\FPP_Automation\\src\\main\\resources\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		WebElement element=driver.findElement(By.id("searchDropdownBox"));
		Select select=new Select(element);
		List<WebElement> alloptions=select.getOptions();
		HashSet<String> a=new HashSet<String>();
		
		for (WebElement ele:alloptions){
			String text=ele.getText();
			a.add(text);
		}
		
		if (alloptions.size()==a.size()){
			System.out.println("No Duplicate");
		}else{
			System.out.println("Duplicate value is present");
		}
		

	}

}
