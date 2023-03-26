package com.automationsaas.pom.investoronboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class EmploymentDetailsPage {

	public WebDriver driver;

	public EmploymentDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1")
	private WebElement employmentdetailsheading;
	
	@FindBy(id="employmentType")
	private WebElement employmenttypetextbox;
	
	@FindBy(id="organizationName")
	private WebElement organizationnametextbox;
	
	@FindBy(id="organizationType")
	private WebElement organizationtypetextbox;
	
	@FindBy(id="investorEmploymentDetailsTextVariable1")
	private WebElement investoremploymentdetailstextvariable1textbox;
	
	@FindBy(id="saveEmploymentDetails")
	private WebElement submitbutton;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	public void validateEmploymentDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, employmentdetailsheading);
			if (employmentdetailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Employment Details is displayed", true);
			} else
				Reporter.log("Employment Details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateEmploymentDetailsHeading", true);
		}
	}
	
	public void enterEmploymentTypes(String employmenttype) {
		try {
			Generics.waitForElement(driver, employmenttypetextbox);
			employmenttypetextbox.click();
			employmenttypetextbox.clear();
			employmenttypetextbox.sendKeys(employmenttype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterOrganizationName(String organizationname) {
		try {
			Generics.waitForElement(driver, organizationnametextbox);
			organizationnametextbox.click();
			organizationnametextbox.clear();
			organizationnametextbox.sendKeys(organizationname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterOrganizationType(String organizationtype) {
		try {
			Generics.waitForElement(driver, organizationtypetextbox);
			organizationtypetextbox.click();
			organizationtypetextbox.clear();
			organizationtypetextbox.sendKeys(organizationtype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterInvestorEmploymentDetailsTextVariable1(String InvestorEmploymentDetailsText) {
		try {
			Generics.waitForElement(driver, investoremploymentdetailstextvariable1textbox);
			investoremploymentdetailstextvariable1textbox.click();
			investoremploymentdetailstextvariable1textbox.clear();
			investoremploymentdetailstextvariable1textbox.sendKeys(InvestorEmploymentDetailsText);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSubmitButton() {
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
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
