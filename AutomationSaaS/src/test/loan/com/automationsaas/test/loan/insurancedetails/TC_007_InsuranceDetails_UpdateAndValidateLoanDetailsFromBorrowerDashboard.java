package com.automationsaas.test.loan.insurancedetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_007_InsuranceDetails_UpdateAndValidateLoanDetailsFromBorrowerDashboard extends Base {

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
		loanDetailsPage.clickInsuranceDetailsAccordion();
		
		loanDetailsPage.clickInsuranceDetailsEdit();
		ArrayList<String> insuranceDetails = new ArrayList<String>();
		insuranceDetails.add("Max Health");
		insuranceDetails.add("100000.00");
		insuranceDetails.add("Bank");
		insuranceDetails.add("Testing");
		for(int i=0; i<insuranceDetails.size();i++) {
			loanDetailsPage.editInsuranceDetails(i, insuranceDetails.get(i));
		}
		loanDetailsPage.clickEditInsuranceDetailsDone();
		
		ArrayList<String> insuranceDetails_1 = new ArrayList<String>();
		insuranceDetails_1.add("Max Health");
		insuranceDetails_1.add("100000.00");
		insuranceDetails_1.add("Bank");
		insuranceDetails_1.add("Testing");
		
		for(int j=0; j<loanDetailsPage.getInsuranceDetailsCount(); j++) {
			if(j==0) {
				for(int i=0; i<insuranceDetails_1.size(); i++) {
					loanDetailsPage.validateInsuranceDetails(j, i, insuranceDetails_1.get(i));
				}
			}
		}
	}
}