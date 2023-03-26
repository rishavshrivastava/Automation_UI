package com.automationsaas.test.loan.loanreject;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_LoanReject_ValidateIfLoanIsRejectedFromDashboard extends Base {

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

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		borrowerDashboardPage.validateBorrowerId(borrowerId);
		borrowerDashboardPage.validateBorrowerName("MR RISHAV SHRIVASTAVA");
		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Application Rejected");
		borrowerDashboardPage.validateLoanId(loanId);
	}
}