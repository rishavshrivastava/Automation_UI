package com.automationsaas.pom.investor;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class EmploymentDetailsPage extends Base {

	public WebDriver driver;
	public EmploymentDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Employment Details']")
	private WebElement employmentdetailstab;
	
	@FindBy(id="employmentType")
	private WebElement employmenttextbox;
	
	@FindBy(id="organizationName")
	private WebElement organizationnametextbox;
	
	@FindBy(id="organizationType")
	private WebElement organizationtypetextbox;
	
	@FindBy(id="investorEmploymentDetailsTextVariable1")
	private WebElement investoremploymentdetailstextvariable1textbox;
	
	@FindBy(xpath="//span[contains(text(),'updated')]")
	private WebElement employmentprofileupdatenotification;
	
	@FindBy(xpath="//div[@id='submitButtonEmploymentDetail']//button[text()='Update']")
	private WebElement employmentdetailsupdatebutton;
	
	public void clickEmploymentDetails() {
		try {
			Generics.waitForElement(driver, employmentdetailstab);
			employmentdetailstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateEmploymentDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, employmenttextbox);
				assertEquals(employmenttextbox.getAttribute("value"), product);
				break;

			case 1:
				Generics.waitForElement(driver, organizationnametextbox);
				assertEquals(organizationnametextbox.getAttribute("value"), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, organizationtypetextbox);
				assertEquals(organizationtypetextbox.getAttribute("value"), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, investoremploymentdetailstextvariable1textbox);
				assertEquals(investoremploymentdetailstextvariable1textbox.getAttribute("value"), product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editEmploymentDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, employmenttextbox);
				employmenttextbox.click();
				employmenttextbox.clear();
				employmenttextbox.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, organizationnametextbox);
				organizationnametextbox.click();
				organizationnametextbox.clear();
				organizationnametextbox.sendKeys(product);
				break;
				
			case 2:
				Generics.waitForElement(driver, organizationtypetextbox);
				organizationtypetextbox.click();
				organizationtypetextbox.clear();
				organizationtypetextbox.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, investoremploymentdetailstextvariable1textbox);
				investoremploymentdetailstextvariable1textbox.click();
				investoremploymentdetailstextvariable1textbox.clear();
				investoremploymentdetailstextvariable1textbox.sendKeys(product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEmploymentDetailsUpdate() {
		try {
			Generics.waitForElement(driver, employmentdetailsupdatebutton);
			employmentdetailsupdatebutton.click();
			Generics.waitForElement(driver, employmentprofileupdatenotification);
			Generics.waitForElement(driver, employmentdetailsupdatebutton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
