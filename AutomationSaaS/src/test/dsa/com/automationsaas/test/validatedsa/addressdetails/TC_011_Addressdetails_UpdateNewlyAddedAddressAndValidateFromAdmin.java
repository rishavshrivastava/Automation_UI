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

public class TC_011_Addressdetails_UpdateNewlyAddedAddressAndValidateFromAdmin extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
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
	
		// Address details update
		Generics.scrollPage(driver, 800);
		dsaDetailsPage.clickAddressDetailsAccordion(); //accordion code added
		dsaDetailsPage.clickEditAddressDetails();

		ArrayList<String> updateAddressDetails = new ArrayList<String>();
		updateAddressDetails.add("Quadron Building 890");
		updateAddressDetails.add("DLF Hitech City 321");
		updateAddressDetails.add("Kondapur");
		updateAddressDetails.add("Madhapur sd");
		updateAddressDetails.add("Forum Mall");
		updateAddressDetails.add("Karnataka");
		updateAddressDetails.add("Hyderabad");
		updateAddressDetails.add("India K");
		updateAddressDetails.add("247820");
		updateAddressDetails.add("");
		updateAddressDetails.add("Double story house");

		for (int i = 0; i < updateAddressDetails.size(); i++) {
			dsaDetailsPage.editAddressDetails(i, updateAddressDetails.get(i),"2018","Feb","16");
		}
		dsaDetailsPage.clickSaveEditAddress();
		Generics.refreshPage(driver);
	    
		Generics.scrollPage(driver, 800);
		dsaDetailsPage.clickAddressDetailsAccordion(); //accordion code added
		dsaDetailsPage.clickEditAddressDetails();
		
		ArrayList<String> addressDetails = new ArrayList<String>();
		addressDetails.add("Quadron Building 890");
		addressDetails.add("DLF Hitech City 321");
		addressDetails.add("Kondapur");
		addressDetails.add("Madhapur sd");
		addressDetails.add("Forum Mall");
		addressDetails.add("Karnataka");
		addressDetails.add("Hyderabad");
		addressDetails.add("India K");
		addressDetails.add("247820");
		addressDetails.add("16/02/2018");
		addressDetails.add("Double story house");
		
		for (int i = 0; i < addressDetails.size(); i++) {
			dsaDetailsPage.validateUpdatedAddressDetail(i, addressDetails.get(i));
		}
		dsaDetailsPage.closeAddressEditOverlay();

	}}