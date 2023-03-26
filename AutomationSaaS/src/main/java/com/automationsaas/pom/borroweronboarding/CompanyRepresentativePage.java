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

public class CompanyRepresentativePage {

	public WebDriver driver;

	public CompanyRepresentativePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1")
	private WebElement companyrepresenttaiveheading;

	@FindBy(xpath = "(//button[@id='openRepresentativeModalBtn'])[1]")
	private WebElement createceobutton;

	@FindBy(xpath = "//a[contains(text(),'Share Holder')]//parent::div//following-sibling::div/button[@id='openRepresentativeModalBtn']")
	private WebElement createshareholderbutton;

	@FindBy(id = "firstName")
	private WebElement ceofirstnametextbox;

	@FindBy(id = "lastName")
	private WebElement ceolastnametextbox;

	@FindBy(id = "emailAddress")
	private WebElement ceoemailaddresstextbox;

	@FindBy(id = "mobileNumber")
	private WebElement ceomobilenumbertextbox;

	@FindBy(xpath = "//input[contains(@id,'companyRepresentativeDateOfBirth')]")
	private WebElement ceodobtextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement ceodobyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement ceodobmonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> ceodobdatealllinks;

	@FindBy(id = "citizenship")
	private WebElement ceocitizenshiptextbox;

	@FindBy(id = "identityNumberOne")
	private WebElement ceoidentitynumberonetextbox;

	@FindBy(id = "identityNumberTwo")
	private WebElement ceoidentitynumbertwotextbox;

	@FindBy(xpath = "//input[contains(@id,'dateOfAppointment')]")
	private WebElement ceodateofappointmenttextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement ceodateofappointmentyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement ceodateofappointmentmonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> ceodateofappointmentdatealllinks;

	@FindBy(id = "directorTextVariable1")
	private WebElement ceotextvariable1textbox;

	@FindBy(xpath = "//input[contains(@id,'directorDateVariable1')]")
	private WebElement ceodatevariable1textbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement ceodatevariable1yeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement ceodatevariable1monthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> ceodatevariable1datealllinks;

	@FindBy(id = "addressOneLine1")
	private WebElement ceoaddressoneline1;

	@FindBy(id = "addressOneLine2")
	private WebElement ceoaddressoneline2;

	@FindBy(id = "addressOneLine3")
	private WebElement ceoaddressoneline3;

	@FindBy(id = "addressOneDistrict")
	private WebElement ceoaddressonedistrict;

	@FindBy(id = "addressOneSubDistrict")
	private WebElement ceoaddressonesubdistrict;

	@FindBy(id = "addressOneState")
	private WebElement ceoaddressonestate;

	@FindBy(id = "addressOneCity")
	private WebElement ceoaddressonecity;

	@FindBy(id = "addressOneCountry")
	private WebElement ceoaddressonecountry;

	@FindBy(id = "addressOneZipCode")
	private WebElement ceoaddressonezipcode;

	@FindBy(id = "addressOneOwnershipType")
	private WebElement ceoaddressoneownershiptype;

	@FindBy(id = "addressOneTypeOfAddress")
	private WebElement ceoaddressonetypeofaddress;

	@FindBy(id = "directorAddressOneLivingSince")
	private WebElement ceolivingsincetextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement ceolivingsinceyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement ceolivingsincemonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> ceolivingsincedatealllinks;

