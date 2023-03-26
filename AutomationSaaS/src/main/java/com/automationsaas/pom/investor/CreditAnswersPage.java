package com.automationsaas.pom.investor;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class CreditAnswersPage extends Base {

	public WebDriver driver;

	public CreditAnswersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Credit Answers']")
	private WebElement creditanswerstab;
	
	@FindBy(xpath="//a[contains(text(),'Investor Question Group 1')]")
	private WebElement investorquestiongroup1accordion;

	@FindBy(xpath = "//label[text()='Down Payment']/following-sibling::input")
	private WebElement downpaymenttextbox;

	@FindBy(xpath = "//label[text()='Borrower Nationality']/following-sibling::select")
	private WebElement borrowernationalitydropdown;

	@FindBy(id = "button_cfInvAnswersFormId_Investor Question Group 1")
	private WebElement submitbutton;
	
	@FindBy(xpath="//span[contains(text(),'updated')]")
	private WebElement creditanswersupdatenotification;

	public void clickCreditAnswers() {
		try {
			Generics.waitForElement(driver, creditanswerstab);
			creditanswerstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCreditAnswersAccordion() {
		try {
			Generics.waitForElement(driver, investorquestiongroup1accordion);
			investorquestiongroup1accordion.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateCreditAnswers(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, downpaymenttextbox);
				assertEquals(downpaymenttextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, borrowernationalitydropdown);
				Select borrowernationality = new Select(borrowernationalitydropdown);
				WebElement borrowernationalityoptions = borrowernationality.getFirstSelectedOption();
				assertEquals(borrowernationalityoptions.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editCreditAnswers(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, downpaymenttextbox);
				downpaymenttextbox.click();
				downpaymenttextbox.clear();
				downpaymenttextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, borrowernationalitydropdown);
				Select borrowernationality = new Select(borrowernationalitydropdown);
				borrowernationality.selectByVisibleText(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSubmit() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
			Generics.waitForElement(driver, creditanswersupdatenotification);
			Generics.waitForElement(driver, submitbutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkIfCreditAnswersFieldsAreDisabled(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, downpaymenttextbox);
				assertEquals(downpaymenttextbox.getAttribute("disabled"), product);
				break;
				
			case 1:
				Generics.waitForElement(driver, borrowernationalitydropdown);
				assertEquals(borrowernationalitydropdown.getAttribute("disabled"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
