package com.automationsaas.test.loan.coapplicantdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_008_CoApplicant_ValidateNewDetailsFromDashboard extends Base {

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

		ArrayList<String> addedCoApplicantDetails_1 = new ArrayList<String>();
		addedCoApplicantDetails_1.add("Divyacoapp CoappDashboard");
		addedCoApplicantDetails_1.add("divya.s+dashboard@perfios.com");
		addedCoApplicantDetails_1.add("From Dashboard");
		addedCoApplicantDetails_1.add("Update");

		ArrayList<String> addedCoApplicantDetails_2 = new ArrayList<String>();
		addedCoApplicantDetails_2.add("DAdminNew SAdminNew");
		addedCoApplicantDetails_2.add("divya.s+Adminnew@perfios.com");
		addedCoApplicantDetails_2.add("Addednew from admin");
		addedCoApplicantDetails_2.add("Development");

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
		// Divya : validate if co applicant details are present in a popup.
		loanDetailsPage.clickCoApplicantDetailsEdit(1);
		ArrayList<String> coApplicantDetailsInPopUp = new ArrayList<String>();
		coApplicantDetailsInPopUp.add("DAdminNew");
		coApplicantDetailsInPopUp.add("SAdminNew");
		coApplicantDetailsInPopUp.add("divya.s+Adminnew@perfios.com");
		coApplicantDetailsInPopUp.add("Addednew from admin");
		coApplicantDetailsInPopUp.add("Development");
		for (int i = 0; i < coApplicantDetailsInPopUp.size(); i++) {
			loanDetailsPage.validateCoApplicantDetailsInPopUp(i, coApplicantDetailsInPopUp.get(i));
		}
		loanDetailsPage.clickEditCoApplicantClose();
	}
}
