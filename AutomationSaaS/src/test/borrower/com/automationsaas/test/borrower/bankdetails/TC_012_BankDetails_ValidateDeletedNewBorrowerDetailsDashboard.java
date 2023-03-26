package com.automationsaas.test.borrower.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_012_BankDetails_ValidateDeletedNewBorrowerDetailsDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
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
		
		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("5845214578");
		bankDetails.add("Current");
		bankDetails.add("HDFC");
		bankDetails.add("HDFC0099");
		bankDetails.add("Shrivastava");
		
		for (int i = 0; i < profilePage.getBankDetailsCount(); i++) {
			if(i==0) {
				for (int j = 0; j < bankDetails.size(); j++) {
					profilePage.validateBankDetails(i, j, bankDetails.get(j));
				}
			}
		}
	}
}
