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

public class TC_04_UpdateDSAAdmin extends Base {

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

		// Validate Identity Number 1 From DSA Basic Details Page
		String valididentityNumberOne = "11" + Generics.getRandomNumber(10);
		String invalididentityNumberOne11 = "12" + Generics.getRandomNumber(9);
		String invalididentityNumberOne13 = "123" + Generics.getRandomNumber(10);

		// case 1 - Invalid: Identity Number 1= 11 digits
		dsaDetailsPage.validateDSAIdentityNumbersInValidCase("^[0-9]{12}$", invalididentityNumberOne11);
		// case 2 - Invalid: Identity Number 1= 13 digits
		dsaDetailsPage.validateDSAIdentityNumbersInValidCase("^[0-9]{12}$", invalididentityNumberOne13);
		// case 3 - Invalid: Identity Number 1= 12 Alphabets
		dsaDetailsPage.validateDSAIdentityNumbersInValidCase("^[0-9]{12}$", "ABCDEFGHijkL");

		// case 4 - Valid: Identity Number 1= 12 digits
		// Generics.refreshPage(driver);
		dsaDetailsPage.validateDSAIdentityNumbersValidCase("^[0-9]{12}$", valididentityNumberOne);

		// Validate Identity Number 2 From DSA Basic Details Page
		String valididentityNumberTwo = "ABCDE" + Generics.getRandomNumber(4) + "F";
		String invalididentityNumberTwo36 = "ABC" + Generics.getRandomNumber(6);
		String invalididentityNumberTwo35 = "ABC" + Generics.getRandomNumber(5);
		String invalididentityNumberTwo10 = Generics.getRandomNumber(10);
		String invalididentityNumberTwo451 = Generics.getRandomNumber(5) + "ABCD" + 1;

		// case 1 - Invalid: Identity Number 2= 3 Alphabets + 6 numbers
		dsaDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$", invalididentityNumberTwo36);
		// case 2 - Invalid: Identity Number 2= 3 Alphabets + 5 numbers
		dsaDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$", invalididentityNumberTwo35);
		// case 3 - Invalid: Identity Number 2= 12 numbers
		dsaDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$", invalididentityNumberTwo10);
		// case 3 - Invalid: Identity Number 2= 4 numbers + 5 Alphabets + 1 number
		dsaDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$", invalididentityNumberTwo451);

		// case 4 - Valid: Identity Number 2= 5 Alphabets+ 4 numbers + 1 Alphabet
		dsaDetailsPage.validateDSAIdentityNumberTwoValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$", valididentityNumberTwo);

		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 10, 1, valididentityNumberOne);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 11, 1, valididentityNumberTwo);

		// update DSA details tab

		ArrayList<String> updateDSADetails = new ArrayList<String>();
		updateDSADetails.add("Mrs");
		updateDSADetails.add("Divya");
		updateDSADetails.add("Sachan");
		updateDSADetails.add("Female");
		updateDSADetails.add("");
		updateDSADetails.add("Test");
		updateDSADetails.add("");

		for (int i = 0; i < updateDSADetails.size(); i++) {
			dsaDetailsPage.editDsaDetails(i, updateDSADetails.get(i), "1996", "Jun", "10");

		}
		dsaDetailsPage.clickUpdateDsaDetails();
		Generics.scrollPage(driver, 800);
		// Address details update
