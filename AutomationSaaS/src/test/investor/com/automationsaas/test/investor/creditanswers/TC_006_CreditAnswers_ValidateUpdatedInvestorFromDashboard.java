package com.automationsaas.test.investor.creditanswers;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.CreditAnswersPage;
import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_006_CreditAnswers_ValidateUpdatedInvestorFromDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
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
		dashboardPage.validateProfileStatus("Completed");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.validateEmailVerificationLinks();
		dashboardPage.validatePhoneNumberVerificationLinks();
		dashboardPage.validateDepositButton();
		dashboardPage.validateWithdrawButton();
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		CreditAnswersPage creditAnswersPage = new CreditAnswersPage(driver);
		creditAnswersPage.clickCreditAnswers();
		creditAnswersPage.clickCreditAnswersAccordion();

		ArrayList<String> creditAnswers = new ArrayList<String>();
		creditAnswers.add("50000");
		creditAnswers.add("Indian");

		for (int i = 0; i < creditAnswers.size(); i++) {
			creditAnswersPage.validateCreditAnswers(i, creditAnswers.get(i));
		}
	}
}
