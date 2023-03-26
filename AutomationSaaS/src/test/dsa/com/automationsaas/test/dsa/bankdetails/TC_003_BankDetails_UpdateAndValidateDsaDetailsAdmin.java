package com.automationsaas.test.dsa.bankdetails;

import static org.testng.Assert.assertEquals;

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

public class TC_003_BankDetails_UpdateAndValidateDsaDetailsAdmin extends Base {

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

		ArrayList<String> dsaDetails = new ArrayList<String>();
		dsaDetails.add("Mr Rishav");
		dsaDetails.add("AWAITING_APPROVAL");
		dsaDetails.add(DSAEmail);
		dsaDetails.add("0");

		for (int i = 0; i < dsaDetails.size(); i++) {
			dSAPage.validateSearchedDSA(i, dsaDetails.get(i));
		}

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
		updateBankDetails.add("123456789");
		updateBankDetails.add("SBITest");
		updateBankDetails.add("SBINTest123");
		updateBankDetails.add("Current");
		updateBankDetails.add("Divya");
		updateBankDetails.add("SBI ABC 123");
		updateBankDetails.add("");
		updateBankDetails.add("123098");
		updateBankDetails.add("Yelahanka");
		updateBankDetails.add("SBI123123");
		updateBankDetails.add("123456");
		updateBankDetails.add("New Bangalore");
		updateBankDetails.add("Offline");
		updateBankDetails.add("Test");

		for (int i = 0; i < updateBankDetails.size(); i++) {
			dsaDetailsPage.editBankDetails(i, updateBankDetails.get(i), "2004", "Jul", "11");
		}

		dsaDetailsPage.clickBankDetailsDone();
		Generics.refreshPage(driver);
		dsaDetailsPage.clickBankDetails();
		dsaDetailsPage.clickBankDetailsAccordion();

		int bankDetailsCount = dsaDetailsPage.getBankDetailsCount();
		assertEquals(bankDetailsCount, 1);

		// validate bank details after update
		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("123456789");
		bankDetails.add("Current");
		bankDetails.add("SBITest");
		bankDetails.add("SBINTest123");
		bankDetails.add("Divya");
		bankDetails.add("SBI ABC 123");
		bankDetails.add("Yelahanka");
		bankDetails.add("123098");
		bankDetails.add("11/07/2004");
		bankDetails.add("SBI123123");
		bankDetails.add("123456");
		bankDetails.add("New Bangalore");
		bankDetails.add("Offline");
		bankDetails.add("Test");

		for (int i = 0; i < bankDetails.size(); i++) {
			dsaDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails.get(i));
		}
	}
}