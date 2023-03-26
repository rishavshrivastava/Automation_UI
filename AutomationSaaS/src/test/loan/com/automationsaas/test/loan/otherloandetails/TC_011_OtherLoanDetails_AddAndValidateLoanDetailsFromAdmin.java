package com.automationsaas.test.loan.otherloandetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_011_OtherLoanDetails_AddAndValidateLoanDetailsFromAdmin extends Base {

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
		loanDetailsPage.clickOtherLoanDetailsAccordion();
		
		loanDetailsPage.clickAddOtherOtherLoanDetails();
		ArrayList<String> otherLoanDetails = new ArrayList<String>();
		otherLoanDetails.add("Car");
		otherLoanDetails.add("500000");
		otherLoanDetails.add("550000");
		otherLoanDetails.add("SBI");
		otherLoanDetails.add("Testing");
		for(int i=0;i<otherLoanDetails.size();i++) {
			loanDetailsPage.addOtherLoanDetails(i, otherLoanDetails.get(i));
		}
		loanDetailsPage.clickAddOtherLoanDetailsDone();
		ArrayList<String> addedOtherLoanDetails = new ArrayList<String>();
		addedOtherLoanDetails.add("Car");
		addedOtherLoanDetails.add("500000");
		addedOtherLoanDetails.add("550000");
		addedOtherLoanDetails.add("SBI");
		addedOtherLoanDetails.add("Testing");
		for(int i=0;i<addedOtherLoanDetails.size();i++) {
			loanDetailsPage.validateOtherLoanDetails(i, addedOtherLoanDetails.get(i));
		}
	}
}
