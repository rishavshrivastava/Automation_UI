package com.automationsaas.pom.investor;

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

	@FindBy(xpath = "//div[text()='Remaining Amount For Funding']/following-sibling::div")
	private WebElement remainingamountforfundingtext;

	@FindBy(xpath = "//input[@value='Fund this Loan Application']")
	private WebElement fundthisloanapplicationbutton;

	@FindBy(id = "bidAmount")
	private WebElement bidamounttextbox;

	@FindBy(id = "submitBidModal")
	private WebElement bidbutton;

	@FindBy(xpath = "//img[src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement bidprocessspinner;

	@FindBy(xpath = "//span[text()='Bid Has been initialized you will be notified once it is placed']")
	private WebElement bidsuccessnotification;

	@FindBy(id = "progressBarDiv")
	private WebElement bidprogressbar;
	
	@FindBy(xpath="(//a[contains(text(),'Loan Detail')])[1]")
	private WebElement loandetailaccordionlink;

	@FindBy(xpath = "//div[text()='Borrower Profile Text Variable 1']/following-sibling::h4")
	private WebElement borrowerprofiletextvariable1text;

	@FindBy(xpath = "//div[text()='Spouse Name']/following-sibling::h4")
	private WebElement spoucenametext;

	@FindBy(xpath = "//div[text()='Age']/following-sibling::h4")
	private WebElement agetext;

	@FindBy(xpath = "//div[text()='Last Name']/following-sibling::h4")
	private WebElement lastnametext;

	@FindBy(xpath = "//div[text()='Email Address']/following-sibling::h4")
	private WebElement emailaddresstext;

	@FindBy(xpath = "//div[text()='Martial Status']/following-sibling::h4")
	private WebElement martialstatustext;

	@FindBy(xpath = "//div[text()='Title']/following-sibling::h4")
	private WebElement titletext;

	@FindBy(xpath = "//div[text()='First Name']/following-sibling::h4")
	private WebElement firstnametext;

	@FindBy(xpath = "//div[text()='Gender']/following-sibling::h4")
	private WebElement gendertext;

	@FindBy(xpath = "//div[text()='Date of Birth']/following-sibling::h4")
	private WebElement dateofbirthtext;

	@FindBy(xpath = "//div[text()='Loan Application Text Variable 1']/following-sibling::h4")
	private WebElement loanapplicationtextvariable1text;

	@FindBy(xpath = "//div[text()='Interest Rate']/following-sibling::h4")
	private WebElement interestratetext;

	@FindBy(xpath = "//div[text()='Loan Tenure']/following-sibling::h4")
	private WebElement loantenuretext;

	@FindBy(xpath = "//div[text()='Loan Purpose']/following-sibling::h4")
	private WebElement loanpurposetext;

	@FindBy(xpath = "//div[text()='Loan Amount']/following-sibling::h4")
	private WebElement loanamounttext;

	@FindBy(xpath = "//div[text()='Loan Application Date Variable 1']/following-sibling::h4")
	private WebElement loanapplicationdatevariable1text;

	@FindBy(xpath = "//div[text()='Gross Income']/following-sibling::h4")
	private WebElement grossincometext;

	@FindBy(xpath = "//div[text()='Job Type']/following-sibling::h4")
	private WebElement jobtypetext;

	@FindBy(xpath = "//div[text()='Work Experience']/following-sibling::h4")
	private WebElement workexperiencetext;

	@FindBy(xpath = "//div[text()='Organization Name']/following-sibling::h4")
	private WebElement organizationnametext;

	@FindBy(xpath = "//div[text()='Department']/following-sibling::h4")
	private WebElement departmenttext;

	@FindBy(xpath = "//div[text()='Employment Designation']/following-sibling::h4")
	private WebElement employmentdesignationtext;

	@FindBy(xpath = "//div[text()='Address']/following-sibling::h4")
	private WebElement addresstext;

	@FindBy(xpath = "//div[text()='Employee ID']/following-sibling::h4")
	private WebElement employidtext;
	
	@FindBy(xpath="//a[contains(text(),'All Bids')]")
	private WebElement allbidsaccordionlink;

	@FindBy(id = "bid_table")
	private WebElement nobidtextinallbids;
	
	@FindBy(xpath="//a[contains(text(),'Borrower Question Group 1')]")
	private WebElement borrowerquestiongroupaccordionlink;

	@FindBy(xpath = "//label[text()='Borrower Nationality']/following-sibling::select")
	private WebElement borrowerquestiongroup1_borrowernationality;

	@FindBy(xpath = "//label[text()='Down Payment']/following-sibling::input")
	private WebElement borrowerquestiongroup1_downpayment;
	
	@FindBy(xpath="//a[contains(text(),'Other Loan Details')]")
	private WebElement otherloandetailsaccordionlink;

	@FindBy(xpath = "//th[.='LoanPurpose']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='LoanPurpose']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_loanpurposetext;

	@FindBy(xpath = "//th[.='Loan Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Amount']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_loanamounttext;

	@FindBy(xpath = "//th[.='Repayment Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Repayment Amount']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_repaymentamounttext;

	@FindBy(xpath = "//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_banknametext;

	@FindBy(xpath = "//th[.='Loan extra text variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan extra text variable1']/preceding-sibling::th)+1]")
	private WebElement otherloandetails_loanextratextvariable1text;
	
	@FindBy(xpath="//a[contains(text(),'Insurance Details')]")
	private WebElement insurancedetailsaccordionlink;

	@FindBy(xpath = "//th[.='Insurer Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurer Name']/preceding-sibling::th)+1]")
	private WebElement insurancedetails_insurernametext;

	@FindBy(xpath = "//div[@id='insurance_list']//th[.='Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount']/preceding-sibling::th)+1]")
	private WebElement insurancedetails_amounttext;

	@FindBy(xpath = "//th[.='Type of Insurance']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type of Insurance']/preceding-sibling::th)+1]")
	private WebElement insurancedetails_typeofinsurancetext;

	@FindBy(xpath = "//th[.='Insurance Text Variable 1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Insurance Text Variable 1']/preceding-sibling::th)+1]")
	private WebElement insurancedetails_insurancetextvariable1text;
	
	@FindBy(xpath="//a[contains(text(),'Vehicle Details')]")
	private WebElement vehicledetailsaccordionlink;

	@FindBy(xpath = "//th[.='Brand Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Brand Name']/preceding-sibling::th)+1]")
	private WebElement vehicledetails_brandnametext;

	@FindBy(xpath = "//th[.='License Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='License Number']/preceding-sibling::th)+1]")
	private WebElement vehicledetails_licensenumbertext;

	@FindBy(xpath = "//th[.='Vehicle Owned extra text variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Vehicle Owned extra text variable1']/preceding-sibling::th)+1]")
	private WebElement vehicledetails_vehicleownedextratextvariable1text;
	
	@FindBy(xpath="//a[contains(text(),'Co-Applicant Details')]")
	private WebElement coapplicantdetailsaccordionlink;

	@FindBy(xpath = "//div[@id='co_applicant_list_onBoard']//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)+1]")
	private WebElement coapplicantdetails_nametext;

	@FindBy(xpath = "//div[@id='co_applicant_list_onBoard']//th[.='co.applicant.email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='co.applicant.email']/preceding-sibling::th)+1]")
	private WebElement coapplicantdetails_emailtext;

	@FindBy(xpath = "//div[@id='co_applicant_list_onBoard']//th[.='Company Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Company Name']/preceding-sibling::th)+1]")
	private WebElement coapplicantdetails_companyname;
	
	@FindBy(xpath="//a[contains(text(),'Reference Details')]")
	private WebElement referencedetailsaccordionlink;

	@FindBy(xpath = "//div[@id='reference_detail_list']//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)]")
	private WebElement referencedetails_nametext;

	@FindBy(xpath = "//div[@id='reference_detail_list']//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)-3]")
	private WebElement referencedetails_emailtext;

	@FindBy(xpath = "//div[@id='reference_detail_list']//th[.='Mobile Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Mobile Number']/preceding-sibling::th)+1]")
	private WebElement referencedetails_mobilenumbertext;

	@FindBy(xpath = "//div[@id='reference_detail_list']//th[.='Relationship Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Relationship Status']/preceding-sibling::th)+1]")
	private WebElement referencedetails_relationshipstatustext;
	
	@FindBy(xpath="//a[contains(text(),'Loan Repayment Schedule')]")
	private WebElement loanrepaymentscheduleaccordionlink;

	@FindBy(xpath = "//div[@id='loadLoanRepayment']//th[.='Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Status']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_statustext;

	@FindBy(xpath = "//div[@id='loadLoanRepayment']//th[.='S.No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='S.No']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_serialnumbertext;

	@FindBy(xpath = "//div[@id='loadLoanRepayment']//th[.='Repayment Date']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Repayment Date']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_repaymentdatetext;

	@FindBy(xpath = "//div[@id='loadLoanRepayment']//th[.='Penalties']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Penalties']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_penaltiestext;

	@FindBy(xpath = "//div[@id='loadLoanRepayment']//th[.='Service Fees From Investor']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Service Fees From Investor']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_servicefeesfrominvestortext;

	@FindBy(xpath = "//div[@id='loadLoanRepayment']//th[.='Total Interest Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Total Interest Amount']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_totalinterestamounttext;

	@FindBy(xpath = "//div[@id='loadLoanRepayment']//th[.='Principal']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Principal']/preceding-sibling::th)+1]")
	private List<WebElement> loanrepaymentschedule_principaltext;

	public String validateRemainingAmountForFunding(String amount) {
		String remainingAmount = null;
		try {
			Generics.waitForElement(driver, remainingamountforfundingtext);
			if (remainingamountforfundingtext.getText().replace("Rs", "").replace(",", "").equalsIgnoreCase(amount)) {
				Reporter.log("Amount is equals loan amount", true);
				remainingAmount = remainingamountforfundingtext.getText().replace("Rs", "").replace(",", "");
			} else {
				remainingAmount = remainingamountforfundingtext.getText().replace("Rs", "").replace(",", "");
				Reporter.log("Amount is not equals to loan amount", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return remainingAmount;
	}

	public void clickFundThisLoanApplication() {
		try {
			Generics.waitForElement(driver, fundthisloanapplicationbutton);
			fundthisloanapplicationbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterBidAmount(String bidamount) {
		try {
			Generics.waitForElement(driver, bidamounttextbox);
			bidamounttextbox.click();
			bidamounttextbox.clear();
			bidamounttextbox.sendKeys(bidamount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBid() {
		try {
			Generics.waitForElement(driver, bidbutton);
			bidbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForBidToBeProcessed() {
		try {
			Generics.waitForElement(driver, bidsuccessnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForProgressBarToShowProgress(String bidprogress) {
		try {
			Generics.waitForElement(driver, bidprogressbar);
			while (!bidprogressbar.getText().equalsIgnoreCase(bidprogress)) {
				driver.navigate().refresh();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoanDetailsAccordion() {
		try {
			Generics.waitForElement(driver, loandetailaccordionlink);
			loandetailaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoanDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, borrowerprofiletextvariable1text);
				assertEquals(borrowerprofiletextvariable1text.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, spoucenametext);
				assertEquals(spoucenametext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, agetext);
				assertEquals(agetext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, lastnametext);
				assertEquals(lastnametext.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, emailaddresstext);
				assertEquals(emailaddresstext.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, martialstatustext);
				assertEquals(martialstatustext.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, titletext);
				assertEquals(titletext.getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, firstnametext);
				assertEquals(firstnametext.getText(), product);
				break;

			case 8:
				Generics.waitForElement(driver, gendertext);
				assertEquals(gendertext.getText(), product);
				break;

			case 9:
				Generics.waitForElement(driver, dateofbirthtext);
				assertEquals(dateofbirthtext.getText(), product);
				break;

			case 10:
				Generics.waitForElement(driver, loanapplicationtextvariable1text);
				assertEquals(loanapplicationtextvariable1text.getText(), product);
				break;

			case 11:
				Generics.waitForElement(driver, interestratetext);
				assertEquals(interestratetext.getText(), product);
				break;

			case 12:
				Generics.waitForElement(driver, loantenuretext);
				assertEquals(loantenuretext.getText(), product);
				break;

			case 13:
				Generics.waitForElement(driver, loanpurposetext);
				assertEquals(loanpurposetext.getText(), product);
				break;

			case 14:
				Generics.waitForElement(driver, loanamounttext);
				assertEquals(loanamounttext.getText(), product);
				break;

			case 15:
				Generics.waitForElement(driver, loanapplicationdatevariable1text);
				assertEquals(loanapplicationdatevariable1text.getText(), product);
				break;

			case 16:
				Generics.waitForElement(driver, grossincometext);
				assertEquals(grossincometext.getText(), product);
				break;

			case 17:
				Generics.waitForElement(driver, jobtypetext);
				assertEquals(jobtypetext.getText(), product);
				break;

			case 18:
				Generics.waitForElement(driver, workexperiencetext);
				assertEquals(workexperiencetext.getText(), product);
				break;

			case 19:
				Generics.waitForElement(driver, organizationnametext);
				assertEquals(organizationnametext.getText(), product);
				break;

			case 20:
				Generics.waitForElement(driver, departmenttext);
				assertEquals(departmenttext.getText(), product);
				break;

			case 21:
				Generics.waitForElement(driver, employmentdesignationtext);
				assertEquals(employmentdesignationtext.getText(), product);
				break;

			case 22:
				Generics.waitForElement(driver, addresstext);
				assertEquals(addresstext.getText(), product);
				break;

			case 23:
				Generics.waitForElement(driver, employidtext);
				assertEquals(employidtext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAllBidsAccordion() {
		try {
			Generics.waitForElement(driver, allbidsaccordionlink);
			allbidsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateAllBids(String product) {
		try {
			Generics.waitForElement(driver, nobidtextinallbids);
			assertEquals(nobidtextinallbids.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickQuestionGroup1Accordion() {
		try {
			Generics.waitForElement(driver, borrowerquestiongroupaccordionlink);
			borrowerquestiongroupaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateQuestionGroup1(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, borrowerquestiongroup1_borrowernationality);
				Select options = new Select(borrowerquestiongroup1_borrowernationality);
				assertEquals(options.getFirstSelectedOption().getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, borrowerquestiongroup1_downpayment);
				assertEquals(borrowerquestiongroup1_downpayment.getAttribute("value"), product);
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

	public void validateOtherLoanDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, otherloandetails_loanpurposetext);
				assertEquals(otherloandetails_loanpurposetext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, otherloandetails_loanamounttext);
				assertEquals(otherloandetails_loanamounttext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, otherloandetails_repaymentamounttext);
				assertEquals(otherloandetails_repaymentamounttext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, otherloandetails_banknametext);
				assertEquals(otherloandetails_banknametext.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, otherloandetails_loanextratextvariable1text);
				assertEquals(otherloandetails_loanextratextvariable1text.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickInsuranceDetailsAccordion() {
		try {
			Generics.waitForElement(driver, insurancedetailsaccordionlink);
			insurancedetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateInsuranceDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, insurancedetails_insurernametext);
				assertEquals(insurancedetails_insurernametext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, insurancedetails_amounttext);
				assertEquals(insurancedetails_amounttext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, insurancedetails_typeofinsurancetext);
				assertEquals(insurancedetails_typeofinsurancetext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, insurancedetails_insurancetextvariable1text);
				assertEquals(insurancedetails_insurancetextvariable1text.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
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
				Generics.waitForElement(driver, vehicledetails_brandnametext);
				assertEquals(vehicledetails_brandnametext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, vehicledetails_licensenumbertext);
				assertEquals(vehicledetails_licensenumbertext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, vehicledetails_vehicleownedextratextvariable1text);
				assertEquals(vehicledetails_vehicleownedextratextvariable1text.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCoapplicantDetailsAccordion() {
		try {
			Generics.waitForElement(driver, coapplicantdetailsaccordionlink);
			coapplicantdetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCoApplicantDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, coapplicantdetails_nametext);
				assertEquals(coapplicantdetails_nametext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, coapplicantdetails_emailtext);
				assertEquals(coapplicantdetails_emailtext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, coapplicantdetails_companyname);
				assertEquals(coapplicantdetails_companyname.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
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

	public void validateReferenceDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, referencedetails_nametext);
				assertEquals(referencedetails_nametext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, referencedetails_emailtext);
				assertEquals(referencedetails_emailtext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, referencedetails_mobilenumbertext);
				assertEquals(referencedetails_mobilenumbertext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, referencedetails_relationshipstatustext);
				assertEquals(referencedetails_relationshipstatustext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validatePDCManagement() {

	}
	
	public void clickLoanRepaymentScheduleAccordion() {
		try {
			Generics.waitForElement(driver, loanrepaymentscheduleaccordionlink);
			loanrepaymentscheduleaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateLoanRepaymentSchedule(int i, String status, String serialnumber, String repaymentdate,
			String penalties, String servicefees, String totalinterestamount, String principal) {
		try {
			Generics.waitForElement(driver, loanrepaymentschedule_statustext.get(i));
			assertEquals(loanrepaymentschedule_statustext.get(i).getText(), status);

			Generics.waitForElement(driver, loanrepaymentschedule_serialnumbertext.get(i));
			assertEquals(loanrepaymentschedule_serialnumbertext.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, loanrepaymentschedule_repaymentdatetext.get(i));
//			assertEquals(loanrepaymentschedule_repaymentdatetext.get(i).getText(), repaymentdate);

			Generics.waitForElement(driver, loanrepaymentschedule_penaltiestext.get(i));
			assertEquals(loanrepaymentschedule_penaltiestext.get(i).getText(), penalties);

			Generics.waitForElement(driver, loanrepaymentschedule_servicefeesfrominvestortext.get(i));
			assertEquals(loanrepaymentschedule_servicefeesfrominvestortext.get(i).getText(), servicefees);

			Generics.waitForElement(driver, loanrepaymentschedule_totalinterestamounttext.get(i));
			assertEquals(loanrepaymentschedule_totalinterestamounttext.get(i).getText(), totalinterestamount);
			
			Generics.waitForElement(driver, loanrepaymentschedule_principaltext.get(i));
			assertEquals(loanrepaymentschedule_principaltext.get(i).getText(), principal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
