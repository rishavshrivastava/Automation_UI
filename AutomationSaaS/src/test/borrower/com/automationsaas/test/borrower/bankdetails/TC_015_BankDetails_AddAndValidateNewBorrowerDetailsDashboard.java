package com.automationsaas.test.borrower.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_015_BankDetails_AddAndValidateNewBorrowerDetailsDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);

		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Initialized");
		
		ProfilePage profilePage = new ProfilePage(driver);
		borrowerDashboardPage.clickAccount();
		borrowerDashboardPage.clickProfile();
		
		//Bank Details
		profilePage.clickBankDetails();
		profilePage.clickBankDetailsAccordionLink();
		profilePage.clickAddNewBankDetails();
		
		ArrayList<String> bankdetails = new ArrayList<String>();
		bankdetails.add("Rishav");
		bankdetails.add("8545215635");
		bankdetails.add("SBI");
		bankdetails.add("SBIN0323");
		bankdetails.add("Savings");
		for (int i=0; i<bankdetails.size(); i++) {
			profilePage.addBankDetails(i, bankdetails.get(i));
		}
		profilePage.clickAddBankDetailsDone();
		
		Generics.refreshPage(driver);
		
		profilePage.clickBankDetails();
		profilePage.clickBankDetailsAccordionLink();
		ArrayList<String> updatedBankDetails = new ArrayList<String>();
		updatedBankDetails.add("8545215635");
		updatedBankDetails.add("Savings");
		updatedBankDetails.add("SBI");
		updatedBankDetails.add("SBIN0323");
		updatedBankDetails.add("Rishav");
		for (int i = 0; i < updatedBankDetails.size(); i++) {
			profilePage.validateBankDetails(0, i, updatedBankDetails.get(i));
		}
	}
}
