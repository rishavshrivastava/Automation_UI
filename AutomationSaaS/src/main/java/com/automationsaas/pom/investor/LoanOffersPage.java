package com.automationsaas.pom.investor;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class LoanOffersPage extends Base {
	
	public WebDriver driver;
	public LoanOffersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='loanId']")
	private WebElement loanidtextbox;
	
	@FindBy(id="loanSearchBtn")
	private WebElement searchbutton;
	
	@FindBy(xpath="//span[text()='1']")
	private WebElement paginationnumber_1;
	
	@FindBy(xpath="//th[.='Loan Id']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Id']/preceding-sibling::th)+1]/a")
	private WebElement loanidtext;
	
	@FindBy(xpath="//th[.='Loan Tenure']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Tenure']/preceding-sibling::th)+1]")
	private WebElement loantenuretext;
	
	@FindBy(xpath="//th[.='Interest(%)']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Interest(%)']/preceding-sibling::th)+1]")
	private WebElement interesttext;
	
	@FindBy(xpath="//th[.='Amount(Rs)']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount(Rs)']/preceding-sibling::th)+1]")
	private WebElement amounttext;
	
	@FindBy(id="progressBarSpan")
	private WebElement progressbar;
	
	@FindBy(xpath="//a[text()='Fund Now']")
	private WebElement fundnowbutton;
	
	public void enterLoanId(String product) {
		try {
			Generics.waitForElement(driver, loanidtextbox);
			loanidtextbox.click();
			loanidtextbox.clear();
			loanidtextbox.sendKeys(product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSearch() {
		try {
			Generics.waitForElement(driver, searchbutton);
			searchbutton.click();
//			Generics.waitForElementToInvisible(driver, paginationnumber_1);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateSearchedLoanOffers(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, loanidtext);
				assertEquals(loanidtext.getText(), product);
				break;
				
			case 1:
				Generics.waitForElement(driver, loantenuretext);
				assertEquals(loantenuretext.getText(), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, interesttext);
				assertEquals(interesttext.getText(), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, amounttext);
				assertEquals(amounttext.getText(), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void progressBarPercentage(String product) {
		try {
			Generics.waitForElement(driver, progressbar);
			assertEquals(progressbar.getText(), product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickFundNow() {
		try {
			Generics.waitForElement(driver, fundnowbutton);
			fundnowbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoanId(String product) {
		try {
			Generics.waitForElement(driver, loanidtext);
			if(loanidtext.getText().equalsIgnoreCase(product)) {
				loanidtext.click();
			}
			else Reporter.log("Loan ID not correct", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
