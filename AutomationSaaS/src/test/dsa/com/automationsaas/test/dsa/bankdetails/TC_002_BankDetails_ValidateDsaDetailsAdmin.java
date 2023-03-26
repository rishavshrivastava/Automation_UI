package com.automationsaas.test.dsa.bankdetails;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admindsa.DSADetailsPage;
import com.automationsaas.pom.admindsa.DSAPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_BankDetails_ValidateDsaDetailsAdmin extends Base {

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
		dsaDetailsPage.clickBankDetails();
		dsaDetailsPage.clickBankDetailsAccordion();

		int bankDetailsCount = dsaDetailsPage.getBankDetailsCount();
		assertEquals(bankDetailsCount, 1);

		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("5684521256");
		bankDetails.add("Savings");
		bankDetails.add("SBI");
		bankDetails.add("SBIN999");
		bankDetails.add("Rishav");
		bankDetails.add("Testing");
		bankDetails.add("MICO");
		bankDetails.add("Test");
		bankDetails.add("01/03/2001");
		bankDetails.add("Test");
		bankDetails.add("452563");
		bankDetails.add("Bangalore");
		bankDetails.add("Online");
		bankDetails.add("Testing");

		for (int i = 0; i < bankDetails.size(); i++) {
			dsaDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails.get(i));
		}
	}
}