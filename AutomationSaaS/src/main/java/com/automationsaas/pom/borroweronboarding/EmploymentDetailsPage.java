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

public class EmploymentDetailsPage {

	public WebDriver driver;

	public EmploymentDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement employmentdetailsheading;
	
	@FindBy(id="organizationName")
	private WebElement organisationtextbox;
	
	@FindBy(id="organizationType")
	private WebElement organizationtypedropdown;
	
	@FindBy(id="employmentType")
	private WebElement employmenttypedropdown;
	
	@FindBy(id="department")
	private WebElement departmentdropdown;
	
	@FindBy(id="designation")
	private WebElement designationdropdown;
	
	@FindBy(id="annualIncome")
	private WebElement annualincometextbox;
	
	@FindBy(id="officialEmailId")
	private WebElement officialemailidtextbox;
	
	@FindBy(id="officeLandline")
	private WebElement officiallandlinetextbox;
	
	@FindBy(id="employeeId")
	private WebElement employeeidtextbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable1")
	private WebElement borroweremploymenthistorytextvariable1textbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable2")
	private WebElement borroweremploymenthistorytextvariable2textbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable3")
	private WebElement borroweremploymenthistorytextvariable3textbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable4")
	private WebElement borroweremploymenthistorytextvariable4textbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable5")
	private WebElement borroweremploymenthistorytextvariable5textbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable6")
	private WebElement borroweremploymenthistorytextvariable6textbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable7")
	private WebElement borroweremploymenthistorytextvariable7textbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable8")
	private WebElement borroweremploymenthistorytextvariable8textbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable9")
	private WebElement borroweremploymenthistorytextvariable9textbox;
	
	@FindBy(id="borrowerEmploymentHistoryTextVariable10")
	private WebElement borroweremploymenthistorytextvariable10textbox;
	
	@FindBy(id="borrowerEmploymentHistoryNumberVariable1")
	private WebElement borroweremploymenthistorynumbervariable1textbox;
	
	@FindBy(id="borrowerEmploymentHistoryNumberVariable2")
	private WebElement borroweremploymenthistorynumbervariable2textbox;
	
	@FindBy(id="borrowerEmploymentHistoryNumberVariable3")
	private WebElement borroweremploymenthistorynumbervariable3textbox;
	
	@FindBy(id="borrowerEmploymentHistoryNumberVariable4")
	private WebElement borroweremploymenthistorynumbervariable4textbox;
	
	@FindBy(id="borrowerEmploymentHistoryNumberVariable5")
	private WebElement borroweremploymenthistorynumbervariable5textbox;
	
	@FindBy(xpath="//input[contains(@id,'borrowerEmploymentHistoryDateVariable1')]")
	private WebElement borroweremploymenthistorydatevariable1textbox;
	
	@FindBy(xpath="//input[contains(@id,'borrowerEmploymentHistoryDateVariable2')]")
	private WebElement borroweremploymenthistorydatevariable2textbox;
	
	@FindBy(xpath="//input[contains(@id,'borrowerEmploymentHistoryDateVariable3')]")
	private WebElement borroweremploymenthistorydatevariable3textbox;
	
	@FindBy(xpath="//input[contains(@id,'borrowerEmploymentHistoryDateVariable4')]")
	private WebElement borroweremploymenthistorydatevariable4textbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks;
	
	@FindBy(id="line1")
	private WebElement addresslineonetextbox;
	
	@FindBy(id="line2")
	private WebElement addresslinetwotextbox;
	
	@FindBy(id="line3")
	private WebElement addresslinethreetextbox;
	
	@FindBy(id="subDistrict")
	private WebElement subdistricttextbox;
	
	@FindBy(id="district")
	private WebElement districttextbox;
	
	@FindBy(id="state")
	private WebElement statetextbox;
	
	@FindBy(id="city")
	private WebElement citytextbox;
	
	@FindBy(id="country")
	private WebElement countrytextbox;
	
	@FindBy(id="zipCode")
	private WebElement zipcodetextbox;
	
