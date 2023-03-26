package com.automationsaas.pom.admininvestor;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class InvestorDetailsPage extends Base {

	public WebDriver driver;
	public InvestorDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement investoridtext;
	
	@FindBy(id="loanOverviewStatus")
	private WebElement investorstatustext;
	
	@FindBy(id="followingStatus")
	private WebElement investorstatusdropdown;
	
	@FindBy(xpath="//span[contains(text(),'Status Changed Succesfully')]")
	private WebElement statuschangenotification;
	
	@FindBy(id="availableCashHeader")
	private WebElement accountbalancetext;
	
	@FindBy(xpath="//a[contains(text(),'Deposit')]")
	private WebElement depositbutton;
	
	@FindBy(xpath="//form[@id='transactionDepositForm']//input[@id='transactionAmount']")
	private WebElement deposit_transactionamounttextbox;
	
	@FindBy(xpath="//button[@id='completeDepositTransactiobBtn']")
	private WebElement deposit_depositbutton;
	
	@FindBy(xpath="//div[@id='waitingSpinnerDepositTransactionModel']//img")
	private WebElement deposit_spinner;
	
	@FindBy(xpath="//span[contains(text(),'Transaction Completed Successfully')]")
	private WebElement transactionnotification;
	
	@FindBy(xpath="//div[@id='top_detail_table']//a[contains(text(),'Withdraw')]")
	private WebElement withdrawbutton;
	
	@FindBy(xpath="//form[@id='transactionWithdrawForm']//input[@id='transactionAmount']")
	private WebElement withdraw_transactionamounttextbox;
	
	@FindBy(xpath="//button[@id='completeWithdrawTransactiobBtn']")
	private WebElement withdraw_withdrawbutton;
	
	//Details Section
	@FindBy(xpath="//h6")
	private WebElement investoremailidtext;
	
	@FindBy(id="title")
	private WebElement titledropdown;
	
	@FindBy(id="firstName")
	private WebElement firstnametextbox;
	
	@FindBy(id="lastName")
	private WebElement lastnametextbox;
	
	@FindBy(xpath="//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//a")
	private List<WebElement> datelinks;
	
	@FindBy(id="gender")
	private WebElement genderdropdown;
	
	@FindBy(id="maritalStatus")
	private WebElement maritialstatusdropdown;
	
	@FindBy(id="contact")
	private WebElement mobilenumbertextbox;
	
	@FindBy(id="identityNumberOne")
	private WebElement identitynumberonetextbox;
	
	@FindBy(id="identityNumberTwo")
	private WebElement identitynumbertwotextbox;
	
	@FindBy(id="investorCategory")
	private WebElement categorydropdown;
	
	@FindBy(id="investorProfileTextVariable1")
	private WebElement investordetailstextvariable1textbox;
	
	@FindBy(id="updateInvestorBasicDetails")
	private WebElement details_updatebutton;
	
	@FindBy(xpath="//li[contains(.,'Identity number one should follow ^[0-9]{12}$ regex pattern')]")
	private WebElement identitynumberonenotification;
	
	@FindBy(xpath="//li[contains(.,'Identity number two should follow ^[A-Z]{5}[0-9]{4}[A-Z]{1}$ regex pattern')]")
	private WebElement identitynumbertwonotification;
	
	@FindBy(xpath="//span[contains(text(),'Updated')]")
	private WebElement investordetailsupdatenotification;
	
	//Profile Info
	@FindBy(id="amountToInvest")
	private WebElement amounttoinvesttextbox;
	
	@FindBy(id="grossIncome")
	private WebElement grossincometextbox;
	
	@FindBy(xpath="//form[@id='investorIndividualDetails']//input[@id='investorProfileTextVariable1']")
	private WebElement investorprofiletextvariable1textbox;
	
	@FindBy(xpath="//span[contains(text(),'Updated')]")
	private WebElement profileinfoupdatenotification;
	
	@FindBy(xpath="//div[@id='submitButtonIndividualDetail']//button")
	private WebElement profileinfo_updatebutton;
	
	//Employment History Info
	@FindBy(id="employmentType")
	private WebElement employmenttypetextbox;
	
	@FindBy(id="organizationName")
	private WebElement organizationnametextbox;
	
	@FindBy(id="organizationType")
	private WebElement organizationtypetextbox;
	
	@FindBy(id="investorEmploymentDetailsTextVariable1")
	private WebElement investoremploymentdetailstextvariable1textbox;
	
	@FindBy(xpath="//div[@id='submitButtonEmploymentDetail']//button")
	private WebElement employmenthistoryinfo_updatebutton;
	
	@FindBy(xpath="//span[contains(text(),'updated')]")
	private WebElement employmenthistoryinfoupdatenotification;
	
	//Investor Agents
	@FindBy(xpath="//div[@id='loadInvestorAgents']//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)+1]")
	private WebElement investoragents_emailtext;
	
	@FindBy(xpath="//div[@id='loadInvestorAgents']//th[.='First Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='First Name']/preceding-sibling::th)+1]")
	private WebElement investotagents_firstname;
	
	@FindBy(xpath="//div[@id='loadInvestorAgents']//th[.='Last Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Last Name']/preceding-sibling::th)+1]")
	private WebElement investoragents_lastname;
	
	@FindBy(xpath="//div[@id='loadInvestorAgents']//th[.='Phone Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Phone Number']/preceding-sibling::th)+1]")
	private WebElement investoragents_phonenumbertext;
	
	@FindBy(xpath="//div[@id='loadInvestorAgents']//a")
	private WebElement investoragents_addagentbutton;
	
	//Address Details
	@FindBy(xpath="//div[@id='addressDetailTable']//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private WebElement addressdetails_serialno;
	
	@FindBy(xpath="//div[@id='addressDetailTable']//th[.='Address Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Address Name']/preceding-sibling::th)+1]")
	private WebElement addressdetails_addressnametext;
	
	@FindBy(xpath="//div[@id='addressDetailTable']//th[.='Line1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Line1']/preceding-sibling::th)+1]")
	private WebElement addressdetails_line1text;
	
	@FindBy(xpath="//div[@id='addressDetailTable']//th[.='Line2']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Line2']/preceding-sibling::th)+1]")
	private WebElement addressdetails_line2text;
	
	@FindBy(xpath="//div[@id='addressDetailTable']//th[.='Line3']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Line3']/preceding-sibling::th)+1]")
	private WebElement addressdetails_line3text;
	
	@FindBy(xpath="//div[@id='addressDetailTable']//th[.='City']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='City']/preceding-sibling::th)+1]")
	private WebElement addressdetails_citytext;
	
	@FindBy(xpath="//div[@id='addressDetailTable']//th[.='State']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='State']/preceding-sibling::th)+1]")
	private WebElement addressdetails_statetext;
	
	@FindBy(xpath="//div[@id='addressDetailTable']//th[.='Zip Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Zip Code']/preceding-sibling::th)+1]")
	private WebElement addressdetails_zipcodetext;
	
	@FindBy(xpath="//a[contains(text(),'Address Details')]")
	private WebElement addressdetailsaccordionlink;
	
	@FindBy(xpath="//div[@id='addressDetailTable']//i[@class='fa fa-edit']")
	private WebElement addressdetails_editbutton;
	
	@FindBy(xpath="//div[@id='addressDetailTable']//i[@class='fa fa-trash-o']")
	private WebElement addressdetails_deletebutton;
	
	@FindBy(xpath="(//form[@id='borrowerAddressForm']//input[@id='modal_address_line1'])[1]")
	private WebElement editaddress_line1textbox;
	
	@FindBy(xpath="(//form[@id='borrowerAddressForm']//input[@id='modal_address_line2'])[1]")
	private WebElement editaddress_line2textbox;
	
	@FindBy(xpath="(//form[@id='borrowerAddressForm']//input[@id='modal_address_line3'])[1]")
	private WebElement editaddress_line3textbox;
	
	@FindBy(xpath="(//label[text()='State']/..//select[@id='modal_address_state'])[1]")
	private WebElement editaddress_statetextbox;
	
	@FindBy(xpath="(//form[@id='borrowerAddressForm']//input[@id='modal_address_city'])[1]")
	private WebElement editaddress_citytextbox;
	
	@FindBy(xpath="(//form[@id='borrowerAddressForm']//input[@id='modal_address_zipCode'])[1]")
	private WebElement editaddress_zipcodetextbox;
	
	@FindBy(xpath="(//form[@id='borrowerAddressForm']//button[@id='createOrEditAddressBtn'])[1]")
	private WebElement editaddress_donebutton;
	
	@FindBy(xpath="//span[contains(text(),'Updated')]")
	private WebElement addressdetailsupdatenotification;
	
	//Bank Details
	@FindBy(xpath="//div[@id='bank_details_list']//th[.='Account Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Number']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_accountnumbertext;
	
	@FindBy(xpath="//div[@id='bank_details_list']//th[.='Account Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Type']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_accounttypetext;
	
	@FindBy(xpath="//div[@id='bank_details_list']//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_banknametext;
	
	@FindBy(xpath="//div[@id='bank_details_list']//th[.='IFSC']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='IFSC']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_ifsctext;
	
	@FindBy(xpath="//button[@id='bank_detail_modal_opener']")
	private WebElement bankdetails_addbankdetailsbutton;
	
	@FindBy(xpath = "//div[@id='bank_details_list']//button[@name='bankDetaileleteLink']")
	private List<WebElement> bankdetails_deletebutton;

        @FindBy(xpath = "//div[@id='bank_details_list']//button[@id='edit_bank_detail_modal_opener']")
	private List<WebElement> bankdetails_editbutton;

	@FindBy(xpath = "//div[@id='modal-for-update-bank-detail']//button[@class='close']")
	private WebElement bankdetails_closebutton;

	@FindBy(xpath="//span[contains(text(),'Deleted')]")
	private WebElement deletebankdetailsnotification;
	
	@FindBy(xpath="//form[@id='bankDetailForm']//input[@id='accountNumber']")
	private WebElement editbankdetails_accountnumbertextbox;
	
	@FindBy(xpath="//form[@id='bankDetailForm']//input[@id='bankName']")
	private WebElement editbankdetails_banknametextbox;
	
	@FindBy(xpath="//form[@id='bankDetailForm']//input[@id='ifsc']")
	private WebElement editbankdetails_ifsctextbox;
	
	@FindBy(xpath="//form[@id='bankDetailForm']//input[@id='bankAccountType']")
	private WebElement editbankdetails_accounttypetextbox;
	
	@FindBy(xpath="//form[@id='bankDetailForm']//button[@id='submitBankDetailsButton']")
	private WebElement editbankdetails_donebutton;
	
	@FindBy(xpath="//div[@id='waitingSubmitBankDetailsButton']//img")
	private WebElement editbankdetails_donebutton_spinner;

	@FindBy(xpath = "//span[contains(text(),'Successfully')]")
	private WebElement bankdetailsnotification;

	//Credit Answers
	@FindBy(xpath="//a[contains(text(),'Credit Answers')]")
	private WebElement creditanswerstab;
	
	@FindBy(xpath="//a[contains(text(),'Investor Question Group 1')]")
	private WebElement investorquestiongroupaccordionlink;
	
	@FindBy(xpath="//label[text()='Down Payment']/following-sibling::input")
	private WebElement downpaymenttextbox;
	
	@FindBy(xpath="//label[text()='Borrower Nationality']/following-sibling::select")
	private WebElement borrowernationalitydropdown;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement creditanswers_submitbutton;
	
	@FindBy(xpath="//a[contains(text(),'Supporting Documents')]")
	private WebElement supportingdocumentstab;
	
	@FindBy(xpath="//div[@id='investorDocumentsTableDiv']//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> supportingdocument_serialnumber;
	
	@FindBy(xpath="//div[@id='investorDocumentsTableDiv']//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Category']/preceding-sibling::th)+1]")
	private List<WebElement> supportingdocument_documentcategory;
	
	@FindBy(xpath="//div[@id='investorDocumentsTableDiv']//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)+1]")
	private List<WebElement> supportingdocument_documentname;
	
	@FindBy(xpath="//div[@id='investorDocumentsTableDiv']//th[.='Visible To Investor']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Investor']/preceding-sibling::th)+1]/input")
	private List<WebElement> supportingdocument_visibletoinvestor;
	
	@FindBy(xpath="//th[.='Contract Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Contract Name']/preceding-sibling::th)+1]")
	private List<WebElement> contract_contractnametext;
	
	@FindBy(xpath="//th[.='Current Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Current Status']/preceding-sibling::th)+1]")
	private List<WebElement> contract_currentstatustext;
	
	@FindBy(xpath="//th[.='Accepted / Uploaded By']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Accepted / Uploaded By']/preceding-sibling::th)+1]")
	private List<WebElement> contract_accepteduploadedbytext;
	
	@FindBy(xpath="//th[.='Acceptd / Uploaded at Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Acceptd / Uploaded at Status']/preceding-sibling::th)+1]")
	private List<WebElement> contract_acceptuploadedatstatus;
	
	@FindBy(xpath="//th[.='Contract Files']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Contract Files']/preceding-sibling::th)+1]")
	private List<WebElement> contract_contractfiles;
	
	@FindBy(xpath="//a[text()='Transactions']")
	private WebElement transactionstab;
	
	@FindBy(xpath="//a[contains(text(),'Completed Transactions')]")
	private WebElement completedtransactionaccordionlink;
	
	@FindBy(xpath="//div[@id='transactionDiv']//th[@id='TRANSACTION_AMOUNT']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='TRANSACTION_AMOUNT']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_amounttext;
	
	@FindBy(xpath="//div[@id='transactionDiv']//th[@id='TRANSACTION_REMAINING_BALANCE']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='TRANSACTION_REMAINING_BALANCE']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_remainingbalancetext;
	
	@FindBy(xpath="//th[.='Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_typetext;
	
	@FindBy(xpath="//th[.='Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Status']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_statustext;
	
	@FindBy(xpath="//div[@id='investorDocumentsTableDiv']//button/i[@class='fa fa-eye']")
	private List<WebElement> document_viewbutton;
	
	@FindBy(xpath="//div[@id='investorSupportingDocuments']//button[text()='×']")
	private WebElement document_preview_closebutton;
	
	@FindBy(xpath="//div[@id='investorDocumentsTableDiv']//button/i[@class='fa fa-upload']")
	private List<WebElement> document_uploadbutton;
	
	@FindBy(xpath="//div[@id='supportingDocumentListToDelete']//button/i[@class='fa fa-times']")
	private List<WebElement> document_deletebutton;
	
	@FindBy(xpath="//form[@id='investorDocumentForm']//div/input")
	private WebElement document_choosefilebutton;
	
	@FindBy(xpath="//div[@id='documentPopUpDiv']//button[text()='×']")
	private WebElement document_popupclosebutton;
	
	@FindBy(xpath="//span[contains(text(),'Document Deleted Successfully')]")
	private WebElement documentdeletenotification;
	
	@FindBy(xpath="//span[contains(text(),'uploaded successfully')]")
	private WebElement documentuploadnotification;
	
	@FindBy(xpath="//form[@id='investorDocumentForm']//button[text()='Done']")
	private WebElement document_donebutton;
	
	@FindBy(xpath="//th[.='#']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='#']/preceding-sibling::th)+1]")
	private List<WebElement> supportingdocumentuploadedfilecount;
	
	@FindBy(xpath="//div[@id='investorDocumentsTableDiv']//a/i[@class='fa fa-download']")
	private List<WebElement> document_downloadbutton;
	
	@FindBy(xpath = "//div[@id='modal-dsa-address']//button[text()='×']")
	private WebElement editaddress_closebutton;
	
	@FindBy(xpath = "//div[@id='bank_details_list']//strong")
	private WebElement nobankdetailsnotification;
	
	@FindBy(xpath="//div[@id='viewContractDetail']//a[contains(text(),'Contracts')]")
	private WebElement contractsaccordionlink;
	
	@FindBy(xpath="//div[@id='documentDetailTable']//strong")
	private WebElement contractdetailsdeletetext;
	
	@FindBy(xpath="//a[contains(text(),'Profile Info')]")
	private WebElement profileinfoaccordionlink;
	
	@FindBy(xpath="//a[contains(text(),'Employment Histroy Info')]")
	private WebElement employmenthistoryinfoaccordionlink;
	
	@FindBy(xpath="//a[contains(text(),'Bank Details')]")
	private WebElement bankdetailsaccordionlink;
	
	
	public void validateInvestorID(String expectedinvestorid) {
		try {
			Generics.waitForElement(driver, investoridtext);
			assertEquals(investoridtext.getText(), expectedinvestorid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateInvestorStatus(String status1, String status2) {
		try {
			Generics.waitForElement(driver, investorstatustext);
			String investorStatus = investorstatustext.getText();
			assertEquals(investorStatus, status1);
			
			Generics.waitForElement(driver, investorstatusdropdown);
			Select investorStatusDropdown = new Select(investorstatusdropdown);
			WebElement selectedStatus = investorStatusDropdown.getFirstSelectedOption();
			assertEquals(selectedStatus.getText(), status2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getAccountBalance() {
		String accountBalance = null;
		try {
			Generics.waitForElement(driver, accountbalancetext);
			accountBalance = accountbalancetext.getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return accountBalance;
	}
	
	public void validateAccountBalance(String balance) {
		try {
			Generics.waitForElement(driver, accountbalancetext);
			String accountBalance = accountbalancetext.getText();
			assertEquals(accountBalance, balance);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateInvestorEmailId(String product) {
		try {
			Generics.waitForElement(driver, investoremailidtext);
			assertEquals(investoremailidtext.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickProfileInfoAccordion() {
		try {
			Generics.waitForElement(driver, profileinfoaccordionlink);
			profileinfoaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEmploymentHistoryInfoAccordion() {
		try {
			Generics.waitForElement(driver, employmenthistoryinfoaccordionlink);
			employmenthistoryinfoaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBankDetailsAccordion() {
		try {
			Generics.waitForElement(driver, bankdetailsaccordionlink);
			bankdetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickContractsAccordion() {
		try {
			Generics.waitForElement(driver, contractsaccordionlink);
			contractsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateIfNoContractDisplayed(String product) {
		try {
			Generics.waitForElement(driver, contractdetailsdeletetext);
			assertEquals(contractdetailsdeletetext.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select titleOptions = new Select(titledropdown);
				WebElement title = titleOptions.getFirstSelectedOption();
				assertEquals(title.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, firstnametextbox);
				assertEquals(firstnametextbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, lastnametextbox);
				assertEquals(lastnametextbox.getAttribute("value"), product);
				break;

			case 3:
				Generics.waitForElement(driver, dateofbirthtextbox);
				assertEquals(dateofbirthtextbox.getAttribute("value"), product);
				break;

			case 4:
				Generics.waitForElement(driver, genderdropdown);
				Select genderOptions = new Select(genderdropdown);
				WebElement gender = genderOptions.getFirstSelectedOption();
				assertEquals(gender.getText(), product);
				break;
				
			case 5:
				Generics.waitForElement(driver, maritialstatusdropdown);
				Select maritialStatusOptions = new Select(maritialstatusdropdown);
				WebElement maritialStatus = maritialStatusOptions.getFirstSelectedOption();
				assertEquals(maritialStatus.getText(), product);
				break;
				
			case 6:
				Generics.waitForElement(driver, mobilenumbertextbox);
				assertEquals(mobilenumbertextbox.getAttribute("value"), product);
				break;
				
			case 7:
				Generics.waitForElement(driver, identitynumberonetextbox);
				assertEquals(identitynumberonetextbox.getAttribute("value"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				assertEquals(identitynumbertwotextbox.getAttribute("value"), product);
				break;
				
			case 9:
				Generics.waitForElement(driver, categorydropdown);
				Select categoryOptions = new Select(categorydropdown);
				WebElement category = categoryOptions.getFirstSelectedOption();
				assertEquals(category.getText(), product);
				break;
				
			case 10:
				Generics.waitForElement(driver, investordetailstextvariable1textbox);
				assertEquals(investordetailstextvariable1textbox.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editDetails(int i, String product, String yearvalue, String monthvalue, String datevalue) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select titleOptions = new Select(titledropdown);
				titleOptions.selectByVisibleText(product);
				break;
				
			case 1:
				Generics.waitForElement(driver, firstnametextbox);
				firstnametextbox.click();
				firstnametextbox.clear();
				firstnametextbox.sendKeys(product);
				break;
				
			case 2:
				Generics.waitForElement(driver, lastnametextbox);
				lastnametextbox.click();
				lastnametextbox.clear();
				lastnametextbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, dateofbirthtextbox);
				dateofbirthtextbox.click();
				
				Select yearOptions = new Select(yeardropdown);
				yearOptions.selectByVisibleText(yearvalue);
				
				Select monthOptions = new Select(monthdropdown);
				monthOptions.selectByVisibleText(monthvalue);
				
				for(int j=0;j<datelinks.size();j++) {
					if(datelinks.get(j).getText().equalsIgnoreCase(datevalue)) {
						datelinks.get(j).click();
					}
				}
				break;
				
			case 4:
				Generics.waitForElement(driver, genderdropdown);
				Select genderOptions = new Select(genderdropdown);
				genderOptions.selectByVisibleText(product);
				break;
				
			case 5:
				Generics.waitForElement(driver, maritialstatusdropdown);
				Select maritialStatusOptions = new Select(maritialstatusdropdown);
				maritialStatusOptions.selectByVisibleText(product);
				break;
				
			case 6:
				Generics.waitForElement(driver, mobilenumbertextbox);
				mobilenumbertextbox.click();
				mobilenumbertextbox.clear();
				mobilenumbertextbox.sendKeys(product);
				break;
				
			case 7:
				Generics.waitForElement(driver, identitynumberonetextbox);
				identitynumberonetextbox.click();
				identitynumberonetextbox.clear();
				identitynumberonetextbox.sendKeys(product);
				break;
				
			case 8:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				identitynumbertwotextbox.click();
				identitynumbertwotextbox.clear();
				identitynumbertwotextbox.sendKeys(product);
				break;
				
			case 9:
				Generics.waitForElement(driver, categorydropdown);
				Select categoryOptions = new Select(categorydropdown);
				categoryOptions.selectByVisibleText(product);
				break;
				
			case 10:
				Generics.waitForElement(driver, investordetailstextvariable1textbox);
				investordetailstextvariable1textbox.click();
				investordetailstextvariable1textbox.clear();
				investordetailstextvariable1textbox.sendKeys(product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDetailsUpdate() {
		try {
			Generics.waitForElement(driver, details_updatebutton);
			details_updatebutton.click();
			Generics.waitForElement(driver, investordetailsupdatenotification);
			Generics.waitForElement(driver, details_updatebutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickUpdateToValidateWrongIdentityNumbers() {
		try {
			Generics.waitForElement(driver, details_updatebutton);
			details_updatebutton.click();
			Generics.waitForElement(driver, identitynumberonenotification);
			Generics.waitForElement(driver, identitynumbertwonotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateProfileInfo(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, amounttoinvesttextbox);
				assertEquals(amounttoinvesttextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, grossincometextbox);
				assertEquals(grossincometextbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, investorprofiletextvariable1textbox);
				assertEquals(investorprofiletextvariable1textbox.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editProfileInfo(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, amounttoinvesttextbox);
				amounttoinvesttextbox.click();
				amounttoinvesttextbox.clear();
				amounttoinvesttextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, grossincometextbox);
				grossincometextbox.click();
				grossincometextbox.clear();
				grossincometextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, investorprofiletextvariable1textbox);
				investorprofiletextvariable1textbox.click();
				investorprofiletextvariable1textbox.clear();
				investorprofiletextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickProfileInfoUpdate() {
		try {
			Generics.waitForElement(driver, profileinfo_updatebutton);
			profileinfo_updatebutton.click();
			Generics.waitForElement(driver, profileinfoupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void employmentHistoryInfo(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, employmenttypetextbox);
				assertEquals(employmenttypetextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, organizationnametextbox);
				assertEquals(organizationnametextbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, organizationtypetextbox);
				assertEquals(organizationtypetextbox.getAttribute("value"), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, investoremploymentdetailstextvariable1textbox);
				assertEquals(investoremploymentdetailstextvariable1textbox.getAttribute("value"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editEmploymentHistoryInfo(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, employmenttypetextbox);
				employmenttypetextbox.click();
				employmenttypetextbox.clear();
				employmenttypetextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, organizationnametextbox);
				organizationnametextbox.click();
				organizationnametextbox.clear();
				organizationnametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, organizationtypetextbox);
				organizationtypetextbox.click();
				organizationtypetextbox.clear();
				organizationtypetextbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, investoremploymentdetailstextvariable1textbox);
				investoremploymentdetailstextvariable1textbox.click();
				investoremploymentdetailstextvariable1textbox.clear();
				investoremploymentdetailstextvariable1textbox.sendKeys(product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickUpdateEmploymentHistoryInfo() {
		try {
			Generics.waitForElement(driver, employmenthistoryinfo_updatebutton);
			employmenthistoryinfo_updatebutton.click();
			Generics.waitForElement(driver, employmenthistoryinfoupdatenotification);
			Generics.waitForElement(driver, employmenthistoryinfo_updatebutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateInvestorAgents(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, investoragents_emailtext);
				assertEquals(investoragents_emailtext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, investotagents_firstname);
				assertEquals(investotagents_firstname.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, investoragents_lastname);
				assertEquals(investoragents_lastname.getText(), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, investoragents_phonenumbertext);
				assertEquals(investoragents_phonenumbertext.getText(), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateAddressDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addressdetails_serialno);
				assertEquals(addressdetails_serialno.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, addressdetails_addressnametext);
				assertEquals(addressdetails_addressnametext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, addressdetails_line1text);
				assertEquals(addressdetails_line1text.getText(), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, addressdetails_line2text);
				assertEquals(addressdetails_line2text.getText(), product);
				break;
				
			case 4:
				Generics.waitForElement(driver, addressdetails_line3text);
				assertEquals(addressdetails_line3text.getText(), product);
				break;
				
			case 5:
				Generics.waitForElement(driver, addressdetails_citytext);
				assertEquals(addressdetails_citytext.getText(), product);
				break;
				
			case 6:
				Generics.waitForElement(driver, addressdetails_statetext);
				assertEquals(addressdetails_statetext.getText(), product);
				break;
				
			case 7:
				Generics.waitForElement(driver, addressdetails_zipcodetext);
				assertEquals(addressdetails_zipcodetext.getText(), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddressDetailsEdit() {
		try {
			Generics.waitForElement(driver, addressdetails_editbutton);
			addressdetails_editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddressDetailsAccordion() {
		try {
			Generics.waitForElement(driver, addressdetailsaccordionlink);
			addressdetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddressDetailsDelete() {
		try {
			Generics.waitForElement(driver, addressdetails_deletebutton);
			addressdetails_deletebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editAddressDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editaddress_line1textbox);
				editaddress_line1textbox.click();
				editaddress_line1textbox.clear();
				editaddress_line1textbox.sendKeys(product);
				break;
				
			case 1:
				Generics.waitForElement(driver, editaddress_line2textbox);
				editaddress_line2textbox.click();
				editaddress_line2textbox.clear();
				editaddress_line2textbox.sendKeys(product);
				break;
				
			case 2:
				Generics.waitForElement(driver, editaddress_line3textbox);
				editaddress_line3textbox.click();
				editaddress_line3textbox.clear();
				editaddress_line3textbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, editaddress_statetextbox);
				Select stateOptions = new Select(editaddress_statetextbox);
				stateOptions.selectByVisibleText(product);
				break;
				
			case 4:
				Generics.waitForElement(driver, editaddress_citytextbox);
				editaddress_citytextbox.click();
				editaddress_citytextbox.clear();
				editaddress_citytextbox.sendKeys(product);
				break;
				
			case 5:
				Generics.waitForElement(driver, editaddress_zipcodetextbox);
				editaddress_zipcodetextbox.click();
				editaddress_zipcodetextbox.clear();
				editaddress_zipcodetextbox.sendKeys(product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddressDetailsDone() {
		try {
			Generics.waitForElement(driver, editaddress_donebutton);
			editaddress_donebutton.click();
			Generics.waitForElement(driver, addressdetailsupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void editBankDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editbankdetails_accountnumbertextbox);
				editbankdetails_accountnumbertextbox.click();
				editbankdetails_accountnumbertextbox.clear();
				editbankdetails_accountnumbertextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, editbankdetails_banknametextbox);
				editbankdetails_banknametextbox.click();
				editbankdetails_banknametextbox.clear();
				editbankdetails_banknametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, editbankdetails_ifsctextbox);
				editbankdetails_ifsctextbox.click();
				editbankdetails_ifsctextbox.clear();
				editbankdetails_ifsctextbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, editbankdetails_accounttypetextbox);
				editbankdetails_accounttypetextbox.click();
				editbankdetails_accounttypetextbox.clear();
				editbankdetails_accounttypetextbox.sendKeys(product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddBankDetails() {
		try {
			Generics.waitForElement(driver, bankdetails_addbankdetailsbutton);
			bankdetails_addbankdetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void addBankDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editbankdetails_accountnumbertextbox);
				editbankdetails_accountnumbertextbox.click();
				editbankdetails_accountnumbertextbox.clear();
				editbankdetails_accountnumbertextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, editbankdetails_banknametextbox);
				editbankdetails_banknametextbox.click();
				editbankdetails_banknametextbox.clear();
				editbankdetails_banknametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, editbankdetails_ifsctextbox);
				editbankdetails_ifsctextbox.click();
				editbankdetails_ifsctextbox.clear();
				editbankdetails_ifsctextbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, editbankdetails_accounttypetextbox);
				editbankdetails_accounttypetextbox.click();
				editbankdetails_accounttypetextbox.clear();
				editbankdetails_accounttypetextbox.sendKeys(product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBankDetailsDone() {
		try {
			Generics.waitForElement(driver, editbankdetails_donebutton);
			editbankdetails_donebutton.click();
			Generics.waitForElementToInvisible(driver, editbankdetails_donebutton_spinner);
			Generics.waitForElement(driver, bankdetailsnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCreditAnswers() {
		try {
			Generics.waitForElement(driver, creditanswerstab);
			creditanswerstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickInvestorQuestionGroup1Accordion() {
		try {
			Generics.waitForElement(driver, investorquestiongroupaccordionlink);
			investorquestiongroupaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateInvestorQuestionGroup1(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, downpaymenttextbox);
				assertEquals(downpaymenttextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, borrowernationalitydropdown);
				Select borrowerNationalityOptions = new Select(borrowernationalitydropdown);
				WebElement borrowerNationality = borrowerNationalityOptions.getFirstSelectedOption();
				assertEquals(borrowerNationality.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editInvestorQuestionGroup1(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, downpaymenttextbox);
				downpaymenttextbox.click();
				downpaymenttextbox.clear();
				downpaymenttextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, borrowernationalitydropdown);
				Select borrowerNationalityOptions = new Select(borrowernationalitydropdown);
				borrowerNationalityOptions.selectByVisibleText(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickInvestorQuestionGroup1Submit() {
		try {
			Generics.waitForElement(driver, creditanswers_submitbutton);
			creditanswers_submitbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSupportingDocuments() {
		try {
			Generics.waitForElement(driver, supportingdocumentstab);
			supportingdocumentstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateSupportingDocuments(int i, String serialnumber, String documentcategory, String documentdetails, boolean visiblity) {
		try {
			Generics.waitForElement(driver, supportingdocument_serialnumber.get(i));
			assertEquals(supportingdocument_serialnumber.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, supportingdocument_documentcategory.get(i));
			assertEquals(supportingdocument_documentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, supportingdocument_documentname.get(i));
//			assertEquals(supportingdocument_documentname.get(i).getText(), documentdetails);
			
			Generics.waitForElement(driver, supportingdocument_visibletoinvestor.get(i));
			assertEquals(supportingdocument_visibletoinvestor.get(i).isSelected(), visiblity);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void changeInvestorStatus(String product) {
		try {
			Generics.waitForElement(driver, investorstatusdropdown);
			Select investorOptions = new Select(investorstatusdropdown);
			investorOptions.selectByVisibleText(product);
			Generics.waitForElement(driver, statuschangenotification);
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
			Generics.waitForElementToInvisible(driver, deposit_spinner);
			Generics.waitForElement(driver, transactionnotification);
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
			Generics.waitForElement(driver, transactionnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateContracts(int i, String contractname, String contractcurrentstatus, String contractaccepteduploadedby,
			String accepteduploadedbyproduct) {
		try {
			Generics.waitForElement(driver, contract_contractnametext.get(i));
			assertEquals(contract_contractnametext.get(i).getText(), contractname);

			Generics.waitForElement(driver, contract_currentstatustext.get(i));
			assertEquals(contract_currentstatustext.get(i).getText(), contractcurrentstatus);

			Generics.waitForElement(driver, contract_accepteduploadedbytext.get(i));
			assertEquals(contract_accepteduploadedbytext.get(i).getText(), contractaccepteduploadedby);

			Generics.waitForElement(driver, contract_acceptuploadedatstatus.get(i));
			assertEquals(contract_acceptuploadedatstatus.get(i).getText(), accepteduploadedbyproduct);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickTransactions() {
		try {
			Generics.waitForElement(driver, transactionstab);
			transactionstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCompletedTransactionAccordion() {
		try {
			Generics.waitForElement(driver, completedtransactionaccordionlink);
			completedtransactionaccordionlink.click();
			Thread.sleep(1000);
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
	
	public void validateIfInvestorIsDisabled() {
		try {
			Thread.sleep(2000);
			Generics.waitForElement(driver, titledropdown);
			assertEquals(titledropdown.getAttribute("disabled"), "true");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateIfInvestorIsEnabled() {
		try {
			Generics.waitForElement(driver, titledropdown);
			assertEquals(titledropdown.isEnabled(), true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSupportingDocument() {
		try {
			Generics.waitForElement(driver, supportingdocumentstab);
			supportingdocumentstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void previewDocument() {
		try {
			Generics.waitForElement(driver, document_viewbutton.get(0));
			document_viewbutton.get(0).click();
			Generics.waitForElement(driver, document_preview_closebutton);
			document_preview_closebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void uploadDocument(String filepath) {
		try {
			Generics.waitForElement(driver, document_uploadbutton.get(0));
			document_uploadbutton.get(0).click();
		
			Generics.waitForElement(driver, document_choosefilebutton);
			document_choosefilebutton.sendKeys(filepath);
			
			Generics.waitForElement(driver, document_donebutton);
			document_donebutton.click();
			
			Generics.waitForElement(driver, documentuploadnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDocument() {
		try {
			Generics.waitForElement(driver, document_uploadbutton.get(0));
			document_uploadbutton.get(0).click();
			
			Generics.waitForElement(driver, document_deletebutton.get(0));
			document_deletebutton.get(0).click();
			
			Generics.waitForElement(driver, documentdeletenotification);
			
			Generics.waitForElement(driver, document_popupclosebutton);
			document_popupclosebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateDocumentCount(String filename, int count) {
		try {
			Generics.waitForElement(driver, document_uploadbutton.get(0));
			document_uploadbutton.get(0).click();
			assertEquals(supportingdocumentuploadedfilecount.size(), count);
			Generics.waitForElement(driver, document_popupclosebutton);
			document_popupclosebutton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void downloadDocument() {
		try {
			Generics.waitForElement(driver, document_downloadbutton.get(0));
			document_downloadbutton.get(0).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


public int getBankDetailsCount() {
		return Generics.getElementCount(bankdetails_accountnumbertext);
	}

	public void validateBankDetails(int n, int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, bankdetails_accountnumbertext.get(n));
				assertEquals(bankdetails_accountnumbertext.get(n).getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, bankdetails_accounttypetext.get(n));
				assertEquals(bankdetails_accounttypetext.get(n).getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, bankdetails_banknametext.get(n));
				assertEquals(bankdetails_banknametext.get(n).getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, bankdetails_ifsctext.get(n));
				assertEquals(bankdetails_ifsctext.get(n).getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBankDetailsEdit(int n) {
		try {
			Generics.waitForElement(driver, bankdetails_editbutton.get(n));
			bankdetails_editbutton.get(n).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// Divya:

	public void validateBankDetailsInPopup(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editbankdetails_accountnumbertextbox);
				assertEquals(editbankdetails_accountnumbertextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, editbankdetails_banknametextbox);
				assertEquals(editbankdetails_banknametextbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, editbankdetails_ifsctextbox);
				assertEquals(editbankdetails_ifsctextbox.getAttribute("value"), product);
				break;

			case 3:
				Generics.waitForElement(driver, editbankdetails_accounttypetextbox);
				assertEquals(editbankdetails_accounttypetextbox.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBankDetailsDelete(int i) {
		try {
			Generics.waitForElement(driver, bankdetails_deletebutton.get(i));
			bankdetails_deletebutton.get(i).click();
			Generics.alertAction(driver, "Yes");
			Generics.waitForElement(driver, deletebankdetailsnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void close_bankdetails() {
		try {
			Generics.waitForElement(driver, bankdetails_closebutton);
			bankdetails_closebutton.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void validateAddressDetailsInPopup(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editaddress_line1textbox);
				assertEquals(editaddress_line1textbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, editaddress_line2textbox);
				assertEquals(editaddress_line2textbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, editaddress_line3textbox);
				assertEquals(editaddress_line3textbox.getAttribute("value"), product);
				break;

			case 3:
				Generics.waitForElement(driver, editaddress_statetextbox);
				assertEquals(editaddress_statetextbox.getAttribute("value"), product);
				break;

			case 4:
				Generics.waitForElement(driver, editaddress_citytextbox);
				assertEquals(editaddress_citytextbox.getAttribute("value"), product);
				break;

			case 5:
				Generics.waitForElement(driver, editaddress_zipcodetextbox);
				assertEquals(editaddress_zipcodetextbox.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void close_addressdetailspopup() {
		try {
			Generics.waitForElement(driver, editaddress_closebutton);
			editaddress_closebutton.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void noBankDetailsMessage(String text) {
		try {
			Generics.waitForElement(driver, nobankdetailsnotification);
			assertEquals(nobankdetailsnotification.getText(), text);

		} catch (InterruptedException e) {
			e.printStackTrace();
			;
		}
	}
	
	


}