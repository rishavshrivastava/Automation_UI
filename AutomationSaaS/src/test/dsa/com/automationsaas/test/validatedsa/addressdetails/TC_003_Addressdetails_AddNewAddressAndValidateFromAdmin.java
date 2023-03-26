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

public class TC_003_Addressdetails_AddNewAddressAndValidateFromAdmin extends Base {

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
		dsaDetailsPage.clickAddressDetailsAccordion(); // accordion code added
		dsaDetailsPage.clickEditAddressDetails();

		ArrayList<String> updateAddressDetails = new ArrayList<String>();
		updateAddressDetails.add("First line 123");
		updateAddressDetails.add("Second Line 234");
		updateAddressDetails.add("Third Line 345");
		updateAddressDetails.add("Koramangla");
		updateAddressDetails.add("Indira Nagar");
		updateAddressDetails.add("Karnataka");
		updateAddressDetails.add("Bhopal");
		updateAddressDetails.add("India A");
		updateAddressDetails.add("534087");
		updateAddressDetails.add("");
		updateAddressDetails.add("Staff Residence");

		for (int i = 0; i < updateAddressDetails.size(); i++) {
			dsaDetailsPage.editAddressDetails(i, updateAddressDetails.get(i), "2015", "Dec", "18");
		}
		dsaDetailsPage.clickSaveEditAddress();

		Generics.refreshPage(driver);
		Generics.scrollPage(driver, 800);
		dsaDetailsPage.clickAddressDetailsAccordion();
		dsaDetailsPage.clickEditAddressDetails();

		ArrayList<String> addressDetails = new ArrayList<String>();
		addressDetails.add("First line 123");
		addressDetails.add("Second Line 234");
		addressDetails.add("Third Line 345");
		addressDetails.add("Koramangla");
		addressDetails.add("Indira Nagar");
		addressDetails.add("Karnataka");
		addressDetails.add("Bhopal");
		addressDetails.add("India A");
		addressDetails.add("534087");
		addressDetails.add("18/12/2015");
		updateAddressDetails.add("Staff Residence");

		for (int i = 0; i < addressDetails.size(); i++) {
			dsaDetailsPage.validateUpdatedAddressDetail(i, addressDetails.get(i));
		}
		dsaDetailsPage.closeAddressEditOverlay();

	}
}
