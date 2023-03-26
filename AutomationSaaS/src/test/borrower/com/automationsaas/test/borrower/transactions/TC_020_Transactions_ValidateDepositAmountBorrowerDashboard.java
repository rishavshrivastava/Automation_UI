package com.automationsaas.test.borrower.transactions;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_020_Transactions_ValidateDepositAmountBorrowerDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void transactionFromBorrowerSide() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
		LoginPage loginPage = new LoginPage(driver);
		String borrowerUsername = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String borrowerPassword = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(borrowerUsername);
		loginPage.enterPassword(borrowerPassword);
		loginPage.clickLogin();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		dashboardPage.validateBorrowerId(borrowerId);
		dashboardPage.validateProfileStatus("Approved");
		dashboardPage.validateAccountBalance("Rs1,510,000");
	}
}
