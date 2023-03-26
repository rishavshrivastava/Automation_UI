package com.automationsaas.test.dsa.bankdetails;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.BankDetailsPage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_BankDetails_UpdateAndValidateDsaDetailsDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void updateDSA() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// DSA Dashboard
		DashboardPage dsaDashboardPage = new DashboardPage(driver);

		dsaDashboardPage.clickAccount();
		dsaDashboardPage.clickProfile();

		dsaDashboardPage.validateProfileStatus("Awaiting Approval");
		dsaDashboardPage.validateAccountBalance("Rs0");
		// update bank details

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.clickBankDetails();
		bankDetailsPage.clickBankDetailsEdit();

		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("Divya dashboard");
		bankDetails.add("908708654");
		bankDetails.add("PNB");
		bankDetails.add("PNB Hi tech City");
		bankDetails.add("PNB1098");
		bankDetails.add("");
		bankDetails.add("119876");
		bankDetails.add("Current");
		bankDetails.add("Madhapur");
		bankDetails.add("PNB56587");
		bankDetails.add("208976");
		bankDetails.add("Hyderabad");
		bankDetails.add("Online");
		bankDetails.add("Test QA");

		for (int i = 0; i < bankDetails.size(); i++) {
			bankDetailsPage.editBankDetails(i, bankDetails.get(i), "2003", "Aug", "12");
		}

		bankDetailsPage.clickBankDetailsEditDone();
		Generics.refreshPage(driver);

		// validate bank details after update
		bankDetailsPage.clickBankDetails();
		int bankDetailsCount = bankDetailsPage.getBankDetailsCount();
		assertEquals(bankDetailsCount, 1);

		ArrayList<String> bankDetailsValidate = new ArrayList<String>();
		bankDetails.add("Divya dashboard");
		bankDetails.add("908708654");
		bankDetails.add("Current");
		bankDetails.add("PNB");
		bankDetails.add("PNB1098");
		bankDetails.add("PNB Hi tech City");
		bankDetails.add("12/08/2003");
		bankDetails.add("119876");
		bankDetails.add("Madhapur");
		bankDetails.add("PNB56587");
		bankDetails.add("208976");
		bankDetails.add("Hyderabad");
		bankDetails.add("Online");
		bankDetails.add("Test QA");

		for (int i = 0; i < bankDetailsValidate.size(); i++) {
			bankDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetailsValidate.get(i));
		}
	}
}