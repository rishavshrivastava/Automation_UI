package com.automationsaas.test.investor.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.BankDetailsPage;
import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_BankDetails_ValidateIndividualInvestorDashboard extends Base {

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
		dashboardPage.validateInvestorName("MR RISHAV SHRIVASTAVA");
		dashboardPage.validateInvestorID(investorId);
		dashboardPage.validateProfileStatus("Completed");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.validateEmailVerificationLinks();
		dashboardPage.validatePhoneNumberVerificationLinks();
		dashboardPage.validateDepositButton();
		dashboardPage.validateWithdrawButton();
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.clickBankDetails();
		bankDetailsPage.clickBankDetailsAccordion();

		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("857845856");
		bankDetails.add("Savings");
		bankDetails.add("SBI");
		bankDetails.add("SBIN555");

		for (int j = 0; j < bankDetails.size(); j++) {
			bankDetailsPage.validateBankDetails(0,j, bankDetails.get(j));
		}
	}
}