package com.automationsaas.pom.fia;

import static org.testng.Assert.assertEquals;

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
	
	
	@FindBy(id="title")
	private WebElement titledropdown;
	

	@FindBy(id="firstName")
	private WebElement firstnametextbox;
	
	@FindBy(id="lastName")
	private WebElement lastnametextbox;
	
	@FindBy(id="phoneNumber")
	private WebElement mobilenumbertextbox;
	
	@FindBy(id="gender")
	private WebElement genderdropdown;
	
	@FindBy(id="identityNumberOne")
	private WebElement identitynumberonetextbox;
	
	@FindBy(id="identityNumberTwo")
	private WebElement identitynumbertwotextbox;
	
	@FindBy(xpath="//b[text()='Personal Address']/../../following-sibling::div/input[@id='line1']")
	private WebElement personaladdressline1textbox;
	
	@FindBy(xpath="//b[text()='Personal Address']/../../following-sibling::div/input[@id='line2']")
	private WebElement personaladdressline2textbox;
	
	@FindBy(xpath="//b[text()='Personal Address']/../../following-sibling::div/input[@id='line3']")
	private WebElement persoanladdressline3textbox;
	
	//@FindBy(xpath="//b[text()='Personal Address']/../../following-sibling::div/input[@id='state']")
	@FindBy(xpath="//b[text()='Personal Address']/../../following-sibling::div/select[@id='state']")
	private WebElement personaladdressstatetextbox;
	
	@FindBy(xpath="//b[text()='Personal Address']/../../following-sibling::div/input[@id='city']")
	private WebElement personaladdresscitytextbox;
	
	@FindBy(xpath="//b[text()='Personal Address']/../../following-sibling::div/input[@id='zipCode']")
	private WebElement personaladdresszipcodetextbox;
	
	//chandrashekar 27-12-2022
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
	
	public void validateBasicProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, titledropdown);
				Select titleoptions = new Select(titledropdown);
				WebElement title = titleoptions.getFirstSelectedOption();
				assertEquals(title.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, firstnametextbox);
				assertEquals(firstnametextbox.getAttribute("value"), product);
				break;

			case 2:
				Generics.waitForElement(driver, lastnametextbox);
				assertEquals(lastnametextbox.getAttribute("value"), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, mobilenumbertextbox);
				assertEquals(mobilenumbertextbox.getAttribute("value"), product);
				break;
				
			case 4:
				Generics.waitForElement(driver, genderdropdown);
				Select genderoptions = new Select(genderdropdown);
				WebElement gender = genderoptions.getFirstSelectedOption();
				assertEquals(gender.getText(), product);
				break;
				
			case 5:
				Generics.waitForElement(driver, dobtextbox);
				assertEquals(dobtextbox.getAttribute("value"), product);
				break;	
			
			case 6:
				Generics.waitForElement(driver, identitynumberonetextbox);
				assertEquals(identitynumberonetextbox.getAttribute("value"), product);
				break;
					
			case 7:
				Generics.waitForElement(driver, idoneissuedatetextbox);
				assertEquals(idoneissuedatetextbox.getAttribute("value"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				assertEquals(identitynumbertwotextbox.getAttribute("value"), product);
				break;
			
			case 9:
				Generics.waitForElement(driver, idtwoissuedatetextbox);
				assertEquals(idtwoissuedatetextbox.getAttribute("value"), product);
				break;
				
			case 10:
				Generics.waitForElement(driver, textvariableonetextbox);
				assertEquals(textvariableonetextbox.getAttribute("value"), product);
				break;	
			
			case 11:
				Generics.waitForElement(driver, textvariabletwotextbox);
				assertEquals(textvariabletwotextbox.getAttribute("value"), product);
				break;		
				
			case 12:
				Generics.waitForElement(driver, personaladdressline1textbox);
				assertEquals(personaladdressline1textbox.getAttribute("value"), product);
				break;
				
			case 13:
				Generics.waitForElement(driver, personaladdressline2textbox);
				assertEquals(personaladdressline2textbox.getAttribute("value"), product);
				break;
			
			case 14:
				Generics.waitForElement(driver, persoanladdressline3textbox);
				assertEquals(persoanladdressline3textbox.getAttribute("value"), product);
				break;
				
			case 15:
				Generics.waitForElement(driver, personaladdresssubdistrict);
				assertEquals(personaladdresssubdistrict.getAttribute("value"), product);
				break;	
				
			case 16:
				Generics.waitForElement(driver, personaladdressdistrict);
				assertEquals(personaladdressdistrict.getAttribute("value"), product);
				break;	
				
			case 17:
				Generics.waitForElement(driver, personaladdressstatetextbox);
				assertEquals(personaladdressstatetextbox.getAttribute("value"), product);
				break;
				
			case 18:
				Generics.waitForElement(driver, personaladdresscitytextbox);
				assertEquals(personaladdresscitytextbox.getAttribute("value"), product);
				break;
				
			case 19:
				Generics.waitForElement(driver, personaladdresscountry);
				assertEquals(personaladdresscountry.getAttribute("value"), product);
				break;
				
			case 20:
				Generics.waitForElement(driver, personaladdresszipcodetextbox);
				assertEquals(personaladdresszipcodetextbox.getAttribute("value"), product);
				break;
				
			case 21:
				Generics.waitForElement(driver, personaladdresslivingsince);
				assertEquals(personaladdresslivingsince.getAttribute("value"), product);
				break;
				
			case 22:
				Generics.waitForElement(driver, personaladdressownershiptype);
				assertEquals(personaladdressownershiptype.getAttribute("value"), product);
				break;
				
			//commented below line because of issue http://emu.hinagro.com/perfios/integreat/-/issues/9355, once issue is closed we can uncomment this.
			case 23:
				Generics.waitForElement(driver, personaladdresstypeofaddress);
				//assertEquals(personaladdresstypeofaddress.getAttribute("value"), product);
				break; 
				
			//Address One	
				
			case 24:
				Generics.waitForElement(driver, addressone_line1_textbox);
				assertEquals(addressone_line1_textbox.getAttribute("value"), product);
				break;
				
			case 25:
				Generics.waitForElement(driver, addressone_line2_textbox);
				assertEquals(addressone_line2_textbox.getAttribute("value"), product);
				break;
			
			case 26:
				Generics.waitForElement(driver, addressone_line3_textbox);
				assertEquals(addressone_line3_textbox.getAttribute("value"), product);
				break;
				
			case 27:
				Generics.waitForElement(driver, addressone_subdistrict_textbox);
				assertEquals(addressone_subdistrict_textbox.getAttribute("value"), product);
				break;	
				
			case 28:
				Generics.waitForElement(driver, addressone_district_textbox);
				assertEquals(addressone_district_textbox.getAttribute("value"), product);
				break;	
				
			case 29:
				Generics.waitForElement(driver, addressone_state_dropdown);
				assertEquals(addressone_state_dropdown.getAttribute("value"), product);
				break;
				
			case 30:
				Generics.waitForElement(driver, addressone_city_textbox);
				assertEquals(addressone_city_textbox.getAttribute("value"), product);
				break;
				
			case 31:
				Generics.waitForElement(driver, addressone_country_textbox);
				assertEquals(addressone_country_textbox.getAttribute("value"), product);
				break;
				
			case 32:
				Generics.waitForElement(driver, addressone_zipcode_textbox);
				assertEquals(addressone_zipcode_textbox.getAttribute("value"), product);
				break;
				
			case 33:
				Generics.waitForElement(driver, addressone_livingsince_textbox);
				assertEquals(addressone_livingsince_textbox.getAttribute("value"), product);
				break;
				
			case 34:
				Generics.waitForElement(driver, addressone_ownershiptype_dropdown);
				assertEquals(addressone_ownershiptype_dropdown.getAttribute("value"), product);
				break;
				
			//commented below line because of issue http://emu.hinagro.com/perfios/integreat/-/issues/9355, once issue is closed we can uncomment this.
			case 35:
				Generics.waitForElement(driver, addressone_addresstype_dropdown);
				//assertEquals(addressone_addresstype_dropdown.getAttribute("value"), product);
				break;	
			
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}

