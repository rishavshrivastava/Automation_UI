package com.automationsaas.pom.dsaonboarding;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class DSAQuestionGroup1Page extends Base {

	public WebDriver driver;
	public DSAQuestionGroup1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2")
	private WebElement headingtext;
	
	@FindBy(xpath="//label[text()='Down Payment']/following-sibling::input")
	private WebElement downpaymenttextbox;
	
	@FindBy(xpath="//label[text()='Borrower Nationality']/following-sibling::select")
	private WebElement borrowernationalitydropdown;
	
	@FindBy(id="submitCfAnswersButton")
	private WebElement submitbutton;
	
	
	public void validateHeading(String value) {
		try {
			Generics.waitForElement(driver, headingtext);
			assertEquals(headingtext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterDownpayment(String value) {
		try {
			Generics.waitForElement(driver, downpaymenttextbox);
			downpaymenttextbox.click();
			downpaymenttextbox.clear();
			downpaymenttextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectBorrowerNationality(String value) {
		try {
			Generics.waitForElement(driver, borrowernationalitydropdown);
			Select borrowerNationalityOptions = new Select(borrowernationalitydropdown);
			borrowerNationalityOptions.selectByVisibleText(value);
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
}
