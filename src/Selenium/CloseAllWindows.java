package Selenium;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CloseAllWindows {
	static WebDriver driver;

	@Test
	public void test_CloseAllWindowsExceptMainWindow() {
		System.setProperty("webdriver.chrome.driver", "D:\\Hari_Selenium\\Resources\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://www.naukri.com/");
		
		// To get the main window handle
		String windowTitle= getCurrentWindowTitle();
		String mainWindow = getMainWindowHandle(driver);
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Assert.assertTrue(windowTitle.contains("Jobs - Recruitment"), "Main window title is not matching");
	}
		
	public String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	//To close all the other windows except the main window.
	public static boolean closeAllOtherWindows(String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			
				
				driver.switchTo().window(currentWindowHandle);
				System.out.println(driver.getTitle());
				driver.close();
			
		}
		
		

			return true;
	
	}
}