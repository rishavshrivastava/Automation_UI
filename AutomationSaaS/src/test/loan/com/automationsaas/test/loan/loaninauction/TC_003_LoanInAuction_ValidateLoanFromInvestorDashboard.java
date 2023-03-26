package com.automationsaas.test.loan.loaninauction;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investor.LoanDetailsPage;
import com.automationsaas.pom.investor.LoanOffersPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_LoanInAuction_ValidateLoanFromInvestorDashboard extends Base {

	@Test(priority = 11, retryAnalyzer = RetryAnalyzer.class, groups={"TC_21_A_BidLoanForRepaymentFileUpload.test"})
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
		String borrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID")
				.get(1);
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
		loanDetailsPage.clickLoanDetailsAccordion();
		ArrayList<String> loanDetails = new ArrayList<String>();
		loanDetails.add("Test_1");
		loanDetails.add("N/A");
		loanDetails.add("28");
		loanDetails.add("Shrivastava");
		loanDetails.add(borrowerMailId);
		loanDetails.add("Unmarried");
		loanDetails.add("Mr");
		loanDetails.add("Rishav");
		loanDetails.add("Male");
		loanDetails.add("02/03/1994");
		loanDetails.add("N/A");
		loanDetails.add("9.00");
		loanDetails.add("12");
		loanDetails.add("Personal Loan");
		loanDetails.add("200000.00");
		loanDetails.add("N/A");
		loanDetails.add("50000.00");
		loanDetails.add("Permanent");
		loanDetails.add("2 Years");
		loanDetails.add("Perfios");
		loanDetails.add("Technology");
		loanDetails.add("QA");
		loanDetails.add("Line1, Line2, Line3, Bangalore, Karnataka, 560090, India, Bangalore, Bengaluru");
		loanDetails.add("Per785");

		for (int i = 0; i < loanDetails.size(); i++) {
			loanDetailsPage.validateLoanDetails(i, loanDetails.get(i));
		}
		loanDetailsPage.clickAllBidsAccordion();
		loanDetailsPage.validateAllBids("There is no Bid to be displayed.");

		loanDetailsPage.clickQuestionGroup1Accordion();
		ArrayList<String> questionGroup = new ArrayList<String>();
		questionGroup.add("Indian");
		questionGroup.add("50000");
		for (int i = 0; i < questionGroup.size(); i++) {
			loanDetailsPage.validateQuestionGroup1(i, questionGroup.get(i));
		}

		loanDetailsPage.clickOtherLoanDetailsAccordion();
		ArrayList<String> otherLoanDetails = new ArrayList<String>();
		otherLoanDetails.add("Testing");
		otherLoanDetails.add("50000.00");
		otherLoanDetails.add("60000.00");
		otherLoanDetails.add("SBI");
		otherLoanDetails.add("Test");
		for (int i = 0; i < otherLoanDetails.size(); i++) {
			loanDetailsPage.validateOtherLoanDetails(i, otherLoanDetails.get(i));
		}

		loanDetailsPage.clickInsuranceDetailsAccordion();
		ArrayList<String> insuranceDetails = new ArrayList<String>();
		insuranceDetails.add("Tata");
		insuranceDetails.add("50000.00");
		insuranceDetails.add("Bank");
		for (int i = 0; i < insuranceDetails.size(); i++) {
			loanDetailsPage.validateInsuranceDetails(i, insuranceDetails.get(i));
		}

		loanDetailsPage.clickVehicleDetailsAccordion();
		ArrayList<String> vehicleDetails = new ArrayList<String>();
		vehicleDetails.add("RE");
		vehicleDetails.add("DL9299");
		vehicleDetails.add("Testing");
		for (int i = 0; i < vehicleDetails.size(); i++) {
			loanDetailsPage.validateVehicleDetails(i, vehicleDetails.get(i));
		}

		loanDetailsPage.clickCoapplicantDetailsAccordion();
		ArrayList<String> coApplicantDetails = new ArrayList<String>();
		coApplicantDetails.add("Rishav Shrivastava");
		coApplicantDetails.add("rishav.s@perfios.com");
		coApplicantDetails.add("Perfios");
		for (int i = 0; i < coApplicantDetails.size(); i++) {
			loanDetailsPage.validateCoApplicantDetails(i, coApplicantDetails.get(i));
		}

		loanDetailsPage.clickReferenceDetailsAccordion();
		ArrayList<String> referenceDetails = new ArrayList<String>();
		referenceDetails.add("Rishav  Shrivastava");
		referenceDetails.add("rishav.s@perfios.com");
		referenceDetails.add("+918524563524");
		referenceDetails.add("Single");
		for (int i = 0; i < referenceDetails.size(); i++) {
			loanDetailsPage.validateReferenceDetails(i, referenceDetails.get(i));
		}

		// Have to put code for validation of PDC Management

		loanDetailsPage.clickLoanRepaymentScheduleAccordion();
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

		ArrayList<String> repaymentdate = new ArrayList<String>();
		for (int i = 2; i <= serialno.size()+1; i++) {
			String dates = ReadWriteExcel.getDataXY(excel_path, repayments_sheet_name, i, 5);
			repaymentdate.add(dates);
		}

		ArrayList<String> principal = new ArrayList<String>();
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

		ArrayList<String> penalties = new ArrayList<String>();
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");
		penalties.add("-");

		ArrayList<String> status = new ArrayList<String>();
		status.add("-");
		status.add("-");
		status.add("-");
		status.add("-");
		status.add("-");
		status.add("-");
		status.add("-");
		status.add("-");
		status.add("-");
		status.add("-");
		status.add("-");
		status.add("-");

		ArrayList<String> serviceFeesFromInvestor = new ArrayList<String>();
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");
		serviceFeesFromInvestor.add("Rs0");

		for (int i = 0; i < serialno.size(); i++) {
			loanDetailsPage.validateLoanRepaymentSchedule(i, status.get(i), serialno.get(i), repaymentdate.get(i),
					penalties.get(i), serviceFeesFromInvestor.get(i), totalinterestamount.get(i), principal.get(i));
		}

		loanDetailsPage.validateRemainingAmountForFunding("200000");
	}
}
