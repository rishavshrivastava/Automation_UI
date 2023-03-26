package com.automationsaas.test.investor.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.BankDetailsPage;
import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_015_BankDetails_AddAndValidateNewInvestorDetailsDashboard extends Base {

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
		bankDetailsPage.clickAddBankDetails();

		ArrayList<String> investorDashboardBankDetails_add = new ArrayList<String>();
		investorDashboardBankDetails_add.add("9864321075");
		investorDashboardBankDetails_add.add("PNBPNB");
		investorDashboardBankDetails_add.add("PNB2468");
		investorDashboardBankDetails_add.add("Savings");
		for (int i = 0; i < investorDashboardBankDetails_add.size(); i++) {
			bankDetailsPage.addBankDetails(i, investorDashboardBankDetails_add.get(i));
		}
		bankDetailsPage.clickBankDetailsEditDone();

		Generics.refreshPage(driver);
		bankDetailsPage.clickBankDetails();
		bankDetailsPage.clickBankDetailsAccordion();

		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("9864321075");
		bankDetails.add("Savings");
		bankDetails.add("PNBPNB");
		bankDetails.add("PNB2468");

		for (int i = 0; i < bankDetailsPage.getBankDetailsCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < bankDetails.size(); j++) {
					bankDetailsPage.validateBankDetails(i, j, bankDetails.get(j));
				}
			}
        }
	}
}