	@FindBy(xpath = "//a[contains(text(),'CEO')]")
	private WebElement ceoaccordion;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_DATE_OF_BIRTH']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Date of birth']/preceding-sibling::th)+1]")
	private WebElement ceodobvalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_ADDRESS_ONE']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Address One']/preceding-sibling::th)+1]")
	private WebElement ceoaddressonevalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_ONE']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Company Representative Table Identity One']/preceding-sibling::th)+1]")
	private WebElement ceoidentitynumberonevalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_CITIZENSHIP']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Citizenship']/preceding-sibling::th)+1]")
	private WebElement ceocitizenshipvalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_DATE_VARIABLE_1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Company Representative Date Variable 1']/preceding-sibling::th)+1]")
	private WebElement ceodatevariableonevalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_MOBILE_NUMBER']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='MObile Number']/preceding-sibling::th)+1]")
	private WebElement ceomobilenumbervalidate;

	// Divya

	@FindBy(xpath = "//th[contains(text(),'First Name')]/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='First Name']/preceding-sibling::th)+1]")
	private WebElement ceofirstnamevalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_LAST_NAME']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Last Name']/preceding-sibling::th)+1]")
	private WebElement ceolastnamevalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_EMAIL']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)+1]")
	private WebElement ceoemailvalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_TWO']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Company Representative Table Identity Two']/preceding-sibling::th)+1]")
	private WebElement ceoidentitynumbertwovalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_DATE_OF_APPOINTMENT']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Date of appointment']/preceding-sibling::th)+1]")
	private WebElement ceodateofappointmentvalidate;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_TEXT_VARIABLE_1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Company Representative Text Variable 1']/preceding-sibling::th)+1]")
	private WebElement ceotextvariableonevalidate;

	@FindBy(xpath = "//div[@id='AccordCEO']//table/tbody/tr/td/button[contains(text(),'Edit')]")
	private WebElement editceobutton;

	@FindBy(xpath = "//div[@id='AccordShareHolder']//table/tbody/tr/td/button[contains(text(),'Edit')]")
	private WebElement editshareholderbutton;

	@FindBy(xpath = "//div[@id='AccordCEO']//table/tbody/tr/td/button[contains(text(),'Delete')]")
	private WebElement deleteceobutton;

	@FindBy(xpath = "//div[@id='AccordShareHolder']//table/tbody/tr/td/button[contains(text(),'Delete')]")
	private WebElement deleteshareholderbutton;

	@FindBy(id = "saveRepresentativeBtn")
	private WebElement ceocontinuebutton;

	@FindBy(id = "updateRepresentativeBtn")
	private WebElement editceocontinuebutton;

	@FindBy(xpath = "//span[contains(text(),'Created Successfully')]")
	private WebElement ceocreatednotification;

	@FindBy(xpath = "//span[contains(text(),'Updated Successfully')]")
	private WebElement ceoupdatenotification;

	@FindBy(xpath = "//span[contains(text(),'Created Successfully')]")
	private WebElement shareholdercreatednotification;

	@FindBy(xpath = "//span[contains(text(),'Updated Successfully')]")
	private WebElement shareholderupdatenotification;

	@FindBy(xpath = "//a[contains(text(),'Share Holder')]")
	private WebElement shareholderaccordion;

	@FindBy(id = "firstName")
	private WebElement shareholderfirstnametextbox;

	@FindBy(id = "lastName")
	private WebElement shareholderlastnametextbox;

	@FindBy(id = "emailAddress")
	private WebElement shareholderemailaddresstextbox;

	@FindBy(id = "mobileNumber")
	private WebElement shareholdermobilenumbertextbox;

	@FindBy(xpath = "//input[contains(@id,'companyRepresentativeDateOfBirth')]")
	private WebElement shareholderdobtextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement shareholderdobyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement shareholderdobmonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> shareholderdobdatealllinks;

	@FindBy(id = "citizenship")
	private WebElement shareholdercitizenshiptextbox;

	@FindBy(id = "identityNumberOne")
	private WebElement shareholderidentitynumberonetextbox;

	@FindBy(id = "identityNumberTwo")
	private WebElement shareholderidentitynumbertwotextbox;

	@FindBy(xpath = "//input[contains(@id,'dateOfAppointment')]")
	private WebElement shareholderdateofappointmenttextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement shareholderdateofappointmentyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement shareholderdateofappointmentmonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> shareholderdateofappointmentdatealllinks;

	@FindBy(id = "directorTextVariable2")
	private WebElement shareholdertextvariable1textbox;

	@FindBy(xpath = "//input[contains(@id,'directorDateVariable2')]")
	private WebElement shareholderdatevariable1textbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement shareholderdatevariable1yeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement shareholderdatevariable1monthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> shareholderdatevariable1datealllinks;

	@FindBy(id = "addressOneLine1")
	private WebElement shareholderaddressoneline1;

	@FindBy(id = "addressOneLine2")
	private WebElement shareholderaddressoneline2;

	@FindBy(id = "addressOneLine3")
	private WebElement shareholderaddressoneline3;

	@FindBy(id = "addressOneDistrict")
	private WebElement shareholderaddressonedistrict;

	@FindBy(id = "addressOneSubDistrict")
	private WebElement shareholderaddressonesubdistrict;

	@FindBy(id = "addressOneState")
	private WebElement shareholderaddressonestate;

	@FindBy(id = "addressOneCity")
	private WebElement shareholderaddressonecity;

	@FindBy(id = "addressOneCountry")
	private WebElement shareholderaddressonecountry;

	@FindBy(id = "addressOneZipCode")
	private WebElement shareholderaddressonezipcode;

	@FindBy(id = "addressOneOwnershipType")
	private WebElement shareholderaddressoneownershiptype;

	@FindBy(id = "addressOneTypeOfAddress")
	private WebElement shareholderaddressonetypeofaddress;

	@FindBy(id = "directorAddressOneLivingSince")
	private WebElement shareholderlivingsincetextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement shareholderlivingsinceyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement shareholderlivingsincemonthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> shareholderlivingsincedatealllinks;

	@FindBy(id = "saveRepresentativeBtn")
	private WebElement shareholdercontinuebutton;

	@FindBy(xpath = "//button[@id='updateRepresentativeBtn']")
	private WebElement editshareholdercontinuebutton;

	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continuebutton;

	@FindBy(xpath = "//a[contains(text(),'Skip')]")
	private WebElement skipbutton;

	@FindBy(xpath = "//button[@id='close_modal']")
	private WebElement addceomodalclosebutton;

	@FindBy(xpath = "//button[@id='close_modal']")
	private WebElement addshareholdermodalclosebutton;

	@FindBy(xpath = "(//b[contains(text(),'No records found')])[2]")
	private WebElement shareholdernorecord;

	public void clickSkip() {
		try {
			Generics.waitForElement(driver, skipbutton);
			skipbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCompanyRepresentativeHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, companyrepresenttaiveheading);
			if (companyrepresenttaiveheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Company Representative is displayed", true);
			} else
				Reporter.log("Company Representative is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateCompanyRepresentativeHeading", true);
		}
	}

	public void clickcreateCEO() {
		try {
			Generics.waitForElement(driver, createceobutton);
			createceobutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEOFirstName(String firstname) {
		try {
			Generics.waitForElement(driver, ceofirstnametextbox);
			ceofirstnametextbox.click();
			ceofirstnametextbox.clear();
			ceofirstnametextbox.sendKeys(firstname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEOLastName(String lastname) {
		try {
			Generics.waitForElement(driver, ceolastnametextbox);
			ceolastnametextbox.click();
			ceolastnametextbox.clear();
			ceolastnametextbox.sendKeys(lastname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEOEmailAddress(String emailaddress) {
		try {
			Generics.waitForElement(driver, ceoemailaddresstextbox);
			ceoemailaddresstextbox.click();
			ceoemailaddresstextbox.clear();
			ceoemailaddresstextbox.sendKeys(emailaddress);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEOMobileNumber(String mobilenumber) {
		try {
			Generics.waitForElement(driver, ceomobilenumbertextbox);
			ceomobilenumbertextbox.click();
			ceomobilenumbertextbox.clear();
			ceomobilenumbertextbox.sendKeys(mobilenumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEODob(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, ceodobtextbox);
			ceodobtextbox.click();
			Select yeardropdown = new Select(ceodobyeardropdown);
			yeardropdown.selectByVisibleText(year);
			Select monthdropdown = new Select(ceodobmonthdropdown);
			monthdropdown.selectByVisibleText(month);
			for (int i = 0; i < ceodobdatealllinks.size(); i++) {
				if (ceodobdatealllinks.get(i).getText().equalsIgnoreCase(date)) {
					ceodobdatealllinks.get(i).click();

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEOCitizenship(String citizenship) {
		try {
			Generics.waitForElement(driver, ceocitizenshiptextbox);
			ceocitizenshiptextbox.click();
			ceocitizenshiptextbox.clear();
			ceocitizenshiptextbox.sendKeys(citizenship);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEOIdentityNumberOne(String ceoidentitynumberone) {
		try {
			Generics.waitForElement(driver, ceoidentitynumberonetextbox);
			ceoidentitynumberonetextbox.clear();
			ceoidentitynumberonetextbox.sendKeys(ceoidentitynumberone);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEOIdentityNumberTwo(String ceoidentitynumbertwo) {
		try {
			Generics.waitForElement(driver, ceoidentitynumbertwotextbox);
			ceoidentitynumbertwotextbox.click();
			ceoidentitynumbertwotextbox.clear();
			ceoidentitynumbertwotextbox.sendKeys(ceoidentitynumbertwo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEODateOfAppointment(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, ceodateofappointmenttextbox);
			ceodateofappointmenttextbox.click();
			Select yeardropdown = new Select(ceodateofappointmentyeardropdown);
			yeardropdown.selectByVisibleText(year);
			Select monthdropdown = new Select(ceodateofappointmentmonthdropdown);
			monthdropdown.selectByVisibleText(month);
			for (int i = 0; i < ceodateofappointmentdatealllinks.size(); i++) {
				if (ceodateofappointmentdatealllinks.get(i).getText().equalsIgnoreCase(date)) {
					ceodateofappointmentdatealllinks.get(i).click();

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEOTextVariable1(String ceotextvariable1) {
		try {
			Generics.waitForElement(driver, ceotextvariable1textbox);
			ceotextvariable1textbox.click();
			ceotextvariable1textbox.clear();
			ceotextvariable1textbox.sendKeys(ceotextvariable1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEODateVariable1(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, ceodatevariable1textbox);
			ceodatevariable1textbox.click();
			Select yeardropdown = new Select(ceodatevariable1yeardropdown);
			yeardropdown.selectByVisibleText(year);
			Select monthdropdown = new Select(ceodatevariable1monthdropdown);
			monthdropdown.selectByVisibleText(month);
			for (int i = 0; i < ceodatevariable1datealllinks.size(); i++) {
				if (ceodatevariable1datealllinks.get(i).getText().equalsIgnoreCase(date)) {
					ceodatevariable1datealllinks.get(i).click();

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCEOAddressOne(String line1, String line2, String line3, String subdistrict, String district,
			String state, String city, String country, String zipcode, String year, String month, String date,
			String ownershiptype, String addresstype) {
		try {
			Generics.waitForElement(driver, ceoaddressoneline1);
			ceoaddressoneline1.click();
			ceoaddressoneline1.clear();
			ceoaddressoneline1.sendKeys(line1);

			Generics.waitForElement(driver, ceoaddressoneline2);
			ceoaddressoneline2.click();
			ceoaddressoneline2.clear();
			ceoaddressoneline2.sendKeys(line2);

			Generics.waitForElement(driver, ceoaddressoneline3);
			ceoaddressoneline3.click();
			ceoaddressoneline3.clear();
			ceoaddressoneline3.sendKeys(line3);

			Generics.waitForElement(driver, ceoaddressonesubdistrict);
			ceoaddressonesubdistrict.click();
			ceoaddressonesubdistrict.clear();
			ceoaddressonesubdistrict.sendKeys(subdistrict);

			Generics.waitForElement(driver, ceoaddressonedistrict);
			ceoaddressonedistrict.click();
			ceoaddressonedistrict.clear();
			ceoaddressonedistrict.sendKeys(district);

			Generics.waitForElement(driver, ceoaddressonestate);
			ceoaddressonestate.click();
			Select statedropdown = new Select(ceoaddressonestate);
			statedropdown.selectByVisibleText(state);

			Generics.waitForElement(driver, ceoaddressonecity);
			ceoaddressonecity.click();
			ceoaddressonecity.clear();
			ceoaddressonecity.sendKeys(city);

			Generics.waitForElement(driver, ceoaddressonecountry);
			ceoaddressonecountry.click();
			ceoaddressonecountry.clear();
			ceoaddressonecountry.sendKeys(country);

			Generics.waitForElement(driver, ceoaddressonezipcode);
			ceoaddressonezipcode.click();
			ceoaddressonezipcode.clear();
			ceoaddressonezipcode.sendKeys(zipcode);

			Generics.waitForElement(driver, ceolivingsincetextbox);
			ceolivingsincetextbox.click();

			Generics.waitForElement(driver, ceolivingsinceyeardropdown);
			Select yeardropdown = new Select(ceolivingsinceyeardropdown);
			yeardropdown.selectByVisibleText(year);

			Generics.waitForElement(driver, ceolivingsincemonthdropdown);
			Select monthdropdown = new Select(ceolivingsincemonthdropdown);
			monthdropdown.selectByVisibleText(month);

			for (int i = 0; i < ceolivingsincedatealllinks.size(); i++) {
				if (ceolivingsincedatealllinks.get(i).getText().equalsIgnoreCase(date)) {
					ceolivingsincedatealllinks.get(i).click();
				}
			}

			Generics.waitForElement(driver, ceoaddressoneownershiptype);
			ceoaddressoneownershiptype.click();
			Select ownershiptypedropdown = new Select(ceoaddressoneownershiptype);
			ownershiptypedropdown.selectByVisibleText(ownershiptype);

			Generics.waitForElement(driver, ceoaddressonetypeofaddress);
			ceoaddressonetypeofaddress.click();
			Select addresstypedropdown = new Select(ceoaddressonetypeofaddress);
			addresstypedropdown.selectByVisibleText(addresstype);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddCeoContinue() {
		try {
			Generics.waitForElement(driver, ceocontinuebutton);
			ceocontinuebutton.click();
			Generics.waitForElement(driver, ceocreatednotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCeoAccordion() {
		try {
			Generics.waitForElement(driver, ceoaccordion);
			ceoaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCeoDetails(String firstname, String lastname, String email, String mobilenumber, String dob,
			String citizenship, String ceoidentitynumberone, String ceoidentitynumbertwo, String dateofappointment,
			String ceotextvariable1, String datevariable1, String line1, String line2, String line3, String subdistrict,
			String district, String state, String city, String country, String zipcode, String livingsince,
			String ownershiptype, String addresstype) {
		try {
			Generics.waitForElement(driver, ceofirstnametextbox);
			assertEquals(ceofirstnametextbox.getAttribute("value"), firstname);
			Generics.waitForElement(driver, ceolastnametextbox);
			assertEquals(ceolastnametextbox.getAttribute("value"), lastname);
			Generics.waitForElement(driver, ceoemailaddresstextbox);
			assertEquals(ceoemailaddresstextbox.getAttribute("value"), email);
			Generics.waitForElement(driver, ceomobilenumbertextbox);
			assertEquals(ceomobilenumbertextbox.getAttribute("value"), mobilenumber);
			Generics.waitForElement(driver, ceodobtextbox);
			assertEquals(ceodobtextbox.getAttribute("value"), dob);
			Generics.waitForElement(driver, ceocitizenshiptextbox);
			assertEquals(ceocitizenshiptextbox.getAttribute("value"), citizenship);
			Generics.waitForElement(driver, ceoidentitynumberonetextbox);
			assertEquals(ceoidentitynumberonetextbox.getAttribute("value"), ceoidentitynumberone);
			Generics.waitForElement(driver, ceoidentitynumbertwotextbox);
			assertEquals(ceoidentitynumbertwotextbox.getAttribute("value"), ceoidentitynumbertwo);
			Generics.waitForElement(driver, ceodateofappointmenttextbox);
			assertEquals(ceodateofappointmenttextbox.getAttribute("value"), dateofappointment);
			Generics.waitForElement(driver, ceotextvariable1textbox);
			assertEquals(ceotextvariable1textbox.getAttribute("value"), ceotextvariable1);
			Generics.waitForElement(driver, ceodatevariable1textbox);
			assertEquals(ceodatevariable1textbox.getAttribute("value"), datevariable1);
			Generics.waitForElement(driver, ceoaddressoneline1);
			assertEquals(ceoaddressoneline1.getAttribute("value"), line1);
			Generics.waitForElement(driver, ceoaddressoneline2);
			assertEquals(ceoaddressoneline2.getAttribute("value"), line2);
			Generics.waitForElement(driver, ceoaddressoneline3);
			assertEquals(ceoaddressoneline3.getAttribute("value"), line3);
			Generics.waitForElement(driver, ceoaddressonesubdistrict);
			assertEquals(ceoaddressonesubdistrict.getAttribute("value"), subdistrict);
			Generics.waitForElement(driver, ceoaddressonedistrict);
			assertEquals(ceoaddressonedistrict.getAttribute("value"), district);

			Generics.waitForElement(driver, ceoaddressonestate);
			Select stateoptions = new Select(ceoaddressonestate);
			WebElement addressonestate = stateoptions.getFirstSelectedOption();
			assertEquals(addressonestate.getText(), state);

			Generics.waitForElement(driver, ceoaddressonecity);
			assertEquals(ceoaddressonecity.getAttribute("value"), city);
			Generics.waitForElement(driver, ceoaddressonecountry);
			assertEquals(ceoaddressonecountry.getAttribute("value"), country);
			Generics.waitForElement(driver, ceoaddressonezipcode);
			assertEquals(ceoaddressonezipcode.getAttribute("value"), zipcode);
			Generics.waitForElement(driver, ceolivingsincetextbox);
			assertEquals(ceolivingsincetextbox.getAttribute("value"), livingsince);

			Generics.waitForElement(driver, ceoaddressoneownershiptype);
			Select ownershiptypeoptions = new Select(ceoaddressoneownershiptype);
			WebElement addressoneownershiptype = ownershiptypeoptions.getFirstSelectedOption();
			assertEquals(addressoneownershiptype.getText(), ownershiptype);

			Generics.waitForElement(driver, ceoaddressonetypeofaddress);
			Select addressonetypeofaddressoptions = new Select(ceoaddressonetypeofaddress);
			WebElement addressonetypeofaddress = addressonetypeofaddressoptions.getFirstSelectedOption();
			assertEquals(addressonetypeofaddress.getText(), addresstype);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCeoDetailsTable(String firstname, String lastname, String email, String mobilenumber,
			String dob, String citizenship, String ceoidentitynumberone, String ceoidentitynumbertwo,
			String dateofappointment, String ceotextvariable1, String datevariable1, String addressone) {
		try {
			Generics.waitForElement(driver, ceofirstnamevalidate);
			assertEquals(ceofirstnamevalidate.getText(), firstname);
			Generics.waitForElement(driver, ceolastnamevalidate);
			assertEquals(ceolastnamevalidate.getText(), lastname);
			Generics.waitForElement(driver, ceoemailvalidate);
			assertEquals(ceoemailvalidate.getText(), email);
			Generics.waitForElement(driver, ceomobilenumbervalidate);
			assertEquals(ceomobilenumbervalidate.getText(), mobilenumber);
			Generics.waitForElement(driver, ceodobvalidate);
			assertEquals(ceodobvalidate.getText(), dob);
			Generics.waitForElement(driver, ceocitizenshipvalidate);
			assertEquals(ceocitizenshipvalidate.getText(), citizenship);
			Generics.waitForElement(driver, ceoidentitynumberonevalidate);
			assertEquals(ceoidentitynumberonevalidate.getText(), ceoidentitynumberone);
			Generics.waitForElement(driver, ceoidentitynumbertwovalidate);
			assertEquals(ceoidentitynumbertwovalidate.getText(), ceoidentitynumbertwo);
			Generics.waitForElement(driver, ceodateofappointmentvalidate);
			assertEquals(ceodateofappointmentvalidate.getText(), dateofappointment);
			Generics.waitForElement(driver, ceotextvariableonevalidate);
			assertEquals(ceotextvariableonevalidate.getText(), ceotextvariable1);
			Generics.waitForElement(driver, ceodatevariableonevalidate);
			assertEquals(ceodatevariableonevalidate.getText(), datevariable1);
			Generics.waitForElement(driver, ceoaddressonevalidate);
//			assertEquals(ceoaddressonevalidate.getText(), line1);
//			Generics.waitForElement(driver, ceoaddressoneline2);
//			assertEquals(ceoaddressoneline2.getText(), line2);
//			Generics.waitForElement(driver, ceoaddressoneline3);
//			assertEquals(ceoaddressoneline3.getText(), line3);
//			Generics.waitForElement(driver, ceoaddressonesubdistrict);
//			assertEquals(ceoaddressonesubdistrict.getText(), subdistrict);
//			Generics.waitForElement(driver,ceoaddressonedistrict );
//			assertEquals(ceoaddressonedistrict.getText(), district);
//			Generics.waitForElement(driver, ceoaddressonestate);
//			assertEquals(ceoaddressonestate.getText(), state);
//			Generics.waitForElement(driver, ceoaddressonecity);
//			assertEquals(ceoaddressonecity.getText(), city);
//			Generics.waitForElement(driver, ceoaddressonecountry);
//			assertEquals(ceoaddressonecountry.getText(), country);
//			Generics.waitForElement(driver, ceoaddressonezipcode);
//			assertEquals(ceoaddressonezipcode.getText(), zipcode);
//			Generics.waitForElement(driver, ceoaddressoneownershiptype);
//			assertEquals(ceoaddressoneownershiptype.getText(), livingsince);
//			Generics.waitForElement(driver, ceoaddressonetypeofaddress);
//			assertEquals(ceoaddressonetypeofaddress.getText(), ownershiptype);
//			Generics.waitForElement(driver, ceolivingsincetextbox);
//			assertEquals(ceolivingsincetextbox.getText(), addresstype);
//			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCeoEdit() {
		try {
			Generics.waitForElement(driver, editceobutton);
			editceobutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCeoDelete() {
		try {
			Generics.waitForElement(driver, deleteceobutton);
			deleteceobutton.click();
			driver.switchTo().alert().accept();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickShareHolderEdit() {
		try {
			Generics.waitForElement(driver, editshareholderbutton);
			editshareholderbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickShareHolderDelete() {
		try {
			Generics.waitForElement(driver, deleteshareholderbutton);
			deleteshareholderbutton.click();
			driver.switchTo().alert().accept();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickShareHolderAccordion() {
		try {
			Generics.waitForElement(driver, shareholderaccordion);
			shareholderaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCreateShareHolder() {
		try {
			Generics.waitForElement(driver, createshareholderbutton);
			createshareholderbutton.click();
		} catch (InterruptedException e) {
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

	public void enterShareHolderTextVariable1(String identitynumbertwo) {
		try {
			Generics.waitForElement(driver, shareholdertextvariable1textbox);
			shareholdertextvariable1textbox.click();
			shareholdertextvariable1textbox.clear();
			shareholdertextvariable1textbox.sendKeys(identitynumbertwo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterShareHolderDateVariable1(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, shareholderdatevariable1textbox);
			shareholderdatevariable1textbox.click();
			Select yeardropdown = new Select(shareholderdatevariable1yeardropdown);
			yeardropdown.selectByVisibleText(year);
			Select monthdropdown = new Select(shareholderdatevariable1monthdropdown);
			monthdropdown.selectByVisibleText(month);
			for (int i = 0; i < shareholderdatevariable1datealllinks.size(); i++) {
				if (shareholderdatevariable1datealllinks.get(i).getText().equalsIgnoreCase(date)) {
					shareholderdatevariable1datealllinks.get(i).click();
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

	public void clickAddShareHolderContinue() {
		try {
			Generics.waitForElement(driver, shareholdercontinuebutton);
			shareholdercontinuebutton.click();
			Generics.waitForElement(driver, shareholdercreatednotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickContinue() {
		try {
			Generics.waitForElement(driver, continuebutton);
			continuebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateShareHolderDetails(String firstname, String lastname, String email, String mobilenumber,
			String dob, String citizenship, String identitynumberone, String identitynumbertwo,
			String dateofappointment, String line1, String line2, String line3, String subdistrict, String district,
			String state, String city, String country, String zipcode, String livingsince, String ownershiptype,
			String addresstype) {
		try {
			Generics.waitForElement(driver, ceofirstnametextbox);
			assertEquals(ceofirstnametextbox.getAttribute("value"), firstname);
			Generics.waitForElement(driver, ceolastnametextbox);
			assertEquals(ceolastnametextbox.getAttribute("value"), lastname);
			Generics.waitForElement(driver, ceoemailaddresstextbox);
			assertEquals(ceoemailaddresstextbox.getAttribute("value"), email);
			Generics.waitForElement(driver, ceomobilenumbertextbox);
			assertEquals(ceomobilenumbertextbox.getAttribute("value"), mobilenumber);

			Generics.waitForElement(driver, ceodobtextbox);
			assertEquals(ceodobtextbox.getAttribute("value"), dob);
			Generics.waitForElement(driver, ceocitizenshiptextbox);
			assertEquals(ceocitizenshiptextbox.getAttribute("value"), citizenship);
			Generics.waitForElement(driver, ceoidentitynumberonetextbox);
			assertEquals(ceoidentitynumberonetextbox.getAttribute("value"), identitynumberone);
			Generics.waitForElement(driver, ceoidentitynumbertwotextbox);
			assertEquals(ceoidentitynumbertwotextbox.getAttribute("value"), identitynumbertwo);
			Generics.waitForElement(driver, ceodateofappointmenttextbox);
			assertEquals(ceodateofappointmenttextbox.getAttribute("value"), dateofappointment);
//			Generics.waitForElement(driver, ceotextvariable1textbox);
//			assertEquals(ceotextvariable1textbox.getAttribute("value"), ceotextvariable1);
//			Generics.waitForElement(driver, ceodatevariable1textbox);
//			assertEquals(ceodatevariable1textbox.getAttribute("value"), datevariable1);
			Generics.waitForElement(driver, ceoaddressoneline1);
			assertEquals(ceoaddressoneline1.getAttribute("value"), line1);
			Generics.waitForElement(driver, ceoaddressoneline2);
			assertEquals(ceoaddressoneline2.getAttribute("value"), line2);
			Generics.waitForElement(driver, ceoaddressoneline3);
			assertEquals(ceoaddressoneline3.getAttribute("value"), line3);
			Generics.waitForElement(driver, ceoaddressonesubdistrict);
			assertEquals(ceoaddressonesubdistrict.getAttribute("value"), subdistrict);
			Generics.waitForElement(driver, ceoaddressonedistrict);
			assertEquals(ceoaddressonedistrict.getAttribute("value"), district);

			Generics.waitForElement(driver, ceoaddressonestate);
			Select stateoptions = new Select(ceoaddressonestate);
			WebElement addressonestate = stateoptions.getFirstSelectedOption();
			assertEquals(addressonestate.getText(), state);

			Generics.waitForElement(driver, ceoaddressonecity);
			assertEquals(ceoaddressonecity.getAttribute("value"), city);
			Generics.waitForElement(driver, ceoaddressonecountry);
			assertEquals(ceoaddressonecountry.getAttribute("value"), country);
			Generics.waitForElement(driver, ceoaddressonezipcode);
			assertEquals(ceoaddressonezipcode.getAttribute("value"), zipcode);

			Generics.waitForElement(driver, ceolivingsincetextbox);
			assertEquals(ceolivingsincetextbox.getAttribute("value"), livingsince);

			Generics.waitForElement(driver, ceoaddressoneownershiptype);
			Select ownershiptypeoptions = new Select(ceoaddressoneownershiptype);
			WebElement addressoneownershiptype = ownershiptypeoptions.getFirstSelectedOption();
			assertEquals(addressoneownershiptype.getText(), ownershiptype);

			Generics.waitForElement(driver, ceoaddressonetypeofaddress);
			Select addresstypeoptions = new Select(ceoaddressonetypeofaddress);
			WebElement addressoneaddresstype = addresstypeoptions.getFirstSelectedOption();
			assertEquals(addressoneaddresstype.getText(), addresstype);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickCeoModalClose() {
		try {
			Generics.waitForElement(driver, addceomodalclosebutton);
			addceomodalclosebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickShareHolderModalClose() {
		try {
			Generics.waitForElement(driver, addshareholdermodalclosebutton);
			addshareholdermodalclosebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditCeoContinueButton() {
		try {
			Generics.waitForElement(driver, editceocontinuebutton);
			editceocontinuebutton.click();
			Generics.waitForElement(driver, ceoupdatenotification);
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
	
	public void enterCEODetailsForDSACompanyBorrower(String firstname, String lastname, String email) {
		try {
			Generics.waitForElement(driver,ceofirstnametextbox );
			ceofirstnametextbox.click();
			ceofirstnametextbox.clear();
			ceofirstnametextbox.sendKeys(firstname);
			
			Generics.waitForElement(driver,ceolastnametextbox );
			ceolastnametextbox.click();
			ceolastnametextbox.clear();
			ceolastnametextbox.sendKeys(lastname);
			
			Generics.waitForElement(driver,ceoemailaddresstextbox );
			ceoemailaddresstextbox.click();
			ceoemailaddresstextbox.clear();
			ceoemailaddresstextbox.sendKeys(email);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}

public void enterShareHolderDetailsForDSACompanyBorrower(String firstname, String lastname, String email) {
	try {
		Generics.waitForElement(driver,shareholderfirstnametextbox );
		shareholderfirstnametextbox.click();
		shareholderfirstnametextbox.clear();
		shareholderfirstnametextbox.sendKeys(firstname);
		
		Generics.waitForElement(driver,shareholderlastnametextbox );
		shareholderlastnametextbox.click();
		shareholderlastnametextbox.clear();
		shareholderlastnametextbox.sendKeys(lastname);
		
		Generics.waitForElement(driver,shareholderemailaddresstextbox );
		shareholderemailaddresstextbox.click();
		shareholderemailaddresstextbox.clear();
		shareholderemailaddresstextbox.sendKeys(email);

	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}

}