package com.automationsaas.test.investor.investordetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.BasicProfilePage;
import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_InvestorDetails_ValidateIndividualInvestorDashboard extends Base {

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

		BasicProfilePage basicProfilePage = new BasicProfilePage(driver);
		String phoneNumber = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor Phone Number").get(1);
		ArrayList<String> basicProfile = new ArrayList<String>();
		basicProfile.add(username);
		basicProfile.add("Mr");
		basicProfile.add("Rishav");
		basicProfile.add("Shrivastava");
		basicProfile.add("2/3/1994");
		basicProfile.add("Male");
		basicProfile.add("Unmarried");
		basicProfile.add(phoneNumber);
		basicProfile.add("xxxxxxxx9123");
		basicProfile.add("xxxxxx876H");
		basicProfile.add("Category 1");
		basicProfile.add("Testing");

		for (int i = 0; i < basicProfile.size(); i++) {
			basicProfilePage.validateBasicProfile(i, basicProfile.get(i));
		}
	}
}