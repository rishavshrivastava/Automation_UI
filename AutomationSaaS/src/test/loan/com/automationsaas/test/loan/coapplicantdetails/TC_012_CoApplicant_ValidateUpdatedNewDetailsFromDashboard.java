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

public class TC_012_CoApplicant_ValidateUpdatedNewDetailsFromDashboard extends Base {

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

		ArrayList<String> addedCoApplicantDetails_1 = new ArrayList<String>();
		addedCoApplicantDetails_1.add("Divyacoapp CoappDashboard");
		addedCoApplicantDetails_1.add("divya.s+dashboard@perfios.com");
		addedCoApplicantDetails_1.add("From Dashboard");
		addedCoApplicantDetails_1.add("Update");

		ArrayList<String> addedCoApplicantDetails_2 = new ArrayList<String>();
		addedCoApplicantDetails_2.add("DNewUpdtAdmin SNewUpdtadmin");
		addedCoApplicantDetails_2.add("divya.s+newupdateadmin@perfios.com");
		addedCoApplicantDetails_2.add("new updteFrm admin");
		addedCoApplicantDetails_2.add("Admin");

		ArrayList<String> addedCoApplicantDetails_3 = new ArrayList<String>();
		addedCoApplicantDetails_3.add("DAdminSec SAdminSec");
		addedCoApplicantDetails_3.add("divya.s+AdminSec@perfios.com");
		addedCoApplicantDetails_3.add("AddedSec from admin");
		addedCoApplicantDetails_3.add("Development sec");

		for (int i = 0; i < loanDetailsPage.getNumberOfCoApplicants(); i++) {
			if (i == 0)
				for (int j = 0; j < addedCoApplicantDetails_1.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, addedCoApplicantDetails_1.get(j));
				}
			if (i == 1) {
				for (int j = 0; j < addedCoApplicantDetails_2.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, addedCoApplicantDetails_2.get(j));
				}
			}
			if (i == 2) {
				for (int j = 0; j < addedCoApplicantDetails_3.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, addedCoApplicantDetails_3.get(j));
				}
			}
		}
	}
}
