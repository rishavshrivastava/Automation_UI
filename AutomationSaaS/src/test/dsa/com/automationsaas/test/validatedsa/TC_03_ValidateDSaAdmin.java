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

public class TC_03_ValidateDSaAdmin extends Base {

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
		dsaDetailsPage.validateDsaStatus("Awaiting Approval", "Awaiting_Approval");
		dsaDetailsPage.validateAccountBalance("Rs0");
		dsaDetailsPage.validateDsaEmailId(DSAEmail);

		String last4CharsId1 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberOne").get(1), 4);
		System.out.println("last4CharsId1=" + last4CharsId1);
		String last4CharsId2 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberTwo").get(1), 4);

		// Details tab

		ArrayList<String> dsadetails = new ArrayList<String>();
		dsadetails.add("Mr");
		dsadetails.add("Rishav");
		dsadetails.add("Shrivastava");
		dsadetails.add("- Select One -");
		dsadetails.add("Male");
		dsadetails.add("12/11/1994");
		dsadetails.add("Testing");
		dsadetails.add(last4CharsId1);
		dsadetails.add(last4CharsId2);
		dsadetails.add("12/11/1994");

		for (int i = 0; i < dsadetails.size(); i++) {
			dsaDetailsPage.validateDsaDetails(i, dsadetails.get(i));
		}

		Generics.scrollPage(driver, 800);
		dsaDetailsPage.clickAddressDetailsAccordion();
		// Address details section

		ArrayList<String> addressDetails_personalAddress = new ArrayList<String>();
		addressDetails_personalAddress.add("1");
		addressDetails_personalAddress.add("Personal Address");
		addressDetails_personalAddress.add("Line1");
		addressDetails_personalAddress.add("Line2");
		addressDetails_personalAddress.add("Line3");
		addressDetails_personalAddress.add("Sub District Per");
		addressDetails_personalAddress.add("District Per");
		addressDetails_personalAddress.add("Gurgoan");
		addressDetails_personalAddress.add("India A");
		addressDetails_personalAddress.add("Haryana");
		addressDetails_personalAddress.add("213190");
		addressDetails_personalAddress.add("14/11/2007");
		addressDetails_personalAddress.add("Staff Residence");

		System.out.println("addressDetails_personalAddress.size()=" + addressDetails_personalAddress.size());
		for (int i = 0; i < addressDetails_personalAddress.size(); i++) {
			dsaDetailsPage.validateAddressDetails(i, addressDetails_personalAddress.get(i));
		}

		dsaDetailsPage.clickDocumentsAccordion();
		// Documents - upload documents
		dsaDetailsPage.uploadDocument("Address Proof", text_upload_file_path);
		dsaDetailsPage.clickDocumentsAccordion();
		dsaDetailsPage.clickDownloadDocument("Address Proof");

		// validation of documents:

		ArrayList<String> documents_SerialNumber = new ArrayList<String>();
		documents_SerialNumber.add("1");
		documents_SerialNumber.add("2");

		ArrayList<String> documents_DocumentCategory = new ArrayList<String>();
		documents_DocumentCategory.add("Adhar Card");
		documents_DocumentCategory.add("Address Proof");

		ArrayList<String> documents_DocumentName = new ArrayList<String>();
		documents_DocumentName.add("PNGFile.png");
		documents_DocumentName.add("TextFile.txt");

		for (int i = 0; i < documents_SerialNumber.size(); i++) {
			dsaDetailsPage.validateDSADetailsDocuments(i, documents_SerialNumber.get(i),
					documents_DocumentCategory.get(i), documents_DocumentName.get(i));
		}

		// view document:
		dsaDetailsPage.clickViewDocument("Adhar Card");

		// download single document:
		dsaDetailsPage.clickDownloadDocument("Adhar Card");

		// validate single document download
		String documentDownloaded = "PNGFile.png";
		dsaDetailsPage.validateDownloadedDocument(documentDownloaded);

		// upload multiple document
		Generics.refreshPage(driver);
		Generics.scrollPage(driver, 600);
		dsaDetailsPage.clickDocumentsAccordion();
		dsaDetailsPage.uploadDocument("Adhar Card", pdf_upload_file_path);
		Generics.refreshPage(driver);
		Generics.scrollPage(driver, 600);
		dsaDetailsPage.clickDocumentsAccordion();
		dsaDetailsPage.uploadDocument("Address Proof", jpg_upload_file_path);
		dsaDetailsPage.clickDocumentsAccordion();

		// download multiple document

		dsaDetailsPage.clickDownloadDocument("Address Proof");

		String multipleDocumentDownload = "Address_Proof.zip";
		dsaDetailsPage.validateDownloadedDocument(multipleDocumentDownload);
		Generics.refreshPage(driver);
		Generics.scrollPage(driver, 600);
		dsaDetailsPage.clickDocumentsAccordion();

		// delete and view document from upload pop up
		dsaDetailsPage.viewAndDeleteDocument("Address Proof");
		Generics.scrollPage(driver, -800);

		// company details tab
		Generics.scrollPage(driver, -800);
		dsaDetailsPage.clickCompanyDetails();

		String last4CharscompanyId1 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "CompanyIdentityNumberOne").get(1), 4);
		System.out.println(last4CharscompanyId1);
		String last4CharscompanyId2 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "CompanyIdentityNumberTwo").get(1), 4);

		ArrayList<String> companyDetailsInfo = new ArrayList<String>();
		companyDetailsInfo.add("Perfios");
		companyDetailsInfo.add("3892");
		companyDetailsInfo.add("Testing");
		companyDetailsInfo.add("12/11/1994");
		companyDetailsInfo.add("Line123");
		companyDetailsInfo.add("Line234");
		companyDetailsInfo.add("Line345");
		companyDetailsInfo.add("Uttar Pradesh");
		companyDetailsInfo.add("Kanpur");
		companyDetailsInfo.add("785452");
		companyDetailsInfo.add(last4CharscompanyId1);
		companyDetailsInfo.add(last4CharscompanyId2);

		for (int i = 0; i < companyDetailsInfo.size(); i++) {
			dsaDetailsPage.validateCompanyDetails(i, companyDetailsInfo.get(i));
		}

		// Transactions tab

		dsaDetailsPage.clickTransactions();
		dsaDetailsPage.clickCompletedTransactionsAccordion();
		dsaDetailsPage.validateCompletedTransactionNoTransactionText("There is no transaction to be displayed.");

//		// Bank details tab
//
//		dsaDetailsPage.clickBankDetails();
//
//		ArrayList<String> bankDetails = new ArrayList<String>();
//		bankDetails.add("458784521485");
//		bankDetails.add("Savings");
//		bankDetails.add("SBI");
//		bankDetails.add("SBI78585");
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
