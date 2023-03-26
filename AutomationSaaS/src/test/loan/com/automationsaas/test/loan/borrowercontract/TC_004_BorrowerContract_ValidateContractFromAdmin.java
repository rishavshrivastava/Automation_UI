package com.automationsaas.test.loan.borrowercontract;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_004_BorrowerContract_ValidateContractFromAdmin extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String adminUsername = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String adminPassword = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(adminUsername);
		loginPage.enterPassword(adminPassword);
		loginPage.clickLogin();

		HomePage homePage = new HomePage(driver);
		homePage.clickLoanApplications();
		homePage.clickLoanApplicationsAll();

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		String borrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID")
				.get(1);

		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();

		ArrayList<String> searchedLoan = new ArrayList<String>();
		searchedLoan.add(loanId);
		searchedLoan.add("Rs200,000");
		searchedLoan.add("12 Months");
		searchedLoan.add("9.00 %");
		searchedLoan.add("Application Approved");
		searchedLoan.add("Personal Loan");
		searchedLoan.add("Individual");
		searchedLoan.add(borrowerMailId);

		for (int i = 0; i < searchedLoan.size(); i++) {
			loanApplicationsPage.validateSearchedLoan(i, searchedLoan.get(i));
		}

		loanApplicationsPage.clickLoanId();

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.validateLoanStatus("Application Approved");
		
		loanDetailsPage.clickContractsAccordion();

		ArrayList<String> contractLoanIds = new ArrayList<String>();
		contractLoanIds.add(loanId);
		contractLoanIds.add(loanId);
		contractLoanIds.add(loanId);

		ArrayList<String> contractName = new ArrayList<String>();
		contractName.add("Bid Contract");
		contractName.add("Loan General Term");
		contractName.add("Loan General Term");

		ArrayList<String> contractCurrentStatus = new ArrayList<String>();
		contractCurrentStatus.add("ACCEPTED");
		contractCurrentStatus.add("REJECTED");
		contractCurrentStatus.add("ACCEPTED");

		ArrayList<String> contractAcceptedUploadedBy = new ArrayList<String>();
		contractAcceptedUploadedBy.add(borrowerMailId);
		contractAcceptedUploadedBy.add(borrowerMailId);
		contractAcceptedUploadedBy.add(borrowerMailId);

		ArrayList<String> contractAcceptedUploadedAtStatus = new ArrayList<String>();
		contractAcceptedUploadedAtStatus.add("APPROVED");
		contractAcceptedUploadedAtStatus.add("APPROVED");
		contractAcceptedUploadedAtStatus.add("APPROVED");

		for (int i = 0; i < contractLoanIds.size(); i++) {
			loanDetailsPage.validateContracts(i, contractLoanIds.get(i), contractName.get(i),
					contractCurrentStatus.get(i), contractAcceptedUploadedBy.get(i),
					contractAcceptedUploadedAtStatus.get(i));
		}
	}
}