	@FindBy(id="submit_button")
	private WebElement continuebutton;
	
	@FindBy(id="employmentLivingSince")
	private WebElement livingsincetextbox;
	
	@FindBy(id="ownershipType")
	private WebElement ownershiptypedropdown;
	
	@FindBy(id="typeOfAddress")
	private WebElement addresstypedropdown;
	
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
	
	public void validateEmploymentDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, employmentdetailsheading);
			if (employmentdetailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Employment Details is displayed", true);
			} else
				Reporter.log("Employment Details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateEmploymentDetailsHeading", true);
		}
	}
	
	public void enterOrganisation(String organisation) {
		try {
			Generics.waitForElement(driver, organisationtextbox);
			organisationtextbox.click();
			organisationtextbox.clear();
			organisationtextbox.sendKeys(organisation);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterOrganisation", true);
		}
	}
	
	public void selectOrganisationType(String value) {
		try {
			Generics.waitForElement(driver, organizationtypedropdown);
			Select organisationTypeOptions = new Select(organizationtypedropdown);
			organisationTypeOptions.selectByVisibleText(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectEmploymentType(String value) {
		try {
			Generics.waitForElement(driver, employmenttypedropdown);
			Select employmentTypeOptions = new Select(employmenttypedropdown);
			employmentTypeOptions.selectByVisibleText(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectDepartment(String department) {
		try {
			Generics.waitForElement(driver, departmentdropdown);
			Select departments = new Select(departmentdropdown);
			departments.selectByVisibleText(department);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectDepartment", true);
		}
	}
	
	public void selectDesignation(String designation) {
		try {
			Generics.waitForElement(driver, designationdropdown);
			Select designations = new Select(designationdropdown);
			designations.selectByVisibleText(designation);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectDesignation", true);
		}
	}
	
	public void enterAnnualIncome(String value) {
		try {
			Generics.waitForElement(driver, annualincometextbox);
			annualincometextbox.click();
			annualincometextbox.clear();
			annualincometextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterOfficialEmailId(String value) {
		try {
			Generics.waitForElement(driver, officialemailidtextbox);
			officialemailidtextbox.click();
			officialemailidtextbox.clear();
			officialemailidtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterOfficeLandline(String value) {
		try {
			Generics.waitForElement(driver, officiallandlinetextbox);
			officiallandlinetextbox.click();
			officiallandlinetextbox.clear();
			officiallandlinetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterEmployeeId(String employeeid) {
		try {
			Generics.waitForElement(driver, employeeidtextbox);
			employeeidtextbox.click();
			employeeidtextbox.clear();
			employeeidtextbox.sendKeys(employeeid);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterEmployeeId", true);
		}
	}
	
	public void enterBorrowerEmploymentHistoryTextVariable1(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable1textbox);
			borroweremploymenthistorytextvariable1textbox.click();
			borroweremploymenthistorytextvariable1textbox.clear();
			borroweremploymenthistorytextvariable1textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerEmploymentHistoryTextVariable2(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable2textbox);
			borroweremploymenthistorytextvariable2textbox.click();
			borroweremploymenthistorytextvariable2textbox.clear();
			borroweremploymenthistorytextvariable2textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerEmploymentHistoryTextVariable3(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable3textbox);
			borroweremploymenthistorytextvariable3textbox.click();
			borroweremploymenthistorytextvariable3textbox.clear();
			borroweremploymenthistorytextvariable3textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerEmploymentHistoryTextVariable4(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable4textbox);
			borroweremploymenthistorytextvariable4textbox.click();
			borroweremploymenthistorytextvariable4textbox.clear();
			borroweremploymenthistorytextvariable4textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerEmploymentHistoryTextVariable5(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable5textbox);
			borroweremploymenthistorytextvariable5textbox.click();
			borroweremploymenthistorytextvariable5textbox.clear();
			borroweremploymenthistorytextvariable5textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterBorrowerEmploymentHistoryTextVariable6(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable6textbox);
			borroweremploymenthistorytextvariable6textbox.click();
			borroweremploymenthistorytextvariable6textbox.clear();
			borroweremploymenthistorytextvariable6textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerEmploymentHistoryTextVariable7(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable7textbox);
			borroweremploymenthistorytextvariable7textbox.click();
			borroweremploymenthistorytextvariable7textbox.clear();
			borroweremploymenthistorytextvariable7textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerEmploymentHistoryTextVariable8(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable8textbox);
			borroweremploymenthistorytextvariable8textbox.click();
			borroweremploymenthistorytextvariable8textbox.clear();
			borroweremploymenthistorytextvariable8textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerEmploymentHistoryTextVariable9(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable9textbox);
			borroweremploymenthistorytextvariable9textbox.click();
			borroweremploymenthistorytextvariable9textbox.clear();
			borroweremploymenthistorytextvariable9textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerEmploymentHistoryTextVariable10(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorytextvariable10textbox);
			borroweremploymenthistorytextvariable10textbox.click();
			borroweremploymenthistorytextvariable10textbox.clear();
			borroweremploymenthistorytextvariable10textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterEmploymentHistoryNumberVariable1(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorynumbervariable1textbox);
			borroweremploymenthistorynumbervariable1textbox.click();
			borroweremploymenthistorynumbervariable1textbox.clear();
			borroweremploymenthistorynumbervariable1textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterEmploymentHistoryNumberVariable2(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorynumbervariable2textbox);
			borroweremploymenthistorynumbervariable2textbox.click();
			borroweremploymenthistorynumbervariable2textbox.clear();
			borroweremploymenthistorynumbervariable2textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterEmploymentHistoryNumberVariable3(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorynumbervariable3textbox);
			borroweremploymenthistorynumbervariable3textbox.click();
			borroweremploymenthistorynumbervariable3textbox.clear();
			borroweremploymenthistorynumbervariable3textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterEmploymentHistoryNumberVariable4(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorynumbervariable4textbox);
			borroweremploymenthistorynumbervariable4textbox.click();
			borroweremploymenthistorynumbervariable4textbox.clear();
			borroweremploymenthistorynumbervariable4textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterEmploymentHistoryNumberVariable5(String value) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorynumbervariable5textbox);
			borroweremploymenthistorynumbervariable5textbox.click();
			borroweremploymenthistorynumbervariable5textbox.clear();
			borroweremploymenthistorynumbervariable5textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBorrowerEmploymentHistoryDateVariable1(String date, String month, String year) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorydatevariable1textbox);
			borroweremploymenthistorydatevariable1textbox.click();
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
	
	public void enterBorrowerEmploymentHistoryDateVariable2(String date, String month, String year) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorydatevariable2textbox);
			borroweremploymenthistorydatevariable2textbox.click();
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
	
	public void enterBorrowerEmploymentHistoryDateVariable3(String date, String month, String year) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorydatevariable3textbox);
			borroweremploymenthistorydatevariable3textbox.click();
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
	
	public void enterBorrowerEmploymentHistoryDateVariable4(String date, String month, String year) {
		try {
			Generics.waitForElement(driver, borroweremploymenthistorydatevariable4textbox);
			borroweremploymenthistorydatevariable4textbox.click();
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
			Generics.waitForElement(driver, addresslineonetextbox);
			addresslineonetextbox.click();
			addresslineonetextbox.clear();
			addresslineonetextbox.sendKeys(line1);
			
			Generics.waitForElement(driver, addresslinetwotextbox);
			addresslinetwotextbox.click();
			addresslinetwotextbox.clear();
			addresslinetwotextbox.sendKeys(line2);
			
			Generics.waitForElement(driver, addresslinethreetextbox);
			addresslinethreetextbox.click();
			addresslinethreetextbox.clear();
			addresslinethreetextbox.sendKeys(line3);
			
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
	
	public void clickContinue() {
		try {
			Generics.waitForElement(driver, continuebutton);
			continuebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in clickContinue", true);
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
