package com.automationsaas.test.investor.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.BankDetailsPage;
import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_010_BankDetails_ValidateUpdatedNewInvestorDetailsDashboard extends Base {

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
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.clickBankDetails();
		bankDetailsPage.clickBankDetailsAccordion();

		// validate added bank details from dashboard.
		ArrayList<String> bankDetails_1 = new ArrayList<String>();
		bankDetails_1.add("45456767");
		bankDetails_1.add("Current");
		bankDetails_1.add("HDFC");
		bankDetails_1.add("HDFCIN678");
		
		bankDetails_1.add("23234545");
		bankDetails_1.add("Current");
		bankDetails_1.add("Kotak");
		bankDetails_1.add("Kotak96");

		ArrayList<String> bankDetails_2 = new ArrayList<String>();
		

		for (int i = 0; i < bankDetailsPage.getBankDetailsCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < bankDetails_1.size(); j++) {
					bankDetailsPage.validateBankDetails(i, j, bankDetails_1.get(j));
				}
			} else if (i == 1) {
				for (int j = 0; j < bankDetails_2.size(); j++) {
					bankDetailsPage.validateBankDetails(i, j, bankDetails_2.get(j));
				}
			}
		}
	}
}
