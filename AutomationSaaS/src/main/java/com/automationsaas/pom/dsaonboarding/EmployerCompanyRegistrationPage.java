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

public class EmployerCompanyRegistrationPage extends Base {

	public WebDriver driver;

	public EmployerCompanyRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1")
	private WebElement headingtext;

	@FindBy(id = "name")
	private WebElement companynametextbox;

	@FindBy(id = "registrationCode")
	private WebElement registrationcodetextbox;

	@FindBy(id = "dsaCompanyTextVariable1")
	private WebElement dsacompanytextvariable1textbox;

	@FindBy(xpath = "//input[contains(@id,'dsaCompanyDateVariable1')]")
	private WebElement dsacompanydatevariable1textbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement dsacompanydatevariable1yeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement dsacompanydatevariable1monthdropdown;

	@FindBy(xpath = "//a[@class='ui-state-default']")
	private List<WebElement> dsacompanydatevariable1datelinks;

	@FindBy(xpath = "//input[@id='line1']")
	private WebElement line1textbox;

	@FindBy(xpath = "//input[@id='line2']")
	private WebElement line2textbox;

	@FindBy(xpath = "//input[@id='line3']")
	private WebElement line3textbox;

	@FindBy(xpath = "//select[@id='state']")
	private WebElement statetextbox;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement citytextbox;

	@FindBy(id = "subDistrict")
	private WebElement subdistricttextbox;

	@FindBy(id = "district")
	private WebElement districttextbox;

	@FindBy(id = "country")
	private WebElement countrytextbox;

	@FindBy(id = "submit_button")
	private WebElement continuebutton;

	@FindBy(id = "companyAddressLivingSince")
	private WebElement livingsincetextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks;

	@FindBy(id = "ownershipType")
	private WebElement ownershiptypedropdown;

	@FindBy(id = "typeOfAddress")
	private WebElement addresstypedropdown;

	@FindBy(xpath = "//input[@id='zipCode']")
	private WebElement zipcodetextbox;

	@FindBy(xpath = "//button[contains(text(),'Register')]")
	private WebElement registerbutton;

	// IdentityNumber 1 & 2
	@FindBy(id = "companyIdentityNumberOne")
	private WebElement companyidentitynumberonetextbox;

	@FindBy(id = "companyIdentityNumberTwo")
	private WebElement companyidentitynumbertwotextbox;

	public void validateHeading(String value) {
		try {
			Generics.waitForElement(driver, headingtext);
			assertEquals(headingtext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterCompanyName(String value) {
		try {
			Generics.waitForElement(driver, companynametextbox);
			companynametextbox.click();
			companynametextbox.clear();
			companynametextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterRegistrationCode(String value) {
		try {
			Generics.waitForElement(driver, registrationcodetextbox);
			registrationcodetextbox.click();
			registrationcodetextbox.clear();
			registrationcodetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterDSACompanyTextVariable1(String value) {
		try {
			Generics.waitForElement(driver, dsacompanytextvariable1textbox);
			dsacompanytextvariable1textbox.click();
			dsacompanytextvariable1textbox.clear();
			dsacompanytextvariable1textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectDSACompanyDateVariable1(String yearvalue, String monthvalue, String datevalue) {
		try {
			Generics.waitForElement(driver, dsacompanydatevariable1textbox);
			dsacompanydatevariable1textbox.click();

			Generics.waitForElement(driver, dsacompanydatevariable1yeardropdown);
			Select yearOptions = new Select(dsacompanydatevariable1yeardropdown);
			yearOptions.selectByVisibleText(yearvalue);

			Generics.waitForElement(driver, dsacompanydatevariable1monthdropdown);
			Select monthOptions = new Select(dsacompanydatevariable1monthdropdown);
			monthOptions.selectByVisibleText(monthvalue);

			for (int i = 0; i < dsacompanydatevariable1datelinks.size(); i++) {
				Generics.waitForElement(driver, dsacompanydatevariable1datelinks.get(i));
				if (dsacompanydatevariable1datelinks.get(i).getText().equalsIgnoreCase(datevalue)) {
					dsacompanydatevariable1datelinks.get(i).click();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterAddress(String line1, String line2, String line3, String subdistrict, String district,
			String state, String city, String country, String zipcode, String year,String month,String date,
			String ownershiptype, String addresstype) {
		try {
			Generics.waitForElement(driver, line1textbox);
			line1textbox.click();
			line1textbox.clear();
			line1textbox.sendKeys(line1);

			Generics.waitForElement(driver, line2textbox);
			line2textbox.click();
			line2textbox.clear();
			line2textbox.sendKeys(line2);

			Generics.waitForElement(driver, line3textbox);
			line3textbox.click();
			line3textbox.clear();
			line3textbox.sendKeys(line3);

			Generics.waitForElement(driver, subdistricttextbox);
			subdistricttextbox.click();
			subdistricttextbox.clear();
			subdistricttextbox.sendKeys(subdistrict);

			Generics.waitForElement(driver, districttextbox);
			districttextbox.click();
			districttextbox.clear();
			districttextbox.sendKeys(district);

			Generics.waitForElement(driver, statetextbox);
			Select stateOptions = new Select(statetextbox);
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
			for (int i = 0; i < datelinks.size(); i++) {
				if (datelinks.get(i).getText().equalsIgnoreCase(date)) {
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
		}
	}

	public void clickRegister() {
		try {
			Generics.waitForElement(driver, registerbutton);
			registerbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Identity 1
	public void enterCompanyIdentityNumberOne(String value) {
		try {
			Generics.waitForElement(driver, companyidentitynumberonetextbox);
			companyidentitynumberonetextbox.click();
			companyidentitynumberonetextbox.clear();
			companyidentitynumberonetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Identity 2
	public void enterCompanyIdentityNumberTwo(String value) {
		try {
			Generics.waitForElement(driver, companyidentitynumbertwotextbox);
			companyidentitynumbertwotextbox.click();
			companyidentitynumbertwotextbox.clear();
			companyidentitynumbertwotextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
