package com.automationsaas.test.dsa.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admindsa.DSADetailsPage;
import com.automationsaas.pom.admindsa.DSAPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_007_BankDetails_AddAndValidateNewDsaDetailsAdmin extends Base {

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

		// Bank Details
		dsaDetailsPage.clickBankDetails();

		dsaDetailsPage.clickAddBankDetails();
		ArrayList<String> bankDetails_add = new ArrayList<String>();
		bankDetails_add.add("Divya first");
		bankDetails_add.add("123123123");
		bankDetails_add.add("Kotak");
		bankDetails_add.add("Gachibowli");
		bankDetails_add.add("KTK009988");
		bankDetails_add.add("");
		bankDetails_add.add("9249325");
		bankDetails_add.add("Current");
		bankDetails_add.add("DLF Cyber city");
		bankDetails_add.add("KT1234");
		bankDetails_add.add("1234567");
		bankDetails_add.add("Secunderabad");
		bankDetails_add.add("Public");
		bankDetails_add.add("Test Automation");

		for (int j = 0; j < bankDetails_add.size(); j++) {
			dsaDetailsPage.addBankDetails(j, bankDetails_add.get(j), "2000", "Mar", "20");
		}
		dsaDetailsPage.clickAddBankDetailsDone();

		dsaDetailsPage.clickBankDetailsAccordion();
		ArrayList<String> bankDetails_1 = new ArrayList<String>();
		bankDetails_1.add("123123123");
		bankDetails_1.add("Current");
		bankDetails_1.add("Kotak");
		bankDetails_1.add("KTK009988");
		bankDetails_1.add("Divya first");
		bankDetails_1.add("Gachibowli");
		bankDetails_1.add("DLF Cyber city");
		bankDetails_1.add("9249325");
		bankDetails_1.add("20/03/2000");
		bankDetails_1.add("KT1234");
		bankDetails_1.add("1234567");
		bankDetails_1.add("Secunderabad");
		bankDetails_1.add("Public");
		bankDetails_1.add("Test Automation");

		ArrayList<String> bankDetails_2 = new ArrayList<String>();
		bankDetails_2.add("908708654");
		bankDetails_2.add("Current");
		bankDetails_2.add("PNB");
		bankDetails_2.add("PNB1098");
		bankDetails_2.add("Divya dashboard");
		bankDetails_2.add("PNB Hi tech City");
		bankDetails_2.add("Madhapur");
		bankDetails_2.add("119876");
		bankDetails_2.add("12/08/2003");
		bankDetails_2.add("PNB56587");
		bankDetails_2.add("208976");
		bankDetails_2.add("Hyderabad");
		bankDetails_2.add("Online");
		bankDetails_2.add("Test QA");

		for (int i = 0; i < dsaDetailsPage.getBankDetailsCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < bankDetails_1.size(); j++) {
					dsaDetailsPage.validateBankDetails(i, j, bankDetails_1.get(j));
				}
			} else if (i == 1) {
				for (int j = 0; j < bankDetails_2.size(); j++) {
					dsaDetailsPage.validateBankDetails(i, j, bankDetails_2.get(j));
				}
			}
		}

	}
}
