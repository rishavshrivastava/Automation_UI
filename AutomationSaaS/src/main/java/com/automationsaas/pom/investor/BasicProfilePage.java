package com.automationsaas.pom.investor;

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

public class BasicProfilePage extends Base {

	public WebDriver driver;
	public BasicProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Basic Profile']")
	private WebElement basicprofiletab;
	
	@FindBy(id="emailAddress")
	private WebElement emailaddresstext;
	
	@FindBy(id="title")
	private WebElement titledropdown;
	
	@FindBy(id="firstName")
	private WebElement firstnametextbox;
	
	@FindBy(id="lastName")
	private WebElement lastnametextbox;
	
	@FindBy(xpath="//input[contains(@id,'dateOfBirth')]")
	private WebElement dateofbirthtextbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//a")
	private List<WebElement> datelinks;
	
	@FindBy(id="gender")
	private WebElement genderdropdown;
	
	@FindBy(id="maritalStatus")
	private WebElement martialstatusdropdown;
	
	@FindBy(id="contact")
	private WebElement mobilenumbertextbox;
	
	@FindBy(id="identityNumberOne")
	private WebElement identitynumberonetextbox;
	
	@FindBy(id="identityNumberTwo")
	private WebElement identitynumbertwotextbox;
	
	@FindBy(id="investorCategory")
	private WebElement categorydropdown;
	
	@FindBy(id="investorProfileTextVariable1")
	private WebElement investordetailstextvariable1;
	
	@FindBy(xpath="//span[contains(text(),'Updated')]")
	private WebElement basicprofileupdatenotification;
	
	@FindBy(id="submit_button")
	private WebElement updatebutton;
	
	@FindBy(id="close_OTP_modal_2")
	private WebElement continuewithoutvalidationbutton;
	
	@FindBy(xpath="//li[contains(.,'Identity number one should follow ^[0-9]{12}$ regex pattern')]")
	private WebElement identitynumberoneerrormessage;
	
