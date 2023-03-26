package com.automationsaas.pom.investor;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class BankDetailsPage extends Base {

	public WebDriver driver;
	public BankDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='bank_detail_tab']//a[text()='Bank Details']")
	private WebElement bankdetailstab;
	
	@FindBy(xpath = "//th[.='Account Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Number']/preceding-sibling::th)+1]")
	private List<WebElement> accountnumbertext;

	@FindBy(xpath = "//th[.='Account Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Type']/preceding-sibling::th)+1]")
	private List<WebElement> accounttypetext;

	@FindBy(xpath = "//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private List<WebElement> banknametext;

	@FindBy(xpath = "//th[.='IFSC']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='IFSC']/preceding-sibling::th)+1]")
	private List<WebElement> ifsctext;
	
	@FindBy(xpath="//i[@class='fa fa-edit']")
	private WebElement bankdetailseditbutton;
	
	@FindBy(xpath="//form[@id='bankDetailForm']//input[@id='accountNumber']")
	private WebElement edit_bankdetailsaccountnumber;
	
	@FindBy(xpath="//form[@id='bankDetailForm']//input[@id='bankName']")
	private WebElement edit_bankdetailsbankname;
	
	@FindBy(xpath="//form[@id='bankDetailForm']//input[@id='ifsc']")
	private WebElement edit_edit_bankdetailsifsc;
	
	@FindBy(xpath="//form[@id='bankDetailForm']//input[@id='bankAccountType']")
	private WebElement edit_bankdetailsaccounttype;
	
	@FindBy(id="submitBankDetailsButton")
	private WebElement edit_donebutton;
	
	@FindBy(xpath="//span[contains(text(),'Updated')]")
	private WebElement bankdetailsupdatenotification;
	
	@FindBy(xpath="//div[@id='modal-borrower-bankDetail']//button[text()='×']")
	private WebElement bankdetails_popupclose;
	
	@FindBy(xpath="//div[@id='bank_details_list']//strong")
	private WebElement nobankdetailsnotification;
	
	@FindBy(xpath="//button[@id='bank_detail_modal_opener']")
	private WebElement bankdetails_addbankdetailsbutton;
	
	@FindBy(xpath="//div[@id='bank_detail']//a[contains(text(),'Bank Details')]")
	private WebElement bankdetailsaccordionlink;
	
	public void clickBankDetailsAccordion() {
		try {
			Generics.waitForElement(driver, bankdetailsaccordionlink);
			bankdetailsaccordionlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBankDetails() {
		try {
			Generics.waitForElement(driver, bankdetailstab);
			bankdetailstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBankDetailsEdit() {
		try {
			Thread.sleep(2000);
			Generics.waitForElement(driver, bankdetailseditbutton);
			bankdetailseditbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickBankDetailsEditDone() {
		try {
			Generics.waitForElement(driver, edit_donebutton);
			edit_donebutton.click();
			Generics.waitForElement(driver, bankdetailsupdatenotification);
			Generics.waitForElementToInvisible(driver, edit_bankdetailsaccountnumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public int getBankDetailsCount() {
		return Generics.getElementCount(accountnumbertext);
	}
	 
	
	public void validateBankDetails(int n, int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, accountnumbertext.get(n));
				assertEquals(accountnumbertext.get(n).getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, accounttypetext.get(n));
				assertEquals(accounttypetext.get(n).getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, banknametext.get(n));
				assertEquals(banknametext.get(n).getText(), product);
				break;
				
			case 3:
				Generics.waitForElement(driver, ifsctext.get(n));
				assertEquals(ifsctext.get(n).getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editBankDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, edit_bankdetailsaccountnumber);
				edit_bankdetailsaccountnumber.click();
				edit_bankdetailsaccountnumber.clear();
				edit_bankdetailsaccountnumber.sendKeys(product);
				break;
				
			case 1:
				Generics.waitForElement(driver, edit_bankdetailsbankname);
				edit_bankdetailsbankname.click();
				edit_bankdetailsbankname.clear();
				edit_bankdetailsbankname.sendKeys(product);
				break;
				
			case 2:
				Generics.waitForElement(driver, edit_edit_bankdetailsifsc);
				edit_edit_bankdetailsifsc.click();
				edit_edit_bankdetailsifsc.clear();
				edit_edit_bankdetailsifsc.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, edit_bankdetailsaccounttype);
				edit_bankdetailsaccounttype.click();
				edit_bankdetailsaccounttype.clear();
				edit_bankdetailsaccounttype.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Divya
	
	public void clickBankDetailsPopupClose() {
		try {
			Generics.waitForElement(driver, bankdetails_popupclose);
			bankdetails_popupclose.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateBankDetailsInPopup(int i, String product) {
		try {
			switch (i) {
		
			case 0:
				Generics.waitForElement(driver, edit_bankdetailsaccountnumber);
				assertEquals(edit_bankdetailsaccountnumber.getAttribute("value"), product);
				break;
			case 1:
				Generics.waitForElement(driver, edit_bankdetailsbankname);
				assertEquals(edit_bankdetailsbankname.getAttribute("value"), product);
				break;
				
			case 2:
				Generics.waitForElement(driver, edit_edit_bankdetailsifsc);
				assertEquals(edit_edit_bankdetailsifsc.getAttribute("value"), product);
				Generics.scrollPage(driver,800 );
				break;
				
			case 3:
				Generics.waitForElement(driver, edit_bankdetailsaccounttype);
				assertEquals(edit_bankdetailsaccounttype.getAttribute("value"), product);
				break;
				

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void noBankDetailsMessage(String text)
	{
		try {
		Generics.waitForElement(driver, nobankdetailsnotification);
		assertEquals(nobankdetailsnotification.getText(), text);
		}
		catch(InterruptedException e)
		{
		e.printStackTrace();	;
		}
	}
	
	public void clickAddBankDetails() {
		try {
			Generics.waitForElement(driver, bankdetails_addbankdetailsbutton);
			bankdetails_addbankdetailsbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void addBankDetails(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, edit_bankdetailsaccountnumber);
				edit_bankdetailsaccountnumber.click();
				edit_bankdetailsaccountnumber.clear();
				edit_bankdetailsaccountnumber.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, edit_bankdetailsbankname);
				edit_bankdetailsbankname.click();
				edit_bankdetailsbankname.clear();
				edit_bankdetailsbankname.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, edit_edit_bankdetailsifsc);
				edit_edit_bankdetailsifsc.click();
				edit_edit_bankdetailsifsc.clear();
				edit_edit_bankdetailsifsc.sendKeys(product);
				break;
				
			case 3:
				Generics.waitForElement(driver, edit_bankdetailsaccounttype);
				edit_bankdetailsaccounttype.click();
				edit_bankdetailsaccounttype.clear();
				edit_bankdetailsaccounttype.sendKeys(product);
				break;
				
			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
