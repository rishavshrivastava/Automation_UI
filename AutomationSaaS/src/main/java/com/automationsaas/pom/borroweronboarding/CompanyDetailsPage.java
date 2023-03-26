package com.automationsaas.pom.borroweronboarding;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class CompanyDetailsPage {

	public WebDriver driver;

	public CompanyDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement detailsheading;
	
	@FindBy(id="companyName")
	private WebElement companynametextbox;
	
	@FindBy(id="companyRegistrationCode")
	private WebElement companyregistrationnumbertextbox;
	
	@FindBy(id="companyTurnover")
	private WebElement companyturnovertextbox;
	
	@FindBy(xpath="//input[contains(@id,'dateOfArticle')]")
	private WebElement dateofarticletextbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks;
	
	@FindBy(id="line1")
	private WebElement addresslineonetextbox;
	
	@FindBy(id="line2")
	private WebElement addresslinetwotextbox;
	
	@FindBy(id="line3")
	private WebElement addresslinethreetextbox;
	
	@FindBy(id="state")
	private WebElement statetextbox;
	
	@FindBy(id="city")
	private WebElement citytextbox;
	
	@FindBy(id="zipCode")
	private WebElement zipcodetextbox;
	
	@FindBy(id="saveCompanyDetails")
	private WebElement continuebutton;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	private WebElement skipbutton;
	
	public void clickSkip() {
		try {
			Generics.waitForElement(driver, skipbutton);
			skipbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateCompanyDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, detailsheading);
			if (detailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Company Details is displayed", true);
			} else
				Reporter.log("Company Details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateCompanyDetailsHeading", true);
		}
	}
	
	public void enterCompanyName(String companyname) {
		try {
			Generics.waitForElement(driver, companynametextbox);
			companynametextbox.click();
			companynametextbox.clear();
			companynametextbox.sendKeys(companyname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterCompanyRegistrationNumber(String companyregistrationnumber) {
		try {
			Generics.waitForElement(driver, companyregistrationnumbertextbox);
			companyregistrationnumbertextbox.click();
			companyregistrationnumbertextbox.clear();
			companyregistrationnumbertextbox.sendKeys(companyregistrationnumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterCompanyTurnOver(String companyturnover) {
		try {
			Generics.waitForElement(driver, companyturnovertextbox);
			companyturnovertextbox.click();
			companyturnovertextbox.clear();
			companyturnovertextbox.sendKeys(companyturnover);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectDateOfArticles(String year, String month, String date) {
		try {
			Generics.waitForElement(driver, dateofarticletextbox);
			dateofarticletextbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select years = new Select(yeardropdown);
			years.selectByVisibleText(year);
			Generics.waitForElement(driver, monthdropdown);
			Select months = new Select(monthdropdown);
			months.selectByVisibleText(month);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(date)) {
					datelinks.get(i).click();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in selectDateOfArticles", true);
		}
	}
	
	public void enterAddress(String line1, String line2, String line3, String state, String city, String zipcode) {
		try {
			Generics.waitForElement(driver, addresslineonetextbox);
			addresslineonetextbox.click();
			addresslineonetextbox.clear();
			addresslineonetextbox.sendKeys(line1);
			
			Generics.waitForElement(driver, addresslinetwotextbox);
			addresslinetwotextbox.click();
			addresslinetwotextbox.clear();
			addresslinetwotextbox.sendKeys(line2);
			
			Generics.waitForElement(driver, addresslinethreetextbox);
			addresslinethreetextbox.click();
			addresslinethreetextbox.clear();
			addresslinethreetextbox.sendKeys(line3);
			
			Generics.waitForElement(driver, statetextbox);
			Select stateOptions = new Select(statetextbox);
			stateOptions.selectByVisibleText(state);
			
			Generics.waitForElement(driver, citytextbox);
			citytextbox.click();
			citytextbox.clear();
			citytextbox.sendKeys(city);
			
			Generics.waitForElement(driver, zipcodetextbox);
			zipcodetextbox.click();
			zipcodetextbox.clear();
			zipcodetextbox.sendKeys(zipcode);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Reporter.log("Error in enterAddress", true);
		}
	}
	
	public void clickContinue() {
		try {
			Generics.waitForElement(driver, continuebutton);
			continuebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
