package com.automationsaas.test.loan.otherloandetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_OtherLoanDetails_AddAndValidateLoanDetailsFromBorrowerDashboard extends Base {

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

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		
		borrowerDashboardPage.validateBorrowerId(borrowerId);
		borrowerDashboardPage.validateLoanId(loanId);

		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Initialized");
		borrowerDashboardPage.clickLoanDetailsButton();
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.clickDetails();
		loanDetailsPage.clickOtherLoanDetailsAccordion();
		
		//Other Loan Details
		loanDetailsPage.clickAddOtherLoanDetails();
		ArrayList<String> otherLoanDetails = new ArrayList<String>();
		otherLoanDetails.add("Money");
		otherLoanDetails.add("50000");
		otherLoanDetails.add("55000");
		otherLoanDetails.add("SBI");
		otherLoanDetails.add("Test");
		for(int i=0; i<otherLoanDetails.size();i++) {
			loanDetailsPage.addOtherLoanDetails(i, otherLoanDetails.get(i));
		}
		loanDetailsPage.clickAddOtherLoanDetailsDone();
		
		ArrayList<String> addedOtherLoanDetails = new ArrayList<String>();
		addedOtherLoanDetails.add("Money");
		addedOtherLoanDetails.add("50000");
		addedOtherLoanDetails.add("55000");
		addedOtherLoanDetails.add("SBI");
		addedOtherLoanDetails.add("Test");
		for(int i=0; i<addedOtherLoanDetails.size();i++) {
			loanDetailsPage.validateOtherLoanDetails(i, addedOtherLoanDetails.get(i));
		}
	}
}
