package com.automationsaas.test.loan.pdcmanagement;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_PDCManagement_UpdateAndValidateLoanDetailsFromAdmin extends Base {

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
		loanDetailsPage.clickPDCManagementAccordion();
		
		loanDetailsPage.clickPDCManagementEdit();
		ArrayList<String> PDCManagementDetails = new ArrayList<String>();
		PDCManagementDetails.add("Rishav Shrivastava");
		PDCManagementDetails.add("ICICI");
		PDCManagementDetails.add("ICICI0030");
		PDCManagementDetails.add("ICC98");
		PDCManagementDetails.add("HSR");
		PDCManagementDetails.add("400000");
		PDCManagementDetails.add("CHQ87789393");
		PDCManagementDetails.add("-Select");
		for(int i=0;i<PDCManagementDetails.size();i++) {
			loanDetailsPage.editPDCManagement(i, PDCManagementDetails.get(i));
		}
		loanDetailsPage.clickEditPDCManagementDone();
		ArrayList<String> editedPDCManagementDetails = new ArrayList<String>();
		editedPDCManagementDetails.add("ICICI");
		editedPDCManagementDetails.add("ICICI0030");
		editedPDCManagementDetails.add("ICC98");
		editedPDCManagementDetails.add("HSR");
		editedPDCManagementDetails.add("400000");
		editedPDCManagementDetails.add("CHQ87789393");
		editedPDCManagementDetails.add("Rishav Shrivastava");
		for(int i=0;i<editedPDCManagementDetails.size();i++) {
			loanDetailsPage.validatePDCManagement(i, editedPDCManagementDetails.get(i));
		}
		
	}
}