package com.automationsaas.pom.borroweronboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class BorrowerRegistrationPage extends Base {

	public WebDriver driver;

	public BorrowerRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1")
	private WebElement borrowerregistrationheading;

	@FindBy(id = "title")
	private WebElement titledropdown;

	@FindBy(id = "firstName")
	private WebElement firstnametextbox;

	@FindBy(id = "lastName")
	private WebElement lastnametextbox;

	@FindBy(id = "emailAddress")
	private WebElement emailaddresstextbox;

	@FindBy(xpath = "//span[text()='Email Id Good To Go !']")
	private WebElement emailaddressavailabilitynotification;

	@FindBy(id = "password")
	private WebElement passwordtextbox;

	@FindBy(id = "confirmPassword")
	private WebElement confirmpasswordtextbox;

	@FindBy(id = "gender")
	private WebElement genderdropdown;

	@FindBy(id = "maritalStatus")
	private WebElement maritialstatusdropdown;

	@FindBy(id = "mobileNumber")
	private WebElement mobilenumbertextbox;

	@FindBy(xpath = "//span[text()='Mobile Number good is to Go!']")
	private WebElement mobilenumberavailabilitynotification;

	@FindBy(xpath = "//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;
	
	@FindBy(id="landLineNumber")
	private WebElement landlinenumbertextbox;
	
	@FindBy(xpath="//span[contains(text(),'Landline Number good to go')]")
	private WebElement landlinenumbernotification;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks; 

	@FindBy(xpath = "//input[@id='identityNumberOne']")
	private WebElement identitynumberone;
	
	@FindBy(id = "identityNumberTwo")
	private WebElement identitynumbertwo;
	
	@FindBy(id="identityNumberThree")
	private WebElement identitynumberthree;
	
	@FindBy(id="identityNumberFour")
	private WebElement identitynumberfour;
	
	@FindBy(id="identityNumberFive")
	private WebElement identitynumberfive;
	
	@FindBy(id="identityNumberSix")
	private WebElement identitynumbersix;
	
	@FindBy(id="referralCode")
	private WebElement referalcodetextbox;
	
	@FindBy(id="borrowerCategory")
	private WebElement borrowercategorydropdown;
	
	@FindBy(id="fatherFullName")
	private WebElement fatherfullnametextbox;
	
	@FindBy(id="fatherFirstName")
	private WebElement fatherfirstnametextbox;
	
	@FindBy(id="fatherMiddleName")
	private WebElement fathermiddlenametextbox;
	
	@FindBy(id="fatherLastName")
	private WebElement fatherlastnametextbox;
	
	@FindBy(id="motherFullName")
	private WebElement motherfullnametextbox;
	
	@FindBy(id="motherFirstName")
	private WebElement motherfirstnametextbox;
	
	@FindBy(id="motherMiddleName")
	private WebElement mothermiddlenametextbox;
	
	@FindBy(id="motherLastName")
	private WebElement motherlastnametextbox;
	
	@FindBy(id="educationType")
	private WebElement eduationtypedropdown;
	
	@FindBy(id="numberOfDependents")
	private WebElement numberofdependentstextbox;
	
	@FindBy(id="promotionCode")
	private WebElement promotioncodetextbox;
	
	@FindBy(id="workExperienceType")
	private WebElement workexperiencetextbox;
	
	@FindBy(id = "individualRadio")
	private WebElement individualtyperadiobutton;
	
	@FindBy(id="companyRadio")
	private WebElement companytyperadiobutton;
	
	@FindBy(id="personalAddressLine1")
	private WebElement personal_address_line1_textbox;
	
	@FindBy(id="personalAddressLine2")
	private WebElement personal_address_line2_textbox;
	
	@FindBy(id="personalAddressLine3")
	private WebElement personal_address_line3_textbox;
	
	@FindBy(id="personalAddressSubDistrict")
	private WebElement personal_address_subdistrict_textbox;
	
	@FindBy(id="personalAddressDistrict")
	private WebElement personal_address_district_textbox;
	
	@FindBy(id="personalAddressState")
	private WebElement personal_address_state_dropdown;
	
	@FindBy(id="personalAddressCity")
	private WebElement personal_address_city_textbox;
	
	@FindBy(id="personalAddressCountry")
	private WebElement personal_address_country_textbox;
	
	@FindBy(id="personalAddressZipCode")
	private WebElement personal_address_zipcode_textbox;
	
	@FindBy(id="personalAddressLivingSince")
	private WebElement personal_address_livingsince_textbox;
	
	@FindBy(id="personalAddressOwnershipType")
	private WebElement personal_address_ownershiptype_dropdown;
	
	@FindBy(id="personalAddressTypeOfAddress")
	private WebElement personal_address_addresstype_dropdown;
	
	@FindBy(id="addressOneLine1")
	private WebElement addressone_line1_textbox;
	
	@FindBy(id="addressOneLine2")
	private WebElement addressone_line2_textbox;
	
	@FindBy(id="addressOneLine3")
	private WebElement addressone_line3_textbox;
	
	@FindBy(id="addressOneSubDistrict")
	private WebElement addressone_subdistrict_textbox;
	
	@FindBy(id="addressOneDistrict")
	private WebElement addressone_district_textbox;
	
	@FindBy(id="addressOneState")
	private WebElement addressone_state_dropdown;
	
	@FindBy(id="addressOneCity")
	private WebElement addressone_city_textbox;
	
	@FindBy(id="addressOneCountry")
	private WebElement addressone_country_textbox;
	
	@FindBy(id="addressOneZipCode")
	private WebElement addressone_zipcode_textbox;
	
	@FindBy(id="addressOneLivingSince")
	private WebElement addressone_livingsince_textbox;
	
	@FindBy(id="addressOneOwnershipType")
	private WebElement addressone_ownershiptype_dropdown;
	
	@FindBy(id="addressOneTypeOfAddress")
	private WebElement addressone_addresstype_dropdown;
	
	@FindBy(id="addressTwoLine1")
	private WebElement addresstwo_line1_textbox;
	
	@FindBy(id="addressTwoLine2")
	private WebElement addresstwo_line2_textbox;
	
	@FindBy(id="addressTwoLine3")
	private WebElement addresstwo_line3_textbox;
	
	@FindBy(id="addressTwoSubDistrict")
	private WebElement addresstwo_subdistrict_textbox;
	
	@FindBy(id="addressTwoDistrict")
	private WebElement addresstwo_district_textbox;
	
	@FindBy(id="addressTwoState")
	private WebElement addresstwo_state_dropdown;
	
	@FindBy(id="addressTwoCity")
	private WebElement addresstwo_city_textbox;
	
	@FindBy(id="addressTwoCountry")
	private WebElement addresstwo_country_textbox;
	
	@FindBy(id="addressTwoZipCode")
	private WebElement borrowerprofiletextvariable3dropdowntextbox;
	
	@FindBy(id="addressTwoLivingSince")
	private WebElement addresstwo_livingsince_textbox;
	
	@FindBy(id="addressTwoOwnershipType")
	private WebElement addresstwo_ownershiptype_dropdown;
	
	@FindBy(id="addressTwoTypeOfAddress")
	private WebElement addresstwo_addresstype_dropdown;

	@FindBy(id = "borrowerProfileTextVariable1")
	private WebElement borrowerprofiletextvariable1dropdown;
	
	@FindBy(id="borrowerProfileTextVariable2")
	private WebElement borrowerprofiletextvariable2dropdown;
	
	@FindBy(id="borrowerProfileTextVariable3")
	private WebElement borrowerprofiletextvariable3textbox;

	@FindBy(id = "submit_button")
	private WebElement applynowbutton;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	private WebElement skipbutton;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	Logger logger = Logger.getLogger("test");
	
	public void clickSkip() {
		try {
			Generics.waitForElement(driver, skipbutton);
			skipbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateBorrowerRegistrationHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, borrowerregistrationheading);
			if (borrowerregistrationheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Borrower Registration is displayed", true);
			} else
				Reporter.log("Borrower Registration is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateBorrowerRegistrationHeading", true);
		}
	}

	public void selectTitle(String title) {
		try {
			Generics.waitForElement(driver, titledropdown);
			Select titles = new Select(titledropdown);
			titles.selectByVisibleText(title);
			Reporter.log("selectTitle is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectTitle", true);
		}
	}
	
	public void enterFirstName(String firstname) {
		try {
			Generics.waitForElement(driver, firstnametextbox);
			firstnametextbox.click();
			firstnametextbox.clear();
			firstnametextbox.sendKeys(firstname);
			Reporter.log("enterFirstName is passed", true);
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
			Reporter.log("enterLastName is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterLastName", true);
		}
	}
	
	public void enterEmailAddress(String emailaddress) {
		try {
			Generics.waitForElement(driver, emailaddresstextbox);
			emailaddresstextbox.click();
			emailaddresstextbox.clear();
			emailaddresstextbox.sendKeys(emailaddress);
			passwordtextbox.click();
			Reporter.log("enterEmailAddress is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterEmailAddress", true);
		}
	}
	
	public void checkAvailabilityOfEmailAddress() {
		try {
			Generics.waitForElement(driver, emailaddressavailabilitynotification);
			Reporter.log("checkAvailabilityOfEmailAddress is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in checkAvailabilityOfEmailAddress", true);
		}
	}
	
	public void enterPassword(String password) {
		try {
			Generics.waitForElement(driver, passwordtextbox);
			passwordtextbox.click();
			passwordtextbox.clear();
			passwordtextbox.sendKeys(password);
			Reporter.log("enterPassword is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterPassword", true);
		}
	}
	
	public void enterConfirmPassword(String confirmpassword) {
		try {
			Generics.waitForElement(driver, confirmpasswordtextbox);
			confirmpasswordtextbox.click();
			confirmpasswordtextbox.clear();
			confirmpasswordtextbox.sendKeys(confirmpassword);
			Reporter.log("enterConfirmPassword is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterConfirmPassword", true);
		}
	}
	
	public void selectGender(String gender) {
		try {
			Generics.waitForElement(driver, genderdropdown);
			Select genders = new Select(genderdropdown);
			genders.selectByVisibleText(gender);
			Reporter.log("selectGender is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectGender", true);
		}
	}
	
	public void selectMaritialStatus(String maritialstatus) {
		try {
			Generics.waitForElement(driver, maritialstatusdropdown);
			Select maritialStatus = new Select(maritialstatusdropdown);
			maritialStatus.selectByVisibleText(maritialstatus);
			Reporter.log("selectMaritialStatus is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectMaritialStatus", true);
		}
	}
	
	public void enterMobileNumber(String mobilenumber) {
		try {
			Generics.waitForElement(driver, mobilenumbertextbox);
			mobilenumbertextbox.click();
			mobilenumbertextbox.clear();
			mobilenumbertextbox.sendKeys(mobilenumber);
			dateofbirthtextbox.click();
			Reporter.log("enterMobileNumber is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterMobileNumber", true);
		}
	}
	
	public void enterLandlineNumber(String landlinenumber) {
		try {
			Generics.waitForElement(driver, landlinenumbertextbox);
			landlinenumbertextbox.click();
			landlinenumbertextbox.clear();
			landlinenumbertextbox.sendKeys(landlinenumber);
			dateofbirthtextbox.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkAvailabilityOfLandlineNumber() {
		try {
			Generics.waitForElement(driver, landlinenumbernotification);
			Reporter.log("checkAvailabilityOfLandlineNumber is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in checkAvailabilityOfLandlineNumber", true);
		}
	}
	
	public void checkAvailabilityOfMobileNumber() {
		try {
			Generics.waitForElement(driver, mobilenumberavailabilitynotification);
			Reporter.log("checkAvailabilityOfMobileNumber is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in checkAvailabilityOfMobileNumber", true);
		}
	}
	
	public void selectDateOfBirth(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, dateofbirthtextbox);
			dateofbirthtextbox.click();
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
			Reporter.log("selectDateOfBirth is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectDateOfBirth", true);
		}
	}
	//Divya
	public void enterIdentityNumberOne(String identitynumberoneborrower) {
		try {
			Generics.waitForElement(driver, identitynumberone);
			identitynumberone.click();
			identitynumberone.clear();
			identitynumberone.sendKeys(identitynumberoneborrower);
			identitynumbertwo.click();
			Reporter.log("enterIdentityNumberOne is passed", true);
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
			Reporter.log("enterIdentityNumberTwo is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterIdentityNumberTwo", true);
		}
	}
	
	public void enterIdentityNumberThree(String identitynumberthreeborrower) {
		try {
			Generics.waitForElement(driver, identitynumberthree);
			identitynumberthree.click();
			identitynumberthree.clear();
			identitynumberthree.sendKeys(identitynumberthreeborrower);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIdentityNumberFour(String identitynumberfourborrower) {
		try {
			Generics.waitForElement(driver, identitynumberfour);
			identitynumberfour.click();
			identitynumberfour.clear();
			identitynumberfour.sendKeys(identitynumberfourborrower);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIdentityNumberFive(String identitynumberfiveborrower) {
		try {
			Generics.waitForElement(driver, identitynumberfive);
			identitynumberfive.click();
			identitynumberfive.clear();
			identitynumberfive.sendKeys(identitynumberfiveborrower);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIdentityNumberSix(String identitynumbersixborrower) {
		try {
			Generics.waitForElement(driver, identitynumbersix);
			identitynumbersix.click();
			identitynumbersix.clear();
			identitynumbersix.sendKeys(identitynumbersixborrower);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterReferalCode(String referalcode) {
		try {
			Generics.waitForElement(driver, referalcodetextbox);
			referalcodetextbox.click();
			referalcodetextbox.clear();
			referalcodetextbox.sendKeys(referalcode);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerCategory(String borrowercategoryoptions) {
		try {
			Generics.waitForElement(driver, borrowercategorydropdown);
			Select borrowerCategoryOptions = new Select(borrowercategorydropdown);
			borrowerCategoryOptions.selectByVisibleText(borrowercategoryoptions);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFatherFullName(String fatherfullname) {
		try {
			Generics.waitForElement(driver, fatherfullnametextbox);
			fatherfullnametextbox.click();
			fatherfullnametextbox.clear();
			fatherfullnametextbox.sendKeys(fatherfullname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFatherFirstName(String fatherfirstname) {
		try {
			Generics.waitForElement(driver, fatherfirstnametextbox);
			fatherfirstnametextbox.click();
			fatherfirstnametextbox.clear();
			fatherfirstnametextbox.sendKeys(fatherfirstname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFatherMiddleName(String fathermiddlename) {
		try {
			Generics.waitForElement(driver, fathermiddlenametextbox);
			fathermiddlenametextbox.click();
			fathermiddlenametextbox.clear();
			fathermiddlenametextbox.sendKeys(fathermiddlename);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFatherLastName(String fatherlastname) {
		try {
			Generics.waitForElement(driver, fatherlastnametextbox);
			fatherlastnametextbox.click();
			fatherlastnametextbox.clear();
			fatherlastnametextbox.sendKeys(fatherlastname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterMotherFullName(String motherfullname) {
		try {
			Generics.waitForElement(driver, motherfullnametextbox);
			motherfullnametextbox.click();
			motherfullnametextbox.clear();
			motherfullnametextbox.sendKeys(motherfullname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterMotherFirstName(String motherfirstname) {
		try {
			Generics.waitForElement(driver, motherfirstnametextbox);
			motherfirstnametextbox.click();
			motherfirstnametextbox.clear();
			motherfirstnametextbox.sendKeys(motherfirstname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterMotherMiddleName(String mothermiddlename) {
		try {
			Generics.waitForElement(driver, mothermiddlenametextbox);
			mothermiddlenametextbox.click();
			mothermiddlenametextbox.clear();
			mothermiddlenametextbox.sendKeys(mothermiddlename);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterMotherLastName(String motherlastname) {
		try {
			Generics.waitForElement(driver, motherlastnametextbox);
			motherlastnametextbox.click();
			motherlastnametextbox.clear();
			motherlastnametextbox.sendKeys(motherlastname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterEducationType(String educationtype) {
		try {
			Generics.waitForElement(driver, eduationtypedropdown);
			Select educationTypeOptions = new Select(eduationtypedropdown);
			educationTypeOptions.selectByVisibleText(educationtype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterNumberOfDependents(String numberdependents) {
		try {
			Generics.waitForElement(driver, numberofdependentstextbox);
			numberofdependentstextbox.click();
			numberofdependentstextbox.clear();
			numberofdependentstextbox.sendKeys(numberdependents);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterPromotionCode(String promotioncode) {
		try {
			Generics.waitForElement(driver, promotioncodetextbox);
			promotioncodetextbox.click();
			promotioncodetextbox.clear();
			promotioncodetextbox.sendKeys(promotioncode);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterWorkExperience(String workexperience) {
		try {
			Generics.waitForElement(driver, workexperiencetextbox);
			workexperiencetextbox.click();
			workexperiencetextbox.clear();
			workexperiencetextbox.sendKeys(workexperience);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectTypeAsIndividualOrCompany(String type) {
		try {
			if (type.equalsIgnoreCase("individual")){
				Generics.waitForElement(driver, individualtyperadiobutton);
				individualtyperadiobutton.click();
				Reporter.log("selectTypeAsIndividualOrCompany is passed with option as "+ type, true);
			}
			else if (type.equalsIgnoreCase("company")){
				Generics.waitForElement(driver, companytyperadiobutton);
				companytyperadiobutton.click();
				Reporter.log("selectTypeAsIndividualOrCompany is passed with option as "+ type, true);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectTypeAsIndividual", true);
		}
	}
	
	public void enterPersonalAddress(String personaladdressline1, String personaladdressline2, String personaladdressline3, String subdistrict,
			String district, String state, String city, String country, String zipcode, String year, String month, String date, String ownershiptype,
			String addresstype) {
		try {
			Generics.waitForElement(driver, personal_address_line1_textbox);
			personal_address_line1_textbox.click();
			personal_address_line1_textbox.clear();
			personal_address_line1_textbox.sendKeys(personaladdressline1);
			
			Generics.waitForElement(driver, personal_address_line2_textbox);
			personal_address_line2_textbox.click();
			personal_address_line2_textbox.clear();
			personal_address_line2_textbox.sendKeys(personaladdressline2);
			
			Generics.waitForElement(driver, personal_address_line3_textbox);
			personal_address_line3_textbox.click();
			personal_address_line3_textbox.clear();
			personal_address_line3_textbox.sendKeys(personaladdressline3);
			
			Generics.waitForElement(driver, personal_address_subdistrict_textbox);
			personal_address_subdistrict_textbox.click();
			personal_address_subdistrict_textbox.clear();
			personal_address_subdistrict_textbox.sendKeys(subdistrict);
			
			Generics.waitForElement(driver, personal_address_district_textbox);
			personal_address_district_textbox.click();
			personal_address_district_textbox.clear();
			personal_address_district_textbox.sendKeys(district);
			
			Generics.waitForElement(driver, personal_address_state_dropdown);
			Select stateOptions = new Select(personal_address_state_dropdown);
			stateOptions.selectByVisibleText(state);
			
			Generics.waitForElement(driver, personal_address_city_textbox);
			personal_address_city_textbox.click();
			personal_address_city_textbox.clear();
			personal_address_city_textbox.sendKeys(city);
			
			Generics.waitForElement(driver, personal_address_country_textbox);
			personal_address_country_textbox.click();
			personal_address_country_textbox.clear();
			personal_address_country_textbox.sendKeys(country);
			
			Generics.waitForElement(driver, personal_address_zipcode_textbox);
			personal_address_zipcode_textbox.click();
			personal_address_zipcode_textbox.clear();
			personal_address_zipcode_textbox.sendKeys(zipcode);
			
			Generics.waitForElement(driver, personal_address_livingsince_textbox);
			personal_address_livingsince_textbox.click();
			
			Generics.waitForElement(driver, dateofbirthtextbox);
//			dateofbirthtextbox.click();
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
			
			Generics.waitForElement(driver, personal_address_ownershiptype_dropdown);
			Select ownershiptypeoptions = new Select(personal_address_ownershiptype_dropdown);
			ownershiptypeoptions.selectByVisibleText(ownershiptype);
			
			Generics.waitForElement(driver, personal_address_addresstype_dropdown);
			Select addressTypeOptions = new Select(personal_address_addresstype_dropdown);
			addressTypeOptions.selectByVisibleText(addresstype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterAddressOne(String personaladdressline1, String personaladdressline2, String personaladdressline3, String subdistrict,
			String district, String state, String city, String country, String zipcode, String year, String month, String date, String ownershiptype,
			String addresstype) {
		try {
			Generics.waitForElement(driver, addressone_line1_textbox);
			addressone_line1_textbox.click();
			addressone_line1_textbox.clear();
			addressone_line1_textbox.sendKeys(personaladdressline1);
			
			Generics.waitForElement(driver, addressone_line2_textbox);
			addressone_line2_textbox.click();
			addressone_line2_textbox.clear();
			addressone_line2_textbox.sendKeys(personaladdressline2);
			
			Generics.waitForElement(driver, addressone_line3_textbox);
			addressone_line3_textbox.click();
			addressone_line3_textbox.clear();
			addressone_line3_textbox.sendKeys(personaladdressline3);
			
			Generics.waitForElement(driver, addressone_subdistrict_textbox);
			addressone_subdistrict_textbox.click();
			addressone_subdistrict_textbox.clear();
			addressone_subdistrict_textbox.sendKeys(subdistrict);
			
			Generics.waitForElement(driver, addressone_district_textbox);
			addressone_district_textbox.click();
			addressone_district_textbox.clear();
			addressone_district_textbox.sendKeys(district);
			
			Generics.waitForElement(driver, addressone_state_dropdown);
			Select stateOptions = new Select(addressone_state_dropdown);
			stateOptions.selectByVisibleText(state);
			
			Generics.waitForElement(driver, addressone_city_textbox);
			addressone_city_textbox.click();
			addressone_city_textbox.clear();
			addressone_city_textbox.sendKeys(city);
			
			Generics.waitForElement(driver, addressone_country_textbox);
			addressone_country_textbox.click();
			addressone_country_textbox.clear();
			addressone_country_textbox.sendKeys(country);
			
			Generics.waitForElement(driver, addressone_zipcode_textbox);
			addressone_zipcode_textbox.click();
			addressone_zipcode_textbox.clear();
			addressone_zipcode_textbox.sendKeys(zipcode);
			
			Generics.waitForElement(driver, addressone_livingsince_textbox);
			addressone_livingsince_textbox.click();
			
			Generics.waitForElement(driver, dateofbirthtextbox);
//			dateofbirthtextbox.click();
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
			
			Generics.waitForElement(driver, addressone_ownershiptype_dropdown);
			Select ownershiptypeoptions = new Select(addressone_ownershiptype_dropdown);
			ownershiptypeoptions.selectByVisibleText(ownershiptype);
			
			Generics.waitForElement(driver, addressone_addresstype_dropdown);
			Select addressTypeOptions = new Select(addressone_addresstype_dropdown);
			addressTypeOptions.selectByVisibleText(addresstype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterAddressTwo(String personaladdressline1, String personaladdressline2, String personaladdressline3, String subdistrict,
			String district, String state, String city, String country, String zipcode, String year, String month, String date, String ownershiptype,
			String addresstype) {
		try {
			Generics.waitForElement(driver, addresstwo_line1_textbox);
			addresstwo_line1_textbox.click();
			addresstwo_line1_textbox.clear();
			addresstwo_line1_textbox.sendKeys(personaladdressline1);
			
			Generics.waitForElement(driver, addresstwo_line2_textbox);
			addresstwo_line2_textbox.click();
			addresstwo_line2_textbox.clear();
			addresstwo_line2_textbox.sendKeys(personaladdressline2);
			
			Generics.waitForElement(driver, addresstwo_line3_textbox);
			addresstwo_line3_textbox.click();
			addresstwo_line3_textbox.clear();
			addresstwo_line3_textbox.sendKeys(personaladdressline3);
			
			Generics.waitForElement(driver, addresstwo_subdistrict_textbox);
			addresstwo_subdistrict_textbox.click();
			addresstwo_subdistrict_textbox.clear();
			addresstwo_subdistrict_textbox.sendKeys(subdistrict);
			
			Generics.waitForElement(driver, addresstwo_district_textbox);
			addresstwo_district_textbox.click();
			addresstwo_district_textbox.clear();
			addresstwo_district_textbox.sendKeys(district);
			
			Generics.waitForElement(driver, addresstwo_state_dropdown);
			Select stateOptions = new Select(addresstwo_state_dropdown);
			stateOptions.selectByVisibleText(state);
			
			Generics.waitForElement(driver, addresstwo_city_textbox);
			addresstwo_city_textbox.click();
			addresstwo_city_textbox.clear();
			addresstwo_city_textbox.sendKeys(city);
			
			Generics.waitForElement(driver, addresstwo_country_textbox);
			addresstwo_country_textbox.click();
			addresstwo_country_textbox.clear();
			addresstwo_country_textbox.sendKeys(country);
			
			Generics.waitForElement(driver, borrowerprofiletextvariable3dropdowntextbox);
			borrowerprofiletextvariable3dropdowntextbox.click();
			borrowerprofiletextvariable3dropdowntextbox.clear();
			borrowerprofiletextvariable3dropdowntextbox.sendKeys(zipcode);
			
			Generics.waitForElement(driver, addresstwo_livingsince_textbox);
			addresstwo_livingsince_textbox.click();
			
			Generics.waitForElement(driver, dateofbirthtextbox);
//			dateofbirthtextbox.click();
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
			
			Generics.waitForElement(driver, addresstwo_ownershiptype_dropdown);
			Select ownershiptypeoptions = new Select(addresstwo_ownershiptype_dropdown);
			ownershiptypeoptions.selectByVisibleText(ownershiptype);
			
			Generics.waitForElement(driver, addresstwo_addresstype_dropdown);
			Select addressTypeOptions = new Select(addresstwo_addresstype_dropdown);
			addressTypeOptions.selectByVisibleText(addresstype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectBorrowerProfileTextVariable1(String text) {
		try {
			Generics.waitForElement(driver, borrowerprofiletextvariable1dropdown);
			Select borrowerProfileTextVariable1Options = new Select(borrowerprofiletextvariable1dropdown);
			borrowerProfileTextVariable1Options.selectByVisibleText(text);
			Reporter.log("enterBorrowerProfileTextVariable1 is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterBorrowerProfileTextVariable1", true);
		}
	}
	
	public void selectBorrowerProfileTextVariable2(String text) {
		try {
			Generics.waitForElement(driver, borrowerprofiletextvariable2dropdown);
			Select borrowerProfileTextVariable2Options = new Select(borrowerprofiletextvariable2dropdown);
			borrowerProfileTextVariable2Options.selectByVisibleText(text);
			Reporter.log("enterBorrowerProfileTextVariable2 is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterBorrowerProfileTextVariable2", true);
		}
	}
	
	public void enterBorrowerProfileTextVariable3(String text) {
		try {
			Generics.waitForElement(driver, borrowerprofiletextvariable3textbox);
			borrowerprofiletextvariable3textbox.click();
			borrowerprofiletextvariable3textbox.clear();
			borrowerprofiletextvariable3textbox.sendKeys(text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickApplyNow() {
		try {
			Generics.waitForElement(driver, applynowbutton);
			applynowbutton.click();
			Reporter.log("clickApplyNow is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in clickApplyNow", true);
		}
	}
	
	/**
	 * @author chandrashekar
	 * To enter email id on Borrower Registration Page - From DSA Side
	 */
	public void enterborrowerEmail(String emailaddress) {
		try {
			Generics.waitForElement(driver, emailaddresstextbox);
			emailaddresstextbox.click();
			emailaddresstextbox.clear();
			emailaddresstextbox.sendKeys(emailaddress);
			mobilenumbertextbox.click();
			Reporter.log("enterborrowerEmail is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterEmailAddress", true);
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
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
