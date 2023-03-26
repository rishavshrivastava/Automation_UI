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

public class ReferenceDetailsPage {

	public WebDriver driver;

	public ReferenceDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement ReferenceDetailsPage;
	
	@FindBy(id="firstName")
	private WebElement firstnametextbox;
	
	@FindBy(id="lastName")
	private WebElement lastnametextbox;
	
	@FindBy(id="userName")
	private WebElement emailtextbox;
	
	@FindBy(id="phoneNumber")
	private WebElement mobilenumbertextbox;
	
	@FindBy(id="relationshipStatus")
	private WebElement relationshipstatusdropdown;
	
	@FindBy(id="borrowerReferenceTextVariable1")
	private WebElement borrowerreferencetextvariable1textbox;
	
	@FindBy(id="borrowerReferenceTextVariable2")
	private WebElement borrowerreferencetextvariable2textbox;
	
	@FindBy(id="borrowerReferenceTextVariable3")
	private WebElement borrowerreferencetextvariable3textbox;
	
	@FindBy(id="borrowerReferenceTextVariable4")
	private WebElement borrowerreferencetextvariable4textbox;
	
	@FindBy(id="borrowerReferenceTextVariable5")
	private WebElement borrowerreferencetextvariable5textbox;
	
	@FindBy(id="borrowerReferenceTextVariable6")
	private WebElement borrowerreferencetextvariable6textbox;
	
	@FindBy(id="borrowerReferenceTextVariable7")
	private WebElement borrowerreferencetextvariable7textbox;
	
	@FindBy(id="borrowerReferenceTextVariable8")
	private WebElement borrowerreferencetextvariable8textbox;
	
	@FindBy(id="borrowerReferenceTextVariable9")
	private WebElement borrowerreferencetextvariable9textbox;
	
	@FindBy(id="borrowerReferenceTextVariable10")
	private WebElement borrowerreferencetextvariable10textbox;
	
	@FindBy(xpath="//input[contains(@id,'borrowerReferenceDateVariable1')]")
	private WebElement borrowerreferencedatevariable1textbox;
	
	@FindBy(xpath="//input[contains(@id,'borrowerReferenceDateVariable2')]")
	private WebElement borrowerreferencedatevariable2textbox;
	
	@FindBy(xpath="//input[contains(@id,'borrowerReferenceDateVariable3')]")
	private WebElement borrowerreferencedatevariable3textbox;
	
	@FindBy(xpath="//input[contains(@id,'borrowerReferenceDateVariable4')]")
	private WebElement borrowerreferencedatevariable4textbox;
	
	@FindBy(id="addressOneLine1")
	private WebElement referenceaddress_line1textbox;
	
	@FindBy(id="addressOneLine2")
	private WebElement referenceaddress_line2textbox;
	
	@FindBy(id="addressOneLine3")
	private WebElement referenceaddress_line3textbox;
	
	@FindBy(id="addressOneSubDistrict")
	private WebElement referenceaddress_subdistricttextbox;
	
	@FindBy(id="addressOneDistrict")
	private WebElement referenceaddress_districttextbox;
	
	@FindBy(id="addressOneState")
	private WebElement referenceaddress_statedropdown;
	
	@FindBy(id="addressOneCity")
	private WebElement referenceaddress_citytextbox;
	
	@FindBy(id="addressOneCountry")
	private WebElement referenceaddress_countrytextbox;
	
	@FindBy(id="addressOneZipCode")
	private WebElement referenceaddress_zipcodetextbox;
	
	@FindBy(id="referenceAddressOneLivingSince")
	private WebElement referenceaddress_livingsincetextbox;
	
	@FindBy(id="addressOneOwnershipType")
	private WebElement referenceaddress_ownershiptypedropdown;
	
	@FindBy(id="addressOneTypeOfAddress")
	private WebElement referenceaddress_addresstypedropdown;
	
	@FindBy(id="createReferenceAjaxBtn")
	private WebElement addmorebutton;
	
