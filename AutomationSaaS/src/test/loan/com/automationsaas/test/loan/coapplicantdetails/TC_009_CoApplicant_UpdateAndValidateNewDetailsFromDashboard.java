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

public class TC_009_CoApplicant_UpdateAndValidateNewDetailsFromDashboard extends Base {

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

		loanDetailsPage.clickCoApplicantDetailsEdit(1);
		ArrayList<String> coApplicantDetails = new ArrayList<String>();
		coApplicantDetails.add("DNewUpdateBor");
		coApplicantDetails.add("SNewUpdateBor");
		coApplicantDetails.add("divya.s+newupdatebor@perfios.com");
		coApplicantDetails.add("189517859016");
		coApplicantDetails.add("DLKJG2914K");
		coApplicantDetails.add("1895178432");
		coApplicantDetails.add("1895178432");
		coApplicantDetails.add("1895178432");
		coApplicantDetails.add("1895178432");
		coApplicantDetails.add("new updteFrm Dshbrd");
		coApplicantDetails.add("Testing");
		for (int i = 0; i < coApplicantDetails.size(); i++) {
			loanDetailsPage.editCoApplicantDetails(i, coApplicantDetails.get(i));
		}
		loanDetailsPage.clickEditCoApplicantDone();
		Generics.refreshPage(driver);
		loanDetailsPage.clickCoApplicantDetailsAccordion();

		ArrayList<String> validatecoApplicantDetails_1 = new ArrayList<String>();
		validatecoApplicantDetails_1.add("Divyacoapp CoappDashboard");
		validatecoApplicantDetails_1.add("divya.s+dashboard@perfios.com");
		validatecoApplicantDetails_1.add("From Dashboard");
		validatecoApplicantDetails_1.add("Update");

		ArrayList<String> validatecoApplicantDetails_2 = new ArrayList<String>();
		validatecoApplicantDetails_2.add("DNewUpdateBor SNewUpdateBor");
		validatecoApplicantDetails_2.add("divya.s+newupdatebor@perfios.com");
		validatecoApplicantDetails_2.add("new updteFrm Dshbrd");
		validatecoApplicantDetails_2.add("Testing");
		
		ArrayList<String> validatecoApplicantDetails_3 = new ArrayList<String>();
		validatecoApplicantDetails_3.add("DAdminSec SAdminSec");
		validatecoApplicantDetails_3.add("divya.s+AdminSec@perfios.com");
		validatecoApplicantDetails_3.add("AddedSec from admin");
		validatecoApplicantDetails_3.add("Development sec");

		
        for (int i = 0; i < loanDetailsPage.getNumberOfCoApplicants(); i++) {
			if (i == 0)
				for (int j = 0; j < validatecoApplicantDetails_1.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, validatecoApplicantDetails_1.get(j));
				}
			if (i == 1) {
				for (int j = 0; j < validatecoApplicantDetails_2.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, validatecoApplicantDetails_2.get(j));
				}
			}
			if (i == 2) {
				for (int j = 0; j < validatecoApplicantDetails_3.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, validatecoApplicantDetails_3.get(j));
				}
			}
		}
	}
}

