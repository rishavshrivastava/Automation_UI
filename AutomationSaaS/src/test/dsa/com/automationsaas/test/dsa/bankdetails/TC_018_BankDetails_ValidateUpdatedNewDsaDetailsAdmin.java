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

public class TC_018_BankDetails_ValidateUpdatedNewDsaDetailsAdmin extends Base {

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
		bankDetails.add("78901239");
		bankDetails.add("Current");
		bankDetails.add("HSBC");
		bankDetails.add("HSBC1010");
		bankDetails.add("Divya seven");
		bankDetails.add("Viman Nagar");
		bankDetails.add("Airport Yerawada");
		bankDetails.add("112230");
		bankDetails.add("16/04/1997");
		bankDetails.add("SW1234567");
		bankDetails.add("202030");
		bankDetails.add("Pune");
		bankDetails.add("Facility");
		bankDetails.add("Testing");

		for (int i = 0; i < bankDetails.size(); i++) {
			dsaDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails.get(i));
		}
	}
}