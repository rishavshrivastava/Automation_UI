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

public class TC_006_BankDetails_ValidateUpdatedDsaDetailsAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void updateDSA() {
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

		DSAPage dSAsearchPage = new DSAPage(driver);
		String DSAEmail = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);

		dSAsearchPage.enterEmail(DSAEmail);
		dSAsearchPage.clickSearch();
		dSAsearchPage.clickAction();

		DSADetailsPage dsaDetailsPage = new DSADetailsPage(driver);

		// Bank details tab

		dsaDetailsPage.clickBankDetails();
		dsaDetailsPage.clickBankDetailsAccordion();

		int bankDetailsCount = dsaDetailsPage.getBankDetailsCount();
		assertEquals(bankDetailsCount, 1);
		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("908708654");
		bankDetails.add("Current");
		bankDetails.add("PNB");
		bankDetails.add("PNB1098");
		bankDetails.add("Divya dashboard");
		bankDetails.add("PNB Hi tech City");
		bankDetails.add("Madhapur");
		bankDetails.add("119876");
		bankDetails.add("12/08/2003");
		bankDetails.add("PNB56587");
		bankDetails.add("208976");
		bankDetails.add("Hyderabad");
		bankDetails.add("Online");
		bankDetails.add("Test QA");

		for (int i = 0; i < bankDetails.size(); i++) {
			dsaDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails.get(i));
		}
	}
}
