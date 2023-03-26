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

public class TC_003_CoApplicant_UpdateAndValidateLoanDetailsFromAdmin extends Base {

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
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickLoanId();

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);

		// validate if co applicant details are present in popup.
		
		loanDetailsPage.clickCoApplicantAccordion();
		loanDetailsPage.clickCoApplicantDetailsEdit(0);
		ArrayList<String> coApplicantDetailsInPopUp = new ArrayList<String>();
		coApplicantDetailsInPopUp.add("Rishav");
		coApplicantDetailsInPopUp.add("Shrivastava");
		coApplicantDetailsInPopUp.add("rishav.s@perfios.com");
		coApplicantDetailsInPopUp.add("Perfios");
		coApplicantDetailsInPopUp.add("Testing");
		for (int i = 0; i < coApplicantDetailsInPopUp.size(); i++) {
			loanDetailsPage.validateCoApplicantDetailsInPopUp(i, coApplicantDetailsInPopUp.get(i));
		}
		loanDetailsPage.clickEditCoApplicantClose();

		loanDetailsPage.clickCoApplicantDetailsEdit(0);
		ArrayList<String> coApplicantDetails = new ArrayList<String>();
		coApplicantDetails.add("Divya");
		coApplicantDetails.add("Sachan");
		coApplicantDetails.add("divya.s@perfios.com");
		coApplicantDetails.add("Fintechlabs");
		coApplicantDetails.add("Automation");
		for (int i = 0; i < coApplicantDetails.size(); i++) {
			loanDetailsPage.editCoApplicantDetails(i, coApplicantDetails.get(i));
		}
		loanDetailsPage.clickEditCoApplicantDetailsDone();

		Generics.refreshPage(driver);

		loanDetailsPage.clickCoApplicantAccordion();
		ArrayList<String> CoApplicantDetails = new ArrayList<String>();
		CoApplicantDetails.add("Divya Sachan");
		CoApplicantDetails.add("divya.s@perfios.com");
		CoApplicantDetails.add("Fintechlabs");
		CoApplicantDetails.add("Automation");

		for (int i = 0; i < loanDetailsPage.getCoApplicantsCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < CoApplicantDetails.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(0, j, CoApplicantDetails.get(j));
				}
			}
		}
	}
}