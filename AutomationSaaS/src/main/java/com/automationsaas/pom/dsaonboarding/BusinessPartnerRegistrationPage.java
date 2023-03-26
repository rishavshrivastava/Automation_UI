package com.automationsaas.pom.dsaonboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class BusinessPartnerRegistrationPage extends Base {

	public WebDriver driver;

	public BusinessPartnerRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1")
	private WebElement headingtext;

	@FindBy(id = "title")
	private WebElement titledropdown;

	@FindBy(id = "firstName")
	private WebElement firstnametextbox;

	@FindBy(id = "lastName")
	private WebElement lastnametextbox;

	@FindBy(id = "username")
	private WebElement emailaddresstextbox;

	@FindBy(id = "password")
	private WebElement passwordtextbox;

	@FindBy(id = "confirmPassword")
	private WebElement confirmpasswordtextbox;

	@FindBy(id = "gender")
	private WebElement genderdropdown;

	@FindBy(xpath = "//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement dateofbirth_year;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement dateofbirth_month;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> dateofbirth_date;

	@FindBy(id = "dsaProfileTextVariable1")
	private WebElement dsaprofiletextvariable1textbox;

	@FindBy(xpath = "//input[contains(@id,'dsaProfileDateVariable')]")
	private WebElement dsaprofiledatevariable1textbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement dsaprofiledatevariable1_year;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement dsaprofiledatevariable1_month;

	@FindBy(xpath = "//b[text()='Personal Address']/../../following-sibling::div/input[@id='line1']")
	private WebElement personaladdressline1textbox;

	@FindBy(xpath = "//b[text()='Personal Address']/../../following-sibling::div/input[@id='line2']")
	private WebElement personaladdressline2textbox;

	@FindBy(xpath = "//b[text()='Personal Address']/../../following-sibling::div/input[@id='line3']")
	private WebElement personaladdressline3textbox;

	@FindBy(id = "subDistrict")
	private WebElement personaladdresssubdistricttextbox;

	@FindBy(id = "district")
	private WebElement personaladdressdistricttextbox;

//	@FindBy(xpath="//b[text()='Personal Address']/../../following-sibling::div/input[@id='state']")
//	private WebElement personaladdressstatetextbox;

	@FindBy(id = "state")
	private WebElement personaladdressstatetextbox;

	@FindBy(xpath = "//b[text()='Personal Address']/../../following-sibling::div/input[@id='city']")
	private WebElement personaladdresscitytextbox;

	@FindBy(id = "country")
	private WebElement personaladdresscountrytextbox;

	@FindBy(xpath = "//b[text()='Personal Address']/../../following-sibling::div/input[@id='zipCode']")
	private WebElement personaladdresszipcodetextbox;

	@FindBy(id = "livingSince")
	private WebElement personaladdresslivingsincetextbox;

	@FindBy(xpath = "//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-year']")
	private WebElement personaladdresslivingsinceyeardropdown;

	@FindBy(xpath = "//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-month']")
	private WebElement personaladdresslivingsincemonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> personaladdresslivingsincedatelinks;

	@FindBy(id = "ownershipType")
	private WebElement personaladdressownershiptypetextbox;

	@FindBy(id = "typeOfAddress")
	private WebElement personaladdressaddresstypetextbox;

	@FindBy(xpath = "//b[text()='Address One']/../../following-sibling::div/input[@id='addressOneLine1']")
	private WebElement addressoneline1textbox;

	@FindBy(xpath = "//b[text()='Address One']/../../following-sibling::div/input[@id='addressOneLine2']")
	private WebElement addressoneline2textbox;

	@FindBy(xpath = "//b[text()='Address One']/../../following-sibling::div/input[@id='addressOneLine3']")
	private WebElement addressoneline3textbox;

	@FindBy(id = "addressOneSubDistrict")
	private WebElement addressonesubdistricttextbox;

	@FindBy(id = "addressOneDistrict")
	private WebElement addressonedistricttextbox;

//	@FindBy(xpath="//b[text()='Address One']/../../following-sibling::div/input[@id='addressOneState']")
//	private WebElement addressonestatetextbox;

	@FindBy(id = "addressOneState")
	private WebElement addressonestatetextbox;

	@FindBy(xpath = "//b[text()='Address One']/../../following-sibling::div/input[@id='addressOneCity']")
	private WebElement addressonecitytextbox;

	@FindBy(id = "addressOneCountry")
	private WebElement addressonecountrytextbox;

	@FindBy(xpath = "//b[text()='Address One']/../../following-sibling::div/input[@id='addressOneZipCode']")
	private WebElement addressonezipcodetextbox;

	@FindBy(id = "addressOneLivingSince")
	private WebElement addressonelivingsincetextbox;

	@FindBy(xpath = "//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-year']")
	private WebElement addressonelivingsinceyeardropdown;

	@FindBy(xpath = "//div[@class='ui-datepicker-title']//select[@class='ui-datepicker-month']")
	private WebElement addressonelivingsincemonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> addressonelivingsincedatelinks;

	@FindBy(id = "addressOneOwnershipType")
	private WebElement addressoneownershiptypetextbox;

	@FindBy(id = "typeOfAddress")
	private WebElement addressoneaddresstypetextbox;

	@FindBy(id = "submit_button")
	private WebElement submitbutton;

	@FindBy(id = "phoneNumber")
	private WebElement phonenumbertextbox;

	// IdentityNumber 1 & 2
	@FindBy(id = "identityNumberOne")
	private WebElement identitynumberonetextbox;

	@FindBy(id = "identityNumberTwo")
	private WebElement identitynumbertwotextbox;

	public void validateHeading(String value) {
		try {
			Generics.waitForElement(driver, headingtext);
			assertEquals(headingtext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectTitle(String value) {
		try {
			Generics.waitForElement(driver, titledropdown);
			Select titleOptions = new Select(titledropdown);
			titleOptions.selectByVisibleText(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterFirstName(String value) {
		try {
			Generics.waitForElement(driver, firstnametextbox);
			firstnametextbox.click();
			firstnametextbox.clear();
			firstnametextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterLastName(String value) {
		try {
			Generics.waitForElement(driver, lastnametextbox);
			lastnametextbox.click();
			lastnametextbox.clear();
			lastnametextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterEmailAddress(String value) {
		try {
			Generics.waitForElement(driver, emailaddresstextbox);
			emailaddresstextbox.click();
			emailaddresstextbox.clear();
			emailaddresstextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPassword(String value) {
		try {
			Generics.waitForElement(driver, passwordtextbox);
			passwordtextbox.click();
			passwordtextbox.clear();
			passwordtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterConfirmPassword(String value) {
		try {
			Generics.waitForElement(driver, confirmpasswordtextbox);
			confirmpasswordtextbox.click();
			confirmpasswordtextbox.clear();
			confirmpasswordtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectGeneder(String value) {
		try {
			Generics.waitForElement(driver, genderdropdown);
			Select genderOptions = new Select(genderdropdown);
			genderOptions.selectByVisibleText(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectDateOfBirth(String yearvalue, String monthvalue, String datevalue) {
		try {
			Generics.waitForElement(driver, dateofbirthtextbox);
			dateofbirthtextbox.click();

			Generics.waitForElement(driver, dateofbirth_year);
			Select yearOptions = new Select(dateofbirth_year);
			yearOptions.selectByVisibleText(yearvalue);

			Generics.waitForElement(driver, dateofbirth_month);
			Select monthOptions = new Select(dateofbirth_month);
			monthOptions.selectByVisibleText(monthvalue);

			for (int i = 0; i < dateofbirth_date.size(); i++) {
				Generics.waitForElement(driver, dateofbirth_date.get(i));
				if (dateofbirth_date.get(i).getText().equalsIgnoreCase(datevalue)) {
					dateofbirth_date.get(i).click();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterDSAProfileTextVariable1(String value) {
		try {
			Generics.waitForElement(driver, dsaprofiletextvariable1textbox);
			dsaprofiletextvariable1textbox.click();
			dsaprofiletextvariable1textbox.clear();
			dsaprofiletextvariable1textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectDSAProfileDateVariable1(String yearvalue, String monthvalue, String datevalue) {
		try {
			Generics.waitForElement(driver, dsaprofiledatevariable1textbox);
			dsaprofiledatevariable1textbox.click();

			Generics.waitForElement(driver, dateofbirth_year);
			Select yearOptions = new Select(dateofbirth_year);
			yearOptions.selectByVisibleText(yearvalue);

			Generics.waitForElement(driver, dateofbirth_month);
			Select monthOptions = new Select(dateofbirth_month);
			monthOptions.selectByVisibleText(monthvalue);

			for (int i = 0; i < dateofbirth_date.size(); i++) {
				Generics.waitForElement(driver, dateofbirth_date.get(i));
				if (dateofbirth_date.get(i).getText().equalsIgnoreCase(datevalue)) {
					dateofbirth_date.get(i).click();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPersonalAddress(String line1value, String line2value, String line3value, String subdistrict,
			String district, String statevalue, String city, String country, String zipcodevalue, String year,
			String month, String date, String ownershiptype, String addresstype) {
		try {
			Generics.waitForElement(driver, personaladdressline1textbox);
			personaladdressline1textbox.click();
			personaladdressline1textbox.clear();
			personaladdressline1textbox.sendKeys(line1value);

			Generics.waitForElement(driver, personaladdressline2textbox);
			personaladdressline2textbox.click();
			personaladdressline2textbox.clear();
			personaladdressline2textbox.sendKeys(line2value);

			Generics.waitForElement(driver, personaladdressline3textbox);
			personaladdressline3textbox.click();
			personaladdressline3textbox.clear();
			personaladdressline3textbox.sendKeys(line3value);
			
			Generics.waitForElement(driver, personaladdresssubdistricttextbox);
			personaladdresssubdistricttextbox.click();
			personaladdresssubdistricttextbox.clear();
			personaladdresssubdistricttextbox.sendKeys(subdistrict);
			
			Generics.waitForElement(driver, personaladdressdistricttextbox);
			personaladdressdistricttextbox.click();
			personaladdressdistricttextbox.clear();
			personaladdressdistricttextbox.sendKeys(district);

			Generics.waitForElement(driver, personaladdressstatetextbox);
			Select stateOptions = new Select(personaladdressstatetextbox);
			stateOptions.selectByVisibleText(statevalue);

			Generics.waitForElement(driver, personaladdresscitytextbox);
			personaladdresscitytextbox.click();
			personaladdresscitytextbox.clear();
			personaladdresscitytextbox.sendKeys(city);
			

			Generics.waitForElement(driver, personaladdresscountrytextbox);
			personaladdresscountrytextbox.click();
			personaladdresscountrytextbox.clear();
			personaladdresscountrytextbox.sendKeys(country);

			Generics.waitForElement(driver, personaladdresszipcodetextbox);
			personaladdresszipcodetextbox.click();
			personaladdresszipcodetextbox.clear();
			personaladdresszipcodetextbox.sendKeys(zipcodevalue);
			
			Generics.waitForElement(driver, personaladdresslivingsincetextbox);
			personaladdresslivingsincetextbox.click();

			Generics.waitForElement(driver, personaladdresslivingsincetextbox);
			Generics.waitForElement(driver, personaladdresslivingsinceyeardropdown);
			Select years = new Select(personaladdresslivingsinceyeardropdown);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, personaladdresslivingsincemonthdropdown);
			Select months = new Select(personaladdresslivingsincemonthdropdown);
			months.selectByVisibleText(month);
			for (int i = 0; i < personaladdresslivingsincedatelinks.size(); i++) {
				if (personaladdresslivingsincedatelinks.get(i).getText().equalsIgnoreCase(date)) {
					personaladdresslivingsincedatelinks.get(i).click();
				}
			}

			Generics.waitForElement(driver, personaladdressownershiptypetextbox);
			Select ownershiptypeoptions = new Select(personaladdressownershiptypetextbox);
			ownershiptypeoptions.selectByVisibleText(ownershiptype);

			Generics.waitForElement(driver, personaladdressaddresstypetextbox);
			Select addressTypeOptions = new Select(personaladdressaddresstypetextbox);
			addressTypeOptions.selectByVisibleText(addresstype);

			
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterAddressOne(String line1value, String line2value, String line3value, String subdistrict,
			String district, String statevalue, String city, String country, String zipcodevalue, String year,
			String month, String date, String ownershiptype, String addresstype) {
		try {
			Generics.waitForElement(driver, addressoneline1textbox);
			addressoneline1textbox.click();
			addressoneline1textbox.clear();
			addressoneline1textbox.sendKeys(line1value);

			Generics.waitForElement(driver, addressoneline2textbox);
			addressoneline2textbox.click();
			addressoneline2textbox.clear();
			addressoneline2textbox.sendKeys(line2value);

			Generics.waitForElement(driver, addressoneline3textbox);
			addressoneline3textbox.click();
			addressoneline3textbox.clear();
			addressoneline3textbox.sendKeys(line3value);

			Generics.waitForElement(driver, addressonesubdistricttextbox);
			addressonesubdistricttextbox.click();
			addressonesubdistricttextbox.clear();
			addressonesubdistricttextbox.sendKeys(subdistrict);

			Generics.waitForElement(driver, addressonedistricttextbox);
			addressonedistricttextbox.click();
			addressonedistricttextbox.clear();
			addressonedistricttextbox.sendKeys(district);

			Generics.waitForElement(driver, addressonestatetextbox);
			Select stateOptions = new Select(addressonestatetextbox);
			stateOptions.selectByVisibleText(statevalue);

			Generics.waitForElement(driver, addressonecitytextbox);
			addressonecitytextbox.click();
			addressonecitytextbox.clear();
			addressonecitytextbox.sendKeys(city);

			Generics.waitForElement(driver, addressonecountrytextbox);
			addressonecountrytextbox.click();
			addressonecountrytextbox.clear();
			addressonecountrytextbox.sendKeys(country);

			Generics.waitForElement(driver, addressonezipcodetextbox);
			addressonezipcodetextbox.click();
			addressonezipcodetextbox.clear();
			addressonezipcodetextbox.sendKeys(zipcodevalue);

			Generics.waitForElement(driver, addressonelivingsincetextbox);
			addressonelivingsincetextbox.click();

			Generics.waitForElement(driver, addressonelivingsincetextbox);
			Generics.waitForElement(driver, addressonelivingsinceyeardropdown);
			Select years = new Select(addressonelivingsinceyeardropdown);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, addressonelivingsincemonthdropdown);
			Select months = new Select(addressonelivingsincemonthdropdown);
			months.selectByVisibleText(month);
			for (int i = 0; i < addressonelivingsincedatelinks.size(); i++) {
				if (addressonelivingsincedatelinks.get(i).getText().equalsIgnoreCase(date)) {
					addressonelivingsincedatelinks.get(i).click();
				}
			}

			Generics.waitForElement(driver, addressoneownershiptypetextbox);
			Select ownershiptypeoptions = new Select(addressoneownershiptypetextbox);
			ownershiptypeoptions.selectByVisibleText(ownershiptype);

			Generics.waitForElement(driver, addressoneaddresstypetextbox);
			Select addressTypeOptions = new Select(addressoneaddresstypetextbox);
			addressTypeOptions.selectByVisibleText(addresstype);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickRegister() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPhoneNumber(String phonenumber) {
		try {
			Generics.waitForElement(driver, phonenumbertextbox);
			phonenumbertextbox.click();
			phonenumbertextbox.clear();
			phonenumbertextbox.sendKeys(phonenumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Identity 1
	public void enterIdentityNumberOne(String value) {
		try {
			Generics.waitForElement(driver, identitynumberonetextbox);
			identitynumberonetextbox.click();
			identitynumberonetextbox.clear();
			identitynumberonetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Identity 2
	public void enterIdentityNumberTwo(String value) {
		try {
			Generics.waitForElement(driver, identitynumbertwotextbox);
			identitynumbertwotextbox.click();
			identitynumbertwotextbox.clear();
			identitynumbertwotextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
