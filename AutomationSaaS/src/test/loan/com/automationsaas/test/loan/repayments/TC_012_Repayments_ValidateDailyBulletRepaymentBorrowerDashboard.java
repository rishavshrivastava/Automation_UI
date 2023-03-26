package com.automationsaas.test.loan.repayments;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_012_Repayments_ValidateDailyBulletRepaymentBorrowerDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(2);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(2);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);

		borrowerDashboardPage.clickLoanDetailsButton();
		
		ArrayList<String> serialno = new ArrayList<String>();
		serialno.add("1");
		serialno.add("2");
		
		ArrayList<String> payableamount = new ArrayList<String>();
		payableamount.add("Rs0");
		payableamount.add("Rs218,000");
		
		ArrayList<String> penalties = new ArrayList<String>();
		penalties.add("Rs0");
		penalties.add("Rs0");
		
		ArrayList<String> markpaid = new ArrayList<String>();
		markpaid.add("-");
		markpaid.add("-");
		
		ArrayList<String> totalinterestamount = new ArrayList<String>();
		totalinterestamount.add("Rs0");
		totalinterestamount.add("Rs18,000");
		
		ArrayList<String> interest = new ArrayList<String>();
		interest.add("9.00");
		interest.add("9.00");
		
		ArrayList<String> repaymentamount = new ArrayList<String>();
		repaymentamount.add("Rs0");
		repaymentamount.add("Rs218,000");
		
		ArrayList<String> principal = new ArrayList<String>();
		principal.add("Rs0");
		principal.add("Rs200,000");
		
		ArrayList<String> loantenure = new ArrayList<String>();
		loantenure.add("-");
		loantenure.add("12");
		
		ArrayList<String> repaymentdate = new ArrayList<String>();
		for (int i = 1; i <= serialno.size(); i++) {
			String dates = ReadWriteExcel.getDataXY(excel_path, repayments_sheet_name, i, 3);
			repaymentdate.add(dates);
		}
		
		ArrayList<String> status = new ArrayList<String>();
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
