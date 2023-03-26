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



public class BankDetailsPage {

	public WebDriver driver;

	public BankDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement bankdetailsheading;
	
	@FindBy(id="accountHolderName")
	private WebElement accountholdernametextbox;
	
	@FindBy(id="accountNumber")
	private WebElement accountnumbertextbox;
	
	@FindBy(id="bankName")
	private WebElement banknametextbox;
	
	@FindBy(id="bankAddress")
	private WebElement bankaddresstextbox;
	
	@FindBy(id="ifsc")
	private WebElement ifsctextbox;
	
	@FindBy(xpath="//input[contains(@id,'dateOfOpeningAccount')]")
	private WebElement dateofopeningaccounttextbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks;
	
	@FindBy(id="micr")
	private WebElement micrcodetextbox;
	
	@FindBy(id="bankAccountType")
	private WebElement accounttypetextbox;
	
	@FindBy(id="branchName")
	private WebElement branchnametextbox;
	
	@FindBy(id="swiftCode")
	private WebElement swiftcodetextbox;
	
	@FindBy(id="branchPinCode")
	private WebElement branchpincodetextbox;
	
	@FindBy(id="branchCity")
	private WebElement branchcitytextbox;
	
	@FindBy(id="natureOfFacility")
	private WebElement natureoffacilitytextbox;
	
	@FindBy(id="bankDetailTextVariable1")
	private WebElement bankdetailstextvariable1textbox;
	
	@FindBy(id="bankDetailTextVariable2")
	private WebElement bankdetailstextvariable2textbox;
	
	@FindBy(id="bankDetailTextVariable3")
	private WebElement bankdetailstextvariable3textbox;
	
	@FindBy(id="bankDetailTextVariable4")
	private WebElement bankdetailstextvariable4textbox;
	
	@FindBy(id="bankDetailTextVariable5")
	private WebElement bankdetailstextvariable5textbox;
	
	@FindBy(id="bankDetailTextVariable6")
	private WebElement bankdetailstextvariable6textbox;
	
	@FindBy(id="bankDetailTextVariable7")
	private WebElement bankdetailstextvariable7textbox;
	
	@FindBy(id="bankDetailTextVariable8")
	private WebElement bankdetailstextvariable8textbox;
	
	@FindBy(id="bankDetailTextVariable9")
	private WebElement bankdetailstextvariable9textbox;
	
	@FindBy(id="bankDetailTextVariable10")
	private WebElement bankdetailstextvariable10textbox;
	
	@FindBy(id="submit_button")
	private WebElement submitbutton;
	
	@FindBy(xpath="//a[contains(text(),'Skip Page')]")
	private WebElement skippagebutton;
	
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
	
	public void validateBankDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, bankdetailsheading);
			if (bankdetailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Bank Details is displayed", true);
			} else
				Reporter.log("Bank Details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateBankDetailsHeading", true);
		}
	}
	
	public void enterAccountHolderName(String value) {
		try {
			Generics.waitForElement(driver, accountholdernametextbox);
			accountholdernametextbox.click();
			accountholdernametextbox.clear();
			accountholdernametextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterAccountNumber(String accountnumber) {
		try {
			Generics.waitForElement(driver, accountnumbertextbox);
			accountnumbertextbox.click();
			accountnumbertextbox.clear();
			accountnumbertextbox.sendKeys(accountnumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterAccountNumber", true);
		}
	}
	
	public void enterBankName(String bankname) {
		try {
			Generics.waitForElement(driver, banknametextbox);
			banknametextbox.click();
			banknametextbox.clear();
			banknametextbox.sendKeys(bankname);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterBankName", true);
		}
	}
	
	public void enterBankAddress(String value) {
		try {
			Generics.waitForElement(driver, bankaddresstextbox);
			bankaddresstextbox.click();
			bankaddresstextbox.clear();
			bankaddresstextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIFSC(String ifsc) {
		try {
			Generics.waitForElement(driver, ifsctextbox);
			ifsctextbox.click();
			ifsctextbox.clear();
			ifsctextbox.sendKeys(ifsc);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterIFSC", true);
		}
	}
	
	public void enterDateOfOpeningAccount(String date, String month, String year) {
		try {
			Generics.waitForElement(driver, dateofopeningaccounttextbox);
			dateofopeningaccounttextbox.click();
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
	
	public void enterMICRCode(String value) {
		try {
			Generics.waitForElement(driver, micrcodetextbox);
			micrcodetextbox.click();
			micrcodetextbox.clear();
			micrcodetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterAccountType(String accounttype) {
		try {
			Generics.waitForElement(driver, accounttypetextbox);
			accounttypetextbox.click();
			accounttypetextbox.clear();
			accounttypetextbox.sendKeys(accounttype);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterAccountType", true);
		}
	}
	
	public void enterBranchName(String value) {
		try {
			Generics.waitForElement(driver, branchnametextbox);
			branchnametextbox.click();
			branchnametextbox.clear();
			branchnametextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterSwiftCode(String value) {
		try {
			Generics.waitForElement(driver, swiftcodetextbox);
			swiftcodetextbox.click();
			swiftcodetextbox.clear();
			swiftcodetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBranchPinCode(String value) {
		try {
			Generics.waitForElement(driver, branchpincodetextbox);
			branchpincodetextbox.click();
			branchpincodetextbox.clear();
			branchpincodetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBranchCity(String value) {
		try {
			Generics.waitForElement(driver, branchcitytextbox);
			branchcitytextbox.click();
			branchcitytextbox.clear();
			branchcitytextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterNatureOfFacility(String value) {
		try {
			Generics.waitForElement(driver, natureoffacilitytextbox);
			natureoffacilitytextbox.click();
			natureoffacilitytextbox.clear();
			natureoffacilitytextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable1TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable1textbox);
			bankdetailstextvariable1textbox.click();
			bankdetailstextvariable1textbox.clear();
			bankdetailstextvariable1textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable2TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable2textbox);
			bankdetailstextvariable2textbox.click();
			bankdetailstextvariable2textbox.clear();
			bankdetailstextvariable2textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable3TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable3textbox);
			bankdetailstextvariable3textbox.click();
			bankdetailstextvariable3textbox.clear();
			bankdetailstextvariable3textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable4TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable4textbox);
			bankdetailstextvariable4textbox.click();
			bankdetailstextvariable4textbox.clear();
			bankdetailstextvariable4textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable5TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable5textbox);
			bankdetailstextvariable5textbox.click();
			bankdetailstextvariable5textbox.clear();
			bankdetailstextvariable5textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable6TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable6textbox);
			bankdetailstextvariable6textbox.click();
			bankdetailstextvariable6textbox.clear();
			bankdetailstextvariable6textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable7TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable7textbox);
			bankdetailstextvariable7textbox.click();
			bankdetailstextvariable7textbox.clear();
			bankdetailstextvariable7textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable8TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable8textbox);
			bankdetailstextvariable8textbox.click();
			bankdetailstextvariable8textbox.clear();
			bankdetailstextvariable8textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable9TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable9textbox);
			bankdetailstextvariable9textbox.click();
			bankdetailstextvariable9textbox.clear();
			bankdetailstextvariable9textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankDetailsTextVariable10TextBox(String value) {
		try {
			Generics.waitForElement(driver, bankdetailstextvariable10textbox);
			bankdetailstextvariable10textbox.click();
			bankdetailstextvariable10textbox.clear();
			bankdetailstextvariable10textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSubmit() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in clickSubmit", true);
		}
	}
	
	public void clickSkipPage() {
		try {
			Generics.waitForElement(driver, skippagebutton);
			skippagebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in clickSkipPage", true);
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
