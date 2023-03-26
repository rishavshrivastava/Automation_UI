package com.automationsaas.pom.fia;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class FIARegistrationPage {
	
	public WebDriver driver;

	public FIARegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1")
	private WebElement fiaregistrationheading;
	
	@FindBy(xpath="//*[contains(text(), 'Personal Address')]")
	private WebElement personaladdresstextbox;
	
	//Address fields
	@FindBy(id="line1")
	private WebElement addressline1;
	
	@FindBy(id="line2")
	private WebElement addressline2;
	
	@FindBy(id="line3")
	private WebElement addressline3;
	
	@FindBy(id="subDistrict")
	private WebElement subdistrict1;
	
	@FindBy(id="district")
	private WebElement district1;
	
	@FindBy(id="country")
	private WebElement country1;
	
	@FindBy(id="ownershipType")
	private WebElement ownershiptype;
	
	@FindBy(id="typeOfAddress")
	private WebElement typeOfaddress;
	
	@FindBy(id="state")
	private WebElement addressstate;
	
	@FindBy(id="city")
	private WebElement addresscity;
	
	@FindBy(id="zipCode")
	private WebElement addresszipcode;
	
	@FindBy(id="livingSince")
	private WebElement livingsince1;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks; 
	
	@FindBy(id="ownershipType")
	private WebElement ownershiptype_dropdown;
	
	@FindBy(id="typeOfAddress")
	private WebElement addresstype_dropdown;
	
	//Address One
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
	
	@FindBy(xpath="//select[(@id='addressOneOwnershipType')]/../following-sibling::div/select[(@id='typeOfAddress')]")
	private WebElement addressone_addresstype_dropdown;
	
	//text
	@FindBy(id="identityNumberOne")
	private WebElement identitynumberone;
	
	@FindBy(id="identityNumberTwo")
	private WebElement identitynumbertwo;
	
	@FindBy(id="submit_button")
	private WebElement submitbutton;
	
	@FindBy(id="username")
	private WebElement emailidtextbox;
	
	@FindBy(id="phoneNumber")
	private WebElement phonenumbertextbox;
	
	//Chandrashekar 27-12-2022
	@FindBy(xpath="//input[contains(@id,'dateOfBirth')]")
	private WebElement dobtextbox;
	
	@FindBy(xpath="//input[contains(@name,'identityNumberOneIssueDate')]")
	private WebElement idoneissuedatetextbox;
	
	@FindBy(xpath="//input[contains(@name,'identityNumberTwoIssueDate')]")
	private WebElement idtwoissuedatetextbox;
	
	@FindBy(xpath="//input[(@id='fiaProfileTextVariable1')]")
	private WebElement textvariableonetextbox;
	
	@FindBy(xpath="//input[(@id='fiaProfileTextVariable2')]")
	private WebElement textvariabletwotextbox;
	
	@FindBy(xpath="//input[(@id='citizenship')]")
	private WebElement citizentextbox;
	
	
	
	
	public void validateFIARegistrationHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, fiaregistrationheading);
			if (fiaregistrationheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("FIA Registration is displayed", true);
			} else
				Reporter.log("FIA Registration is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateFIARegistrationHeading", true);
		}
	}
	
	
	public void enteremailid(String email) {
		try {
			Generics.waitForElement(driver, emailidtextbox);
			emailidtextbox.click();
			emailidtextbox.clear();
			emailidtextbox.sendKeys(email);
			//clicking outside email textbox to verify the email validation message
			identitynumberone.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in email", true);
		}
	}
	
	public void enterPhoneNumber(String Phone) {
		try {
			Generics.waitForElement(driver, phonenumbertextbox);
			phonenumbertextbox.click();
			phonenumbertextbox.clear();
			phonenumbertextbox.sendKeys(Phone);
			//clicking outside phone textbox to verify the phone validation message
			identitynumbertwo.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in Mobile number", true);
		}
	}
	
