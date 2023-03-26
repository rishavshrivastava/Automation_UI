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

public class TC_005_Repayments_ValidateFlateRateRepaymentAdmin extends Base {

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

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(3);

		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();

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

		PrintDates.printRepaymentDates(driver, "Flat Rate Repayment", 12, excel_path, repayments_sheet_name);
		ArrayList<String> repaymentdate = new ArrayList<String>();
		for (int i = 1; i <= serialno.size(); i++) {
			String dates = ReadWriteExcel.getDataXY(excel_path, repayments_sheet_name, i, 4);
			repaymentdate.add(dates);
		}

		ArrayList<String> principal = new ArrayList<String>();
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

		ArrayList<String> totalinterestamount = new ArrayList<String>();
		totalinterestamount.add("Rs0");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");
		totalinterestamount.add("Rs1,500");

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
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");
		leftprincipal.add("Rs16,667");

		ArrayList<String> leftinterest = new ArrayList<String>();
		leftinterest.add("Rs0");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");
		leftinterest.add("Rs1,500");

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
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");
		payableamount.add("Rs18,167");

		ArrayList<String> principaloutstanding = new ArrayList<String>();
		principaloutstanding.add("Rs200,000");
		principaloutstanding.add("Rs183,333");
		principaloutstanding.add("Rs166,667");
		principaloutstanding.add("Rs150,000");
		principaloutstanding.add("Rs133,333");
		principaloutstanding.add("Rs116,667");
		principaloutstanding.add("Rs100,000");
		principaloutstanding.add("Rs83,333");
		principaloutstanding.add("Rs66,667");
		principaloutstanding.add("Rs50,000");
		principaloutstanding.add("Rs33,333");
		principaloutstanding.add("Rs16,667");
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
		for (int i = 0; i < serialno.size()-1; i++) {
			loanDetailsPage.validateRepaymentTable(i, serialno.get(i), repaymentdate.get(i), principal.get(i),
					totalinterestamount.get(i), loantenure.get(i), penalties.get(i), leftprincipal.get(i),
					leftinterest.get(i), leftpenalty.get(i), payableamount.get(i), principaloutstanding.get(i),
					status.get(i), repaymentpayment.get(i), paymentdate.get(i));
		}
	}
}
