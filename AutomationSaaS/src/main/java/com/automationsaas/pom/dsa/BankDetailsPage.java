package com.automationsaas.pom.dsa;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class BankDetailsPage extends Base {

	public WebDriver driver;

	public BankDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Bank Details')]")
	private WebElement bankdetailstab;

	@FindBy(xpath = "//th[.='Account Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Number']/preceding-sibling::th)+1]")
	private List<WebElement> accountnumbertext;

	@FindBy(xpath = "//th[.='Account Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Type']/preceding-sibling::th)+1]")
	private List<WebElement> accounttypetext;

	@FindBy(xpath = "//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private List<WebElement> banknametext;

	@FindBy(xpath = "//th[.='IFSC']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='IFSC']/preceding-sibling::th)+1]")
	private List<WebElement> ifsctext;

	@FindBy(xpath = "//th[.='Account Holder Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Account Holder Name']/preceding-sibling::th)+1]")
	private List<WebElement> accountholdername;

	@FindBy(xpath = "//th[.='Bank Address']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Address']/preceding-sibling::th)+1]")
	private List<WebElement> bankaddress;

	@FindBy(xpath = "//th[.='Date Of Opening Account']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Date Of Opening Account']/preceding-sibling::th)+1]")
	private List<WebElement> dateofopeningaccount;

	@FindBy(xpath = "//th[.='MIRC Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='MIRC Code']/preceding-sibling::th)+1]")
	private List<WebElement> micrcode;

	@FindBy(xpath = "//th[.='Branch Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Branch Name']/preceding-sibling::th)+1]")
	private List<WebElement> branchname;

	@FindBy(xpath = "//th[.='Swift Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Swift Code']/preceding-sibling::th)+1]")
	private List<WebElement> swiftcode;

	@FindBy(xpath = "//th[.='Branch Pin Code']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Branch Pin Code']/preceding-sibling::th)+1]")
	private List<WebElement> branchpincode;

	@FindBy(xpath = "//th[.='Branch City']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Branch City']/preceding-sibling::th)+1]")
	private List<WebElement> branchcity;

	@FindBy(xpath = "//th[.='Nature Of Facility']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Nature Of Facility']/preceding-sibling::th)+1]")
	private List<WebElement> natureoffacility;

	@FindBy(xpath = "//th[.='Bank Detail Text Variable 1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Detail Text Variable 1']/preceding-sibling::th)+1]")
	private List<WebElement> bankdetailstextvariable1textbox;

	@FindBy(xpath = "//i[@class='fa fa-edit']")
	private WebElement bankdetailseditbutton;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='accountNumber']")
	private WebElement edit_bankdetailsaccountnumber;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='accountHolderName']")
	private WebElement edit_bankdetailsaccountholdername;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='bankName']")
	private WebElement edit_bankdetailsbankname;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='bankAddress']")
	private WebElement edit_bankdetailsbankaddress;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='ifsc']")
	private WebElement edit_bankdetailsifsc;

	@FindBy(xpath = "//input[contains(@id,'dateOfOpeningAccount')]")
	private WebElement edit_bankdetailsdateofopeningacctextbox;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement edit_bankdetailsdateofopeningaccyeardropdown;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement edit_bankdetailsdateofopeningaccmonthdropdown;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> edit_bankdetailsdateofopeningaccdatelinks;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='bankAccountType']")
	private WebElement edit_bankdetailsaccounttype;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='micr']")
	private WebElement edit_bankdetailsmicr;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='branchName']")
	private WebElement edit_bankdetailsbranchname;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='swiftCode']")
	private WebElement edit_bankdetailsswiftcode;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='branchPinCode']")
	private WebElement edit_bankdetailsbranchpincode;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='branchCity']")
	private WebElement edit_bankdetailsbranchcity;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='natureOfFacility']")
	private WebElement edit_bankdetailsnatureoffacility;

	@FindBy(xpath = "//form[@id='bankDetailForm']//input[@id='bankDetailTextVariable1']")
	private WebElement edit_bankdetailstextvariable1;

	@FindBy(id = "submitBankDetailsButton")
	private WebElement edit_donebutton;

	@FindBy(xpath = "//div[@id='bank_details_list']/strong")
	private WebElement nobankdetailstext;

	@FindBy(xpath = "//button[@id='bank_detail_modal_opener']")
	private WebElement addbankdetailbutton;

	@FindBy(xpath = "//button[@id='submitBankDetailsButton']")
	private WebElement addbankdetailsdonebutton;

	@FindBy(xpath = "//span[contains(text(),'Updated')]")
	private WebElement addbankdetails_notifications;

	public void clickBankDetails() {
		try {
			Generics.waitForElement(driver, bankdetailstab);
			bankdetailstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateBankDetails(int n, int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, accountholdername.get(n));
				assertEquals(accountholdername.get(n).getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, accountnumbertext.get(n));
				assertEquals(accountnumbertext.get(n).getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, accounttypetext.get(n));
				assertEquals(accounttypetext.get(n).getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, banknametext.get(n));
				assertEquals(banknametext.get(n).getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, ifsctext.get(n));
				assertEquals(ifsctext.get(n).getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, bankaddress.get(n));
				assertEquals(bankaddress.get(n).getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, dateofopeningaccount.get(n));
				assertEquals(dateofopeningaccount.get(n).getText(), product);
				break;
				
			case 7:
				Generics.waitForElement(driver, micrcode.get(n));
				assertEquals(micrcode.get(n).getText(), product);
				break;

			case 8:
				Generics.waitForElement(driver, branchname.get(n));
				assertEquals(branchname.get(n).getText(), product);
				break;

			case 9:
				Generics.waitForElement(driver, swiftcode.get(n));
				assertEquals(swiftcode.get(n).getText(), product);
				break;

			case 10:
				Generics.waitForElement(driver, branchpincode.get(n));
				assertEquals(branchpincode.get(n).getText(), product);
				break;

			case 11:
				Generics.waitForElement(driver, branchcity.get(n));
				assertEquals(branchcity.get(n).getText(), product);
				break;

			case 12:
				Generics.waitForElement(driver, natureoffacility.get(n));
				assertEquals(natureoffacility.get(n).getText(), product);
				break;

			case 13:
				Generics.waitForElement(driver, bankdetailstextvariable1textbox.get(n));
				assertEquals(bankdetailstextvariable1textbox.get(n).getText(), product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editBankDetails(int i, String product, String year, String month, String date) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, edit_bankdetailsaccountholdername);
				edit_bankdetailsaccountholdername.click();
				edit_bankdetailsaccountholdername.clear();
				edit_bankdetailsaccountholdername.sendKeys(product);
				break;

			case 1:
				Generics.waitForElement(driver, edit_bankdetailsaccountnumber);
				edit_bankdetailsaccountnumber.click();
				edit_bankdetailsaccountnumber.clear();
				edit_bankdetailsaccountnumber.sendKeys(product);
				break;

			case 2:
				Generics.waitForElement(driver, edit_bankdetailsbankname);
				edit_bankdetailsbankname.click();
				edit_bankdetailsbankname.clear();
				edit_bankdetailsbankname.sendKeys(product);
				break;

			case 3:
				Generics.waitForElement(driver, edit_bankdetailsbankaddress);
				edit_bankdetailsbankaddress.click();
				edit_bankdetailsbankaddress.clear();
				edit_bankdetailsbankaddress.sendKeys(product);
				break;

			case 4:
				Generics.waitForElement(driver, edit_bankdetailsifsc);
				edit_bankdetailsifsc.click();
				edit_bankdetailsifsc.clear();
				edit_bankdetailsifsc.sendKeys(product);
				break;

			case 5:
				Generics.waitForElement(driver, edit_bankdetailsdateofopeningacctextbox);
				edit_bankdetailsdateofopeningacctextbox.click();

				Generics.waitForElement(driver, edit_bankdetailsdateofopeningaccyeardropdown);
				Select yeardropdown = new Select(edit_bankdetailsdateofopeningaccyeardropdown);
				yeardropdown.selectByVisibleText(year);

				Generics.waitForElement(driver, edit_bankdetailsdateofopeningaccmonthdropdown);
				Select monthdropdown = new Select(edit_bankdetailsdateofopeningaccmonthdropdown);
				monthdropdown.selectByVisibleText(month);

				for (int j = 0; j < edit_bankdetailsdateofopeningaccdatelinks.size(); j++) {
					if (edit_bankdetailsdateofopeningaccdatelinks.get(j).getText().equalsIgnoreCase(date))
						edit_bankdetailsdateofopeningaccdatelinks.get(j).click();
				}
				break;

			case 6:
				Generics.waitForElement(driver, edit_bankdetailsmicr);
				edit_bankdetailsmicr.click();
				edit_bankdetailsmicr.clear();
				edit_bankdetailsmicr.sendKeys(product);
				break;
				
			case 7:
				Generics.waitForElement(driver, edit_bankdetailsaccounttype);
				edit_bankdetailsaccounttype.click();
				edit_bankdetailsaccounttype.clear();
				edit_bankdetailsaccounttype.sendKeys(product);
				break;

			case 8:
				Generics.waitForElement(driver, edit_bankdetailsbranchname);
				edit_bankdetailsbranchname.click();
				edit_bankdetailsbranchname.clear();
				edit_bankdetailsbranchname.sendKeys(product);
				break;

			case 9:
				Generics.waitForElement(driver, edit_bankdetailsswiftcode);
				edit_bankdetailsswiftcode.click();
				edit_bankdetailsswiftcode.clear();
				edit_bankdetailsswiftcode.sendKeys(product);
				break;

			case 10:
				Generics.waitForElement(driver, edit_bankdetailsbranchpincode);
				edit_bankdetailsbranchpincode.click();
				edit_bankdetailsbranchpincode.clear();
				edit_bankdetailsbranchpincode.sendKeys(product);
				break;

			case 11:
				Generics.waitForElement(driver, edit_bankdetailsbranchcity);
				edit_bankdetailsbranchcity.click();
				edit_bankdetailsbranchcity.clear();
				edit_bankdetailsbranchcity.sendKeys(product);
				break;

			case 12:
				Generics.waitForElement(driver, edit_bankdetailsnatureoffacility);
				edit_bankdetailsnatureoffacility.click();
				edit_bankdetailsnatureoffacility.clear();
				edit_bankdetailsnatureoffacility.sendKeys(product);
				break;

			case 13:
				Generics.waitForElement(driver, edit_bankdetailstextvariable1);
				edit_bankdetailstextvariable1.click();
				edit_bankdetailstextvariable1.clear();
				edit_bankdetailstextvariable1.sendKeys(product);
				break;

			default:
				Reporter.log("No value found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBankDetailsEdit() {
		try {
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
			Generics.waitForElementToInvisible(driver, edit_bankdetailsaccountnumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getBankDetailsCount() {
		return Generics.getElementCount(accountnumbertext);
	}

	public void validateIfNoBankDetails(String value) {
		try {
			Generics.waitForElement(driver, nobankdetailstext);
			assertEquals(nobankdetailstext.getText(), value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddBankDetails() {
		try {
			Generics.waitForElement(driver, addbankdetailbutton);
			addbankdetailbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddBankDetailsDone() {
		try {
			Generics.waitForElement(driver, addbankdetailsdonebutton);
			addbankdetailsdonebutton.click();
			Generics.waitForElement(driver, addbankdetails_notifications);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
