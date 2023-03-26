package com.automationsaas.pom.investoronboarding;

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

public class InvestorRegistrationPage extends Base {

	public WebDriver driver;

	public InvestorRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1")
	private WebElement investorregistrationheading;
	
	@FindBy(id="title")
	private WebElement titledropdown;
	
	@FindBy(id="firstName")
	private WebElement firstnametextbox;
	
	@FindBy(id="lastName")
	private WebElement lastnametextbox;
	
	@FindBy(id="userName")
	private WebElement emailaddresstextbox;
	
	@FindBy(xpath = "//span[text()='Email Id Good To Go !']")
	private WebElement emailaddressavailabilitynotification;
	
	@FindBy(id="gender")
	private WebElement genderdropdown;
	
	@FindBy(id="maritalStatus")
	private WebElement maritialstatusdropdown;
	
	@FindBy(id="contact")
	private WebElement mobilenumbertextbox;
	
	@FindBy(id="password")
	private WebElement passwordtextbox;
	
	@FindBy(id="retypePassword")
	private WebElement confirmpasswordtextbox;
	
	@FindBy(xpath="//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks;
	
	@FindBy(id="investorCategory")
	private WebElement investorcategorydropdown;
	
	@FindBy(id="identityNumberOne")
	private WebElement identitynumberonetextbox;
	
	@FindBy(id="identityNumberTwo")
	private WebElement identitynumbertwotextbox;
	
	@FindBy(id="investorProfileTextVariable1")
	private WebElement investordetailstextvariable1;
	
	@FindBy(id="submit_button")
	private WebElement continuebutton;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	
	public void validateInvestorRegistrationHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, investorregistrationheading);
			if (investorregistrationheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Investor Registration is displayed", true);
			} else
				Reporter.log("Investor Registration is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateInvestorRegistrationHeading", true);
		}
	}
	
	public void selectTitle(String title) {
		try {
			Generics.waitForElement(driver, titledropdown);
			Select titles = new Select(titledropdown);
			titles.selectByVisibleText(title);
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
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterEmailAddress", true);
		}
	}
	
	public void checkAvailabilityOfEmailAddress() {
		try {
			Generics.waitForElement(driver, emailaddressavailabilitynotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in checkAvailabilityOfEmailAddress", true);
		}
	}
	
	public void selectGender(String gender) {
		try {
			Generics.waitForElement(driver, genderdropdown);
			Select genders = new Select(genderdropdown);
			genders.selectByVisibleText(gender);
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
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterMobileNumber", true);
		}
	}
	
	public void enterPassword(String password) {
		try {
			Generics.waitForElement(driver, passwordtextbox);
			passwordtextbox.click();
			passwordtextbox.clear();
			passwordtextbox.sendKeys(password);
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
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterConfirmPassword", true);
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
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectDateOfBirth", true);
		}
	}
	
	public void selectInvestorCategory(String category) {
		try {
			Generics.waitForElement(driver, investorcategorydropdown);
			Select investorCategory = new Select(investorcategorydropdown);
			investorCategory.selectByVisibleText(category);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
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
	
	public void enterInvestorDetailTextVariable1(String text) {
		try {
			Generics.waitForElement(driver, investordetailstextvariable1);
			investordetailstextvariable1.click();
			investordetailstextvariable1.clear();
			investordetailstextvariable1.sendKeys(text);
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
