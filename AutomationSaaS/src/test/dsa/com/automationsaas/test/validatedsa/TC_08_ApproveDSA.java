package com.automationsaas.test.validatedsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admindsa.DSADetailsPage;
import com.automationsaas.pom.admindsa.DSAPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_08_ApproveDSA extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void approveDSADetails() throws InterruptedException {

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
		String DSAId = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);

		dSAsearchPage.enterEmail(DSAEmail);
		dSAsearchPage.clickSearch();
		dSAsearchPage.clickAction();

		DSADetailsPage dsaDetailsPage = new DSADetailsPage(driver);
		dsaDetailsPage.validateDsaId(DSAId);
		dsaDetailsPage.validateDsaStatus("Awaiting Approval", "Awaiting_Approval");
		dsaDetailsPage.changeDsaStatus("Approved", "Yes");
		dsaDetailsPage.validateDsaStatus("Approved", "Approved");

	}

}