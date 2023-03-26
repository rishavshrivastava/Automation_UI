package com.automationsaas.test.validatetransactionsdsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admindsa.DSADetailsPage;
import com.automationsaas.pom.admindsa.DSAPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_03_ValidateDepositAmountDSAFromAdminLogin extends Base {
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void transactionFromDSASide() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String adminUsername = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String adminPassword = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(adminUsername);
		loginPage.enterPassword(adminPassword);
		loginPage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickBusinessPartner();
		homePage.clickBusinessPartnerAll();

		
		DSAPage dSAPage = new DSAPage(driver);
		String DSAEmail = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String DSAId = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		dSAPage.enterEmail(DSAEmail);
		dSAPage.clickSearch();	
		dSAPage.clickAction();
		
		DSADetailsPage dsaDetailsPage = new DSADetailsPage(driver);
		dsaDetailsPage.validateDsaId(DSAId);
		dsaDetailsPage.validateDsaEmailId(DSAEmail);
		dsaDetailsPage.validateDsaStatus("Approved", "Approved");
		dsaDetailsPage.validateAccountBalance("Rs0");
	}
}

