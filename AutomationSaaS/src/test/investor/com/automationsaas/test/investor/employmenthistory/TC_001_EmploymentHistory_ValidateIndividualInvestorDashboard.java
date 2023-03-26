package com.automationsaas.test.investor.employmenthistory;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investor.EmploymentDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_EmploymentHistory_ValidateIndividualInvestorDashboard extends Base {

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

		EmploymentDetailsPage employmentDetailsPage = new EmploymentDetailsPage(driver);
		employmentDetailsPage.clickEmploymentDetails();

		ArrayList<String> employmentDetails = new ArrayList<String>();
		employmentDetails.add("QA");
		employmentDetails.add("Perfios");
		employmentDetails.add("IT");
		employmentDetails.add("Testing");

		for (int i = 0; i < employmentDetails.size(); i++) {
			employmentDetailsPage.validateEmploymentDetails(i, employmentDetails.get(i));
		}
	}
}