//		dsaDetailsPage.clickAddressDetailsAccordion();
//		dsaDetailsPage.clickEditAddressDetails();
//
//		ArrayList<String> updateAddressDetails = new ArrayList<String>();
//		updateAddressDetails.add("Line1");
//		updateAddressDetails.add("Line1122");
//		updateAddressDetails.add("Line1133");
//		updateAddressDetails.add("Uttar Pradesh");
//		updateAddressDetails.add("Bangalore");
//		updateAddressDetails.add("560090");
//
//		for (int i = 0; i < updateAddressDetails.size(); i++) {
//			dsaDetailsPage.editAddressDetails(i, updateAddressDetails.get(i));
//		}
//		dsaDetailsPage.clickSaveEditAddress();

		Generics.scrollPage(driver, -800);
		Generics.refreshPage(driver);

		// validation of updated fields

		ArrayList<String> basicDetails = new ArrayList<String>();

		basicDetails.add("Mrs");
		basicDetails.add("Divya");
		basicDetails.add("Sachan");
		basicDetails.add("Female");
		basicDetails.add("10/06/1996");
		basicDetails.add("Test");
		basicDetails.add("10/06/1996");

		for (int i = 0; i < basicDetails.size(); i++) {
			dsaDetailsPage.validateBasicDetail(i, basicDetails.get(i));
		}

//		Generics.scrollPage(driver, 800);
//		
//		dsaDetailsPage.clickAddressDetailsAccordion();
//		dsaDetailsPage.clickEditAddressDetails();
//
//		ArrayList<String> addressDetails = new ArrayList<String>();
//		addressDetails.add("Line1");
//		addressDetails.add("Line1122");
//		addressDetails.add("Line1133");
//		addressDetails.add("Uttar Pradesh");
//		addressDetails.add("Bangalore");
//		addressDetails.add("560090");
//
//		for (int i = 0; i < addressDetails.size(); i++) {
//			dsaDetailsPage.validateUpdatedAddressDetail(i, addressDetails.get(i));
//		}
//		dsaDetailsPage.closeAddressEditOverlay();
		Generics.scrollPage(driver, -800);

		// Validate Identity Number 1 From DSA Company Details Page
		String validcompanyidentityNumberOne = "11" + Generics.getRandomNumber(10);

		// case 1 - Invalid: Identity Number 1= 11 digits
		dsaDetailsPage.validateDSACompanyIdentityNumbeOneInValidCase("^[0-9]{12}$", invalididentityNumberOne11);
		// case 2 - Invalid: Identity Number 1= 13 digits
		dsaDetailsPage.validateDSACompanyIdentityNumbeOneInValidCase("^[0-9]{12}$", invalididentityNumberOne13);
		// case 3 - Invalid: Identity Number 1= 12 Alphabets
		dsaDetailsPage.validateDSACompanyIdentityNumbeOneInValidCase("^[0-9]{12}$", "ABCDEFGHijkL");
		// case 4 - Valid: Identity Number 1= 12 digits
		dsaDetailsPage.validateDSACompanyIdentityNumberOneValidCase("^[0-9]{12}$", validcompanyidentityNumberOne);

		Generics.refreshPage(driver);
		dsaDetailsPage.clickCompanyDetails();
		String validcompanyidentityNumberTwo = "ABCDE" + Generics.getRandomNumber(4) + "F";

		// case 1 - Invalid: Identity Number 2= 3 Alphabets + 6 numbers
		dsaDetailsPage.validateDSACompanyIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				invalididentityNumberTwo36);
		// case 2 - Invalid: Identity Number 2= 3 Alphabets + 5 numbers
		dsaDetailsPage.validateDSACompanyIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				invalididentityNumberTwo35);
		// case 3 - Invalid: Identity Number 2= 12 numbers
		dsaDetailsPage.validateDSACompanyIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				invalididentityNumberTwo10);
		// case 3 - Invalid: Identity Number 2= 4 numbers + 5 Alphabets + 1 number
		dsaDetailsPage.validateDSACompanyIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				invalididentityNumberTwo451);
		// case 4 - Valid: Identity Number 2= 5 Alphabets+ 4 numbers + 1 Alphabet
		dsaDetailsPage.validateDSACompanyIdentityNumberTwoValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				validcompanyidentityNumberTwo);

		// company details update
		ArrayList<String> updateCompanyDetails = new ArrayList<String>();
		updateCompanyDetails.add("abc software");
		updateCompanyDetails.add("2020");
		updateCompanyDetails.add("Test");
		updateCompanyDetails.add("");
		updateCompanyDetails.add("Line11");
		updateCompanyDetails.add("Line12");
		updateCompanyDetails.add("Line13");
		updateCompanyDetails.add("Uttar Pradesh");
		updateCompanyDetails.add("Bangalore");
		updateCompanyDetails.add("123123");

		for (int i = 0; i < updateCompanyDetails.size(); i++) {
			dsaDetailsPage.editCompanyDetails(i, updateCompanyDetails.get(i), "1996", "Jun", "10");
		}
		dsaDetailsPage.updateCompanyDetails();

		Generics.refreshPage(driver);
		dsaDetailsPage.clickCompanyDetails();

		// validate company details after update

		ArrayList<String> companyDetailsInfo = new ArrayList<String>();
		companyDetailsInfo.add("abc software");
		companyDetailsInfo.add("2020");
		companyDetailsInfo.add("Test");
		companyDetailsInfo.add("10/06/1996");
		companyDetailsInfo.add("Line11");
		companyDetailsInfo.add("Line12");
		companyDetailsInfo.add("Line13");
		companyDetailsInfo.add("Uttar Pradesh");
		companyDetailsInfo.add("Bangalore");
		companyDetailsInfo.add("123123");

		for (int i = 0; i < companyDetailsInfo.size(); i++) {
			dsaDetailsPage.validateCompanyDetails(i, companyDetailsInfo.get(i));
		}

