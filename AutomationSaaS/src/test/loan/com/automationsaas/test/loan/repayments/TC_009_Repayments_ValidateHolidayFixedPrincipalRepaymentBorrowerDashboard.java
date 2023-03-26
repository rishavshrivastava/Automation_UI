package com.automationsaas.test.loan.repayments;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_009_Repayments_ValidateHolidayFixedPrincipalRepaymentBorrowerDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(4);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(4);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);

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
		payableamount.add("Rs1,500");
		payableamount.add("Rs1,500");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,042");
		payableamount.add("Rs17,917");
		payableamount.add("Rs17,792");
		payableamount.add("Rs17,667");
		payableamount.add("Rs17,542");
		payableamount.add("Rs17,417");
		payableamount.add("Rs17,292");
		payableamount.add("Rs17,167");
		payableamount.add("Rs17,042");
		payableamount.add("Rs16,917");
		payableamount.add("Rs16,792");
		
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
		markpaid.add("-");
		markpaid.add("-");
		
		ArrayList<String> totalinterestamount = new ArrayList<String>();
		totalinterestamount.add("Rs0");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,375");
		totalinterestamount.add("Rs1,250");
		totalinterestamount.add("Rs1,125");
		totalinterestamount.add("Rs1,000");
		totalinterestamount.add("Rs875");
		totalinterestamount.add("Rs750");
		totalinterestamount.add("Rs625");
		totalinterestamount.add("Rs500");
		totalinterestamount.add("Rs375");
		totalinterestamount.add("Rs250");
		totalinterestamount.add("Rs125");
		
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
		interest.add("9.00");
		interest.add("9.00");
		
		ArrayList<String> repaymentamount = new ArrayList<String>();
		repaymentamount.add("Rs0");
		repaymentamount.add("Rs1,500");
		repaymentamount.add("Rs1,500");
		repaymentamount.add("Rs18,167");
		repaymentamount.add("Rs18,042");
		repaymentamount.add("Rs17,917");
		repaymentamount.add("Rs17,792");
		repaymentamount.add("Rs17,667");
		repaymentamount.add("Rs17,542");
		repaymentamount.add("Rs17,417");
		repaymentamount.add("Rs17,292");
		repaymentamount.add("Rs17,167");
		repaymentamount.add("Rs17,042");
		repaymentamount.add("Rs16,917");
		repaymentamount.add("Rs16,792");
		
		ArrayList<String> principal = new ArrayList<String>();
		principal.add("Rs0");
		principal.add("Rs0");
		principal.add("Rs0");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		principal.add("Rs16,667");
		
		ArrayList<String> loantenure = new ArrayList<String>();
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		loantenure.add("-");
		
		ArrayList<String> repaymentdate = new ArrayList<String>();
		for (int i = 1; i <= serialno.size(); i++) {
			String dates = ReadWriteExcel.getDataXY(excel_path, repayments_sheet_name, i, 1);
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
		status.add("PENDING");
		status.add("PENDING");

		LoanDetailsPage loanDetailsPage = new  LoanDetailsPage(driver);
		loanDetailsPage.clickLoanRepaymentScheduleAccordion();
		for(int i=0;i<serialno.size();i++) {
			loanDetailsPage.validateRepaymentSchedule(i, serialno.get(i), payableamount.get(i), penalties.get(i), markpaid.get(i), totalinterestamount.get(i), 
					interest.get(i), repaymentamount.get(i), principal.get(i), loantenure.get(i), repaymentdate.get(i), status.get(i));
		}
	}
}
