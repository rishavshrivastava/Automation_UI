package com.automationsaas.pom.admintransaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;

public class AwaitingTransactionsPage {

	public WebDriver driver;
	public AwaitingTransactionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//i[@class='fa fa-check'])[1]")
	private WebElement accepttransactionlink;
	
	@FindBy(xpath="(//i[@class='fa fa-times'])[1]")
	private WebElement rejecttransactionlink;
	
	@FindBy(xpath="//span[text()='Transaction Rejected']")
	private WebElement rejecttransactionnotification;
	
	public void acceptTransaction() {
		try {
			Generics.waitForElement(driver, accepttransactionlink);
			accepttransactionlink.click();
			Generics.alertAction(driver, "Yes");
			Generics.waitForFewSecondstoLoad(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void rejectTransaction() {
		try {
			Generics.waitForElement(driver, rejecttransactionlink);
			rejecttransactionlink.click();
			Generics.alertAction(driver, "Yes");
			Generics.waitForElement(driver, rejecttransactionnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
