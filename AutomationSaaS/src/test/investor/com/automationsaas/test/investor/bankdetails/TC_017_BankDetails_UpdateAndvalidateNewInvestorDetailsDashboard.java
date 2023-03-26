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

public class TC_017_BankDetails_UpdateAndvalidateNewInvestorDetailsDashboard extends Base {

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

		// same validate bank details method here also as in tc08

		// validate added bank details from dashboard.

		bankDetailsPage.clickBankDetails();
		bankDetailsPage.clickBankDetailsEdit();
		//

		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("879123546");
		bankDetails.add("ICICI");
		bankDetails.add("ICIC098875");
		bankDetails.add("Current");

		for (int i = 0; i < bankDetails.size(); i++) {
			bankDetailsPage.editBankDetails(i, bankDetails.get(i));
		}
		bankDetailsPage.clickBankDetailsEditDone();

		// Validate Updated Bank Details
		Generics.refreshPage(driver);
		bankDetailsPage.clickBankDetails();
		bankDetailsPage.clickBankDetailsAccordion();

		ArrayList<String> bankDetails_validate = new ArrayList<String>();
		bankDetails_validate.add("879123546");
		bankDetails_validate.add("Current");
		bankDetails_validate.add("ICICI");
		bankDetails_validate.add("ICIC098875");
		for (int j = 0; j < bankDetails_validate.size(); j++) {
			bankDetailsPage.validateBankDetails(0, j, bankDetails_validate.get(j));
		}
	}
}
