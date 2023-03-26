package com.automationsaas.pom.fia;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;

public class DashboardPage {
	public WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//span[@class='name']")
	@FindBy(xpath="(//div[@class='logobox']//span)[3]")
	private WebElement fianametext;
	
	//@FindBy(id="fiaId")
	@FindBy(xpath="(//div[@class='logobox']//span)[3]")
	private WebElement fiaIdtext;

	//@FindBy(xpath="//h5/span")
	@FindBy( xpath="//h5[contains(text(),'Profile Status')]")
	private WebElement profilestatustext;
	
	@FindBy(id="availableCashHeader")
	private WebElement accountbalancetext;

	@FindBy(xpath="//span[text()='Account']")
	private WebElement accountlink;
	
	@FindBy(xpath="//li[@id='fia_profile']//*[contains(text(),'Profile')]")
	private WebElement profilelink;
	
	//FIA assigned loans
	@FindBy(xpath="//a[text()='Details']")
	private WebElement fialoandetailslink;
	
	@FindBy(xpath="//div[@id='tab-home']//strong")
	private WebElement fiaassignedloanid;
	
	@FindBy(xpath="//div[@id='tab-home']//a[contains(text(),'Loan Overview')]")
	private WebElement loanoverviewaccordion;
	
	public String getFIAName() {
		String fiaName = null;
		try {
			Generics.waitForElement(driver, fianametext);
			//fiaName = fianametext.getText();
			fiaName = fianametext.getText().split("\\n")[0];
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return fiaName;
	}
	
	
	
	public String getFIAId() {
		String fiaId = null;
		try {
			Generics.waitForElement(driver, fiaIdtext);
			//fiaId = fiaIdtext.getText();
			  fiaId = fiaIdtext.getText().split("\\n") [1];
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return fiaId;
	}

	public void validateFIAName(String value) {
		try {
			Generics.waitForElement(driver, fianametext);
			String actualName=fianametext.getText().split("\\n")[0];
			assertEquals(actualName, value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateFIAId(String value) {
		try {
			Generics.waitForElement(driver, fiaIdtext);
			String actualID=fiaIdtext.getText().split("\\n") [1];
			assertEquals(actualID, value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateProfileStatus(String value) {
		try {
			Generics.waitForElement(driver, profilestatustext);
			assertEquals(profilestatustext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateAccountBalance(String value) {
		try {
			Generics.waitForElement(driver, accountbalancetext);
			assertEquals(accountbalancetext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAccount() {
		try {
			Generics.waitForElement(driver, accountlink);
			accountlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickProfile() {
		try {
			Generics.waitForElement(driver, profilelink);
			profilelink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnLoanDetailsLink() {
		try {
			Generics.waitForElement(driver, fialoandetailslink);
			fialoandetailslink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateLoanIDassignedtoFIA(String actualloanid) {
			try {
				Generics.waitForElement(driver, loanoverviewaccordion);
				String loanDetails[]=loanoverviewaccordion.getText().split(":");
				String loanId=loanDetails[1].trim();
				assertEquals(loanId, actualloanid);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
