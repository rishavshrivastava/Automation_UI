package com.automationsaas.test.dsa.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admindsa.DSADetailsPage;
import com.automationsaas.pom.admindsa.DSAPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_009_BankDetails_UpdateAndValidateNewDsaDetailsAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateDSA() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		HomePage homePage = new HomePage(driver);
		homePage.clickBusinessPartner();
		homePage.clickBusinessPartnerAll();

		DSAPage dSAPage = new DSAPage(driver);
		String DSAEmail = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		dSAPage.enterEmail(DSAEmail);
		dSAPage.clickSearch();
		dSAPage.clickAction();

		String dsaId = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);

		DSADetailsPage dsaDetailsPage = new DSADetailsPage(driver);
		dsaDetailsPage.validateDsaId(dsaId);
		dsaDetailsPage.validateDsaStatus("Awaiting Approval", "Awaiting_Approval");
		dsaDetailsPage.validateAccountBalance("Rs0");
		dsaDetailsPage.validateDsaEmailId(DSAEmail);

		// Bank Details update
		dsaDetailsPage.clickBankDetails();
		dsaDetailsPage.clickBankDetailsAccordion();

		dsaDetailsPage.clickBankDetailsEdit();

		ArrayList<String> updateBankDetails = new ArrayList<String>();
		updateBankDetails.add("124124124");
		updateBankDetails.add("HDFC");
		updateBankDetails.add("HDFCTest");
		updateBankDetails.add("Savings");
		updateBankDetails.add("Divya edit");
		updateBankDetails.add("Quadron");
		updateBankDetails.add("");
		updateBankDetails.add("789065");
		updateBankDetails.add("Hinjewadi");
		updateBankDetails.add("HD123123");
		updateBankDetails.add("393030");
		updateBankDetails.add("Pune");
		updateBankDetails.add("Offline");
		updateBankDetails.add("Automation");

		for (int i = 0; i < updateBankDetails.size(); i++) {
			dsaDetailsPage.editBankDetails(i, updateBankDetails.get(i), "2001", "Dec", "21");
		}

		dsaDetailsPage.clickBankDetailsDone();
		Generics.refreshPage(driver);

		dsaDetailsPage.clickBankDetails();
		dsaDetailsPage.clickBankDetailsAccordion();

		ArrayList<String> bankDetails_validate_1 = new ArrayList<String>();
		bankDetails_validate_1.add("124124124");
		bankDetails_validate_1.add("Savings");
		bankDetails_validate_1.add("HDFC");
		bankDetails_validate_1.add("HDFCTest");
		bankDetails_validate_1.add("Divya edit");
		bankDetails_validate_1.add("Quadron");
		bankDetails_validate_1.add("Hinjewadi");
		bankDetails_validate_1.add("789065");
		bankDetails_validate_1.add("21/12/2001");
		bankDetails_validate_1.add("HD123123");
		bankDetails_validate_1.add("393030");
		bankDetails_validate_1.add("Pune");
		bankDetails_validate_1.add("Offline");
		bankDetails_validate_1.add("Automation");

		ArrayList<String> bankDetails_validate_2 = new ArrayList<String>();
		bankDetails_validate_2.add("908708654");
		bankDetails_validate_2.add("Current");
		bankDetails_validate_2.add("PNB");
		bankDetails_validate_2.add("PNB1098");
		bankDetails_validate_2.add("Divya dashboard");
		bankDetails_validate_2.add("PNB Hi tech City");
		bankDetails_validate_2.add("Madhapur");
		bankDetails_validate_2.add("119876");
		bankDetails_validate_2.add("12/08/2003");
		bankDetails_validate_2.add("PNB56587");
		bankDetails_validate_2.add("208976");
		bankDetails_validate_2.add("Hyderabad");
		bankDetails_validate_2.add("Online");
		bankDetails_validate_2.add("Test QA");

		for (int i = 0; i < dsaDetailsPage.getBankDetailsCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < bankDetails_validate_1.size(); j++) {
					dsaDetailsPage.validateBankDetails(i, j, bankDetails_validate_1.get(j));
				}
			} else if (i == 1) {
				for (int j = 0; j < bankDetails_validate_2.size(); j++) {
					dsaDetailsPage.validateBankDetails(i, j, bankDetails_validate_2.get(j));
				}
			}
		}
	}
}
