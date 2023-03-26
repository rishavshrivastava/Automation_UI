package com.automationsaas.pom.admindashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;

public class HomePage extends Base {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@id='header_profile_dropdown']//span")
	private WebElement headerprofiledropdown;

	@FindBy(xpath = "//i[@class='fa fa-power-off']")
	private WebElement logoutlink;

	@FindBy(xpath = "//li[@id='for_Borrowers']//span[text()='Borrowers']")
	private WebElement borrowerlink;

	@FindBy(id = "link_borrower_ALL")
	private WebElement borroweralllink;

	@FindBy(xpath = "//li[@id='for_LoanApplications']//span[text()='Loan Applications']")
	private WebElement loanapplicationlink;

	@FindBy(id = "link_Loan_ALL")
	private WebElement loanalllink;

	@FindBy(id = "link_Loan_INITIALIZED")
	private WebElement initializedloanlink;

	@FindBy(xpath = "//a[contains(text(),'Notifications')]")
	private WebElement notificationslink;

	@FindBy(xpath = "//li[@id='reports_uploadedFiles']/a")
	private WebElement uploadedfilereportlink;

	@FindBy(xpath = "//li[@id='for_UploadLoanFile']/a/span[text()='Upload Loan File']")
	private WebElement uploadloanfilelink;

	@FindBy(xpath = "//li[@id='for_Transactions']//span[text()='Transactions']")
	private WebElement transactionslink;

	@FindBy(xpath = "//li[@id='transactions_AWAITING_APPROVAL']//a")
	private WebElement awaitingapprovallink;

	@FindBy(xpath = "//span[text()='Investors']")
	private WebElement investorlink;

	@FindBy(id = "link_Investor_ALL")
	private WebElement investoralllink;

	@FindBy(id = "link_Investor_APPROVED")
	private WebElement investorapprovedlink;

	@FindBy(xpath = "//span[contains(text(),'Business Partner')]")
	private WebElement businesspartnerlink;

	@FindBy(id = "link_DSA_All")
	private WebElement businesspartnerlllink;

	@FindBy(xpath = "//span[contains(text(),'Field Investigation Associate')]")
	private WebElement fialink;

	@FindBy(id = "link_Fia_All")
	private WebElement fiaallink;

	@FindBy(xpath = "//*[@id='header-navbar']//a[contains(text(),'System')]")
	private WebElement systemdropdown;

	@FindBy(xpath = "//a[@href='/settings/admins']")
	private WebElement systemadminslink;

	public void clickBorrower() {
		try {
			Generics.waitForElement(driver, borrowerlink);
			borrowerlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBorrowerAll() {
		try {
			Generics.waitForElement(driver, borroweralllink);
			borroweralllink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanApplications() {
		try {
			Generics.waitForElement(driver, loanapplicationlink);
			loanapplicationlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanApplicationsAll() {
		try {
			Generics.waitForElement(driver, loanalllink);
			loanalllink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickLoanApplicationsInitialized() {
		try {
			Generics.waitForElement(driver, initializedloanlink);
			initializedloanlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickNotifications() {
		try {
			Generics.waitForElement(driver, notificationslink);
			notificationslink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickUploadedFileReport() {
		try {
			Generics.waitForElement(driver, uploadedfilereportlink);
			uploadedfilereportlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickUploadLoanFile() {
		try {
			Generics.waitForElement(driver, uploadloanfilelink);
			uploadloanfilelink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickTransactions() {
		try {
			Generics.waitForElement(driver, transactionslink);
			transactionslink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAwaiting() {
		try {
			Generics.waitForElement(driver, awaitingapprovallink);
			awaitingapprovallink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		try {
			Generics.waitForElement(driver, headerprofiledropdown);
			headerprofiledropdown.click();
			Thread.sleep(2000);
			Generics.waitForElement(driver, logoutlink);
			logoutlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickInvestor() {
		try {
			Generics.waitForElement(driver, investorlink);
			investorlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickInvestorAll() {
		try {
			Generics.waitForElement(driver, investoralllink);
			investoralllink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickInvestorApproved() {
		try {
			Generics.waitForElement(driver, investorapprovedlink);
			investorapprovedlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBusinessPartner() {
		try {
			Generics.waitForElement(driver, businesspartnerlink);
			businesspartnerlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickBusinessPartnerAll() {
		try {
			Generics.waitForElement(driver, businesspartnerlllink);
			businesspartnerlllink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickFIA() {
		try {
			Generics.waitForElement(driver, fialink);
			fialink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickFIAAll() {
		try {
			Generics.waitForElement(driver, fiaallink);
			fiaallink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void fiaEmailsList() {
		try {
			
			String fiaemail = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
			
			WebElement actionButtonWRTEmail = driver.findElement(By.xpath("//th[.='Email Address']/ancestor::thead/following-sibling::tbody/tr/td[contains(text(),'"+fiaemail+"')]/following-sibling::td/a"));
			Generics.waitForElement(driver, actionButtonWRTEmail);
			actionButtonWRTEmail.click();
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	

	public void clickSystems() {
		try {
			Generics.waitForElement(driver, systemdropdown);
			systemdropdown.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSystemAdmin() {
		try {
			Thread.sleep(1000);
			Generics.waitForElement(driver, systemadminslink);
			systemadminslink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}