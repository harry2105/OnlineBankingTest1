package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OnlineBankingHome {
	
	
	WebDriver driver;
	@FindBy(id="listAccounts")
	WebElement AccountList;
	@FindBy(id="btnGetAccount")
	WebElement btnGo;
	@FindBy(id="_ctl0__ctl0_Content_Main_accountid")
	WebElement AccountNumber;
	@FindBy(xpath="//td[contains(text(),'Ending balance as of')]")
	WebElement BalanceDate;
	@FindBy(linkText="View Account Summary")
	WebElement AccountSummary;
	//By username=By.name("username");
	//By password=By.id("password");
	//By login=By.xpath(".//*[@id='uiv2-loginform']/button");
	
	public OnlineBankingHome(WebDriver driver){
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		
	}
	
	
	public void SelectAccount(String accNumber){
		
		Select selection=new Select(AccountList);
		selection.selectByValue(accNumber);
		
	 }
	
	public void clickGO(){
		 	
		btnGo.click();
	}
	
	
	public String getAccountNumberFromHistrory()
	{
		return AccountNumber.getText();
	}
	
	public String getBalanceDate()
	{
		return BalanceDate.getText();
	}
	
	public void ClickAccountSummary()
	{
		AccountSummary.click();
	}
}

