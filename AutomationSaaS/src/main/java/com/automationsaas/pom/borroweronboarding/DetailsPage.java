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

public class DetailsPage {

	public WebDriver driver;

	public DetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement detailsheading;
	
	@FindBy(id="maritalStatus")
	private WebElement maritalstatusdropdown;
	
	@FindBy(id="mobileNumber")
	private WebElement mobilenumbertextbox;
	
	@FindBy(id="workExperience")
	private WebElement workexperiencetextbox;
	
	@FindBy(id="jobType")
	private WebElement employmentcategorydropdown;
	
	@FindBy(id="grossIncome")
	private WebElement grossincometextbox;
	
	@FindBy(id="transportationExpenses")
	private WebElement transportationexpensestextbox;
	
	@FindBy(id="utilitiesExpenses")
	private WebElement utilitiesexpensestextbox;
	
	@FindBy(id="entertainmentExpenses")
	private WebElement entertainmentexpensestextbox;
	
	@FindBy(id="creditCardExpenses")
	private WebElement creditcardexpensestextbox;
	
	@FindBy(id="identityNumberSeven")
	private WebElement identitynumberseventextbox;
	
	@FindBy(id="identityNumberEight")
	private WebElement identitynumbereighttextbox;
	
	@FindBy(id="borrowerDetailTextVariable1")
	private WebElement borrowerdetailtextvariable1dropdown;
	
	@FindBy(id="borrowerDetailTextVariable2")
	private WebElement borrowerDetailTextVariable2dropdown;
	
	@FindBy(id="borrowerDetailTextVariable3")
	private WebElement borrowerDetailTextVariable3textbox;
	
	@FindBy(id="borrowerDetailTextVariable4")
	private WebElement borrowerDetailTextVariable4textbox;
	
	@FindBy(id="borrowerDetailTextVariable5")
	private WebElement borrowerDetailTextVariable5textbox;
	
	@FindBy(id="borrowerDetailTextVariable6")
	private WebElement borrowerDetailTextVariable6textbox;
	
	@FindBy(id="borrowerDetailNumberVariable1")
	private WebElement borrowerDetailNumberVariable1textbox;
	
	@FindBy(id="line1")
	private WebElement personal_address_line1_textbox;
	
	@FindBy(id="line2")
	private WebElement personal_address_line2_textbox;
	
	@FindBy(id="line3")
	private WebElement personal_address_line3_textbox;
	
	@FindBy(id="subDistrict")
	private WebElement personal_address_subdistrict_textbox;
	
	@FindBy(id="district")
	private WebElement personal_address_district_textbox;
	
	@FindBy(id="state")
	private WebElement personal_address_state_dropdown;
	
	@FindBy(id="city")
	private WebElement personal_address_city_textbox;
	
	@FindBy(id="country")
	private WebElement personal_address_country_textbox;
	
	@FindBy(id="zipCode")
	private WebElement personal_address_zipcode_textbox;
	
	@FindBy(id="livingSince")
	private WebElement personal_address_livingsince_textbox;
	
	@FindBy(id="ownershipType")
	private WebElement personal_address_ownershiptype_dropdown;
	
	@FindBy(id="typeOfAddress")
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
	
	@FindBy(id="personalAddressOneLivingSince")
	private WebElement addressone_livingsince_textbox;
	
	@FindBy(id="addressOneOwnershipType")
	private WebElement addressone_ownershiptype_dropdown;
	
	@FindBy(id="addressOneTypeOfAddress")
	private WebElement addressone_addresstype_dropdowm;
	
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
	private WebElement addresstwo_zipcode_textbox;
	
	@FindBy(id="personalAddressTwoLivingSince")
	private WebElement addresstwo_livingsince_textbox;
	
	@FindBy(id="addressTwoOwnershipType")
	private WebElement addresstwo_ownershiptype_dropdown;
	
	@FindBy(id="addressTwoTypeOfAddress")
	private WebElement addresstwo_addresstype_dropdown;
	
	@FindBy(id="addressThreeLine1")
	private WebElement addressthree_line1_textbox;
	
	@FindBy(id="addressThreeLine2")
	private WebElement addressthree_line2_textbox;
	
	@FindBy(id="addressThreeLine3")
	private WebElement addressthree_line3_textbox;
	
	@FindBy(id="addressThreeSubDistrict")
	private WebElement addressthree_subdistrict_textbox;
	
	@FindBy(id="addressThreeDistrict")
	private WebElement addressthree_district_textbox;
	
	@FindBy(id="addressThreeState")
	private WebElement addressthree_state_dropdowm;
	
	@FindBy(id="addressThreeCity")
	private WebElement addressthree_city_textbox;
	
	@FindBy(id="addressThreeCountry")
	private WebElement addressthree_country_textbox;
	
