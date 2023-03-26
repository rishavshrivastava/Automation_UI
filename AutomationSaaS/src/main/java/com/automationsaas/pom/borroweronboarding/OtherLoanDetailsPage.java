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

public class OtherLoanDetailsPage {

	public WebDriver driver;

	public OtherLoanDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1")
	private WebElement otherloandetailsheading;
	
	@FindBy(id="purpose")
	private WebElement loanpurposetextbox;
	
	@FindBy(id="loanAmount")
	private WebElement loanamounttextbox;
	
	@FindBy(id="repaymentAmount")
	private WebElement repaymentamounttextbox;
	
	@FindBy(id="outstandingPrincipal")
	private WebElement principaloutstandingtextbox;	
	
	@FindBy(id="bankName")
	private WebElement banknametextbox;
	
	@FindBy(id="bankAccountNumber")
	private WebElement bankaccountnumbertextbox;
	
	@FindBy(xpath="//input[contains(@id,'startDate')]")
	private WebElement startdatetextbox;
	
	@FindBy(xpath="//input[contains(@id,'endDate')]")
	private WebElement enddatetextbox;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement yeardropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement monthdropdown;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	private List<WebElement> datelinks;
	
	@FindBy(id="remainingTenure")
	private WebElement remainingtenuretextbox;
	
	@FindBy(id="otherLoanType")
	private WebElement loantypetextbox;
	
	@FindBy(id="otherLoanTextVariable1")
	private WebElement loanextratextvariable1textbox;
	
	@FindBy(id="otherLoanTextVariable2")
	private WebElement loanextratextvariable2textbox;
	
	@FindBy(id="createOtherLoanAjxBtn")
	private WebElement addmorebutton;
	
