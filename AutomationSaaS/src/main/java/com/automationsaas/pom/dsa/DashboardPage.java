package com.automationsaas.pom.dsa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
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
	
//	@FindBy(xpath="//span[@class='name']")
	
	@FindBy(xpath="(//div[@class='logobox']//span)[3]")
	private WebElement dsanametext;
	
	@FindBy(xpath="(//div[@class='logobox']//span)[3]")
	private WebElement dsaidtext;
	
	@FindBy(xpath="//h5/span")
	private WebElement profilestatustext;
	
	@FindBy(id="availableCashHeader")
	private WebElement accountbalancetext;
	
	@FindBy(xpath="//a[contains(text(),'Deposit')]")
	private WebElement depositbutton;
	
	@FindBy(xpath="//form[@id='transactionDepositForm']//input[@id='transactionAmount']")
	private WebElement deposit_enteramounttextbox;
	
	@FindBy(xpath="//button[text()='Deposit']")
	private WebElement deposit_depositbutton;
	
	@FindBy(xpath="//a[contains(text(),'Withdraw')]")
	private WebElement withdrawbutton;
	
	@FindBy(xpath="//form[@id='transactionWithdrawForm']//input[@id='transactionAmount']")
	private WebElement withdraw_enteramounttextbox;
	
	@FindBy(xpath="//button[text()='Withdraw']")
	private WebElement withdraw_withdrawbutton;
	
	@FindBy(xpath="//a[text()='Verify Phone Number']")
	private WebElement verifyphonenumberlink;
	
	@FindBy(xpath="//a[text()='Verification Email']")
	private WebElement verificationemaillink;
	
	@FindBy(id="dsa_account")
	private WebElement accountlink;
	
	@FindBy(id="dsa_profile")
	private WebElement profilelink;
	
	@FindBy(xpath="//span[contains(text(),'Transaction is pending For Admin Approval')]")
	private WebElement transaction_notification;
	
	@FindBy(xpath="//a[text()='View and accept contracts']")
	private WebElement viewandacceptcontractlink;
	
	//@FindBy(xpath="//*[@id='sidebar-nav']//li[contains(text(),'Navigation')]")
	@FindBy(xpath="//div[@id='sidebar-nav']//ul")
	private WebElement navigation;
	
	@FindBy(xpath="//*[@id='dsa_activeLoans']//span")
	private WebElement activeloanslink;
	
	@FindBy(xpath="//*[contains(text(),'LN0')]")
	private WebElement recentactiveloan;
	
	@FindBy(xpath="//b[text()='Borrower ID']/../..//h4")
	private WebElement activeloanborrowerid;
	
	@FindBy(xpath="//b[text()='Loan Id']/../..//h4")
	private WebElement activeloanid;
	
	@FindBy(xpath="//a[text()='Verify Phone Number']")
	private WebElement phoneNumberVerifyLink;
	
	@FindBy(xpath="//button[@id='close_OTP_modal_1']")
	private WebElement closeOTPPopup;
	
	@FindBy(xpath="//a[text()='Verification Email']")
	private WebElement emailVerifyLink;

	@FindBy(xpath="//div[@class='alert alert-success']//strong")
	private WebElement sentVerificationEmailNotification;
	
	@FindBy(xpath="//span[@class='name']")
	private WebElement namedisplayondsanavigation;
	
	@FindBy(xpath="//a[contains(text(),'Supporting Documents')]")
//	@FindBy(xpath="//li[@id='dsaBorrowerBasicDetails']//parent::div//preceding-sibling::div//li/a[contains(text(),'Supporting Documents')]")
//	li[@id='dsaBorrowerBasicDetails']/..//preceding-sibling::div//li/a[contains(text(),'Supporting Documents')]
	private WebElement supportingDocumentsTab;
	
	//Apply For Loan
	
		@FindBy(id="dsa_applyForLoan_div")
		private WebElement applyforloanlink;
		
		@FindBy(id="dsa_applyForNew")
		private WebElement applyfornewlink;
		
		@FindBy(id="dsa_applyFoExisting")
		private WebElement applyforexistinglink;
		
		@FindBy(xpath="//*[@id='sidebar-nav']/ul")
		private List<WebElement> dsaleftmenuitems;
		
