package com.automationsaas.pom.dsa;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class ExistingBorrowerPage extends Base {
	
	public WebDriver driver;
	public ExistingBorrowerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement emailtextbox;
	
	@FindBy(id="searchBorrower")
	private WebElement searchbox;
	
	@FindBy(xpath="//a[contains(text(),'Bank Details')]")
	private WebElement bankdetailstab;
	
	@FindBy(xpath="//*[@id=\"borrowersList1\"]/div/div[1]/table/tbody/tr/td[2]/a")
	private WebElement borrowerid;
	
	@FindBy(xpath="//*[@id='borrowersList1']//div//tr[1]//td[3]")
	private WebElement emaillist;
	
	@FindBy(xpath="//*[@id='borrowersList1']//div//td[2]")
	private WebElement borroweridlist;
	
	@FindBy(xpath="//*[@id='adv-filter']")
	private WebElement showAllFilters;
	
	@FindBy(xpath="//*[@id='close']")
	private WebElement closelink;
	
	@FindBy(xpath="//*[@id='borrowersList1']//tr[1]//td[4]//a")
	private WebElement applyforloanlink;
	
	@FindBy(xpath="//*[@id='borrowersList1']//div//td[2]//a")
	private WebElement borroweridlink;
	
	// deposit money in borrower wallet
	
	@FindBy(xpath="//input[@value='Deposit Money In Borrower account']")
	private WebElement depositMoneyInBorrowerAccountbutton;
			
	@FindBy(xpath="//form[@id='depositMoneyToBorrower']//input[@id='amount']")
	private WebElement enterAmountTextbox;
			
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement deposit_submitbutton;
			
	@FindBy(xpath = "//span[contains(text(),'Transaction Completed Successfully')]")
	private WebElement transactionnotification;
	
	@FindBy(xpath="//*[@id='description']")
	private WebElement deposit_description;
	
	
	public void fillEmailFilter(String emailid) {
		try {
			Generics.waitForElement(driver, emailtextbox);
			emailtextbox.click();
			emailtextbox.sendKeys(emailid);
			//Generics.waitForElementToInvisible(driver, edit_bankdetailsaccountnumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnSearch() {
		try {
			Generics.waitForElement(driver, searchbox);
			searchbox.click();
			Generics.waitForFewSecondstoLoad(4000);
			//Generics.waitForElementToInvisible(driver, bankdetailstab);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getBorrowerId() {
		String borrower_id = null;
		try {
			
			Generics.waitForElement(driver, borrowerid);
			borrower_id=borrowerid.getText();
			//Generics.waitForElementToInvisible(driver, bankdetailstab);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return borrower_id;
	}
	
	public void validateSearchedBorrower(int i, String product) {
		try {
			switch (i) {
			case 0:
				//Generics.waitForElementToInvisible(driver, closelink);
				Generics.waitForElement(driver, borroweridlist);
				assertEquals(borroweridlist.getText(), product);
				break;

			case 1:
				//Generics.waitForElementToInvisible(driver, borroweridlist2);
				Generics.waitForElement(driver, emaillist);
				assertEquals(emaillist.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnApplyForLoanLink() {
		try {
			//Generics.waitForElementToInvisible(driver, closelink);
			Generics.waitForElement(driver, applyforloanlink);
			applyforloanlink.click();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnShowAllFiltersLink() {
		try {
			Generics.waitForElement(driver, showAllFilters);
			showAllFilters.click();
			Generics.waitForElementToInvisible(driver, showAllFilters);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clickOncloseLink() {
		try {
			Generics.waitForElement(driver, closelink);
			closelink.click();
			//Generics.waitForElementToInvisible(driver, closelink);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clearfillEmailFilter() {
		emailtextbox.click();
		emailtextbox.clear();
		//Generics.waitForElementToInvisible(driver, edit_bankdetailsaccountnumber);
	}
	
	public void clickOnExistingBorrowerIDLink() {
		try {
			Generics.waitForElement(driver, borroweridlink);
			borroweridlink.click();
			Generics.waitForElement(driver, depositMoneyInBorrowerAccountbutton);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */	
	public void clickDepositMoneyInBorrowerAccountbutton() {
		try {
			Generics.waitForElement(driver, depositMoneyInBorrowerAccountbutton);
			depositMoneyInBorrowerAccountbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */	
	public void enterDepositAmountforBorrower(String depositamount) {
		try {
			Generics.waitForElement(driver, enterAmountTextbox);
			enterAmountTextbox.click();
			enterAmountTextbox.clear();
			enterAmountTextbox.sendKeys(depositamount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */	
	public void enterDepositDescription(String description) {
		try {
			Generics.waitForElement(driver, deposit_description);
			deposit_description.click();
			deposit_description.clear();
			deposit_description.sendKeys(description);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */	
	public void clickSubmitButton() {
		try {
			Generics.waitForElement(driver, deposit_submitbutton);
			deposit_submitbutton.click();
			Generics.waitForElement(driver, transactionnotification);
			System.out.println(transactionnotification.getText());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}