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

public class BorrowerQuestionGroup1Page {

	public WebDriver driver;

	public BorrowerQuestionGroup1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2")
	private WebElement borrowerquestiongroup1heading;
	
	@FindBy(id="cfgMapping_3487")
	private WebElement borrowernationalitydropdown;
	
	@FindBy(id="cfgMapping_3486")
	private WebElement downpaymenttextbox;
	
	@FindBy(id="submitCfAnswersButton")
	private WebElement submitbutton;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	private WebElement skipbutton;
	
	@FindBy(xpath="//div[@id='cfgSignUpFormTemplateId']//li")
	private List<WebElement> errormessages;
	
	public void clickSkip() {
		try {
			Generics.waitForElement(driver, skipbutton);
			skipbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateBorrowerQuestionGroup1Heading(String pageheading) {
		try {
			Generics.waitForElement(driver, borrowerquestiongroup1heading);
			if (borrowerquestiongroup1heading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Borrower Question Group is displayed", true);
			} else
				Reporter.log("Borrower Question Group is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateBorrowerQuestionGroup1Heading", true);
		}
	}
	
	public void selectBorrowerNationality(String nationality) {
		try {
			Generics.waitForElement(driver, borrowernationalitydropdown);
			Select borrowerNationality = new Select(borrowernationalitydropdown);
			borrowerNationality.selectByVisibleText(nationality);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectBorrowerNationality", true);
		}
	}
	
	public void enterDownPayment(String downpayment) {
		try {
			Generics.waitForElement(driver, downpaymenttextbox);
			downpaymenttextbox.click();
			downpaymenttextbox.clear();
			downpaymenttextbox.sendKeys(downpayment);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterDownPayment", true);
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
					assertEquals(true, false);
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
