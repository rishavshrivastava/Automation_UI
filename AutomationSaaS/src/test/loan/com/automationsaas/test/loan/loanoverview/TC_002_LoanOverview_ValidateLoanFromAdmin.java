package com.automationsaas.test.loan.loanoverview;

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

public class TC_002_LoanOverview_ValidateLoanFromAdmin extends Base {

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
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
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

		ArrayList<String> loanDetails = new ArrayList<String>();
		loanDetails.add(borrowerId);
		loanDetails.add("N/A");
		loanDetails.add("Rs0");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add(loanId);
		loanDetails.add("Rs200,000");
		loanDetails.add("12 Months");
		loanDetails.add("Personal Loan");
		loanDetails.add("9.00%");
		String currentDate = Generics.getCurrentDate();
		loanDetails.add(currentDate);
		loanDetails.add("Rs209,884");
		loanDetails.add("N/A");
		loanDetails.add("Mr Rishav Shrivastava");
		loanDetails.add("Mr Rishav Shrivastava");
		loanDetails.add("Automation Test");
		for (int i = 0; i < loanDetails.size(); i++) {
			loanDetailsPage.validateLoanDetails(i, loanDetails.get(i));
		}
	}
}
