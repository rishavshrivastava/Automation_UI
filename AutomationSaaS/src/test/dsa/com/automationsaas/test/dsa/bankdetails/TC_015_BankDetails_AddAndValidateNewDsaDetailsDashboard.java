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

public class TC_015_BankDetails_AddAndValidateNewDsaDetailsDashboard extends Base {

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
		bankDetailsPage.clickAddBankDetails();

		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("Divya new");
		bankDetails.add("78901234");
		bankDetails.add("ICICI");
		bankDetails.add("Anwarganj");
		bankDetails.add("ICICI1010");
		bankDetails.add("");
		bankDetails.add("112233");
		bankDetails.add("Savings");
		bankDetails.add("Railway Station");
		bankDetails.add("SW1234");
		bankDetails.add("202020");
		bankDetails.add("Kanpur");
		bankDetails.add("Offline");
		bankDetails.add("Test Dev");

		for (int i = 0; i < bankDetails.size(); i++) {
			bankDetailsPage.editBankDetails(i, bankDetails.get(i), "1998", "Jun", "13");
		}

		bankDetailsPage.clickAddBankDetailsDone();

		Generics.refreshPage(driver);
		bankDetailsPage.clickBankDetails();

		int bankDetailsCount = bankDetailsPage.getBankDetailsCount();
		assertEquals(bankDetailsCount, 1);

		ArrayList<String> bankDetails_validate_1 = new ArrayList<String>();
		bankDetails_validate_1.add("Divya new");
		bankDetails_validate_1.add("78901234");
		bankDetails_validate_1.add("Savings");
		bankDetails_validate_1.add("ICICI");
		bankDetails_validate_1.add("ICICI1010");
		bankDetails_validate_1.add("Anwarganj");
		bankDetails_validate_1.add("13/06/1998");
		bankDetails_validate_1.add("112233");
		bankDetails_validate_1.add("Railway Station");
		bankDetails_validate_1.add("SW1234");
		bankDetails_validate_1.add("202020");
		bankDetails_validate_1.add("Kanpur");
		bankDetails_validate_1.add("Offline");
		bankDetails_validate_1.add("Test Dev");

		for (int i = 0; i < bankDetails_validate_1.size(); i++) {
			bankDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails_validate_1.get(i));
		}
	}
}
