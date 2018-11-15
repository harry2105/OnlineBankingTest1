package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFund {
	
	WebDriver driver;
	@FindBy(linkText="Transfer Funds")
	WebElement TransferFund;
	@FindBy(xpath=".//*[@id='tForm']/h1")
	WebElement TransferFundsPage;
	@FindBy(id="debitAccount")
	WebElement FromAccount;
	@FindBy(id="creditAccount")
	WebElement ToAccount;
	@FindBy(id="transferAmount")
	WebElement Amount;
	@FindBy(id="transfer")
	WebElement TransferMoney;
	@FindBy(xpath=".//*[@id='soapResp']/span")
	WebElement verifyAmount;
	//By username=By.name("username");
	//By password=By.id("password");
	//By login=By.xpath(".//*[@id='uiv2-loginform']/button");
	
	
	
	public TransferFund(WebDriver driver){
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		
	}
	
	public void ClickTrnasferFundLink()
	{
		TransferFund.click();
	}
	
	public String verifyTrasferFundPage()
	{
		return TransferFundsPage.getText();
	}
	
	
	
	
	public void SelectFromAccount(String accNumber){
		
		Select selection=new Select(FromAccount);
		selection.selectByValue(accNumber);
		
	 }
	
	public void SelectToAccount(String accNumber){
		
		Select selection=new Select(ToAccount);
		selection.selectByValue(accNumber);
	}
	public void SetAmount(String tranferAmount)
	{
		Amount.sendKeys(tranferAmount);
	}
	
	public void clickTransferFundButton(){
		
		TransferMoney.click();
	}
	
	
	public String verifyTransferedAmount()
	{
		return verifyAmount.getText();
	}
	

}
