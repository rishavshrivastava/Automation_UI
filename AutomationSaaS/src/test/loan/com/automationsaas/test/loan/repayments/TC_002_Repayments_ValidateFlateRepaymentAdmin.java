package com.automationsaas.test.loan.repayments;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.PrintDates;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_Repayments_ValidateFlateRepaymentAdmin extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void validateRepayment() {
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

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(2);

		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();

		loanApplicationsPage.clickLoanId();
		ArrayList<String> serialno = new ArrayList<String>();
		serialno.add("1");
		serialno.add("2");

		PrintDates.printRepaymentDates(driver, "Flat Repayment", 12, excel_path, repayments_sheet_name);
		ArrayList<String> repaymentdate = new ArrayList<String>();
		for (int i = 1; i <= serialno.size(); i++) {
			String dates = ReadWriteExcel.getDataXY(excel_path, repayments_sheet_name, i, 2);
			repaymentdate.add(dates);
		}

		ArrayList<String> principal = new ArrayList<String>();
		principal.add("Rs0");
		principal.add("Rs200,000");

		ArrayList<String> totalinterestamount = new ArrayList<String>();
		totalinterestamount.add("Rs0");
		totalinterestamount.add("Rs18,000");

		ArrayList<String> loantenure = new ArrayList<String>();
		loantenure.add("-");
		loantenure.add("12");

		ArrayList<String> penalties = new ArrayList<String>();
		penalties.add("Rs0");
		penalties.add("Rs0");

		ArrayList<String> leftprincipal = new ArrayList<String>();
		leftprincipal.add("Rs0");
		leftprincipal.add("Rs200,000");

		ArrayList<String> leftinterest = new ArrayList<String>();
		leftinterest.add("Rs0");
		leftinterest.add("Rs18,000");

		ArrayList<String> leftpenalty = new ArrayList<String>();
		leftpenalty.add("-");
		leftpenalty.add("-");

		ArrayList<String> payableamount = new ArrayList<String>();
		payableamount.add("Rs0");
		payableamount.add("Rs218,000");

		ArrayList<String> principaloutstanding = new ArrayList<String>();
		principaloutstanding.add("Rs200,000");
		principaloutstanding.add("Rs0");

		ArrayList<String> status = new ArrayList<String>();
		status.add("PENDING");
		status.add("PENDING");

		ArrayList<String> repaymentpayment = new ArrayList<String>();
		repaymentpayment.add("");
		repaymentpayment.add("");

		ArrayList<String> paymentdate = new ArrayList<String>();
		paymentdate.add("-");
		paymentdate.add("-");

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.clickLoanRepaymentScheduleAccordion();
		for (int i = 0; i < serialno.size(); i++) {
			loanDetailsPage.validateRepaymentTable(i, serialno.get(i), repaymentdate.get(i), principal.get(i),
					totalinterestamount.get(i), loantenure.get(i), penalties.get(i), leftprincipal.get(i),
					leftinterest.get(i), leftpenalty.get(i), payableamount.get(i), principaloutstanding.get(i),
					status.get(i), repaymentpayment.get(i), paymentdate.get(i));
		}
	}
}
