package com.automationsaas.test.loan.coapplicantdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_023_CoApplicant_DeleteAndValidateNewDetailsFromDashboard extends Base {

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
	     
		borrowerDashboardPage.validateLoanStatus("Initialized");

		ArrayList<String> loanDetails = new ArrayList<String>();
		loanDetails.add("Personal Loan");
		loanDetails.add(loanId);
		loanDetails.add("Mr Rishav Shrivastava");
		loanDetails.add("N/A");
		loanDetails.add("Rs209,884");
		loanDetails.add(borrowerId);
		loanDetails.add("Rs200,000");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add("Rs0");
		String currentDate = Generics.getCurrentDate();
		loanDetails.add(currentDate);
		loanDetails.add("12 Months");
		loanDetails.add("9.00%");
		loanDetails.add("N/A");
		for (int i = 0; i < loanDetails.size(); i++) {
			borrowerDashboardPage.validateLoanDetails(i, loanDetails.get(i));
		}

		borrowerDashboardPage.clickLoanDetailsButton();

		// Borrower Loan Details
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.clickDetails();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.clickCoApplicantDetailsAccordion();
		loanDetailsPage.clickCoApplicantDetailsDelete(1);

		Generics.refreshPage(driver);
		loanDetailsPage.clickCoApplicantDetailsAccordion();

		ArrayList<String> coApplicantDetails = new ArrayList<String>();
		coApplicantDetails.add("Divyacoapp CoappDashboard");
		coApplicantDetails.add("divya.s+dashboard@perfios.com");
		coApplicantDetails.add("From Dashboard");
		coApplicantDetails.add("Update");

		ArrayList<String> coApplicantDetails2 = new ArrayList<String>();
		coApplicantDetails2.add("DNewborthrd SNewthrd");
		coApplicantDetails2.add("divya.s+newborthrd@perfios.com");
		coApplicantDetails2.add("third");
		coApplicantDetails2.add("third Co App");
		for (int i = 0; i < loanDetailsPage.getNumberOfCoApplicants(); i++) {
			if (i == 0)
				for (int j = 0; j < coApplicantDetails.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, coApplicantDetails.get(j));
				}
			if (i == 1) {
				for (int j = 0; j < coApplicantDetails2.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, coApplicantDetails2.get(j));
				}
			}
		}
	}
}