//		// Bank Details update
//
//		dsaDetailsPage.clickBankDetails();
//		dsaDetailsPage.clickBankDetailsEdit();
//
//		ArrayList<String> updateBankDetails = new ArrayList<String>();
//		updateBankDetails.add("123456789");
//		updateBankDetails.add("SBITest");
//		updateBankDetails.add("SBINTest");
//		updateBankDetails.add("Current");
//
//		for (int i = 0; i < updateBankDetails.size(); i++) {
//			dsaDetailsPage.editBankDetails(i, updateBankDetails.get(i));
//		}
//
//		dsaDetailsPage.clickBankDetailsDone();
//		Generics.refreshPage(driver);
//		dsaDetailsPage.clickBankDetails();
//
//		// validate bank details after update
//		ArrayList<String> bankDetails = new ArrayList<String>();
//		bankDetails.add("123456789");
//		bankDetails.add("Current");
//		bankDetails.add("SBITest");
//		bankDetails.add("SBINTest");
//		for (int i = 0; i < bankDetails.size(); i++) {
//			dsaDetailsPage.validateBankDetails(i, bankDetails.get(i));
//		}

		// credit answers update

		dsaDetailsPage.clickCreditAnswers();
		dsaDetailsPage.clickDSAQuestionGroup1Accordion();

		ArrayList<String> updateCreditAnswers = new ArrayList<String>();
		updateCreditAnswers.add("10000");
		updateCreditAnswers.add("Dubai");

		for (int i = 0; i < updateCreditAnswers.size(); i++) {
			dsaDetailsPage.editDsaQuestionGroup1(i, updateCreditAnswers.get(i));
		}

		dsaDetailsPage.clickDsaQuestionGroup1Submit();

		Generics.refreshPage(driver);
		dsaDetailsPage.clickCreditAnswers();
		dsaDetailsPage.clickDSAQuestionGroup1Accordion();

		// Validate Credit Answers tab after update

		ArrayList<String> questionGroup1 = new ArrayList<String>();
		questionGroup1.add("10000");
		questionGroup1.add("Dubai");
		for (int i = 0; i < questionGroup1.size(); i++) {
			dsaDetailsPage.validateDsaQuestionGroup1(i, questionGroup1.get(i));
		}
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 12, 1, validcompanyidentityNumberOne);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 13, 1, validcompanyidentityNumberTwo);
	}
}