	@FindBy(xpath="//div[@id='waitingSpinnerCreateReference']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement addmorespinner;
	
	@FindBy(xpath="//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)+1]")
	private WebElement savedreferencedetailsname;
	
	@FindBy(xpath="//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)+1]")
	private WebElement savedreferencedetailsemail;
	
	@FindBy(xpath="//th[.='Mobile Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Mobile Number']/preceding-sibling::th)+1]")
	private WebElement savedreferencedetailsmobilenumber;
	
	@FindBy(xpath="//th[.='Relationship Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Relationship Status']/preceding-sibling::th)+1]")
	private WebElement savedreferencedetailsrelationshipstatus;
	
	@FindBy(id="edit_bank_detail_modal_opener")
	private WebElement editbutton;
	
	@FindBy(xpath="//form[@id='updateReferenceForm']//input[@id='firstName']")
	private WebElement updatefirstnametextbox;
	
	@FindBy(xpath="//form[@id='updateReferenceForm']//input[@id='lastName']")
	private WebElement updatesecondnametextbox;
	
	@FindBy(xpath="//form[@id='updateReferenceForm']//input[@id='userName']")
	private WebElement updateemailtextbox;
	
	@FindBy(xpath="//form[@id='updateReferenceForm']//input[@id='phoneNumber']")
	private WebElement updatemobilenumbertextbox;
	
	@FindBy(xpath="//form[@id='updateReferenceForm']//select[@id='relationshipStatus']")
	private WebElement updaterelationshipstatusdropdown;
	
	@FindBy(id="submitUpdateBtn")
	private WebElement updatesubmitbutton;
	
	@FindBy(xpath="//div[@id='waitingSpinnerEditReferenceDetail']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement updatebuttonspinner;
	
	@FindBy(xpath="//button[@id='edit_bank_detail_modal_opener']/following-sibling::button")
	private WebElement deletebutton;
	
	@FindBy(xpath="//span[contains(text(),'deleted Successfully')]")
	private WebElement addedreferencedetailsdeletenotification;
	
	@FindBy(id="createReference")
	private WebElement addandcontinuebutton;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	private WebElement skipbutton;
	
	@FindBy(xpath="//div[@id='ajaxFormReferenceDivId']//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	public void clickSkip() {
		try {
			Generics.waitForElement(driver, skipbutton);
			skipbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateReferenceDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, ReferenceDetailsPage);
			if (ReferenceDetailsPage.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Reference details is displayed", true);
			} else
				Reporter.log("Reference details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateApplyForLoanHeading", true);
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
		}
	}
	
	public void enterEmailAddress(String email) {
		try {
			Generics.waitForElement(driver, emailtextbox);
			emailtextbox.click();
			emailtextbox.clear();
			emailtextbox.sendKeys(email);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
		}
	}
	
	public void enterRelationshipStatus(String relationshipstatus) {
		try {
			Generics.waitForElement(driver, relationshipstatusdropdown);
			Select relationshipOptions = new Select(relationshipstatusdropdown);
			relationshipOptions.selectByVisibleText(relationshipstatus);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddMore() {
		try {
			Generics.waitForElement(driver, addmorebutton);
			addmorebutton.click();
			Generics.waitForElement(driver, addmorespinner);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateReferenceDetails(String name, String email, String mobilenumber, String relationshipstatus) {
		try {
			Generics.waitForElement(driver, savedreferencedetailsname);
			assertEquals(savedreferencedetailsname.getText(), name);
			
			Generics.waitForElement(driver, savedreferencedetailsemail);
			assertEquals(savedreferencedetailsemail.getText(), email);
			
			Generics.waitForElement(driver, savedreferencedetailsmobilenumber);
			assertEquals(savedreferencedetailsmobilenumber.getText(), mobilenumber);
			
			Generics.waitForElement(driver, savedreferencedetailsrelationshipstatus);
			assertEquals(savedreferencedetailsrelationshipstatus.getText(), relationshipstatus);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEdit() {
		try {
			Generics.waitForElement(driver, editbutton);
			editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editReferenceDetails(String firstname, String lastname, String email, String mobilenumber, String relationshipstatus) {
		try {
			Generics.waitForElement(driver, updatefirstnametextbox);
			updatefirstnametextbox.click();
			updatefirstnametextbox.clear();
			updatefirstnametextbox.sendKeys(firstname);
			
			Generics.waitForElement(driver, updatesecondnametextbox);
			updatesecondnametextbox.click();
			updatesecondnametextbox.clear();
			updatesecondnametextbox.sendKeys(lastname);
			
			Generics.waitForElement(driver, updateemailtextbox);
			updateemailtextbox.click();
			updateemailtextbox.clear();
			updateemailtextbox.sendKeys(email);
			
			Generics.waitForElement(driver, updatemobilenumbertextbox);
			updatemobilenumbertextbox.click();
			updatemobilenumbertextbox.clear();
			updatemobilenumbertextbox.sendKeys(mobilenumber);
			
			Generics.waitForElement(driver, updaterelationshipstatusdropdown);
			Select relationshipStatusOptions = new Select(updaterelationshipstatusdropdown);
			relationshipStatusOptions.selectByVisibleText(relationshipstatus);
			
			Generics.waitForElement(driver, updatesubmitbutton);
			updatesubmitbutton.click();
			
			Generics.waitForElementToInvisible(driver, updatebuttonspinner);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDelete() {
		try {
			Generics.waitForElement(driver, deletebutton);
			deletebutton.click();
			driver.switchTo().alert().accept();
			Generics.waitForElement(driver, addedreferencedetailsdeletenotification);
			System.out.println(addedreferencedetailsdeletenotification.getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddAndContinue() {
		try {
			Generics.waitForElement(driver, addandcontinuebutton);
			addandcontinuebutton.click();
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
					assertEquals(true, false);
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
