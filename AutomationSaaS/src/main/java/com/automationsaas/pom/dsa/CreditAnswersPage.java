package com.automationsaas.pom.dsa;

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

	@FindBy(xpath = "//a[contains(text(),'Credit Answers')]")
	private WebElement creditanswerstab;
	
	@FindBy(xpath="//a[contains(text(),'DSA Question Group 1')]")
	private WebElement dsaquestiongroup1accordionlink;

	@FindBy(xpath = "//label[text()='Down Payment']/following-sibling::input")
	private WebElement downpaymenttextbox;

	@FindBy(xpath = "//label[text()='Borrower Nationality']/following-sibling::select")
	private WebElement borrowernationalitydropdown;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitbutton;

	public void clickCreditAnswers() {
		try {
			Generics.waitForElement(driver, creditanswerstab);
			creditanswerstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDSAQuestionGroup1Accordion() {
		try {
			Generics.waitForElement(driver, dsaquestiongroup1accordionlink);
			dsaquestiongroup1accordionlink.click();
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
				Select borrowerNationalityOptions = new Select(borrowernationalitydropdown);
				assertEquals(borrowerNationalityOptions.getFirstSelectedOption().getText(), product);
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
			Generics.waitForElement(driver, submitbutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void checkIfCreditAnswersAreDisabled(int i, String product) {
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