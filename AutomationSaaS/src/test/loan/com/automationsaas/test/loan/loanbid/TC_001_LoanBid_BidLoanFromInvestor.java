package com.automationsaas.test.loan.loanbid;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investor.LoanDetailsPage;
import com.automationsaas.pom.investor.LoanOffersPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_LoanBid_BidLoanFromInvestor extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		String investorId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor ID").get(1);
		dashboardPage.validateInvestorID(investorId);
		dashboardPage.clickLoanOffers();

		LoanOffersPage loanOffersPage = new LoanOffersPage(driver);
		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		loanOffersPage.enterLoanId(loanId);
		loanOffersPage.clickSearch();

		ArrayList<String> searchedLoanDetails = new ArrayList<String>();
		searchedLoanDetails.add(loanId);
		searchedLoanDetails.add("12 Months");
		searchedLoanDetails.add("9.00 %");
		searchedLoanDetails.add("Rs200,000");
		for (int i = 0; i < searchedLoanDetails.size(); i++) {
			loanOffersPage.validateSearchedLoanOffers(i, searchedLoanDetails.get(i));
		}
		loanOffersPage.progressBarPercentage("0.00% funded");
		loanOffersPage.clickLoanId(loanId);

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.clickFundThisLoanApplication();
		loanDetailsPage.enterBidAmount("200000");
		loanDetailsPage.clickBid();
		loanDetailsPage.waitForBidToBeProcessed();
		loanDetailsPage.waitForProgressBarToShowProgress("100.0% funded");
	}
}
