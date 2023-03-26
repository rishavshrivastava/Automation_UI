package com.automationsaas.pom.adminborrower;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Generics;

public class BorrowersPage {

	public WebDriver driver;

	public BorrowersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='ajax-loader-spinner']//img")
	private WebElement borrowersdataspinner;
	
	@FindBy(id = "userId")
	private WebElement borroweridtextbox;

	@FindBy(id = "searchBorrower")
	private WebElement searchbutton;

	@FindBy(xpath = "//div[@id='borrowersList']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement borrowerresultspinner;
	
	@FindBy(xpath="//div[@id='borrowersList']//th[.='Borrower ID']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Borrower ID']/preceding-sibling::th)+1]")
	private WebElement borroweridtext;
	
	@FindBy(xpath="//div[@id='borrowersList']//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)+1]")
	private WebElement borroweremailidtext;
	
	@FindBy(xpath="//div[@id='borrowersList']//th[.='Borrower']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Borrower']/preceding-sibling::th)+1]")
	private WebElement borrowernametext;
	
	@FindBy(xpath="//div[@id='borrowersList']//th[.='Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type']/preceding-sibling::th)+1]")
	private WebElement borrowertypetext;
	
	@FindBy(xpath="//div[@id='borrowersList']//th[.='Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Status']/preceding-sibling::th)+1]")
	private WebElement borrowerstatustext;
	
	@FindBy(xpath="//div[@id='borrowersList']//th[.='Job Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Job Type']/preceding-sibling::th)+1]")
	private WebElement borrowerjobtypetext;
	
	@FindBy(xpath="//div[@id='borrowersList']//th[.='Gross Income']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Gross Income']/preceding-sibling::th)+1]")
	private WebElement borrowergrossincometext;
	
	public void enterUserId(String borrowerid) {
		try {
			Generics.waitForElementToInvisible(driver, borrowersdataspinner);
			Generics.waitForElement(driver, borroweridtextbox);
			borroweridtextbox.click();
			borroweridtextbox.clear();
			borroweridtextbox.sendKeys(borrowerid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSearch() {
		try {
			Generics.waitForElement(driver, searchbutton);
			searchbutton.click();
			Generics.waitForElementToInvisible(driver, borrowerresultspinner);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateSearchedBorrower(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, borroweridtext);
				assertEquals(borroweridtext.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, borroweremailidtext);
				assertEquals(borroweremailidtext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, borrowernametext);
				assertEquals(borrowernametext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, borrowertypetext);
				assertEquals(borrowertypetext.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, borrowerstatustext);
				assertEquals(borrowerstatustext.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, borrowerjobtypetext);
				assertEquals(borrowerjobtypetext.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, borrowergrossincometext);
				assertEquals(borrowergrossincometext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBorrower(String borrowerid) {
		try {
			WebElement borrowerlink = driver.findElement(By.xpath("//a[text()='" + borrowerid + "']"));
			Generics.waitForElement(driver, borrowerlink);
			borrowerlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
