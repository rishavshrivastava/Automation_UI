package com.automationsaas.test.loan.insurancedetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_InsuranceDetails_AddAndValidateLoanDetailsFromBorrowerDashboard extends Base {

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
		
		//Insurance Details
		loanDetailsPage.clickInsuranceDetailsAccordion();
		loanDetailsPage.clickAddInsuranceDetails();
		ArrayList<String> insuranceDetails = new ArrayList<String>();
		insuranceDetails.add("TATA AIG");
		insuranceDetails.add("50000");
		insuranceDetails.add("Credit");
		insuranceDetails.add("test");
		for(int i=0; i<insuranceDetails.size();i++) {
			loanDetailsPage.addInsuranceDetails(i, insuranceDetails.get(i));
		}
		loanDetailsPage.clickAddInsuranceDetailsDone();
		
		Generics.refreshPage(driver);
		loanDetailsPage.clickInsuranceDetailsAccordion();
		
		ArrayList<String> addedInsuranceDetails_1 = new ArrayList<String>();
		addedInsuranceDetails_1.add("TATA AIG");
		addedInsuranceDetails_1.add("50000.00");
		addedInsuranceDetails_1.add("Credit");
		addedInsuranceDetails_1.add("test");
		
		for(int j=0; j<loanDetailsPage.getInsuranceDetailsCount(); j++) {
			if(j==0) {
				for(int i=0; i<addedInsuranceDetails_1.size();i++) {
					loanDetailsPage.validateInsuranceDetails(j, i, addedInsuranceDetails_1.get(i));
				}
			}
		}
	}
}