package com.automationsaas.pom.adminborrower;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class BorrowerDetailsPage {

	public WebDriver driver;

	public BorrowerDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//b[text()='Details']")
	private WebElement detailstab;

	@FindBy(xpath = "//li[@id='userTransaction']//a[contains(text(),'Transactions')]")
	private WebElement transactionstab;
	
	@FindBy(xpath="//a[contains(text(),'Completed Transactions')]")
	private WebElement completedtransactionaccordionlink;

	@FindBy(xpath = "//li[@id='borrowerPreviosLoan']//a[contains(text(),'Previous Loans')]")
	private WebElement previosuloantab;
	
	@FindBy(xpath="//div[@id='previousLoans']//a[contains(text(),'Previous Loans')]")
	private WebElement previousloanaccordionlink;

	@FindBy(xpath = "//div[@id='top_detail_table']//h1")
	private WebElement borroweridtext;

	@FindBy(xpath = "//label[@id='loanOverviewStatus']//span")
	private WebElement borrowerstatustext;

	@FindBy(id = "followingStatus")
	private WebElement borrowerstatusdropdown;

	@FindBy(id = "availableCashHeader")
	private WebElement accountbalancetext;

	@FindBy(xpath = "//span[@id='availableCashHeader']/../../following-sibling::div//a[contains(text(),'Deposit')]")
	private WebElement depositbutton;

	@FindBy(xpath = "//span[@id='availableCashHeader']/../../following-sibling::div//a[contains(text(),'Withdraw')]")
	private WebElement withdrawbutton;

	@FindBy(xpath = "//form[@id='transactionDepositForm']//input[@id='transactionAmount']")
	private WebElement deposit_transactionamount;

	@FindBy(id = "completeDepositTransactiobBtn")
	private WebElement depositsubmitbutton;

	@FindBy(xpath = "//div[@id='waitingSpinnerDepositTransactionModel']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement deposit_spinner;

	@FindBy(xpath = "//div[@id='waitingSpinnerWithdrawTransactionModel']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement withdraw_spinner;

	@FindBy(xpath = "//span[contains(text(),'Transaction Completed Successfully')]")
	private WebElement transactionnotification;

	@FindBy(xpath = "//form[@id='transactionWithdrawForm']//input[@id='transactionAmount']")
	private WebElement withdraw_transactionamount;

	@FindBy(id = "completeWithdrawTransactiobBtn")
	private WebElement withdrawsubmitbutton;

	@FindBy(xpath = "//div[@id='loadProfilePicTemplate']//h6")
	private WebElement borroweremailtext;
	
	@FindBy(xpath="//a[contains(text(),'Bank Details')]")
	private WebElement bankdetailsaccordionlink;

	@FindBy(id = "title")
	private WebElement titledropdown;

	@FindBy(id = "firstName")
	private WebElement firstnametextbox;

	@FindBy(id = "lastName")
	private WebElement lastnametextbox;

	@FindBy(xpath = "//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks;

	@FindBy(id = "gender")
	private WebElement genderdropdown;

	@FindBy(id = "maritalStatus")
	private WebElement maritialstatusdropdown;
	
	@FindBy(xpath = "//input[@id='identityNumberOne']")
	private WebElement identitynumberone;
	
	@FindBy(xpath = "//input[@id='identityNumberTwo']")
	private WebElement identitynumbertwo;
	
	@FindBy(xpath = "//div[@id='basicDetailAjaxDiv']//ul/li[1]")
	private WebElement identitynumberoneerrormessage;
	
	@FindBy(xpath = "//div[@id='basicDetailAjaxDiv']//ul/li[2]")
	private WebElement identitynumbertwoerrormessage;
	
	@FindBy(id = "borrowerProfileTextVariable1")
	private WebElement borrowerprofiletextvariable1dropdown;

	@FindBy(xpath = "//div[@id='submitButtonBasicDetail']//button[text()='Update']")
	private WebElement detailsupdatebutton;

	@FindBy(id = "waitingSpinnerBasicDetail")
	private WebElement detailsupdatespinner;
	
	@FindBy(xpath= "//span[contains(text(),'Updated Successfully')]")
	private WebElement borrowerdetailupdatenotification;
	
	@FindBy(xpath="//a[contains(text(),'Profile Info')]")
	private WebElement profileinfoaccordionlink;
	
	@FindBy(id = "workExperience")
	private WebElement workexperiencetextbox;

	@FindBy(id = "jobType")
	private WebElement employmentcategorydropdown;

	@FindBy(id = "grossIncome")
	private WebElement grossincometextbox;

	@FindBy(xpath = "//div[@id='submitButtonIndividualDetail']//button[text()='Update']")
	private WebElement profileinfoupdatebutton;
	
	@FindBy(xpath="//a[contains(.,'Employment Histroy Info')]")
	private WebElement employmenthistoryaccordionlink;

	@FindBy(id = "organizationName")
	private WebElement organizationtextbox;

	@FindBy(id = "department")
	private WebElement departmentdropdown;

	@FindBy(id = "designation")
	private WebElement designationdropdown;

	@FindBy(id = "employeeId")
	private WebElement employeeidtextbox;

	@FindBy(xpath = "//div[@id='submitButtonEmploymentHistory']//button[text()='Update']")
	private WebElement employmenthistoryinfoupdatebutton;
	
	@FindBy(xpath="//a[contains(.,'Address Details')]")
	private WebElement addressdetailsaccordionlink;

	@FindBy(xpath = "//div[@id='addressDetailTable']//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private WebElement addressdetailsserialnumbertext;

	@FindBy(xpath = "//div[@id='addressDetailTable']//th[.='Address Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Address Name']/preceding-sibling::th)+1]")
	private WebElement adressnametext;

	@FindBy(xpath = "//div[@id='addressDetailTable']//th[.='Line1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Line1']/preceding-sibling::th)+1]")
	private WebElement line1text;

	@FindBy(xpath = "//div[@id='addressDetailTable']//th[.='Line2']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Line2']/preceding-sibling::th)+1]")
	private WebElement line2text;

	@FindBy(xpath = "//div[@id='addressDetailTable']//th[.='Line3']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Line3']/preceding-sibling::th)+1]")
	private WebElement line3text;

	@FindBy(xpath = "//div[@id='addressDetailTable']//th[.='City']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='City']/preceding-sibling::th)+1]")
	private WebElement citytext;

	@FindBy(xpath = "//div[@id='addressDetailTable']//th[.='State']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='State']/preceding-sibling::th)+1]")
	private WebElement statetext;

	@FindBy(xpath = "//div[@id='addressDetailTable']//th[.='Zip Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Zip Code']/preceding-sibling::th)+1]")
	private WebElement zipcodetext;
	
	@FindBy(xpath="//div[@id='bank_details_list']//th[.='Account Holder Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Holder Name']/preceding-sibling::th)+1]")
	private List<WebElement> accountholdernametext;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Account Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Number']/preceding-sibling::th)+1]")
	private List<WebElement> accountnumbertext;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Account Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Type']/preceding-sibling::th)+1]")
	private List<WebElement> accounttypetext;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private List<WebElement> banknametext;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='IFSC']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='IFSC']/preceding-sibling::th)+1]")
	private List<WebElement> ifsctext;

	@FindBy(xpath="//div[@id='bank_details_list']/strong")
	private WebElement nobankdetailstext;
	
	@FindBy(xpath = "//div[@id='transactionDiv']//strong")
	private WebElement notransactionforcompletedtransactiontext;

	@FindBy(xpath = "//div[@id='previousLoans']//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)+1]")
	private WebElement previousloanemailtext;

	@FindBy(xpath = "//div[@id='previousLoans']//th[.='Loan Id']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Id']/preceding-sibling::th)+1]")
	private WebElement previousloanloanidtext;

	@FindBy(xpath = "//div[@id='previousLoans']//th[.='Amount(Rs)']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount(Rs)']/preceding-sibling::th)+1]")
	private WebElement previousloanamounttext;

	@FindBy(xpath = "//div[@id='previousLoans']//th[.='Loan Tenure']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Tenure']/preceding-sibling::th)+1]")
	private WebElement previousloanloantenuretext;

	@FindBy(xpath = "//div[@id='previousLoans']//th[.='Interest(%)']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Interest(%)']/preceding-sibling::th)+1]")
	private WebElement previousloaninteresttext;

	@FindBy(xpath = "//div[@id='previousLoans']//th[.='Loan Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Status']/preceding-sibling::th)+1]")
	private WebElement previousloanloanstatustext;

	@FindBy(xpath = "//div[@id='previousLoans']//th[.='Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type']/preceding-sibling::th)+1]")
	private WebElement previousloantypetext;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_line1']")
	private WebElement address_editform_line1textbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_line2']")
	private WebElement address_editform_line2textbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_line3']")
	private WebElement address_editform_line3textbox;

	@FindBy(xpath = "(//label[contains(text(),'State')]/..//select[@id='modal_address_state'])[1]")
	private WebElement address_editform_statetextdropdown;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_city']")
	private WebElement address_editform_citytextbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_zipCode']")
	private WebElement address_editform_zipcodetextbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//button[@id='createOrEditAddressBtn']")
	private WebElement address_editform_donebutton;

	@FindBy(xpath = "//div[@id='waitingCreateOrEditAddressBtn']//img")
	private WebElement address_editform_donespinner;

	@FindBy(xpath = "//div[@id='addressDetailTable']//button[@class='btn btn-icon btn-primary loanBorrowerAddressBtn']/i")
	private WebElement addressdetails_editbutton;

	@FindBy(xpath = "//div[@id='addressDetailTable']//button[@class='btn btn-icon btn-danger loanBorrowerAddressBtn']/i")
	private WebElement addressdetails_deletebutton;
	
	@FindBy(id="bank_detail_modal_opener")
	private WebElement bankdetails_addbutton;

	@FindBy(id = "edit_bank_detail_modal_opener")
	private List<WebElement> bankdetails_editbutton;

	@FindBy(xpath = "//div[@id='bankDetailTable']//button[@class='btn btn-icon btn-danger bankDetailButton']/i")
	private List<WebElement> bankdetails_deletebutton;
	
	@FindBy(xpath="//span[contains(text(),'Deleted')]")
	private WebElement bankdetails_deletenotifications;

	@FindBy(id = "accountNumber")
	private WebElement bankdetails_editform_accountnumbertextbox;

	@FindBy(id = "bankName")
	private WebElement bankdetails_editform_banknametextbox;

	@FindBy(id = "ifsc")
	private WebElement bankdetails_editform_ifsctextbox;

	@FindBy(id = "bankAccountType")
	private WebElement bankdetails_editform_accounttypetextbox;

	@FindBy(id = "submitBankDetailsButton")
	private WebElement bankdetails_editform_donebutton;

	@FindBy(xpath = "//div[@id='waitingSubmitBankDetailsButton']//img")
	private WebElement bankdetails_editform_donebuttonspinner;

	@FindBy(id = "workExperience")
	private WebElement profileinfo_workexptextbox;

	@FindBy(id = "jobType")
	private WebElement profileinfo_employmentcategorydropdown;

	@FindBy(id = "grossIncome")
	private WebElement profileinfo_grossincometextbox;

	@FindBy(xpath = "//div[@id='submitButtonIndividualDetail']//button[text()='Update']")
	private WebElement profileinfo_updatebutton;

	@FindBy(id = "organizationName")
	private WebElement employmenthistoryinfo_organizationtextbox;

	@FindBy(id = "department")
	private WebElement employmenthistoryinfo_departmentdropdown;

	@FindBy(id = "designation")
	private WebElement employmenthistoryinfo_designationdropdown;

	@FindBy(id = "employeeId")
	private WebElement employmenthistoryinfo_employeeidtextbox;

	@FindBy(xpath = "//div[@id='submitButtonEmploymentHistory']//button[text()='Update']")
	private WebElement employmenthistoryinfo_updatebutton;

	@FindBy(xpath = "//div[@id='transactionDiv']//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_amounttext;

	@FindBy(xpath = "//div[@id='transactionDiv']//th[.='Remaining Balance']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Remaining Balance']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_remainingbalancetext;

	@FindBy(xpath = "//div[@id='transactionDiv']//th[.='Loan Id']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Id']/preceding-sibling::th)-2]")
	private List<WebElement> completedtransactions_loanidtext;

	@FindBy(xpath = "//div[@id='transactionDiv']//th[.='Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type']/preceding-sibling::th)-1]")
	private List<WebElement> completedtransactions_typetext;

	@FindBy(xpath = "//div[@id='transactionDiv']//th[.='Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Status']/preceding-sibling::th)+1]")
	private List<WebElement> completedtransactions_statustext;
	
	@FindBy(id="accountHolderName")
	private WebElement addbankdetails_accountholdernametextbox;
	
	@FindBy(id="accountNumber")
	private WebElement addbankdetails_accountnumbertextbox;
	
	@FindBy(id="bankName")
	private WebElement addbankdetails_banknametextbox;
	
	@FindBy(id="bankAddress")
	private WebElement addbankdetails_bankaddresstextbox;
	
	@FindBy(id="ifsc")
	private WebElement addbankdetails_ifsctextbox;
	
	@FindBy(id="bankAccountType")
	private WebElement addbankdetails_accounttypetextbox;
	
	@FindBy(id="submitBankDetailsButton")
	private WebElement addbankdetails_donebutton;
	
	@FindBy(xpath="//span[contains(text(),'Successfully')]")
	private WebElement bankdetails_notifications;
	
	@FindBy(id="mobileNumber")
	private WebElement mobilenumbertextbox;
	
	@FindBy(id="landLineNumber")
	private WebElement landlinenumbertextbox;
	
	@FindBy(id="identityNumberThree")
	private WebElement identitynumberthreetextbox;
	
	@FindBy(id="identityNumberFour")
	private WebElement identitynumberfourtextbox;
	
	@FindBy(id="identityNumberFive")
	private WebElement identitynumberfivetextbox;
	
	@FindBy(id="referralCode")
	private WebElement borrowerreferralcode;
	
	
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

	public void validateBorrowerId(String borrowerid) {
		try {
			Generics.waitForElement(driver, borroweridtext);
			assertEquals(borroweridtext.getText(), borrowerid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateBorrowerStatus(String borrowerstatus, String borrowerstatusfromdropdown) {
		try {
			Generics.waitForElement(driver, borrowerstatustext);
			assertEquals(borrowerstatustext.getText(), borrowerstatus);

			Generics.waitForElement(driver, borrowerstatusdropdown);
			Select borrowerdropdownstatusoption = new Select(borrowerstatusdropdown);
			WebElement borrowerdropdownstatus = borrowerdropdownstatusoption.getFirstSelectedOption();
			assertEquals(borrowerdropdownstatus.getText(), borrowerstatusfromdropdown);
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

	public void validateAccountBalance(String accountbalance) {
		try {
			Generics.waitForElement(driver, accountbalancetext);
			assertEquals(accountbalancetext.getText(), accountbalance);
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

	public void validateBorrowerEmailId(String borroweremailid) {
		try {
			Generics.waitForElement(driver, borroweremailtext);
			assertEquals(borroweremailtext.getText(), borroweremailid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateBorrowerDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select title = new Select(titledropdown);
				WebElement titleoption = title.getFirstSelectedOption();
				assertEquals(titleoption.getText(), product);
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
				Select gender = new Select(genderdropdown);
				WebElement genderoption = gender.getFirstSelectedOption();
				assertEquals(genderoption.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, maritialstatusdropdown);
				Select maritialstatus = new Select(maritialstatusdropdown);
				WebElement maritialstatusoption = maritialstatus.getFirstSelectedOption();
				assertEquals(maritialstatusoption.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver,identitynumberone);
				assertEquals(identitynumberone.getAttribute("value"), product);
			    break;
			    
			case 7:
				Generics.waitForElement(driver, identitynumbertwo);
				assertEquals(identitynumbertwo.getAttribute("value"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, borrowerprofiletextvariable1dropdown);
				assertEquals(borrowerprofiletextvariable1dropdown.getAttribute("value"), product);
				break;

			case 9:
				Generics.waitForElement(driver, workexperiencetextbox);
				assertEquals(workexperiencetextbox.getAttribute("value"), product);
				break;

			case 10:
				Generics.waitForElement(driver, employmentcategorydropdown);
				Select employmentcategory = new Select(employmentcategorydropdown);
				WebElement employmentcategoryoption = employmentcategory.getFirstSelectedOption();
				assertEquals(employmentcategoryoption.getText(), product);
				break;

			case 11:
				Generics.waitForElement(driver, grossincometextbox);
				assertEquals(grossincometextbox.getAttribute("value"), product);
				break;

			case 12:
				Generics.waitForElement(driver, organizationtextbox);
				assertEquals(organizationtextbox.getAttribute("value"), product);
				break;

			case 13:
				Generics.waitForElement(driver, departmentdropdown);
				Select department = new Select(departmentdropdown);
				WebElement departmentoption = department.getFirstSelectedOption();
				assertEquals(departmentoption.getText(), product);
				break;

			case 14:
				Generics.waitForElement(driver, designationdropdown);
				Select designation = new Select(designationdropdown);
				WebElement designationoption = designation.getFirstSelectedOption();
				assertEquals(designationoption.getText(), product);
				break;

			case 15:
				Generics.waitForElement(driver, employeeidtextbox);
				assertEquals(employeeidtextbox.getAttribute("value"), product);
				break;

			case 16:
				Generics.waitForElement(driver, addressdetailsserialnumbertext);
				assertEquals(addressdetailsserialnumbertext.getText(), product);
				break;

			case 17:
				Generics.waitForElement(driver, adressnametext);
				assertEquals(adressnametext.getText(), product);
				break;

			case 18:
				Generics.waitForElement(driver, line1text);
				assertEquals(line1text.getText(), product);
				break;

			case 19:
				Generics.waitForElement(driver, line2text);
				assertEquals(line2text.getText(), product);
				break;

			case 20:
				Generics.waitForElement(driver, line3text);
				assertEquals(line3text.getText(), product);
				break;

			case 21:
				Generics.waitForElement(driver, citytext);
				assertEquals(citytext.getText(), product);
				break;

			case 22:
				Generics.waitForElement(driver, statetext);
				assertEquals(statetext.getText(), product);
				break;

			case 23:
				Generics.waitForElement(driver, zipcodetext);
				assertEquals(zipcodetext.getText(), product);
				break;

			case 24:
				Generics.waitForElement(driver, accountnumbertext.get(0));
				assertEquals(accountnumbertext.get(0).getText(), product);
				break;

			case 25:
				Generics.waitForElement(driver, accounttypetext.get(0));
				assertEquals(accounttypetext.get(0).getText(), product);
				break;

			case 26:
				Generics.waitForElement(driver, banknametext.get(0));
				assertEquals(banknametext.get(0).getText(), product);
				break;

			case 27:
				Generics.waitForElement(driver, ifsctext.get(0));
				assertEquals(ifsctext.get(0).getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editBorrowerDetails(int i, String product, String year, String month, String date) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select title = new Select(titledropdown);
				title.selectByVisibleText(product);
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
				Generics.waitForElement(driver, yeardropdown);
				Select years = new Select(yeardropdown);
				years.selectByVisibleText(year);
				Generics.waitForElement(driver, monthdropdown);
				Select months = new Select(monthdropdown);
				months.selectByVisibleText(month);
				for (int j = 0; j < datelinks.size(); j++) {
					if (datelinks.get(j).getText().equalsIgnoreCase(date)) {
						datelinks.get(j).click();
					}
				}
				break;

			case 4:
				Generics.waitForElement(driver, genderdropdown);
				Select gender = new Select(genderdropdown);
				gender.selectByVisibleText(product);
				break;

			case 5:
				Generics.waitForElement(driver, maritialstatusdropdown);
				Select maritialstatus = new Select(maritialstatusdropdown);
				maritialstatus.selectByVisibleText(product);
				break;

			case 6:
				Generics.waitForElement(driver, identitynumberone);
				identitynumberone.click();
				identitynumberone.clear();
				identitynumberone.sendKeys(product);
				break;
				
			case 7:
				Generics.waitForElement(driver, identitynumbertwo);
				identitynumbertwo.click();
				identitynumbertwo.clear();
				identitynumbertwo.sendKeys(product);
				break;
				
			case 8:
				Generics.waitForElement(driver, borrowerprofiletextvariable1dropdown);
				Select borrowerProfileTextVariable1Options = new Select(borrowerprofiletextvariable1dropdown);
				borrowerProfileTextVariable1Options.selectByVisibleText(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//@author: Divya
		public void enterIdentityNumberOne(String identitynumberoneborrower) {
			try {
				Generics.waitForElement(driver, identitynumberone);
				identitynumberone.click();
				identitynumberone.clear();
				identitynumberone.sendKeys(identitynumberoneborrower);
				identitynumbertwo.click();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Reporter.log("Error in enterIdentityNumberOne", true);
			}
		}
		public void enterIdentityNumberTwo(String identitynumbertwoborrower) {
			try {
				Generics.waitForElement(driver, identitynumbertwo);
				identitynumbertwo.click();
				identitynumbertwo.clear();
				identitynumbertwo.sendKeys(identitynumbertwoborrower);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Reporter.log("Error in enterIdentityNumberTwo", true);
			}
		}
		
		public void invalidIdentityNumberErrorMessage() {
			try {
				Generics.waitForElement(driver, identitynumberoneerrormessage);
				identitynumberoneerrormessage.isDisplayed();
				Generics.waitForElement(driver, identitynumbertwoerrormessage);
				identitynumbertwoerrormessage.isDisplayed();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				Reporter.log("Error message not displayed for IdentityNumber", true);
			}
		}
		
		
	public void editProfileInfo(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, profileinfo_workexptextbox);
				profileinfo_workexptextbox.click();
				profileinfo_workexptextbox.clear();profileinfo_workexptextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, profileinfo_employmentcategorydropdown);
				Select employmentCategory = new Select(profileinfo_employmentcategorydropdown);
				employmentCategory.selectByVisibleText(product);
				break;

			case 2:
				Generics.waitForElement(driver, profileinfo_grossincometextbox);
				profileinfo_grossincometextbox.click();
				profileinfo_grossincometextbox.clear();
				profileinfo_grossincometextbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void updateProfileInfo() {
		try {
			Generics.waitForElement(driver, profileinfo_updatebutton);
			profileinfo_updatebutton.click();
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editEmploymentHistoryInfo(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, employmenthistoryinfo_organizationtextbox);
				employmenthistoryinfo_organizationtextbox.click();
				employmenthistoryinfo_organizationtextbox.clear();
				employmenthistoryinfo_organizationtextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, employmenthistoryinfo_departmentdropdown);
				Select department = new Select(employmenthistoryinfo_departmentdropdown);
				department.selectByVisibleText(product);
				break;

			case 2:
				Generics.waitForElement(driver, employmenthistoryinfo_designationdropdown);
				Select designation = new Select(employmenthistoryinfo_designationdropdown);
				designation.selectByVisibleText(product);
				break;

			case 3:
				Generics.waitForElement(driver, employmenthistoryinfo_employeeidtextbox);
				employmenthistoryinfo_employeeidtextbox.click();
				employmenthistoryinfo_employeeidtextbox.clear();
				employmenthistoryinfo_employeeidtextbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void updateEmploymentHistoryInfo() {
		try {
			Generics.waitForElement(driver, employmenthistoryinfo_updatebutton);
			employmenthistoryinfo_updatebutton.click();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editAddressDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, address_editform_line1textbox);
				address_editform_line1textbox.click();
				address_editform_line1textbox.clear();
				address_editform_line1textbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, address_editform_line2textbox);
				address_editform_line2textbox.click();
				address_editform_line2textbox.clear();
				address_editform_line2textbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, address_editform_line3textbox);
				address_editform_line3textbox.click();
				address_editform_line3textbox.clear();
				address_editform_line3textbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, address_editform_statetextdropdown);
				Select stateOptions = new Select(address_editform_statetextdropdown);
				stateOptions.selectByVisibleText(product);
				break;

			case 4:
				Generics.waitForElement(driver, address_editform_citytextbox);
				address_editform_citytextbox.click();
				address_editform_citytextbox.clear();
				address_editform_citytextbox.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, address_editform_zipcodetextbox);
				address_editform_zipcodetextbox.click();
				address_editform_zipcodetextbox.clear();
				address_editform_zipcodetextbox.sendKeys(product);
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
			Generics.waitForElement(driver, bankdetails_addbutton);
			bankdetails_addbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void addBankDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addbankdetails_accountholdernametextbox);
				addbankdetails_accountholdernametextbox.click();
				addbankdetails_accountholdernametextbox.clear();
				addbankdetails_accountholdernametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, addbankdetails_accountnumbertextbox);
				addbankdetails_accountnumbertextbox.click();
				addbankdetails_accountnumbertextbox.clear();
				addbankdetails_accountnumbertextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, addbankdetails_banknametextbox);
				addbankdetails_banknametextbox.click();
				addbankdetails_banknametextbox.clear();
				addbankdetails_banknametextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, addbankdetails_bankaddresstextbox);
				addbankdetails_bankaddresstextbox.click();
				addbankdetails_bankaddresstextbox.clear();
				addbankdetails_bankaddresstextbox.sendKeys(product);
				break;
				
			case 4:
				Generics.waitForElement(driver, addbankdetails_ifsctextbox);
				addbankdetails_ifsctextbox.click();
				addbankdetails_ifsctextbox.clear();
				addbankdetails_ifsctextbox.sendKeys(product);
				break;
				
			case 5:
				Generics.waitForElement(driver, addbankdetails_accounttypetextbox);
				addbankdetails_accounttypetextbox.click();
				addbankdetails_accounttypetextbox.clear();
				addbankdetails_accounttypetextbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddBankDetailsDone() {
		try {
			Generics.waitForElement(driver, addbankdetails_donebutton);
			addbankdetails_donebutton.click();
			Generics.waitForElement(driver, bankdetails_notifications);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editBankDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, bankdetails_editform_accountnumbertextbox);
				bankdetails_editform_accountnumbertextbox.getAttribute("value");
				bankdetails_editform_accountnumbertextbox.click();
				bankdetails_editform_accountnumbertextbox.clear();
				bankdetails_editform_accountnumbertextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, bankdetails_editform_banknametextbox);
				bankdetails_editform_banknametextbox.click();
				bankdetails_editform_banknametextbox.clear();
				bankdetails_editform_banknametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, bankdetails_editform_ifsctextbox);
				bankdetails_editform_ifsctextbox.click();
				bankdetails_editform_ifsctextbox.clear();
				bankdetails_editform_ifsctextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, bankdetails_editform_accounttypetextbox);
				bankdetails_editform_accounttypetextbox.click();
				bankdetails_editform_accounttypetextbox.clear();
				bankdetails_editform_accounttypetextbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void eclickSaveEditBankDetails() {
		try {
			Generics.waitForElement(driver, bankdetails_editform_donebutton);
			bankdetails_editform_donebutton.click();
			Generics.waitForElementToInvisible(driver, bankdetails_editform_donebuttonspinner);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSaveEditAddress() {
		try {
			Generics.waitForElement(driver, address_editform_donebutton);
			address_editform_donebutton.click();
			Generics.waitForElementToInvisible(driver, address_editform_donespinner);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickUpdateBorrowerDetails() {
		try {
			Generics.waitForElement(driver, detailsupdatebutton);
			detailsupdatebutton.click();
			Generics.waitForElementToInvisible(driver, detailsupdatespinner);
		    
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditAddressDetails() {
		try {
			Generics.waitForElement(driver, addressdetails_editbutton);
			addressdetails_editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditBankDetails(int i) {
		try {
			Generics.waitForElement(driver, bankdetails_editbutton.get(i));
			bankdetails_editbutton.get(i).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDeleteBankDetails(int i) {
		try {
			Generics.waitForElement(driver, bankdetails_deletebutton.get(i));
			bankdetails_deletebutton.get(i).click();
			Generics.alertAction(driver, "Yes");
			Generics.waitForElement(driver, bankdetails_deletenotifications);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateIfNoBankDetails(String value) {
		try {
			Generics.waitForElement(driver, nobankdetailstext);
			assertEquals(nobankdetailstext.getText(), value);
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
	
	public void clickCompletedTransactionsAccordion() {
		try {
			Generics.waitForElement(driver, completedtransactionaccordionlink);
			completedtransactionaccordionlink.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCompletedTransactionWhenNoTransaction(String text) {
		try {
			Generics.waitForElement(driver, notransactionforcompletedtransactiontext);
			assertEquals(notransactionforcompletedtransactiontext.getText(), text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCompletedTransactions(int expectedamount, int expectedremainingamount) {
		// Amount
		int a1 = 0;
		for (int i = 0; i < completedtransactions_amounttext.size(); i++) {
			String amount = completedtransactions_amounttext.get(i).getText().replace("Rs", "").replace(",", "");
			int a2 = Integer.parseInt(amount);
			int sum = a1 + a2;
			a1 = sum;
		}
		assertEquals(a1, expectedamount);

		// Remaining Balance
		int b1 = 0;
		for (int i = 0; i < completedtransactions_remainingbalancetext.size(); i++) {
			String amount = completedtransactions_remainingbalancetext.get(i).getText().replace("Rs", "").replace(",",
					"");
			int b2 = Integer.parseInt(amount);
			int sum = b1 + b2;
			b1 = sum;
		}
		assertEquals(b1, expectedremainingamount);
	}

	public void clickPreviousLoan() {
		try {
			Generics.waitForElement(driver, previosuloantab);
			previosuloantab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickPreviousLoanAccordion() {
		try {
			Generics.waitForElement(driver, previousloanaccordionlink);
			previousloanaccordionlink.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validatePreviousLoanDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, previousloanemailtext);
				assertEquals(previousloanemailtext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, previousloanloanidtext);
				assertEquals(previousloanloanidtext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, previousloanamounttext);
				assertEquals(previousloanamounttext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, previousloanloantenuretext);
				assertEquals(previousloanloantenuretext.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, previousloaninteresttext);
				assertEquals(previousloaninteresttext.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, previousloanloanstatustext);
				assertEquals(previousloanloanstatustext.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, previousloantypetext);
				assertEquals(previousloantypetext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void changeBorrowerStatus(String statusoption, String alertoption) {
		try {
			Generics.waitForElement(driver, borrowerstatusdropdown);
			Select status = new Select(borrowerstatusdropdown);
			status.selectByVisibleText(statusoption);
			Generics.alertAction(driver, alertoption);
			Thread.sleep(2000);
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

	public void enterDepositAmount(String amount) {
		try {
			Generics.waitForElement(driver, deposit_transactionamount);
			deposit_transactionamount.click();
			deposit_transactionamount.clear();
			deposit_transactionamount.sendKeys(amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickDepositButton() {
		try {
			Generics.waitForElement(driver, depositsubmitbutton);
			depositsubmitbutton.click();
			Generics.waitForElementToInvisible(driver, deposit_spinner);
			Generics.waitForElement(driver, transactionnotification);
			System.out.println(transactionnotification.getText());
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

	public void enterWithdrawAmount(String amount) {
		try {
			Generics.waitForElement(driver, withdraw_transactionamount);
			withdraw_transactionamount.click();
			withdraw_transactionamount.clear();
			withdraw_transactionamount.sendKeys(amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickWithdrawButton() {
		try {
			Generics.waitForElement(driver, withdrawsubmitbutton);
			withdrawsubmitbutton.click();
			Generics.waitForElementToInvisible(driver, withdraw_spinner);
			Generics.waitForElement(driver, transactionnotification);
			System.out.println(transactionnotification.getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateIfBorrowerIsDisabled() {
		try {
			Thread.sleep(2000);
			Generics.waitForElement(driver, titledropdown);
			assertEquals(titledropdown.getAttribute("disabled"), "true");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateIfBorrowerIsEnabled() {
		try {
			Generics.waitForElement(driver, titledropdown);
			assertEquals(titledropdown.isEnabled(), true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getBankDetailsCount() {
		return Generics.getElementCount(accountnumbertext);
	}
	
	public void validateBankDetails(int n, int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, accountnumbertext.get(n));
				assertEquals(accountnumbertext.get(n).getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, accounttypetext.get(n));
				assertEquals(accounttypetext.get(n).getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, banknametext.get(n));
				assertEquals(banknametext.get(n).getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, ifsctext.get(n));
				assertEquals(ifsctext.get(n).getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, accountholdernametext.get(n));
				assertEquals(accountholdernametext.get(n).getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
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
	
	public void clickAddressDetailsAccordion() {
		try {
			Generics.waitForElement(driver, addressdetailsaccordionlink);
			addressdetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateAddressDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addressdetailsserialnumbertext);
				assertEquals(addressdetailsserialnumbertext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, adressnametext);
				assertEquals(adressnametext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, line1text);
				assertEquals(line1text.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, line2text);
				assertEquals(line2text.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, line3text);
				assertEquals(line3text.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, citytext);
				assertEquals(citytext.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, statetext);
				assertEquals(statetext.getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, zipcodetext);
				assertEquals(zipcodetext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateBorrowerBasicDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select title = new Select(titledropdown);
				WebElement titleoption = title.getFirstSelectedOption();
				assertEquals(titleoption.getText(), product);
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
				Select gender = new Select(genderdropdown);
				WebElement genderoption = gender.getFirstSelectedOption();
				assertEquals(genderoption.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, maritialstatusdropdown);
				Select maritialstatus = new Select(maritialstatusdropdown);
				WebElement maritialstatusoption = maritialstatus.getFirstSelectedOption();
				assertEquals(maritialstatusoption.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver,identitynumberone);
				assertEquals(identitynumberone.getAttribute("value"), product);
			    break;
			    
			case 7:
				Generics.waitForElement(driver, identitynumbertwo);
				assertEquals(identitynumbertwo.getAttribute("value"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, borrowerprofiletextvariable1dropdown);
				assertEquals(borrowerprofiletextvariable1dropdown.getAttribute("value"), product);
				break;
				
			case 9:
				Generics.waitForElement(driver, mobilenumbertextbox);
				assertEquals(mobilenumbertextbox.getAttribute("value"), product);
				break;
				
			case 10:
				Generics.waitForElement(driver, landlinenumbertextbox);
				assertEquals(landlinenumbertextbox.getAttribute("value"), product);
				break;
				
			case 11:
				Generics.waitForElement(driver, identitynumberthreetextbox);
				assertEquals(identitynumberthreetextbox.getAttribute("value"), product);
				break;
				
			case 12:
				Generics.waitForElement(driver, identitynumberfourtextbox);
				assertEquals(identitynumberfourtextbox.getAttribute("value"), product);
				break;
				
			case 13:
				Generics.waitForElement(driver, identitynumberfivetextbox);
				assertEquals(identitynumberfivetextbox.getAttribute("value"), product);
				break;
				
			case 14:
				Generics.waitForElement(driver, borrowerreferralcode);
				assertEquals(borrowerreferralcode.getAttribute("value"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateBasicProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select title = new Select(titledropdown);
				WebElement titleoption = title.getFirstSelectedOption();
				assertEquals(titleoption.getText(), product);
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
				Select gender = new Select(genderdropdown);
				WebElement genderoption = gender.getFirstSelectedOption();
				assertEquals(genderoption.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, maritialstatusdropdown);
				Select maritialstatus = new Select(maritialstatusdropdown);
				WebElement maritialstatusoption = maritialstatus.getFirstSelectedOption();
				assertEquals(maritialstatusoption.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver,identitynumberone);
				assertEquals(identitynumberone.getAttribute("value"), product);
			    break;
			    
			case 7:
				Generics.waitForElement(driver, identitynumbertwo);
				assertEquals(identitynumbertwo.getAttribute("value"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, borrowerprofiletextvariable1dropdown);
				assertEquals(borrowerprofiletextvariable1dropdown.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
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
	
	public void validatePersonalProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, workexperiencetextbox);
				assertEquals(workexperiencetextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, employmentcategorydropdown);
				Select employmentcategory = new Select(employmentcategorydropdown);
				WebElement employmentcategoryoption = employmentcategory.getFirstSelectedOption();
				assertEquals(employmentcategoryoption.getText(), product);
				break;
		
			case 2:
				Generics.waitForElement(driver, grossincometextbox);
				assertEquals(grossincometextbox.getAttribute("value"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEmploymentHistoryInfoAccordion() {
		try {
			Generics.waitForElement(driver, employmenthistoryaccordionlink);
			employmenthistoryaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateEmploymentHistoryInfo(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, organizationtextbox);
				assertEquals(organizationtextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, departmentdropdown);
				Select department = new Select(departmentdropdown);
				WebElement departmentoption = department.getFirstSelectedOption();
				assertEquals(departmentoption.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, designationdropdown);
				Select designation = new Select(designationdropdown);
				WebElement designationoption = designation.getFirstSelectedOption();
				assertEquals(designationoption.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, employeeidtextbox);
				assertEquals(employeeidtextbox.getAttribute("value"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
