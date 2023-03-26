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

public class TC_017_BankDetails_UpdateAndvalidateNewDsaDetailsDashboard extends Base {

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
		bankDetails.add("Divya seven");
		bankDetails.add("78901239");
		bankDetails.add("HSBC");
		bankDetails.add("Viman Nagar");
		bankDetails.add("HSBC1010");
		bankDetails.add("");
		bankDetails.add("112230");
		bankDetails.add("Current");
		bankDetails.add("Airport Yerawada");
		bankDetails.add("SW1234567");
		bankDetails.add("202030");
		bankDetails.add("Pune");
		bankDetails.add("Facility");
		bankDetails.add("Testing");
		for (int i = 0; i < bankDetails.size(); i++) {
			bankDetailsPage.editBankDetails(i, bankDetails.get(i), "1997", "Apr", "16");
		}

		bankDetailsPage.clickBankDetailsEditDone();
		Generics.refreshPage(driver);

		// validate bank details after update
		bankDetailsPage.clickBankDetails();
		int bankDetailsCount = bankDetailsPage.getBankDetailsCount();
		assertEquals(bankDetailsCount, 1);

		ArrayList<String> bankDetails_validate_1 = new ArrayList<String>();
		bankDetails_validate_1.add("Divya seven");
		bankDetails_validate_1.add("78901239");
		bankDetails_validate_1.add("Current");
		bankDetails_validate_1.add("HSBC");
		bankDetails_validate_1.add("HSBC1010");
		bankDetails_validate_1.add("Viman Nagar");
		bankDetails_validate_1.add("16/04/1997");
		bankDetails_validate_1.add("112230");
		bankDetails_validate_1.add("Airport Yerawada");
		bankDetails_validate_1.add("SW1234567");
		bankDetails_validate_1.add("202030");
		bankDetails_validate_1.add("Pune");
		bankDetails_validate_1.add("Facility");
		bankDetails_validate_1.add("Testing");

		for (int i = 0; i < bankDetails_validate_1.size(); i++) {
			bankDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails_validate_1.get(i));
		}
	}
}