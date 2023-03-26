package com.automationsaas.test.validatedsa;

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

public class TC_07_ValidateUpdatedDSAFromAdmin extends Base {

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
		String DSAId = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);

		dSAsearchPage.enterEmail(DSAEmail);
		dSAsearchPage.clickSearch();

		ArrayList<String> searchDSADetails = new ArrayList<String>();
		// searchDSADetails.add(DSAId);

		searchDSADetails.add("Mr DivyaDSA");
		searchDSADetails.add("AWAITING_APPROVAL");
		searchDSADetails.add(DSAEmail);
		searchDSADetails.add("0");

		// click on action button.

		for (int i = 0; i < searchDSADetails.size(); i++) {
			dSAsearchPage.validateSearchedDSA(i, searchDSADetails.get(i));
		}
		dSAsearchPage.clickAction();

		DSADetailsPage dsaDetailsPage = new DSADetailsPage(driver);
		dsaDetailsPage.validateDsaId(DSAId);
		dsaDetailsPage.validateDsaStatus("Awaiting Approval", "Awaiting_Approval");
		dsaDetailsPage.validateAccountBalance("Rs0");
		dsaDetailsPage.validateDsaEmailId(DSAEmail);

		String last4CharsId1 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberOne").get(1), 4);
		String last4CharsId2 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberTwo").get(1), 4);
		// Details tab

		ArrayList<String> dsadetails = new ArrayList<String>();
		dsadetails.add("Mr");
		dsadetails.add("DivyaDSA");
		dsadetails.add("SachanDSA");
		dsadetails.add("- Select One -");
		dsadetails.add("Male");
		dsadetails.add("12/11/1995");
		dsadetails.add("Testing1");
		dsadetails.add(last4CharsId1);
		dsadetails.add(last4CharsId2);

		for (int i = 0; i < dsadetails.size(); i++) {
			dsaDetailsPage.validateDsaDetails(i, dsadetails.get(i));
		}

		Generics.scrollPage(driver, -800);
		dsaDetailsPage.clickAddressDetailsAccordion();
		// Address details section

		ArrayList<String> addressDetails_personalAddress = new ArrayList<String>();
		addressDetails_personalAddress.add("1");
		addressDetails_personalAddress.add("Personal Address"); // Personal Address
		addressDetails_personalAddress.add("Line111");
		addressDetails_personalAddress.add("Line112");
		addressDetails_personalAddress.add("Line113");
		addressDetails_personalAddress.add("Sub District Per");
		addressDetails_personalAddress.add("District Per");
		addressDetails_personalAddress.add("Kanpur");
		addressDetails_personalAddress.add("India A");
		addressDetails_personalAddress.add("Karnataka");
		addressDetails_personalAddress.add("208080");
		addressDetails_personalAddress.add("14/11/2007");
		addressDetails_personalAddress.add("Staff Residence");
	
		for (int i = 0; i < addressDetails_personalAddress.size(); i++) {
			dsaDetailsPage.validateAddressDetails(i, addressDetails_personalAddress.get(i));
		}

		String last4CharscompanyId1 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "CompanyIdentityNumberOne").get(1), 4);
		String last4CharscompanyId2 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "CompanyIdentityNumberTwo").get(1), 4);
		// company details tab

		dsaDetailsPage.clickCompanyDetails();

		ArrayList<String> companyDetailsInfo = new ArrayList<String>();
		companyDetailsInfo.add("def private");
		companyDetailsInfo.add("3030");
		companyDetailsInfo.add("Testing");
		companyDetailsInfo.add("12/11/1995");
		companyDetailsInfo.add("Line21");
		companyDetailsInfo.add("Line22");
		companyDetailsInfo.add("Line23");
		companyDetailsInfo.add("Karnataka");
		companyDetailsInfo.add("Pune");
		companyDetailsInfo.add("888777");
		companyDetailsInfo.add(last4CharscompanyId1);
		companyDetailsInfo.add(last4CharscompanyId2);

		for (int i = 0; i < companyDetailsInfo.size(); i++) {
			dsaDetailsPage.validateCompanyDetails(i, companyDetailsInfo.get(i));
		}
//
//		// Bank details tab
//
//		dsaDetailsPage.clickBankDetails();
//
//		ArrayList<String> bankDetails = new ArrayList<String>();
//		bankDetails.add("5684521256");
//		bankDetails.add("Savings");
//		bankDetails.add("SBI");
//		bankDetails.add("SBIN999");
//		for (int i = 0; i < bankDetails.size(); i++) {
//			dsaDetailsPage.validateBankDetails(i, bankDetails.get(i));
//		}

		// Credit Answers tab

		dsaDetailsPage.clickCreditAnswers();
		dsaDetailsPage.clickDSAQuestionGroup1Accordion();
		ArrayList<String> questionGroup1 = new ArrayList<String>();
		questionGroup1.add("50000");
		questionGroup1.add("Indian");
		for (int i = 0; i < questionGroup1.size(); i++) {
			dsaDetailsPage.validateDsaQuestionGroup1(i, questionGroup1.get(i));
		}
	}

}
