package com.automationsaas.test.loan.transactionsafterloandisbursal;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_TransactionsAfterLoanDisbursal_CheckTransactionFromBorrowerSideAfterDisbursal extends Base {

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
		borrowerDashboardPage.validateProfileStatus("Approved");
		borrowerDashboardPage.validateAccountBalance("Rs1,700,000");
		borrowerDashboardPage.validateLoanStatus("Disbursed");
		borrowerDashboardPage.clickTransactions();
		borrowerDashboardPage.validateCompletedTransactions(1700000, 3200000);
	}
}
