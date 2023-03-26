package com.automationsaas.pom.admindsa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class DSAPage extends Base {
	
	public WebDriver driver;
	public DSAPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement emailtextbox;
	
	@FindBy(id="search")
	private WebElement searchbutton;
	
	@FindBy(xpath="//th[.='Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Name']/preceding-sibling::th)+1]")
	private WebElement nametext;
	
	@FindBy(xpath="//th[.='STATUS']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='STATUS']/preceding-sibling::th)+1]")
	private WebElement statustext;
	
	@FindBy(xpath="//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)+1]")
	private WebElement emailtext;
	
	@FindBy(xpath="//th[.='No. of Loan Applications']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='No. of Loan Applications']/preceding-sibling::th)+1]")
	private WebElement numberofloanapplicationstext;
	
	@FindBy(xpath="//i[@class='fa fa-edit']")
	private WebElement actionbutton;
	
	@FindBy(xpath = "//*[@id='dsaList']//td[5]")
	private WebElement numberofloanapplication;
	
	
	public void enterEmail(String product) {
		try {
			Generics.waitForElement(driver, emailtextbox);
			emailtextbox.click();
			emailtextbox.clear();
			//Generics.waitForFewSecondstoLoad(1000);
			emailtextbox.sendKeys(product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSearch() {
		try {
			Generics.waitForElement(driver, searchbutton);
			searchbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateSearchedDSA(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, nametext);
				assertEquals(nametext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, statustext);
				assertEquals(statustext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, emailtext);
				assertEquals(emailtext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, numberofloanapplicationstext);
				assertEquals(numberofloanapplicationstext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAction() {
		try {
			Generics.waitForElement(driver, actionbutton);
			actionbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author chandrashekar
	 *
	 */
	//Validate Number of loan applications
	public void validatenumberLoanApplications() {
		 {
			String zero="0";
			try {
				Generics.waitForElement(driver, numberofloanapplication);
				String count=numberofloanapplication.getText();
				assertNotEquals(zero, count,"No loan applications found for this dsa, as to check upload download contracts we need to have atleast one loan and this also indicates DSA Apply Loan for New/Existing borrower test cases have failed - so no loans created.");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
