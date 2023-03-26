package com.automationsaas.pom.investor;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class DashboardPage extends Base {

	public WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h5/span")
	private WebElement investorprofilestatustext;
	
//	@FindBy(id="investorId")
	@FindBy(xpath="(//div[@class='logobox']//span)[3]")
	private WebElement investoridtext;
	
	@FindBy(xpath="//li[@id='header_profile_dropdown']//span")
	private WebElement headerprofiledropdown;
	
	@FindBy(xpath="//i[@class='fa fa-power-off']")
	private WebElement logoutlink;
	
	@FindBy(xpath="//span[text()='Account']")
	private WebElement accountlink;
	
	@FindBy(xpath="//a[@href='/investorSection/profile']//span[contains(text(),'Profile')]")
	private WebElement profilelink;
	
	@FindBy(xpath="//a[contains(text(),'View Accepted Contracts')]")
	private WebElement viewacceptedcontracttab;
	
	@FindBy(xpath="//div[@id='viewInvestorAcceptedContract']//strong")
	private WebElement contractdetailsdeletetext;
	
	@FindBy(xpath="//a[text()='Verify Phone Number']")
	private WebElement verifyphonenumberlink;
	
	@FindBy(xpath="//a[text()='Verification Email']")
	private WebElement verifyemaillink;
	
	@FindBy(id="availableCashHeader")
	private WebElement accountbalancetext;
	
	@FindBy(xpath="//a[contains(text(),'Deposit')]")
	private WebElement depositbutton;
	
	@FindBy(xpath="//a[contains(text(),'Withdraw')]")
	private WebElement withdrawbutton;
	
	@FindBy(xpath="//form[@id='transactionDepositForm']//input[@id='transactionAmount']")
	private WebElement deposit_transactionamounttextbox;
	
	@FindBy(id="completeDepositTransactiobBtn")
	private WebElement deposit_depositbutton;
	
	@FindBy(xpath="//form[@id='transactionWithdrawForm']//input[@id='transactionAmount']")
	private WebElement withdraw_transactionamounttextbox;
	
	@FindBy(id="completeWithdrawTransactiobBtn")
	private WebElement withdraw_withdrawbutton;
	
	@FindBy(xpath="//span[contains(text(),'Transaction is pending For Admin Approval')]")
	private WebElement transactionnotification;
	
	@FindBy(xpath="//div[@id='loanOffers']//th[.='Loan Id']/ancestor::thead/following-sibling::tbody/tr/td[count(//div[@id='loanOffers']//tr/th[.='Loan Id']/preceding-sibling::th)+1]/a")
	private List<WebElement> loanidlinks;
	
	@FindBy(xpath="//a[text()='View Contract']")
	private WebElement viewcontractlink;
	
	@FindBy(xpath="//div[@id='nav-col']//span[contains(text(),'Loan Offers')]")
	private WebElement loanofferslink;
	
	@FindBy(xpath="//span[contains(text(),'Transactions')]")
	private WebElement transactionslink;
	
	@FindBy(xpath="//div[@id='completedTransactionDiv']//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_amounttext;
	
	@FindBy(xpath="//div[@id='completedTransactionDiv']//th[.='Remaining Balance']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Remaining Balance']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_remainingbalancetext;
	
	@FindBy(xpath="//div[@class='alert alert-success']//strong")
	private WebElement sentVerificationEmailNotification;
	
	//cmy
	@FindBy(xpath="(//div[@class='logobox']//span)[3]")
	private WebElement namedisplayoninvestornavigation;
	
	public String getInvestorId() {
		String investorId = null;
		try {
			Generics.waitForElement(driver, investoridtext);
			investorId = investoridtext.getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return investorId;
	}
	
	public void validateInvestorID(String expectedinvestorid) {
		try {
			Generics.waitForElement(driver, investoridtext);
			assertEquals(investoridtext.getText().split("\\n")[1], expectedinvestorid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateProfileStatus(String investorprofilestatus) {
		try {
			Generics.waitForElement(driver, investorprofilestatustext);
			assertEquals(investorprofilestatustext.getText(), investorprofilestatus);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateAccountBalance(String accountbalance) {
		try {
			Generics.waitForElement(driver, accountbalancetext);
			assertEquals(accountbalancetext.getText(), accountbalance);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validatePhoneNumberVerificationLinks() {
		try {
			Generics.waitForElement(driver, verifyphonenumberlink);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateEmailVerificationLinks() {
		try {
			Generics.waitForElement(driver, verifyemaillink);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateDepositButton() {
		try {
			Generics.waitForElement(driver, depositbutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateWithdrawButton() {
		try {
			Generics.waitForElement(driver, withdrawbutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAccount() {
		try {
			Generics.waitForElement(driver, accountlink);
			accountlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickProfile() {
		try {
			Generics.waitForElement(driver, profilelink);
			profilelink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickViewAcceptedContract() {
		try {
			Generics.waitForElement(driver, viewacceptedcontracttab);
			viewacceptedcontracttab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateIfNoContractDisplayed(String product) {
		try {
			Generics.waitForElement(driver, contractdetailsdeletetext);
			assertEquals(contractdetailsdeletetext.getText(), product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickDeposit() {
		try {
			Generics.waitForElement(driver, depositbutton);
			depositbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickWithdraw() {
		try {
			Generics.waitForElement(driver, withdrawbutton);
			withdrawbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterDepositAmount(String depositamount) {
		try {
			Generics.waitForElement(driver, deposit_transactionamounttextbox);
			deposit_transactionamounttextbox.click();
			deposit_transactionamounttextbox.clear();
			deposit_transactionamounttextbox.sendKeys(depositamount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDepositButton() {
		try {
			Generics.waitForElement(driver, deposit_depositbutton);
			deposit_depositbutton.click();
			Generics.waitForElement(driver, transactionnotification);
			System.out.println(transactionnotification.getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterWithdrawAmount(String depositamount) {
		try {
			Generics.waitForElement(driver, withdraw_transactionamounttextbox);
			withdraw_transactionamounttextbox.click();
			withdraw_transactionamounttextbox.clear();
			withdraw_transactionamounttextbox.sendKeys(depositamount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickWithdrawButton() {
		try {
			Generics.waitForElement(driver, withdraw_withdrawbutton);
			withdraw_withdrawbutton.click();
			Thread.sleep(2000);
			Generics.waitForElement(driver, transactionnotification);
			System.out.println(transactionnotification.getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void logout() {
		try {
			Generics.waitForElement(driver, headerprofiledropdown);
			headerprofiledropdown.click();
			Generics.waitForElement(driver, logoutlink);
			logoutlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoanIdToBeBid(String loanid) {
		try {
			Generics.waitForElement(driver, loanidlinks.get(0));
			for(int i=0;i<loanidlinks.size();i++) {
				if(loanidlinks.get(i).getText().equalsIgnoreCase(loanid)) {
					Reporter.log("Loan Id found", true);
					loanidlinks.get(i).click();
				}
				else Reporter.log("Loan Id not found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickViewContract() {
		try {
			Generics.waitForElement(driver, viewcontractlink);
			viewcontractlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoanOffers() {
		try {
			Generics.waitForElement(driver, loanofferslink);
			loanofferslink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickTransactions() {
		try {
			Generics.waitForElement(driver, transactionslink);
			transactionslink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateCompletedTransactions(int expectedamount, int expectedremainingamount) {
		
		//Amount
		int a1 = 0;
		for(int i=0; i<completedtransactions_amounttext.size(); i++) {
			String amount = completedtransactions_amounttext.get(i).getText().replace("Rs", "").replace(",", "");
			int a2 = Integer.parseInt(amount);
			int sum = a1 + a2;
			a1 = sum;
		}
		assertEquals(a1, expectedamount);
		
		//Remaining Balance
		int b1 = 0;
		for(int i=0; i<completedtransactions_remainingbalancetext.size(); i++) {
			String amount = completedtransactions_remainingbalancetext.get(i).getText().replace("Rs", "").replace(",", "");
			int b2 = Integer.parseInt(amount);
			int sum = b1 + b2;
			b1 = sum;
		}
		assertEquals(b1, expectedremainingamount);
	}

//Chandru
	public void clickonPhoneNumberVerifyLink() {
		try {
			Generics.waitForElement(driver, verifyphonenumberlink);
			verifyphonenumberlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	
	public void clickonEmailVerifyLink() {
		try {
			Generics.waitForElement(driver, verifyemaillink);
			verifyemaillink.click();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	public void validateSentVerificationEmailNotification(String text) {
		try {
			Generics.waitForElement(driver, sentVerificationEmailNotification);
			System.out.println(sentVerificationEmailNotification.getText());
			assertEquals(sentVerificationEmailNotification.getText(), text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//cmy
		public void validateInvestorName(String expectedName) {
			try {
				Generics.waitForElement(driver, namedisplayoninvestornavigation);
				String actualName=namedisplayoninvestornavigation.getText().split("\\n")[0];
				assertEquals(actualName, expectedName);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
}
