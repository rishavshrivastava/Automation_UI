package com.automationsaas.test.borrower.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_BankDetails_UpdateAndValidateBorrowerDetailsDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void updateBorrower() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
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

		borrowerDashboardPage.clickAccount();
		borrowerDashboardPage.clickProfile();

		ProfilePage profilePage = new ProfilePage(driver);

		profilePage.clickBankDetails();
		profilePage.clickBankDetailsAccordionLink();
		
		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("");
		bankDetails.add("5684521256");
		bankDetails.add("SBI");
		bankDetails.add("SBIN999");
		bankDetails.add("Savings");
		for (int i = 0; i < bankDetails.size(); i++) {
			profilePage.editBankDetails(i, bankDetails.get(i));
		}
		profilePage.updateBankDetails();

		// Validate Bank Details
		ArrayList<String> updatedBankDetails = new ArrayList<String>();
		updatedBankDetails.add("5684521256");
		updatedBankDetails.add("Savings");
		updatedBankDetails.add("SBI");
		updatedBankDetails.add("SBIN999");
		for (int i = 0; i < updatedBankDetails.size(); i++) {
				profilePage.validateBankDetails(0, i, updatedBankDetails.get(i));
		}
	}
}
