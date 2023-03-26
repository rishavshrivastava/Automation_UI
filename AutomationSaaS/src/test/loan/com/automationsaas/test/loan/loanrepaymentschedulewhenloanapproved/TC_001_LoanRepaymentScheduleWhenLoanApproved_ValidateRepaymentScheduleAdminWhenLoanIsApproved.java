package com.automationsaas.test.loan.loanrepaymentschedulewhenloanapproved;

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

public class TC_001_LoanRepaymentScheduleWhenLoanApproved_ValidateRepaymentScheduleAdminWhenLoanIsApproved extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
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
		searchedLoan.add("Application Approved");
		searchedLoan.add("Personal Loan");
		searchedLoan.add("Individual");
		searchedLoan.add(borrowerMailId);

		for (int i = 0; i < searchedLoan.size(); i++) {
			loanApplicationsPage.validateSearchedLoan(i, searchedLoan.get(i));
		}
		
		loanApplicationsPage.clickLoanId();
		ArrayList<String> serialno = new ArrayList<String>();
		serialno.add("1");
		serialno.add("2");
		serialno.add("3");
		serialno.add("4");
		serialno.add("5");
		serialno.add("6");
		serialno.add("7");
		serialno.add("8");
		serialno.add("9");
		serialno.add("10");
		serialno.add("11");
		serialno.add("12");
		serialno.add("13");

		PrintDates.printRepaymentDates(driver, "Even Repayment", 12, excel_path, repayments_sheet_name);
		ArrayList<String> repaymentdate = new ArrayList<String>();
		for (int i = 1; i <= serialno.size(); i++) {
			String dates = ReadWriteExcel.getDataXY(excel_path, repayments_sheet_name, i, 5);
			repaymentdate.add(dates);
		}

		ArrayList<String> principal = new ArrayList<String>();
		principal.add("Rs0");
		principal.add("Rs15,990");
		principal.add("Rs16,110");
		principal.add("Rs16,231");
		principal.add("Rs16,353");
		principal.add("Rs16,475");
		principal.add("Rs16,599");
		principal.add("Rs16,723");
		principal.add("Rs16,849");
		principal.add("Rs16,975");
		principal.add("Rs17,103");
		principal.add("Rs17,231");
		principal.add("Rs17,360");

		ArrayList<String> totalinterestamount = new ArrayList<String>();
		totalinterestamount.add("Rs0");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,380");
		totalinterestamount.add("Rs1,259");
		totalinterestamount.add("Rs1,138");
		totalinterestamount.add("Rs1,015");
		totalinterestamount.add("Rs891");
		totalinterestamount.add("Rs767");
		totalinterestamount.add("Rs641");
		totalinterestamount.add("Rs515");
		totalinterestamount.add("Rs388");
		totalinterestamount.add("Rs259");
		totalinterestamount.add("Rs130");

		ArrayList<String> loantenure = new ArrayList<String>();
		loantenure.add("-");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");
		loantenure.add("12");

		ArrayList<String> penalties = new ArrayList<String>();
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");
		penalties.add("Rs0");

		ArrayList<String> leftprincipal = new ArrayList<String>();
		leftprincipal.add("Rs0");
		leftprincipal.add("Rs15,990");
		leftprincipal.add("Rs16,110");
		leftprincipal.add("Rs16,231");
		leftprincipal.add("Rs16,353");
		leftprincipal.add("Rs16,475");
		leftprincipal.add("Rs16,599");
		leftprincipal.add("Rs16,723");
		leftprincipal.add("Rs16,849");
		leftprincipal.add("Rs16,975");
		leftprincipal.add("Rs17,103");
		leftprincipal.add("Rs17,231");
		leftprincipal.add("Rs17,360");

		ArrayList<String> leftinterest = new ArrayList<String>();
		leftinterest.add("Rs0");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,380");
		leftinterest.add("Rs1,259");
		leftinterest.add("Rs1,138");
		leftinterest.add("Rs1,015");
		leftinterest.add("Rs891");
		leftinterest.add("Rs767");
		leftinterest.add("Rs641");
		leftinterest.add("Rs515");
		leftinterest.add("Rs388");
		leftinterest.add("Rs259");
		leftinterest.add("Rs130");

		ArrayList<String> leftpenalty = new ArrayList<String>();
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");
		leftpenalty.add("-");

		ArrayList<String> payableamount = new ArrayList<String>();
		payableamount.add("Rs0");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");
		payableamount.add("Rs17,490");

		ArrayList<String> principaloutstanding = new ArrayList<String>();
		principaloutstanding.add("Rs200,000");
		principaloutstanding.add("Rs184,010");
		principaloutstanding.add("Rs167,899");
		principaloutstanding.add("Rs151,668");
		principaloutstanding.add("Rs135,316");
		principaloutstanding.add("Rs118,840");
		principaloutstanding.add("Rs102,241");
		principaloutstanding.add("Rs85,518");
		principaloutstanding.add("Rs68,669");
		principaloutstanding.add("Rs51,694");
		principaloutstanding.add("Rs34,591");
		principaloutstanding.add("Rs17,360");
		principaloutstanding.add("Rs0");

		ArrayList<String> status = new ArrayList<String>();
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");
		status.add("PENDING");

		ArrayList<String> repaymentpayment = new ArrayList<String>();
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");
		repaymentpayment.add("");

		ArrayList<String> paymentdate = new ArrayList<String>();
		paymentdate.add("-");
		paymentdate.add("-");
		paymentdate.add("-");
		paymentdate.add("-");
		paymentdate.add("-");
		paymentdate.add("-");
		paymentdate.add("-");
		paymentdate.add("-");
		paymentdate.add("-");
		paymentdate.add("-");
		paymentdate.add("-");
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
