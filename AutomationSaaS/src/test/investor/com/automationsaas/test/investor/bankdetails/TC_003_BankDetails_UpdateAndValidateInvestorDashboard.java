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

public class TC_003_BankDetails_UpdateAndValidateInvestorDashboard extends Base {

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
		dashboardPage.validateProfileStatus("Completed");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.validateEmailVerificationLinks();
		dashboardPage.validatePhoneNumberVerificationLinks();
		dashboardPage.validateDepositButton();
		dashboardPage.validateWithdrawButton();
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.clickBankDetails();
		bankDetailsPage.clickBankDetailsAccordion();
		bankDetailsPage.clickBankDetailsEdit();
		
		ArrayList<String> bankDetailsInPopUp = new ArrayList<String>();
		bankDetailsInPopUp.add("857845856");
		bankDetailsInPopUp.add("SBI");
		bankDetailsInPopUp.add("SBIN555");
		bankDetailsInPopUp.add("Savings");

		for (int i = 0; i < bankDetailsInPopUp.size(); i++) {
			bankDetailsPage.validateBankDetailsInPopup(i, bankDetailsInPopUp.get(i));
		}
		
		bankDetailsPage.clickBankDetailsPopupClose();
		Generics.refreshPage(driver);
		
		bankDetailsPage.clickBankDetails();
		bankDetailsPage.clickBankDetailsAccordion();
		bankDetailsPage.clickBankDetailsEdit();
		
		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("85478547845");
		bankDetails.add("AXIS");
		bankDetails.add("AXN00303");
		bankDetails.add("Current");

		for (int i = 0; i < bankDetails.size(); i++) {
			bankDetailsPage.editBankDetails(i, bankDetails.get(i));
		}
		bankDetailsPage.clickBankDetailsEditDone();
		
		//Validate Updated Bank Details
		Generics.refreshPage(driver);
		bankDetailsPage.clickBankDetails();
		bankDetailsPage.clickBankDetailsAccordion();
		ArrayList<String> updatedBankDetails = new ArrayList<String>();
		updatedBankDetails.add("85478547845");
		updatedBankDetails.add("Current");
		updatedBankDetails.add("AXIS");
		updatedBankDetails.add("AXN00303");

		for (int j = 0; j < updatedBankDetails.size(); j++) {
		bankDetailsPage.validateBankDetails(0,j, updatedBankDetails.get(j));
		}
	}
}