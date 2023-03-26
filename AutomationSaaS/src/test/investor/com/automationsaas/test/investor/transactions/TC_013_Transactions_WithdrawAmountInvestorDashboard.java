package com.automationsaas.test.investor.transactions;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_013_Transactions_WithdrawAmountInvestorDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String investorUsername = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		String investorPassword = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		loginPage.enterUsername(investorUsername);
		loginPage.enterPassword(investorPassword);
		loginPage.clickLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickWithdraw();
		dashboardPage.enterWithdrawAmount("5000");
		dashboardPage.clickWithdrawButton();
		dashboardPage.validateAccountBalance("Rs1,500,000");
	}
}
