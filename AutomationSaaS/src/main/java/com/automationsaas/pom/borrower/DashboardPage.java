package com.automationsaas.pom.borrower;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class DashboardPage {

	public WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(id = "borrowerId")
	@FindBy(xpath="(//div[@class='logobox']//span)[3]")
	private WebElement borroweridtext;
	
	@FindBy(xpath="//li[@id='header_profile_dropdown']//span")
	private WebElement headerprofiledropdown;
	
	@FindBy(xpath="//i[@class='fa fa-power-off']")
	private WebElement logoutlink;
	
	@FindBy(xpath="//span[text()='Transactions']")
	private WebElement transactionslink;
	
	@FindBy(xpath="//span[text()='Account']")
	private WebElement accountlink;
	
	@FindBy(xpath="//span[text()='Profile']")
	private WebElement profilelink;

	@FindBy(xpath = "//h5//span")
	private WebElement borrowerprofilestatustext;

	@FindBy(id = "availableCashHeader")
	private WebElement accountbalancetext;

	@FindBy(xpath = "//h2[contains(text(),'Loan')]")
	private WebElement loanidtext;

	@FindBy(id = "loanOverviewStatus")
	private WebElement loanstatustext;
	
	@FindBy(xpath="//a[text()='Verify Phone Number']")
	private WebElement verifyphonenumberlink;
	
	@FindBy(xpath="//a[text()='Verification Email']")
	private WebElement verifyemaillink;
	
	@FindBy(id="loan_funded_span")
	private WebElement fundedpercentage;

	@FindBy(xpath = "//b[text()='Product']/../following-sibling::h4")
	private WebElement producttext;

	@FindBy(xpath = "//b[text()='Loan Id']/../following-sibling::h4")
	private WebElement loanoverviewloanidtext;

	@FindBy(xpath = "//b[text()='Borrower Name']/../following-sibling::h4")
	private WebElement borrowernametext;

	@FindBy(xpath = "//b[text()='VAT On Service Fee']/../following-sibling::h4")
	private WebElement vatonservicefeetext;

	@FindBy(xpath = "//b[text()='Amount to be Repaid']/../following-sibling::h4")
	private WebElement amounttoberepaidtext;

	@FindBy(xpath = "//b[text()='Borrower ID']/../following-sibling::h4")
	private WebElement loanoverviewborroweridtext;

	@FindBy(xpath = "//b[text()='Principal']/../following-sibling::h4")
	private WebElement principaltext;

	@FindBy(xpath = "//b[text()='DSA Agent']/../following-sibling::h4")
	private WebElement dsaagenttext;

	@FindBy(xpath = "//b[text()='Disbursed date']/../following-sibling::h4")
	private WebElement disburseddatetext;

	@FindBy(xpath = "//b[text()='Total Borrower Service Fees']/../following-sibling::h4")
	private WebElement totalborrowerservicefees;

	@FindBy(xpath = "//b[text()='Total Fees']/../following-sibling::h4")
	private WebElement totalfeestext;

	@FindBy(xpath = "//b[text()='Starting Date']/../following-sibling::h4")
	private WebElement startingdatetext;

	@FindBy(xpath = "//b[text()='Debt Repayment Term']/../following-sibling::h4")
	private WebElement debtrepaymenttermtext;

	@FindBy(xpath = "//b[text()='Annual Percentage Rate']/../following-sibling::h4")
	private WebElement annualpercentageratetext;

	@FindBy(xpath = "//b[text()='Total Service Fee']/../following-sibling::h4")
	private WebElement totalservicefeetext;
	
	@FindBy(xpath="//a[text()='Loan Details']")
	private WebElement loandetailsbutton;
	
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
	
	@FindBy(xpath="//a[text()='View and accept contracts']")
	private WebElement viewandacceptcontractlink;
	
	@FindBy(xpath="//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_amounttext;
	
	@FindBy(xpath="//th[.='Remaining Balance']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Remaining Balance']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_remainingbalancetext;
	
	@FindBy(xpath="//th[.='Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransations_typetext;
	
	@FindBy(xpath="//a[text()='Verify Phone Number']")
	private WebElement phoneNumberVerifyLink;
	
	@FindBy(xpath="//a[text()='Verification Email']")
	private WebElement emailVerifyLink;

	@FindBy(xpath="//div[@class='alert alert-success']//strong")
	private WebElement sentVerificationEmailNotification;
	
//	@FindBy(xpath="//span[@class='name']")
	@FindBy(xpath="(//div[@class='logobox']//span)[3]")
	private WebElement namedisplayondsanavigation;
	
	@FindBy(xpath = "//div[@id='completedTransactionDiv']//strong")
	private WebElement notransactionforcompletedtransactiontext;
	
	@FindBy(xpath="//span[text()='Apply Loan']")
	private WebElement applyloanlink;
	
	@FindBy(xpath="//th[@id='LOAN_ID']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='LOAN_ID']/preceding-sibling::th)+1]/a")
	private List<WebElement> loanidlinks;
	
	public void validateBorrowerName(String name) {
		try {
			Generics.waitForElement(driver, namedisplayondsanavigation);
			String actualName=namedisplayondsanavigation.getText();
			String[] splitactualname = actualName.split("\\n");
			String expectedName=name;
			assertEquals(splitactualname[0], expectedName);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

	public String getBorrowerId() {
		String borrowerId = null;
		try {
			Generics.waitForElement(driver, borroweridtext);
			borrowerId = borroweridtext.getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return borrowerId;
	}
	
	public void validateBorrowerId(String product) {
		try {
			Generics.waitForElement(driver, borroweridtext);
			assertEquals((borroweridtext.getText().split("\\n"))[1], product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateProfileStatus(String borrowerprofilestatus) {
		try {
			Generics.waitForElement(driver, borrowerprofilestatustext);
			assertEquals(borrowerprofilestatustext.getText(), borrowerprofilestatus);
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
	
	public void validateVerificationLinks() {
		try {
			Generics.waitForElement(driver, verifyphonenumberlink);
			Generics.waitForElement(driver, verifyemaillink);
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

	public String getLoanId() {
		String loanId = null;
		try {
			Generics.waitForElement(driver, loanidtext);
			loanId = loanidtext.getText().replace("LoanOverview:", "").replace(" (Initialized)", "")
					.replace("Loan Details Withdraw Loan Application", "").replaceAll("\\s+", "")
					.replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("LoanOverview:", "");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return loanId;
	}
	
	public void validateLoanId(String product) {
		try {
			Generics.waitForElement(driver, loanidtext);
			
			assertEquals(loanidtext.getText().replace("Loan Overview : ", "").replace(" (Application Rejected)", "")
					.replace("Loan Details Withdraw Loan Application", "").replaceAll("\\s+", "").replace("LoanDetails", "")
					.replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("Initialized", "").replaceAll("\\(", "").replaceAll("\\)", "")
					.replaceAll("ApplicationApproved", "").replace("LoanOverview:", ""), product);
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoanStatus(String loanstatus) {
		try {
			Generics.waitForElement(driver, loanstatustext);
			assertEquals(loanstatustext.getText().replace("(", "").replace(")", ""), loanstatus);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateFundedPercentage(String percentagevalue) {
		try {
			Generics.waitForElement(driver, fundedpercentage);
			assertEquals(fundedpercentage.getText(), percentagevalue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoanDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, producttext);
				assertEquals(producttext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, loanoverviewloanidtext);
				assertEquals(loanoverviewloanidtext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, borrowernametext);
				assertEquals(borrowernametext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, vatonservicefeetext);
				assertEquals(vatonservicefeetext.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, amounttoberepaidtext);
				assertEquals(amounttoberepaidtext.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, loanoverviewborroweridtext);
				assertEquals(loanoverviewborroweridtext.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, principaltext);
				assertEquals(principaltext.getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, dsaagenttext);
				assertEquals(dsaagenttext.getText(), product);
				break;

			case 8:
				Generics.waitForElement(driver, disburseddatetext);
				assertEquals(disburseddatetext.getText(), product);
				break;

			case 9:
				Generics.waitForElement(driver, totalborrowerservicefees);
				assertEquals(totalborrowerservicefees.getText(), product);
				break;

			case 10:
				Generics.waitForElement(driver, totalfeestext);
				assertEquals(totalfeestext.getText(), product);
				break;

			case 11:
				Generics.waitForElement(driver, startingdatetext);
//				assertEquals(startingdatetext.getText(), product);
				break;

			case 12:
				Generics.waitForElement(driver, debtrepaymenttermtext);
				assertEquals(debtrepaymenttermtext.getText(), product);
				break;

			case 13:
				Generics.waitForElement(driver, annualpercentageratetext);
				assertEquals(annualpercentageratetext.getText(), product);
				break;

			case 14:
				Generics.waitForElement(driver, totalservicefeetext);
				assertEquals(totalservicefeetext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoanDetailsButton() {
		try {
			Generics.waitForElement(driver, loandetailsbutton);
			loandetailsbutton.click();
		} catch (InterruptedException e) {
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
	
	public void clickViewAndAcceptContract() {
		try {
			Generics.waitForElement(driver, viewandacceptcontractlink);
			viewandacceptcontractlink.click();
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
	
	public void validateCompletedTransactionWhenNoTransaction(String text) {
		try {
			Generics.waitForElement(driver, notransactionforcompletedtransactiontext);
			assertEquals(notransactionforcompletedtransactiontext.getText(), text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Chandru
	public void clickonPhoneNumberVerifyLink() {
		try {
			Generics.waitForElement(driver, phoneNumberVerifyLink);
			phoneNumberVerifyLink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	
	public void clickonEmailVerifyLink() {
		try {
			Generics.waitForElement(driver, emailVerifyLink);
			emailVerifyLink.click();
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
	
	public void clickApplyLoan() {
		try {
			Generics.waitForElement(driver, applyloanlink);
			applyloanlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getGeneratedLoanIdBasedOnSequenceProvided(int index) {
		List < String > myList = new ArrayList < String > ();
		for(int i=0; i<loanidlinks.size(); i++) {
			myList.add(i, loanidlinks.get(i).getText());
		}
		Collections.sort(myList, Collections.reverseOrder());
		return myList.get(index);
	}
	
	public void clickSelectedLoanId(String value) {
		try {
			Generics.waitForElement(driver, accountlink);
			for(int i=0; i<loanidlinks.size(); i++) {
				if(loanidlinks.get(i).getText().equalsIgnoreCase(value)) {
					loanidlinks.get(i).click();
				}
				else {
					Reporter.log("Select Loan Skipped");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
