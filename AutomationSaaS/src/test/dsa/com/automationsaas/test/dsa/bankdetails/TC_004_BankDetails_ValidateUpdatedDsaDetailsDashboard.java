package com.automationsaas.test.dsa.bankdetails;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;
import com.automationsaas.pom.dsa.BankDetailsPage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_004_BankDetails_ValidateUpdatedDsaDetailsDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testing() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// DSA Dashboard
		DashboardPage dsaDashboardPage = new DashboardPage(driver);
		dsaDashboardPage.validateProfileStatus("Awaiting Approval");
		dsaDashboardPage.validateAccountBalance("Rs0");
		dsaDashboardPage.clickAccount();
		dsaDashboardPage.clickProfile();
		// Bank Details tab

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.clickBankDetails();

		int bankDetailsCount = bankDetailsPage.getBankDetailsCount();
		assertEquals(bankDetailsCount, 1);

		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("Divya");
		bankDetails.add("123456789");
		bankDetails.add("Current");
		bankDetails.add("SBITest");
		bankDetails.add("SBINTest123");
		bankDetails.add("SBI ABC 123");
		bankDetails.add("11/07/2004");
		bankDetails.add("123098");
		bankDetails.add("Yelahanka");
		bankDetails.add("SBI123123");
		bankDetails.add("123456");
		bankDetails.add("New Bangalore");
		bankDetails.add("Offline");
		bankDetails.add("Test");

		for (int i = 0; i < bankDetails.size(); i++) {
			bankDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails.get(i));
		}
	}
}
