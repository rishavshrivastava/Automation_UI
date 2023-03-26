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

public class TC_016_BankDetails_ValidateNewAddedDsaDetailsAdmin extends Base {

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

		ArrayList<String> bankDetails_validate_1 = new ArrayList<String>();

		bankDetails_validate_1.add("78901234");
		bankDetails_validate_1.add("Savings");
		bankDetails_validate_1.add("ICICI");
		bankDetails_validate_1.add("ICICI1010");
		bankDetails_validate_1.add("Divya new");
		bankDetails_validate_1.add("Anwarganj");
		bankDetails_validate_1.add("Railway Station");
		bankDetails_validate_1.add("112233");
		bankDetails_validate_1.add("13/06/1998");
		bankDetails_validate_1.add("SW1234");
		bankDetails_validate_1.add("202020");
		bankDetails_validate_1.add("Kanpur");
		bankDetails_validate_1.add("Offline");
		bankDetails_validate_1.add("Test Dev");

		for (int i = 0; i < bankDetails_validate_1.size(); i++) {
			dsaDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails_validate_1.get(i));
		}
	}
}