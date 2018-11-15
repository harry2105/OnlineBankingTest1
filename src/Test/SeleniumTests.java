package Test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class SeleniumTests {

	private static Logger log=Logger.getLogger(SeleniumTests.class);
   

	@Test
    public void testAmazon() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
    	System.setProperty("webdriver.chrome.driver",
				"D:\\Hari_Selenium\\SeleniumWebDriver\\chromedriver_win32 (1)\\chromedriver.exe");
                    WebDriver driver = new ChromeDriver();
                    log.info("Execution started");
                    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    driver.get("http:www.amazon.in");
                    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 10");
                    driver.findElement(By.className("nav-input")).click();
                    driver.findElement(By.xpath("//a[@title='Apple iPhone X (Silver, 256GB)']")).click();
                    WebElement a=driver.findElement(By.linkText("Next Page"));
                   boolean flag=a.isEnabled();
                   log.info(flag);
                   int num=1;
                    while(flag==true){
                    List<WebElement> list=driver.findElements(By.xpath(".//div[@class='a-row a-spacing-none']/a/h2"));
                    log.info(list.size());
                    for(int i=0;i<list.size();i++){
                    	log.info(list.get(i).getText());
                     }
                     a=driver.findElement(By.linkText("Next Page"));
                     flag=a.isEnabled();
                     if(flag==true){
                    	 num=num+1;
                    	 WebElement element =driver.findElement(By.linkText(String.valueOf(num)));
                    	 Actions actions = new Actions(driver);
                    	actions.moveToElement(element).click().perform();
                    	 WebDriverWait wait = new WebDriverWait(driver, 20);
                    	 WebElement element1 =driver.findElement(By.linkText(String.valueOf(num+1)));
                    	 wait.until(ExpectedConditions.elementToBeClickable(element1));
                    	 
                    	 
                     }
                     
                    }

                    driver.close();            
                    
    }
	
	

  //  @Test               

public void findSapientInNewsFeed() throws Exception {
    	System.setProperty("webdriver.chrome.driver",
				"D:\\Hari_Selenium\\SeleniumWebDriver\\chromedriver_win32 (1)\\chromedriver.exe");
    	       ChromeOptions ops = new ChromeOptions();
    	       ops.addArguments("--disable-notifications");
               WebDriver driver = new ChromeDriver(ops);
               driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
               driver.manage().window().maximize();
               driver.get("http://www.facebook.com");
               driver.findElement(By.id(("email"))).sendKeys("haribabu110@gmail.com");
               driver.findElement(By.id("pass")).sendKeys("Gudiya123");
               driver.findElement(By.id("loginbutton")).click();

           

               JavascriptExecutor js = (JavascriptExecutor) driver;

               List<WebElement> sapientElement = driver.findElements(By.xpath("//a[contains(@href, 'Sapient')]"));
               
               //Keep scrolling page till Sapient is found
               while (sapientElement.size() == 0) {
                               js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                               sapientElement = driver.findElements(By.xpath("//a[contains(@href, 'Sapient')]"));
               }
               
               if (sapientElement.size()>0){
            	   for(int i=0;i<sapientElement.size()-1;i++){
            		  log.info(sapientElement.get(i).getText());  
            	   }
               }
               
               driver.close();
}
	

}

