package com.automationsaas.test.validatedsa.addressdetails;

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

public class TC_007_Addressdetails_DeleteAddressFromAdminAndValidate extends Base {

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
		
		Generics.scrollPage(driver, 800);
		Generics.waitForFewSecondstoLoad(3000);
		dsaDetailsPage.clickAddressDetailsAccordion(); //accordion code added
		dsaDetailsPage.clickAddressDetailsDelete();
		Generics.refreshPage(driver);
		
		Generics.scrollPage(driver, 800);
		dsaDetailsPage.clickAddressDetailsAccordion();

		ArrayList<String> addressDetails = new ArrayList<String>();
		addressDetails.add("1");
		addressDetails.add("Personal Address");
		addressDetails.add("");
		addressDetails.add("");
		addressDetails.add("");
		addressDetails.add("");
		addressDetails.add("");
		addressDetails.add("");
		addressDetails.add("");
		addressDetails.add("");
		addressDetails.add("");
		addressDetails.add("");
		addressDetails.add("");
		for (int i = 0; i < addressDetails.size(); i++) {
			dsaDetailsPage.validateAddressDetails(i, addressDetails.get(i));
		}
	}


}
