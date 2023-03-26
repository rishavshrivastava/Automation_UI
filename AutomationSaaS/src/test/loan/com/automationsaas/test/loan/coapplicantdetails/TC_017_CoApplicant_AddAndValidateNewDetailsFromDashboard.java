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

public class TC_017_CoApplicant_AddAndValidateNewDetailsFromDashboard extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
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
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
        
		borrowerDashboardPage.validateLoanStatus("Initialized");

		ArrayList<String> loanDetails = new ArrayList<String>();
		loanDetails.add("Personal Loan");
		loanDetails.add(loanId);
		loanDetails.add("Mr Rishav Shrivastava");
		loanDetails.add("N/A");
		loanDetails.add("Rs209,884");
		loanDetails.add(borrowerId);
		loanDetails.add("Rs200,000");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add("Rs0");
		String currentDate = Generics.getCurrentDate();
		loanDetails.add(currentDate);
		loanDetails.add("12 Months");
		loanDetails.add("9.00%");
		loanDetails.add("N/A");
		for (int i = 0; i < loanDetails.size(); i++) {
			borrowerDashboardPage.validateLoanDetails(i, loanDetails.get(i));
		}

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
		loanDetailsPage.clickAddCoApplicant();

		ArrayList<String> coApplicantDetails = new ArrayList<String>();
		coApplicantDetails.add("DNewbor");
		coApplicantDetails.add("SNewBor");
		coApplicantDetails.add("divya.s+newbor@perfios.com");
		coApplicantDetails.add("839511682059");
		coApplicantDetails.add("AEIUO9801B");
		coApplicantDetails.add("2609200341");
		coApplicantDetails.add("2609200341");
		coApplicantDetails.add("2609200341");
		coApplicantDetails.add("2609200341");
		coApplicantDetails.add("new from bor Dshbrd");
		coApplicantDetails.add("Co Applicant");
		for (int i = 0; i < coApplicantDetails.size(); i++) {
			loanDetailsPage.addCoApplicant(i, coApplicantDetails.get(i));
		}
		loanDetailsPage.clickAddCoApplicantDone();
		
		Generics.refreshPage(driver);
		loanDetailsPage.clickCoApplicantDetailsAccordion();
		loanDetailsPage.clickAddCoApplicant();

		ArrayList<String> coApplicantDetails2 = new ArrayList<String>();
		coApplicantDetails2.add("DNewborthrd");
		coApplicantDetails2.add("SNewthrd");
		coApplicantDetails2.add("divya.s+newborthrd@perfios.com");
		coApplicantDetails2.add("024696240912");
		coApplicantDetails2.add("FGHIJ9870K");
		coApplicantDetails2.add("8359280206");
		coApplicantDetails2.add("8359280206");
		coApplicantDetails2.add("8359280206");
		coApplicantDetails2.add("8359280206");
		coApplicantDetails2.add("third");
		coApplicantDetails2.add("third Co App");
		for (int i = 0; i < coApplicantDetails2.size(); i++) {
			loanDetailsPage.addCoApplicant(i, coApplicantDetails2.get(i));
		}
		loanDetailsPage.clickAddCoApplicantDone();
		
		Generics.refreshPage(driver);
		loanDetailsPage.clickCoApplicantDetailsAccordion();

		ArrayList<String> coApplicantDetails_1 = new ArrayList<String>();
		coApplicantDetails_1.add("Divyacoapp CoappDashboard");
		coApplicantDetails_1.add("divya.s+dashboard@perfios.com");
		coApplicantDetails_1.add("From Dashboard");
		coApplicantDetails_1.add("Update");

		ArrayList<String> coApplicantDetails_2 = new ArrayList<String>();
		coApplicantDetails_2.add("DNewbor SNewBor");
		coApplicantDetails_2.add("divya.s+newbor@perfios.com");
		coApplicantDetails_2.add("new from bor Dshbrd");
		coApplicantDetails_2.add("Co Applicant");

		ArrayList<String> coApplicantDetails_3 = new ArrayList<String>();
		coApplicantDetails_3.add("DNewborthrd SNewthrd");
		coApplicantDetails_3.add("divya.s+newborthrd@perfios.com");
		coApplicantDetails_3.add("third");
		coApplicantDetails_3.add("third Co App");

		for (int i = 0; i < loanDetailsPage.getNumberOfCoApplicants(); i++) {
			if (i == 0)
				for (int j = 0; j < coApplicantDetails_1.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, coApplicantDetails_1.get(j));
				}
			if (i == 1) {
				for (int j = 0; j < coApplicantDetails_2.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, coApplicantDetails_2.get(j));
				}
			}
			if (i == 2) {
				for (int j = 0; j < coApplicantDetails_3.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, coApplicantDetails_3.get(j));
				}
			}
		}
	}
}
