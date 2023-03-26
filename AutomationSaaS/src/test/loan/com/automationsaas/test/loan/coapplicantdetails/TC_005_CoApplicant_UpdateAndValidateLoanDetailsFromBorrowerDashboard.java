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

public class TC_005_CoApplicant_UpdateAndValidateLoanDetailsFromBorrowerDashboard extends Base {

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

		// validate if co applicant details are present in popup.

		loanDetailsPage.clickCoApplicantDetailsAccordion();
		loanDetailsPage.clickCoApplicantDetailsEdit(0);
		ArrayList<String> coApplicantDetailsInPopUp = new ArrayList<String>();
		coApplicantDetailsInPopUp.add("Divya");
		coApplicantDetailsInPopUp.add("Sachan");
		coApplicantDetailsInPopUp.add("divya.s@perfios.com");
		coApplicantDetailsInPopUp.add("Fintechlabs");
		coApplicantDetailsInPopUp.add("Automation");
		for (int i = 0; i < coApplicantDetailsInPopUp.size(); i++) {
			loanDetailsPage.validateCoApplicantDetailsInPopUp(i, coApplicantDetailsInPopUp.get(i));
		}
		loanDetailsPage.clickEditCoApplicantClose();

		loanDetailsPage.clickCoApplicantDetailsEdit(0);
		ArrayList<String> coApplicantDetails = new ArrayList<String>();
		coApplicantDetails.add("Divyacoapp");
		coApplicantDetails.add("CoappDashboard");
		coApplicantDetails.add("divya.s+dashboard@perfios.com");
		coApplicantDetails.add("784512357845");
		coApplicantDetails.add("BUWER8167Q");
		coApplicantDetails.add("8547457214");
		coApplicantDetails.add("8547457214");
		coApplicantDetails.add("8547457214");
		coApplicantDetails.add("8547457214");
		coApplicantDetails.add("From Dashboard");
		coApplicantDetails.add("Update");
		for (int i = 0; i < coApplicantDetails.size(); i++) {
			loanDetailsPage.editCoApplicantDetails(i, coApplicantDetails.get(i));
		}
		loanDetailsPage.clickEditCoApplicantDone();
		
		Generics.refreshPage(driver);
		loanDetailsPage.clickCoApplicantDetailsAccordion();

		ArrayList<String> validatecoApplicantDetails = new ArrayList<String>();
		validatecoApplicantDetails.add("Divyacoapp CoappDashboard");
		validatecoApplicantDetails.add("divya.s+dashboard@perfios.com");
		validatecoApplicantDetails.add("From Dashboard");
		validatecoApplicantDetails.add("Update");
		for (int i = 0; i < loanDetailsPage.getNumberOfCoApplicants(); i++) {
			if (i == 0) {
				for (int j = 0; j < validatecoApplicantDetails.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(0, j, validatecoApplicantDetails.get(j));
				}
			}
		}
	}
}