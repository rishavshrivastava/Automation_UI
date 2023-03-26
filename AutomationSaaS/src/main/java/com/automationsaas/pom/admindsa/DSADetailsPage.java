package com.automationsaas.pom.admindsa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class DSADetailsPage extends Base {

	public WebDriver driver;

	public DSADetailsPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// @FindBy(xpath = "//h1")

	@FindBy(xpath = "//div[@id='top_detail_table']//h1")
	private WebElement dsaidtext;

	@FindBy(xpath = "//div[@id='top_detail_table']//label/span")
	private WebElement dsastatustext;

	@FindBy(id = "followingStatus")
	private WebElement dsastatusdropdown;

	@FindBy(id = "availableCashHeader")
	private WebElement accountbalancetext;

	@FindBy(xpath = "//a[contains(text(),'Deposit')]")
	private WebElement depositbutton;

	@FindBy(xpath = "//div[3]//div[2]//a[contains(text(),'Withdraw')]")
	private WebElement withdrawbutton;

	// Divya 7th Jan

	// tabs

	@FindBy(xpath = "//li[@class='active']//b[contains(text(),'Details')]")
	private WebElement detailstab;

	@FindBy(xpath = "//li[@class='active']//b[contains(text(),'Applied Loans')]")
	private WebElement appliedloanstab;

	@FindBy(xpath = "//a[contains(text(),'Company Details')]")
	private WebElement companydetailstab;

	@FindBy(xpath = "//a[@name='showTransactionDetail_Ajx']")
	private WebElement transactionstab;

	@FindBy(xpath = "//a[contains(text(),'Bank Details')]")
	private WebElement bankdetailstab;

	@FindBy(xpath = "//a[contains(text(),'Credit Answers')]")
	private WebElement creditanswerstab;

	@FindBy(xpath = "//a[contains(text(),'DSA Question Group 1')]")
	private WebElement dsaquestiongroup1accordionlink;

	// withdraw,deposit buttons

	@FindBy(xpath = "//form[@id='transactionDepositForm']//input[@id='transactionAmount']")
	private WebElement deposit_transactionamounttextbox;

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

	// Details section

	@FindBy(xpath = "//div[@id='loadProfilePicTemplate']//h6")
	private WebElement dsaemailtext;

	@FindBy(id = "title")
	private WebElement titledropdown;

	@FindBy(id = "firstName")
	private WebElement firstnametextbox;

	@FindBy(id = "lastName")
	private WebElement lastnametextbox;

	@FindBy(id = "parentDsaUuid")
	private WebElement parentnamedropdown;

	@FindBy(id = "branchName")
	private WebElement dsabranchnamedropdown;

	@FindBy(id = "gender")
	private WebElement genderdropdown;

	@FindBy(xpath = "//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")

	private List<WebElement> datelinks;

	@FindBy(id = "dsaProfileTextVariable1")

	private WebElement dsaprofiletextvariable1textbox;

	@FindBy(xpath = " //input[contains(@id,'dsaProfileDateVariable1')]")

	private WebElement dsaprofiledatevariable1textbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")

	private WebElement yeardropdown1;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")

	private WebElement monthdropdown1;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")

	private List<WebElement> datelinks1;

	@FindBy(id = "updateDSABasicDetailButton")

	private WebElement detailsupdatebutton;

	@FindBy(id = "waitingSpinnerBasicDetail")

	private WebElement detailsupdatespinner;

	// Address details

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1])[1]")

	private WebElement addressdetailsserialnumbertext;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='Address Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Address Name']/preceding-sibling::th)+1])[1]")

	private WebElement adressnametext;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='Line1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Line1']/preceding-sibling::th)+1])[1]")

	private WebElement line1text;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='Line2']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Line2']/preceding-sibling::th)+1])[1]")

	private WebElement line2text;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='Line3']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Line3']/preceding-sibling::th)+1])[1]")

	private WebElement line3text;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='Sub District']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Sub District']/preceding-sibling::th)+1])[1]")
	private WebElement subdistricttext;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='District']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='District']/preceding-sibling::th)+1])[1]")
	private WebElement districttext;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='Country']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Country']/preceding-sibling::th)+1])[1]")
	private WebElement countrytext;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='Ownership Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Ownership Type']/preceding-sibling::th)+1])[1]")
	private WebElement ownershiptypetext;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='Living Since']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Living Since']/preceding-sibling::th)+1])[1]")
	private WebElement livingsincetext;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='City']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='City']/preceding-sibling::th)+1])[1]")

	private WebElement citytext;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='City']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='City']/preceding-sibling::th)+2])[1]")

	private WebElement statetext;

	@FindBy(xpath = "(//div[@id='addressDetailTable']//th[.='City']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='City']/preceding-sibling::th)+3])[1]")

	private WebElement zipcodetext;

	// applied loans tab
	// Transaction tab

	@FindBy(xpath = "//div[@id='transactionDiv']//strong")

	private WebElement notransactiontextforcompletedtransaction;

	@FindBy(xpath = "//div[@id='dsaLoanDetailDiv']//th[.='Amount(Rs)']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount(Rs)']/preceding-sibling::th)+1]")

	private WebElement appliedloansamounttext;

	@FindBy(xpath = "//div[@id='dsaLoanDetailDiv']//th[.='Interest(%)']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Interest(%)']/preceding-sibling::th)+1]")

	private WebElement appliedloaninteresttext;

	@FindBy(xpath = "/div[@id='dsaLoanDetailDiv']//th[contains(text(),'Type')]/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[contains(text(),'Type')]/preceding-sibling::th)+1]")

	private WebElement appliedloantypetext;

	@FindBy(xpath = "//div[@id='dsaLoanDetailDiv']//th[.='Loan Id']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Id']/preceding-sibling::th)+1]")

	private WebElement appliedloanidtext;

	@FindBy(xpath = "//div[@id='dsaLoanDetailDiv']//th[.='Loan Tenure']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Tenure']/preceding-sibling::th)+1]")

	private WebElement appliedloantenuretext;

	@FindBy(xpath = "//div[@id='dsaLoanDetailDiv']//th[.='Details']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Details']/preceding-sibling::th)+1]")

	private WebElement appliedloanloandetailsbutton;

	// address edit , delete

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_line1']")

	private WebElement address_updateform_line1textbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_line2']")

	private WebElement address_updateform_line2textbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_line3']")

	private WebElement address_updateform_line3textbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_subDistrict']")
	private WebElement address_updateform_subdistricttextbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_district']")
	private WebElement address_updateform_districttextbox;

	// @FindBy(xpath =
	// "//div[@id='modal-dsa-address']//input[@id='modal_address_state']")
	@FindBy(xpath = "//select[@id='modal_address_state']")
	private WebElement address_updateform_statetextbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_city']")
	private WebElement address_updateform_citytextbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_country']")
	private WebElement address_updateform_countrytextbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_zipCode']")
	private WebElement address_updateform_zipcodetextbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//input[@id='modal_address_livingSince']")
	private WebElement address_updateform_livingsincetextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement address_updateform_livingsinceyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement address_updateform_livingsincemonthdropdown;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//select[@id='modal_address_ownershipType']")
	private WebElement address_updateform_ownershiptypetextbox;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//button[@id='createOrEditAddressBtn']")
	private WebElement address_updateform_donebutton;

	@FindBy(xpath = "//div[@id='waitingCreateOrEditAddressBtn']//img")

	private WebElement address_updateform_donespinner;

	@FindBy(xpath = "//div[@id='addressDetailTable']//button[@class='btn btn-icon btn-primary loanBorrowerAddressBtn']/i")
	private WebElement addressdetails_editbutton;

	@FindBy(xpath = "//div[@id='addressDetailTable']//button[@class='btn btn-icon btn-danger loanBorrowerAddressBtn']/i")
	private WebElement addressdetails_deletebutton;

	@FindBy(xpath = "//div[@id='modal-dsa-address']//following-sibling::div//button[text()='×']")
	private WebElement addresseditmodal_closeicon;
	// documents

	@FindBy(xpath = "//div[@id='dsaDocumentsTableDiv']//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> document_serialnumber;

	@FindBy(xpath = "//div[@id='dsaDocumentsTableDiv']//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Category']/preceding-sibling::th)+1]")
	private List<WebElement> document_documentcategory;

	@FindBy(xpath = "//div[@id='dsaDocumentsTableDiv']//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)+1]")
	private List<WebElement> document_documentname;

	// documents download:

	// company details tab

	@FindBy(xpath = "//input[@id='name']")
	private WebElement companynametextbox;

	@FindBy(xpath = "//input[@id='registrationCode']")
	private WebElement registrationcodetextbox;

	@FindBy(xpath = "//input[@id='dsaCompanyTextVariable1']")

	private WebElement dsacompanytextvariable1textbox;

	@FindBy(xpath = "//input[contains(@id,'dsaCompanyDateVariable1')]")

	private WebElement dsacompanydatevariable1textbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")

	private WebElement companyvariableyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")

	private WebElement companyvariablemonthdropdown;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")

	private List<WebElement> companyvariabledatelinks;

	@FindBy(xpath = "//input[@id='line1']")

	private WebElement addressline1;

	@FindBy(xpath = "//input[@id='line2']")

	private WebElement addressline2;

	@FindBy(xpath = "//input[@id='line3']")

	private WebElement addressline3;

	@FindBy(xpath = "//select[@id='state']")

	private WebElement addressstate;

	@FindBy(xpath = "//input[@id='city']")

	private WebElement addresscity;

	@FindBy(xpath = "//input[@id='zipCode']")

	private WebElement addresszipcode;

	@FindBy(xpath = "//input[@id='updateDSACompanyDetailButton']")

	private WebElement companydetails_updatebutton;

	@FindBy(xpath = "//span[text()='Profile Updated']")
	private WebElement updatenotification;

	// bank details tab

	@FindBy(xpath = "//div[@id='bank_details_list']//button[@id='edit_bank_detail_modal_opener']")

	private WebElement bankdetails_editbutton;

	@FindBy(xpath = "//div[@id='bank_details_list']//button[@name='bankDetaileleteLink']")

	private List<WebElement> bankdetails_deletebutton;

	@FindBy(xpath = "//span[contains(text(),'Deleted')]")
	private WebElement bankdetails_deletenotifications;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Account Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Number']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_accountnumbertext;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Account Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Type']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_accounttypetext;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_banknametext;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='IFSC']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='IFSC']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_ifsctext;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Account Holder Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Holder Name']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_accountholdername;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Bank Address']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Address']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_bankaddress;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Branch Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Branch Name']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_branchname;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='MIRC Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='MIRC Code']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_mirccode;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Date Of Opening Account']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Date Of Opening Account']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_dateofopeningaccount;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Swift Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Swift Code']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_swiftcode;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Branch Pin Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Branch Pin Code']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_branchpincode;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Branch City']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Branch City']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_branchcity;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Nature Of Facility']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Nature Of Facility']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_natureoffacility;

	@FindBy(xpath = "//div[@id='bank_details_list']//th[.='Bank Detail Text Variable 1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Detail Text Variable 1']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetails_bankdetailtextvariable1;

	@FindBy(xpath = "//button[@id='bank_detail_modal_opener']")
	private WebElement bankdetails_addbankdetailsbutton;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='accountNumber']")
	private WebElement editbankdetails_accountnumbertextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='bankName']")
	private WebElement editbankdetails_banknametextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='ifsc']")
	private WebElement editbankdetails_ifsctextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='bankAccountType']")
	private WebElement editbankdetails_accounttypetextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='accountHolderName']")
	private WebElement editbankdetails_accountholdernametextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='bankAddress']")
	private WebElement editbankdetails_bankaddresstextbox;

	@FindBy(xpath = "//input[contains(@id,'dateOfOpeningAccount')]")
	private WebElement editbankdetails_dateofopeningacctextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement editbankdetails_dateofopeningaccmonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement editbankdetails_dateofopeningaccyear;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> editbankdetails_dateofopeningaccdatelinks;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='micr']")
	private WebElement editbankdetails_micrtextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='branchName']")
	private WebElement editbankdetails_branchnametextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='swiftCode']")
	private WebElement editbankdetails_swiftcodetextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='branchPinCode']")
	private WebElement editbankdetails_branchpincodetextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='branchCity']")
	private WebElement editbankdetails_branchcitytextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='natureOfFacility']")
	private WebElement editbankdetails_natureoffacilitytextbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='bankDetailTextVariable1']")
	private WebElement editbankdetails_bankdetailtextvariable1textbox;

	@FindBy(xpath = "//form[@id='bankDetailForm']//button[@id='submitBankDetailsButton']")
	private WebElement editbankdetails_donebutton;

	@FindBy(xpath = "//div[@id='waitingSubmitBankDetailsButton']//img")
	private WebElement editbankdetails_donebutton_spinner;

	// Credit Answers

	@FindBy(xpath = "//label[text()='Down Payment']/following-sibling::input")
	private WebElement downpaymenttextbox;

	@FindBy(xpath = "//label[text()='Borrower Nationality']/following-sibling::select")
	private WebElement borrowernationalitydropdown;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement creditanswers_submitbutton;

	@FindBy(xpath = "//span[contains(text(),'updated successfully')]")
	private WebElement questiongroupupdatenotification;

	// DSA Upload Contracts

	@FindBy(xpath = "//*[@id='viewContractDetail']//i")
	private WebElement uploadicon;

	@FindBy(xpath = "//*[@id='contractId']")
	private WebElement documentdropdown;

	@FindBy(xpath = "//*[@id='editLoanApplicationDocumentForm']//input[1]")
	private WebElement choosefile;

	@FindBy(xpath = "//*[@id='updateLoanDocumentModal']//h4")
	private WebElement documentheaderpopup;

	@FindBy(xpath = "//*[@id='updateLoanDocumentModal']//div[3]//button")
	private WebElement uploadbutton;

	@FindBy(xpath = "//*[@id='documentDetailTable']//td[1]")
	private WebElement contractname;

	@FindBy(xpath = "//*[@id='documentDetailTable']//td[7]")
	private WebElement downloadcontractlink;

	@FindBy(xpath = "//button[@name='contractDeleteLink']")
	private WebElement deletecontractlink;

	@FindBy(xpath = "//*[@id='contractId']//option[1]")
	private WebElement contractoptionone;

	@FindBy(xpath = "//*[@id='contractId']//option[2]")
	private WebElement contractoptiontwo;
	//
	@FindBy(xpath = "//span[contains(text(),'Contract Deleted')]")
	private WebElement deletecontractnotification;

	@FindBy(xpath = "//span[contains(text(),'success')]")
	private WebElement uploadcontractsuccessnotification;

	@FindBy(xpath = "//*[@id='documentDetailTable']//strong")
	private WebElement nocontractdisplaymessage;

	// IdentityNumbers 1 & 2
	@FindBy(xpath = "//li[@id='basic_profile_tab']//a") // identityNumberOne
	private WebElement basicdetailstablabel;

	@FindBy(xpath = "//*[@id='identityNumberOne']")
	private WebElement identitynumberonetextbox;

	@FindBy(xpath = "//*[@id='identityNumberTwo']")
	private WebElement identitynumbertwotextbox;

	@FindBy(xpath = "//*[@id='companyIdentityNumberOne']")
	private WebElement companyidentitynumberonetextbox;

	@FindBy(xpath = "//*[@id='companyIdentityNumberTwo']")
	private WebElement companyidentitynumbertwotextbox;

	@FindBy(xpath = "//span[text()='Details Updated Succesfully !']")
	private WebElement dsaDetailsUpdatedNotification;

	@FindBy(xpath = "//span[text()='DSA Profile Updated']")
	private WebElement detailsUpdatedNotification;

	@FindBy(xpath = "//*[@id='basicDetailAjaxDiv']//li")
	private WebElement invalididentitynumbererrormessage;

	// *[@id="companyDetailDsa"]//li
	@FindBy(xpath = "//*[@id=\"companyDetailDsa\"]//li")
	private WebElement invalidcompanyidentitynumbererrormessage;

	// Address accordion
	@FindBy(xpath = "//a[contains(.,'Address Details')]")
	private WebElement addressaccordion;

	// Documents accordion
	@FindBy(xpath = "//div[@id='dsaDocumentsTableDiv']//a[contains(.,'Documents')]")
	private WebElement documentsaccordion;

	@FindBy(xpath = "//div[@id='viewContractDetail']//a[contains(text(),'Contracts')]")
	private WebElement contractsaccordion;

	@FindBy(xpath = "//button[@id='submitBankDetailsButton']")
	private WebElement addbankdetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'Successfully')]")
	private WebElement bankdetails_notifications;

	@FindBy(xpath = "//div[@id='bank_details_list']/strong")
	private WebElement nobankdetailstext;

	@FindBy(xpath = "//div[@id='bankDetails']//a[contains(text(),'Bank Details')]")
	private WebElement bankdetailsaccordion;

	@FindBy(xpath = "//a[contains(text(),'Completed Transactions')]")
	private WebElement completedtransactionaccordion;
