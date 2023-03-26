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

public class TC_012_BankDetails_ValidateDeletedNewDsaDetailsDashboard extends Base {

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

		int bankDetailsCount = bankDetailsPage.getBankDetailsCount();
		assertEquals(bankDetailsCount, 1);

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

		for (int i = 0; i < bankDetails_validate_1.size(); i++) {
			bankDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails_validate_1.get(i));
		}
	}
}