	@FindBy(xpath="//li[contains(.,'Identity number two should follow ^[A-Z]{5}[0-9]{4}[A-Z]{1}$ regex pattern')]")
	private WebElement identitynumbertwoerrormessage;
	
	
	public void clickBasicProfile() {
		try {
			Generics.waitForElement(driver, basicprofiletab);
			basicprofiletab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateBasicProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, emailaddresstext);
				assertEquals(emailaddresstext.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, titledropdown);
				Select title = new Select(titledropdown);
				WebElement titleoptions = title.getFirstSelectedOption();
				assertEquals(titleoptions.getText(), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, firstnametextbox);
				assertEquals(firstnametextbox.getAttribute("value"), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, lastnametextbox);
				assertEquals(lastnametextbox.getAttribute("value"), product);
				break;
				
			case 4:
				Generics.waitForElement(driver, dateofbirthtextbox);
				assertEquals(dateofbirthtextbox.getAttribute("value"), product);
				break;
				
			case 5:
				Generics.waitForElement(driver, genderdropdown);
				Select gender = new Select(genderdropdown);
				WebElement genderoptions = gender.getFirstSelectedOption();
				assertEquals(genderoptions.getText(), product);
				break;
				
			case 6:
				Generics.waitForElement(driver, martialstatusdropdown);
				Select maritialstatus = new Select(martialstatusdropdown);
				WebElement maritialstatusoptions = maritialstatus.getFirstSelectedOption();
				assertEquals(maritialstatusoptions.getText(), product);
				break;
				
			case 7:
				Generics.waitForElement(driver, mobilenumbertextbox);
				assertEquals(mobilenumbertextbox.getAttribute("value"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, identitynumberonetextbox);
				assertEquals(identitynumberonetextbox.getAttribute("value"), product);
				break;
				
			case 9:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				assertEquals(identitynumbertwotextbox.getAttribute("value"), product);
				break;
				
			case 10:
				Generics.waitForElement(driver, categorydropdown);
				Select category = new Select(categorydropdown);
				WebElement categoryoptions = category.getFirstSelectedOption();
				assertEquals(categoryoptions.getText(), product);
				break;
				
			case 11:
				Generics.waitForElement(driver, investordetailstextvariable1);
				assertEquals(investordetailstextvariable1.getAttribute("value"), product);
				break;
			
			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editBasicProfile(int i, String product, String yearvalue, String monthvalue, String datevalue) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select title = new Select(titledropdown);
				title.selectByVisibleText(product);
				break;
				
			case 1:
				Generics.waitForElement(driver, firstnametextbox);
				firstnametextbox.click();
				firstnametextbox.clear();
				firstnametextbox.sendKeys(product);
				break;
				
			case 2:
				Generics.waitForElement(driver, lastnametextbox);
				lastnametextbox.click();
				lastnametextbox.clear();
				lastnametextbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, dateofbirthtextbox);
				dateofbirthtextbox.click();
				
				Generics.waitForElement(driver, yeardropdown);
				Select year = new Select(yeardropdown);
				year.selectByVisibleText(yearvalue);
				
				Generics.waitForElement(driver, monthdropdown);
				Select month = new Select(monthdropdown);
				month.selectByVisibleText(monthvalue);
				
				Generics.waitForElement(driver, datelinks.get(0));
				for(int j=0;j<datelinks.size();j++) {
					if(datelinks.get(j).getText().equalsIgnoreCase(datevalue)) {
						datelinks.get(j).click();
					}
				}
				break;
				
			case 4:
				Generics.waitForElement(driver, genderdropdown);
				Select gender = new Select(genderdropdown);
				gender.selectByVisibleText(product);
				break;
				
			case 5:
				Generics.waitForElement(driver, martialstatusdropdown);
				Select maritialstatus = new Select(martialstatusdropdown);
				maritialstatus.selectByVisibleText(product);
				break;
				
			case 6:
				Generics.waitForElement(driver, mobilenumbertextbox);
				mobilenumbertextbox.click();
				mobilenumbertextbox.clear();
				mobilenumbertextbox.sendKeys(product);
				break;
				
			case 7:
				Generics.waitForElement(driver, identitynumberonetextbox);
				identitynumberonetextbox.click();
				identitynumberonetextbox.clear();
				identitynumberonetextbox.sendKeys(product);
				break;
				
			case 8:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				identitynumbertwotextbox.click();
				identitynumbertwotextbox.clear();
				identitynumbertwotextbox.sendKeys(product);
				break;
				
			case 9:
				Generics.waitForElement(driver, categorydropdown);
				Select category = new Select(categorydropdown);
				category.selectByVisibleText(product);
				break;
				
			case 10:
				Generics.waitForElement(driver, investordetailstextvariable1);
				investordetailstextvariable1.click();
				investordetailstextvariable1.clear();
				investordetailstextvariable1.sendKeys(product);
				break;
			
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBasicProfileUpdate() {
		try {
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, basicprofileupdatenotification);
			Generics.waitForElement(driver, updatebutton);
			Generics.waitForElement(driver, continuewithoutvalidationbutton);
			continuewithoutvalidationbutton.click();
			Generics.waitForElementToInvisible(driver, continuewithoutvalidationbutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickUpdateToValidateWrongIdentityNumbers() {
		try {
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, identitynumberoneerrormessage);
			Generics.waitForElement(driver, identitynumbertwoerrormessage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfBasicProfileFieldsAreDisabled(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				assertEquals(titledropdown.getAttribute("disabled"), product);
				break;
				
			case 1:
				Generics.waitForElement(driver, firstnametextbox);
				assertEquals(firstnametextbox.getAttribute("disabled"), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, lastnametextbox);
				assertEquals(lastnametextbox.getAttribute("disabled"), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, dateofbirthtextbox);
				assertEquals(dateofbirthtextbox.getAttribute("disabled"), product);
				break;
				
			case 4:
				Generics.waitForElement(driver, genderdropdown);
				assertEquals(genderdropdown.getAttribute("disabled"), product);
				break;
				
			case 5:
				Generics.waitForElement(driver, martialstatusdropdown);
				assertEquals(martialstatusdropdown.getAttribute("disabled"), product);
				break;
				
			case 6:
				Generics.waitForElement(driver, mobilenumbertextbox);
				assertEquals(mobilenumbertextbox.getAttribute("disabled"), product);
				break;
				
			case 7:
				Generics.waitForElement(driver, categorydropdown);
				assertEquals(categorydropdown.getAttribute("disabled"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, investordetailstextvariable1);
				assertEquals(investordetailstextvariable1.getAttribute("disabled"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}