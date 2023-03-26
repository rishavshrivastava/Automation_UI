package com.automationsaas.pom.investoronboarding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class InvestorQuestionGroup1Page {

	public WebDriver driver;

	public InvestorQuestionGroup1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2")
	private WebElement investorquestiongroup1heading;
	
	@FindBy(xpath="//input[contains(@id,'cfgMapping')]")
	private WebElement downpaymenttextbox;
	
	@FindBy(xpath="//select[contains(@id,'cfgMapping')]")
	private WebElement borrowernationalitydropdown;
	
	@FindBy(id="submitCfAnswersButton")
	private WebElement submitbutton;
	
	
	public void validateInvestorQuestionGroup1Heading(String pageheading) {
		try {
			Generics.waitForElement(driver, investorquestiongroup1heading);
			if (investorquestiongroup1heading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Investor Question Group1 is displayed", true);
			} else
				Reporter.log("Investor Question Group1 is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateInvestorQuestionGroup1Heading", true);
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
		}
	}
	
	public void selectBorrowerNationality(String nationality) {
		try {
			Generics.waitForElement(driver, borrowernationalitydropdown);
			Select borrowerNationality = new Select(borrowernationalitydropdown);
			borrowerNationality.selectByVisibleText(nationality);
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
