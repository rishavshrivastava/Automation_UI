package com.automationsaas.pom.borrower;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class ProfilePage {

	public WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Basic Profile']")
	private WebElement basicprofiletab;

	@FindBy(id = "emailAddress")
	private WebElement basicprofileemailtextbox;

	@FindBy(id = "title")
	private WebElement basicprofiletitletextbox;

	@FindBy(id = "firstName")
	private WebElement basicprofilefirstnametextbox;

	@FindBy(id = "lastName")
	private WebElement basicprofilelastnametextbox;

	@FindBy(xpath = "//input[contains(@id,'dateOfBirth')]")
	private WebElement basicprofiledateofbirthtextbox;

	@FindBy(id = "gender")
	private WebElement basicprofilegenderdropdown;

	@FindBy(id = "maritalStatus")
	private WebElement basicprofilemartialstatusdropdown;
	
	@FindBy(id = "identityNumberOne")
	private WebElement identitynumberonetextbox;
	
	@FindBy(id = "identityNumberTwo")
	private WebElement identitynumbertwotextbox;
	
	@FindBy(xpath = "//form[@id='basicDetailForm']//ul/li[1]")
	private WebElement identitynumberoneerrormessage;
	
	@FindBy(xpath = "//form[@id='basicDetailForm']//ul/li[2]")
	private WebElement identitynumbertwoerrormessage;

	@FindBy(id = "borrowerProfileTextVariable1")
	private WebElement basicprofileborrowerprofiletextvariable1dropdown;

	@FindBy(xpath = "//div[@id='submitButtonBasicDetail']//button[text()='Update']")
	private WebElement basicprofileupdatebutton;
	
	@FindBy(id="close_OTP_modal_2")
	private WebElement verifyotp_continuewithoutvalidation;
	
	@FindBy(id = "waitingSpinnerBasicDetail")
	private WebElement detailsupdatespinner;

	@FindBy(xpath = "//a[text()='Personal Profile']")
	private WebElement personalprofiletab;

	@FindBy(id = "workExperience")
	private WebElement personalprofileworkexperiencedtextbox;

	@FindBy(id = "jobType")
	private WebElement personalprofileemploymentcategorydropdown;

	@FindBy(id = "grossIncome")
	private WebElement personalprofilegrossincometextbox;

	@FindBy(xpath = "//div[@id='submitButtonIndividualDetail']//button[text()='Update']")
	private WebElement personalprofileupdatebutton;
	
	@FindBy(xpath="//span[contains(text(),'Profile Updated Successfully')]")
	private WebElement personalprofileupdatenotification;

	@FindBy(xpath = "//a[text()='Employment Profile']")
	private WebElement employmentprofiletab;

	@FindBy(id = "organizationName")
	private WebElement employmentprofileorganizationtextbox;

	@FindBy(id = "department")
	private WebElement employmentprofiledepartmentdropdown;

	@FindBy(id = "designation")
	private WebElement employmentprofiledesignationdropdown;

	@FindBy(id = "employeeId")
	private WebElement employmentprofileemployeeidtextbox;

	@FindBy(id = "line1")
	private WebElement employmentprofileaddressline1textbox;

	@FindBy(id = "line2")
	private WebElement employmentprofileaddressline2textbox;

	@FindBy(id = "line3")
	private WebElement employmentprofileaddressline3textbox;

	@FindBy(id = "state")
	private WebElement employmentprofilestatetextbox;

	@FindBy(id = "city")
	private WebElement employmentprofilecitytextbox;

	@FindBy(id = "zipCode")
	private WebElement employmentprofilezipcodetextbox;

	@FindBy(xpath = "//div[@id='submitButtonEmploymentHistory']//button[text()='Update']")
	private WebElement employmentprofileupdatebutton;
	
	@FindBy(xpath="//span[contains(text(),'Profile Updated Successfully')]")
	private WebElement employmentprofileupdatenotification;
	
	@FindBy(xpath="//div[@id='bankDetailsAjx']//a[contains(text(),'Bank Details')]")
	private WebElement bankdetailsaccordionlink;

	@FindBy(xpath = "//li[@id='bank_detail_tab']//a[text()='Bank Details']")
	private WebElement bankdetailstab;

	@FindBy(xpath = "//th[.='Account Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Number']/preceding-sibling::th)+1]")
	private List<WebElement> accountnumbertext;

	@FindBy(xpath = "//th[.='Account Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Type']/preceding-sibling::th)+1]")
	private List<WebElement> accounttypetext;

	@FindBy(xpath = "//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private List<WebElement> banknametext;

	@FindBy(xpath = "//th[.='IFSC']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='IFSC']/preceding-sibling::th)+1]")
	private List<WebElement> ifsctext;
	
	@FindBy(xpath="//th[.='Account Holder Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Holder Name']/preceding-sibling::th)+1]")
	private List<WebElement> accountholdernametext;

	@FindBy(xpath = "//th[.='Action']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Action']/preceding-sibling::th)+1]/button")
	private WebElement bankdetailseditbutton;

	@FindBy(id = "accountNumber")
	private WebElement edit_accountnumbertextbox;

	@FindBy(id = "bankName")
	private WebElement edit_banknametextbox;

	@FindBy(id = "ifsc")
	private WebElement edit_ifsctextbox;

	@FindBy(id = "bankAccountType")
	private WebElement edit_accounttypetextbox;

	@FindBy(id = "submitBankDetailsButton")
	private WebElement edit_donebutton;
	
	@FindBy(xpath="//span[contains(text(),'Bank Detail Updated')]")
	private WebElement bankdetailsupdatenotification;
	
	@FindBy(xpath="//div[@id='bank_details_list']/strong")
	private WebElement nobankdetailstext;
	
	@FindBy(id="bank_detail_modal_opener")
	private WebElement bankdetails_addbankdetailsbutton;
	
	@FindBy(id="accountHolderName")
	private WebElement addbankdetails_accountholdernametextbox;
	
	@FindBy(id="accountNumber")
	private WebElement addbankdetails_accountnumbertextbox;
	
	@FindBy(id="bankName")
	private WebElement addbankdetails_banknametextbox;
	
	@FindBy(id="ifsc")
	private WebElement addbankdetails_ifsctextbox;
	
	@FindBy(id="bankAccountType")
	private WebElement addbankdetails_bankaccounttypetextbox;
	
	@FindBy(id="submitBankDetailsButton")
	private WebElement addbankdetails_donebutton;
	
	@FindBy(xpath="//span[contains(text(),'Updated')]")
	private WebElement addbankdetails_notifications;
	
	@FindBy(xpath="//span[contains(text(),'Updated')]")
	private WebElement editbankdetails_notifications;
	
	@FindBy(xpath="//th[.='Action']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Action']/preceding-sibling::th)+1]/button")
	private List<WebElement> bankdetails_editbutton;

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
				Generics.waitForElement(driver, basicprofileemailtextbox);
				assertEquals(basicprofileemailtextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, basicprofiletitletextbox);
				Select title = new Select(basicprofiletitletextbox);
				WebElement titleoption = title.getFirstSelectedOption();
				assertEquals(titleoption.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, basicprofilefirstnametextbox);
				assertEquals(basicprofilefirstnametextbox.getAttribute("value"), product);
				break;

			case 3:
				Generics.waitForElement(driver, basicprofilelastnametextbox);
				assertEquals(basicprofilelastnametextbox.getAttribute("value"), product);
				break;

			case 4:
				Generics.waitForElement(driver, basicprofiledateofbirthtextbox);
				assertEquals(basicprofiledateofbirthtextbox.getAttribute("value"), product);
				break;

			case 5:
				Generics.waitForElement(driver, basicprofilegenderdropdown);
				Select gender = new Select(basicprofilegenderdropdown);
				WebElement loanoverviewborroweridoption = gender.getFirstSelectedOption();
				assertEquals(loanoverviewborroweridoption.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, basicprofilemartialstatusdropdown);
				Select maritialStatus = new Select(basicprofilemartialstatusdropdown);
				WebElement basicprofilemartialstatusoption = maritialStatus.getFirstSelectedOption();
				assertEquals(basicprofilemartialstatusoption.getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, identitynumberonetextbox);
				assertEquals(identitynumberonetextbox.getAttribute("value"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				assertEquals(identitynumbertwotextbox.getAttribute("value"),product);
				break;
				
			case 9:	
				Generics.waitForElement(driver, basicprofileborrowerprofiletextvariable1dropdown);
				assertEquals(basicprofileborrowerprofiletextvariable1dropdown.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editBasicProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, basicprofiletitletextbox);
				Select title = new Select(basicprofiletitletextbox);
				title.selectByVisibleText(product);
				break;
				
			case 1:
				Generics.waitForElement(driver, basicprofilefirstnametextbox);
				basicprofilefirstnametextbox.click();
				basicprofilefirstnametextbox.clear();
				basicprofilefirstnametextbox.sendKeys(product);
				break;
				
			case 2:
				Generics.waitForElement(driver, basicprofilelastnametextbox);
				basicprofilelastnametextbox.click();
				basicprofilelastnametextbox.clear();
				basicprofilelastnametextbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, basicprofilegenderdropdown);
				Select gender = new Select(basicprofilegenderdropdown);
				gender.selectByVisibleText(product);
				break;
				
			case 4:
				Generics.waitForElement(driver, basicprofilemartialstatusdropdown);
				Select maritialstatus = new Select(basicprofilemartialstatusdropdown);
				maritialstatus.selectByVisibleText(product);
				break;
				
			case 5:
				Generics.waitForElement(driver, identitynumberonetextbox);
				identitynumberonetextbox.click();
				identitynumberonetextbox.clear();
				identitynumberonetextbox.sendKeys(product);
				break;
				
			case 6:
				Generics.waitForElement(driver, identitynumbertwotextbox);
				identitynumbertwotextbox.click();
				identitynumbertwotextbox.clear();
				identitynumbertwotextbox.sendKeys(product);
				break;
					
			case 7:
				Generics.waitForElement(driver, basicprofileborrowerprofiletextvariable1dropdown);
				Select basicProfileBorrowerProfileTextVariable1Options = new Select(basicprofileborrowerprofiletextvariable1dropdown);
				basicProfileBorrowerProfileTextVariable1Options.selectByVisibleText(product);
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//@author: Divya
			public void enterIdentityNumberOne(String identitynumberoneborrower) {
				try {
					Generics.waitForElement(driver, identitynumberonetextbox);
					identitynumberonetextbox.click();
					identitynumberonetextbox.clear();
					identitynumberonetextbox.sendKeys(identitynumberoneborrower);
					identitynumbertwotextbox.click();
				} catch (InterruptedException e) {
					e.printStackTrace();
					Reporter.log("Error in enterIdentityNumberOne", true);
				}
			}
			public void enterIdentityNumberTwo(String identitynumbertwoborrower) {
				try {
					Generics.waitForElement(driver, identitynumbertwotextbox);
					identitynumbertwotextbox.click();
					identitynumbertwotextbox.clear();
					identitynumbertwotextbox.sendKeys(identitynumbertwoborrower);
				} catch (InterruptedException e) {
					e.printStackTrace();
					Reporter.log("Error in enterIdentityNumberTwo", true);
				}
			}
			
			public void invalidIdentityNumberErrorMessage() {
				try {
					Generics.waitForElement(driver, identitynumberoneerrormessage);
					identitynumberoneerrormessage.isDisplayed();
					Generics.waitForElement(driver, identitynumbertwoerrormessage);
					identitynumbertwoerrormessage.isDisplayed();
				} catch (InterruptedException e) {
					e.printStackTrace();
					Reporter.log("Error message not displayed for IdentityNumber", true);
				}
			}
			
			public void updateBasicProfileButton() {
				try {
					Generics.waitForElement(driver, basicprofileupdatebutton);
					basicprofileupdatebutton.click();
					Generics.waitForElementToInvisible(driver, detailsupdatespinner);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//
	
	public void updateBasicProfile() {
		try {
			Generics.waitForElement(driver, basicprofileupdatebutton);
			basicprofileupdatebutton.click();
			Generics.waitForElement(driver, verifyotp_continuewithoutvalidation);
			verifyotp_continuewithoutvalidation.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickPersonalProfile() {
		try {
			Generics.waitForElement(driver, personalprofiletab);
			personalprofiletab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validatePersonalProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, personalprofileworkexperiencedtextbox);
				assertEquals(personalprofileworkexperiencedtextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, personalprofileemploymentcategorydropdown);
				Select employmentcategory = new Select(personalprofileemploymentcategorydropdown);
				WebElement personalprofileemploymentcategoryoption = employmentcategory.getFirstSelectedOption();
				assertEquals(personalprofileemploymentcategoryoption.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, personalprofilegrossincometextbox);
				assertEquals(personalprofilegrossincometextbox.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editPersonalProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, personalprofileworkexperiencedtextbox);
				personalprofileworkexperiencedtextbox.click();
				personalprofileworkexperiencedtextbox.clear();
				personalprofileworkexperiencedtextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, personalprofileemploymentcategorydropdown);
				Select employmentcategory = new Select(personalprofileemploymentcategorydropdown);
				employmentcategory.selectByVisibleText(product);
				break;

			case 2:
				Generics.waitForElement(driver, personalprofilegrossincometextbox);
				personalprofilegrossincometextbox.click();
				personalprofilegrossincometextbox.clear();
				personalprofilegrossincometextbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public void validateIfPersonalProfileIsDisabled() {
		try {
			Generics.waitForElement(driver, personalprofileworkexperiencedtextbox);
			assertEquals(personalprofileworkexperiencedtextbox.isEnabled(), false);

			Generics.waitForElement(driver, personalprofileemploymentcategorydropdown);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void updatePersonalProfile() {
		try {
			Generics.waitForElement(driver, personalprofileupdatebutton);
			personalprofileupdatebutton.click();
			Generics.waitForElement(driver, personalprofileupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEmploymentProfile() {
		try {
			Generics.waitForElement(driver, employmentprofiletab);
			employmentprofiletab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateEmploymentProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, employmentprofileorganizationtextbox);
				assertEquals(employmentprofileorganizationtextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, employmentprofiledepartmentdropdown);
				Select department = new Select(employmentprofiledepartmentdropdown);
				WebElement employmentprofiledepartmentoption = department.getFirstSelectedOption();
				assertEquals(employmentprofiledepartmentoption.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, employmentprofiledesignationdropdown);
				Select designation = new Select(employmentprofiledesignationdropdown);
				WebElement employmentprofiledesignationoption = designation.getFirstSelectedOption();
				assertEquals(employmentprofiledesignationoption.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, employmentprofileemployeeidtextbox);
				assertEquals(employmentprofileemployeeidtextbox.getAttribute("value"), product);
				break;

			case 4:
				Generics.waitForElement(driver, employmentprofileaddressline1textbox);
				assertEquals(employmentprofileaddressline1textbox.getAttribute("value"), product);
				break;

			case 5:
				Generics.waitForElement(driver, employmentprofileaddressline2textbox);
				assertEquals(employmentprofileaddressline2textbox.getAttribute("value"), product);
				break;

			case 6:
				Generics.waitForElement(driver, employmentprofileaddressline3textbox);
				assertEquals(employmentprofileaddressline3textbox.getAttribute("value"), product);
				break;

			case 7:
				Generics.waitForElement(driver, employmentprofilestatetextbox);
				assertEquals(employmentprofilestatetextbox.getAttribute("value"), product);
				break;

			case 8:
				Generics.waitForElement(driver, employmentprofilecitytextbox);
				assertEquals(employmentprofilecitytextbox.getAttribute("value"), product);
				break;

			case 9:
				Generics.waitForElement(driver, employmentprofilezipcodetextbox);
				assertEquals(employmentprofilezipcodetextbox.getAttribute("value"), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editEmploymentProfile(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, employmentprofileorganizationtextbox);
				assertEquals(employmentprofileorganizationtextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, employmentprofiledepartmentdropdown);
				Select department = new Select(employmentprofiledepartmentdropdown);
				department.selectByVisibleText(product);
				break;

			case 2:
				Generics.waitForElement(driver, employmentprofiledesignationdropdown);
				Select designation = new Select(employmentprofiledesignationdropdown);
				designation.selectByVisibleText(product);
				break;

			case 3:
				Generics.waitForElement(driver, employmentprofileemployeeidtextbox);
				employmentprofileemployeeidtextbox.click();
				employmentprofileemployeeidtextbox.clear();
				employmentprofileemployeeidtextbox.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, employmentprofileaddressline1textbox);
				employmentprofileaddressline1textbox.click();
				employmentprofileaddressline1textbox.clear();
				employmentprofileaddressline1textbox.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, employmentprofileaddressline2textbox);
				employmentprofileaddressline2textbox.click();
				employmentprofileaddressline2textbox.clear();
				employmentprofileaddressline2textbox.sendKeys(product);
				break;

			case 6:
				Generics.waitForElement(driver, employmentprofileaddressline3textbox);
				employmentprofileaddressline3textbox.click();
				employmentprofileaddressline3textbox.clear();
				employmentprofileaddressline3textbox.sendKeys(product);
				break;

			case 7:
				Generics.waitForElement(driver, employmentprofilestatetextbox);
				Select stateOptions = new Select(employmentprofilestatetextbox);
				stateOptions.selectByVisibleText(product);
				break;

			case 8:
				Generics.waitForElement(driver, employmentprofilecitytextbox);
				employmentprofilecitytextbox.click();
				employmentprofilecitytextbox.clear();
				employmentprofilecitytextbox.sendKeys(product);
				break;

			case 9:
				Generics.waitForElement(driver, employmentprofilezipcodetextbox);
				employmentprofilezipcodetextbox.click();
				employmentprofilezipcodetextbox.clear();
				employmentprofilezipcodetextbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateIfEmploymentProfileIsDisabled() {
		
	}

	public void updateEmploymentProfile() {
		try {
			Generics.waitForElement(driver, employmentprofileupdatebutton);
			employmentprofileupdatebutton.click();
			Generics.waitForElement(driver, employmentprofileupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBankDetailsAccordionLink() {
		try {
			Generics.waitForElement(driver, bankdetailsaccordionlink);
			bankdetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBankDetails() {
		try {
			Generics.waitForElement(driver, bankdetailstab);
			bankdetailstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getBankDetailsCount() {
		return Generics.getElementCount(accountnumbertext);
	}

	public void validateBankDetails(int n, int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, accountnumbertext.get(n));
				assertEquals(accountnumbertext.get(n).getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, accounttypetext.get(n));
				assertEquals(accounttypetext.get(n).getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, banknametext.get(n));
				assertEquals(banknametext.get(n).getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, ifsctext.get(n));
				assertEquals(ifsctext.get(n).getText(), product);
				break;
				
			case 4:
				Generics.waitForElement(driver, accountholdernametext.get(n));
				assertEquals(accountholdernametext.get(n).getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editBankDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, bankdetailseditbutton);
				bankdetailseditbutton.click();
				break;

			case 1:
				Generics.waitForElement(driver, edit_accountnumbertextbox);
				edit_accountnumbertextbox.click();
				edit_accountnumbertextbox.clear();
				edit_accountnumbertextbox.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, edit_banknametextbox);
				edit_banknametextbox.click();
				edit_banknametextbox.clear();
				edit_banknametextbox.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, edit_ifsctextbox);
				edit_ifsctextbox.click();
				edit_ifsctextbox.clear();
				edit_ifsctextbox.sendKeys(product);
				break;
				
			case 4:
				Generics.waitForElement(driver, edit_accounttypetextbox);
				edit_accounttypetextbox.click();
				edit_accounttypetextbox.clear();
				edit_accounttypetextbox.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBankDetails() {
		try {
			Generics.waitForElement(driver, edit_donebutton);
			edit_donebutton.click();
			Generics.waitForElement(driver, bankdetailsupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfBasicProfileDetailsAreDisabled(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, basicprofiletitletextbox);
				assertEquals(basicprofiletitletextbox.getAttribute("disabled"), product);
				break;
			
			case 1:
				Generics.waitForElement(driver, basicprofilefirstnametextbox);
				assertEquals(basicprofilefirstnametextbox.getAttribute("disabled"), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, basicprofilelastnametextbox);
				assertEquals(basicprofilelastnametextbox.getAttribute("disabled"), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, basicprofiledateofbirthtextbox);
				assertEquals(basicprofiledateofbirthtextbox.getAttribute("disabled"), product);
				break;
				
			case 4:
				Generics.waitForElement(driver, basicprofilegenderdropdown);
				assertEquals(basicprofilegenderdropdown.getAttribute("disabled"), product);
				break;
				
			case 5:
				Generics.waitForElement(driver, basicprofilemartialstatusdropdown);
				assertEquals(basicprofilemartialstatusdropdown.getAttribute("disabled"), product);
				break;
				
			case 6:
				Generics.waitForElement(driver, basicprofileborrowerprofiletextvariable1dropdown);
				assertEquals(basicprofileborrowerprofiletextvariable1dropdown.getAttribute("disabled"), product);
				break;
			
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfPersonalProfileFieldsAreDisabled(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, personalprofileworkexperiencedtextbox);
				assertEquals(personalprofileworkexperiencedtextbox.getAttribute("disabled"), product);
				break;
				
			case 1:
				Generics.waitForElement(driver, personalprofileemploymentcategorydropdown);
				assertEquals(personalprofileemploymentcategorydropdown.getAttribute("disabled"), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, personalprofilegrossincometextbox);
				assertEquals(personalprofilegrossincometextbox.getAttribute("disabled"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfEmploymentProfileFieldsAreDisabled(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, employmentprofileorganizationtextbox);
				assertEquals(employmentprofileorganizationtextbox.getAttribute("disabled"), product);
				break;
				
			case 1:
				Generics.waitForElement(driver, employmentprofiledepartmentdropdown);
				assertEquals(employmentprofiledepartmentdropdown.getAttribute("disabled"), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, employmentprofiledesignationdropdown);
				assertEquals(employmentprofiledesignationdropdown.getAttribute("disabled"), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, employmentprofileemployeeidtextbox);
				assertEquals(employmentprofileemployeeidtextbox.getAttribute("disabled"), product);
				break;
				
			case 4:
				Generics.waitForElement(driver, employmentprofileaddressline1textbox);
				assertEquals(employmentprofileaddressline1textbox.getAttribute("disabled"), product);
				break;
				
			case 5:
				Generics.waitForElement(driver, employmentprofileaddressline2textbox);
				assertEquals(employmentprofileaddressline2textbox.getAttribute("disabled"), product);
				break;
				
			case 6:
				Generics.waitForElement(driver, employmentprofileaddressline3textbox);
				assertEquals(employmentprofileaddressline3textbox.getAttribute("disabled"), product);
				break;
				
			case 7:
				Generics.waitForElement(driver, employmentprofilestatetextbox);
				assertEquals(employmentprofilestatetextbox.getAttribute("disabled"), product);
				break;
				
			case 8:
				Generics.waitForElement(driver, employmentprofilecitytextbox);
				assertEquals(employmentprofilecitytextbox.getAttribute("disabled"), product);
				break;
				
			case 9:
				Generics.waitForElement(driver, employmentprofilezipcodetextbox);
				assertEquals(employmentprofilezipcodetextbox.getAttribute("disabled"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateIfNoBankDetails(String value) {
		try {
			Generics.waitForElement(driver, nobankdetailstext);
			assertEquals(nobankdetailstext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddNewBankDetails() {
		try {
			Generics.waitForElement(driver, bankdetails_addbankdetailsbutton);
			bankdetails_addbankdetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void addBankDetails(int i, String value) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, addbankdetails_accountholdernametextbox);
				addbankdetails_accountholdernametextbox.click();
				addbankdetails_accountholdernametextbox.clear();
				addbankdetails_accountholdernametextbox.sendKeys(value);
				break;
				
			case 1:
				Generics.waitForElement(driver, addbankdetails_accountnumbertextbox);
				addbankdetails_accountnumbertextbox.click();
				addbankdetails_accountnumbertextbox.clear();
				addbankdetails_accountnumbertextbox.sendKeys(value);
				break;
				
			case 2:
				Generics.waitForElement(driver, addbankdetails_banknametextbox);
				addbankdetails_banknametextbox.click();
				addbankdetails_banknametextbox.clear();
				addbankdetails_banknametextbox.sendKeys(value);
				break;
				
			case 3:
				Generics.waitForElement(driver, addbankdetails_ifsctextbox);
				addbankdetails_ifsctextbox.click();
				addbankdetails_ifsctextbox.clear();
				addbankdetails_ifsctextbox.sendKeys(value);
				break;
				
			case 4:
				Generics.waitForElement(driver, addbankdetails_bankaccounttypetextbox);
				addbankdetails_bankaccounttypetextbox.click();
				addbankdetails_bankaccounttypetextbox.clear();
				addbankdetails_bankaccounttypetextbox.sendKeys(value);
				break;
			
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddBankDetailsDone() {
		try {
			Generics.waitForElement(driver, addbankdetails_donebutton);
			addbankdetails_donebutton.click();
			Generics.waitForElement(driver, addbankdetails_notifications);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBankDetailsEdit(int i) {
		try {
			Generics.waitForElement(driver, bankdetails_editbutton.get(i));
			bankdetails_editbutton.get(i).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEditBankDetailsDone() {
		try {
			Generics.waitForElement(driver, edit_donebutton);
			edit_donebutton.click();
			Generics.waitForElement(driver, editbankdetails_notifications);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
