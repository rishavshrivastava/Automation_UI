package com.automationsaas.pom.borrower;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class CompanyRepresentativePage extends Base {

	public WebDriver driver;

	public CompanyRepresentativePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@id='companyRepresentativeTabId']")
	private WebElement companyrepresentativetab;

	@FindBy(xpath = "//a[contains(text(),'Share Holder')]")
	private WebElement shareholderaccordion;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_ADDRESS_ONE']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[.='Address One']/preceding-sibling::th)+1]")
	private List<WebElement> validateaddressone;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_EMAIL']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[@id='COMPANY_REPRESENTATIVE_EMAIL']/preceding-sibling::th)+1]")
	private List<WebElement> validateemail;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_CITIZENSHIP']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[@id='COMPANY_REPRESENTATIVE_CITIZENSHIP']/preceding-sibling::th)+1]")
	private List<WebElement> validatecitizenship;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_ONE']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_ONE']/preceding-sibling::th)+1]")
	private List<WebElement> validateidentitynumberone;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_TWO']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[@id='COMPANY_REPRESENTATIVE_IDENTITY_NUMBER_TWO']/preceding-sibling::th)+1]")
	private List<WebElement> validateidentitynumbertwo;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_DATE_OF_APPOINTMENT']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[@id='COMPANY_REPRESENTATIVE_DATE_OF_APPOINTMENT']/preceding-sibling::th)+1]")
	private List<WebElement> validatedateofappointment;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_MOBILE_NUMBER']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[@id='COMPANY_REPRESENTATIVE_MOBILE_NUMBER']/preceding-sibling::th)+1]")
	private List<WebElement> validatemobilenumber;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_FIRST_NAME']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[@id='COMPANY_REPRESENTATIVE_FIRST_NAME']/preceding-sibling::th)+1]")
	private List<WebElement> validatefirstname;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_LAST_NAME']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[@id='COMPANY_REPRESENTATIVE_LAST_NAME']/preceding-sibling::th)+1]")
	private List<WebElement> validatelastname;

	@FindBy(xpath = "//th[@id='COMPANY_REPRESENTATIVE_DATE_OF_BIRTH']//ancestor::thead//following-sibling::tbody/tr/td[count(//tr/th[@id='COMPANY_REPRESENTATIVE_DATE_OF_BIRTH']/preceding-sibling::th)+1]")
	private List<WebElement> validatedob;

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

	@FindBy(xpath = "//button[contains(@id,'delete_representative')]")
	private List<WebElement> deleteshareholderbutton;

	@FindBy(xpath = "//a[contains(text(),'Share Holder')]//parent::div//following-sibling::div/button[contains(@id,'openRepresentativeModalBtn')]")
	private WebElement createshareholderbutton;

	@FindBy(xpath = "//button[@id='saveRepresentativeBtn']")
	private WebElement createshareholdercontinuebutton;

	@FindBy(xpath = "//span[contains(text(),'Created Successfully')]")
	private WebElement createshareholdernotification;

	@FindBy(xpath = "//div[@id='AccordShareHolder']//b[contains(text(),'No records found')]")
	private WebElement noshareholderdisplayed;

	public void clickCompanyRepresentativeTab() {
		try {
			Generics.waitForElement(driver, companyrepresentativetab);
			companyrepresentativetab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickshareHolderAccordion() {
		try {
			Generics.waitForElement(driver, shareholderaccordion);
			shareholderaccordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateShareHolderDetails(int n, int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, validateidentitynumbertwo.get(n));
				assertEquals(validateidentitynumbertwo.get(n).getText(), product);
				break;
			case 1:
				Generics.waitForElement(driver, validateemail.get(n));
				assertEquals(validateemail.get(n).getText(), product);
				break;
			case 2:
				Generics.waitForElement(driver, validatecitizenship.get(n));
				assertEquals(validatecitizenship.get(n).getText(), product);
				break;
			case 3:
				Generics.waitForElement(driver, validatedateofappointment.get(n));
				assertEquals(validatedateofappointment.get(n).getText(), product);
				break;
			case 4:
				Generics.waitForElement(driver, validatemobilenumber.get(n));
				assertEquals(validatemobilenumber.get(n).getText(), product);
				break;
			case 5:
				Generics.waitForElement(driver, validatedob.get(n));
				assertEquals(validatedob.get(n).getText(), product);
				break;
			case 6:
				Generics.waitForElement(driver, validateaddressone.get(n));
				assertEquals(validateaddressone.get(n).getText(), product);
				break;
			case 7:
				Generics.waitForElement(driver, validatefirstname.get(n));
				assertEquals(validatefirstname.get(n).getText(), product);
				break;
			case 8:
				Generics.waitForElement(driver, validateidentitynumberone.get(n));
				assertEquals(validateidentitynumberone.get(n).getText(), product);
				break;
			case 9:
				Generics.waitForElement(driver, validatelastname.get(n));
				assertEquals(validatelastname.get(n).getText(), product);
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getShareholderCount() {
		return Generics.getElementCount(validatefirstname);
	}

	public void clickShareHolderEditButton(int n) {
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

	public void clickDeleteShareHolder(String action, int n) {
		try {
			Generics.waitForElement(driver, deleteshareholderbutton.get(n));
			deleteshareholderbutton.get(n).click();
			Generics.alertAction(driver, action);
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

	public void clickCreateShareHolderContinueButton() {
		try {
			Generics.waitForElement(driver, createshareholdercontinuebutton);
			createshareholdercontinuebutton.click();
			Generics.waitForElement(driver, createshareholdernotification);
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
