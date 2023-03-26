package com.automationsaas.test.loan.coapplicantdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_013_CoApplicant_DeleteAndValidateNewDetailsFromAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void updateBorrower() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		HomePage homePage = new HomePage(driver);
		homePage.clickLoanApplications();
		homePage.clickLoanApplicationsAll();

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		String borrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);

		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();

		ArrayList<String> searchedLoan = new ArrayList<String>();
		searchedLoan.add(loanId);
		searchedLoan.add("Rs200,000");
		searchedLoan.add("12 Months");
		searchedLoan.add("9.00 %");
		searchedLoan.add("Initialized");
		searchedLoan.add("Personal Loan");
		searchedLoan.add("Individual");
		searchedLoan.add(borrowerMailId);

		for (int i = 0; i < searchedLoan.size(); i++) {
			loanApplicationsPage.validateSearchedLoan(i, searchedLoan.get(i));
		}

		loanApplicationsPage.clickLoanId();

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.clickCoApplicantAccordion();

		loanDetailsPage.clickCoApplicantDetailsDelete("Yes", 1);
		
		Generics.refreshPage(driver);
		loanDetailsPage.clickCoApplicantAccordion();

		ArrayList<String> editedCoApplicantDetails = new ArrayList<String>();
		editedCoApplicantDetails.add("Divyacoapp CoappDashboard");
		editedCoApplicantDetails.add("divya.s+dashboard@perfios.com");
		editedCoApplicantDetails.add("From Dashboard");
		editedCoApplicantDetails.add("Update");

		ArrayList<String> editedCoApplicantDetails_2 = new ArrayList<String>();
		editedCoApplicantDetails_2.add("DAdminSec SAdminSec");
		editedCoApplicantDetails_2.add("divya.s+AdminSec@perfios.com");
		editedCoApplicantDetails_2.add("AddedSec from admin");
		editedCoApplicantDetails_2.add("Development sec");

		for (int i = 0; i < loanDetailsPage.getCoApplicantsCount(); i++) {
			if (i == 0)
				for (int j = 0; j < editedCoApplicantDetails.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, editedCoApplicantDetails.get(j));
				}
			if (i == 1) {
				for (int j = 0; j < editedCoApplicantDetails_2.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, editedCoApplicantDetails_2.get(j));
				}
			}
		}
	}
}