//	public String getMobileNumber() {
//		String fiaMobileNumber = null;
//		try {
//			Generics.waitForElement(driver, phonenumbertextbox);
//			fiaMobileNumber = phonenumbertextbox.getText();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return fiaMobileNumber;
//	}
//	
	public void enterIdentityNumberOne(String id1) {
		try {
			//addressline2.click();
			Generics.waitForElement(driver, identitynumberone);
			identitynumberone.click();
			identitynumberone.clear();
			identitynumberone.sendKeys(id1);

		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in identity number one", true);
		}
	}
	
	public void enterIdentityNumberTwo(String id2) {
		try {
			Generics.waitForElement(driver, identitynumbertwo);
			identitynumbertwo.click();
			identitynumbertwo.clear();
			identitynumbertwo.sendKeys(id2);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in identity number two", true);
		}
	}
	
	public void validateAddressHeading(String addressheading) {
		try {
			Generics.waitForElement(driver, personaladdresstextbox);
			if (personaladdresstextbox.getText().equalsIgnoreCase(addressheading)) {
				Reporter.log("Personal Address is displayed", true);
			} else
				Reporter.log("Personal Address is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateAddressHeading", true);
		}
	}
	public void enterAddressLine1(String line1) {
		try {
			Generics.waitForElement(driver, addressline1);
			addressline1.click();
			addressline1.clear();
			addressline1.sendKeys(line1);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in address-line1", true);
		}
	}
	
	public void enterAddressLine2(String line2) {
		try {
			Generics.waitForElement(driver, addressline2);
			addressline2.click();
			addressline2.clear();
			addressline2.sendKeys(line2);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in address-line2", true);
		}
	}
	
	public void enterAddressLine3(String line3) {
		try {
			Generics.waitForElement(driver, addressline3);
			addressline3.click();
			addressline3.clear();
			addressline3.sendKeys(line3);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in address-line3", true);
		}
	}
	
	public void enterAddressState(String state) {
		try {
			Generics.waitForElement(driver, addressstate);
			addressstate.click();
			//addressstate.clear();
			addressstate.sendKeys(state);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in address-state", true);
		}
	}
	
	public void enterAddressCity(String city) {
		try {
			Generics.waitForElement(driver, addresscity);
			addresscity.click();
			addresscity.clear();
			addresscity.sendKeys(city);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in address-city", true);
		}
	}
	
	public void enterAddressZipcode(String zipcode) {
		try {
			Generics.waitForElement(driver, addresscity);
			addresszipcode.click();
			addresszipcode.clear();
			addresszipcode.sendKeys(zipcode);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in address-zipcode", true);
		}
	}
	
	public void clickSubmit() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in clickSubmit", true);
		}
	}
	//
	public void enterPersonalAddress(String personaladdressline1, String personaladdressline2, String personaladdressline3, String subdistrict,
			String district, String state, String city, String country, String zipcode, String year, String month, String date, String ownershiptype,
			String addresstype) {
		try {
			Generics.waitForElement(driver, addressline1);
			addressline1.click();
			addressline1.clear();
			addressline1.sendKeys(personaladdressline1);
			
			Generics.waitForElement(driver, addressline2);
			addressline2.click();
			addressline2.clear();
			addressline2.sendKeys(personaladdressline2);
			
			Generics.waitForElement(driver, addressline3);
			addressline3.click();
			addressline3.clear();
			addressline3.sendKeys(personaladdressline3);
			
			Generics.waitForElement(driver, subdistrict1);
			subdistrict1.click();
			subdistrict1.clear();
			subdistrict1.sendKeys(subdistrict);
			
			Generics.waitForElement(driver, district1);
			district1.click();
			district1.clear();
			district1.sendKeys(district);
			
			Generics.waitForElement(driver, addressstate);
			Select stateOptions = new Select(addressstate);
			stateOptions.selectByVisibleText(state);
			
			Generics.waitForElement(driver, addresscity);
			addresscity.click();
			addresscity.clear();
			addresscity.sendKeys(city);
			
			Generics.waitForElement(driver, country1);
			country1.click();
			country1.clear();
			country1.sendKeys(country);
			
			Generics.waitForElement(driver, addresszipcode);
			addresszipcode.click();
			addresszipcode.clear();
			addresszipcode.sendKeys(zipcode);
			
			Generics.waitForElement(driver, livingsince1);
			livingsince1.click();
			
			Generics.waitForElement(driver, dobtextbox);
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
			
			Generics.waitForElement(driver, ownershiptype_dropdown);
			Select ownershiptypeoptions = new Select(ownershiptype_dropdown);
			ownershiptypeoptions.selectByVisibleText(ownershiptype);
			
			Generics.waitForElement(driver, addresstype_dropdown);
			Select addressTypeOptions = new Select(addresstype_dropdown);
			addressTypeOptions.selectByVisibleText(addresstype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//2
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
			
			Generics.waitForElement(driver, dobtextbox);
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
	
	public void selectIdentityNumberOneIssueDate(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, idoneissuedatetextbox);
			idoneissuedatetextbox.click();
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
			Reporter.log("selectIdentityNumberOneIssueDate is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectIdentityNumberOneIssueDate", true);
		}
	}
	
	public void selectIdentityNumberTwoIssueDate(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, idtwoissuedatetextbox);
			idtwoissuedatetextbox.click();
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
			Reporter.log("selectIdentityNumberTwoIssueDate is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectIdentityNumberTwoIssueDate", true);
		}
	}
	
	public void enterTextVariableOne(String text1) {
		try {
			//addressline2.click();
			Generics.waitForElement(driver, textvariableonetextbox);
			textvariableonetextbox.click();
			textvariableonetextbox.clear();
			textvariableonetextbox.sendKeys(text1);

		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in text variable one", true);
		}
	}
	public void enterTextVariableTwo(String text2) {
		try {
			//addressline2.click();
			Generics.waitForElement(driver, textvariabletwotextbox);
			textvariabletwotextbox.click();
			textvariabletwotextbox.clear();
			textvariabletwotextbox.sendKeys(text2);

		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in text variable Two", true);
		}
	}
	
	public void enterCitizenship(String citizenof) {
		try {
			//addressline2.click();
			Generics.waitForElement(driver, citizentextbox);
			citizentextbox.click();
			citizentextbox.clear();
			citizentextbox.sendKeys(citizenof);

		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in Citizenship field", true);
		}
	}
	public void selectDateOfBirth(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, dobtextbox);
			dobtextbox.click();
			Generics.waitForElement(driver, yeardropdown);
			yeardropdown.click();
			Select years = new Select(yeardropdown);
			//years.selectByValue(year);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, monthdropdown);
			Select months = new Select(monthdropdown);
			monthdropdown.click();
			//months.selectByValue(month);
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

}
