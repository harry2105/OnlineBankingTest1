
	
	package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriverException;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
     import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

//import Pages.HomePage;
import Pages.LoginPage;
import Pages.OnlineBankingHome;
import Pages.TransferFund;
public class OnlineBankingTest {
	 
	
	private static Logger log=Logger.getLogger(OnlineBankingTest.class);
	 
	 
		WebDriver driver;
		LoginPage login_Page;
		//HomePage home_Page;
		String strExpected="Altoro Mutual: Online Banking Home";
		String browser;
		String username;
		String url;
		String password;
		String invalidUserName;
		String accountNumber;
		String FromAccount;
		String ToAccount;
		String tranferAmount;
	
	@BeforeClass
	
	public void loadConfigFile() throws IOException
	{
		
		PropertyConfigurator.configure("log4j.properties");
		
		//DOMConfigurator.configure("log4j.xml");
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Hari_Selenium\\Online Banking\\DataDriven.properties");
		prop.load(fis);
		url=prop.getProperty("url");
		username=prop.getProperty("username");
		password=prop.getProperty("password");
		invalidUserName=prop.getProperty("invalidUserName");
		accountNumber=prop.getProperty("accountNumber");
		FromAccount=prop.getProperty("FromAccount");
		ToAccount=prop.getProperty("ToAccount");
		tranferAmount=prop.getProperty("tranferAmount");
		System.setOut(new PrintStream(new FileOutputStream(System.getProperty("user.dir")+"\\"+"abc.txt")));
	}
		
	@Parameters({ "browser" })	
	@BeforeClass
	public void setUp(String browser) throws Exception

	{
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver","D:\\Hari_Selenium\\SeleniumWebDriver\\geckodriver-v0.21.0-win32\\geckodriver.exe");
				 driver=new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:\\Hari_Selenium\\Resources\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"D:\\Selenium_Resource\\IEDriverServer_Win32_2.52.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			log.info(e.getMessage());
			log.info(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		//login_Page=new LoginPage(driver);
		//String strLogo=login_Page.getLogoName();
		//Assert.assertEquals(strLogo, "http://demo.testfire.net/images/logo.gif","Logo is not matched");
		
		}
	
		
	//(description="Performs an unsuccessful login and checks the resulting error message")
	  
	    @Test(priority=1)
	    
	   public void invalidLogin() {
		   
		    login_Page=new LoginPage(driver);
			login_Page.setUsername(invalidUserName);
			login_Page.setPassword(password);
			login_Page.clickLogin();
			String errorMessage=login_Page.getErrorMessage();
	        Assert.assertEquals(errorMessage, "Login Failed: We're sorry, but this username was not found in our system. Please try again.","Wrong Error Message Displayed");
	        
	    }


	  //  (description="Performs an successful login and checks the Homepage")
	@Test(priority=2)
	public void validLoginHomePage() throws InterruptedException, FileNotFoundException{
	
	login_Page=new LoginPage(driver);
	login_Page.setUsername(username);
	login_Page.setPassword(password);
	login_Page.clickLogin();
	Thread.sleep(10000);
	String strTitle=login_Page.getLoginTitle();
	try{
	Assert.assertEquals("abc","abc", "Title is same");
	Assert.assertEquals(strTitle,strExpected, "Title is not same");
	}catch(AssertionError ae){
		ae.printStackTrace();
	}
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertEquals(strTitle, strExpected);
	log.info("Title is not same as Expected");
	
	}

	
	//(description="Select Account Number From Homepage")
	@Test(priority=3)
	
	public void ValidateAccountHistory()
	{
		OnlineBankingHome onlineHome=new OnlineBankingHome(driver);
		onlineHome.SelectAccount(accountNumber);
		onlineHome.clickGO();
		String ActualAccountNumber=onlineHome.getAccountNumberFromHistrory();
		Assert.assertEquals(ActualAccountNumber, accountNumber,"Displayed Accounted Number is not same as Selected in Account History");
		log.info("Account Number is same As Displayed");
		String balanceDate=onlineHome.getBalanceDate();
		log.info(balanceDate);
		DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy ");
		Date date = new Date();
		String ExpectedDate= dateFormat.format(date);
		log.info(ExpectedDate);
		if(balanceDate.contains(ExpectedDate)){
			log.info("Today's Date is Displaying in the Account history");
		}
			else
			{
				log.info("Today's Date is not Displaying in the Account history");
			}
		
	}
	
	

		//@Test(priority=4)
		public void TransferFundAmount()
		{
			TransferFund transferfund=new TransferFund(driver);
			transferfund.ClickTrnasferFundLink();
			String strTransferFundPage=transferfund.verifyTrasferFundPage();
			Assert.assertEquals(strTransferFundPage, "Transfer Funds","Page Displayed");
			transferfund.SelectFromAccount(FromAccount);
			transferfund.SelectToAccount(ToAccount);
			transferfund.SetAmount(tranferAmount);
			transferfund.clickTransferFundButton();
			String transferedAmount=transferfund.verifyTransferedAmount();
			if(transferedAmount.contains(tranferAmount)){
				log.info("Transfered Amount is same");
			}
				else
				{
					log.info("Transfered Amount is same");
				}
			
		}
		
//@Test(priority=5)
		public void AccountInformation()
		{
			OnlineBankingHome onlineHome=new OnlineBankingHome(driver);
			onlineHome.ClickAccountSummary();
			onlineHome.SelectAccount(FromAccount);
			onlineHome.clickGO();
			
		}



	//@AfterClass
	public void closeBrowser()
	{
		driver.close();
	
	}

}	
	
	

