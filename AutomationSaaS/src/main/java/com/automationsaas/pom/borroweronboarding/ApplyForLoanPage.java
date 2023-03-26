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

public class ApplyForLoanPage {

	public WebDriver driver;

	public ApplyForLoanPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="close_OTP_modal_2")
	private WebElement continuewithoutvalidationbutton;
	
	@FindBy(xpath="//h1")
	private WebElement applyforloanheading;
	
	@FindBy(id="loanPurpose")
	private WebElement loanproductdropdown;
	
	@FindBy(id="loanAmount")
	private WebElement loanamounttextbox;
	
	@FindBy(id="interestRate")
	private WebElement interestratedropdown;
	
	@FindBy(id="loanRepaymentType")
	private WebElement loanrepaymenttypedropdown;
	
	@FindBy(id="loanTenure")
	private WebElement loantenuredropdown;
	
	@FindBy(id="submitLoanFormButton")
	private WebElement applyforloanbutton;
	
	@FindBy(xpath="//a[contains(text(),'Get Details')]")
	private WebElement getdetailsbutton;
	
	@FindBy(xpath="//*[text()='Amount']/../following-sibling::td")
	private WebElement amounttext;
	
	@FindBy(xpath="//*[text()='Interest Rate']/../following-sibling::td")
	private WebElement interestratetext;
	
	@FindBy(xpath="//*[text()='Service fees']/../following-sibling::td")
	private WebElement servicefeestext;
	
	@FindBy(xpath="//*[text()='Loan Duration']/../following-sibling::td")
	private WebElement loandurationtext;
	
	@FindBy(xpath="//*[text()='Total Amount Paid']/../following-sibling::td")
	private WebElement totalamountpaidtext;
	
	@FindBy(xpath="//*[text()='Repayment Amount']/../following-sibling::td")
	private WebElement repaymentamounttext;
	
	@FindBy(xpath="//*[text()='Apply For Loan']")
	private WebElement getdetails_applyloanbutton;
	
	@FindBy(xpath="//img[@src='/public/showTenantLogo']")
	private WebElement tenantlogolink;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	public void clickContinueWithoutValidation() {
		try {
			Generics.waitForElement(driver, continuewithoutvalidationbutton);
			if (continuewithoutvalidationbutton.isDisplayed()) {
				continuewithoutvalidationbutton.click();
				Reporter.log("clickContinueWithoutValidation is passed", true);
			}
			else if(!continuewithoutvalidationbutton.isDisplayed()) {
				System.out.println("clickContinueWithoutValidation Skipped");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("clickContinueWithoutValidation is failed", true);
		}
	}
	
	
	public void validateApplyForLoanHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, applyforloanheading);
			if (applyforloanheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Apply For Loan is displayed", true);
			} else
				Reporter.log("Apply For Loan is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateApplyForLoanHeading", true);
		}
	}
	
	public void selectLoanProduct(String loanproduct) {
		try {
			Generics.waitForElement(driver, loanproductdropdown);
			Select loanProducts = new Select(loanproductdropdown);
			loanProducts.selectByVisibleText(loanproduct);
			Reporter.log("selectLoanProduct is failed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectLoanProduct", true);
		}
	}
	
	public void enterLoanAmount(String loanamount) {
		try {
			Generics.waitForElement(driver, loanamounttextbox);
			Generics.waitForElementToBeEnabled(driver, loanamounttextbox);
			loanamounttextbox.click();
			loanamounttextbox.clear();
			loanamounttextbox.sendKeys(loanamount);
			Reporter.log("enterLoanAmount is failed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterLoanAmount", true);
		}
	}
	
	public void selectInterest(String interest) {
		try {
			Generics.waitForElement(driver, interestratedropdown);
			Generics.waitForElementToBeEnabled(driver, interestratedropdown);
			Select interests = new Select(interestratedropdown);
			interests.selectByVisibleText(interest);
			Reporter.log("selectInterest is failed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectInterest", true);
		}
	}
	
	public void selectLoanRepaymentType(String repaymenttype) {
		try {
			Generics.waitForElement(driver, loanrepaymenttypedropdown);
			Select loanRepaymentTypeOptions = new Select(loanrepaymenttypedropdown);
			loanRepaymentTypeOptions.selectByVisibleText(repaymenttype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectTenure(String tenure) {
		try {
			Generics.waitForElement(driver, loantenuredropdown);
			Generics.waitForElementToBeEnabled(driver, loantenuredropdown);
			Select tenures = new Select(loantenuredropdown);
			tenures.selectByVisibleText(tenure);
			Reporter.log("selectTenure is failed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectTenure", true);
		}
	}
	
	
	public void clickApplyForLoan() {
		try {
			Generics.waitForElement(driver, applyforloanbutton);
			Generics.waitForElementToBeEnabled(driver, applyforloanbutton);
			applyforloanbutton.click();
			Reporter.log("clickApplyForLoan is failed", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in clickApplyForLoan", true);
		}
	}
	
	public void clickGetDetails() {
		try {
			Generics.waitForElement(driver, getdetailsbutton);
			getdetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateLoanDetails(int i, String value) {
		try {
			switch (i) {
			  case 0:
				  Generics.waitForElement(driver, amounttext);
				  assertEquals(amounttext.getText(), value);
			    break;
			    
			  case 1:
				  Generics.waitForElement(driver, interestratetext);
				  assertEquals(interestratetext.getText(), value);
				  break;
				  
			  case 2:
				  Generics.waitForElement(driver, servicefeestext);
				  assertEquals(servicefeestext.getText(), value);
				  break;
				  
			  case 3:
				  Generics.waitForElement(driver, loandurationtext);
				  assertEquals(loandurationtext.getText(), value);
				  break;
				  
			  case 4:
				  Generics.waitForElement(driver, totalamountpaidtext);
				  assertEquals(totalamountpaidtext.getText(), value);
				  break;
				  
//			  case 5:
//				  Generics.waitForElement(driver, repaymentamounttext);
//				  assertEquals(repaymentamounttext.getText(), value);
//				  break;
				  
			  default:
				    System.out.println("No Value Found");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickApplyLoan() {
		try {
			Generics.waitForElement(driver, getdetails_applyloanbutton);
			getdetails_applyloanbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickTenantLogo() {
		try {
			Generics.waitForElement(driver, tenantlogolink);
			tenantlogolink.click();
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
