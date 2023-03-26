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

public class TC_011_BankDetails_DeleteAndValidateNewDsaDetailsAdmin extends Base {

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

		dsaDetailsPage.clickBankDetails();
		dsaDetailsPage.clickBankDetailsAccordion();
		dsaDetailsPage.clickDeleteBankDetails(dsaDetailsPage.getBankDetailsCount() - 2);

		Generics.refreshPage(driver);
		dsaDetailsPage.clickBankDetails();
		dsaDetailsPage.clickBankDetailsAccordion();

		ArrayList<String> bankDetails_validate = new ArrayList<String>();
		bankDetails_validate.add("908708654");
		bankDetails_validate.add("Current");
		bankDetails_validate.add("PNB");
		bankDetails_validate.add("PNB1098");
		bankDetails_validate.add("Divya dashboard");
		bankDetails_validate.add("PNB Hi tech City");
		bankDetails_validate.add("Madhapur");
		bankDetails_validate.add("119876");
		bankDetails_validate.add("12/08/2003");
		bankDetails_validate.add("PNB56587");
		bankDetails_validate.add("208976");
		bankDetails_validate.add("Hyderabad");
		bankDetails_validate.add("Online");
		bankDetails_validate.add("Test QA");

		for (int i = 0; i < dsaDetailsPage.getBankDetailsCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < bankDetails_validate.size(); j++) {
					dsaDetailsPage.validateBankDetails(i, j, bankDetails_validate.get(j));
				}
			}
		}
	}
}