// validation

	// details tab

	public void validateDsaId(String dsaId) {

		try {

			Generics.waitForElement(driver, dsaidtext);

			assertEquals(dsaidtext.getText(), dsaId);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void validateDsaStatus(String dsastatus, String dsastatusfromdropdown) {

		try {

			Generics.waitForElement(driver, dsastatustext);

			assertEquals(dsastatustext.getText(), dsastatus);

			Generics.waitForElement(driver, dsastatusdropdown);

			Select dsadropdownstatusoption = new Select(dsastatusdropdown);

			WebElement dsadropdownstatus = dsadropdownstatusoption.getFirstSelectedOption();

			assertEquals(dsadropdownstatus.getText(), dsastatusfromdropdown);

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

	public void validateDsaEmailId(String dsaemailid) {

		try {

			Generics.waitForElement(driver, dsaemailtext);

			assertEquals(dsaemailtext.getText(), dsaemailid);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void validateDsaDetails(int i, String product) {

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

				Generics.waitForElement(driver, dsabranchnamedropdown);

				Select dsabranchname = new Select(dsabranchnamedropdown);

				WebElement dsabranchnameoption = dsabranchname.getFirstSelectedOption();

				assertEquals(dsabranchnameoption.getText(), product);

				break;

			case 4:

				Generics.waitForElement(driver, genderdropdown);

				Select gender = new Select(genderdropdown);

				WebElement genderoption = gender.getFirstSelectedOption();

				assertEquals(genderoption.getText(), product);

				break;

			case 5:

				Generics.waitForElement(driver, dateofbirthtextbox);

				assertEquals(dateofbirthtextbox.getAttribute("value"), product);

				break;

			case 6:

				Generics.waitForElement(driver, dsaprofiletextvariable1textbox);

				assertEquals(dsaprofiletextvariable1textbox.getAttribute("value"), product);

				break;

			case 7:

				Generics.waitForElement(driver, identitynumberonetextbox);
				// String value=identitynumberonetextbox.getText();
				System.out.println(identitynumberonetextbox.getAttribute("value"));
				System.out.println("product=" + product);
				boolean startsWith = identitynumberonetextbox.getAttribute("value").startsWith("xxxxxxxx");
				boolean endsWith = identitynumberonetextbox.getAttribute("value").endsWith(product);
				System.out.println("endsWith=" + endsWith);
				assertEquals(startsWith, true, "Identity Number One does not starts with prefix 'xxxxxxxx' masking");
				assertEquals(endsWith, true, "Last 4 digits of Identity Number One is not matching.");
				break;

			case 8:

				Generics.waitForElement(driver, identitynumbertwotextbox);
				String value2 = identitynumbertwotextbox.getAttribute("value");
				boolean startsWith2 = value2.startsWith("xxxxxx");
				boolean endsWith2 = value2.endsWith(product);
				assertEquals(true, startsWith2, "Identity Number Two does not starts with prefix 'xxxxxx' masking");
				assertEquals(true, endsWith2, "Last 4 digits of Identity Number Two is not matching.");
				break;

//			case 7:
//
//				Generics.waitForElement(driver, dsaprofiledatevariable1textbox);
//
//				assertEquals(dsaprofiledatevariable1textbox.getAttribute("value"), product);
//
//				break;

			/*
			 * 
			 * case 8: Generics.waitForElement(driver, addressdetailsserialnumbertext);
			 * 
			 * assertEquals(addressdetailsserialnumbertext.getText(), product); break;
			 * 
			 * 
			 * 
			 * case 9: Generics.waitForElement(driver, adressnametext);
			 * 
			 * assertEquals(adressnametext.getText(), product); break;
			 * 
			 * 
			 * 
			 * case 10: Generics.waitForElement(driver, line1text);
			 * 
			 * assertEquals(line1text.getText(), product); break;
			 * 
			 * 
			 * 
			 * case 11: Generics.waitForElement(driver, line2text);
			 * 
			 * assertEquals(line2text.getText(), product); break;
			 * 
			 * 
			 * 
			 * case 12: Generics.waitForElement(driver, line3text);
			 * 
			 * assertEquals(line3text.getText(), product); break;
			 * 
			 * 
			 * 
			 * case 13: Generics.waitForElement(driver, citytext);
			 * 
			 * assertEquals(citytext.getText(), product); break;
			 * 
			 * 
			 * 
			 * case 14: Generics.waitForElement(driver, statetext);
			 * 
			 * assertEquals(statetext.getText(), product); break;
			 * 
			 * 
			 * 
			 * case 15: Generics.waitForElement(driver, zipcodetext);
			 * 
			 * assertEquals(zipcodetext.getText(), product); break;
			 * 
			 */

			default:

				Reporter.log("No value found", true);

			}

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void editDsaDetails(int i, String product, String year, String month, String date) {

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

				Generics.waitForElement(driver, genderdropdown);

				Select gender = new Select(genderdropdown);

				gender.selectByVisibleText(product);

				break;

			case 4:

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

			case 5:

				Generics.waitForElement(driver, dsaprofiletextvariable1textbox);

				dsaprofiletextvariable1textbox.click();

				dsaprofiletextvariable1textbox.clear();

				dsaprofiletextvariable1textbox.sendKeys(product);

				break;

			case 6:

				Generics.waitForElement(driver, dsaprofiledatevariable1textbox);

				dsaprofiledatevariable1textbox.click();

				Generics.waitForElement(driver, yeardropdown1);

				Select years1 = new Select(yeardropdown1);

				years1.selectByVisibleText(year);

				Generics.waitForElement(driver, monthdropdown1);

				Select months1 = new Select(monthdropdown1);

				months1.selectByVisibleText(month);

				for (int j = 0; j < datelinks1.size(); j++) {

					if (datelinks1.get(j).getText().equalsIgnoreCase(date)) {

						datelinks1.get(j).click();

					}

				}

				break;

			default:

				Reporter.log("No value found", true);

			}

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void clickUpdateDsaDetails() {

		try {

			Generics.waitForElement(driver, detailsupdatebutton);

			detailsupdatebutton.click();

			Generics.waitForElementToInvisible(driver, detailsupdatespinner);
//			WebElement updateNotification = driver.findElement(By.xpath("//span[contains(text(),'Updated Successfully')]"));
//			Generics.waitForElement(driver, updateNotification);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	// Address details

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
				Generics.waitForElement(driver, subdistricttext);
				assertEquals(subdistricttext.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, districttext);
				assertEquals(districttext.getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, citytext);
				assertEquals(citytext.getText(), product);
				break;

			case 8:
				Generics.waitForElement(driver, countrytext);
				assertEquals(countrytext.getText(), product);
				break;

			case 9:
				Generics.waitForElement(driver, statetext);
				assertEquals(statetext.getText(), product);
				System.out.println(statetext.getText());
				break;

			case 10:
				Generics.waitForElement(driver, zipcodetext);
				System.out.println(zipcodetext.getText());
				assertEquals(zipcodetext.getText(), product);
				break;

			case 11:
				Generics.waitForElement(driver, livingsincetext);
				assertEquals(livingsincetext.getText(), product);
				break;

			case 12:
				Generics.waitForElement(driver, ownershiptypetext);
				assertEquals(ownershiptypetext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void editAddressDetails(int i, String product, String year, String month, String date) {

		try {

			switch (i) {

			case 0:

				Generics.waitForElement(driver, address_updateform_line1textbox);

				address_updateform_line1textbox.click();

				address_updateform_line1textbox.clear();

				address_updateform_line1textbox.sendKeys(product);

				break;

			case 1:

				Generics.waitForElement(driver, address_updateform_line2textbox);

				address_updateform_line2textbox.click();

				address_updateform_line2textbox.clear();

				address_updateform_line2textbox.sendKeys(product);

				break;

			case 2:

				Generics.waitForElement(driver, address_updateform_line3textbox);

				address_updateform_line3textbox.click();

				address_updateform_line3textbox.clear();

				address_updateform_line3textbox.sendKeys(product);

				break;

			case 3:
				Generics.waitForElement(driver, address_updateform_subdistricttextbox);
				address_updateform_subdistricttextbox.click();
				address_updateform_subdistricttextbox.clear();
				address_updateform_subdistricttextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, address_updateform_districttextbox);
				address_updateform_districttextbox.click();
				address_updateform_districttextbox.clear();
				address_updateform_districttextbox.sendKeys(product);
				break;

			case 5:

				Generics.waitForElement(driver, address_updateform_statetextbox);
				address_updateform_statetextbox.click();
				Select stateOptions = new Select(address_updateform_statetextbox);
				stateOptions.selectByVisibleText(product);
				break;

			case 6:

				Generics.waitForElement(driver, address_updateform_citytextbox);

				address_updateform_citytextbox.click();

				address_updateform_citytextbox.clear();

				address_updateform_citytextbox.sendKeys(product);

				break;

			case 7:
				Generics.waitForElement(driver, address_updateform_countrytextbox);
				address_updateform_countrytextbox.click();
				address_updateform_countrytextbox.clear();
				address_updateform_countrytextbox.sendKeys(product);
				break;

			case 8:

				Generics.waitForElement(driver, address_updateform_zipcodetextbox);

				address_updateform_zipcodetextbox.click();

				address_updateform_zipcodetextbox.clear();

				address_updateform_zipcodetextbox.sendKeys(product);
				break;

			case 9:

				Generics.waitForElement(driver, address_updateform_livingsincetextbox);
				address_updateform_livingsincetextbox.click();
				Generics.waitForElement(driver, address_updateform_livingsinceyeardropdown);
				Select years = new Select(address_updateform_livingsinceyeardropdown);
				years.selectByVisibleText(year);
				Generics.waitForElement(driver, address_updateform_livingsincemonthdropdown);
				Select months = new Select(address_updateform_livingsincemonthdropdown);
				months.selectByVisibleText(month);
				for (int j = 0; j < datelinks.size(); j++) {
					if (datelinks.get(j).getText().equalsIgnoreCase(date)) {
						datelinks.get(j).click();
					}
				}
				break;

			case 10:

				Generics.waitForElement(driver, address_updateform_ownershiptypetextbox);
				address_updateform_ownershiptypetextbox.click();
				Select addresstype = new Select(address_updateform_ownershiptypetextbox);
				addresstype.selectByVisibleText(product);
				break;

			default:

				Reporter.log("No value found", true);

			}

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

	public void clickSaveEditAddress() {

		try {

			Generics.waitForElement(driver, address_updateform_donebutton);

			address_updateform_donebutton.click();

			Generics.waitForElementToInvisible(driver, address_updateform_donespinner);
		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	// validation of basic details after updating these fields

	public void validateBasicDetail(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select titleoptions = new Select(titledropdown);
				WebElement title = titleoptions.getFirstSelectedOption();
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
				Generics.waitForElement(driver, genderdropdown);
				Select genderoptions = new Select(genderdropdown);
				WebElement gender = genderoptions.getFirstSelectedOption();
				assertEquals(gender.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, dateofbirthtextbox);
				assertEquals(dateofbirthtextbox.getAttribute("value"), product);
				break;

			case 5:
				Generics.waitForElement(driver, dsaprofiletextvariable1textbox);
				assertEquals(dsaprofiletextvariable1textbox.getAttribute("value"), product);
				break;

			case 6:
				Generics.waitForElement(driver, dsaprofiledatevariable1textbox);
				assertEquals(dsaprofiledatevariable1textbox.getAttribute("value"), product);
				break;

			case 7:
				Generics.waitForElement(driver, line1text);
				assertEquals(line1text.getAttribute("value"), product);
				break;

			case 8:
				Generics.waitForElement(driver, line2text);
				assertEquals(line2text.getAttribute("value"), product);
				break;

			case 9:
				Generics.waitForElement(driver, line3text);
				assertEquals(line3text.getAttribute("value"), product);
				break;

			case 10:
				Generics.waitForElement(driver, citytext);
				assertEquals(citytext.getAttribute("value"), product);
				break;

			case 11:
				Generics.waitForElement(driver, statetext);
				assertEquals(statetext.getAttribute("value"), product);
				break;

			case 12:
				Generics.waitForElement(driver, zipcodetext);
				assertEquals(zipcodetext.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// validation of address details after updating

	public void validateUpdatedAddressDetail(int i, String product) {
		try {
			switch (i) {

//			case 0:
//				Generics.waitForElement(driver, addressdetailsserialnumbertext);
//				assertEquals(addressdetailsserialnumbertext.getText(), product);
//				break;
//
//			case 1:
//				Generics.waitForElement(driver, adressnametext);
//				assertEquals(adressnametext.getText(), product);
//				break;
			case 0:
				Generics.waitForElement(driver, address_updateform_line1textbox);
				assertEquals(address_updateform_line1textbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, address_updateform_line2textbox);
				assertEquals(address_updateform_line2textbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, address_updateform_line3textbox);
				assertEquals(address_updateform_line3textbox.getAttribute("value"), product);
				break;

			case 3:
				Generics.waitForElement(driver, address_updateform_subdistricttextbox);
				assertEquals(address_updateform_subdistricttextbox.getAttribute("value"), product);
				break;

			case 4:
				Generics.waitForElement(driver, address_updateform_districttextbox);
				assertEquals(address_updateform_districttextbox.getAttribute("value"), product);
				break;

			case 5:
				Generics.waitForElement(driver, address_updateform_statetextbox);
				assertEquals(address_updateform_statetextbox.getAttribute("value"), product);
				break;

			case 6:
				Generics.waitForElement(driver, address_updateform_citytextbox);
				assertEquals(address_updateform_citytextbox.getAttribute("value"), product);
				break;

			case 7:
				Generics.waitForElement(driver, address_updateform_countrytextbox);
				assertEquals(address_updateform_countrytextbox.getAttribute("value"), product);
				break;

			case 8:
				Generics.waitForElement(driver, address_updateform_zipcodetextbox);
				assertEquals(address_updateform_zipcodetextbox.getAttribute("value"), product);
				break;

			case 9:
				Generics.waitForElement(driver, address_updateform_livingsincetextbox);
				assertEquals(address_updateform_livingsincetextbox.getAttribute("value"), product);
				break;

			case 10:
				Generics.waitForElement(driver, address_updateform_ownershiptypetextbox);
				assertEquals(address_updateform_ownershiptypetextbox.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void closeAddressEditOverlay() {
		try {
			Generics.waitForElement(driver, addresseditmodal_closeicon);
			addresseditmodal_closeicon.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Upload Document

	public void uploadDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("//div[@id='dsaDocumentsTableDiv']//td[text()='"
					+ filename + "']//following-sibling::td//i[contains(@class,'upload')]"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//div[@id='documentPopUpDiv']//form/div/input"));

			// WebElement chooseFileLink = driver
			// .findElement(By.xpath("//form[@id='dsaDocumentForm']//div/input
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement uploadDoneButton = driver
					.findElement(By.xpath("(//form[@id='dsaDocumentForm']/div//button)[1]"));
			Generics.waitForElement(driver, uploadDoneButton);
			uploadDoneButton.click();

			WebElement uploadNotification = driver
					.findElement(By.xpath("//span[contains(text(),'uploaded successfully')]"));
			Generics.waitForElement(driver, uploadNotification);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// view download
	public void clickViewDocument(String filename) {
		try {
			WebElement viewDocument = driver.findElement(By.xpath("//div[@id='dsaDocumentsTableDiv']//td[text()='"
					+ filename + "']//following-sibling::td//i[contains(@class,'eye')]"));
			Generics.waitForElement(driver, viewDocument);
			viewDocument.click();

			WebElement closeDocument = driver.findElement(
					By.xpath("//div[@id='documentPopUpDiv']/following-sibling::div//button[@class='close']"));
			Generics.waitForElement(driver, closeDocument);
			closeDocument.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// download documents
	public void clickDownloadDocument(String filename) {
		try {
			WebElement downloadIcon = driver.findElement(By.xpath("//div[@id='dsaDocumentsTableDiv']//td[text()='"
					+ filename + "']//following-sibling::td//i[contains(@class,'download')]"));
			// @FindBy(xpath ="//div[@id='dsaDocumentsTableDiv']//td/a")
			// @FindBy(xpath ="//div[@id='dsaDocumentsTableDiv']//td[text()='Adhar
			// Card']//following-sibling::td/a

			Generics.waitForElement(driver, downloadIcon);
			downloadIcon.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Validate downloaded document

	public boolean validateDownloadedDocument(String expfilename) {

		File[] files = new File(upload_contractfile_path).listFiles();

		for (File file : files) {
			if (file.getName().contains(expfilename)) {
				return true;
			}
		}
		return false;

	}
	// delete and view document from pop up

	public void viewAndDeleteDocument(String filename) {
		try {
			WebElement uploadButton = driver.findElement(By.xpath("//div[@id='dsaDocumentsTableDiv']//td[text()='"
					+ filename + "']//following-sibling::td//i[contains(@class,'upload')]"));
			Generics.waitForElement(driver, uploadButton);
			uploadButton.click();

			WebElement viewDocument = driver.findElement(By.xpath(
					"//div[@id='supportingDocumentListToDelete']//following-sibling::td//i[contains(@class,'eye')]"));
			Generics.waitForElement(driver, viewDocument);
			viewDocument.click();

			WebElement closeDocument = driver.findElement(
					By.xpath("//div[@id='modal_for_doc_preview']//following-sibling::div/button[@class='close']"));
			Generics.waitForElement(driver, closeDocument);
			closeDocument.click();

			WebElement deleteIcon = driver.findElement(
					By.xpath("//div[@id='supportingDocumentListToDelete']//button[contains(@class,'delete')]"));
			Generics.waitForElement(driver, deleteIcon);
			deleteIcon.click();

			WebElement closePopup = driver
					.findElement(By.xpath("//div[@id='documentPopUpDiv']//following-sibling::div/button"));
			Generics.waitForElement(driver, closePopup);
			closePopup.click();

			WebElement deleteNotification = driver
					.findElement(By.xpath("//span[contains(text(),'Deleted Successfully')]"));
			Generics.waitForElement(driver, deleteNotification);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// validation of dsa documents

	public void validateDSADetailsDocuments(int i, String serialnumber, String documentcategory,
			String documentdetails) {

		try {
			// driver.navigate().refresh();
			Generics.waitForFewSecondstoLoad(3000);//
			Generics.scrollPage(driver, 800);//
			Generics.waitForElement(driver, document_serialnumber.get(i));
			assertEquals(document_serialnumber.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, document_documentcategory.get(i));
			assertEquals(document_documentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, document_documentname.get(i));
			System.out.println(document_documentname.get(i).getText());/////
			assertTrue(document_documentname.get(i).getText().contains(documentdetails));
			// assertEquals(document_documentname.get(i).getText(), documentdetails);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	// applied loans tab

	// company details tab

	public void clickCompanyDetails() {

		try {

			Generics.waitForElement(driver, companydetailstab);
			companydetailstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCompanyDetails(int i, String product) {

		try {

			switch (i) {

			case 0:
				Generics.waitForElement(driver, companynametextbox);
				assertEquals(companynametextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, registrationcodetextbox);
				assertEquals(registrationcodetextbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, dsacompanytextvariable1textbox);
				assertEquals(dsacompanytextvariable1textbox.getAttribute("value"), product);
				break;

			case 3:
				Generics.waitForElement(driver, dsacompanydatevariable1textbox);
				assertEquals(dsacompanydatevariable1textbox.getAttribute("value"), product);
				break;

			case 4:
				Generics.waitForElement(driver, addressline1);
				assertEquals(addressline1.getAttribute("value"), product);
				break;

			case 5:
				Generics.waitForElement(driver, addressline2);
				assertEquals(addressline2.getAttribute("value"), product);
				break;

			case 6:
				Generics.waitForElement(driver, addressline3);
				assertEquals(addressline3.getAttribute("value"), product);
				break;

			case 7:
				Generics.waitForElement(driver, addressstate);
				Select state = new Select(addressstate);
				WebElement addressstate = state.getFirstSelectedOption();
				assertEquals(addressstate.getText(), product);
				break;

			case 8:
				Generics.waitForElement(driver, addresscity);
				assertEquals(addresscity.getAttribute("value"), product);
				break;

			case 9:
				Generics.waitForElement(driver, addresszipcode);
				assertEquals(addresszipcode.getAttribute("value"), product);
				break;

			case 10:
				Generics.waitForElement(driver, companyidentitynumberonetextbox);
				// String value=identitynumberonetextbox.getText();
				System.out.println(companyidentitynumberonetextbox.getAttribute("value"));
				System.out.println("product=" + product);
				boolean startsWith = companyidentitynumberonetextbox.getAttribute("value").startsWith("xxxxxxxx");
				boolean endsWith = companyidentitynumberonetextbox.getAttribute("value").endsWith(product);
				System.out.println("endsWith=" + endsWith);
				assertEquals(startsWith, true,
						"Company Identity Number One does not starts with prefix 'xxxxxxxx' masking");
				assertEquals(endsWith, true, "Last 4 digits of company Identity Number One is not matching.");

				break;

			case 11:
				Generics.waitForElement(driver, companyidentitynumbertwotextbox);
				// String value=identitynumberonetextbox.getText();
				System.out.println(companyidentitynumbertwotextbox.getAttribute("value"));
				System.out.println("product=" + product);
				boolean startsWith2 = companyidentitynumbertwotextbox.getAttribute("value").startsWith("xxxxxx");
				boolean endsWith2 = companyidentitynumbertwotextbox.getAttribute("value").endsWith(product);
				System.out.println("endsWith=" + endsWith2);
				assertEquals(startsWith2, true,
						"Company Identity Number Two does not starts with prefix 'xxxxxx' masking");
				assertEquals(endsWith2, true, "Last 4 digits of company Identity Number Two is not matching.");

				break;

			default:

				Reporter.log("No value found", true);

			}

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void editCompanyDetails(int i, String product, String year, String month, String date) {

		try {

			switch (i) {

			case 0:

				Generics.waitForElement(driver, companynametextbox);

				companynametextbox.click();

				companynametextbox.clear();

				companynametextbox.sendKeys(product);

				break;

			case 1:

				Generics.waitForElement(driver, registrationcodetextbox);

				registrationcodetextbox.click();

				registrationcodetextbox.clear();

				registrationcodetextbox.sendKeys(product);

				break;

			case 2:

				Generics.waitForElement(driver, dsacompanytextvariable1textbox);

				dsacompanytextvariable1textbox.click();

				dsacompanytextvariable1textbox.clear();

				dsacompanytextvariable1textbox.sendKeys(product);

				break;

			case 3:

				Generics.waitForElement(driver, dsacompanydatevariable1textbox);

				dsacompanydatevariable1textbox.click();

				Generics.waitForElement(driver, companyvariableyeardropdown);

				Select years = new Select(companyvariableyeardropdown);

				years.selectByVisibleText(year);

				Generics.waitForElement(driver, companyvariablemonthdropdown);

				Select months = new Select(companyvariablemonthdropdown);

				months.selectByVisibleText(month);

				for (int j = 0; j < datelinks.size(); j++) {

					if (datelinks.get(j).getText().equalsIgnoreCase(date)) {

						datelinks.get(j).click();

					}

				}

				break;

			case 4:

				Generics.waitForElement(driver, addressline1);

				addressline1.click();

				addressline1.clear();

				addressline1.sendKeys(product);

				break;

			case 5:

				Generics.waitForElement(driver, addressline2);

				addressline2.click();

				addressline2.clear();

				addressline2.sendKeys(product);

				break;

			case 6:

				Generics.waitForElement(driver, addressline3);

				addressline3.click();

				addressline3.clear();

				addressline3.sendKeys(product);

				break;

			case 7:
				Generics.waitForElement(driver, addressstate);
				Select stateOptions = new Select(addressstate);
				stateOptions.selectByVisibleText(product);
				break;

			case 8:

				Generics.waitForElement(driver, addresscity);

				addresscity.click();

				addresscity.clear();

				addresscity.sendKeys(product);

				break;

			case 9:

				Generics.waitForElement(driver, addresszipcode);

				addresszipcode.click();

				addresszipcode.clear();

				addresszipcode.sendKeys(product);

				break;

			default:

				Reporter.log("No value found", true);

			}

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void updateCompanyDetails() {

		try {

			Generics.waitForElement(driver, companydetails_updatebutton);
			companydetails_updatebutton.click();
			Generics.waitForElementToInvisible(driver, detailsupdatespinner);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

	}

	// transactions tab

	public void clickTransactions() {

		try {

			Generics.waitForElement(driver, transactionstab);

			transactionstab.click();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void validateCompletedTransactionNoTransactionText(String text) {

		try {

			Generics.waitForElement(driver, notransactiontextforcompletedtransaction);

			assertEquals(notransactiontextforcompletedtransaction.getText(), text);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	// Bank Details tab

	public void clickBankDetails() {
		try {
			Generics.waitForElement(driver, bankdetailstab);
			bankdetailstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

			case 4:
				Generics.waitForElement(driver, bankdetails_accountholdername.get(n));
				assertEquals(bankdetails_accountholdername.get(n).getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, bankdetails_bankaddress.get(n));
				assertEquals(bankdetails_bankaddress.get(n).getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, bankdetails_branchname.get(n));
				assertEquals(bankdetails_branchname.get(n).getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, bankdetails_mirccode.get(n));
				assertEquals(bankdetails_mirccode.get(n).getText(), product);
				break;

			case 8:
				Generics.waitForElement(driver, bankdetails_dateofopeningaccount.get(n));
				assertEquals(bankdetails_dateofopeningaccount.get(n).getText(), product);
				break;

			case 9:
				Generics.waitForElement(driver, bankdetails_swiftcode.get(n));
				assertEquals(bankdetails_swiftcode.get(n).getText(), product);
				break;

			case 10:
				Generics.waitForElement(driver, bankdetails_branchpincode.get(n));
				assertEquals(bankdetails_branchpincode.get(n).getText(), product);
				break;

			case 11:
				Generics.waitForElement(driver, bankdetails_branchcity.get(n));
				assertEquals(bankdetails_branchcity.get(n).getText(), product);
				break;

			case 12:
				Generics.waitForElement(driver, bankdetails_natureoffacility.get(n));
				assertEquals(bankdetails_natureoffacility.get(n).getText(), product);
				break;

			case 13:
				Generics.waitForElement(driver, bankdetails_bankdetailtextvariable1.get(n));
				assertEquals(bankdetails_bankdetailtextvariable1.get(n).getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBankDetailsEdit() {

		try {

			Generics.waitForElement(driver, bankdetails_editbutton);

			bankdetails_editbutton.click();

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

	public void editBankDetails(int i, String product, String year, String month, String date) {

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

			case 4:
				Generics.waitForElement(driver, editbankdetails_accountholdernametextbox);
				editbankdetails_accountholdernametextbox.click();
				editbankdetails_accountholdernametextbox.clear();
				editbankdetails_accountholdernametextbox.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, editbankdetails_bankaddresstextbox);
				editbankdetails_bankaddresstextbox.click();
				editbankdetails_bankaddresstextbox.clear();
				editbankdetails_bankaddresstextbox.sendKeys(product);
				break;

			case 6:
				Generics.waitForElement(driver, editbankdetails_dateofopeningacctextbox);
				editbankdetails_dateofopeningacctextbox.click();

				Generics.waitForElement(driver, editbankdetails_dateofopeningaccyear);
				Select yeardropdwon = new Select(editbankdetails_dateofopeningaccyear);
				yeardropdwon.selectByVisibleText(year);

				Generics.waitForElement(driver, editbankdetails_dateofopeningaccmonth);
				Select monthdropdwon = new Select(editbankdetails_dateofopeningaccmonth);
				monthdropdwon.selectByVisibleText(month);

				for (int j = 0; j < editbankdetails_dateofopeningaccdatelinks.size(); j++) {
					if (editbankdetails_dateofopeningaccdatelinks.get(j).getText().equalsIgnoreCase(date)) {
						editbankdetails_dateofopeningaccdatelinks.get(j).click();
					}
				}
				break;

			case 7:
				Generics.waitForElement(driver, editbankdetails_micrtextbox);
				editbankdetails_micrtextbox.click();
				editbankdetails_micrtextbox.clear();
				editbankdetails_micrtextbox.sendKeys(product);
				break;

			case 8:
				Generics.waitForElement(driver, editbankdetails_branchnametextbox);
				editbankdetails_branchnametextbox.click();
				editbankdetails_branchnametextbox.clear();
				editbankdetails_branchnametextbox.sendKeys(product);
				break;

			case 9:
				Generics.waitForElement(driver, editbankdetails_swiftcodetextbox);
				editbankdetails_swiftcodetextbox.click();
				editbankdetails_swiftcodetextbox.clear();
				editbankdetails_swiftcodetextbox.sendKeys(product);
				break;

			case 10:
				Generics.waitForElement(driver, editbankdetails_branchpincodetextbox);
				editbankdetails_branchpincodetextbox.click();
				editbankdetails_branchpincodetextbox.clear();
				editbankdetails_branchpincodetextbox.sendKeys(product);
				break;

			case 11:
				Generics.waitForElement(driver, editbankdetails_branchcitytextbox);
				editbankdetails_branchcitytextbox.click();
				editbankdetails_branchcitytextbox.clear();
				editbankdetails_branchcitytextbox.sendKeys(product);
				break;

			case 12:
				Generics.waitForElement(driver, editbankdetails_natureoffacilitytextbox);
				editbankdetails_natureoffacilitytextbox.click();
				editbankdetails_natureoffacilitytextbox.clear();
				editbankdetails_natureoffacilitytextbox.sendKeys(product);
				break;

			case 13:
				Generics.waitForElement(driver, editbankdetails_bankdetailtextvariable1textbox);
				editbankdetails_bankdetailtextvariable1textbox.click();
				editbankdetails_bankdetailtextvariable1textbox.clear();
				editbankdetails_bankdetailtextvariable1textbox.sendKeys(product);
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

	public void addBankDetails(int i, String product, String year, String month, String date) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editbankdetails_accountholdernametextbox);
				editbankdetails_accountholdernametextbox.click();
				editbankdetails_accountholdernametextbox.clear();
				editbankdetails_accountholdernametextbox.sendKeys(product);
				break;
			case 1:
				Generics.waitForElement(driver, editbankdetails_accountnumbertextbox);
				editbankdetails_accountnumbertextbox.click();
				editbankdetails_accountnumbertextbox.clear();
				editbankdetails_accountnumbertextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, editbankdetails_banknametextbox);
				editbankdetails_banknametextbox.click();
				editbankdetails_banknametextbox.clear();
				editbankdetails_banknametextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, editbankdetails_bankaddresstextbox);
				editbankdetails_bankaddresstextbox.click();
				editbankdetails_bankaddresstextbox.clear();
				editbankdetails_bankaddresstextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, editbankdetails_ifsctextbox);
				editbankdetails_ifsctextbox.click();
				editbankdetails_ifsctextbox.clear();
				editbankdetails_ifsctextbox.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, editbankdetails_dateofopeningacctextbox);
				editbankdetails_dateofopeningacctextbox.click();

				Generics.waitForElement(driver, editbankdetails_dateofopeningaccyear);
				Select yeardropdown = new Select(editbankdetails_dateofopeningaccyear);
				yeardropdown.selectByVisibleText(year);

				Generics.waitForElement(driver, editbankdetails_dateofopeningaccmonth);
				Select monthdropdown = new Select(editbankdetails_dateofopeningaccmonth);
				monthdropdown.selectByVisibleText(month);

				for (int j = 0; j < editbankdetails_dateofopeningaccdatelinks.size(); j++) {
					if (editbankdetails_dateofopeningaccdatelinks.get(j).getText().equalsIgnoreCase(date)) {
						editbankdetails_dateofopeningaccdatelinks.get(j).click();
					}
				}
				break;

			case 6:
				Generics.waitForElement(driver, editbankdetails_micrtextbox);
				editbankdetails_micrtextbox.click();
				editbankdetails_micrtextbox.clear();
				editbankdetails_micrtextbox.sendKeys(product);
				break;

			case 7:
				Generics.waitForElement(driver, editbankdetails_accounttypetextbox);
				editbankdetails_accounttypetextbox.click();
				editbankdetails_accounttypetextbox.clear();
				editbankdetails_accounttypetextbox.sendKeys(product);
				break;

			case 8:
				Generics.waitForElement(driver, editbankdetails_branchnametextbox);
				editbankdetails_branchnametextbox.click();
				editbankdetails_branchnametextbox.clear();
				editbankdetails_branchnametextbox.sendKeys(product);
				break;

			case 9:
				Generics.waitForElement(driver, editbankdetails_swiftcodetextbox);
				editbankdetails_swiftcodetextbox.click();
				editbankdetails_swiftcodetextbox.clear();
				editbankdetails_swiftcodetextbox.sendKeys(product);
				break;

			case 10:
				Generics.waitForElement(driver, editbankdetails_branchpincodetextbox);
				editbankdetails_branchpincodetextbox.click();
				editbankdetails_branchpincodetextbox.clear();
				editbankdetails_branchpincodetextbox.sendKeys(product);
				break;

			case 11:
				Generics.waitForElement(driver, editbankdetails_branchcitytextbox);
				editbankdetails_branchcitytextbox.click();
				editbankdetails_branchcitytextbox.clear();
				editbankdetails_branchcitytextbox.sendKeys(product);
				break;

			case 12:
				Generics.waitForElement(driver, editbankdetails_natureoffacilitytextbox);
				editbankdetails_natureoffacilitytextbox.click();
				editbankdetails_natureoffacilitytextbox.clear();
				editbankdetails_natureoffacilitytextbox.sendKeys(product);
				break;

			case 13:
				Generics.waitForElement(driver, editbankdetails_bankdetailtextvariable1textbox);
				editbankdetails_bankdetailtextvariable1textbox.click();
				editbankdetails_bankdetailtextvariable1textbox.clear();
				editbankdetails_bankdetailtextvariable1textbox.sendKeys(product);
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

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	// Credit answers tab

	public void clickCreditAnswers() {

		try {

			Generics.waitForElement(driver, creditanswerstab);

			creditanswerstab.click();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void clickDSAQuestionGroup1Accordion() {
		try {
			Generics.waitForElement(driver, dsaquestiongroup1accordionlink);
			dsaquestiongroup1accordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateDsaQuestionGroup1(int i, String product) {

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

	public void editDsaQuestionGroup1(int i, String product) {

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

	public void clickDsaQuestionGroup1Submit() {

		try {

			Generics.waitForElement(driver, creditanswers_submitbutton);
			creditanswers_submitbutton.click();
			Generics.waitForElement(driver, questiongroupupdatenotification);
		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	// DSA status change

	public void changeDsaStatus(String statusoption, String alertoption) {

		try {

			Generics.waitForElement(driver, dsastatusdropdown);

			Select status = new Select(dsastatusdropdown);

			status.selectByVisibleText(statusoption);

			Generics.alertAction(driver, alertoption);

			Thread.sleep(2000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	// Deposit and Withdraw

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

			Generics.waitForElement(driver, deposit_transactionamounttextbox);

			deposit_transactionamounttextbox.click();

			deposit_transactionamounttextbox.clear();

			deposit_transactionamounttextbox.sendKeys(amount);

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

	// Rishav
	public void validateIfDSADetailsIsDisabled() {
		try {
			Thread.sleep(2000);
			Generics.waitForElement(driver, titledropdown);
			assertEquals(titledropdown.getAttribute("disabled"), "true");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfDSADetailsIsEnabled() {
		try {
			Thread.sleep(2000);
			Generics.waitForElement(driver, titledropdown);
			assertEquals(titledropdown.isEnabled(), true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author chandrashekar
	 *
	 */
	public void clickUploadContract() {
		try {
			Generics.waitForElement(driver, uploadicon);
			uploadicon.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void uploadContractDocument(Integer index, String uploadfilepath, String contractName, String notification) {
		try {

			// Generics.scrollPage(driver, 3000);
			Generics.waitForElement(driver, uploadicon);
			uploadicon.click();
			Generics.waitForElement(driver, documentheaderpopup);

			Generics.waitForElement(driver, choosefile);
			choosefile.sendKeys(uploadfilepath);

			Generics.waitForElement(driver, documentdropdown);
			documentdropdown.click();

			Select contract = new Select(documentdropdown);
			contract.selectByIndex(index);
			documentheaderpopup.click();
			uploadbutton.click();

			Generics.waitForElement(driver, uploadcontractsuccessnotification);
			assertEquals(uploadcontractsuccessnotification.getText(), notification);
			contractsaccordion.click();

			Generics.waitForElement(driver, downloadcontractlink);
			assertTrue(downloadcontractlink.isDisplayed(), "Failed to upload the contract");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File file = new File(downloadPath);
		File[] listfiles = file.listFiles();

		for (int i = 0; i < listfiles.length; i++) {
			if (listfiles[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	public void downloadContractDocument(String contractName, String fileName) {
		try {

			Generics.waitForElement(driver, contractname);
			assertEquals(contractname.getText(), contractName);
			Generics.scrollPage(driver, 4500);
			downloadcontractlink.click();
			// Generics.waitForFewSecondstoLoad(2000);
			// assertTrue(isFileDownloaded(upload_contractfile_path, fileName),
			// "Failed to download the contract: " + contractName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void deleteContract(String notification) {
		try {
			Generics.waitForElement(driver, deletecontractlink);
			deletecontractlink.click();
			Generics.waitForElement(driver, deletecontractnotification);
			assertEquals(deletecontractnotification.getText(), notification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyAndDeleteContractifAnyExisting(String product) {

		try {
			Generics.scrollPage(driver, 4500);
			contractsaccordion.click();
			deletecontractlink.click();
			Generics.refreshPage(driver);
			Generics.scrollPage(driver, 4500);
			contractsaccordion.click();
			deletecontractlink.click();

			Generics.refreshPage(driver);
			Generics.scrollPage(driver, 4500);
			contractsaccordion.click();

			Generics.waitForElement(driver, nocontractdisplaymessage);
			assertEquals(nocontractdisplaymessage.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* DSA Basic Details */

	// cmy- id 1-valid case
	public void validateDSAIdentityNumbersValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			Generics generics = new Generics();
			assertTrue(generics.validateregexpattern(regexpattern, identitynumber),
					"Invalid value for the regex pattern configured");
			identitynumberonetextbox.click();
			identitynumberonetextbox.clear();
			identitynumberonetextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, detailsupdatebutton);
			detailsupdatebutton.click();
			Generics.waitForElement(driver, dsaDetailsUpdatedNotification);
			assertEquals(dsaDetailsUpdatedNotification.getText(), "Details Updated Succesfully !",
					"Unable to update the DSA basic details with the valid IdenityNumberOne");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	//// cmy- id 1-invalid case
	public void validateDSAIdentityNumbersInValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			// Generics.waitForElement(driver, basicdetailstablabel);
			Generics generics = new Generics();
			// assert.assertFalse(condition, message);
			assertFalse(generics.validateregexpattern(regexpattern, identitynumber),
					"Regex pattern is accepting the invalid identity Number");
			identitynumberonetextbox.click();
			identitynumberonetextbox.clear();
			identitynumberonetextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, detailsupdatebutton);
			detailsupdatebutton.click();
			Generics.waitForElement(driver, invalididentitynumbererrormessage);
			assertEquals(invalididentitynumbererrormessage.getText().trim(),
					"Identity number one should follow ^[0-9]{12}$ regex pattern");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	// cmy- id 2-valid case
	public void validateDSAIdentityNumberTwoValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			// Generics.waitForElement(driver, basicdetailstablabel);
			Generics generics = new Generics();
			assertTrue(generics.validateregexpattern(regexpattern, identitynumber),
					"Invalid value(Idenitity Number Two) for the regex pattern configured");
			identitynumbertwotextbox.click();
			identitynumbertwotextbox.clear();
			identitynumbertwotextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, detailsupdatebutton);
			detailsupdatebutton.click();
			Generics.waitForElement(driver, dsaDetailsUpdatedNotification);
			assertEquals(dsaDetailsUpdatedNotification.getText(), "Details Updated Succesfully !",
					"Unable to update the DSA basic details with the valid IdenityNumberOne");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	//// cmy- id 2-invalid case
	public void validateDSAIdentityNumberTwoInValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			// Generics.waitForElement(driver, basicdetailstablabel);
			Generics generics = new Generics();
			// assert.assertFalse(condition, message);
			assertFalse(generics.validateregexpattern(regexpattern, identitynumber),
					"Regex pattern is accepting the invalid identity Number");
			identitynumbertwotextbox.click();
			identitynumbertwotextbox.clear();
			identitynumbertwotextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, detailsupdatebutton);
			detailsupdatebutton.click();
			Generics.waitForElement(driver, invalididentitynumbererrormessage);
			assertEquals(invalididentitynumbererrormessage.getText().trim(),
					"Identity number two should follow ^[A-Z]{5}[0-9]{4}[A-Z]{1}$ regex pattern");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/* DSA company Details */

	// cmy- id 1-valid case
	public void validateDSACompanyIdentityNumberOneValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			clickCompanyDetails();
			Generics.waitForElement(driver, companydetailstab);
			Generics generics = new Generics();
			System.out.println(identitynumber);
			assertTrue(generics.validateregexpattern(regexpattern, identitynumber),
					"Invalid value for the regex pattern configured");
			companyidentitynumberonetextbox.click();
			companyidentitynumberonetextbox.clear();
			companyidentitynumberonetextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, companydetails_updatebutton);
			companydetails_updatebutton.click();
			Generics.waitForElement(driver, detailsUpdatedNotification);
			assertEquals(detailsUpdatedNotification.getText(), "DSA Profile Updated",
					"Unable to update the DSA basic details with the valid IdenityNumberOne");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	//// cmy- id 1-invalid case
	public void validateDSACompanyIdentityNumbeOneInValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			clickCompanyDetails();
			Generics.waitForElement(driver, companydetailstab);
			Generics generics = new Generics();
			System.out.println(identitynumber);
			assertFalse(generics.validateregexpattern(regexpattern, identitynumber),
					"Regex pattern is accepting the invalid identity Number");
			companyidentitynumberonetextbox.click();
			companyidentitynumberonetextbox.clear();
			companyidentitynumberonetextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, companydetails_updatebutton);
			companydetails_updatebutton.click();
			Generics.waitForElement(driver, invalidcompanyidentitynumbererrormessage);
			assertEquals(invalidcompanyidentitynumbererrormessage.getText().trim(),
					"Identity number one should follow ^[0-9]{12}$ regex pattern");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	// cmy- id 2-valid case
	public void validateDSACompanyIdentityNumberTwoValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			clickCompanyDetails();
			Generics.waitForElement(driver, companydetailstab);
			Generics generics = new Generics();
			System.out.println(identitynumber);
			assertTrue(generics.validateregexpattern(regexpattern, identitynumber),
					"Invalid value(Idenitity Number Two) for the regex pattern configured");
			companyidentitynumbertwotextbox.click();
			companyidentitynumbertwotextbox.clear();
			companyidentitynumbertwotextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, companydetails_updatebutton);
			companydetails_updatebutton.click();
			Generics.waitForElement(driver, detailsUpdatedNotification);
			assertEquals(detailsUpdatedNotification.getText(), "DSA Profile Updated",
					"Unable to update the DSA company details with the valid IdenityNumberTwo");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	//// cmy- id 2-invalid case
	public void validateDSACompanyIdentityNumberTwoInValidCase(String regexpattern, String identitynumber) {
		try {
			Generics.refreshPage(driver);
			clickCompanyDetails();
			Generics.waitForElement(driver, companydetailstab);
			Generics generics = new Generics();
			System.out.println(identitynumber);
			assertFalse(generics.validateregexpattern(regexpattern, identitynumber),
					"Regex pattern is accepting the invalid identity Number");
			companyidentitynumbertwotextbox.click();
			companyidentitynumbertwotextbox.clear();
			companyidentitynumbertwotextbox.sendKeys(identitynumber);
			Generics.waitForElement(driver, companydetails_updatebutton);
			companydetails_updatebutton.click();
			Generics.waitForElement(driver, invalidcompanyidentitynumbererrormessage);
			assertEquals(invalidcompanyidentitynumbererrormessage.getText().trim(),
					"Identity number two should follow ^[A-Z]{5}[0-9]{4}[A-Z]{1}$ regex pattern");

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
			Generics.waitForElement(driver, addressaccordion);
			addressaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickDocumentsAccordion() {
		try {
			Generics.waitForElement(driver, documentsaccordion);
			documentsaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickContractsAccordion() {
		try {
			Generics.waitForElement(driver, contractsaccordion);
			contractsaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getBankDetailsCount() {
		return Generics.getElementCount(bankdetails_accountnumbertext);
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

	public void validateIfNoBankDetails(String value) {
		try {
			Generics.waitForElement(driver, nobankdetailstext);
			assertEquals(nobankdetailstext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBankDetailsAccordion() {
		try {
			Generics.waitForElement(driver, bankdetailsaccordion);
			bankdetailsaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCompletedTransactionsAccordion() {
		try {
			Generics.waitForElement(driver, completedtransactionaccordion);
			completedtransactionaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
