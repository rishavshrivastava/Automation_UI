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

public class TC_019_CoApplicant_UpdateAndValidateNewDetailsFromAdmin extends Base {

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

		loanDetailsPage.clickCoApplicantDetailsEdit(1);
		ArrayList<String> coApplicantDetails = new ArrayList<String>();
		coApplicantDetails.add("Divyasec");
		coApplicantDetails.add("Sachan");
		coApplicantDetails.add("divya.s+sec@perfios.com");
		coApplicantDetails.add("new second");
		coApplicantDetails.add("Co App second");
		for (int i = 0; i < coApplicantDetails.size(); i++) {
			loanDetailsPage.editCoApplicantDetails(i, coApplicantDetails.get(i));
		}
		loanDetailsPage.clickEditCoApplicantDetailsDone();
		Generics.refreshPage(driver);
		loanDetailsPage.clickCoApplicantAccordion();

		ArrayList<String> addedCoApplicantDetails_1 = new ArrayList<String>();
		addedCoApplicantDetails_1.add("Divyacoapp CoappDashboard");
		addedCoApplicantDetails_1.add("divya.s+dashboard@perfios.com");
		addedCoApplicantDetails_1.add("From Dashboard");
		addedCoApplicantDetails_1.add("Update");

		ArrayList<String> addedCoApplicantDetails_2 = new ArrayList<String>();
		addedCoApplicantDetails_2.add("Divyasec Sachan");
		addedCoApplicantDetails_2.add("divya.s+sec@perfios.com");
		addedCoApplicantDetails_2.add("new second");
		addedCoApplicantDetails_2.add("Co App second");

		ArrayList<String> addedCoApplicantDetails_3 = new ArrayList<String>();
		addedCoApplicantDetails_3.add("DNewborthrd SNewthrd");
		addedCoApplicantDetails_3.add("divya.s+newborthrd@perfios.com");
		addedCoApplicantDetails_3.add("third");
		addedCoApplicantDetails_3.add("third Co App");

		for (int i = 0; i < loanDetailsPage.getCoApplicantsCount(); i++) {
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
