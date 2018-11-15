package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestExample {
	
	//@Test
	public void testAmazon(){
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/hgup22/IdeaProjects/FPP_Automation/src/main/resources/Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 10 mobile");
		driver.findElement(By.xpath(".//div[@data-keyword='iphone 10 mobile 128 gb']")).click();
		String value=driver.findElement(By.xpath(".//span[@class='pagnDisabled']")).getText();
		System.out.println(value);
		int count=Integer.parseInt(value);
		for (int i=1;i<=count;i++){
			if(i>2){
			 
				List<WebElement> links=driver.findElements(By.tagName("a"));
				System.out.println(links.size());
				for(WebElement link:links){
					System.out.println(link.getText());
					System.out.println(link.getText()==Integer.toString(i));
					if (link.getText().toString()==Integer.toString(i)){
						String attribute=link.getAttribute("href");
						driver.navigate().to(attribute);
					}
				}
				
				
			}
			
			List<WebElement> list=driver.findElements(By.xpath(".//div[@class='a-row a-spacing-none']/a/h2"));
            System.out.println(list.size());
            for(int j=0;j<list.size();j++){
            	System.out.println(list.get(j).getText());
             }
            
			
	
		}
		
		
}
	
	//driver.close();
	
@Test
	public void facebookScroll(){
		ChromeOptions ops=new ChromeOptions();
		ops.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:/Users/hgup22/IdeaProjects/FPP_Automation/src/main/resources/Driver/chromedriver.exe");	
		WebDriver driver=new ChromeDriver(ops);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("haribabu110@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Gudiya123");
		driver.findElement(By.id("loginbutton")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		List<WebElement> list=driver.findElements(By.xpath(".//a[contains(@href,'Sapient')]"));
		while(list.size()==0){
			js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
			list=driver.findElements(By.xpath(".//a[contains(@href,'Sapient')]"));
			
		}
		
	}

}
