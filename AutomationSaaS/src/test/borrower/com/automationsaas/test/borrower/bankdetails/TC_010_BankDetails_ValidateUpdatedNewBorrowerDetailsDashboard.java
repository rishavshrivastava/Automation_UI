package com.automationsaas.test.borrower.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_010_BankDetails_ValidateUpdatedNewBorrowerDetailsDashboard extends Base {

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
		
		ArrayList<String> bankDetails_1 = new ArrayList<String>();
		bankDetails_1.add("85471254789");
		bankDetails_1.add("Current");
		bankDetails_1.add("SBITest");
		bankDetails_1.add("SBINTest");
		bankDetails_1.add("Rishav");
		
		ArrayList<String> bankDetails_2 = new ArrayList<String>();
		bankDetails_2.add("5845214578");
		bankDetails_2.add("Current");
		bankDetails_2.add("HDFC");
		bankDetails_2.add("HDFC0099");
		bankDetails_2.add("Shrivastava");
		
		for (int i = 0; i < profilePage.getBankDetailsCount(); i++) {
			if(i==0) {
				for (int j = 0; j < bankDetails_1.size(); j++) {
					profilePage.validateBankDetails(i, j, bankDetails_1.get(j));
				}
			}
			else if(i==1) {
				for (int j = 0; j < bankDetails_2.size(); j++) {
					profilePage.validateBankDetails(i, j, bankDetails_2.get(j));
				}
			}
		}
	}
}