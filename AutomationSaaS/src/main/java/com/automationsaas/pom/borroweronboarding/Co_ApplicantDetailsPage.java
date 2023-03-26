package com.automationsaas.pom.borroweronboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class Co_ApplicantDetailsPage {

	public WebDriver driver;

	public Co_ApplicantDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement co_applicantdetailsheading;
	
	@FindBy(xpath="//div[@id='ajaxFormCoApplicantDivId']//input[@id='firstName']")
	private WebElement firstnametextbox;
	
	@FindBy(xpath="//div[@id='ajaxFormCoApplicantDivId']//input[@id='lastName']")
	private WebElement lastnametextbox;
	
	@FindBy(xpath="//div[@id='ajaxFormCoApplicantDivId']//input[@id='emailId']")
	private WebElement emailidtextbox;
	
	@FindBy(id="identityNumberOne")
	private WebElement aadharcardnumbertextbox;
	
	@FindBy(id="identityNumberTwo")
	private WebElement pancardnumbertextbox;
	
	@FindBy(id="identityNumberThree")
	private WebElement identitynumberthreetextbox;
	
	@FindBy(id="identityNumberFour")
	private WebElement identitynumberfourtextbox;
	
	@FindBy(id="identityNumberFive")
	private WebElement identitynumberfivetextbox;
	
	@FindBy(id="identityNumberSix")
	private WebElement identitynumbersixtextbox;
	
	@FindBy(xpath="//div[@id='ajaxFormCoApplicantDivId']//input[@id='companyName']")
	private WebElement companynametextbox;
	
	@FindBy(xpath="//input[contains(@id,'department')]")
	private WebElement departmenttextbox;
	
	@FindBy(xpath="//input[contains(@id,'designation')]")
	private WebElement designationtextbox;
	
	@FindBy(xpath="//input[contains(@id,'companyEmail')]")
	private WebElement emailtextbox;
	
	@FindBy(xpath="//input[contains(@id,'companyMobileNumber')]")
	private WebElement companymobilenumbertextbox;
	
	@FindBy(xpath="//div[@id='ajaxFormCoApplicantDivId']//input[@id='coApplicantEmploymentTextVariable1']")
	private WebElement co_applicantemploymenttextvariableonetextbox;
	
	@FindBy(xpath="//input[contains(@id,'coApplicantEmploymentTextVariable2')]")
	private WebElement co_applicantemploymenttextvariabletwotextbox;
	
	@FindBy(xpath="//input[contains(@id,'coApplicantEmploymentTextVariable3')]")
	private WebElement co_applicantemploymenttextvariablethreetextbox;
	
	@FindBy(xpath="//input[contains(@id,'coApplicantEmploymentDateVariable1')]")
	private WebElement co_applicantemploymentdatevariable1textbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks;
	
	@FindBy(id="companyAddressLine1")
	private WebElement addressline1textbox;
	
	@FindBy(id="companyAddressLine2")
	private WebElement addressline2textbox;
	
	@FindBy(id="companyAddressLine3")
	private WebElement addressline3textbox;
	
	@FindBy(id="companyAddressSubDistrict")
	private WebElement addresssubdistricttextbox;
	
	@FindBy(id="companyAddressDistrict")
	private WebElement addressdistricttextbox;
	
	@FindBy(id="companyAddressState")
	private WebElement addressstatedropdown;
	
	@FindBy(id="companyAddressCity")
	private WebElement citytextbox;
	
	@FindBy(id="companyAddressCountry")
	private WebElement countrytextbox;
	
	@FindBy(id="companyAddressZipCode")
	private WebElement zipcodetextbox;
	
	@FindBy(id="companyAddressLivingSince")
	private WebElement livingsincetextbox;
	
	@FindBy(id="companyAddressOwnershipType")
	private WebElement ownershiptypedropdown;
	
	@FindBy(id="companyAddressTypeOfAddress")
	private WebElement addresstypedropdown;
	
	@FindBy(id="createCoApplicantAjaxBtn")
	private WebElement addmorebutton;
	
	@FindBy(xpath="//div[@id='waitingSpinnerCoapplicantDetail']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement addmorespinner;
	
	@FindBy(id="edit_co_applicant_opener")
	private WebElement editbutton;
	
	@FindBy(id="submit_co_applicant")
	private WebElement submitcoapplicantbuttonunderedit;
	
	@FindBy(xpath="//button[@id='edit_co_applicant_opener']/following-sibling::button")
	private WebElement deletebutton;
	
	@FindBy(xpath="//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantname;
	
	@FindBy(xpath="//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)-10]")
	private WebElement savedco_applicantemail_1;
	
	@FindBy(xpath="//th[.='Adhar Card Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Adhar Card Number']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantadharcardnumber;
	
	@FindBy(xpath="//th[.='Pan Card Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Pan Card Number']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantpancardnumber;
	
	@FindBy(xpath="//th[.='Identity Number Five']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Identity Number Five']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantidentitynumberfive;
	
	@FindBy(xpath="//th[.='Identity Number Six']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Identity Number Six']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantidentitynumbersix;
	
	@FindBy(xpath="//th[.='Identity Number Three']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Identity Number Three']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantidentitynumberthree;
	
	@FindBy(xpath="//th[.='Identity Number Four']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Identity Number Four']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantidentitynumberfour;
	
	@FindBy(xpath="//th[.='Company Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Company Name']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantcompanyname;
	
	@FindBy(xpath="//th[.='Designation']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Designation']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantdesignation;
	
	@FindBy(xpath="//th[.='Address']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Address']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantaddress;
	
	@FindBy(xpath="//th[.='Mobile Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Mobile Number']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantmobilenumber;
	
	@FindBy(xpath="//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantemail;
	
	@FindBy(xpath="//th[.='Department']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Department']/preceding-sibling::th)+1]")
	private WebElement savedco_applicantdepartment;
	
	@FindBy(xpath="//th[contains(.,'Co Applicant Employment Text Variable 1')]/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[contains(.,'Co Applicant Employment Text Variable 1')]/preceding-sibling::th)+1]")
	private WebElement savedco_applicantemploymenttextvariableone;
	
	@FindBy(xpath="//th[contains(.,'Co Applicant Employment Text Variable 2')]/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[contains(.,'Co Applicant Employment Text Variable 2')]/preceding-sibling::th)+1]")
	private WebElement savedco_applicantemploymenttextvariabletwo;
	
	@FindBy(xpath="//th[contains(.,'Co Applicant Employment Text Variable 3')]/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[contains(.,'Co Applicant Employment Text Variable 3')]/preceding-sibling::th)+1]")
	private WebElement savedco_applicantemploymenttextvariablethree;
	
	@FindBy(xpath="//th[contains(.,'Co Applicant Employment Date Variable 1')]/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[contains(.,'Co Applicant Employment Date Variable 1')]/preceding-sibling::th)+1]")
	private WebElement savedco_applicantemploymentdatevariableone;
	
	@FindBy(xpath="//form[@id='updateCoApplicantOnBoard']//input[@id='firstName']")
	private WebElement updatecoapplicantfirstnametextbox;
	
	@FindBy(xpath="//form[@id='updateCoApplicantOnBoard']//input[@id='lastName']")
	private WebElement updatecoapplicantlastnametextbox;
	
	@FindBy(xpath="//form[@id='updateCoApplicantOnBoard']//input[@id='emailId']")
	private WebElement updatecoapplicantemailtextbox;
	
	@FindBy(xpath="//form[@id='updateCoApplicantOnBoard']//input[@id='companyName']")
	private WebElement updatecoapplicantcompanynametextbox;
	
	@FindBy(xpath="//form[@id='updateCoApplicantOnBoard']//input[@id='coApplicantEmploymentTextVariable1']")
	private WebElement updatecoapplicantemploymenttextvariable1;
	
	@FindBy(xpath="//form[@id='updateCoApplicantOnBoard']//button[@id='submit_co_applicant']")
	private WebElement updatecoapplicantdonebutton;
	
	@FindBy(xpath="//span[contains(text(),'Co Applicant deleted')]")
	private WebElement addedcoapplicantdeletenotification;
	
	@FindBy(id="createCoApplicant")
	private WebElement addandcontinuebutton;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	private WebElement skipbutton;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	public void clickSkip() {
		try {
			Generics.waitForElement(driver, skipbutton);
			skipbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	public void validateCo_ApplicantDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, co_applicantdetailsheading);
			if (co_applicantdetailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Co_Applicant Details is displayed", true);
			} else
				Reporter.log("Co_Applicant Details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateCo_ApplicantDetailsHeading", true);
		}
	}
	
	public void enterFirstName(String firstname) {
		try {
			Generics.waitForElement(driver, firstnametextbox);
			firstnametextbox.click();
			firstnametextbox.clear();
			firstnametextbox.sendKeys(firstname);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterFirstName", true);
		}
	}
	
	public void enterLastName(String lastname) {
		try {
			Generics.waitForElement(driver, lastnametextbox);
			lastnametextbox.click();
			lastnametextbox.clear();
			lastnametextbox.sendKeys(lastname);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterFirstName", true);
		}
	}
	
	public void enterEmailId(String emailid) {
		try {
			Generics.waitForElement(driver, emailidtextbox);
			emailidtextbox.click();
			emailidtextbox.clear();
			emailidtextbox.sendKeys(emailid);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterEmailId", true);
		}
	}
	
	public void enterAdharCardNumber(String value) {
		try {
			Generics.waitForElement(driver, aadharcardnumbertextbox);
			aadharcardnumbertextbox.click();
			aadharcardnumbertextbox.clear();
			aadharcardnumbertextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterPanCardNumber(String value) {
		try {
			Generics.waitForElement(driver, pancardnumbertextbox);
			pancardnumbertextbox.click();
			pancardnumbertextbox.clear();
			pancardnumbertextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIdentityNumberThree(String value) {
		try {
			Generics.waitForElement(driver, identitynumberthreetextbox);
			identitynumberthreetextbox.click();
			identitynumberthreetextbox.clear();
			identitynumberthreetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIdentityNumberFour(String value) {
		try {
			Generics.waitForElement(driver, identitynumberfourtextbox);
			identitynumberfourtextbox.click();
			identitynumberfourtextbox.clear();
			identitynumberfourtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIdentityNumberFive(String value) {
		try {
			Generics.waitForElement(driver, identitynumberfivetextbox);
			identitynumberfivetextbox.click();
			identitynumberfivetextbox.clear();
			identitynumberfivetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIdentityNumberSix(String value) {
		try {
			Generics.waitForElement(driver, identitynumbersixtextbox);
			identitynumbersixtextbox.click();
			identitynumbersixtextbox.clear();
			identitynumbersixtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterCompanyName(String companyname) {
		try {
			Generics.waitForElement(driver, companynametextbox);
			companynametextbox.click();
			companynametextbox.clear();
			companynametextbox.sendKeys(companyname);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterCompanyName", true);
		}
	}
	
	public void enterDepartmentName(String value) {
		try {
			Generics.waitForElement(driver, departmenttextbox);
			departmenttextbox.click();
			departmenttextbox.clear();
			departmenttextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterDesignation(String value) {
		try {
			Generics.waitForElement(driver, designationtextbox);
			designationtextbox.click();
			designationtextbox.clear();
			designationtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterEmail(String value) {
		try {
			Generics.waitForElement(driver, emailtextbox);
			emailtextbox.click();
			emailtextbox.clear();
			emailtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterMobileNumber(String value) {
		try {
			Generics.waitForElement(driver, companymobilenumbertextbox);
			companymobilenumbertextbox.click();
			companymobilenumbertextbox.clear();
			companymobilenumbertextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterCoApplicantEmploymentTextVariable1(String coapplicanttextvariable1) {
		try {
			Generics.waitForElement(driver, co_applicantemploymenttextvariableonetextbox);
			co_applicantemploymenttextvariableonetextbox.click();
			co_applicantemploymenttextvariableonetextbox.clear();
			co_applicantemploymenttextvariableonetextbox.sendKeys(coapplicanttextvariable1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterCoApplicantEmploymentTextVariable2(String value) {
		try {
			Generics.waitForElement(driver, co_applicantemploymenttextvariabletwotextbox);
			co_applicantemploymenttextvariabletwotextbox.click();
			co_applicantemploymenttextvariabletwotextbox.clear();
			co_applicantemploymenttextvariabletwotextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterCoApplicantEmploymentTextVariable3(String value) {
		try {
			Generics.waitForElement(driver, co_applicantemploymenttextvariablethreetextbox);
			co_applicantemploymenttextvariablethreetextbox.click();
			co_applicantemploymenttextvariablethreetextbox.clear();
			co_applicantemploymenttextvariablethreetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterCoApplicantEmploymentDateVariable1(String date, String month, String year) {
		try {
			Generics.waitForElement(driver, co_applicantemploymentdatevariable1textbox);
			co_applicantemploymentdatevariable1textbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select years = new Select(yeardropdown);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, monthdropdown);
			Select months = new Select(monthdropdown);
			months.selectByVisibleText(month);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(date)) {
					datelinks.get(i).click();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterAddress(String line1, String line2, String line3, String subdistrict, String district, String state, String city, String country, 
			String zipcode,	String date, String month, String year, String ownershiptype, String addresstype) {
		try {
			Generics.waitForElement(driver, addressline1textbox);
			addressline1textbox.click();
			addressline1textbox.clear();
			addressline1textbox.sendKeys(line1);
			
			Generics.waitForElement(driver, addressline2textbox);
			addressline2textbox.click();
			addressline2textbox.clear();
			addressline2textbox.sendKeys(line2);
			
			Generics.waitForElement(driver, addressline3textbox);
			addressline3textbox.click();
			addressline3textbox.clear();
			addressline3textbox.sendKeys(line3);
			
			Generics.waitForElement(driver, addresssubdistricttextbox);
			addresssubdistricttextbox.click();
			addresssubdistricttextbox.clear();
			addresssubdistricttextbox.sendKeys(subdistrict);
			
			Generics.waitForElement(driver, addressdistricttextbox);
			addressdistricttextbox.click();
			addressdistricttextbox.clear();
			addressdistricttextbox.sendKeys(district);
			
			Generics.waitForElement(driver, addressstatedropdown);
			Select stateOptions = new Select(addressstatedropdown);
			stateOptions.selectByVisibleText(state);
			
			Generics.waitForElement(driver, citytextbox);
			citytextbox.click();
			citytextbox.clear();
			citytextbox.sendKeys(city);
			
			Generics.waitForElement(driver, countrytextbox);
			countrytextbox.click();
			countrytextbox.clear();
			countrytextbox.sendKeys(country);
			
			Generics.waitForElement(driver, zipcodetextbox);
			zipcodetextbox.click();
			zipcodetextbox.clear();
			zipcodetextbox.sendKeys(zipcode);
			
			Generics.waitForElement(driver, livingsincetextbox);
			livingsincetextbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select years = new Select(yeardropdown);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, monthdropdown);
			Select months = new Select(monthdropdown);
			months.selectByVisibleText(month);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(date)) {
					datelinks.get(i).click();
				}
			}
			
			Generics.waitForElement(driver, ownershiptypedropdown);
			Select ownershipTypeoptions = new Select(ownershiptypedropdown);
			ownershipTypeoptions.selectByVisibleText(ownershiptype);
			
			Generics.waitForElement(driver, addresstypedropdown);
			Select addressTypeOptions = new Select(addresstypedropdown);
			addressTypeOptions.selectByVisibleText(addresstype);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterAddress", true);
		}
	}
	
	public void clickAddMore() {
		try {
			Generics.waitForElement(driver, addmorebutton);
			addmorebutton.click();
			Generics.waitForElementToInvisible(driver, addmorespinner);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateCoAppplicantDetails(String coapplicantname, String email, String adharcardnumber, String pancardnumber, String identitynumberfive,
			String identitynumbersix, String identitynumberthree, String identitynumberfour, String companyname, String designation, String applicantaddress,
			String mobilenumber, String applicantemail, String department, String employmenttextvariable1, String employmenttextvariable2,
			String employmenttextvariable3, String employmentdatevariable1) {
		try {
			Generics.waitForElement(driver, savedco_applicantname);
			assertEquals(savedco_applicantname.getText(), coapplicantname);
			Generics.waitForElement(driver, savedco_applicantemail_1);
			assertEquals(savedco_applicantemail_1.getText(), email);
			Generics.waitForElement(driver, savedco_applicantadharcardnumber);
			assertEquals(savedco_applicantadharcardnumber.getText(), adharcardnumber);
			Generics.waitForElement(driver, savedco_applicantpancardnumber);
			assertEquals(savedco_applicantpancardnumber.getText(), pancardnumber);
			Generics.waitForElement(driver, savedco_applicantidentitynumberfive);
			assertEquals(savedco_applicantidentitynumberfive.getText(), identitynumberfive);
			Generics.waitForElement(driver, savedco_applicantidentitynumbersix);
			assertEquals(savedco_applicantidentitynumbersix.getText(), identitynumbersix);
			Generics.waitForElement(driver, savedco_applicantidentitynumberthree);
			assertEquals(savedco_applicantidentitynumberthree.getText(), identitynumberthree);
			Generics.waitForElement(driver, savedco_applicantidentitynumberfour);
			assertEquals(savedco_applicantidentitynumberfour.getText(), identitynumberfour);
			
			Generics.waitForElement(driver, savedco_applicantcompanyname);
			assertEquals(savedco_applicantcompanyname.getText(), companyname);
			Generics.waitForElement(driver, savedco_applicantdesignation);
			assertEquals(savedco_applicantdesignation.getText(), designation);
			Generics.waitForElement(driver, savedco_applicantaddress);
			assertEquals(savedco_applicantaddress.getText(), applicantaddress);
			Generics.waitForElement(driver, savedco_applicantmobilenumber);
			assertEquals(savedco_applicantmobilenumber.getText(), mobilenumber);
			Generics.waitForElement(driver, savedco_applicantemail);
			assertEquals(savedco_applicantemail.getText(), applicantemail);
			Generics.waitForElement(driver, savedco_applicantdepartment);
			assertEquals(savedco_applicantdepartment.getText(), department);
			Generics.waitForElement(driver, savedco_applicantemploymenttextvariableone);
			assertEquals(savedco_applicantemploymenttextvariableone.getText(), employmenttextvariable1);
			Generics.waitForElement(driver, savedco_applicantemploymenttextvariabletwo);
			assertEquals(savedco_applicantemploymenttextvariabletwo.getText(), employmenttextvariable2);
			Generics.waitForElement(driver, savedco_applicantemploymenttextvariablethree);
			assertEquals(savedco_applicantemploymenttextvariablethree.getText(), employmenttextvariable3);
			Generics.waitForElement(driver, savedco_applicantemploymentdatevariableone);
			assertEquals(savedco_applicantemploymentdatevariableone.getText(), employmentdatevariable1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEdit() {
		try {
			Generics.waitForElement(driver, editbutton);
			editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editCoApplicantDetails(String firstname, String lastname, String email, String companyname, String employmenttextvariable) {
		try {
			Generics.waitForElement(driver, updatecoapplicantfirstnametextbox);
			updatecoapplicantfirstnametextbox.click();
			updatecoapplicantfirstnametextbox.clear();
			updatecoapplicantfirstnametextbox.sendKeys(firstname);
			
			Generics.waitForElement(driver, updatecoapplicantlastnametextbox);
			updatecoapplicantlastnametextbox.click();
			updatecoapplicantlastnametextbox.clear();
			updatecoapplicantlastnametextbox.sendKeys(lastname);
			
			Generics.waitForElement(driver, updatecoapplicantemailtextbox);
			updatecoapplicantemailtextbox.click();
			updatecoapplicantemailtextbox.clear();
			updatecoapplicantemailtextbox.sendKeys(email);
			
			Generics.waitForElement(driver, updatecoapplicantcompanynametextbox);
			updatecoapplicantcompanynametextbox.click();
			updatecoapplicantcompanynametextbox.clear();
			updatecoapplicantcompanynametextbox.sendKeys(companyname);
			
			Generics.waitForElement(driver, updatecoapplicantemploymenttextvariable1);
			updatecoapplicantemploymenttextvariable1.click();
			updatecoapplicantemploymenttextvariable1.clear();
			updatecoapplicantemploymenttextvariable1.sendKeys(employmenttextvariable);
			
			Generics.waitForElement(driver, updatecoapplicantdonebutton);
			updatecoapplicantdonebutton.click();
			Generics.waitForElementToInvisible(driver, updatecoapplicantdonebutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDelete() {
		try {
			Generics.waitForElement(driver, deletebutton);
			deletebutton.click();
			driver.switchTo().alert().accept();
			Generics.waitForElement(driver, addedcoapplicantdeletenotification);
			System.out.println(addedcoapplicantdeletenotification.getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddAndContinue() {
		try {
			Generics.waitForElement(driver, addandcontinuebutton);
			addandcontinuebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateMandatoryFieldsErrorMessages(int count, String i) {
		try {
			Generics.waitForElement(driver, errormessages.get(0));
			assertEquals(errormessages.size(), count);
			for(int j=0; j<errormessages.size(); j++) {
				if(i.equals(errormessages.get(j).getText())) {
					assertEquals(errormessages.get(j).getText(), i);
					break;
				}
				else if(!i.equals(errormessages.get(j).getText()) && j==count-1) {
					Reporter.log("Can't able to match - "+i, true);
					assertEquals(true, false);
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
