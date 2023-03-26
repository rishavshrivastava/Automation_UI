package com.automationsaas.pom.borrower;

import static org.testng.Assert.assertEquals;

import java.io.File;
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

	@FindBy(xpath = "//a[contains(text(),'Details')]")
	private WebElement detailstab;

	@FindBy(xpath = "//h2")
	private WebElement loanidtext;

	@FindBy(id = "loan_funded_span")
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

	@FindBy(xpath = "//a[contains(.,'Loan Repayment Schedule')]")
	private WebElement loanrepaymentscheduleaccordionlink;

	@FindBy(xpath = "//div[@id='loan_repayment_schedule_table']")
	private WebElement loanrepaymentscheduletable;

	@FindBy(xpath = "//div[@id='completeQuestionsTemplateDiv']//a[contains(.,'Questions')]")
	private WebElement questionsaccordion;

	@FindBy(xpath = "//div[@id='questions_table']//strong")
	private WebElement questionstext;

	@FindBy(xpath = "//a[contains(.,'Borrower Question Group 1')]")
	private WebElement borrowerquestiongroupaccordion;

	@FindBy(xpath = "//label[contains(text(),'Borrower Nationality')]/..//select")
	private WebElement borrowernationalityanswer;

	@FindBy(xpath = "//label[contains(text(),'Down Payment')]/../input")
	private WebElement downpaymentanswer;

	@FindBy(xpath = "//div[@id='cfAnswersTemplateId']//button[contains(text(),'Submit')]")
	private WebElement borrowerquestiongroupsubmitbutton;

	@FindBy(xpath = "//button[contains(text(),'Add Reference')]")
	private WebElement addreferencebutton;

	@FindBy(xpath = "//a[contains(.,'Reference Details')]")
	private WebElement referencedetailsaccordionlink;

	@FindBy(xpath = "//div[@id='reference_detail_list']//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)+1]")
	private WebElement referencedetailsname;

	@FindBy(xpath = "//div[@id='reference_detail_list']//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)]")
	private WebElement referencedetailsemail;

	@FindBy(xpath = "//div[@id='reference_detail_list']//th[.='Mobile Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Mobile Number']/preceding-sibling::th)+1]")
	private WebElement referencedetailsmobilenumber;

	@FindBy(xpath = "//div[@id='reference_detail_list']//th[.='Relationship Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Relationship Status']/preceding-sibling::th)+1]")
	private WebElement referencedetailsrelationshipstatus;

	@FindBy(xpath = "//div[@id='reference_detail_list']//button[@id='edit_bank_detail_modal_opener']")
	private WebElement referencedetailseditbutton;

	@FindBy(xpath = "//div[@id='reference_detail_list']//button[@name='cardDetaildeleteLink']")
	private WebElement referencedetailsdeletebutton;

	@FindBy(xpath = "//div[@id='showGuarantorDetailsDiv']//a")
	private WebElement coapplicantaccordionlink;

	@FindBy(xpath = "//div[@id='showGuarantorDetailsDiv']//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)+1]")
	private List<WebElement> coapplicantdetailsname;

	@FindBy(xpath = "//div[@id='showGuarantorDetailsDiv']//th[text()='Email']/ancestor::thead/following-sibling::tbody/tr/td[2]")
	private List<WebElement> coapplicantdetailsemail;

	@FindBy(xpath = "//div[@id='showGuarantorDetailsDiv']//th[.='Company Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Company Name']/preceding-sibling::th)+1]")
	private List<WebElement> coapplicantdetailscompanyname;

	@FindBy(xpath = "//div[@id='showGuarantorDetailsDiv']//th[contains(.,'Co Applicant Employment Text Variable 1')]/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[contains(.,'Co Applicant Employment Text Variable 1')]/preceding-sibling::th)+1]")
	private List<WebElement> coapplicantemploymenttextvariable1;

	@FindBy(xpath = "//a[contains(.,'Other Loan Details')]")
	private WebElement otherloandetailsaccordionlink;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='LoanPurpose']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='LoanPurpose']/preceding-sibling::th)+1]")
	private WebElement otherloandetailsloanpurpose;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='Loan Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Amount']/preceding-sibling::th)+1]")
	private WebElement otherloandetailsloanamount;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='Repayment Amount']/../../following-sibling::tbody//td[3]")
	private WebElement otherloandetailsrepaymentamount;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private WebElement otherloandetailsbankname;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//th[.='Loan extra text variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan extra text variable1']/preceding-sibling::th)+1]")
	private WebElement otherloandetailsloanextratextvariable1;

	@FindBy(xpath = "//a[contains(.,'Vehicle Details')]")
	private WebElement vehicledetailsaccordionlink;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//th[.='Brand Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Brand Name']/preceding-sibling::th)+1]")
	private WebElement vehicledetailsbrandname;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//th[.='License Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='License Number']/preceding-sibling::th)+1]")
	private WebElement vehicledetailslicensenumber;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//th[.='Vehicle Owned extra text variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Vehicle Owned extra text variable1']/preceding-sibling::th)+1]")
	private WebElement vehicleownedextratextvariable1;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//th[.='Vehicle Owned extra date variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Vehicle Owned extra date variable1']/preceding-sibling::th)+1]")
	private WebElement vehicleownedextradatevariable1;

	@FindBy(xpath = "//a[contains(.,'Insurance Details')]")
	private WebElement insurancedetailsaccordionlink;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//th[.='Insurer Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurer Name']/preceding-sibling::th)+1]")
	private List<WebElement> insurancedetailsinsurername;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)+1]")
	private List<WebElement> insurancedetailsamount;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//th[.='Type of Insurance']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type of Insurance']/preceding-sibling::th)+1]")
	private List<WebElement> insurancedetailstypeofinsurance;

	@FindBy(xpath = "//div[@id='borrowerInsurance']//th[.='Insurance Text Variable 1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 1']/preceding-sibling::th)+1]")
	private List<WebElement> insurancetextvariable1;

	@FindBy(xpath = "//a[contains(.,'Contracts')]")
	private WebElement contractsaccordionlink;

	@FindBy(xpath = "//div[@id='documentDetailTable']//strong")
	private WebElement contractstext;

	@FindBy(xpath = "//th[.='S.No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='S.No']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_serialnumbertext;

	@FindBy(xpath = "//th[.='Payable Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Payable Amount']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_payableamounttext;

	@FindBy(xpath = "//th[.='Penalties']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Penalties']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_penaltiestext;

	@FindBy(xpath = "//th[.='Mark Paid']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Mark Paid']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_markpaidtext;

	@FindBy(xpath = "//th[.='Total Interest Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Total Interest Amount']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_totalinterestamounttext;

	@FindBy(xpath = "//th[@id='LOAN_INTEREST']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='LOAN_INTEREST']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_interesttext;

	@FindBy(xpath = "//th[.='Repayment Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Repayment Amount']/preceding-sibling::th)-1]")
	private List<WebElement> loanrepaymentschedule_repaymentamounttext;

	@FindBy(xpath = "//th[.='Principal']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Principal']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_principaltext;

	@FindBy(xpath = "//th[.='Loan Tenure']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Tenure']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_loantenuretext;

	@FindBy(xpath = "//th[.='Repayment Date']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Repayment Date']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_repaymentdatetext;

	@FindBy(xpath = "//th[.='Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Status']/preceding-sibling::th)+1]/div")
	private List<WebElement> loanrepaymentschedule_statustext;

	@FindBy(xpath = "//div[@id='cfAnswersTemplateId']//button[contains(text(),'Submit')]")
	private WebElement borrowerquestiongroup1submitbutton;

	@FindBy(xpath = "//div[@id='reference_detail_list']//i[@class='fa fa-edit']")
	private WebElement referencedetails_editbutton;

	@FindBy(xpath = "//div[@id='reference_detail_list']//i[@class='fa fa-trash']")
	private WebElement referencedetails_deletebutton;

	@FindBy(xpath = "//div[@id='showReferenceDetailsDiv']//button[@id='reference_detail']")
	private WebElement referencedetails_addreferencebutton;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='firstName']")
	private WebElement addreference_firstnametextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='lastName']")
	private WebElement addreference_lastnametextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='userName']")
	private WebElement addreference_emailtextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='phoneNumber']")
	private WebElement addreference_mobilenumbertextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//input[@id='relationshipStatus']")
	private WebElement addreference_relationshipstatustextbox;

	@FindBy(xpath = "//form[@id='referenceForm']//button[@id='submitReferenceBtn']")
	private WebElement addreference_donebutton;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='firstName']")
	private WebElement updatereference_firstnametextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='lastName']")
	private WebElement updatereference_lastnametextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='userName']")
	private WebElement updatereference_emailtextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='phoneNumber']")
	private WebElement updatereference_mobilenumbertextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//input[@id='relationshipStatus']")
	private WebElement updatereference_relationshipstatustextbox;

	@FindBy(xpath = "//form[@id='updateReferenceForm']//button[@id='submitUpdateBtn']")
	private WebElement updatereference_donebutton;

	@FindBy(xpath = "//div[@id='showGuarantorDetailsDiv']//button[@id='co_applicant_detail']")
	private WebElement coapplicantdetails_addcoapplicantbutton;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='firstName']")
	private WebElement addcoapplicant_firstnametextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='lastName']")
	private WebElement addcoapplicant_lastnametextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='emailId']")
	private WebElement addcoapplicant_emailtextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='identityNumberOne']")
	private WebElement addcoapplicant_aadharcardnumbertextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='identityNumberTwo']")
	private WebElement addcoapplicant_pancardnumbertextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='identityNumberThree']")
	private WebElement addcoapplicant_identitynumberthreetextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='identityNumberFour']")
	private WebElement addcoapplicant_identitynumberfourtextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='identityNumberFive']")
	private WebElement addcoapplicant_identitynumberfivetextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='identityNumberSix']")
	private WebElement addcoapplicant_identitynumbersixtextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='companyName']")
	private WebElement addcoapplicant_companynametextbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='coApplicantEmploymentTextVariable1']")
	private WebElement addcoapplicant_coapplicantemploymenttextvariable1textbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//input[@id='coApplicantEmploymentDateVariable1']")
	private WebElement addcoapplicant_coapplicantemploymentdatevariable1textbox;

	@FindBy(xpath = "//form[@id='addCoApplicantOnBoard']//button[@id='submit_co_applicant']")
	private WebElement addcoapplicant_donebutton;

	@FindBy(xpath = "//div[@id='co_applicant_list_onBoard']//i[@class='fa fa-edit']")
	private List<WebElement> coapplicantdetails_editbutton;

	@FindBy(xpath = "//div[@id='co_applicant_list_onBoard']//i[@class='fa fa-trash']")
	private List<WebElement> coapplicantdetails_deletebutton;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='firstName']")
	private WebElement updatecoapplicantdetails_firstnametextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='lastName']")
	private WebElement updatecoapplicantdetails_lastnametextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='emailId']")
	private WebElement updatecoapplicantdetails_emailtextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='identityNumberOne']")
	private WebElement updatecoapplicantdetails_aadharcardnumbertextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='identityNumberTwo']")
	private WebElement updatecoapplicantdetails_pancardnumbertextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='identityNumberThree']")
	private WebElement updatecoapplicantdetails_identitynumberthreetextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='identityNumberFour']")
	private WebElement updatecoapplicantdetails_identitynumberfourtextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='identityNumberFive']")
	private WebElement updatecoapplicantdetails_identitynumberfivetextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='identityNumberSix']")
	private WebElement updatecoapplicantdetails_identitynumbersixtextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='companyName']")
	private WebElement updatecoapplicantdetails_companynametextbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='coApplicantEmploymentTextVariable1']")
	private WebElement updatecoapplicantdetails_coapplicantemploymenttextvariable1textbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//input[@id='coApplicantEmploymentDateVariable1']")
	private WebElement updatecoapplicantdetails_coapplicantemploymentdatevariable1textbox;

	@FindBy(xpath = "//form[@id='updateCoApplicantOnBoard']//button[@id='submit_co_applicant']")
	private WebElement updatecoapplicantdetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'has been successfully updated.')]")
	private WebElement coapplicantdetailsupdatenotification;

	@FindBy(xpath = "//div[@id='loadOtherLoans']//button[@id='other_loan_detail']")
	private WebElement otherloandetails_addotherloandetailsbutton;

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

	@FindBy(xpath = "//div[@id='editCreateOtherLoanDivId']//button[@id='addOtherLoanBtn']")
	private WebElement addotherloandetails_donebutton;

	@FindBy(xpath = "//div[@id='other_loan_list']//i[@class='fa fa-edit']")
	private WebElement addotherloandetails_editbutton;

	@FindBy(xpath = "//div[@id='other_loan_list']//i[@class='fa fa-trash-o']")
	private WebElement addotherloandetails_deletebutton;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='purpose']")
	private WebElement updateotherloandetails_loanpurposetextbox;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='loanAmount']")
	private WebElement updateotherloandetails_loanamounttextbox;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='repaymentAmount']")
	private WebElement updateotherloandetails_repaymentamounttextbox;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='bankName']")
	private WebElement updateotherloandetails_banknametextbox;

	@FindBy(xpath = "//form[@id='otherLoanDetailForm']//input[@id='otherLoanTextVariable1']")
	private WebElement updateotherloandetails_loanextratextvariable1textbox;

	@FindBy(xpath = "//div[@id='editCreateOtherLoanDivId']//button[@id='updateOtherLoanBtn']")
	private WebElement updateotherloandetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'Other Loan has been Updated')]")
	private WebElement updateotherloandetailsnotifications;

	@FindBy(xpath = "//div[@id='borrowerVehicleDetails']//button[@id='vehicle_owned_detail']")
	private WebElement vehicledetails_addvehicledetailsbutton;

	@FindBy(xpath = "//form[@id='createVehicleOwnedDetailForm']//input[@id='brandName']")
	private WebElement addvehicledetails_brandnametextbox;

	@FindBy(xpath = "//form[@id='createVehicleOwnedDetailForm']//input[@id='licenseNumber']")
	private WebElement addvehicledetails_licensenumbertextbox;

	@FindBy(xpath = "//form[@id='createVehicleOwnedDetailForm']//input[@id='vehicleOwnedTextVariable1']")
	private WebElement addvehicledetails_vehicleownedextratextvariable1textbox;

	@FindBy(xpath = "//div[@id='editCreateVehicleOwnedDivId']//button[@id='createVehicleOwnedDetailBtn']")
	private WebElement addvehicledetails_donebutton;

	@FindBy(xpath = "//div[@id='vehicle_list']//i[@class='fa fa-edit']")
	private WebElement vehicledetails_editbutton;

	@FindBy(xpath = "//div[@id='vehicle_list']//i[@class='fa fa-trash-o']")
	private WebElement vehicledetails_deletebutton;

	@FindBy(xpath = "//form[@id='vehicleOwnedDetailForm']//input[@id='brandName']")
	private WebElement updatevehicledetails_brandnametextbox;

	@FindBy(xpath = "//form[@id='vehicleOwnedDetailForm']//input[@id='licenseNumber']")
	private WebElement updatevehicledetails_licensenumbertextbox;

	@FindBy(xpath = "//form[@id='vehicleOwnedDetailForm']//input[@id='vehicleOwnedTextVariable1']")
	private WebElement updatevehicledetails_vehicleownedextratextvariable1textbox;

	@FindBy(xpath = "//div[@id='editCreateVehicleOwnedDivId']//button[@id='updateVehicleOwnedDetailBtn']")
	private WebElement updatevehicledetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'Vehicle record Royal updated')]")
	private WebElement updatevehicledetailsnotification;

	@FindBy(xpath = "//button[contains(text(),'Add insurance Detail')]")
	private WebElement insurancedetails_addinsurancedetailsbutton;

	@FindBy(xpath = "//div[@id='insurance_list']//i[@class='fa fa-edit']")
	private WebElement insurancedetails_editbutton;

	@FindBy(xpath = "//div[@id='insurance_list']//i[@class='fa fa-trash-o']")
	private WebElement insurancedetails_deletebutton;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//input[@id='insuranceName']")
	private WebElement addinsurancedetails_insurernametextbox;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//input[@id='insuranceAmount']")
	private WebElement addinsurancedetails_amounttextbox;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//select[@id='insuranceType']")
	private WebElement addinsurancedetails_typeofinsurancedropdown;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//input[@id='insuranceTextVariable1']")
	private WebElement addinsurancedetails_insurancetextvariable1textbox;

	@FindBy(xpath = "//form[@id='insuranceDetailForm']//button[contains(text(),'Done')]")
	private WebElement addinsurancedetails_donebutton;

	@FindBy(xpath = "//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceName']")
	private WebElement updateinsurancedetails_insurernametextbox;

	@FindBy(xpath = "//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceAmount']")
	private WebElement updateinsurancedetails_amounttextbox;

	@FindBy(xpath = "//form[@id='insuranceDetailUpdateForm']//select[@id='insuranceType']")
	private WebElement updateinsurancedetails_typeofinsurancedropdown;

	@FindBy(xpath = "//form[@id='insuranceDetailUpdateForm']//input[@id='insuranceTextVariable1']")
	private WebElement updateinsurancedetails_insurancetextvariable1textbox;

	@FindBy(xpath = "//div[@id='editCreateinsuranceDivId']//button[contains(text(),'Done')]")
	private WebElement updateinsurancedetails_donebutton;

	@FindBy(xpath = "//span[contains(text(),'insurance updated')]")
	private WebElement updateinsurancenotification;

	@FindBy(xpath = "//div[@id='co_applicant_list_onBoard']//strong")
	private WebElement coapplicantdetailsdeletetext;

	@FindBy(xpath = "//div[@id='other_loan_list']//strong")
	private WebElement otherloandetailsdeletetext;

	@FindBy(xpath = "//div[@id='vehicle_list']//strong")
	private WebElement vehicledetailsdeletetext;

	@FindBy(xpath = "//div[@id='insurance_list']//strong")
	private WebElement insurancedetailsdeletetext;

	@FindBy(xpath = "//span[contains(text(),'deleted')]")
	private WebElement coapplicantdeletenotification;

	@FindBy(xpath = "//div[@id='co_applicant_modal_onBoard_update']//button[text()='×']")
	private WebElement editcoapplicant_closebutton;

	@FindBy(xpath = "//div[@id='loanCommentsNonAdminDiv']//a[contains(text(),'Loan Comments')]")
	private WebElement loancommentaccordion;

	@FindBy(xpath = "//div[@id='Additional-info']//a")
	private WebElement downloadloancommentdocument;
	
	@FindBy(xpath ="//div[@class='attach']/following-sibling::text()[1]")
	
	//@FindBy(xpath ="//div[@class='conversation-body' and contains(text(), Testing)]")
	private WebElement  loancomment;
	
	
	public void clickDetails() {
		try {
			Generics.waitForElement(driver, detailstab);
			detailstab.click();
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

	public void validateLoanId(String actualloanid) {
		try {
			Generics.waitForElement(driver, loanidtext);
			String loanId = loanidtext.getText().replace("Loan Overview : ", "").replace(" (Initialized)", "")
					.replace("Loan Details Withdraw Loan Application", "").replaceAll("\\s+", "")
					.replaceAll("\\r\\n|\\r|\\n", " ").replaceAll("WithdrawLoanApplication", "")
					.replaceAll("ApplicationApproved", "").replaceAll("\\(", "").replaceAll("\\)", "")
					.replaceAll("Loan Overview:", "").replaceAll("LoanOverview:", "");
			System.out.println("loanId: " + loanId);
			assertEquals(actualloanid, loanId);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in validateLoanId", true);
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

	public void clickLoanRepaymentScheduleAccordion() {
		try {
			Generics.waitForElement(driver, loanrepaymentscheduleaccordionlink);
			loanrepaymentscheduleaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoanRepaymentTable() {
		try {
			Generics.waitForElement(driver, loanrepaymentscheduletable);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Loan Repayment table is not displayed", true);
		}
	}

	public void clickQuestionsAccordion() {
		try {
			Generics.waitForElement(driver, questionsaccordion);
			questionsaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateQuestions(String expectedquestiontext) {
		try {
			Generics.waitForElement(driver, questionstext);
			String questionText = questionstext.getText();
			assertEquals(questionText, expectedquestiontext);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickQuestionGroupAccordion() {
		try {
			Generics.waitForElement(driver, borrowerquestiongroupaccordion);
			borrowerquestiongroupaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateQuestionGroups(String borrowernationality, String downpayment) {
		try {
			Generics.waitForElement(driver, borrowernationalityanswer);
			Select borrowerNationalityOptions = new Select(borrowernationalityanswer);
			String borrowerNationality = borrowerNationalityOptions.getFirstSelectedOption().getText();
			assertEquals(borrowernationality, borrowerNationality);

			Generics.waitForElement(driver, downpaymentanswer);
			String downPayment = downpaymentanswer.getAttribute("value");
			assertEquals(downPayment, downpayment);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void updateQuesionGroup(String borrowernationality, String downpayment) {
		try {
			Generics.waitForElement(driver, borrowernationalityanswer);
			Select borrowerNationalityOptions = new Select(borrowernationalityanswer);
			borrowerNationalityOptions.selectByVisibleText(borrowernationality);

			Generics.waitForElement(driver, downpaymentanswer);
			downpaymentanswer.click();
			downpaymentanswer.clear();
			downpaymentanswer.sendKeys(downpayment);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBorrowerQuestionGroup1Submit() {
		try {
			Generics.waitForElement(driver, borrowerquestiongroup1submitbutton);
			borrowerquestiongroup1submitbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickaddReferenceDetails() {
		try {
			Generics.waitForElement(driver, referencedetails_addreferencebutton);
			referencedetails_addreferencebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addReferenceDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addreference_firstnametextbox);
				addreference_firstnametextbox.click();
				addreference_firstnametextbox.clear();
				addreference_firstnametextbox.sendKeys(product);

			case 1:
				Generics.waitForElement(driver, addreference_lastnametextbox);
				addreference_lastnametextbox.click();
				addreference_lastnametextbox.clear();
				addreference_lastnametextbox.sendKeys(product);

			case 2:
				Generics.waitForElement(driver, addreference_emailtextbox);
				addreference_emailtextbox.click();
				addreference_emailtextbox.clear();
				addreference_emailtextbox.sendKeys(product);

			case 3:
				Generics.waitForElement(driver, addreference_mobilenumbertextbox);
				addreference_mobilenumbertextbox.click();
				addreference_mobilenumbertextbox.clear();
				addreference_mobilenumbertextbox.sendKeys(product);

			case 4:
				Generics.waitForElement(driver, addreference_relationshipstatustextbox);
				addreference_relationshipstatustextbox.click();
				addreference_relationshipstatustextbox.clear();
				addreference_relationshipstatustextbox.sendKeys(product);

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddReferenceDone() {
		try {
			Generics.waitForElement(driver, addreference_donebutton);
			addreference_donebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditReferenceDetails() {
		try {
			Generics.waitForElement(driver, referencedetails_editbutton);
			referencedetails_editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editReferenceDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, updatereference_firstnametextbox);
				updatereference_firstnametextbox.click();
				updatereference_firstnametextbox.clear();
				updatereference_firstnametextbox.sendKeys(product);

			case 1:
				Generics.waitForElement(driver, updatereference_lastnametextbox);
				updatereference_lastnametextbox.click();
				updatereference_lastnametextbox.clear();
				updatereference_lastnametextbox.sendKeys(product);

			case 2:
				Generics.waitForElement(driver, updatereference_emailtextbox);
				updatereference_emailtextbox.click();
				updatereference_emailtextbox.clear();
				updatereference_emailtextbox.sendKeys(product);

			case 3:
				Generics.waitForElement(driver, updatereference_mobilenumbertextbox);
				updatereference_mobilenumbertextbox.click();
				updatereference_mobilenumbertextbox.clear();
				updatereference_mobilenumbertextbox.sendKeys(product);

			case 4:
				Generics.waitForElement(driver, updatereference_relationshipstatustextbox);
				updatereference_relationshipstatustextbox.click();
				updatereference_relationshipstatustextbox.clear();
				updatereference_relationshipstatustextbox.sendKeys(product);
			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditReferenceDetailsDone() {
		try {
			Generics.waitForElement(driver, updatereference_donebutton);
			updatereference_donebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickDeleteReferenceDetails() {
		try {
			Generics.waitForElement(driver, referencedetails_deletebutton);
			referencedetails_deletebutton.click();
			Generics.alertAction(driver, "Yes");
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

	public void validateReferenceDetails(int i, String referencedetails) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, referencedetailsname);
				assertEquals(referencedetailsname.getText(), referencedetails);
				break;

			case 1:
				Generics.waitForElement(driver, referencedetailsemail);
				assertEquals(referencedetailsemail.getText(), referencedetails);
				break;

			case 2:
				Generics.waitForElement(driver, referencedetailsmobilenumber);
				assertEquals(referencedetailsmobilenumber.getText(), referencedetails);
				break;

			case 3:
				Generics.waitForElement(driver, referencedetailsrelationshipstatus);
				assertEquals(referencedetailsrelationshipstatus.getText(), referencedetails);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddCoApplicant() {
		try {
			Generics.waitForElement(driver, coapplicantdetails_addcoapplicantbutton);
			coapplicantdetails_addcoapplicantbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addCoApplicant(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addcoapplicant_firstnametextbox);
				addcoapplicant_firstnametextbox.click();
				addcoapplicant_firstnametextbox.clear();
				addcoapplicant_firstnametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, addcoapplicant_lastnametextbox);
				addcoapplicant_lastnametextbox.click();
				addcoapplicant_lastnametextbox.clear();
				addcoapplicant_lastnametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, addcoapplicant_emailtextbox);
				addcoapplicant_emailtextbox.click();
				addcoapplicant_emailtextbox.clear();
				addcoapplicant_emailtextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, addcoapplicant_aadharcardnumbertextbox);
				addcoapplicant_aadharcardnumbertextbox.click();
				addcoapplicant_aadharcardnumbertextbox.clear();
				addcoapplicant_aadharcardnumbertextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, addcoapplicant_pancardnumbertextbox);
				addcoapplicant_pancardnumbertextbox.click();
				addcoapplicant_pancardnumbertextbox.clear();
				addcoapplicant_pancardnumbertextbox.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, addcoapplicant_identitynumberthreetextbox);
				addcoapplicant_identitynumberthreetextbox.click();
				addcoapplicant_identitynumberthreetextbox.clear();
				addcoapplicant_identitynumberthreetextbox.sendKeys(product);
				break;

			case 6:
				Generics.waitForElement(driver, addcoapplicant_identitynumberfourtextbox);
				addcoapplicant_identitynumberfourtextbox.click();
				addcoapplicant_identitynumberfourtextbox.clear();
				addcoapplicant_identitynumberfourtextbox.sendKeys(product);
				break;

			case 7:
				Generics.waitForElement(driver, addcoapplicant_identitynumberfivetextbox);
				addcoapplicant_identitynumberfivetextbox.click();
				addcoapplicant_identitynumberfivetextbox.clear();
				addcoapplicant_identitynumberfivetextbox.sendKeys(product);
				break;

			case 8:
				Generics.waitForElement(driver, addcoapplicant_identitynumbersixtextbox);
				addcoapplicant_identitynumbersixtextbox.click();
				addcoapplicant_identitynumbersixtextbox.clear();
				addcoapplicant_identitynumbersixtextbox.sendKeys(product);
				break;

			case 9:
				Generics.waitForElement(driver, addcoapplicant_companynametextbox);
				addcoapplicant_companynametextbox.click();
				addcoapplicant_companynametextbox.clear();
				addcoapplicant_companynametextbox.sendKeys(product);
				break;

			case 10:
				Generics.waitForElement(driver, addcoapplicant_coapplicantemploymenttextvariable1textbox);
				addcoapplicant_coapplicantemploymenttextvariable1textbox.click();
				addcoapplicant_coapplicantemploymenttextvariable1textbox.clear();
				addcoapplicant_coapplicantemploymenttextvariable1textbox.sendKeys(product);
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
			Generics.waitForElement(driver, addcoapplicant_donebutton);
			addcoapplicant_donebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCoApplicantDetailsEdit(int n) {
		try {
			Generics.waitForElement(driver, coapplicantdetails_editbutton.get(n));
			coapplicantdetails_editbutton.get(n).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editCoApplicantDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, updatecoapplicantdetails_firstnametextbox);
				updatecoapplicantdetails_firstnametextbox.click();
				updatecoapplicantdetails_firstnametextbox.clear();
				updatecoapplicantdetails_firstnametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, updatecoapplicantdetails_lastnametextbox);
				updatecoapplicantdetails_lastnametextbox.click();
				updatecoapplicantdetails_lastnametextbox.clear();
				updatecoapplicantdetails_lastnametextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, updatecoapplicantdetails_emailtextbox);
				updatecoapplicantdetails_emailtextbox.click();
				updatecoapplicantdetails_emailtextbox.clear();
				updatecoapplicantdetails_emailtextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, updatecoapplicantdetails_aadharcardnumbertextbox);
				updatecoapplicantdetails_aadharcardnumbertextbox.click();
				updatecoapplicantdetails_aadharcardnumbertextbox.clear();
				updatecoapplicantdetails_aadharcardnumbertextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, updatecoapplicantdetails_pancardnumbertextbox);
				updatecoapplicantdetails_pancardnumbertextbox.click();
				updatecoapplicantdetails_pancardnumbertextbox.clear();
				updatecoapplicantdetails_pancardnumbertextbox.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, updatecoapplicantdetails_identitynumberthreetextbox);
				updatecoapplicantdetails_identitynumberthreetextbox.click();
				updatecoapplicantdetails_identitynumberthreetextbox.clear();
				updatecoapplicantdetails_identitynumberthreetextbox.sendKeys(product);
				break;

			case 6:
				Generics.waitForElement(driver, updatecoapplicantdetails_identitynumberfourtextbox);
				updatecoapplicantdetails_identitynumberfourtextbox.click();
				updatecoapplicantdetails_identitynumberfourtextbox.clear();
				updatecoapplicantdetails_identitynumberfourtextbox.sendKeys(product);
				break;

			case 7:
				Generics.waitForElement(driver, updatecoapplicantdetails_identitynumberfivetextbox);
				updatecoapplicantdetails_identitynumberfivetextbox.click();
				updatecoapplicantdetails_identitynumberfivetextbox.clear();
				updatecoapplicantdetails_identitynumberfivetextbox.sendKeys(product);
				break;

			case 8:
				Generics.waitForElement(driver, updatecoapplicantdetails_identitynumbersixtextbox);
				updatecoapplicantdetails_identitynumbersixtextbox.click();
				updatecoapplicantdetails_identitynumbersixtextbox.clear();
				updatecoapplicantdetails_identitynumbersixtextbox.sendKeys(product);
				break;

			case 9:
				Generics.waitForElement(driver, updatecoapplicantdetails_companynametextbox);
				updatecoapplicantdetails_companynametextbox.click();
				updatecoapplicantdetails_companynametextbox.clear();
				updatecoapplicantdetails_companynametextbox.sendKeys(product);
				break;

			case 10:
				Generics.waitForElement(driver, updatecoapplicantdetails_coapplicantemploymenttextvariable1textbox);
				updatecoapplicantdetails_coapplicantemploymenttextvariable1textbox.click();
				updatecoapplicantdetails_coapplicantemploymenttextvariable1textbox.clear();
				updatecoapplicantdetails_coapplicantemploymenttextvariable1textbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditCoApplicantDone() {
		try {
			Generics.waitForElement(driver, updatecoapplicantdetails_donebutton);
			updatecoapplicantdetails_donebutton.click();
			Generics.waitForElement(driver, coapplicantdetailsupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCoApplicantDetailsDelete(int i) {
		try {
			Generics.waitForElement(driver, coapplicantdetails_deletebutton.get(i));
			coapplicantdetails_deletebutton.get(i).click();
			Generics.alertAction(driver, "Yes");
			Generics.waitForElementToInvisible(driver, coapplicantdeletenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddOtherLoanDetails() {
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
			Generics.waitForElement(driver, addotherloandetails_editbutton);
			addotherloandetails_editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editOtherLoanDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, updateotherloandetails_loanpurposetextbox);
				updateotherloandetails_loanpurposetextbox.click();
				updateotherloandetails_loanpurposetextbox.clear();
				updateotherloandetails_loanpurposetextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, updateotherloandetails_loanamounttextbox);
				updateotherloandetails_loanamounttextbox.click();
				updateotherloandetails_loanamounttextbox.clear();
				updateotherloandetails_loanamounttextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, updateotherloandetails_repaymentamounttextbox);
				updateotherloandetails_repaymentamounttextbox.click();
				updateotherloandetails_repaymentamounttextbox.clear();
				updateotherloandetails_repaymentamounttextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, updateotherloandetails_banknametextbox);
				updateotherloandetails_banknametextbox.click();
				updateotherloandetails_banknametextbox.clear();
				updateotherloandetails_banknametextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, updateotherloandetails_loanextratextvariable1textbox);
				updateotherloandetails_loanextratextvariable1textbox.click();
				updateotherloandetails_loanextratextvariable1textbox.clear();
				updateotherloandetails_loanextratextvariable1textbox.sendKeys(product);
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
			Generics.waitForElement(driver, updateotherloandetails_donebutton);
			updateotherloandetails_donebutton.click();
			Generics.waitForElementToInvisible(driver, updateotherloandetailsnotifications);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOtherLoanDetailsDelete() {
		try {
			Generics.waitForElement(driver, addotherloandetails_deletebutton);
			addotherloandetails_deletebutton.click();
			Generics.alertAction(driver, "Yes");
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

	public void validateOtherLoanDetails(int i, String otherloandetails) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, otherloandetailsloanpurpose);
				assertEquals(otherloandetailsloanpurpose.getText(), otherloandetails);
				break;

			case 1:
				Generics.waitForElement(driver, otherloandetailsloanamount);
				assertEquals(otherloandetailsloanamount.getText(), otherloandetails);
				break;

			case 2:
				Generics.waitForElement(driver, otherloandetailsrepaymentamount);
				assertEquals(otherloandetailsrepaymentamount.getText(), otherloandetails);
				break;

			case 3:
				Generics.waitForElement(driver, otherloandetailsbankname);
				assertEquals(otherloandetailsbankname.getText(), otherloandetails);
				break;

			case 4:
				Generics.waitForElement(driver, otherloandetailsloanextratextvariable1);
				assertEquals(otherloandetailsloanextratextvariable1.getText(), otherloandetails);
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
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickVehicleDetailsEdit() {
		try {
			Generics.waitForElement(driver, vehicledetails_editbutton);
			vehicledetails_editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editVehicleDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, updatevehicledetails_brandnametextbox);
				updatevehicledetails_brandnametextbox.click();
				updatevehicledetails_brandnametextbox.clear();
				updatevehicledetails_brandnametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, updatevehicledetails_licensenumbertextbox);
				updatevehicledetails_licensenumbertextbox.click();
				updatevehicledetails_licensenumbertextbox.clear();
				updatevehicledetails_licensenumbertextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, updatevehicledetails_vehicleownedextratextvariable1textbox);
				updatevehicledetails_vehicleownedextratextvariable1textbox.click();
				updatevehicledetails_vehicleownedextratextvariable1textbox.clear();
				updatevehicledetails_vehicleownedextratextvariable1textbox.sendKeys(product);
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
			Generics.waitForElement(driver, updatevehicledetails_donebutton);
			updatevehicledetails_donebutton.click();
			Generics.waitForElement(driver, updatevehicledetailsnotification);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickVehicleDetailsDelete() {
		try {
			Generics.waitForElement(driver, vehicledetails_deletebutton);
			vehicledetails_deletebutton.click();
			Generics.alertAction(driver, "Yes");
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

	public void validateVehicleDetails(int i, String vehicledetails) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, vehicledetailsbrandname);
				assertEquals(vehicledetailsbrandname.getText(), vehicledetails);
				break;

			case 1:
				Generics.waitForElement(driver, vehicledetailslicensenumber);
				assertEquals(vehicledetailslicensenumber.getText(), vehicledetails);
				break;

			case 2:
				Generics.waitForElement(driver, vehicleownedextratextvariable1);
				assertEquals(vehicleownedextratextvariable1.getText(), vehicledetails);
				break;

			case 3:
				Generics.waitForElement(driver, vehicleownedextradatevariable1);
				assertEquals(vehicleownedextradatevariable1.getText(), vehicledetails);
				break;

			default:
				Reporter.log("No value found", true);

			}
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
				Generics.waitForElement(driver, addinsurancedetails_insurernametextbox);
				addinsurancedetails_insurernametextbox.click();
				addinsurancedetails_insurernametextbox.clear();
				addinsurancedetails_insurernametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, addinsurancedetails_amounttextbox);
				addinsurancedetails_amounttextbox.click();
				addinsurancedetails_amounttextbox.clear();
				addinsurancedetails_amounttextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, addinsurancedetails_typeofinsurancedropdown);
				Select insuranceTypeOprions = new Select(addinsurancedetails_typeofinsurancedropdown);
				insuranceTypeOprions.selectByVisibleText(product);
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
				Generics.waitForElement(driver, updateinsurancedetails_insurernametextbox);
				updateinsurancedetails_insurernametextbox.click();
				updateinsurancedetails_insurernametextbox.clear();
				updateinsurancedetails_insurernametextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, updateinsurancedetails_amounttextbox);
				updateinsurancedetails_amounttextbox.click();
				updateinsurancedetails_amounttextbox.clear();
				updateinsurancedetails_amounttextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, updateinsurancedetails_typeofinsurancedropdown);
				Select typeOfInsuranceOptions = new Select(updateinsurancedetails_typeofinsurancedropdown);
				typeOfInsuranceOptions.selectByVisibleText(product);
				break;

			case 3:
				Generics.waitForElement(driver, updateinsurancedetails_insurancetextvariable1textbox);
				updateinsurancedetails_insurancetextvariable1textbox.click();
				updateinsurancedetails_insurancetextvariable1textbox.clear();
				updateinsurancedetails_insurancetextvariable1textbox.sendKeys(product);
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
			Generics.waitForElement(driver, updateinsurancedetails_donebutton);
			updateinsurancedetails_donebutton.click();
			Generics.waitForElement(driver, updateinsurancenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickInsuranceDetailsDelete() {
		try {
			Generics.waitForElement(driver, insurancedetails_deletebutton);
			insurancedetails_deletebutton.click();
			Generics.alertAction(driver, "Yes");
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
		return Generics.getElementCount(insurancedetailsinsurername);
	}

	public void clickInsuranceDetailsAccordion() {
		try {
			Generics.waitForElement(driver, insurancedetailsaccordionlink);
			insurancedetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateInsuranceDetails(int j, int i, String insurancedetails) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, insurancedetailsinsurername.get(j));
				assertEquals(insurancedetailsinsurername.get(j).getText(), insurancedetails);
				break;

			case 1:
				Generics.waitForElement(driver, insurancedetailsamount.get(j));
				assertEquals(insurancedetailsamount.get(j).getText(), insurancedetails);
				break;

			case 2:
				Generics.waitForElement(driver, insurancedetailstypeofinsurance.get(j));
				assertEquals(insurancedetailstypeofinsurance.get(j).getText(), insurancedetails);
				break;

			case 3:
				Generics.waitForElement(driver, insurancetextvariable1.get(j));
				assertEquals(insurancetextvariable1.get(j).getText(), insurancedetails);
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
			Generics.waitForElement(driver, contractsaccordionlink);
			contractsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateIfNoContractDetailsDisplayed(String expectedcontracttext) {
		try {
			Generics.waitForElement(driver, contractstext);
			String questionText = contractstext.getText();
			assertEquals(questionText, expectedcontracttext);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateRepaymentSchedule(int i, String serialnumber, String payableamount, String penalties,
			String markpaid, String totalintrestamount, String interest, String repaymentamount, String principal,
			String loantenure, String repaymentdate, String status) {
		try {
			Generics.waitForElement(driver, loanrepaymentschedule_serialnumbertext.get(i));
			assertEquals(loanrepaymentschedule_serialnumbertext.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, loanrepaymentschedule_payableamounttext.get(i));
			assertEquals(loanrepaymentschedule_payableamounttext.get(i).getText(), payableamount);

			Generics.waitForElement(driver, loanrepaymentschedule_penaltiestext.get(i));
			assertEquals(loanrepaymentschedule_penaltiestext.get(i).getText(), penalties);

			Generics.waitForElement(driver, loanrepaymentschedule_markpaidtext.get(i));
			assertEquals(loanrepaymentschedule_markpaidtext.get(i).getText(), markpaid);

			Generics.waitForElement(driver, loanrepaymentschedule_totalinterestamounttext.get(i));
			assertEquals(loanrepaymentschedule_totalinterestamounttext.get(i).getText(), totalintrestamount);

			Generics.waitForElement(driver, loanrepaymentschedule_interesttext.get(i));
			assertEquals(loanrepaymentschedule_interesttext.get(i).getText(), interest);

			Generics.waitForElement(driver, loanrepaymentschedule_repaymentamounttext.get(i));
			assertEquals(loanrepaymentschedule_repaymentamounttext.get(i).getText(), repaymentamount);

			Generics.waitForElement(driver, loanrepaymentschedule_principaltext.get(i));
			assertEquals(loanrepaymentschedule_principaltext.get(i).getText(), principal);

			Generics.waitForElement(driver, loanrepaymentschedule_loantenuretext.get(i));
			assertEquals(loanrepaymentschedule_loantenuretext.get(i).getText(), loantenure);

			Generics.waitForElement(driver, loanrepaymentschedule_repaymentdatetext.get(i));
//			assertEquals(loanrepaymentschedule_repaymentdatetext.get(i).getText(), repaymentdate);

			Generics.waitForElement(driver, loanrepaymentschedule_statustext.get(i));
			assertEquals(loanrepaymentschedule_statustext.get(i).getText(), status);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCoApplicantDetailsInPopUp(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, updatecoapplicantdetails_firstnametextbox);
				assertEquals(updatecoapplicantdetails_firstnametextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, updatecoapplicantdetails_lastnametextbox);
				assertEquals(updatecoapplicantdetails_lastnametextbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, updatecoapplicantdetails_emailtextbox);
				assertEquals(updatecoapplicantdetails_emailtextbox.getAttribute("value"), product);
				break;

			case 3:
				Generics.waitForElement(driver, updatecoapplicantdetails_companynametextbox);
				assertEquals(updatecoapplicantdetails_companynametextbox.getAttribute("value"), product);
				break;

			case 4:
				Generics.waitForElement(driver, updatecoapplicantdetails_coapplicantemploymenttextvariable1textbox);
				assertEquals(updatecoapplicantdetails_coapplicantemploymenttextvariable1textbox.getAttribute("value"),
						product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getNumberOfCoApplicants() {
		return Generics.getElementCount(coapplicantdetailsname);
	}

	public void validateIfNoCoApplicantDetailsDisplayed(String product) {
		try {
			Generics.waitForElement(driver, coapplicantdetailsdeletetext);
			assertEquals(coapplicantdetailsdeletetext.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCoApplicantDetailsAccordion() {
		try {
			Generics.waitForElement(driver, coapplicantaccordionlink);
			coapplicantaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCoApplicantDetails(int n, int i, String coapplicantdetails) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, coapplicantdetailsname.get(n));
				assertEquals(coapplicantdetailsname.get(n).getText(), coapplicantdetails);
				break;

			case 1:
				Generics.waitForElement(driver, coapplicantdetailsemail.get(n));
				assertEquals(coapplicantdetailsemail.get(n).getText(), coapplicantdetails);
				break;

			case 2:
				Generics.waitForElement(driver, coapplicantdetailscompanyname.get(n));
				assertEquals(coapplicantdetailscompanyname.get(n).getText(), coapplicantdetails);
				break;

			case 3:
				Generics.waitForElement(driver, coapplicantemploymenttextvariable1.get(n));
				assertEquals(coapplicantemploymenttextvariable1.get(n).getText(), coapplicantdetails);
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

	public void clickLoanCommentsAccordion() {
		try {
			Generics.waitForElement(driver, loancommentaccordion);
			loancommentaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickDownloadLoanCommentDocument() {
		try {
			Generics.waitForElement(driver, downloadloancommentdocument);
			downloadloancommentdocument.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoanCommentDocument(String expfilename) {
		try {
			Generics.waitForElement(driver, downloadloancommentdocument);
			assertEquals(downloadloancommentdocument.getText(), expfilename);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void validateLoanComment(String expcomment) {
		try {
			Generics.waitForElement(driver, loancomment);
			assertEquals(loancomment, expcomment);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean validateDownloadedDocument(String expfilename) {
		File[] files = new File(upload_contractfile_path).listFiles();
		for (File file : files) {
			if (file.getName().contains(expfilename)) {
				return true;
			}
		}
		return false;
	}

}