package com.automationsaas.pom.adminfia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;

public class AssignedLoansPage {

	public WebDriver driver;

	public AssignedLoansPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//@FindBy(xpath="//b[contains(text(),'Assigned Loans')]")
	@FindBy(xpath="//a[contains(text(),'Assigned Loans')]")
	private WebElement assignedloanstab;
	
	@FindBy(xpath="//a[contains(text(),'Recent Loan Applications')]")
	private WebElement recentloanapplications_accordion;
	
	
	@FindBy(xpath="//a[contains(text(),'View Details')]")
	private WebElement viewdetailsbutton;
	
	public void clickAppliedLoans() {
		try {
			Generics.waitForElement(driver, assignedloanstab);
			assignedloanstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clickRecentLoanApplicationsAccordion() {
		try {
			Generics.waitForElement(driver, recentloanapplications_accordion);
			recentloanapplications_accordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickViewDetails() {
		try {
			Generics.waitForElement(driver, viewdetailsbutton);
			viewdetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
