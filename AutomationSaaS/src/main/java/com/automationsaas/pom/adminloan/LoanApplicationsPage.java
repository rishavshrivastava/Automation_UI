package com.automationsaas.pom.adminloan;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class LoanApplicationsPage extends Base {

	public WebDriver driver;

	public LoanApplicationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='ajax-loader-spinner']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement loanapplicationpagespinner;

	@FindBy(id = "loanId")
	private WebElement loanidtextbox;

	@FindBy(id = "searchLoans")
	private WebElement searchbutton;

	@FindBy(xpath = "//div[@id='loansList']//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement loanapplicationspinner;

	@FindBy(xpath = "//th[.='Loan Id']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Id']/preceding-sibling::th)+1]/a")
	private List<WebElement> loanidlinks;

	@FindBy(xpath = "//div[@id='loansList']//th[.='Loan Id']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Id']/preceding-sibling::th)+1]/a")
	private List<WebElement> loanidlink;

	@FindBy(xpath = "//div[@id='loansList']//th[.='Amount(Rs)']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount(Rs)']/preceding-sibling::th)+1]")
	private WebElement loanamounttext;

	@FindBy(xpath = "//div[@id='loansList']//th[.='Loan Tenure']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Tenure']/preceding-sibling::th)+1]")
	private WebElement loantenuretext;

	@FindBy(xpath = "//div[@id='loansList']//th[.='Interest(%)']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Interest(%)']/preceding-sibling::th)+1]")
	private WebElement loaninteresttext;

	@FindBy(xpath = "//div[@id='loansList']//th[.='Loan Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Loan Status']/preceding-sibling::th)+1]")
	private WebElement loanstatustext;

	@FindBy(xpath = "//div[@id='loansList']//th[.='Product']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Product']/preceding-sibling::th)+1]")
	private WebElement loanproducttext;

	@FindBy(xpath = "//div[@id='loansList']//th[.='Type']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Type']/preceding-sibling::th)+1]")
	private WebElement loantypetext;

	@FindBy(xpath = "//div[@id='loansList']//th[.='Email']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Email']/preceding-sibling::th)+1]/a")
	private WebElement loanemailtext;

	@FindBy(xpath = "//div[@id='nextStatusButtons']//a[contains(text(),'Action')]")
	private WebElement actiondropdown;

	@FindBy(xpath = "//div[@id='nextStatusButtons']//a[contains(text(),'Loan Application Assign To Fia')]")
	private WebElement loanapplicationassigntofialink;

//	@FindBy(xpath = "//input[@value='Select Field Investigation Agent']")
//	private WebElement selectfieldinvestigationagenttextbox;

	@FindBy(xpath = "//div[@id='fiaUuid_chosen']//ul/li/input")
	private WebElement selectfieldinvestigationagenttextbox;

	@FindBy(xpath = "//form[@id='fiaLoanApplicationAssignForm']//ul[@class='chosen-results']/li")
	private List<WebElement> loanapplicationassigntofialists;

	@FindBy(xpath = "//form[@id='fiaLoanApplicationAssignForm']//button[@id='assignLoanApplicationButton']")
	private WebElement loanapplicationassigntofia_assignbutton;

	@FindBy(xpath = "//span[contains(text(),'Fia has been assigned to loan application successfully.')]")
	private WebElement loanapplicationnotifications;

	
	public void enterLoanIdInSearchField(String loanid) {
		try {
			Generics.waitForElementToInvisible(driver, loanapplicationpagespinner);
			Generics.waitForElement(driver, loanidtextbox);
			loanidtextbox.click();
			loanidtextbox.clear();
			loanidtextbox.sendKeys(loanid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSearch() {
		try {
			Generics.waitForElement(driver, searchbutton);
			searchbutton.click();
			Generics.waitForElementToInvisible(driver, loanapplicationspinner);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSearchedLoanId(String loanid) {
		try {
			Generics.waitForElement(driver, loanidlinks.get(0));
			for (int i = 0; i < loanidlinks.size(); i++) {
				if (loanidlinks.get(i).getText().equalsIgnoreCase(loanid)) {
					Reporter.log("Loan ID found", true);
					loanidlinks.get(i).click();
					break;
				} else
					Reporter.log("Loan ID not found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateSearchedLoan(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, loanidlink.get(0));
				assertEquals(loanidlink.get(0).getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, loanamounttext);
				assertEquals(loanamounttext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, loantenuretext);
				assertEquals(loantenuretext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, loaninteresttext);
				assertEquals(loaninteresttext.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, loanstatustext);
				assertEquals(loanstatustext.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, loanproducttext);
				assertEquals(loanproducttext.getText(), product);
				break;

			case 6:
				Generics.waitForElement(driver, loantypetext);
				assertEquals(loantypetext.getText(), product);
				break;

			case 7:
				Generics.waitForElement(driver, loanemailtext);
				assertEquals(loanemailtext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanId() {
		try {
			Generics.waitForElement(driver, loanidlink.get(0));
			loanidlink.get(0).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEmailId() {
		try {
			Generics.waitForElement(driver, loanemailtext);
			loanemailtext.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getLoanId() {
		String loanId = null;
		try {
			Generics.waitForElement(driver, loanidlink.get(0));
			loanId = loanidlink.get(0).getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return loanId;
	}

	public String getEmailId() {
		String emailId = null;
		try {
			Generics.waitForElement(driver, loanemailtext);
			emailId = loanemailtext.getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return emailId;
	}

	public void clickAction() {
		try {
			Generics.waitForElement(driver, actiondropdown);
			actiondropdown.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanApplicationAssignToFIA() {
		try {
			Generics.waitForElement(driver, loanapplicationassigntofialink);
			loanapplicationassigntofialink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectFIA(String fianame) {
		try {
			Generics.waitForElement(driver, selectfieldinvestigationagenttextbox);
			selectfieldinvestigationagenttextbox.click();

			Generics.waitForElement(driver, loanapplicationassigntofialists.get(0));
			for (int i = 0; i < loanapplicationassigntofialists.size(); i++) {
				if (loanapplicationassigntofialists.get(i).getText().equalsIgnoreCase(fianame)) {
					loanapplicationassigntofialists.get(i).click();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanApplicationAssignToFia() {
		try {
			Generics.waitForElement(driver, loanapplicationassigntofia_assignbutton);
			loanapplicationassigntofia_assignbutton.click();
			Generics.waitForElement(driver, loanapplicationnotifications);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
