package com.automationsaas.pom.dsa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;

public class DSAContractsPage {
	
	public WebDriver driver;

	public DSAContractsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='View Contract']")
	private WebElement viewcontractslink;
	
	@FindBy(xpath="//a[text()='Loan General Term']")
	private WebElement loangeneraltermlink;
	
	@FindBy(xpath="//a[text()='Bid Contract']")
	private WebElement bidcontractlink;
	
	@FindBy(id="accept")
	private WebElement acceptbutton;
	
	@FindBy(id="reject")
	private WebElement rejectbutton;
	
	@FindBy(xpath="//*[@id='content-wrapper']//h2")
	private WebElement contractlistheaderpage;
	
	
	
	public void clickViewDetails() {
		try {
			Generics.waitForElement(driver, viewcontractslink);
			viewcontractslink.click();
			Generics.waitForElement(driver, contractlistheaderpage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoanGeneralTermContract() {
		try {
			Generics.waitForElement(driver, loangeneraltermlink);
			loangeneraltermlink.click();
			Generics.waitForElement(driver, acceptbutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAcceptContract() {
		try {
			Generics.waitForElement(driver, acceptbutton);
			acceptbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBidContract() {
		try {
			Generics.waitForElement(driver, bidcontractlink);
			bidcontractlink.click();
			Generics.waitForElement(driver, rejectbutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickRejectContract() {
		try {
			Generics.waitForElement(driver, rejectbutton);
			rejectbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
