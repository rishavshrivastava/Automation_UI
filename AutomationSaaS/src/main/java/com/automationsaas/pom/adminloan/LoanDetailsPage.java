package com.automationsaas.pom.adminloan;

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

public class LoanDetailsPage extends Base {

	public WebDriver driver;

	public LoanDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='top_detail_table']//h1")
	private WebElement loanidtext;
	
	@FindBy(xpath = "//div[@id='loanRepaymentsDiv']//a[contains(text(),'Loan Repayment Schedule')]")
	private WebElement loanrepaymentscheduleaccordionlink;

	@FindBy(id = "followingStatus")
	private WebElement statusdropdown;

	@FindBy(xpath = "//div[@id='disbursement-detail-modal']//button[text()='Submit']")
	private WebElement disbursementnextbutton;

	@FindBy(xpath = "(//button[@id='submit_status_change'])[1]")
	private WebElement nextbutton;

	@FindBy(xpath = "//span[contains(text(),'Updated')]")
	private WebElement loanstatusupdatenotification;

	@FindBy(id = "loanOverviewStatus")
	private WebElement loanstatus;

	@FindBy(xpath = "//div[@id='loanRepaymentsDiv']")
	private WebElement loanrepaymentscheduletable;

	@FindBy(xpath = "//a[contains(text(),'Action')]")
	private WebElement actiondropdown;

	@FindBy(xpath = "//a[contains(text(),'Repayment Schedule Restructure')]")
	private WebElement repaymentschedulerestructure;

	@FindBy(xpath = "//a/b[contains(text(),'Full Settlement')]")
	private WebElement fullsettlementtab;

	@FindBy(xpath = "//a[contains(text(),'Co-Applicant Details')]")
	private WebElement coapplicantaccordionlink;

	@FindBy(id = "changedPrincipal_FULL_SETTLEMENT")
	private WebElement fullsettlementpaymentamounttextbox;

	@FindBy(xpath = "//span[contains(text(),'')]")
	private List<WebElement> notificationslists;

	@FindBy(id = "repaymentInterest_FULL_SETTLEMENT")
	private WebElement remainingrepaymentinteresttextbox;

	@FindBy(id = "repaymentPenalty_FULL_SETTLEMENT")
	private WebElement remainingrepaymentpenaltytextbox;

	@FindBy(id = "repaymentChequeBouncingCharge_FULL_SETTLEMENT")
	private WebElement remainingrepaymentchequebouncingchargetextbox;

	@FindBy(id = "penaltyAmount_FULL_SETTLEMENT")
	private WebElement fullsettlementpenaltytextbox;

	@FindBy(id = "taxAmount_FULL_SETTLEMENT")
	private WebElement fullsettlementtaxtextbox;

	@FindBy(id = "discountAmount_FULL_SETTLEMENT")
	private WebElement fullsettlementdiscounttextbox;

	@FindBy(id = "borrowerAvailableCash_FULL_SETTLEMENT")
	private WebElement fullsettlementborroweravailablecashtext;

	@FindBy(id = "totalAmountPayable_FULL_SETTLEMENT")
	private WebElement totalamounttext;

	@FindBy(id = "netAmountPayable_FULL_SETTLEMENT")
	private WebElement fullsettlementtotalamountminusborroweravailablecashtext;

	@FindBy(id = "submitFullSettlementBtn")
	private WebElement fullsettlementpaybutton;

	@FindBy(xpath = "//a/b[contains(text(),'Partial Repayment')]")
	private WebElement partialrepaymenttab;

	@FindBy(id = "changedPrincipal_EARLY_REPAYMENT")
	private WebElement paymentamounttextbox;

	@FindBy(id = "repaymentInterestRate_EARLY_REPAYMENT")
	private WebElement newinterestdropdown;

	@FindBy(id = "repaymentTenure_EARLY_REPAYMENT")
	private WebElement newtenuredropdown;

	@FindBy(id = "dateForRepayment_EARLY_REPAYMENT")
	private WebElement updaterepaymentdatedropdown;

	@FindBy(name = "allowGapDayRepayment")
	private WebElement allowgapdayinterestcheckbox;

	@FindBy(id = "penaltyAmount_EARLY_REPAYMENT")
	private WebElement earlyrepaymentpenaltytextbox;

	@FindBy(id = "taxAmount_EARLY_REPAYMENT")
	private WebElement earlyrepaymenttaxtextbox;

	@FindBy(id = "discountAmount_EARLY_REPAYMENT")
	private WebElement earlyrepaymentdiscounttextbox;

	@FindBy(id = "borrowerAvailableCash_EARLY_REPAYMENT")
	private WebElement borroweravailablecashtext;

	@FindBy(id = "totalAmountPayable_EARLY_REPAYMENT")
	private WebElement totalAmount;

	@FindBy(id = "netAmountPayable_EARLY_REPAYMENT")
	private WebElement totalamountminusborroweravailablecashtext;

	@FindBy(id = "submitEarlyRepaymentBtn")
	private WebElement paybutton;

	@FindBy(xpath = "//span[text()='Repayment Schedule changed Successfully']")
	private WebElement repaymentschedulechangednotification;

	@FindBy(xpath = "//span[text()='Repayment Schedule Updated']")
	private WebElement repaymentscheduleupdatednotification;

	@FindBy(xpath = "//span[text()='Principal must be same as remaining principal']")
	private WebElement principalmustbesameasremainingprincipalnotification;

	@FindBy(xpath = "//span[text()='In Full Settlement Payment principal must be equal to the Remaining Principal']")
	private WebElement fullsettlementpaynotification;

	@FindBy(xpath = "//span[text()='Remaining Principal must be less than principal for repayment principal']")
	private WebElement remainingprincipalmustbelessthanprincipalforrepaymentprincipalnotification;

	@FindBy(xpath = "//span[text()='Not Enough Balance in Wallet']")
	private WebElement notenoughbalanceinwalletnotification;

	@FindBy(xpath = "//b[text()='Details']")
	private WebElement detailstab;

	@FindBy(xpath = "//b[text()='Borrower ID']/../..//h4")
	private WebElement borroweridtext;

	@FindBy(xpath = "//b[text()='Disbursed date']/../..//h4")
	private WebElement disburseddatetext;

	@FindBy(xpath = "//b[text()='Total Fees']/../..//h4")
	private WebElement totalfeestext;

	@FindBy(xpath = "//b[text()='Total Service Fee']/../..//h4")
	private WebElement totalservicefeetext;

	@FindBy(xpath = "//b[text()='Total Borrower Service Fees']/../..//h4")
	private WebElement totalborrowerservicefeestext;

	@FindBy(xpath = "//b[text()='VAT On Service Fee']/../..//h4")
	private WebElement vatonservicetext;

	@FindBy(xpath = "//b[text()='Loan Id']/../..//h4")
	private WebElement loanidtext_details;

	@FindBy(xpath = "//b[text()='Principal']/../..//h4")
	private WebElement principaltext;

	@FindBy(xpath = "//b[text()='Debt Repayment Term']/../..//h4")
	private WebElement debtrepaymenttext;

	@FindBy(xpath = "//b[text()='Product']/../..//h4")
	private WebElement producttext;

	@FindBy(xpath = "//b[text()='Annual Percentage Rate']/../..//h4")
	private WebElement annualpercentageratetext;

	@FindBy(xpath = "//b[text()='Starting Date']/../..//h4")
	private WebElement startdatetext;

	@FindBy(xpath = "//b[text()='Amount to be Repaid']/../..//h4")
	private WebElement amounttoberepaidtext;

	@FindBy(xpath = "//b[text()='DSA Agent']/../..//h4")
	private WebElement dsaagenttext;

	@FindBy(xpath = "//b[text()='Borrower Name']/../..//h4")
	private WebElement borrowernametext;

	@FindBy(xpath = "//b[text()='Borrower']/../..//h4")
	private WebElement borrowertext;

	@FindBy(xpath = "//b[text()='Assign To Admin :']/../..//h4")
	private WebElement assigntoadmintext;

	@FindBy(xpath = "//a[contains(text(),'Manage Loan Application Details')]")
	private WebElement manageloanapplicationaccordionlink;

	@FindBy(id = "amount")
	private WebElement manageloanapplication_amount;

	@FindBy(id = "interestRate")
	private WebElement manageloanapplication_interest;

	@FindBy(id = "loanTenure")
	private WebElement manageloanapplication_tenure;

	@FindBy(xpath = "//div[@id='submitButtonLoanDetail']//button")
	private WebElement manageloanapplication_updatebutton;

	@FindBy(xpath = "//div[@id='loadLoanReferences']//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)+1]")
	private WebElement referencedetails_name;

	@FindBy(xpath = "//div[@id='loadLoanReferences']//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)]")
	private WebElement referencedetails_email;

	@FindBy(xpath = "//div[@id='loadLoanReferences']//th[.='Mobile Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Mobile Number']/preceding-sibling::th)+1]")
	private WebElement referencedetails_phonenumber;

	@FindBy(xpath = "//div[@id='loadLoanReferences']//th[.='Relationship Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Relationship Status']/preceding-sibling::th)+1]")
	private WebElement referencedetails_relationshipstatus;

	@FindBy(xpath = "//div[@id='reference_detail_list']//button[@id='edit_bank_detail_modal_opener']")
	private WebElement referencedetails_editbutton;

	@FindBy(xpath = "//div[@id='reference_detail_list']//button/i[@class='fa fa-trash']")
	private WebElement referencedetails_deletebutton;

	@FindBy(xpath = "//div[@id='loadLoanReferences']//button[@id='reference_detail']")
	private WebElement referencedetails_addbutton;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='firstName']")
	private WebElement addreferencedetails_firstnametextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='lastName']")
	private WebElement addreferencedetails_lastnametextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='userName']")
	private WebElement addreferencedetails_emailtextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='phoneNumber']")
	private WebElement addreferencedetails_mobilenumbertextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='relationshipStatus']")
	private WebElement addreferencedetails_relationshipstatustextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//button[@id='submitReferenceBtn']")
	private WebElement addreferencedetails_donebutton;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='firstName']")
	private WebElement updatereferencedetails_firstnametextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='lastName']")
	private WebElement updatereferencedetails_lastnametextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='userName']")
	private WebElement updatereferencedetails_emailtextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='phoneNumber']")
	private WebElement updatereferencedetails_mobilenumbertextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='relationshipStatus']")
	private WebElement updatereferencedetails_relationshipstatustextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//button[@id='submitUpdateBtn']")
	private WebElement updatereferencedetails_donebutton;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='LoanPurpose']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='LoanPurpose']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_loanpurpose;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='Loan Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Amount']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_loanamount;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='Repayment Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Repayment Amount']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_repaymentamount;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_bankname;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='Loan extra text variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan extra text variable1']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_loanextratextvariable1;

	@FindBy(xpath = "//a[contains(text(),'Other Loan Details')]")
	private WebElement otherloandetailsaccordionlink;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//button[@id='other_loan_detail']")
	private WebElement otherloandetails_addotherloandetailsbutton;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//button[@id='edit_bank_detail_modal_opener']")
	private WebElement otherloandetails_editbutton;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//i[@class='fa fa-trash-o']")
	private WebElement otherloandetails_deletebutton;

	@FindBy(xpath = "//form[@id='cretaeOtherLoanDetailForm']//input[@id='purpose']")
	private WebElement addotherloandetails_loanpurposetextbox;

	@FindBy(xpath = "//form[@id='cretaeOtherLoanDetailForm']//input[@id='loanAmount']")
	private WebElement addotherloandetails_loanamounttextbox;

	@FindBy(xpath = "//form[@id='cretaeOtherLoanDetailForm']//input[@id='repaymentAmount']")
	private WebElement addotherloandetails_repaymentamounttextbox;

	@FindBy(xpath = "//form[@id='cretaeOtherLoanDetailForm']//input[@id='bankName']")
	private WebElement addotherloandetails_banknametextbox;

	@FindBy(xpath = "//form[@id='cretaeOtherLoanDetailForm']//input[@id='otherLoanTextVariable1']")
	private WebElement addotherloandetails_loanextratextvariable1textbox;

	@FindBy(xpath = "(//div[@id='editCreateOtherLoanDivId']//button[@id='addOtherLoanBtn'])[1]")
	private WebElement addotherloandetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'has been Created')]")
	private WebElement addotherloandetailnotification;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='purpose']")
	private WebElement editotherloandetails_loanpurposetextbox;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='loanAmount']")
	private WebElement editotherloandetails_loanamounttextbox;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='repaymentAmount']")
	private WebElement editotherloandetails_repaymentamounttextbox;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='bankName']")
	private WebElement editotherloandetails_banknametextbox;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='otherLoanTextVariable1']")
	private WebElement editotherloandetails_loanextratextvariable1textbox;

	@FindBy(xpath = "//div[@id='editCreateOtherLoanDivId']//button[@id='updateOtherLoanBtn']")
	private WebElement editotherloandetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'has been Updated')]")
	private WebElement editotherloandetailsnotifications;

	@FindBy(xpath = "//div[@id='other_loan_list']/strong")
	private WebElement otherloandetailsdeletetext;

	@FindBy(xpath = "//a[contains(text(),'Vehicle Details')]")
	private WebElement vehicledetailsaccordionlink;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//th[.='Brand Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Brand Name']/preceding-sibling::th)+1]")
	private WebElement vehicledetails_brandname;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//th[.='License Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='License Number']/preceding-sibling::th)+1]")
	private WebElement vehicledetails_liscencenumber;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//th[.='Vehicle Owned extra text variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Vehicle Owned extra text variable1']/preceding-sibling::th)+1]")
	private WebElement vehicledetails_vehicleownedextratextvariable1;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//th[.='Vehicle Owned extra date variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Vehicle Owned extra date variable1']/preceding-sibling::th)+1]")
	private WebElement vehicledetails_vehicleownedextradatevariable1;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//button[@id='vehicle_owned_detail']")
	private WebElement vehicledetails_addvehicledetailsbutton;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//button[@id='edit_vehicle_modal_opener']")
	private WebElement vehicledetails_editvehicledetailsbutton;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//i[@class='fa fa-trash-o']")
	private WebElement vehicledetails_deletevehicledetailsbutton;

	@FindBy(xpath = "//div[@id='vehicle_list']/strong")
	private WebElement vehicledetailsdeletetext;

	@FindBy(xpath = "//form[@id='createVehicleOwnedDetailForm']//input[@id='brandName']")
	private WebElement addvehicledetails_brandnametextbox;

	@FindBy(xpath = "//form[@id='createVehicleOwnedDetailForm']//input[@id='licenseNumber']")
	private WebElement addvehicledetails_licensenumbertextbox;

	@FindBy(xpath = "//form[@id='createVehicleOwnedDetailForm']//input[@id='vehicleOwnedTextVariable1']")
	private WebElement addvehicledetails_vehicleownedextratextvariable1textbox;

	@FindBy(xpath = "//div[@id='editCreateVehicleOwnedDivId']//button[@id='createVehicleOwnedDetailBtn']")
	private WebElement addvehicledetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'Vehicle record')]")
	private WebElement addvehicledetailsnotification;

	@FindBy(xpath = "//form[@id='vehicleOwnedDetailForm']//input[@id='brandName']")
	private WebElement editvehicledetails_brandnametextbox;

	@FindBy(xpath = "//form[@id='vehicleOwnedDetailForm']//input[@id='licenseNumber']")
	private WebElement editvehicledetails_licensenumbertextbox;

	@FindBy(xpath = "//form[@id='vehicleOwnedDetailForm']//input[@id='vehicleOwnedTextVariable1']")
	private WebElement editvehicledetails_vehicleownedextratextvariable1textbox;

	@FindBy(xpath = "//div[@id='editCreateVehicleOwnedDivId']//button[@id='updateVehicleOwnedDetailBtn']")
	private WebElement editvehicledetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'Vehicle record')]")
	private WebElement editvehicledetailsnotification;

	@FindBy(xpath = "//div[@id='loadBorrowerGuarantor']//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)+1]")
	private List<WebElement> coapplicantdetails_name;

	@FindBy(xpath = "//div[@id='loadBorrowerGuarantor']//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)]")
	private List<WebElement> coapplicantdetails_email;

	@FindBy(xpath = "//div[@id='loadBorrowerGuarantor']//th[.='Company Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Company Name']/preceding-sibling::th)+1]")
	private List<WebElement> coapplicantdetails_companyname;

	@FindBy(xpath = "//div[@id='loadBorrowerGuarantor']//th[contains(.,'Co Applicant Employment Text Variable 1')]/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[contains(.,'Co Applicant Employment Text Variable 1')]/preceding-sibling::th)+1]")
	private List<WebElement> coapplicantdetails_coapplicantemploymenttextvariable1;

	@FindBy(xpath = "//div[@id='loadBorrowerGuarantor']//button[@id='co_applicant_detail']")
	private WebElement coapplicantdetails_addcoapplicantdetailsbutton;

	@FindBy(xpath = "//div[@id='loadBorrowerGuarantor']//button/i[@class='fa fa-edit']")
	private List<WebElement> coapplicantdetails_editbutton;

	@FindBy(xpath = "//div[@id='loadBorrowerGuarantor']//i[@class='fa fa-trash']")
	private List<WebElement> coapplicantdetails_deletebutton;

	@FindBy(xpath = "//div[@id='co_applicant_list_onBoard']/strong")
	private WebElement coapplicantdetailsdeletebutton;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='firstName']")
	private WebElement addcoapplicantdetails_firstnametextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='lastName']")
	private WebElement addcoapplicantdetails_lastnametextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='emailId']")
	private WebElement addcoapplicantdetails_emailtextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='companyName']")
	private WebElement addcoapplicantdetails_companynametextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='coApplicantEmploymentTextVariable1']")
	private WebElement addcoapplicantdetails_coapplicantemploymenttextvariable1textbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//button[@id='submit_co_applicant']")
	private WebElement addcoapplicantdetails_donebutton;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='firstName']")
	private WebElement editcoapplicantdetails_firstnametextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='lastName']")
	private WebElement editcoapplicantdetails_lastnametextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='emailId']")
	private WebElement editcoapplicantdetails_emailtextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='companyName']")
	private WebElement editcoapplicantdetails_companynametextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='coApplicantEmploymentTextVariable1']")
	private WebElement editcoapplicantdetails_coapplicantemploymenttextvariable1textbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//button[@id='submit_co_applicant']")
	private WebElement editcoapplicantdetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'successfully updated')]")
	private WebElement editcoapplicantdetailsnotification;

	@FindBy(xpath = "//a[contains(text(),'Insurance Details')]")
	private WebElement insurancedetailsaccordionlink;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//th[.='Insurer Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurer Name']/preceding-sibling::th)+1]")
	private List<WebElement> insurancedetails_insurername;

	@FindBy(xpath = "(//div[@id='borrowerInsurance']//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)+1]) | (//div[@id='borrowerInsurance']//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)-3])")
	private List<WebElement> insurancedetails_amount;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//th[.='Type of Insurance']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type of Insurance']/preceding-sibling::th)+1]")
	private List<WebElement> insurancedetails_typeofinsurance;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//th[.='Insurance Text Variable 1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 1']/preceding-sibling::th)+1]")
	private List<WebElement> insurancedetails_insurancetextvariable1;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//button[contains(text(),'Add insurance Detail')]")
	private WebElement insurancedetails_addinsurancedetailsbutton;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//i[@class='fa fa-edit']")
	private WebElement insurancedetails_editbutton;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//i[@class='fa fa-trash-o']")
	private WebElement insurancedetails_deletebutton;

	@FindBy(xpath = "//div[@id='insurance_list']/strong")
	private WebElement insurancedetailsdeletetext;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//input[@id='insuranceName']")
	private WebElement addinsurancedetails_insurancenametextbox;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//input[@id='insuranceAmount']")
	private WebElement addinsurancedetails_amounttextbox;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//select[@id='insuranceType']")
	private WebElement addinsurancedetails_typeofinsurancedropdown;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//input[@id='insuranceType']")
	private WebElement addinsurancedetails_insurancetypetextbox;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//input[@id='insuranceTextVariable1']")
	private WebElement addinsurancedetails_insurancetextvariable1textbox;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//button[contains(text(),'Done')]")
	private WebElement addinsurancedetails_donebutton;

	@FindBy(xpath = "//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceName']")
	private WebElement editinsurancedetails_insurernametextbox;

	@FindBy(xpath = "//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceAmount']")
	private WebElement editinsurancedetails_amounttextbox;

	@FindBy(xpath = "//form[@id='insuranceDetailUpdateForm']//select[@id='insuranceType']")
	private WebElement editinsurancedetails_typeofinsurancedropdown;

	@FindBy(xpath = "//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable1']")
	private WebElement editinsurancedetails_insurancetextvariable1textbox;

	@FindBy(xpath = "//div[@id='editCreateinsuranceDivId']//button[text()='Done']")
	private WebElement editinsurancedetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'insurance updated')]")
	private WebElement editinsurancedetailsnotification;

	@FindBy(xpath = "//div[@id='viewContractDetail']//a[contains(.,'Contracts')]")
	private WebElement contracts_contractsdetailsaccordionlink;

	@FindBy(xpath = "//div[@id='documentDetailTable']//strong")
	private WebElement contracts_nocontractsdisplayedtext;

	@FindBy(xpath = "//div[@id='pdcManagement']//button[@id='pdc_detail_creation']")
	private WebElement pdcmanagement_createpdcbutton;

	@FindBy(xpath = "//a[contains(text(),'PDC Management')]")
	private WebElement pdcmanagementaccordionlink;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']/strong")
	private WebElement pdc_nopdcdisplayed;

	@FindBy(xpath = "//select[@id='coApplicantID']")
	private WebElement createpdc_coapplicantdropsown;

	@FindBy(xpath = "//div[@id='pdc_modal_create']//input[@id='bankName']")
	private WebElement createpdc_banknametextbox;

	@FindBy(xpath = "//div[@id='pdc_modal_create']//input[@id='ifscCode']")
	private WebElement createpdc_ifsccodetextbox;

	@FindBy(xpath = "//div[@id='pdc_modal_create']//input[@id='micrCode']")
	private WebElement createpdc_micrcodetextbox;

	@FindBy(xpath = "//div[@id='pdc_modal_create']//input[@id='branchName']")
	private WebElement createpdc_branchnametextbox;

	@FindBy(xpath = "//div[@id='pdc_modal_create']//input[@id='amount']")
	private WebElement createpdc_amounttextbox;

	@FindBy(xpath = "//div[@id='pdc_modal_create']//input[@id='chequeNumber']")
	private WebElement createpdc_chequenumbertextbox;

	@FindBy(xpath = "//div[@id='pdc_modal_create']//input[@id='chequeStatus']")
	private WebElement createpdc_chequestatustextbox;

	@FindBy(xpath = "//div[@id='pdc_modal_create']//button[@id='createPDCBtn']")
	private WebElement createpdc_createbutton;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)-3]")
	private WebElement pdcmanagement_banknametext;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//th[.='IFSC Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='IFSC Code']/preceding-sibling::th)+1]")
	private WebElement pdcmanagement_ifsccodetext;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//th[.='MICR Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='MICR Code']/preceding-sibling::th)+1]")
	private WebElement pdcmanagement_micrcodetext;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//th[.='Branch Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Branch Name']/preceding-sibling::th)+1]")
	private WebElement pdcmanagement_branchnametext;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)]")
	private WebElement pdcmanagement_amounttext;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//th[.='Cheque Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Cheque Number']/preceding-sibling::th)+1]")
	private WebElement pdcmanagment_chequenumbertext;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//th[.='PDC Co-Applicant Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='PDC Co-Applicant Name']/preceding-sibling::th)+1]")
	private WebElement pdcmanagement_pdccoapplicantname;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//th[.='Cheque Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Cheque Status']/preceding-sibling::th)+1]")
	private WebElement pdcmanagement_chequestatustext;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//button[@id='edit_pdcRecord']")
	private WebElement pdcmanagement_editbutton;

	@FindBy(xpath = "//div[@id='loanApplicationPDCList']//button[contains(text(),'Delete')]")
	private WebElement pdcmanagement_deletebutton;

	@FindBy(xpath = "//select[@id='editPDC_coApplicantID']")
	private WebElement editpdcmanagement_coapplicantdropdown;

	@FindBy(xpath = "//form[@id='editPDCForm']//input[@id='bankName']")
	private WebElement editpdcmanagement_banknametextbox;

	@FindBy(xpath = "//form[@id='editPDCForm']//input[@id='addPDC_ifscCode']")
	private WebElement editpdcmanagement_ifsccodetextbox;

	@FindBy(xpath = "//form[@id='editPDCForm']//input[@id='addPDC_micrCode']")
	private WebElement editpdcmanagement_micrcodetextbox;

	@FindBy(xpath = "//form[@id='editPDCForm']//input[@id='editPDC_branchName']")
	private WebElement editpdcmanagement_branchnametextbox;

	@FindBy(xpath = "//form[@id='editPDCForm']//input[@id='editPDC_amount']")
	private WebElement editpdcmanagement_amounttextbox;

	@FindBy(xpath = "//form[@id='editPDCForm']//input[@id='editPDC_chequeNumber']")
	private WebElement editpdcmanagement_chequenumbertextbox;

	@FindBy(xpath = "//form[@id='editPDCForm']//select[@id='chequeStatus']")
	private WebElement editpdcmanagement_chequestatusdropdown;

	@FindBy(xpath = "//div[@id='pdc_modal_update']//button[@id='updatePDCBtn']")
	private WebElement editpdcmanagement_editbutton;

	@FindBy(xpath = "//span[contains(text(),'PDC Updated')]")
	private WebElement editpdcmanagement_notification;

	@FindBy(xpath = "//a[contains(text(),'Credit Answers')]")
	private WebElement creditanswerstab;

	@FindBy(xpath = "//a[contains(text(),'Borrower Question Group')]")
	private WebElement borrowerquestiongroupaccordionlink;

	@FindBy(xpath = "//label[text()='Borrower Nationality']/..//select")
	private WebElement borrowernationalitydropdown;

	@FindBy(xpath = "//label[text()='Down Payment']/..//input")
	private WebElement downpaymenttextbox;

	@FindBy(xpath = "//a[contains(text(),'Supporting Documents')]")
	private WebElement supportingdocumentstab;

	@FindBy(xpath = "//a[contains(text(),'Loan Application Document')]")
	private WebElement loanapplicationdocument_accordionlink;

	@FindBy(xpath = "//a[contains(text(),'Co Applicant Document Rishav Shrivastava')]")
	private WebElement coapplicantdocument_accordionlink;

	@FindBy(xpath = "//a[contains(text(),'Document For Reference Label Rishav Shrivastava')]")
	private WebElement referencedocument_accordionlink;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> loanapplicationdocuments_serialnumbers;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Category']/preceding-sibling::th)-1]")
	private List<WebElement> loanapplicationdocuments_documentcategory;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)-6]")
	private List<WebElement> loanapplications_documentname;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Visible To Borrower']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Borrower']/preceding-sibling::th)-5]/input")
	private List<WebElement> loanapplications_visibletoborrower;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Visible To Investor']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Investor']/preceding-sibling::th)-7]/input")
	private List<WebElement> loanapplications_visibletoinvestor;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Visible To Business Partner']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Business Partner']/preceding-sibling::th)-9]/input")
	private List<WebElement> loanapplications_visibletobusinesspartner;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//th[.='Visible To FIA']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To FIA']/preceding-sibling::th)-11]/input")
	private List<WebElement> loanapplications_visibletofia;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> coapplicant_serialnumber;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Category']/preceding-sibling::th)-1]")
	private List<WebElement> coapplicant_documentcategory;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)-6]")
	private List<WebElement> coapplicant_documentname;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Visible To Borrower']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Borrower']/preceding-sibling::th)-5]/input")
	private List<WebElement> coapplicant_visibletoborrower;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Visible To Investor']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Investor']/preceding-sibling::th)-7]/input")
	private List<WebElement> coapplicant_visibletoinvestor;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Visible To Business Partner']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Business Partner']/preceding-sibling::th)-9]/input")
	private List<WebElement> coapplicant_visibletobusinesspartner;

	@FindBy(xpath = "//div[contains(@id,'CO_APPLICANT')]//th[.='Visible To FIA']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To FIA']/preceding-sibling::th)-11]/input")
	private List<WebElement> coapplicant_visibletofia;

	@FindBy(xpath = "//div[@id='disbursement-detail-modal']//button[text()='Submit']")
	private WebElement disbursementdetailssubmitbutton;

	@FindBy(id = "followingStatus")
	private WebElement loanstatusdropdown;

	@FindBy(xpath = "//th[.='Loan Id']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Id']/preceding-sibling::th)+1]")
	private List<WebElement> contract_loanidtext;

	@FindBy(xpath = "//th[.='Contract Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Contract Name']/preceding-sibling::th)+1]")
	private List<WebElement> contract_contractnametext;

	@FindBy(xpath = "//th[.='Current Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Current Status']/preceding-sibling::th)+1]")
	private List<WebElement> contract_currentstatustext;

	@FindBy(xpath = "//th[.='Accepted / Uploaded By']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Accepted / Uploaded By']/preceding-sibling::th)+1]")
	private List<WebElement> contract_accepteduploadedbytext;

	@FindBy(xpath = "//th[.='Acceptd / Uploaded at Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Acceptd / Uploaded at Status']/preceding-sibling::th)+1]")
	private List<WebElement> contract_accepteduploadedatstatustext;

	@FindBy(xpath = "//th[.='Contract Files']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Contract Files']/preceding-sibling::th)+1]")
	private List<WebElement> contractfilestext;

	@FindBy(xpath = "//th[.='S.No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='S.No']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_serialnumbertext;

	@FindBy(xpath = "//th[.='Repayment Date']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Repayment Date']/preceding-sibling::th)+1]/input")
	private List<WebElement> loanrepaymentschedule_repaymentdatetextbox;

	@FindBy(xpath = "//th[.='Principal']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Principal']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_principaltext;

	@FindBy(xpath = "//th[.='Total Interest Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Total Interest Amount']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_totalinterestamounttext;

	@FindBy(xpath = "//th[@id='LOAN_TENURE']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='LOAN_TENURE']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_loantenuretext;

	@FindBy(xpath = "//th[.='Penalties']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Penalties']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_penaltiestext;

	@FindBy(xpath = "//th[.='Left Principal']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Left Principal']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_leftprincipaltext;

	@FindBy(xpath = "//th[.='Left Interest']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Left Interest']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_leftinteresttext;

	@FindBy(xpath = "//th[.='Left Penalty']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Left Penalty']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_leftpenaltytext;

	@FindBy(xpath = "//th[.='Payable Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Payable Amount']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_payableamounttext;

	@FindBy(xpath = "//th[@id='REPAYMENT_PRINCIPAL_OUTSTANDING']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='REPAYMENT_PRINCIPAL_OUTSTANDING']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_principaloutstandingtext;

	@FindBy(xpath = "//th[@id='REPAYMENT_STATUS']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='REPAYMENT_STATUS']/preceding-sibling::th)+1]/div")
	private List<WebElement> loanrepaymentschedule_statustext;

	@FindBy(xpath = "//th[@id='REPAYMENT_STATUS']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='REPAYMENT_STATUS']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_statustext2;

	@FindBy(xpath = "//th[@id='REPAYMENT_PAYMENT']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='REPAYMENT_PAYMENT']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_repaymentpaymenttext;

	@FindBy(xpath = "//th[@id='REPAYMENT_PAYMENT']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='REPAYMENT_PAYMENT']/preceding-sibling::th)+1]/select")
	private List<WebElement> loanrepaymentschedule_repaymentpaymentdropdown;

	@FindBy(xpath = "//th[.='Payment Date']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Payment Date']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_paymentdatetext;

	@FindBy(id = "loan_funded_span")
	private WebElement loandetailsfundprogressbar;

	@FindBy(xpath = "//select[contains(@id,'repaymentSelect')]")
	private List<WebElement> repaymentpaymentdropdown;

	@FindBy(xpath = "//span[contains(text(),'Repayment Status Updated !')]")
	private WebElement repaymentstatusupdatenotification;

	@FindBy(xpath = "//th[@id='REPAYMENT_STATUS']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='REPAYMENT_STATUS']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_statustext_afterrepayemi;

	@FindBy(xpath = "//a[contains(text(),'Check List')]")
	private WebElement checklistaccordionlink;

	@FindBy(xpath = "//input[contains(@id,'checkList')]")
	private WebElement checklistcheckbox;

	@FindBy(xpath = "//h4/a")
	private WebElement borowerhyperlink;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//i[@class='fa fa-eye']")
	private List<WebElement> loanapplicationdocument_viewbutton;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//i[@class='fa fa-upload']")
	private List<WebElement> loanapplicationdocument_uploadbutton;

	@FindBy(xpath = "//form[@id='loanApplicationDocumentUploadForm']/div/input")
	private WebElement loanapplicationdocument_choosefilebutton;

	@FindBy(xpath = "//form[@id='loanApplicationDocumentUploadForm']//button")
	private WebElement loanapplicationdocument_donebutton;

	@FindBy(xpath = "//span[contains(text(),'uploaded successfully')]")
	private WebElement documentuploadnotification;

	@FindBy(xpath = "//span[contains(text(),'Document Deleted Successfully')]")
	private WebElement documentdeletenotification;

	@FindBy(xpath = "//div[contains(@id,'MAIN_APPLICANT')]//a")
	private List<WebElement> loanapplicationdocument_downloadbutton;

	@FindBy(xpath = "//div[@id='modal_for_doc_preview']//button[contains(text(),'×')]")
	private WebElement loanapplicationdocument_preview_closebutton;

	@FindBy(xpath = "//div[@id='supportingDocumentListToDelete']//i[@class='fa fa-times']")
	private List<WebElement> loanapplicationdocument_deletebutton;

	@FindBy(xpath = "//div[@id='documentPopUpDiv']//button[text()='×']")
	private WebElement loanapplicationdocument_popupclosebutton;

	@FindBy(xpath = "//th[.='#']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='#']/preceding-sibling::th)+1]")
	private List<WebElement> supportingdocumentuploadedfilecount;

	@FindBy(xpath = "//div[contains(@id,'REFERENCE')]//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> reference_serialnumber;

	@FindBy(xpath = "//div[contains(@id,'REFERENCE')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Category']/preceding-sibling::th)-1]")
	private List<WebElement> reference_documentcategory;

	@FindBy(xpath = "//div[contains(@id,'REFERENCE')]//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)-6]")
	private List<WebElement> reference_documentname;

	@FindBy(xpath = "//div[contains(@id,'REFERENCE')]//th[.='Visible To Borrower']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Borrower']/preceding-sibling::th)-5]/input")
	private List<WebElement> reference_visibletoborrower;

	@FindBy(xpath = "//div[contains(@id,'REFERENCE')]//th[.='Visible To Investor']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Investor']/preceding-sibling::th)-7]/input")
	private List<WebElement> reference_visibletoinvestor;

	@FindBy(xpath = "//div[contains(@id,'REFERENCE')]//th[.='Visible To Business Partner']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To Business Partner']/preceding-sibling::th)-9]/input")
	private List<WebElement> reference_visibletobusinesspartner;

	@FindBy(xpath = "//div[contains(@id,'REFERENCE')]//th[.='Visible To FIA']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Visible To FIA']/preceding-sibling::th)-11]/input")
	private List<WebElement> reference_visibletofia;

	@FindBy(xpath = "//span[contains(text(),'deleted')]")
	private WebElement deletecoapplicantnotification;

	@FindBy(xpath = "//div[@id='co_applicant_modal_onBoard_update']//button[text()='×']")
	private WebElement editcoapplicant_closebutton;

	@FindBy(xpath = "//a[contains(text(),'Reference Details')]")
	private WebElement referencedetailsaccordionlink;

	@FindBy(xpath = "//div[@id='loanApplicationCommentsAjaxDiv']//a[contains(text(),'Loan Comments')]")
	private WebElement loancommentsaccordion;

	@FindBy(xpath = "//div[@id='Accord-LoanComments']/preceding-sibling::div//a//i")
	private WebElement addcommentbutton;

	@FindBy(xpath = "//form[@id='loanApplicationCommentForm']//input[@id='comment']")
	private WebElement commenttextbox;

	@FindBy(xpath = "//form[@id='loanApplicationCommentForm']//input[@id='visibleToBorrower']")
	private WebElement visibletoborrowercheckbox;

	@FindBy(xpath = "//form[@id='loanApplicationCommentForm']//input[@id='visibleToInvestor']")
	private WebElement visibletoinvestorcheckbox;

	@FindBy(xpath = "//form[@id='loanApplicationCommentForm']//input[@id='visibleToDSA']")
	private WebElement visibletodsacheckbox;

	@FindBy(xpath = "//form[@id='loanApplicationCommentForm']//input[@id='visibleToFia']")
	private WebElement visibletofiacheckbox;

	@FindBy(xpath = "//form[@id='loanApplicationCommentForm']//button[contains(text(),'Done')]")
	private WebElement loancommentdonebutton;

	@FindBy(xpath = "//form[@id='loanApplicationCommentForm']/div/input[@name='document']")
	private WebElement loancomment_choosefilebutton;

	@FindBy(xpath = "//span[contains(text(),'Succesfully')]")
	private WebElement loancommentnotification;

	@FindBy(xpath = "//button[@class='owl-next']")
	private WebElement loandetailspage_nextslider;

	@FindBy(xpath = "//a[contains(text(),'Company Representative')]")
	private WebElement companyrepresentativetab;

	@FindBy(xpath = "//a[contains(text(),'Share Holder')]")
	private WebElement shareholderaccordion;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_LAST_NAME']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_LAST_NAME']/preceding-sibling::th)+1]")
	private List<WebElement> validatelastname;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_DATE_OF_APPOINTMENT']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_DATE_OF_APPOINTMENT']/preceding-sibling::th)+1]")
	private List<WebElement> validatedateofappointment;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_ADDRESS_ONE']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_ADDRESS_ONE']/preceding-sibling::th)+1]")
	private List<WebElement> validateaddressone;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_ONE']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_ONE']/preceding-sibling::th)+1]")
	private List<WebElement> validateidnumberone;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_EMAIL']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_EMAIL']/preceding-sibling::th)+1]")
	private List<WebElement> validateemail;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_MOBILE_NUMBER']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_MOBILE_NUMBER']/preceding-sibling::th)+1]")
	private List<WebElement> validatemobilenumber;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_FIRST_NAME']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_FIRST_NAME']/preceding-sibling::th)+1]")
	private List<WebElement> validatefirstname;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_TWO']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_TWO']/preceding-sibling::th)+1]")
	private List<WebElement> validateidnumbertwo;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_DATE_OF_BIRTH']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_DATE_OF_BIRTH']/preceding-sibling::th)+1]")
	private List<WebElement> validatedob;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_CITIZENSHIP']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr//th[@id='COMPANY_REPRESENTATIVE_CITIZENSHIP']/preceding-sibling::th)+1]")
	private List<WebElement> validatecitizenship;

	@FindBy(xpath = "//td/button[contains(@id,'edit_representative')]")
	private List<WebElement> shareholder_editbutton;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='firstName']")
	private WebElement shareholderfirstnametextbox;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='lastName']")
	private WebElement shareholderlastnametextbox;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='emailAddress']")
	private WebElement shareholderemailaddresstextbox;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='mobileNumber']")
	private WebElement shareholdermobilenumbertextbox;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[contains(@id,'companyRepresentativeDateOfBirth')]")
	private WebElement shareholderdobtextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement shareholderdobyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement shareholderdobmonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> shareholderdobdatealllinks;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='citizenship']")
	private WebElement shareholdercitizenshiptextbox;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='identityNumberOne']")
	private WebElement shareholderidentitynumberonetextbox;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='identityNumberTwo']")
	private WebElement shareholderidentitynumbertwotextbox;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[contains(@id,'dateOfAppointment')]")
	private WebElement shareholderdateofappointmenttextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement shareholderdateofappointmentyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement shareholderdateofappointmentmonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> shareholderdateofappointmentdatealllinks;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='addressOneLine1']")
	private WebElement shareholderaddressoneline1;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='addressOneLine2']")
	private WebElement shareholderaddressoneline2;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='addressOneLine3']")
	private WebElement shareholderaddressoneline3;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='addressOneSubDistrict']")
	private WebElement shareholderaddressonesubdistrict;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='addressOneDistrict']")
	private WebElement shareholderaddressonedistrict;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//select[@id='addressOneState']")
	private WebElement shareholderaddressonestate;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='addressOneCity']")
	private WebElement shareholderaddressonecity;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='addressOneCountry']")
	private WebElement shareholderaddressonecountry;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='addressOneZipCode']")
	private WebElement shareholderaddressonezipcode;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//select[@id='addressOneOwnershipType']")
	private WebElement shareholderaddressoneownershiptype;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//select[@id='addressOneTypeOfAddress']")
	private WebElement shareholderaddressonetypeofaddress;

	@FindBy(xpath = "//form[@id='createCompanyRepresentativeForm']//div//input[@id='directorAddressOneLivingSince']")
	private WebElement shareholderlivingsincetextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement shareholderlivingsinceyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement shareholderlivingsincemonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> shareholderlivingsincedatealllinks;

	@FindBy(xpath = "//button[@id='updateRepresentativeBtn']")
	private WebElement editshareholdercontinuebutton;

	@FindBy(xpath = "//span[contains(text(),'Updated Successfully')]")
	private WebElement shareholderupdatenotification;

	@FindBy(xpath = "//a[contains(text(),'Share Holder')]/parent::div//following-sibling::div//button[@id='openRepresentativeModalBtn']")
	private WebElement createshareholderbutton;

	@FindBy(xpath = "//button[@id='saveRepresentativeBtn']")
	private WebElement addshareholdercontinuebutton;

	@FindBy(xpath = "//span[contains(text(),'Created Successfully')]")
	private WebElement shareholdercreatednotification;

	@FindBy(xpath = "//button[contains(@id,'delete_representative')]")
	private List<WebElement> deleteshareholder;

	@FindBy(xpath = "//div[@id='AccordShareHolder']//b[contains(text(),'No records found')]")
	private WebElement noshareholderdisplayed;

	public void validateNotification(String notificationmessage) {
		try {
			for (int i = 0; i < notificationslists.size(); i++) {
				if (notificationslists.get(i).getText().equalsIgnoreCase(notificationmessage)) {
					Reporter.log(notificationslists.get(i).getText() + " and notification is as exected", true);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getLoanId() {
		String loanId = null;
		try {
			Generics.waitForElement(driver, loanidtext);
			loanId = loanidtext.getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return loanId;
	}

	public void validateLoanId(String loanid) {
		try {
			Generics.waitForElement(driver, loanidtext);
			if (loanidtext.getText().equalsIgnoreCase(loanid)) {
				Reporter.log("Loan ID is correct", true);
			} else
				Reporter.log("Loan ID is incorrect", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCoApplicantAccordion() {
		try {
			Generics.waitForElement(driver, coapplicantaccordionlink);
			coapplicantaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getLoanCurrentStatus() {
		String loanOverviewStatus = null;
		try {
			Generics.waitForElement(driver, statusdropdown);
			Generics.waitForElement(driver, loanstatus);
			loanOverviewStatus = loanstatus.getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return loanOverviewStatus;
	}

	public void validateLoanStatus(String product) {
		try {
			Generics.refreshPage(driver);
			Generics.waitForElement(driver, loanstatus);
			assertEquals(loanstatus.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectStatus(String statusoption) {
		try {
			Generics.waitForElement(driver, statusdropdown);
			Select loanStatus = new Select(statusdropdown);
			loanStatus.selectByVisibleText(statusoption);
			String selectedOption = loanStatus.getFirstSelectedOption().getText();
			assertEquals(selectedOption, statusoption);
			Reporter.log("Selected Option: " + selectedOption, true);
			if (statusoption.equalsIgnoreCase("Disbursed")) {
				Generics.waitForElement(driver, disbursementnextbutton);
				disbursementnextbutton.click();
				Generics.waitForElementToInvisible(driver, disbursementnextbutton);
			}
			Generics.waitForElement(driver, nextbutton);
			nextbutton.click();
			Generics.waitForElementToInvisible(driver, nextbutton);
			Thread.sleep(2000);
			driver.navigate().refresh();
			Generics.waitForElement(driver, loanstatus);
			String loanOverviewStatus = loanstatus.getText();
			assertEquals(loanOverviewStatus, statusoption);
			Reporter.log("Loan Status: " + loanOverviewStatus, true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForRepaymentScheduleTable() {
		try {
			Generics.waitForElement(driver, loanrepaymentscheduletable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAction() {
		try {
			Generics.waitForElement(driver, actiondropdown);
			actiondropdown.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickRepaymentScheduleStructure() {
		try {
			Generics.waitForElement(driver, repaymentschedulerestructure);
			repaymentschedulerestructure.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickFullSettlement() {
		try {
			Generics.waitForElement(driver, fullsettlementtab);
			fullsettlementtab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterFullSettlementPaymentAmount(String settlementamount) {
		try {
			Generics.waitForElement(driver, fullsettlementpaymentamounttextbox);
			fullsettlementpaymentamounttextbox.click();
			fullsettlementpaymentamounttextbox.clear();
			fullsettlementpaymentamounttextbox.sendKeys(settlementamount);
			remainingrepaymentinteresttextbox.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForFullSettlementPaymentAmountNotification() {
		try {
			Generics.waitForElement(driver, principalmustbesameasremainingprincipalnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterRemainingRepaymentInterest(String remaininginterest) {
		try {
			Generics.waitForElement(driver, remainingrepaymentinteresttextbox);
			remainingrepaymentinteresttextbox.click();
			remainingrepaymentinteresttextbox.clear();
			remainingrepaymentinteresttextbox.sendKeys(remaininginterest);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterRemainingRepaymentPenalty(String remainingpenalty) {
		try {
			Generics.waitForElement(driver, remainingrepaymentpenaltytextbox);
			remainingrepaymentpenaltytextbox.click();
			remainingrepaymentpenaltytextbox.clear();
			remainingrepaymentpenaltytextbox.sendKeys(remainingpenalty);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterRemainingRepaymentChequeBouncingCharge(String remainingchequebouncingcharge) {
		try {
			Generics.waitForElement(driver, remainingrepaymentchequebouncingchargetextbox);
			remainingrepaymentchequebouncingchargetextbox.click();
			remainingrepaymentchequebouncingchargetextbox.clear();
			remainingrepaymentchequebouncingchargetextbox.sendKeys(remainingchequebouncingcharge);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterRemainingFullSettlementPenalty(String remainingfullsettlementpenalty) {
		try {
			Generics.waitForElement(driver, fullsettlementpenaltytextbox);
			fullsettlementpenaltytextbox.click();
			fullsettlementpenaltytextbox.clear();
			fullsettlementpenaltytextbox.sendKeys(remainingfullsettlementpenalty);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterRemainingFullSettlementTax(String remainingfullsettlementtax) {
		try {
			Generics.waitForElement(driver, fullsettlementtaxtextbox);
			fullsettlementtaxtextbox.click();
			fullsettlementtaxtextbox.clear();
			fullsettlementtaxtextbox.sendKeys(remainingfullsettlementtax);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterRemainingFullSettlementDiscount(String fullsettlementdiscount) {
		try {
			Generics.waitForElement(driver, fullsettlementdiscounttextbox);
			fullsettlementdiscounttextbox.click();
			fullsettlementdiscounttextbox.clear();
			fullsettlementdiscounttextbox.sendKeys(fullsettlementdiscount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickFullSettlementPay() {
		try {
			Generics.waitForElement(driver, fullsettlementpaybutton);
			fullsettlementpaybutton.click();
			Generics.alertAction(driver, "Yes");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForFullSettlementPayNotification() {
		try {
			Generics.waitForElement(driver, fullsettlementpaynotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickPartialRepayment() {
		try {
			Generics.waitForElement(driver, partialrepaymenttab);
			partialrepaymenttab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPaymentAmount(String paymentamount) {
		try {
			Generics.waitForElement(driver, paymentamounttextbox);
			paymentamounttextbox.click();
			paymentamounttextbox.clear();
			paymentamounttextbox.sendKeys(paymentamount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForRemainingPrincipalLessThanTotalPrincipalNotification() {
		try {
			Generics.waitForElement(driver, remainingprincipalmustbelessthanprincipalforrepaymentprincipalnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectNewInterest(String interest) {
		try {
			Generics.waitForElement(driver, newinterestdropdown);
			Select newInterest = new Select(newinterestdropdown);
			newInterest.selectByVisibleText(interest);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectNewTenure(String tenure) {
		try {
			Generics.waitForElement(driver, paymentamounttextbox);
			Select newTenure = new Select(newtenuredropdown);
			newTenure.selectByVisibleText(tenure);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectNewRepaymentDate(String date) {
		try {
			Generics.waitForElement(driver, updaterepaymentdatedropdown);
			Select newRepaymentDate = new Select(updaterepaymentdatedropdown);
			newRepaymentDate.selectByVisibleText(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkAllowGapDayInterest() {
		try {
			Generics.waitForElement(driver, allowgapdayinterestcheckbox);
			if (allowgapdayinterestcheckbox.isSelected() == true) {
			} else if (allowgapdayinterestcheckbox.isSelected() == false) {
				allowgapdayinterestcheckbox.click();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void uncheckAllowGapDayInterest() {
		try {
			Generics.waitForElement(driver, allowgapdayinterestcheckbox);
			if (allowgapdayinterestcheckbox.isSelected() == true) {
				allowgapdayinterestcheckbox.click();
			} else if (allowgapdayinterestcheckbox.isSelected() == false) {
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterEarlyRepaymentPenalty(String earlyrepaymentpenalty) {
		try {
			Generics.waitForElement(driver, earlyrepaymentpenaltytextbox);
			earlyrepaymentpenaltytextbox.click();
			earlyrepaymentpenaltytextbox.clear();
			earlyrepaymentpenaltytextbox.sendKeys(earlyrepaymentpenalty);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterEarlyRepaymentTax(String earlyrepaymentpenalty) {
		try {
			Generics.waitForElement(driver, earlyrepaymenttaxtextbox);
			earlyrepaymenttaxtextbox.click();
			earlyrepaymenttaxtextbox.clear();
			earlyrepaymenttaxtextbox.sendKeys(earlyrepaymentpenalty);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterEarlyRepaymentDiscount(String earlyrepaymentdiscount) {
		try {
			Generics.waitForElement(driver, earlyrepaymentdiscounttextbox);
			earlyrepaymentdiscounttextbox.click();
			earlyrepaymentdiscounttextbox.clear();
			earlyrepaymentdiscounttextbox.sendKeys(earlyrepaymentdiscount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void borrowerAvailableCash(String expectedBorrowerAvailableCash) {
		try {
			Generics.waitForElement(driver, borroweravailablecashtext);
			String actualBorrowerAvailableCash = borroweravailablecashtext.getText();
			assertEquals(actualBorrowerAvailableCash, expectedBorrowerAvailableCash);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void totalAmount(String expectedTotalAmount) {
		try {
			Generics.waitForElement(driver, totalAmount);
			String actualTotalAmount = totalAmount.getText();
			assertEquals(actualTotalAmount, expectedTotalAmount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void totalAmountMinusBorrowerAvailableCash(String expectedTotalAmountMinusBorrowerAvailableCash) {
		try {
			Generics.waitForElement(driver, totalamountminusborroweravailablecashtext);
			String actualTotalAmountMinusBorrowerAvailableCash = totalamountminusborroweravailablecashtext.getText();
			assertEquals(actualTotalAmountMinusBorrowerAvailableCash, expectedTotalAmountMinusBorrowerAvailableCash);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickPay() {
		try {
			Generics.waitForElement(driver, paybutton);
			paybutton.click();
			Generics.alertAction(driver, "Yes");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForNotEnoughBalanceInWalletNotification() {
		try {
			Generics.waitForElement(driver, notenoughbalanceinwalletnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForRepaymnentScheduleChangedNotification() {
		try {
			Generics.waitForElement(driver, repaymentschedulechangednotification);
			Generics.waitForElement(driver, repaymentscheduleupdatednotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateRepaymentTable(int i, String serialnumber, String repaymentdate, String principalamount,
			String interestamount, String loantenuretext, String penalties, String leftprincipal, String leftinterest,
			String leftpenalty, String payableamount, String principaloutstanding, String status,
			String repaymentpayment, String paymentdate) {
		try {
			Generics.waitForElement(driver, loanrepaymentschedule_serialnumbertext.get(i));
			assertEquals(loanrepaymentschedule_serialnumbertext.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, loanrepaymentschedule_repaymentdatetextbox.get(i));
//			assertEquals(loanrepaymentschedule_repaymentdatetextbox.get(i).getAttribute("value"), repaymentdate);

			Generics.waitForElement(driver, loanrepaymentschedule_principaltext.get(i));
			assertEquals(loanrepaymentschedule_principaltext.get(i).getText(), principalamount);

			Generics.waitForElement(driver, loanrepaymentschedule_totalinterestamounttext.get(i));
			assertEquals(loanrepaymentschedule_totalinterestamounttext.get(i).getText(), interestamount);

			Generics.waitForElement(driver, loanrepaymentschedule_loantenuretext.get(i));
			assertEquals(loanrepaymentschedule_loantenuretext.get(i).getText(), loantenuretext);

			Generics.waitForElement(driver, loanrepaymentschedule_penaltiestext.get(i));
			assertEquals(loanrepaymentschedule_penaltiestext.get(i).getText(), penalties);

			Generics.waitForElement(driver, loanrepaymentschedule_leftprincipaltext.get(i));
			assertEquals(loanrepaymentschedule_leftprincipaltext.get(i).getText(), leftprincipal);

			Generics.waitForElement(driver, loanrepaymentschedule_leftinteresttext.get(i));
			assertEquals(loanrepaymentschedule_leftinteresttext.get(i).getText(), leftinterest);

			Generics.waitForElement(driver, loanrepaymentschedule_leftpenaltytext.get(i));
			assertEquals(loanrepaymentschedule_leftpenaltytext.get(i).getText(), leftpenalty);

			Generics.waitForElement(driver, loanrepaymentschedule_payableamounttext.get(i));
			assertEquals(loanrepaymentschedule_payableamounttext.get(i).getText(), payableamount);

			Generics.waitForElement(driver, loanrepaymentschedule_principaloutstandingtext.get(i));
			assertEquals(loanrepaymentschedule_principaloutstandingtext.get(i).getText(), principaloutstanding);

			Generics.waitForElement(driver, loanrepaymentschedule_statustext.get(i));
			assertEquals(loanrepaymentschedule_statustext.get(i).getText(), status);

			Generics.waitForElement(driver, loanrepaymentschedule_repaymentpaymenttext.get(i));
			assertEquals(loanrepaymentschedule_repaymentpaymenttext.get(i).getText(), repaymentpayment);// changed

			Generics.waitForElement(driver, loanrepaymentschedule_paymentdatetext.get(i));
			assertEquals(loanrepaymentschedule_paymentdatetext.get(i).getText(), paymentdate);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateRepaymentTableAfterDisbursal(int i, String serialnumber, String repaymentdate,
			String principalamount, String interestamount, String loantenuretext, String penalties,
			String leftprincipal, String leftinterest, String leftpenalty, String payableamount,
			String principaloutstanding, String status, String repaymentpayment, String paymentdate) {
		try {
			Generics.waitForElement(driver, loanrepaymentschedule_serialnumbertext.get(i));
			assertEquals(loanrepaymentschedule_serialnumbertext.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, loanrepaymentschedule_repaymentdatetextbox.get(i));
//			assertEquals(loanrepaymentschedule_repaymentdatetextbox.get(i).getAttribute("value"), repaymentdate);

			Generics.waitForElement(driver, loanrepaymentschedule_principaltext.get(i));
			assertEquals(loanrepaymentschedule_principaltext.get(i).getText(), principalamount);

			Generics.waitForElement(driver, loanrepaymentschedule_totalinterestamounttext.get(i));
			assertEquals(loanrepaymentschedule_totalinterestamounttext.get(i).getText(), interestamount);

			Generics.waitForElement(driver, loanrepaymentschedule_loantenuretext.get(i));
			assertEquals(loanrepaymentschedule_loantenuretext.get(i).getText(), loantenuretext);

			Generics.waitForElement(driver, loanrepaymentschedule_penaltiestext.get(i));
			assertEquals(loanrepaymentschedule_penaltiestext.get(i).getText(), penalties);

			Generics.waitForElement(driver, loanrepaymentschedule_leftprincipaltext.get(i));
			assertEquals(loanrepaymentschedule_leftprincipaltext.get(i).getText(), leftprincipal);

			Generics.waitForElement(driver, loanrepaymentschedule_leftinteresttext.get(i));
			assertEquals(loanrepaymentschedule_leftinteresttext.get(i).getText(), leftinterest);

			Generics.waitForElement(driver, loanrepaymentschedule_leftpenaltytext.get(i));
			assertEquals(loanrepaymentschedule_leftpenaltytext.get(i).getText(), leftpenalty);

			Generics.waitForElement(driver, loanrepaymentschedule_payableamounttext.get(i));
			assertEquals(loanrepaymentschedule_payableamounttext.get(i).getText(), payableamount);

			Generics.waitForElement(driver, loanrepaymentschedule_principaloutstandingtext.get(i));
			assertEquals(loanrepaymentschedule_principaloutstandingtext.get(i).getText(), principaloutstanding);

			Generics.waitForElement(driver, loanrepaymentschedule_statustext.get(i));
			assertEquals(loanrepaymentschedule_statustext.get(i).getText(), status);

			Generics.waitForElement(driver, loanrepaymentschedule_repaymentpaymenttext.get(i));
			Select repaymentpaymentoptions = new Select(loanrepaymentschedule_repaymentpaymentdropdown.get(i));
			assertEquals(repaymentpaymentoptions.getFirstSelectedOption().getText(), repaymentpayment);

			Generics.waitForElement(driver, loanrepaymentschedule_paymentdatetext.get(i));
//			assertEquals(loanrepaymentschedule_paymentdatetext.get(i).getText(), paymentdate);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickDetails() {
		try {
			Generics.waitForElement(driver, detailstab);
			detailstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoanDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, borroweridtext);
				assertEquals(borroweridtext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, disburseddatetext);
				assertEquals(disburseddatetext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, totalfeestext);
				assertEquals(totalfeestext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, totalservicefeetext);
				assertEquals(totalservicefeetext.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, totalborrowerservicefeestext);
				assertEquals(totalborrowerservicefeestext.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, vatonservicetext);
				assertEquals(vatonservicetext.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, loanidtext_details);
				assertEquals(loanidtext_details.getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, principaltext);
				assertEquals(principaltext.getText(), product);
				break;

			case 8:
				Generics.waitForElement(driver, debtrepaymenttext);
				assertEquals(debtrepaymenttext.getText(), product);
				break;

			case 9:
				Generics.waitForElement(driver, producttext);
				assertEquals(producttext.getText(), product);
				break;

			case 10:
				Generics.waitForElement(driver, annualpercentageratetext);
				assertEquals(annualpercentageratetext.getText(), product);
				break;

			case 11:
				Generics.waitForElement(driver, startdatetext);
				assertEquals(startdatetext.getText(), product);
				break;

			case 12:
				Generics.waitForElement(driver, amounttoberepaidtext);
				assertEquals(amounttoberepaidtext.getText(), product);
				break;

			case 13:
				Generics.waitForElement(driver, dsaagenttext);
				assertEquals(dsaagenttext.getText(), product);
				break;

			case 14:
				Generics.waitForElement(driver, borrowernametext);
				assertEquals(borrowernametext.getText(), product);
				break;

			case 15:
				Generics.waitForElement(driver, borrowertext);
				assertEquals(borrowertext.getText(), product);
				break;

			case 16:
				Generics.waitForElement(driver, assigntoadmintext);
				assertEquals(assigntoadmintext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateManageLoanApplicationDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, manageloanapplication_amount);
				manageloanapplication_amount.getAttribute("value");
				break;

			case 1:
				Generics.waitForElement(driver, manageloanapplication_interest);
				Select interest = new Select(manageloanapplication_interest);
				WebElement selectedInterest = interest.getFirstSelectedOption();
				assertEquals(selectedInterest.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, manageloanapplication_tenure);
				Select tenure = new Select(manageloanapplication_tenure);
				WebElement selectedTenure = tenure.getFirstSelectedOption();
				assertEquals(selectedTenure.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddReference() {
		try {
			Generics.waitForElement(driver, referencedetails_addbutton);
			referencedetails_addbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addReferenceDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addreferencedetails_firstnametextbox);
				addreferencedetails_firstnametextbox.click();
				addreferencedetails_firstnametextbox.clear();
				addreferencedetails_firstnametextbox.sendKeys(product);

			case 1:
				Generics.waitForElement(driver, addreferencedetails_lastnametextbox);
				addreferencedetails_lastnametextbox.click();
				addreferencedetails_lastnametextbox.clear();
				addreferencedetails_lastnametextbox.sendKeys(product);

			case 2:
				Generics.waitForElement(driver, addreferencedetails_emailtextbox);
				addreferencedetails_emailtextbox.click();
				addreferencedetails_emailtextbox.clear();
				addreferencedetails_emailtextbox.sendKeys(product);

			case 3:
				Generics.waitForElement(driver, addreferencedetails_mobilenumbertextbox);
				addreferencedetails_mobilenumbertextbox.click();
				addreferencedetails_mobilenumbertextbox.clear();
				addreferencedetails_mobilenumbertextbox.sendKeys(product);

			case 4:
				Generics.waitForElement(driver, addreferencedetails_relationshipstatustextbox);
				addreferencedetails_relationshipstatustextbox.click();
				addreferencedetails_relationshipstatustextbox.clear();
				addreferencedetails_relationshipstatustextbox.sendKeys(product);

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddReferenceDetailsDone() {
		try {
			Generics.waitForElement(driver, addreferencedetails_donebutton);
			addreferencedetails_donebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickReferenceDetailsEditButton() {
		try {
			Generics.waitForElement(driver, referencedetails_editbutton);
			referencedetails_editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editReferemceDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, updatereferencedetails_firstnametextbox);
				updatereferencedetails_firstnametextbox.click();
				updatereferencedetails_firstnametextbox.clear();
				updatereferencedetails_firstnametextbox.sendKeys(product);

			case 1:
				Generics.waitForElement(driver, updatereferencedetails_lastnametextbox);
				updatereferencedetails_lastnametextbox.click();
				updatereferencedetails_lastnametextbox.clear();
				updatereferencedetails_lastnametextbox.sendKeys(product);

			case 2:
				Generics.waitForElement(driver, updatereferencedetails_emailtextbox);
				updatereferencedetails_emailtextbox.click();
				updatereferencedetails_emailtextbox.clear();
				updatereferencedetails_emailtextbox.sendKeys(product);

			case 3:
				Generics.waitForElement(driver, updatereferencedetails_mobilenumbertextbox);
				updatereferencedetails_mobilenumbertextbox.click();
				updatereferencedetails_mobilenumbertextbox.clear();
				updatereferencedetails_mobilenumbertextbox.sendKeys(product);

			case 4:
				Generics.waitForElement(driver, updatereferencedetails_relationshipstatustextbox);
				updatereferencedetails_relationshipstatustextbox.click();
				updatereferencedetails_relationshipstatustextbox.clear();
				updatereferencedetails_relationshipstatustextbox.sendKeys(product);

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditRefereceDetailsDone() {
		try {
			Generics.waitForElement(driver, updatereferencedetails_donebutton);
			updatereferencedetails_donebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void deleteReferenceDetails() {
		try {
			Generics.waitForElement(driver, referencedetails_deletebutton);
			referencedetails_deletebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateReferenceDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, referencedetails_name);
				assertEquals(referencedetails_name.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, referencedetails_email);
				assertEquals(referencedetails_email.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, referencedetails_phonenumber);
				assertEquals(referencedetails_phonenumber.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, referencedetails_relationshipstatus);
				assertEquals(referencedetails_relationshipstatus.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOtherLoanDetailsAccordion() {
		try {
			Generics.waitForElement(driver, otherloandetailsaccordionlink);
			otherloandetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddOtherOtherLoanDetails() {
		try {
			Generics.waitForElement(driver, otherloandetails_addotherloandetailsbutton);
			otherloandetails_addotherloandetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addOtherLoanDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addotherloandetails_loanpurposetextbox);
				addotherloandetails_loanpurposetextbox.click();
				addotherloandetails_loanpurposetextbox.clear();
				addotherloandetails_loanpurposetextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, addotherloandetails_loanamounttextbox);
				addotherloandetails_loanamounttextbox.click();
				addotherloandetails_loanamounttextbox.clear();
				addotherloandetails_loanamounttextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, addotherloandetails_repaymentamounttextbox);
				addotherloandetails_repaymentamounttextbox.click();
				addotherloandetails_repaymentamounttextbox.clear();
				addotherloandetails_repaymentamounttextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, addotherloandetails_banknametextbox);
				addotherloandetails_banknametextbox.click();
				addotherloandetails_banknametextbox.clear();
				addotherloandetails_banknametextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, addotherloandetails_loanextratextvariable1textbox);
				addotherloandetails_loanextratextvariable1textbox.click();
				addotherloandetails_loanextratextvariable1textbox.clear();
				addotherloandetails_loanextratextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddOtherLoanDetailsDone() {
		try {
			Generics.waitForElement(driver, addotherloandetails_donebutton);
			addotherloandetails_donebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOtherLoanDetailsEdit() {
		try {
			Generics.waitForElement(driver, otherloandetails_editbutton);
			otherloandetails_editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editOtherLoanDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editotherloandetails_loanpurposetextbox);
				editotherloandetails_loanpurposetextbox.click();
				editotherloandetails_loanpurposetextbox.clear();
				editotherloandetails_loanpurposetextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, editotherloandetails_loanamounttextbox);
				editotherloandetails_loanamounttextbox.click();
				editotherloandetails_loanamounttextbox.clear();
				editotherloandetails_loanamounttextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, editotherloandetails_repaymentamounttextbox);
				editotherloandetails_repaymentamounttextbox.click();
				editotherloandetails_repaymentamounttextbox.clear();
				editotherloandetails_repaymentamounttextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, editotherloandetails_banknametextbox);
				editotherloandetails_banknametextbox.click();
				editotherloandetails_banknametextbox.clear();
				editotherloandetails_banknametextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, editotherloandetails_loanextratextvariable1textbox);
				editotherloandetails_loanextratextvariable1textbox.click();
				editotherloandetails_loanextratextvariable1textbox.clear();
				editotherloandetails_loanextratextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditOtherLoanDetailsDone() {
		try {
			Generics.waitForElement(driver, editotherloandetails_donebutton);
			editotherloandetails_donebutton.click();
			Generics.waitForElement(driver, editotherloandetailsnotifications);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOtherLoanDetailsDelete(String action) {
		try {
			Generics.waitForElement(driver, otherloandetails_deletebutton);
			otherloandetails_deletebutton.click();
			Generics.alertAction(driver, action);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfNoOtherLoanDetailsDisplayed(String product) {
		try {
			Generics.waitForElement(driver, otherloandetailsdeletetext);
			assertEquals(otherloandetailsdeletetext.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateOtherLoanDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, otherloandetails_loanpurpose);
				assertEquals(otherloandetails_loanpurpose.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, otherloandetails_loanamount);
				assertEquals(otherloandetails_loanamount.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, otherloandetails_repaymentamount);
				assertEquals(otherloandetails_repaymentamount.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, otherloandetails_bankname);
				assertEquals(otherloandetails_bankname.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, otherloandetails_loanextratextvariable1);
				assertEquals(otherloandetails_loanextratextvariable1.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddVehicleDetails() {
		try {
			Generics.waitForElement(driver, vehicledetails_addvehicledetailsbutton);
			vehicledetails_addvehicledetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addVehicleDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addvehicledetails_brandnametextbox);
				addvehicledetails_brandnametextbox.click();
				addvehicledetails_brandnametextbox.clear();
				addvehicledetails_brandnametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, addvehicledetails_licensenumbertextbox);
				addvehicledetails_licensenumbertextbox.click();
				addvehicledetails_licensenumbertextbox.clear();
				addvehicledetails_licensenumbertextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, addvehicledetails_vehicleownedextratextvariable1textbox);
				addvehicledetails_vehicleownedextratextvariable1textbox.click();
				addvehicledetails_vehicleownedextratextvariable1textbox.clear();
				addvehicledetails_vehicleownedextratextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddVehicleDetailsDone() {
		try {
			Generics.waitForElement(driver, addvehicledetails_donebutton);
			addvehicledetails_donebutton.click();
			Generics.waitForElement(driver, addvehicledetailsnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickVehicleDetailsEdit() {
		try {
			Generics.waitForElement(driver, vehicledetails_editvehicledetailsbutton);
			vehicledetails_editvehicledetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editVehicleDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editvehicledetails_brandnametextbox);
				editvehicledetails_brandnametextbox.click();
				editvehicledetails_brandnametextbox.clear();
				editvehicledetails_brandnametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, editvehicledetails_licensenumbertextbox);
				editvehicledetails_licensenumbertextbox.click();
				editvehicledetails_licensenumbertextbox.clear();
				editvehicledetails_licensenumbertextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, editvehicledetails_vehicleownedextratextvariable1textbox);
				editvehicledetails_vehicleownedextratextvariable1textbox.click();
				editvehicledetails_vehicleownedextratextvariable1textbox.clear();
				editvehicledetails_vehicleownedextratextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditVehicleDetailsDone() {
		try {
			Generics.waitForElement(driver, editvehicledetails_donebutton);
			editvehicledetails_donebutton.click();
			Generics.waitForElement(driver, editvehicledetailsnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickVehicleDetailsDelete(String action) {
		try {
			Generics.waitForElement(driver, vehicledetails_deletevehicledetailsbutton);
			vehicledetails_deletevehicledetailsbutton.click();
			Generics.alertAction(driver, action);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfNoVehicleDetailsDisplayed(String product) {
		try {
			Generics.waitForElement(driver, vehicledetailsdeletetext);
			assertEquals(vehicledetailsdeletetext.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickVehicleDetailsAccordion() {
		try {
			Generics.waitForElement(driver, vehicledetailsaccordionlink);
			vehicledetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateVehicleDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, vehicledetails_brandname);
				assertEquals(vehicledetails_brandname.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, vehicledetails_liscencenumber);
				assertEquals(vehicledetails_liscencenumber.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, vehicledetails_vehicleownedextratextvariable1);
				assertEquals(vehicledetails_vehicleownedextratextvariable1.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, vehicledetails_vehicleownedextradatevariable1);
				assertEquals(vehicledetails_vehicleownedextradatevariable1.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddCoApplicantDetails() {
		try {
			Generics.waitForElement(driver, coapplicantdetails_addcoapplicantdetailsbutton);
			coapplicantdetails_addcoapplicantdetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addCoApplicantDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addcoapplicantdetails_firstnametextbox);
				addcoapplicantdetails_firstnametextbox.click();
				addcoapplicantdetails_firstnametextbox.clear();
				addcoapplicantdetails_firstnametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, addcoapplicantdetails_lastnametextbox);
				addcoapplicantdetails_lastnametextbox.click();
				addcoapplicantdetails_lastnametextbox.clear();
				addcoapplicantdetails_lastnametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, addcoapplicantdetails_emailtextbox);
				addcoapplicantdetails_emailtextbox.click();
				addcoapplicantdetails_emailtextbox.clear();
				addcoapplicantdetails_emailtextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, addcoapplicantdetails_companynametextbox);
				addcoapplicantdetails_companynametextbox.click();
				addcoapplicantdetails_companynametextbox.clear();
				addcoapplicantdetails_companynametextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, addcoapplicantdetails_coapplicantemploymenttextvariable1textbox);
				addcoapplicantdetails_coapplicantemploymenttextvariable1textbox.click();
				addcoapplicantdetails_coapplicantemploymenttextvariable1textbox.clear();
				addcoapplicantdetails_coapplicantemploymenttextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddCoApplicantDone() {
		try {
			Generics.waitForElement(driver, addcoapplicantdetails_donebutton);
			addcoapplicantdetails_donebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCoApplicantDetailsEdit(int i) {
		try {
			Generics.waitForElement(driver, coapplicantdetails_editbutton.get(i));
			coapplicantdetails_editbutton.get(i).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editCoApplicantDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editcoapplicantdetails_firstnametextbox);
				editcoapplicantdetails_firstnametextbox.click();
				editcoapplicantdetails_firstnametextbox.clear();
				editcoapplicantdetails_firstnametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, editcoapplicantdetails_lastnametextbox);
				editcoapplicantdetails_lastnametextbox.click();
				editcoapplicantdetails_lastnametextbox.clear();
				editcoapplicantdetails_lastnametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, editcoapplicantdetails_emailtextbox);
				editcoapplicantdetails_emailtextbox.click();
				editcoapplicantdetails_emailtextbox.clear();
				editcoapplicantdetails_emailtextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, editcoapplicantdetails_companynametextbox);
				editcoapplicantdetails_companynametextbox.click();
				editcoapplicantdetails_companynametextbox.clear();
				editcoapplicantdetails_companynametextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, editcoapplicantdetails_coapplicantemploymenttextvariable1textbox);
				editcoapplicantdetails_coapplicantemploymenttextvariable1textbox.click();
				editcoapplicantdetails_coapplicantemploymenttextvariable1textbox.clear();
				editcoapplicantdetails_coapplicantemploymenttextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfNoCoApplicantDetailsDisplayed(String product) {
		try {
			Generics.waitForElement(driver, coapplicantdetailsdeletebutton);
			assertEquals(coapplicantdetailsdeletebutton.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddInsuranceDetails() {
		try {
			Generics.waitForElement(driver, insurancedetails_addinsurancedetailsbutton);
			insurancedetails_addinsurancedetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addInsuranceDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addinsurancedetails_insurancenametextbox);
				addinsurancedetails_insurancenametextbox.click();
				addinsurancedetails_insurancenametextbox.clear();
				addinsurancedetails_insurancenametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, addinsurancedetails_amounttextbox);
				addinsurancedetails_amounttextbox.click();
				addinsurancedetails_amounttextbox.clear();
				addinsurancedetails_amounttextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, addinsurancedetails_typeofinsurancedropdown);
				Select typeOfInsuranceOptions = new Select(addinsurancedetails_typeofinsurancedropdown);
				typeOfInsuranceOptions.selectByVisibleText(product);
				break;

			case 3:
				Generics.waitForElement(driver, addinsurancedetails_insurancetextvariable1textbox);
				addinsurancedetails_insurancetextvariable1textbox.click();
				addinsurancedetails_insurancetextvariable1textbox.clear();
				addinsurancedetails_insurancetextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddInsuranceDetailsDone() {
		try {
			Generics.waitForElement(driver, addinsurancedetails_donebutton);
			addinsurancedetails_donebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickInsuranceDetailsEdit() {
		try {
			Generics.waitForElement(driver, insurancedetails_editbutton);
			insurancedetails_editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editInsuranceDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editinsurancedetails_insurernametextbox);
				editinsurancedetails_insurernametextbox.click();
				editinsurancedetails_insurernametextbox.clear();
				editinsurancedetails_insurernametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, editinsurancedetails_amounttextbox);
				editinsurancedetails_amounttextbox.click();
				editinsurancedetails_amounttextbox.clear();
				editinsurancedetails_amounttextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, editinsurancedetails_typeofinsurancedropdown);
				Select typeOfInsuranceOptions = new Select(editinsurancedetails_typeofinsurancedropdown);
				typeOfInsuranceOptions.selectByVisibleText(product);
				break;

			case 3:
				Generics.waitForElement(driver, editinsurancedetails_insurancetextvariable1textbox);
				editinsurancedetails_insurancetextvariable1textbox.click();
				editinsurancedetails_insurancetextvariable1textbox.clear();
				editinsurancedetails_insurancetextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditInsuranceDetailsDone() {
		try {
			Generics.waitForElement(driver, editinsurancedetails_donebutton);
			editinsurancedetails_donebutton.click();
			Generics.waitForElement(driver, editinsurancedetailsnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickInsuranceDetailsDelete(String action) {
		try {
			Generics.waitForElement(driver, insurancedetails_deletebutton);
			insurancedetails_deletebutton.click();
			Generics.alertAction(driver, action);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfNoInsuranceDetailsDisplayed(String product) {
		try {
			Generics.waitForElement(driver, insurancedetailsdeletetext);
			assertEquals(insurancedetailsdeletetext.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getInsuranceDetailsCount() {
		return Generics.getElementCount(insurancedetails_insurername);
	}

	public void clickInsuranceDetailsAccordion() {
		try {
			Generics.waitForElement(driver, insurancedetailsaccordionlink);
			insurancedetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateInsuranceDetails(int n, int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, insurancedetails_insurername.get(n));
				assertEquals(insurancedetails_insurername.get(n).getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, insurancedetails_amount.get(n));
				assertEquals(insurancedetails_amount.get(n).getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, insurancedetails_typeofinsurance.get(n));
				assertEquals(insurancedetails_typeofinsurance.get(n).getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, insurancedetails_insurancetextvariable1.get(n));
				assertEquals(insurancedetails_insurancetextvariable1.get(n).getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickContractsAccordion() {
		try {
			Generics.waitForElement(driver, contracts_contractsdetailsaccordionlink);
			contracts_contractsdetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfNoContractDetailsDisplayed(String product) {
		try {
			Generics.waitForElement(driver, contracts_nocontractsdisplayedtext);
			assertEquals(contracts_nocontractsdisplayedtext.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickPDCManagementAccordion() {
		try {
			Generics.waitForElement(driver, pdcmanagementaccordionlink);
			pdcmanagementaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfNoPDCDetailsDisplayed(String product) {
		try {
			Generics.waitForElement(driver, pdc_nopdcdisplayed);
			assertEquals(pdc_nopdcdisplayed.getText(), product);
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

	public void clickBorrowerQuestionGroupAccordion() {
		try {
			Generics.waitForElement(driver, borrowerquestiongroupaccordionlink);
			borrowerquestiongroupaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateBorrowerQuestionGroup(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, borrowernationalitydropdown);
				Select borrowerNationality = new Select(borrowernationalitydropdown);
				WebElement borrowerNationalityOption = borrowerNationality.getFirstSelectedOption();
				assertEquals(borrowerNationalityOption.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, downpaymenttextbox);
				assertEquals(downpaymenttextbox.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateBorrowerQuestionGroup2(int i, String product) {
		try {
			Generics.waitForElement(driver, borrowernationalitydropdown);
			Select borrowerNationality = new Select(borrowernationalitydropdown);
			WebElement borrowerNationalityOption = borrowerNationality.getFirstSelectedOption();
			assertEquals(borrowerNationalityOption.getText(), product);

			Generics.waitForElement(driver, downpaymenttextbox);
			assertEquals(downpaymenttextbox.getAttribute("value"), product);

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

	public void clickLoanApplicationDocumentAccordion() {
		try {
			Generics.waitForElement(driver, loanapplicationdocument_accordionlink);
			loanapplicationdocument_accordionlink.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCoApplicantDocumentAccordion() {
		try {
			Generics.waitForElement(driver, coapplicantdocument_accordionlink);
			coapplicantdocument_accordionlink.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickReferenceDocumentAccordion() {
		try {
			Generics.waitForElement(driver, referencedocument_accordionlink);
			referencedocument_accordionlink.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoanApplicationDocument(int i, String serialnumber, String documentcategory,
			String documentdetails, String visibletoborrower, String visibletoinvestor, String visibletobusinesspartner,
			String visibletofia) {
		try {
			Generics.waitForElement(driver, loanapplicationdocuments_serialnumbers.get(i));
			assertEquals(loanapplicationdocuments_serialnumbers.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, loanapplicationdocuments_documentcategory.get(i));
			assertEquals(loanapplicationdocuments_documentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, loanapplications_documentname.get(i));
//			assertEquals(loanapplications_documentname.get(i).getText(), documentdetails);

			if (visibletoborrower.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, loanapplications_visibletoborrower.get(i));
				assertEquals(loanapplications_visibletoborrower.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, loanapplications_visibletoborrower.get(i));
				assertEquals(loanapplications_visibletoborrower.get(i).isSelected(), false);
			}

			if (visibletoinvestor.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, loanapplications_visibletoinvestor.get(i));
				assertEquals(loanapplications_visibletoinvestor.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, loanapplications_visibletoinvestor.get(i));
				assertEquals(loanapplications_visibletoinvestor.get(i).isSelected(), false);
			}

			if (visibletobusinesspartner.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, loanapplications_visibletobusinesspartner.get(i));
				assertEquals(loanapplications_visibletobusinesspartner.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, loanapplications_visibletobusinesspartner.get(i));
				assertEquals(loanapplications_visibletobusinesspartner.get(i).isSelected(), false);
			}

			if (visibletofia.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, loanapplications_visibletofia.get(i));
				assertEquals(loanapplications_visibletofia.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, loanapplications_visibletofia.get(i));
				assertEquals(loanapplications_visibletofia.get(i).isSelected(), false);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCoApplicantDocument(int i, String serialnumber, String documentcategory, String documentdetails,
			String visibletoborrower, String visibletoinvestor, String visibletobusinesspartner, String visibletofia) {
		try {
			Generics.waitForElement(driver, coapplicant_serialnumber.get(i));
			assertEquals(coapplicant_serialnumber.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, coapplicant_documentcategory.get(i));
			assertEquals(coapplicant_documentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, coapplicant_documentname.get(i));
			assertEquals(coapplicant_documentname.get(i).getText(), documentdetails);

			if (visibletoborrower.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, coapplicant_visibletoborrower.get(i));
				assertEquals(coapplicant_visibletoborrower.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, coapplicant_visibletoborrower.get(i));
				assertEquals(coapplicant_visibletoborrower.get(i).isSelected(), false);
			}

			if (visibletoinvestor.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, coapplicant_visibletoinvestor.get(i));
				assertEquals(coapplicant_visibletoinvestor.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, coapplicant_visibletoinvestor.get(i));
				assertEquals(coapplicant_visibletoinvestor.get(i).isSelected(), false);
			}

			if (visibletobusinesspartner.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, coapplicant_visibletobusinesspartner.get(i));
				assertEquals(coapplicant_visibletobusinesspartner.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, coapplicant_visibletobusinesspartner.get(i));
				assertEquals(coapplicant_visibletobusinesspartner.get(i).isSelected(), false);
			}

			if (visibletofia.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, coapplicant_visibletofia.get(i));
				assertEquals(coapplicant_visibletofia.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, coapplicant_visibletofia.get(i));
				assertEquals(coapplicant_visibletofia.get(i).isSelected(), false);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateContracts(int i, String loanidproduct, String contractnameproduct, String currentstatusproduct,
			String accepteduploadedbyproduct, String accepteduploadedatstatusproduct) {
		try {
			Generics.waitForElement(driver, contract_loanidtext.get(i));
			assertEquals(contract_loanidtext.get(i).getText(), loanidproduct);

			Generics.waitForElement(driver, contract_contractnametext.get(i));
			assertEquals(contract_contractnametext.get(i).getText(), contractnameproduct);

			Generics.waitForElement(driver, contract_currentstatustext.get(i));
			assertEquals(contract_currentstatustext.get(i).getText(), currentstatusproduct);

			Generics.waitForElement(driver, contract_accepteduploadedbytext.get(i));
			assertEquals(contract_accepteduploadedbytext.get(i).getText(), accepteduploadedbyproduct);

			Generics.waitForElement(driver, contract_accepteduploadedatstatustext.get(i));
			assertEquals(contract_accepteduploadedatstatustext.get(i).getText(), accepteduploadedatstatusproduct);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfLoanContractsAreDownloaded(int i) {
		try {
			Generics.waitForElement(driver, contractfilestext.get(i));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCreatePDC() {
		try {
			Generics.waitForElement(driver, pdcmanagement_createpdcbutton);
			pdcmanagement_createpdcbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void createPDC(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, createpdc_coapplicantdropsown);
				Select coapplicant = new Select(createpdc_coapplicantdropsown);
				coapplicant.selectByVisibleText(product);
				break;

			case 1:
				Generics.waitForElement(driver, createpdc_banknametextbox);
				createpdc_banknametextbox.click();
				createpdc_banknametextbox.clear();
				createpdc_banknametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, createpdc_ifsccodetextbox);
				createpdc_ifsccodetextbox.click();
				createpdc_ifsccodetextbox.clear();
				createpdc_ifsccodetextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, createpdc_micrcodetextbox);
				createpdc_micrcodetextbox.click();
				createpdc_micrcodetextbox.clear();
				createpdc_micrcodetextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, createpdc_branchnametextbox);
				createpdc_branchnametextbox.click();
				createpdc_branchnametextbox.clear();
				createpdc_branchnametextbox.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, createpdc_amounttextbox);
				createpdc_amounttextbox.click();
				createpdc_amounttextbox.clear();
				createpdc_amounttextbox.sendKeys(product);
				break;

			case 6:
				Generics.waitForElement(driver, createpdc_chequenumbertextbox);
				createpdc_chequenumbertextbox.click();
				createpdc_chequenumbertextbox.clear();
				createpdc_chequenumbertextbox.sendKeys(product);
				break;

			case 7:
				Generics.waitForElement(driver, createpdc_chequestatustextbox);
				createpdc_chequestatustextbox.click();
				createpdc_chequestatustextbox.clear();
				createpdc_chequestatustextbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCreatePDCCreate() {
		try {
			Generics.waitForElement(driver, createpdc_createbutton);
			createpdc_createbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickPDCManagementEdit() {
		try {
			Generics.waitForElement(driver, pdcmanagement_editbutton);
			pdcmanagement_editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editPDCManagement(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editpdcmanagement_coapplicantdropdown);
				Select coapplicant = new Select(editpdcmanagement_coapplicantdropdown);
				coapplicant.selectByVisibleText(product);
				break;

			case 1:
				Generics.waitForElement(driver, editpdcmanagement_banknametextbox);
				editpdcmanagement_banknametextbox.click();
				editpdcmanagement_banknametextbox.clear();
				editpdcmanagement_banknametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, editpdcmanagement_ifsccodetextbox);
				editpdcmanagement_ifsccodetextbox.click();
				editpdcmanagement_ifsccodetextbox.clear();
				editpdcmanagement_ifsccodetextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, editpdcmanagement_micrcodetextbox);
				editpdcmanagement_micrcodetextbox.click();
				editpdcmanagement_micrcodetextbox.clear();
				editpdcmanagement_micrcodetextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, editpdcmanagement_branchnametextbox);
				editpdcmanagement_branchnametextbox.click();
				editpdcmanagement_branchnametextbox.clear();
				editpdcmanagement_branchnametextbox.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, editpdcmanagement_amounttextbox);
				editpdcmanagement_amounttextbox.click();
				editpdcmanagement_amounttextbox.clear();
				editpdcmanagement_amounttextbox.sendKeys(product);
				break;

			case 6:
				Generics.waitForElement(driver, editpdcmanagement_chequenumbertextbox);
				editpdcmanagement_chequenumbertextbox.click();
				editpdcmanagement_chequenumbertextbox.clear();
				editpdcmanagement_chequenumbertextbox.sendKeys(product);
				break;

			case 7:
				Generics.waitForElement(driver, editpdcmanagement_chequestatusdropdown);
				Select checkbookstatusoptions = new Select(editpdcmanagement_chequestatusdropdown);
				checkbookstatusoptions.selectByVisibleText(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditPDCManagementDone() {
		try {
			Generics.waitForElement(driver, editpdcmanagement_editbutton);
			editpdcmanagement_editbutton.click();
			Generics.waitForElement(driver, editpdcmanagement_notification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickPDCManagementDelete() {
		try {
			Generics.waitForElement(driver, pdcmanagement_deletebutton);
			pdcmanagement_deletebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validatePDCManagement(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, pdcmanagement_banknametext);
				assertEquals(pdcmanagement_banknametext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, pdcmanagement_ifsccodetext);
				assertEquals(pdcmanagement_ifsccodetext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, pdcmanagement_micrcodetext);
				assertEquals(pdcmanagement_micrcodetext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, pdcmanagement_branchnametext);
				assertEquals(pdcmanagement_branchnametext.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, pdcmanagement_amounttext);
				assertEquals(pdcmanagement_amounttext.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, pdcmanagment_chequenumbertext);
				assertEquals(pdcmanagment_chequenumbertext.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, pdcmanagement_pdccoapplicantname);
				assertEquals(pdcmanagement_pdccoapplicantname.getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, pdcmanagement_chequestatustext);
				assertEquals(pdcmanagement_chequestatustext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void checkLoanFundProgressBar(String product) {
		try {
			Generics.waitForElement(driver, loandetailsfundprogressbar);
			assertEquals(loandetailsfundprogressbar.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanRepaymentScheduleAccordion() {
		try {
			Generics.waitForElement(driver, loanrepaymentscheduleaccordionlink);
			loanrepaymentscheduleaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void payRepayments(int i, String alertaction, String repaymentpaymentoption, String updatedstatus) {
		try {
			Generics.waitForElement(driver, repaymentpaymentdropdown.get(i));
			Select repaymentOptions = new Select(repaymentpaymentdropdown.get(i));
			repaymentOptions.selectByVisibleText(repaymentpaymentoption);
			Generics.alertAction(driver, alertaction);
			Generics.waitForElement(driver, repaymentstatusupdatenotification);
			Thread.sleep(2000);
			Generics.waitForElement(driver, loanrepaymentschedule_statustext_afterrepayemi.get(i));
			assertEquals(loanrepaymentschedule_statustext_afterrepayemi.get(i).getText(), updatedstatus);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String storeAmountToBeRepaid() {
		String amountToBeRepaid = null;
		try {
			Generics.waitForElement(driver, amounttoberepaidtext);
			amountToBeRepaid = amounttoberepaidtext.getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return amountToBeRepaid;
	}

	public void clickCheckListAccordion() {
		try {
			Generics.waitForElement(driver, checklistaccordionlink);
			checklistaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickChecklistCheckbox() {
		try {
			Generics.waitForElement(driver, checklistcheckbox);
			checklistcheckbox.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickManageLoanApplicationDetailsAccordion() {
		try {
			Generics.waitForElement(driver, manageloanapplicationaccordionlink);
			manageloanapplicationaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfLoanDetailsAreDisabled() {
		try {
			Generics.waitForElement(driver, manageloanapplication_amount);
			assertEquals(manageloanapplication_amount.getAttribute("disabled"), "true");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfLoanDetailsAreEnabled() {
		try {
			Generics.waitForElement(driver, manageloanapplication_amount);
			assertEquals(manageloanapplication_amount.isEnabled(), true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int countLoanRepaymentPaidEMIStatus() {
		int j = 0;
		try {
			Generics.waitForElement(driver, loanrepaymentschedule_statustext2.get(0));
			for (int i = 0; i < loanrepaymentschedule_statustext2.size(); i++) {
				if (loanrepaymentschedule_statustext2.get(i).getText().equalsIgnoreCase("PAID")) {
					j++;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return j;
	}

	public int countTotalLoanRepaymentEMIStatus() {
		try {
			Generics.waitForElement(driver, loanrepaymentschedule_statustext2.get(0));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return loanrepaymentschedule_statustext2.size();
	}

	public void clickBorrower() {
		try {
			Generics.waitForElement(driver, borowerhyperlink);
			borowerhyperlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void previewDocument() {
		try {
			Generics.waitForElement(driver, loanapplicationdocument_viewbutton.get(0));
			loanapplicationdocument_viewbutton.get(0).click();
			Generics.waitForElement(driver, loanapplicationdocument_preview_closebutton);
			loanapplicationdocument_preview_closebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void downloadDocument() {
		try {
			Generics.waitForElement(driver, loanapplicationdocument_downloadbutton.get(0));
			loanapplicationdocument_downloadbutton.get(0).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void uploadDocument(String filepath) {
		try {
			Generics.waitForElement(driver, loanapplicationdocument_uploadbutton.get(0));
			loanapplicationdocument_uploadbutton.get(0).click();

			Generics.waitForElement(driver, loanapplicationdocument_choosefilebutton);
			loanapplicationdocument_choosefilebutton.sendKeys(filepath);

			Generics.waitForElement(driver, loanapplicationdocument_donebutton);
			loanapplicationdocument_donebutton.click();

			Generics.waitForElement(driver, documentuploadnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void deleteDocument() {
		try {
			Generics.waitForElement(driver, loanapplicationdocument_uploadbutton.get(0));
			loanapplicationdocument_uploadbutton.get(0).click();

			Generics.waitForElement(driver, loanapplicationdocument_deletebutton.get(0));
			loanapplicationdocument_deletebutton.get(0).click();

			Generics.waitForElement(driver, documentdeletenotification);

			Generics.waitForElement(driver, loanapplicationdocument_popupclosebutton);
			loanapplicationdocument_popupclosebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateDocumentCount(String filename, int count) {
		try {
			Generics.waitForElement(driver, loanapplicationdocument_uploadbutton.get(0));
			loanapplicationdocument_uploadbutton.get(0).click();
			assertEquals(supportingdocumentuploadedfilecount.size(), count);
			Generics.waitForElement(driver, loanapplicationdocument_popupclosebutton);
			loanapplicationdocument_popupclosebutton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateReferenceDocument(int i, String serialnumber, String documentcategory, String documentdetails,
			String visibletoborrower, String visibletoinvestor, String visibletobusinesspartner, String visibletofia) {
		try {
			Generics.waitForElement(driver, reference_serialnumber.get(i));
			assertEquals(reference_serialnumber.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, reference_documentcategory.get(i));
			assertEquals(reference_documentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, reference_documentname.get(i));
			assertEquals(reference_documentname.get(i).getText(), documentdetails);

			if (visibletoborrower.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, reference_visibletoborrower.get(i));
				assertEquals(reference_visibletoborrower.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, reference_visibletoborrower.get(i));
				assertEquals(reference_visibletoborrower.get(i).isSelected(), false);
			}

			if (visibletoinvestor.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, reference_visibletoinvestor.get(i));
				assertEquals(reference_visibletoinvestor.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, reference_visibletoinvestor.get(i));
				assertEquals(reference_visibletoinvestor.get(i).isSelected(), false);
			}

			if (visibletobusinesspartner.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, reference_visibletobusinesspartner.get(i));
				assertEquals(reference_visibletobusinesspartner.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, reference_visibletobusinesspartner.get(i));
				assertEquals(reference_visibletobusinesspartner.get(i).isSelected(), false);
			}

			if (visibletofia.equalsIgnoreCase("Yes")) {
				Generics.waitForElement(driver, reference_visibletofia.get(i));
				assertEquals(reference_visibletofia.get(i).isSelected(), true);
			} else {
				Generics.waitForElement(driver, reference_visibletofia.get(i));
				assertEquals(reference_visibletofia.get(i).isSelected(), false);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Divya:

	public int getCoApplicantsCount() {
		return Generics.getElementCount(coapplicantdetails_name);
	}

	public void validateCoApplicantDetailsInPopUp(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, editcoapplicantdetails_firstnametextbox);
				assertEquals(editcoapplicantdetails_firstnametextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, editcoapplicantdetails_lastnametextbox);
				assertEquals(editcoapplicantdetails_lastnametextbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, editcoapplicantdetails_emailtextbox);
				assertEquals(editcoapplicantdetails_emailtextbox.getAttribute("value"), product);
				break;

			case 3:
				Generics.waitForElement(driver, editcoapplicantdetails_companynametextbox);
				assertEquals(editcoapplicantdetails_companynametextbox.getAttribute("value"), product);
				break;

			case 4:
				Generics.waitForElement(driver, editcoapplicantdetails_coapplicantemploymenttextvariable1textbox);
				assertEquals(editcoapplicantdetails_coapplicantemploymenttextvariable1textbox.getAttribute("value"),
						product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditCoApplicantDetailsDone() {
		try {
			Generics.waitForElement(driver, editcoapplicantdetails_donebutton);
			editcoapplicantdetails_donebutton.click();
			Generics.waitForElement(driver, editcoapplicantdetailsnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCoApplicantDetailsDelete(String action, int i) {
		try {
			Generics.waitForElement(driver, coapplicantdetails_deletebutton.get(i));
			coapplicantdetails_deletebutton.get(i).click();
			Generics.alertAction(driver, action);
			Generics.waitForElement(driver, deletecoapplicantnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCoApplicantDetails(int n, int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, coapplicantdetails_name.get(n));
				assertEquals(coapplicantdetails_name.get(n).getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, coapplicantdetails_email.get(n));
				assertEquals(coapplicantdetails_email.get(n).getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, coapplicantdetails_companyname.get(n));
				assertEquals(coapplicantdetails_companyname.get(n).getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, coapplicantdetails_coapplicantemploymenttextvariable1.get(n));
				assertEquals(coapplicantdetails_coapplicantemploymenttextvariable1.get(n).getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditCoApplicantClose() {
		try {
			Generics.waitForElement(driver, editcoapplicant_closebutton);
			editcoapplicant_closebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickReferenceDetailsAccordion() {
		try {
			Generics.waitForElement(driver, referencedetailsaccordionlink);
			referencedetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanCommentsAccordion() {
		try {
			Generics.waitForElement(driver, loancommentsaccordion);
			loancommentsaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddLoanCommentsButton() {
		try {
			Generics.waitForElement(driver, addcommentbutton);
			addcommentbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterComment(String comment, String filepath) {
		try {

			Generics.waitForElement(driver, loancomment_choosefilebutton);
			loancomment_choosefilebutton.sendKeys(filepath);
			Generics.waitForElement(driver, commenttextbox);
			commenttextbox.click();
			commenttextbox.clear();
			commenttextbox.sendKeys(comment);
			visibletoborrowercheckbox.click();
			visibletoinvestorcheckbox.click();
			visibletodsacheckbox.click();
			visibletofiacheckbox.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanCommentsDoneButton() {
		try {
			Generics.waitForElement(driver, loancommentdonebutton);
			loancommentdonebutton.click();

			Generics.waitForElement(driver, loancommentnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanDetailsPageNextSliderForCompanyRepresentative() {
		try {
			Generics.waitForElement(driver, loandetailspage_nextslider);
			loandetailspage_nextslider.click();
			loandetailspage_nextslider.click();
			loandetailspage_nextslider.click();

			Generics.waitForElement(driver, companyrepresentativetab);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCompanyRepresentativeTab() {
		try {
			Generics.waitForElement(driver, companyrepresentativetab);
			companyrepresentativetab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickShareHolderAccordion() {
		try {
			Generics.waitForElement(driver, shareholderaccordion);
			shareholderaccordion.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getShareholderCount() {
		return Generics.getElementCount(validatelastname);
	}

	public void validateShareHolderDetails(int n, int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, validatedob.get(n));
				assertEquals(validatedob.get(n).getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, validateidnumbertwo.get(n));
				assertEquals(validateidnumbertwo.get(n).getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, validatelastname.get(n));
				assertEquals(validatelastname.get(n).getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, validateemail.get(n));
				assertEquals(validateemail.get(n).getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, validateidnumberone.get(n));
				assertEquals(validateidnumberone.get(n).getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, validatefirstname.get(n));
				assertEquals(validatefirstname.get(n).getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, validateaddressone.get(n));
				assertEquals(validateaddressone.get(n).getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, validatemobilenumber.get(n));
				assertEquals(validatemobilenumber.get(n).getText(), product);
				break;

			case 8:
				Generics.waitForElement(driver, validatecitizenship.get(n));
				assertEquals(validatecitizenship.get(n).getText(), product);
				break;

			case 9:
				Generics.waitForElement(driver, validatedateofappointment.get(n));
				assertEquals(validatedateofappointment.get(n).getText(), product);
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editCompanyRepresentative(int n) {
		try {
			Generics.waitForElement(driver, shareholder_editbutton.get(n));
			shareholder_editbutton.get(n).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderFirstName(String firstname) {
		try {
			Generics.waitForElement(driver, shareholderfirstnametextbox);
			shareholderfirstnametextbox.click();
			shareholderfirstnametextbox.clear();
			shareholderfirstnametextbox.sendKeys(firstname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderLastName(String lastname) {
		try {
			Generics.waitForElement(driver, shareholderlastnametextbox);
			shareholderlastnametextbox.click();
			shareholderlastnametextbox.clear();
			shareholderlastnametextbox.sendKeys(lastname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderEmail(String emailaddress) {
		try {
			Generics.waitForElement(driver, shareholderemailaddresstextbox);
			shareholderemailaddresstextbox.click();
			shareholderemailaddresstextbox.clear();
			shareholderemailaddresstextbox.sendKeys(emailaddress);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderMobileNumber(String mobilenumber) {
		try {
			Generics.waitForElement(driver, shareholdermobilenumbertextbox);
			shareholdermobilenumbertextbox.click();
			shareholdermobilenumbertextbox.clear();
			shareholdermobilenumbertextbox.sendKeys(mobilenumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderDob(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, shareholderdobtextbox);
			shareholderdobtextbox.click();
			Select yeardropdown = new Select(shareholderdobyeardropdown);
			yeardropdown.selectByVisibleText(year);
			Select monthdropdown = new Select(shareholderdobmonthdropdown);
			monthdropdown.selectByVisibleText(month);
			for (int i = 0; i < shareholderdobdatealllinks.size(); i++) {
				if (shareholderdobdatealllinks.get(i).getText().equalsIgnoreCase(date)) {
					shareholderdobdatealllinks.get(i).click();

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderCitizenship(String citizenship) {
		try {
			Generics.waitForElement(driver, shareholdercitizenshiptextbox);
			shareholdercitizenshiptextbox.click();
			shareholdercitizenshiptextbox.clear();
			shareholdercitizenshiptextbox.sendKeys(citizenship);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderIdentityNumberOne(String identitynumberone) {
		try {
			Generics.waitForElement(driver, shareholderidentitynumberonetextbox);
			shareholderidentitynumberonetextbox.click();
			shareholderidentitynumberonetextbox.clear();
			shareholderidentitynumberonetextbox.sendKeys(identitynumberone);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderIdentityNumberTwo(String identitynumbertwo) {
		try {
			Generics.waitForElement(driver, shareholderidentitynumbertwotextbox);
			shareholderidentitynumbertwotextbox.click();
			shareholderidentitynumbertwotextbox.clear();
			shareholderidentitynumbertwotextbox.sendKeys(identitynumbertwo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderDateOfAppointment(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, shareholderdateofappointmenttextbox);
			shareholderdateofappointmenttextbox.click();
			Select yeardropdown = new Select(shareholderdateofappointmentyeardropdown);
			yeardropdown.selectByVisibleText(year);
			Select monthdropdown = new Select(shareholderdateofappointmentmonthdropdown);
			monthdropdown.selectByVisibleText(month);
			for (int i = 0; i < shareholderdateofappointmentdatealllinks.size(); i++) {
				if (shareholderdateofappointmentdatealllinks.get(i).getText().equalsIgnoreCase(date)) {
					shareholderdateofappointmentdatealllinks.get(i).click();

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderAddressOne(String line1, String line2, String line3, String subdistrict,
			String district, String state, String city, String country, String zipcode, String year, String month,
			String date, String ownershiptype, String addresstype) {
		try {
			Generics.waitForElement(driver, shareholderaddressoneline1);
			shareholderaddressoneline1.click();
			shareholderaddressoneline1.clear();
			shareholderaddressoneline1.sendKeys(line1);

			Generics.waitForElement(driver, shareholderaddressoneline2);
			shareholderaddressoneline2.click();
			shareholderaddressoneline2.clear();
			shareholderaddressoneline2.sendKeys(line2);

			Generics.waitForElement(driver, shareholderaddressoneline3);
			shareholderaddressoneline3.click();
			shareholderaddressoneline3.clear();
			shareholderaddressoneline3.sendKeys(line3);

			Generics.waitForElement(driver, shareholderaddressonesubdistrict);
			shareholderaddressonesubdistrict.click();
			shareholderaddressonesubdistrict.clear();
			shareholderaddressonesubdistrict.sendKeys(subdistrict);

			Generics.waitForElement(driver, shareholderaddressonedistrict);
			shareholderaddressonedistrict.click();
			shareholderaddressonedistrict.clear();
			shareholderaddressonedistrict.sendKeys(district);

			Generics.waitForElement(driver, shareholderaddressonestate);
			shareholderaddressonestate.click();
			Select statedropdown = new Select(shareholderaddressonestate);
			statedropdown.selectByVisibleText(state);

			Generics.waitForElement(driver, shareholderaddressonecity);
			shareholderaddressonecity.click();
			shareholderaddressonecity.clear();
			shareholderaddressonecity.sendKeys(city);

			Generics.waitForElement(driver, shareholderaddressonecountry);
			shareholderaddressonecountry.click();
			shareholderaddressonecountry.clear();
			shareholderaddressonecountry.sendKeys(country);

			Generics.waitForElement(driver, shareholderaddressonezipcode);
			shareholderaddressonezipcode.click();
			shareholderaddressonezipcode.clear();
			shareholderaddressonezipcode.sendKeys(zipcode);

			Generics.waitForElement(driver, shareholderlivingsincetextbox);
			shareholderlivingsincetextbox.click();

			Generics.waitForElement(driver, shareholderlivingsinceyeardropdown);
			Select yeardropdown = new Select(shareholderlivingsinceyeardropdown);
			yeardropdown.selectByVisibleText(year);

			Generics.waitForElement(driver, shareholderlivingsincemonthdropdown);
			Select monthdropdown = new Select(shareholderlivingsincemonthdropdown);
			monthdropdown.selectByVisibleText(month);

			for (int i = 0; i < shareholderlivingsincedatealllinks.size(); i++) {
				if (shareholderlivingsincedatealllinks.get(i).getText().equalsIgnoreCase(date)) {
					shareholderlivingsincedatealllinks.get(i).click();
				}
			}

			Generics.waitForElement(driver, shareholderaddressoneownershiptype);
			shareholderaddressoneownershiptype.click();
			Select ownershiptypedropdown = new Select(shareholderaddressoneownershiptype);
			ownershiptypedropdown.selectByVisibleText(ownershiptype);

			Generics.waitForElement(driver, shareholderaddressonetypeofaddress);
			shareholderaddressonetypeofaddress.click();
			Select addresstypedropdown = new Select(shareholderaddressonetypeofaddress);
			addresstypedropdown.selectByVisibleText(addresstype);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditShareHolderContinueButton() {
		try {
			Generics.waitForElement(driver, editshareholdercontinuebutton);
			editshareholdercontinuebutton.click();
			Generics.waitForElement(driver, shareholderupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void createShareHolder() {
		try {
			Generics.waitForElement(driver, createshareholderbutton);
			createshareholderbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickContinueAddShareHolderButton() {
		try {
			Generics.waitForElement(driver, addshareholdercontinuebutton);
			addshareholdercontinuebutton.click();
			Generics.waitForElement(driver, shareholdercreatednotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void deleteCompanyRepresentative(String action, int n) {
		try {
			Generics.waitForElement(driver, deleteshareholder.get(n));
			deleteshareholder.get(n).click();
			Generics.alertAction(driver, action);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfNoShareHolderDetailsAreDisplayed(String product) {
		try {
			Generics.waitForElement(driver, noshareholderdisplayed);
			assertEquals(noshareholderdisplayed.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
