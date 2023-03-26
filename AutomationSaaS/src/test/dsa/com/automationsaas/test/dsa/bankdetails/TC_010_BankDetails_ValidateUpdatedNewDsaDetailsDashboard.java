package com.automationsaas.test.dsa.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.BankDetailsPage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_010_BankDetails_ValidateUpdatedNewDsaDetailsDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		String dsaname = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA Name").get(1);
		dashboardPage.validateDSAName(dsaname);
		String dsaid = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		System.out.println();
		dashboardPage.validateDSAId(dsaid);
		dashboardPage.validateProfileStatus("Awaiting Approval");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.clickBankDetails();
		// Bank Details

		ArrayList<String> bankDetails_validate_1 = new ArrayList<String>();
		bankDetails_validate_1.add("Divya dashboard");
		bankDetails_validate_1.add("908708654");
		bankDetails_validate_1.add("Current");
		bankDetails_validate_1.add("PNB");
		bankDetails_validate_1.add("PNB1098");
		bankDetails_validate_1.add("PNB Hi tech City");
		bankDetails_validate_1.add("12/08/2003");
		bankDetails_validate_1.add("119876");
		bankDetails_validate_1.add("Madhapur");
		bankDetails_validate_1.add("PNB56587");
		bankDetails_validate_1.add("208976");
		bankDetails_validate_1.add("Hyderabad");
		bankDetails_validate_1.add("Online");
		bankDetails_validate_1.add("Test QA");

		ArrayList<String> bankDetails_validate_2 = new ArrayList<String>();
		bankDetails_validate_2.add("Divya edit");
		bankDetails_validate_2.add("124124124");
		bankDetails_validate_2.add("Savings");
		bankDetails_validate_2.add("HDFC");
		bankDetails_validate_2.add("HDFCTest");
		bankDetails_validate_2.add("Quadron");
		bankDetails_validate_2.add("21/12/2001");
		bankDetails_validate_2.add("789065");
		bankDetails_validate_2.add("Hinjewadi");
		bankDetails_validate_2.add("HD123123");
		bankDetails_validate_2.add("393030");
		bankDetails_validate_2.add("Pune");
		bankDetails_validate_2.add("Offline");
		bankDetails_validate_2.add("Automation");

		for (int i = 0; i < bankDetailsPage.getBankDetailsCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < bankDetails_validate_1.size(); j++) {
					bankDetailsPage.validateBankDetails(i, j, bankDetails_validate_1.get(j));
				}
			} else if (i == 1) {
				for (int j = 0; j < bankDetails_validate_2.size(); j++) {
					bankDetailsPage.validateBankDetails(i, j, bankDetails_validate_2.get(j));
				}
			}
		}
	}
}
