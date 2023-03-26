package com.automationsaas.test.loan.loanrepaymentschedulewhenloanapproved;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_LoanRepaymentScheduleWhenLoanApproved_ValidateRepaymentScheduleBorrowerDashboardWhenLoanIsApproved extends Base {

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

		borrowerDashboardPage.validateProfileStatus("Approved");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Application Approved");

		borrowerDashboardPage.clickLoanDetailsButton();

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

		ArrayList<String> markpaid = new ArrayList<String>();
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");
		markpaid.add("-");

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

		ArrayList<String> interest = new ArrayList<String>();
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");
		interest.add("9.00");

		ArrayList<String> repaymentamount = new ArrayList<String>();
		repaymentamount.add("Rs0");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");
		repaymentamount.add("Rs17,490");

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

		ArrayList<String> repaymentdate = new ArrayList<String>();
		for (int i = 1; i <= serialno.size(); i++) {
			String dates = ReadWriteExcel.getDataXY(excel_path, repayments_sheet_name, i, 5);
			repaymentdate.add(dates);
		}

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

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.clickLoanRepaymentScheduleAccordion();
		
		for (int i = 0; i < serialno.size(); i++) {
			loanDetailsPage.validateRepaymentSchedule(i, serialno.get(i), payableamount.get(i), penalties.get(i),
					markpaid.get(i), totalinterestamount.get(i), interest.get(i), repaymentamount.get(i),
					principal.get(i), loantenure.get(i), repaymentdate.get(i), status.get(i));
		}
	}
}