//		//IdentityNumbers 1 & 2
//		@FindBy(xpath="//li[@id='basic_profile_tab']//a") //identityNumberOne
//		private WebElement basicdetailstablabel;
//		
//		@FindBy(id="identityNumberOne")
//		private WebElement identitynumberonetextbox;
//		
//		@FindBy(id="identityNumberTwo")
//		private WebElement identitynumbertwotextbox;
	
		
		@FindBy(xpath="//div[@id='loanRelatedDocumentsDiv']//a[contains(text(),'Loan Application Document')]")	
	    private WebElement loanapplicationdocumentaccordion;
		
	public String getDSAName() {
		String dsaName = null;
		try {
			Generics.waitForElement(driver, dsanametext);	
		  dsaName= dsanametext.getText();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return dsaName;
	}
	
	public String getDSAId() {
		String dsaId = null;
		try {
			Generics.waitForElement(driver, dsaidtext);
			dsaId = dsaidtext.getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return dsaId;
	}
	
	public void validateDSAName(String value) {
		try {
			Generics.waitForElement(driver, dsanametext);
			String actualName=dsanametext.getText();
			String[] splitactualname= actualName.split("\\n");
			String expectedName= value;
			assertEquals((splitactualname[0]), expectedName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateDSAId(String value) {
		try {
			Generics.waitForElement(driver, dsaidtext);
			assertEquals((dsaidtext.getText().split("\\n"))[1], value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateProfileStatus(String value) {
		try {
			Generics.waitForElement(driver, profilestatustext);
			assertEquals(profilestatustext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateAccountBalance(String value) {
		try {
			Generics.waitForElement(driver, accountbalancetext);
			assertEquals(accountbalancetext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyIfPhoneNumberLinkIsPresent() {
		try {
			Generics.waitForElement(driver, verifyphonenumberlink);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyIfEmailLinkIsPresent() {
		try {
			Generics.waitForElement(driver, verificationemaillink);
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
			Generics.waitForElement(driver, deposit_enteramounttextbox);
			deposit_enteramounttextbox.click();
			deposit_enteramounttextbox.clear();
			deposit_enteramounttextbox.sendKeys(depositamount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDepositButton() {
		try {
			Generics.waitForElement(driver, deposit_depositbutton);
			deposit_depositbutton.click();
			Generics.waitForElement(driver, transaction_notification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterWithdrawAmount(String withdrawamount) {
		try {
			Generics.waitForElement(driver, withdraw_enteramounttextbox);
			withdraw_enteramounttextbox.click();
			withdraw_enteramounttextbox.clear();
			withdraw_enteramounttextbox.sendKeys(withdrawamount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickWithdrawButton() {
		try {
			Generics.waitForElement(driver, withdraw_withdrawbutton);
			withdraw_withdrawbutton.click();
			Thread.sleep(2000);
			Generics.waitForElement(driver, transaction_notification);
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
	
	/**
	 * @author chandrashekar
	 *
	 */
	public void clickApplyForLoan() {
		try {
			Generics.waitForElement(driver, applyforloanlink);
			applyforloanlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */
	public void clickApplyLoanForNewBorrower() {
		try {
			Generics.waitForElement(driver, applyfornewlink);
			applyfornewlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */
	public void clickApplyLoanForExistingBorrower() {
		try {
			Generics.waitForElement(driver, applyforexistinglink);
			applyforexistinglink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */
	public void validateDSAStatus(String value) {
		try {
			Generics.waitForElement(driver, profilestatustext);
			System.out.println(profilestatustext.getText());
			assertNotEquals(profilestatustext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */	
	public void validateApplyLoanMenu(String expected) {
		try {
			Generics.waitForElement(driver, navigation);
			for (int i=0;i<dsaleftmenuitems.size();i++) {
				String actual=dsaleftmenuitems.get(i).getText();
				String[] split=actual.split("\n");
				ArrayList<String> sp=new ArrayList<String>(Arrays.asList(split));
				for (int j=0;j<sp.size();j++) {
					assertNotEquals(sp.get(j),expected);
					}
				}
				Reporter.log("Test Pass: DSA cannot apply for a Loan as DSA Profile is not Approved, & hence 'Apply For Loan' menu is not present", true);
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */	
	public void clickonActiveLoan() {
		try {
			//Generics.waitForFewSecondstoLoad(4000);
			Generics.waitForElement(driver, activeloanslink);
			activeloanslink.click();
			driver.navigate().refresh();
			Generics.waitForFewSecondstoLoad(5000);
			Generics.waitForElement(driver, recentactiveloan);
			recentactiveloan.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */	
	public String verifyAndCopyActiveLoanID(String expborrowerId) {
		String loanId=null;
		try {
			Generics.waitForElement(driver, activeloanborrowerid);
			String actualborrowerId=activeloanborrowerid.getText();
			assertEquals(actualborrowerId, expborrowerId);
			Generics.waitForElement(driver, activeloanid);
			loanId=activeloanid.getText();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loanId;
	}
	
	
	//Divya
	public void clickonPhoneNumberVerifyLink() {
		try {
			Generics.waitForElement(driver, phoneNumberVerifyLink);
			phoneNumberVerifyLink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void closeOTPPopup() {
		try
		{
			Generics.waitForElement(driver, closeOTPPopup);
			closeOTPPopup.click();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void clickonEmailVerifyLink() {
		try {
			Generics.waitForElement(driver, emailVerifyLink);
		Generics.waitForFewSecondstoLoad(2000);
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
	
	public void validateDSANamefromDSADashboard(String title,String firstname, String lastname) {
		try {
			Generics.waitForElement(driver, namedisplayondsanavigation);
			String actualName=namedisplayondsanavigation.getText();
			String expectedName=title+" "+firstname+" "+lastname;
			assertEquals(actualName, expectedName);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

	public void clickSupportingDocumentsTab() {
		try {
			Generics.waitForElement(driver, supportingDocumentsTab);
			supportingDocumentsTab.click();
			
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	public void uploadDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("//div[contains(@id,'MAIN_APPLICANT')]//td[text()='" +filename+ "']//following-sibling::td//i[contains(@class,'upload')]"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//form[@id='loanApplicationDocumentUploadForm']//div/input"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			
			WebElement uploadDoneButton = driver.findElement(By.xpath("//form[@id='loanApplicationDocumentUploadForm']//div/button"));
			Generics.waitForElement(driver, uploadDoneButton);
			uploadDoneButton.click();
		
			WebElement uploadNotification= driver.findElement(By.xpath("//span[contains(text(),'uploaded successfully')]"));
			Generics.waitForElement(driver, uploadNotification);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	
	//download documents
	public void clickDownloadDocument(String filename) {
		try 
		{
		WebElement downloadIcon= driver.findElement(By.xpath("//div[contains(@id,'MAIN_APPLICANT')]//td[text()='" +filename+ "']//following-sibling::td//i[contains(@class,'download')]"));
			//@FindBy(xpath ="//div[@id='dsaDocumentsTableDiv']//td/a")
			//@FindBy(xpath ="//div[@id='dsaDocumentsTableDiv']//td[text()='Adhar Card']//following-sibling::td/a
		
			Generics.waitForElement(driver, downloadIcon);
			downloadIcon.click();
		}
		catch (InterruptedException e)
		{e.printStackTrace();
		}
	}
	
	
//Validate downloaded document
	
      public boolean validateDownloadedDocument(String expfilename) {
		
		File[] files = new File(upload_contractfile_path).listFiles();
		
			for (File file : files) {
				if (file.getName().contains(expfilename)) {
					return true;
				}
			}	
			return false;		
			
		}
	//delete document from pop up 
      
      public void deleteDocument(String filename) {
  		try {
  			WebElement fileUploadButton = driver.findElement(By.xpath("//div[contains(@id,'MAIN_APPLICANT')]//td[text()='" +filename+ "']//following-sibling::td//i[contains(@class,'upload')]"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();
		
			WebElement deleteIcon = driver.findElement(By.xpath("//table[@id='sds_documentTableToDelete']//td/button"));
  			Generics.waitForElement(driver, deleteIcon);
  			deleteIcon.click();

  			WebElement closePopup = driver.findElement(By.xpath("//div[@id='modal-loan-document-upload-div']//div/button[@class='close']"));
  			Generics.waitForElement(driver, closePopup);
  			closePopup.click();
  			
  			WebElement deleteNotification = driver.findElement(By.xpath("//span[contains(text(),'Deleted Successfully')]"));
  			Generics.waitForElement(driver, deleteNotification);
  			
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}
  	}
      
      public void clickLoanApplicationDocAccordion()
      {
    	  try
    	  {
    		  Generics.waitForElement(driver, loanapplicationdocumentaccordion);
    		  loanapplicationdocumentaccordion.click();
    	  }
    	  catch (InterruptedException e) {
    			e.printStackTrace();
    		}
      }
	
	
	}