	@FindBy(id="addressThreeZipCode")
	private WebElement addressthree_zipcode_textbox;
	
	@FindBy(id="personalAddressThreeLivingSince")
	private WebElement addressthree_livingsince_textbox;
	
	@FindBy(id="addressThreeOwnershipType")
	private WebElement addressthree_ownershiptype_dropdown;
	
	@FindBy(id="addressThreeTypeOfAddress")
	private WebElement addressthree_typeofaddress_dropdown;
	
	@FindBy(xpath = "//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebutton;
	
	@FindBy(id="numberOfDependents")
	private WebElement numberofdependentstextbox;
	
	@FindBy(id="employerType")
	private WebElement employertypedropdown;
	
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
	
	public void validateDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, detailsheading);
			if (detailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Details is displayed", true);
			} else
				Reporter.log("Details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateDetailsHeading", true);
		}
	}
	
	public void enterWorkExperience(String workexperience) {
		try {
			Generics.waitForElement(driver, workexperiencetextbox);
			workexperiencetextbox.click();
			workexperiencetextbox.clear();
			workexperiencetextbox.sendKeys(workexperience);
			Reporter.log("selectWorkExperience is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectWorkExperience", true);
		}
	}
	
	public void selectEmploymentCategory(String employmentcategory) {
		try {
			Generics.waitForElement(driver, employmentcategorydropdown);
			Select employementCategory = new Select(employmentcategorydropdown);
			employementCategory.selectByVisibleText(employmentcategory);
			Reporter.log("selectEmploymentCategory is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectEmploymentCategory", true);
		}
	}
	
	public void enterGrossIncome(String grossincome) {
		try {
			Generics.waitForElement(driver, grossincometextbox);
			grossincometextbox.click();
			grossincometextbox.clear();
			grossincometextbox.sendKeys(grossincome);
			Reporter.log("enterGrossIncome is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterGrossIncome", true);
		}
	}
	
	public void selectEmployerType(String value) {
		try {
			Generics.waitForElement(driver, employertypedropdown);
			Select employerTypeOptions = new Select(employertypedropdown);
			employerTypeOptions.selectByVisibleText(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterTransportationExpenses(String value) {
		try {
			Generics.waitForElement(driver, transportationexpensestextbox);
			transportationexpensestextbox.click();
			transportationexpensestextbox.clear();
			transportationexpensestextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterUtilitiesExpenses(String value) {
		try {
			Generics.waitForElement(driver, utilitiesexpensestextbox);
			utilitiesexpensestextbox.click();
			utilitiesexpensestextbox.clear();
			utilitiesexpensestextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterEntertainmentExpenses(String value) {
		try {
			Generics.waitForElement(driver, entertainmentexpensestextbox);
			entertainmentexpensestextbox.click();
			entertainmentexpensestextbox.clear();
			entertainmentexpensestextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterCreditCardExpenses(String value) {
		try {
			Generics.waitForElement(driver, creditcardexpensestextbox);
			creditcardexpensestextbox.click();
			creditcardexpensestextbox.clear();
			creditcardexpensestextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterNumberOfDependents(String value) {
		try {
			Generics.waitForElement(driver, numberofdependentstextbox);
			numberofdependentstextbox.click();
			numberofdependentstextbox.clear();
			numberofdependentstextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void enterIdentityNumberSeven(String value) {
		try {
			Generics.waitForElement(driver, identitynumberseventextbox);
			identitynumberseventextbox.click();
			identitynumberseventextbox.clear();
			identitynumberseventextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIdentityNumberEight(String value) {
			try {
				Generics.waitForElement(driver, identitynumbereighttextbox);
				identitynumbereighttextbox.click();
				identitynumbereighttextbox.clear();
				identitynumbereighttextbox.sendKeys(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public void selectBorrowerDetailTextVariable1(String value) {
		try {
			Generics.waitForElement(driver, borrowerdetailtextvariable1dropdown);
			Select borrowerdetailtextvariable1Options = new Select(borrowerdetailtextvariable1dropdown);
			borrowerdetailtextvariable1Options.selectByVisibleText(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectBorrowerDetailTextVariable2(String value) {
		try {
			Generics.waitForElement(driver, borrowerDetailTextVariable2dropdown);
			Select borrowerDetailTextVariable2Options = new Select(borrowerDetailTextVariable2dropdown);
			borrowerDetailTextVariable2Options.selectByVisibleText(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerDetailTextVariable3(String value) {
		try {
			Generics.waitForElement(driver, borrowerDetailTextVariable3textbox);
			borrowerDetailTextVariable3textbox.click();
			borrowerDetailTextVariable3textbox.clear();
			borrowerDetailTextVariable3textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerDetailTextVariable4(String value) {
		try {
			Generics.waitForElement(driver, borrowerDetailTextVariable4textbox);
			borrowerDetailTextVariable4textbox.click();
			borrowerDetailTextVariable4textbox.clear();
			borrowerDetailTextVariable4textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerTextVariable5(String value) {
		try {
			Generics.waitForElement(driver, borrowerDetailTextVariable5textbox);
			borrowerDetailTextVariable5textbox.click();
			borrowerDetailTextVariable5textbox.clear();
			borrowerDetailTextVariable5textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerTextVariable6(String value) {
		try {
			Generics.waitForElement(driver, borrowerDetailTextVariable6textbox);
			borrowerDetailTextVariable6textbox.click();
			borrowerDetailTextVariable6textbox.clear();
			borrowerDetailTextVariable6textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerDetailNumberVariable1(String value) {
		try {
			Generics.waitForElement(driver, borrowerDetailNumberVariable1textbox);
			borrowerDetailNumberVariable1textbox.click();
			borrowerDetailNumberVariable1textbox.clear();
			borrowerDetailNumberVariable1textbox.sendKeys(value);
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
			
			Generics.waitForElement(driver, addressone_addresstype_dropdowm);
			Select addressTypeOptions = new Select(addressone_addresstype_dropdowm);
			addressTypeOptions.selectByVisibleText(addresstype);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
			
			Generics.waitForElement(driver, addresstwo_zipcode_textbox);
			addresstwo_zipcode_textbox.click();
			addresstwo_zipcode_textbox.clear();
			addresstwo_zipcode_textbox.sendKeys(zipcode);
			
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
	
	public void enterAddressThree(String personaladdressline1, String personaladdressline2, String personaladdressline3, String subdistrict,
			String district, String state, String city, String country, String zipcode, String year, String month, String date, String ownershiptype,
			String addresstype) {
		try {
			Generics.waitForElement(driver, addressthree_line1_textbox);
			addressthree_line1_textbox.click();
			addressthree_line1_textbox.clear();
			addressthree_line1_textbox.sendKeys(personaladdressline1);
			
			Generics.waitForElement(driver, addressthree_line2_textbox);
			addressthree_line2_textbox.click();
			addressthree_line2_textbox.clear();
			addressthree_line2_textbox.sendKeys(personaladdressline2);
			
			Generics.waitForElement(driver, addressthree_line3_textbox);
			addressthree_line3_textbox.click();
			addressthree_line3_textbox.clear();
			addressthree_line3_textbox.sendKeys(personaladdressline3);
			
			Generics.waitForElement(driver, addressthree_subdistrict_textbox);
			addressthree_subdistrict_textbox.click();
			addressthree_subdistrict_textbox.clear();
			addressthree_subdistrict_textbox.sendKeys(subdistrict);
			
			Generics.waitForElement(driver, addressthree_district_textbox);
			addressthree_district_textbox.click();
			addressthree_district_textbox.clear();
			addressthree_district_textbox.sendKeys(district);
			
			Generics.waitForElement(driver, addressthree_state_dropdowm);
			Select stateOptions = new Select(addressthree_state_dropdowm);
			stateOptions.selectByVisibleText(state);
			
			Generics.waitForElement(driver, addressthree_city_textbox);
			addressthree_city_textbox.click();
			addressthree_city_textbox.clear();
			addressthree_city_textbox.sendKeys(city);
			
			Generics.waitForElement(driver, addressthree_country_textbox);
			addressthree_country_textbox.click();
			addressthree_country_textbox.clear();
			addressthree_country_textbox.sendKeys(country);
			
			Generics.waitForElement(driver, addressthree_zipcode_textbox);
			addressthree_zipcode_textbox.click();
			addressthree_zipcode_textbox.clear();
			addressthree_zipcode_textbox.sendKeys(zipcode);
			
			Generics.waitForElement(driver, addressthree_livingsince_textbox);
			addressthree_livingsince_textbox.click();
			
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
			
			Generics.waitForElement(driver, addressthree_ownershiptype_dropdown);
			Select ownershiptypeoptions = new Select(addressthree_ownershiptype_dropdown);
			ownershiptypeoptions.selectByVisibleText(ownershiptype);
			
			Generics.waitForElement(driver, addressthree_typeofaddress_dropdown);
			Select addressTypeOptions = new Select(addressthree_typeofaddress_dropdown);
			addressTypeOptions.selectByVisibleText(addresstype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickContinueButton() {
		try {
			Generics.waitForElement(driver, continuebutton);
			continuebutton.click();
			Reporter.log("clickContinueButton is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in clickContinueButton", true);
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */
	public void clearGrossIncome() {
		try {
			Generics.waitForElement(driver, grossincometextbox);
			grossincometextbox.clear();
			Reporter.log("clearGrossIncome is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in clearing grossincometextbox", true);
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
