package com.automationsaas.pom.investoronboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class BankDetailsPage {

	public WebDriver driver;

	public BankDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1")
	private WebElement bankdetailsheading;
	
	@FindBy(id="accountNumber")
	private WebElement accountnumbertextbox;
	
	@FindBy(id="bankName")
	private WebElement banknametextbox;
	
	@FindBy(id="ifsc")
	private WebElement ifsctextbox;
	
	@FindBy(id="bankAccountType")
	private WebElement accounttypetextbox;
	
	@FindBy(id="submit_button")
	private WebElement submitbutton;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
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
	
	public void enterAccountNumber(String accountnumber) {
		try {
			Generics.waitForElement(driver, accountnumbertextbox);
			accountnumbertextbox.click();
			accountnumbertextbox.clear();
			accountnumbertextbox.sendKeys(accountnumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
		}
	}
	
	public void clickSubmit() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
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