	@FindBy(xpath="//div[@id='waitingSpinnerCreateLoan']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement addmorespinner;
	
	@FindBy(xpath="//th[.='LoanPurpose']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='LoanPurpose']/preceding-sibling::th)+1]")
	private WebElement savedotherloandetailsloanpurpose;
	
	@FindBy(xpath="//th[.='Loan Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Amount']/preceding-sibling::th)+1]")
	private WebElement savedotherloandetailsloanamount;
	
	@FindBy(xpath="//th[.='Repayment Amount']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Repayment Amount']/preceding-sibling::th)+1]")
	private WebElement savedotherloandetailsrepaymentamount;
	
	@FindBy(xpath="//th[.='Principal Outstanding']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Principal Outstanding']/preceding-sibling::th)+1]")
	private WebElement savedotherloandetailsprincipaloutstanding;
	
	@FindBy(xpath="//th[.='Bank Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Name']/preceding-sibling::th)+1]")
	private WebElement savedloandetailsbankname;
	
	@FindBy(xpath="//th[.='Bank Account Number']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Bank Account Number']/preceding-sibling::th)+1]")
	private WebElement savedotherloandetailsbankaccountnumber;
	
	@FindBy(xpath="//th[.='Start Date']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Start Date']/preceding-sibling::th)+1]")
	private WebElement savedotherloandetailsstartdate;
	
	@FindBy(xpath="//th[.='End Date']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='End Date']/preceding-sibling::th)+1]")
	private WebElement savedotherloandetailsenddate;
	
	@FindBy(xpath="//th[.='Remaining Tenure']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Remaining Tenure']/preceding-sibling::th)+1]")
	private WebElement savedotherloandetailsremainingtenure;
	
	@FindBy(xpath="//th[.='Loan Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Type']/preceding-sibling::th)+1]")
	private WebElement savedotherloandetailsloantype;
	
	@FindBy(xpath="//th[.='Loan extra text variable1']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan extra text variable1']/preceding-sibling::th)+1]")
	private WebElement savedloandetailsloanextratextvariableone;
	
	@FindBy(xpath="//th[.='Loan extra text variable2']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan extra text variable2']/preceding-sibling::th)+1]")
	private WebElement savedloandetailsloanextratextvariabletwo;
	
	@FindBy(id="edit_bank_detail_modal_opener")
	private WebElement editbutton;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[@id='purpose']")
	private WebElement updateloanpurposetextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[@id='loanAmount']")
	private WebElement updateloanamounttextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[@id='repaymentAmount']")
	private WebElement updaterepaymentamounttextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[@id='outstandingPrincipal']")
	private WebElement updateprincipaloutstandingtextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[@id='bankName']")
	private WebElement updatebanknametextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[@id='bankAccountNumber']")
	private WebElement updatebankaccountnumbertextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[contains(@id,'startDate')]")
	private WebElement updatestartdatetextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[contains(@id,'endDate')]")
	private WebElement updateenddatetextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[contains(@id,'remainingTenure')]")
	private WebElement updateremainingtenuretextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[contains(@id,'otherLoanType')]")
	private WebElement updateloantypetextbox;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[@id='otherLoanTextVariable1']")
	private WebElement updateloanextratextvariable1;
	
	@FindBy(xpath="//form[@id='otherLoanDetailForm']//input[contains(@id,'otherLoanTextVariable2')]")
	private WebElement updateloanextratextvariable2;
	
	@FindBy(id="updateOtherLoanBtn")
	private WebElement updatedonebutton;
	
	@FindBy(xpath="//div[@id='waitingUpdateOtherLoanBtn']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement updatedonebuttonspinner;
	
	@FindBy(xpath="//span[contains(text(),'Other Loan has been Updated')]")
	private WebElement otherloanupdatenotification;
	
	@FindBy(xpath="//button[@id='edit_bank_detail_modal_opener']/following-sibling::button")
	private WebElement deletebutton;
	
	@FindBy(xpath="//span[contains(text(),'Other Loan')]")
	private WebElement addedotherloandetailsdeletenotification;
	
	@FindBy(id="createOtherLoanAndCOntinueBtn")
	private WebElement addandcontinuebutton;
	
	@FindBy(xpath="//a[contains(text(),'Skip')]")
	private WebElement skipbutton;
	
	@FindBy(xpath="//ul[@class='nav alert alert-block alert-danger fade in']/li")
	private List<WebElement> errormessages;
	
	public void clickSkip() {
		try {
			Generics.waitForElement(driver, skipbutton);
			skipbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateOtherLoanDetailsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, otherloandetailsheading);
			if (otherloandetailsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Other loan details is displayed", true);
			} else
				Reporter.log("Other loan details is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateOtherLoanDetailsHeading", true);
		}
	}
	
	public void enterLoanPurpose(String loanpurpose) {
		try {
			Generics.waitForElement(driver, loanpurposetextbox);
			loanpurposetextbox.click();
			loanpurposetextbox.clear();
			loanpurposetextbox.sendKeys(loanpurpose);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterLoanAmount(String loanamount) {
		try {
			Generics.waitForElement(driver, loanamounttextbox);
			loanamounttextbox.click();
			loanamounttextbox.clear();
			loanamounttextbox.sendKeys(loanamount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterRepaymentAmount(String repaymentamount) {
		try {
			Generics.waitForElement(driver, repaymentamounttextbox);
			repaymentamounttextbox.click();
			repaymentamounttextbox.clear();
			repaymentamounttextbox.sendKeys(repaymentamount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterPrincipalOutstanding(String value) {
		try {
			Generics.waitForElement(driver, principaloutstandingtextbox);
			principaloutstandingtextbox.click();
			principaloutstandingtextbox.clear();
			principaloutstandingtextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankName(String bankname) {
		try {
			Generics.waitForElement(driver, banknametextbox);
			banknametextbox.click();
			banknametextbox.clear();
			banknametextbox.sendKeys(bankname);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterBankAccountNumber(String value) {
		try {
			Generics.waitForElement(driver, bankaccountnumbertextbox);
			bankaccountnumbertextbox.click();
			bankaccountnumbertextbox.clear();
			bankaccountnumbertextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterStartDate(String date, String month, String year) {
		try {
			Generics.waitForElement(driver, startdatetextbox);
			startdatetextbox.click();
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
		}
	}
	
	public void enterEndDate(String date, String month, String year) {
		try {
			Generics.waitForElement(driver, enddatetextbox);
			enddatetextbox.click();
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
		}
	}
	
	public void enterRemainingTenure(String value) {
		try {
			Generics.waitForElement(driver, remainingtenuretextbox);
			remainingtenuretextbox.click();
			remainingtenuretextbox.clear();
			remainingtenuretextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterLoanType(String value) {
		try {
			Generics.waitForElement(driver, loantypetextbox);
			loantypetextbox.click();
			loantypetextbox.clear();
			loantypetextbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterLoanExtraTextVariable(String loanextratextvariable) {
		try {
			Generics.waitForElement(driver, loanextratextvariable1textbox);
			loanextratextvariable1textbox.click();
			loanextratextvariable1textbox.clear();
			loanextratextvariable1textbox.sendKeys(loanextratextvariable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterLoanExtraTextVariable2(String value) {
		try {
			Generics.waitForElement(driver, addandcontinuebutton);
			loanextratextvariable2textbox.click();
			loanextratextvariable2textbox.clear();
			loanextratextvariable2textbox.sendKeys(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddMore() {
		try {
			Generics.waitForElement(driver, addmorebutton);
			addmorebutton.click();
			Generics.waitForElementToInvisible(driver, addmorespinner);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateSavedOtherLoanDetails(String loanpurpose, String loanamount, String repaymentamount, String principaloutstanding, 
			String bankname, String  bankaccountnumber, String startdate, String enddate, String remainingtenure, 
			String loantype, String extratextvariable1, String extratextvariable2) {
		try {
			Generics.waitForElement(driver, savedotherloandetailsloanpurpose);
			assertEquals(savedotherloandetailsloanpurpose.getText(), loanpurpose);
			
			Generics.waitForElement(driver, savedotherloandetailsloanamount);
			assertEquals(savedotherloandetailsloanamount.getText(), loanamount);
			
			Generics.waitForElement(driver, savedotherloandetailsrepaymentamount);
			assertEquals(savedotherloandetailsrepaymentamount.getText(), repaymentamount);
			
			Generics.waitForElement(driver, savedotherloandetailsprincipaloutstanding);
			assertEquals(savedotherloandetailsprincipaloutstanding.getText(), principaloutstanding);
			
			Generics.waitForElement(driver, savedloandetailsbankname);
			assertEquals(savedloandetailsbankname.getText(), bankname);

			Generics.waitForElement(driver, savedotherloandetailsbankaccountnumber);
			assertEquals(savedotherloandetailsbankaccountnumber.getText(), bankaccountnumber);
			
			Generics.waitForElement(driver, savedotherloandetailsstartdate);
			assertEquals(savedotherloandetailsstartdate.getText(), startdate);
			
			Generics.waitForElement(driver, savedotherloandetailsenddate);
			assertEquals(savedotherloandetailsenddate.getText(), enddate);
			
			Generics.waitForElement(driver, savedotherloandetailsremainingtenure);
			assertEquals(savedotherloandetailsremainingtenure.getText(), remainingtenure);
			
			Generics.waitForElement(driver, savedotherloandetailsloantype);
			assertEquals(savedotherloandetailsloantype.getText(), loantype);
			
			Generics.waitForElement(driver, savedloandetailsloanextratextvariableone);
			assertEquals(savedloandetailsloanextratextvariableone.getText(), extratextvariable1);
			
			Generics.waitForElement(driver, savedloandetailsloanextratextvariabletwo);
			assertEquals(savedloandetailsloanextratextvariabletwo.getText(), extratextvariable2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickEdit() {
		try {
			Generics.waitForElement(driver, editbutton);
			editbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void editOtherLoanDetails(String loanpurpose, String loanamount, String repaymentamount, String principaloutstanding, 
			String bankname, String bankaccountnumber, String startyear, String startmonth, String startdate, 
			String endyear, String endmonth, String enddate, String remainingtenure, String loantype, String loanextratextvariable1,
			String loanextratextvariable2) {
		try {
			Generics.waitForElement(driver, updateloanpurposetextbox);
			updateloanpurposetextbox.click();
			updateloanpurposetextbox.clear();
			updateloanpurposetextbox.sendKeys(loanpurpose);
			
			Generics.waitForElement(driver, updateloanamounttextbox);
			updateloanamounttextbox.click();
			updateloanamounttextbox.clear();
			updateloanamounttextbox.sendKeys(loanamount);
			
			Generics.waitForElement(driver, updaterepaymentamounttextbox);
			updaterepaymentamounttextbox.click();
			updaterepaymentamounttextbox.clear();
			updaterepaymentamounttextbox.sendKeys(repaymentamount);
			
			Generics.waitForElement(driver, updateprincipaloutstandingtextbox);
			updateprincipaloutstandingtextbox.click();
			updateprincipaloutstandingtextbox.clear();
			updateprincipaloutstandingtextbox.sendKeys(principaloutstanding);
			
			Generics.waitForElement(driver, updatebanknametextbox);
			updatebanknametextbox.click();
			updatebanknametextbox.clear();
			updatebanknametextbox.sendKeys(bankname);
			
			Generics.waitForElement(driver, updatebankaccountnumbertextbox);
			updatebankaccountnumbertextbox.click();
			updatebankaccountnumbertextbox.clear();
			updatebankaccountnumbertextbox.sendKeys(bankaccountnumber);
			
			Generics.waitForElement(driver, updatestartdatetextbox);
			updatestartdatetextbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select startYears = new Select(yeardropdown);
			startYears.selectByVisibleText(startyear);
			Generics.waitForElement(driver, monthdropdown);
			Select startMonths = new Select(monthdropdown);
			startMonths.selectByVisibleText(startmonth);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(startdate)) {
					datelinks.get(i).click();
				}
			}
			
			Generics.waitForElement(driver, updateenddatetextbox);
			updateenddatetextbox.click();
			Generics.waitForElement(driver, yeardropdown);
			Select endYears = new Select(yeardropdown);
			endYears.selectByVisibleText(endyear);
			Generics.waitForElement(driver, monthdropdown);
			Select endMonths = new Select(monthdropdown);
			endMonths.selectByVisibleText(endmonth);
			for(int i=0;i<datelinks.size();i++) {
				if(datelinks.get(i).getText().equalsIgnoreCase(enddate)) {
					datelinks.get(i).click();
				}
			}
			
			Generics.waitForElement(driver, updateremainingtenuretextbox);
			updateremainingtenuretextbox.click();
			updateremainingtenuretextbox.clear();
			updateremainingtenuretextbox.sendKeys(remainingtenure);
			
			Generics.scrollPage(driver, 500);
			
			Generics.waitForElement(driver, updateloantypetextbox);
			updateloantypetextbox.click();
			updateloantypetextbox.clear();
			updateloantypetextbox.sendKeys(loantype);
			
			Generics.waitForElement(driver, updateloanextratextvariable1);
			updateloanextratextvariable1.click();
			updateloanextratextvariable1.clear();
			updateloanextratextvariable1.sendKeys(loanextratextvariable1);
			
			Generics.waitForElement(driver, updateloanextratextvariable2);
			updateloanextratextvariable2.click();
			updateloanextratextvariable2.clear();
			updateloanextratextvariable2.sendKeys(loanextratextvariable2);
			
			Generics.waitForElement(driver, updatedonebutton);
			updatedonebutton.click();
			Generics.waitForElement(driver, otherloanupdatenotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDelete() {
		try {
			Generics.waitForElement(driver, deletebutton);
			deletebutton.click();
			driver.switchTo().alert().accept();
			Generics.waitForElement(driver, addedotherloandetailsdeletenotification);
			System.out.println(addedotherloandetailsdeletenotification.getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddAndContinue() {
		try {
			Generics.waitForElement(driver, addandcontinuebutton);
			addandcontinuebutton.click();
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
