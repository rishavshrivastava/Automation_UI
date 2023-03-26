package com.automationsaas.pom.adminfia;

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

public class FIADetailsPage extends Base {

	public WebDriver driver;

	public FIADetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='top_detail_table']//h1")
	private WebElement fiaidtext;

	@FindBy(xpath = "//div[@id='top_detail_table']//label")
	private WebElement fiastatustext;

	@FindBy(id = "followingStatus")
	private WebElement fiastatusdropdown;
	
	@FindBy(xpath="//span[contains(text(),'Status Has been Changed to')]")
	private WebElement fiastatuschangenotification;

	@FindBy(id = "availableCashHeader")
	private WebElement accountbalancetext;

	@FindBy(xpath = "//div[@id='loadProfilePicTemplate']//h6")
	private WebElement fiaemailtext;

	@FindBy(id = "title")
	private WebElement titledropdown;

	@FindBy(id = "firstName")
	private WebElement firstnametextbox;

	@FindBy(id = "lastName")
	private WebElement lastnametextbox;

	@FindBy(id = "phoneNumber")
	private WebElement phonenumber;

	@FindBy(id = "gender")
	private WebElement genderdropdown;

	@FindBy(id = "identityNumberOne")
	private WebElement identitynumberone;

	@FindBy(id = "identityNumberTwo")
	private WebElement identitynumbertwo;

	@FindBy(id = "line1")
	private WebElement personaladdressline1;

	@FindBy(id = "line2")
	private WebElement personaladdressline2;

	@FindBy(id = "line3")
	private WebElement personaladdressline3;

	@FindBy(id = "state")
	private WebElement personaladdressstate;

	@FindBy(id = "city")
	private WebElement personaladdresscity;

	@FindBy(id = "zipCode")
	private WebElement personaladdresszipcode;
	
	@FindBy(id = "submit_button")
	private WebElement fiadetailsupdatebutton;
	
	//cmy
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
			
			@FindBy(xpath="//select[@class='ui-datepicker-year']")
			private WebElement yeardropdown;
			
			@FindBy(xpath="//select[@class='ui-datepicker-month']")
			private WebElement monthdropdown;
			
			@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
			private List<WebElement> datelinks; 

	public void validateFiaId(String fiaId) {

		try {
			Generics.waitForElement(driver, fiaidtext);
			assertEquals(fiaidtext.getText(), fiaId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateFiaStatus(String fiastatus, String fiastatusfromdropdown) {

		try {
			Generics.waitForElement(driver, fiastatustext);
			assertEquals(fiastatustext.getText(), fiastatus);
			Generics.waitForElement(driver, fiastatusdropdown);
			Select fiadropdownstatusoption = new Select(fiastatusdropdown);
			WebElement fiadropdownstatus = fiadropdownstatusoption.getFirstSelectedOption();
			assertEquals(fiadropdownstatus.getText(), fiastatusfromdropdown);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateFiaEmailId(String fiaemailid) {
		try {
			Generics.waitForElement(driver, fiaemailtext);
			assertEquals(fiaemailtext.getText(), fiaemailid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void validateAccountBalance(String accountbalance) {

		try {
			Generics.waitForElement(driver, accountbalancetext);
			assertEquals(accountbalancetext.getText(), accountbalance);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateFiaDetails(int i, String product) {
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
				Generics.waitForElement(driver, phonenumber);
				assertEquals(phonenumber.getAttribute("value"), product);
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
				Generics.waitForElement(driver, identitynumberone);
				assertEquals(identitynumberone.getAttribute("value"), product);
				break;
				
			case 7:
				Generics.waitForElement(driver, idoneissuedatetextbox);
				assertEquals(idoneissuedatetextbox.getAttribute("value"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, identitynumbertwo);
				assertEquals(identitynumbertwo.getAttribute("value"), product);
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
				Generics.waitForElement(driver, personaladdressline1);
				assertEquals(personaladdressline1.getAttribute("value"), product);
				break;
				
			case 13:
				Generics.waitForElement(driver, personaladdressline2);
				assertEquals(personaladdressline2.getAttribute("value"), product);
				break;
			
			case 14:
				Generics.waitForElement(driver, personaladdressline3);
				assertEquals(personaladdressline3.getAttribute("value"), product);
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
				Generics.waitForElement(driver, personaladdressstate);
				assertEquals(personaladdressstate.getAttribute("value"), product);
				break;
				
			case 18:
				Generics.waitForElement(driver, personaladdresscity);
				assertEquals(personaladdresscity.getAttribute("value"), product);
				break;
				
			case 19:
				Generics.waitForElement(driver, personaladdresscountry);
				assertEquals(personaladdresscountry.getAttribute("value"), product);
				break;
				
			case 20:
				Generics.waitForElement(driver, personaladdresszipcode);
				assertEquals(personaladdresszipcode.getAttribute("value"), product);
				break;
				
			case 21:
				Generics.waitForElement(driver, personaladdresslivingsince);
				assertEquals(personaladdresslivingsince.getAttribute("value"), product);
				break;
				
			case 22:
				Generics.waitForElement(driver, personaladdressownershiptype);
				assertEquals(personaladdressownershiptype.getAttribute("value"), product);
				break;
				
			case 23:
				Generics.waitForElement(driver, personaladdresstypeofaddress);
				assertEquals(personaladdresstypeofaddress.getAttribute("value"), product);
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
				
			case 35:
				Generics.waitForElement(driver, addressone_addresstype_dropdown);
				assertEquals(addressone_addresstype_dropdown.getAttribute("value"), product);
				break;	
			
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterPhoneNumber1(String Phone) {
		try {
			Generics.waitForElement(driver, phonenumber);
			phonenumber.click();
			phonenumber.clear();
			phonenumber.sendKeys(Phone);
			//clicking outside phone textbox to verify the phone validation message
		//	identitynumbertwo.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			//Reporter.log("Error in Mobile number", true);
		}
	}
	
	public void editFiaDetails(int i, String product, String year, String month, String date) {

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
				Generics.waitForElement(driver, genderdropdown);
				Select gender = new Select(genderdropdown);
				gender.selectByVisibleText(product);
				break;
				
			case 4:
				Generics.waitForElement(driver, identitynumberone);
				identitynumberone.click();
				identitynumberone.clear();
				identitynumberone.sendKeys(product);
				break;
				
			case 5:
              	Generics.waitForElement(driver, identitynumbertwo);
				identitynumbertwo.click();
				identitynumbertwo.clear();
				identitynumbertwo.sendKeys(product);
				break;
				
			case 6:
              	Generics.waitForElement(driver, textvariableonetextbox);
              	textvariableonetextbox.click();
              	textvariableonetextbox.clear();
              	textvariableonetextbox.sendKeys(product);
				break;
				
			case 7:
              	Generics.waitForElement(driver, textvariabletwotextbox);
              	textvariabletwotextbox.click();
              	textvariabletwotextbox.clear();
              	textvariabletwotextbox.sendKeys(product);
				break;	
				
			case 8:
              	Generics.waitForElement(driver, personaladdressline1);
              	personaladdressline1.click();
              	personaladdressline1.clear();
              	personaladdressline1.sendKeys(product);
				break;
				
			case 9:
              	Generics.waitForElement(driver, personaladdressline2);
              	personaladdressline2.click();
              	personaladdressline2.clear();
              	personaladdressline2.sendKeys(product);
				break;
				
			case 10:
              	Generics.waitForElement(driver, personaladdressline3);
              	personaladdressline3.click();
              	personaladdressline3.clear();
              	personaladdressline3.sendKeys(product);
				break;
				
			case 11:
              	Generics.waitForElement(driver, personaladdresssubdistrict);
              	personaladdresssubdistrict.click();
              	personaladdresssubdistrict.clear();
              	personaladdresssubdistrict.sendKeys(product);
				break;
				
			case 12:
              	Generics.waitForElement(driver, personaladdressdistrict);
              	personaladdressdistrict.click();
              	personaladdressdistrict.clear();
              	personaladdressdistrict.sendKeys(product);
				break;	
				
			case 13:
              	Generics.waitForElement(driver, personaladdressstate);
              	personaladdressstate.click();
              	//personaladdressstate.clear();
              	personaladdressstate.sendKeys(product);
				break;
				
			case 14:
              	Generics.waitForElement(driver, personaladdresscity);
              	personaladdresscity.click();
				personaladdresscity.clear();
				personaladdresscity.sendKeys(product);
				break;
				
			case 15:
              	Generics.waitForElement(driver, personaladdresscountry);
              	personaladdresscountry.click();
              	personaladdresscountry.clear();
              	personaladdresscountry.sendKeys(product);
				break;	
				
			case 16:
              	Generics.waitForElement(driver, personaladdresszipcode);
              	personaladdresszipcode.click();
              	personaladdresszipcode.clear();
              	personaladdresszipcode.sendKeys(product);
				break;
				
			case 17:
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
				
			case 18:
					Generics.waitForElement(driver, personaladdressownershiptype);
					personaladdressownershiptype.click();
					personaladdressownershiptype.sendKeys(product);
					break;
			
			case 19:
				Generics.waitForElement(driver, personaladdresstypeofaddress);
				personaladdresstypeofaddress.click();
				//Select addressTypeOptions = new Select(personaladdresstypeofaddress);
				System.out.println("personaladdresstypeofaddress="+product);
				personaladdresstypeofaddress.sendKeys(product);
				
			case 20:
				Generics.waitForElement(driver, citizentextbox);
				citizentextbox.click();
				citizentextbox.clear();
				citizentextbox.sendKeys(product);
				break;	
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public void clickUpdateFIADetails() {
		try {
			Generics.waitForElement(driver, fiadetailsupdatebutton);
			fiadetailsupdatebutton.click();
			Generics.waitForElementToInvisible(driver, fiadetailsupdatebutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void changeFiaStatus(String statusoption) {

		try {
			
			Generics.waitForElement(driver, fiastatusdropdown);
			Select status = new Select(fiastatusdropdown);
			status.selectByVisibleText(statusoption);
			Generics.waitForElement(driver, fiastatuschangenotification);
			Generics.waitForFewSecondstoLoad(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}

	}
	
	public void selectDateOfBirth(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, dobtextbox);
			dobtextbox.click();
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
			Reporter.log("selectDateOfBirth is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectDateOfBirth", true);
		}
	}
	
	public void selectIdentityNumberOneIssueDate(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, idoneissuedatetextbox);
			idoneissuedatetextbox.click();
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
			Reporter.log("selectIdentityNumberOneIssueDate is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectIdentityNumberOneIssueDate", true);
		}
	}
	
	public void selectIdentityNumberTwoIssueDate(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, idtwoissuedatetextbox);
			idtwoissuedatetextbox.click();
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
			Reporter.log("selectIdentityNumberTwoIssueDate is passed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectIdentityNumberTwoIssueDate", true);
		}
	}

}
