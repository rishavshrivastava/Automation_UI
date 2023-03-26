package com.automationsaas.pom.fia;

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

public class ProfilePage extends Base {

	public WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='title']")
	private WebElement titledropdown;
	
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement firstnametextbox;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement lastnametextbox;
	
	@FindBy(xpath="//input[@id='phoneNumber']")
	private WebElement phonenumbertextbox;
	
	@FindBy(xpath="//Select[@id='gender']")
	private WebElement genderdropdown;
	
	@FindBy(xpath="//input[@id='identityNumberOne']")
	private WebElement identitynumberonetextbox;
	
	@FindBy(xpath="//input[@id='identityNumberTwo']")
	private WebElement identitynumbertwotextbox;
	
	@FindBy(xpath="//input[@id='line1']")
	private WebElement personaladdress_line1textbox;
	
	@FindBy(xpath="//input[@id='line2']")
	private WebElement personaladdress_line2textbox;
	
	@FindBy(xpath="//input[@id='line3']")
	private WebElement personaladdress_line3textbox;
	
	//@FindBy(xpath="//input[@id='state']")
	@FindBy(xpath="//select[@id='state']")
	private WebElement personaladdress_statetextbox;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement personaladdress_citytextbox;
	
	@FindBy(xpath="//input[@id='zipCode']")
	private WebElement personaladdress_zipcodetextbox;
	
	@FindBy(xpath="//button[@id='submit_button']")
	private WebElement updatebutton;
	
	@FindBy(xpath="//span[contains(text(),'Updated Successfully')]")
	private WebElement updatenotifications;
	
	//
	@FindBy(xpath="//input[(@id='fiaProfileTextVariable1')]")
	private WebElement textvariableonetextbox;
	
	@FindBy(xpath="//input[(@id='fiaProfileTextVariable2')]")
	private WebElement textvariabletwotextbox;
	
	@FindBy(xpath="//input[(@id='citizenship')]")
	private WebElement citizentextbox;
	
	@FindBy(id="subDistrict")
	private WebElement personaladdresssubdistrict;
	
	@FindBy(id="district")
	private WebElement personaladdressdistrict;
	
	@FindBy(id="country")
	private WebElement personaladdresscountry;
	
	@FindBy(id="livingSince")
	private WebElement personaladdresslivingsince;
	
	@FindBy(id="ownershipType")
	private WebElement personaladdressownershiptype;
	
	@FindBy(id="typeOfAddress")
	private WebElement personaladdresstypeofaddress;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks; 
	
	@FindBy(xpath="//input[contains(@id,'dateOfBirth')]")
	private WebElement dobtextbox;
	
	@FindBy(xpath="//input[contains(@name,'identityNumberOneIssueDate')]")
	private WebElement idoneissuedatetextbox;
	
	@FindBy(xpath="//input[contains(@name,'identityNumberTwoIssueDate')]")
	private WebElement idtwoissuedatetextbox;
	
	public void editBasicProfile(int i, String value, String year, String month, String date) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select titleOptions = new Select(titledropdown);
				titleOptions.selectByVisibleText(value);
				break;
				
			case 1:
				Generics.waitForElement(driver, firstnametextbox);
				firstnametextbox.click();
				firstnametextbox.clear();
				firstnametextbox.sendKeys(value);
				break;
				
			case 2:
				Generics.waitForElement(driver, lastnametextbox);
				lastnametextbox.click();
				lastnametextbox.clear();
				lastnametextbox.sendKeys(value);
				break;
				
			case 3:
				Generics.waitForElement(driver, phonenumbertextbox);
				phonenumbertextbox.click();
				phonenumbertextbox.clear();
				phonenumbertextbox.sendKeys(value);
				break;
				
			case 4:
				Generics.waitForElement(driver, genderdropdown);
				Select genderOptions = new Select(genderdropdown);
				genderOptions.selectByVisibleText(value);
				break;
				
			case 5:
				Generics.waitForElement(driver, identitynumberonetextbox);
				identitynumberonetextbox.click();
				identitynumberonetextbox.clear();
				identitynumberonetextbox.sendKeys(value);
				break;
				
			case 6:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				identitynumbertwotextbox.click();
				identitynumbertwotextbox.clear();
				identitynumbertwotextbox.sendKeys(value);
				break;
				
				//cmy
			case 7:
              	Generics.waitForElement(driver, textvariableonetextbox);
              	textvariableonetextbox.click();
              	textvariableonetextbox.clear();
              	textvariableonetextbox.sendKeys(value);
				break;
				
			case 8:
              	Generics.waitForElement(driver, textvariabletwotextbox);
              	textvariabletwotextbox.click();
              	textvariabletwotextbox.clear();
              	textvariabletwotextbox.sendKeys(value);
				break;
				
			case 9:
				Generics.waitForElement(driver, personaladdress_line1textbox);
				personaladdress_line1textbox.click();
				personaladdress_line1textbox.clear();
				personaladdress_line1textbox.sendKeys(value);
				break;
				
			case 10:
				Generics.waitForElement(driver, personaladdress_line2textbox);
				personaladdress_line2textbox.click();
				personaladdress_line2textbox.clear();
				personaladdress_line2textbox.sendKeys(value);
				break;
				
			case 11:
				Generics.waitForElement(driver, personaladdress_line3textbox);
				personaladdress_line3textbox.click();
				personaladdress_line3textbox.clear();
				personaladdress_line3textbox.sendKeys(value);
				break;
				
				//
			case 12:
              	Generics.waitForElement(driver, personaladdresssubdistrict);
              	personaladdresssubdistrict.click();
              	personaladdresssubdistrict.clear();
              	personaladdresssubdistrict.sendKeys(value);
				break;
				
			case 13:
              	Generics.waitForElement(driver, personaladdressdistrict);
              	personaladdressdistrict.click();
              	personaladdressdistrict.clear();
              	personaladdressdistrict.sendKeys(value);
				break;	
				
			case 14:
				Generics.waitForElement(driver, personaladdress_statetextbox);
				personaladdress_statetextbox.click();
				//personaladdress_statetextbox.clear();
				personaladdress_statetextbox.sendKeys(value);
				break;
				
			case 15:
				Generics.waitForElement(driver, personaladdress_citytextbox);
				personaladdress_citytextbox.click();
				personaladdress_citytextbox.clear();
				personaladdress_citytextbox.sendKeys(value);
				break;
				
			case 16:
              	Generics.waitForElement(driver, personaladdresscountry);
              	personaladdresscountry.click();
              	personaladdresscountry.clear();
              	personaladdresscountry.sendKeys(value);
				break;
				
			case 17:
				Generics.waitForElement(driver, personaladdress_zipcodetextbox);
				personaladdress_zipcodetextbox.click();
				personaladdress_zipcodetextbox.clear();
				personaladdress_zipcodetextbox.sendKeys(value);
				break;
				
			case 18:
				Generics.waitForElement(driver, personaladdresslivingsince);
				personaladdresslivingsince.click();
				Generics.waitForElement(driver, yeardropdown);
				Select years = new Select(yeardropdown);
				years.selectByVisibleText(year);
				Generics.waitForElement(driver, monthdropdown);
				Select months = new Select(monthdropdown);
				months.selectByVisibleText(month);
				for (int j = 0; j < datelinks.size(); j++) {
					if (datelinks.get(j).getText().equalsIgnoreCase(date)) {
						datelinks.get(j).click();
					}
				}
				break;
				
			case 19:
					Generics.waitForElement(driver, personaladdressownershiptype);
					personaladdressownershiptype.click();
					personaladdressownershiptype.sendKeys(value);
					break;
			
			case 20:
				Generics.waitForElement(driver, personaladdresstypeofaddress);
				personaladdresstypeofaddress.click();
				personaladdresstypeofaddress.sendKeys(value);
				
			case 21:
				Generics.waitForElement(driver, citizentextbox);
				citizentextbox.click();
				citizentextbox.clear();
				citizentextbox.sendKeys(value);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickUpdate() {
		try {
			Generics.waitForElement(driver, updatebutton);
			updatebutton.click();
			Generics.waitForElement(driver, updatenotifications);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateBasicprofile(int i, String value, String livingsince,String dob,String id1issuedate,String id2issuedate) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select titleOptions = new Select(titledropdown);
				assertEquals(titleOptions.getFirstSelectedOption().getText(), value);
				break;
				
			case 1:
				Generics.waitForElement(driver, firstnametextbox);
				assertEquals(firstnametextbox.getAttribute("value"), value);
				break;
				
			case 2:
				Generics.waitForElement(driver, lastnametextbox);
				assertEquals(lastnametextbox.getAttribute("value"), value);
				break;
				
			case 3:
				Generics.waitForElement(driver, phonenumbertextbox);
				assertEquals(phonenumbertextbox.getAttribute("value"), value);
				break;
				
			case 4:
				Generics.waitForElement(driver, genderdropdown);
				Select genderOptions = new Select(genderdropdown);
				assertEquals(genderOptions.getFirstSelectedOption().getText(), value);
				break;
				
			case 5:
				Generics.waitForElement(driver, identitynumberonetextbox);
				assertEquals(identitynumberonetextbox.getAttribute("value"), value);
				break;
				
			case 6:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				assertEquals(identitynumbertwotextbox.getAttribute("value"), value);
				break;
				
				
			case 7:
              	Generics.waitForElement(driver, textvariableonetextbox);
              	assertEquals(textvariableonetextbox.getAttribute("value"), value);
				break;
				
			case 8:
              	Generics.waitForElement(driver, textvariabletwotextbox);
              	assertEquals(textvariabletwotextbox.getAttribute("value"), value);
				break;	
				
			case 9:
				Generics.waitForElement(driver, personaladdress_line1textbox);
				assertEquals(personaladdress_line1textbox.getAttribute("value"), value);
				break;
				
			case 10:
				Generics.waitForElement(driver, personaladdress_line2textbox);
				assertEquals(personaladdress_line2textbox.getAttribute("value"), value);
				break;
				
			case 11:
				Generics.waitForElement(driver, personaladdress_line3textbox);
				assertEquals(personaladdress_line3textbox.getAttribute("value"), value);
				break;
				
			case 12:
				Generics.waitForElement(driver, personaladdresssubdistrict);
				assertEquals(personaladdresssubdistrict.getAttribute("value"), value);
				break;
				
			case 13:
				Generics.waitForElement(driver, personaladdressdistrict);
				assertEquals(personaladdressdistrict.getAttribute("value"), value);
				break;	
				
			case 14:
				Generics.waitForElement(driver, personaladdress_statetextbox);
				assertEquals(personaladdress_statetextbox.getAttribute("value"), value);
				break;

			case 15:
				Generics.waitForElement(driver, personaladdress_citytextbox);
				assertEquals(personaladdress_citytextbox.getAttribute("value"), value);
				break;
				
			case 16:
				Generics.waitForElement(driver, personaladdresscountry);
				assertEquals(personaladdresscountry.getAttribute("value"), value);
				break;
				
			case 17:
				Generics.waitForElement(driver, personaladdress_zipcodetextbox);
				assertEquals(personaladdress_zipcodetextbox.getAttribute("value"), value);
				break;
				
			case 18:
				Generics.waitForElement(driver, personaladdresslivingsince);
				System.out.println(personaladdresslivingsince.getAttribute(value));
				assertEquals(personaladdresslivingsince.getAttribute("value"), livingsince);
				break;
				
			case 19:
				Generics.waitForElement(driver, personaladdressownershiptype);
				assertEquals(personaladdressownershiptype.getAttribute("value"), value);
				break;
				
				//commented below line because of issue http://emu.hinagro.com/perfios/integreat/-/issues/9355, once issue is closed we can uncomment this.
			case 20:
				Generics.waitForElement(driver, personaladdresstypeofaddress);
				//assertEquals(personaladdresstypeofaddress.getAttribute("value"), value);
				break;
				
			case 21:
				Generics.waitForElement(driver, citizentextbox);
				assertEquals(citizentextbox.getAttribute("value"), value);
				break;	
				
			case 22:
				Generics.waitForElement(driver, dobtextbox);
				assertEquals(dobtextbox.getAttribute("value"), dob);
				break;
				
			case 23:
				Generics.waitForElement(driver, idoneissuedatetextbox);
				assertEquals(idoneissuedatetextbox.getAttribute("value"), id1issuedate);
				break;
				
			case 24:
				Generics.waitForElement(driver, idtwoissuedatetextbox);
				assertEquals(idtwoissuedatetextbox.getAttribute("value"), id2issuedate);
				break;
				
				
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
