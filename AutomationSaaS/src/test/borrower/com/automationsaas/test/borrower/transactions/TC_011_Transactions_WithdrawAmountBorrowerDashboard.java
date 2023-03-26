package com.automationsaas.test.borrower.transactions;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_011_Transactions_WithdrawAmountBorrowerDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void transactionFromBorrowerSide() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String borrowerUsername = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String borrowerPassword = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(borrowerUsername);
		loginPage.enterPassword(borrowerPassword);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		borrowerDashboardPage.validateBorrowerId(borrowerId);
		borrowerDashboardPage.validateProfileStatus("Approved");
		borrowerDashboardPage.validateAccountBalance("Rs1,500,000");
		
		borrowerDashboardPage.clickWithdraw();
		borrowerDashboardPage.enterWithdrawAmount("5000");
		borrowerDashboardPage.clickWithdrawButton();
		borrowerDashboardPage.validateAccountBalance("Rs1,500,000");
	}
}
