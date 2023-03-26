package com.automationsaas.test.validatedsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.dsaonboarding.BankDetailsPage;
import com.automationsaas.pom.dsaonboarding.BusinessPartnerRegistrationPage;
import com.automationsaas.pom.dsaonboarding.DSAQuestionGroup1Page;
import com.automationsaas.pom.dsaonboarding.EmployerCompanyRegistrationPage;
import com.automationsaas.pom.dsaonboarding.SupportingDocumentsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_01_DSAOnboarding extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateDSAOnboarding() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterButton();
		loginPage.clickDSA();

		BusinessPartnerRegistrationPage businessPartnerRegistrationPage = new BusinessPartnerRegistrationPage(driver);
		businessPartnerRegistrationPage.validateHeading("Business Partner Registration");
		businessPartnerRegistrationPage.selectTitle("Mr");
		businessPartnerRegistrationPage.enterFirstName("Rishav");
		businessPartnerRegistrationPage.enterLastName("Shrivastava");
		String individualEmailId = "rishav.s+dsa" + Generics.generateTimeStamp() + "@perfios.com";
		businessPartnerRegistrationPage.enterEmailAddress(individualEmailId);
		businessPartnerRegistrationPage.enterPassword(individualEmailId);
		businessPartnerRegistrationPage.enterConfirmPassword(individualEmailId);
		String phoneNumber = "22" + Generics.getRandomNumber(8);
		businessPartnerRegistrationPage.enterPhoneNumber(phoneNumber);
		businessPartnerRegistrationPage.selectGeneder("Male");
		// Identity enterIdentityNumberOne and two
		String identityNumberOne = "10" + Generics.getRandomNumber(10);
		String identityNumberTwo = "DSABD" + Generics.getRandomNumber(4) + "D";
		businessPartnerRegistrationPage.enterIdentityNumberOne(identityNumberOne);
		businessPartnerRegistrationPage.enterIdentityNumberTwo(identityNumberTwo);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 10, 1, identityNumberOne);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 11, 1, identityNumberTwo);

		businessPartnerRegistrationPage.selectDateOfBirth("1994", "Nov", "12");
		businessPartnerRegistrationPage.enterDSAProfileTextVariable1("Testing");
		businessPartnerRegistrationPage.selectDSAProfileDateVariable1("1994", "Nov", "12");
		businessPartnerRegistrationPage.enterPersonalAddress("Line1", "Line2", "Line3", "Sub District Per",
				"District Per", "Haryana", "Gurgoan", "India A", "213190", "2007", "Nov", "14", "Staff Residence",
				"Address Two");
		businessPartnerRegistrationPage.enterAddressOne("Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2005", "Sep", "3", "Double story house", "Address Three");
		businessPartnerRegistrationPage.clickRegister();

		EmployerCompanyRegistrationPage employerCompanyRegistrationPage = new EmployerCompanyRegistrationPage(driver);
		employerCompanyRegistrationPage.validateHeading("Employer Company Registration");
		employerCompanyRegistrationPage.enterCompanyName("Perfios");
		employerCompanyRegistrationPage.enterRegistrationCode("Test3892");
		// Identity enterIdentityNumberOne and two
		String companyIdentityNumberOne = "10" + Generics.getRandomNumber(10);
		String companyIdentityNumberTwo = "DSACD" + Generics.getRandomNumber(4) + "D";
		employerCompanyRegistrationPage.enterCompanyIdentityNumberOne(companyIdentityNumberOne);
		employerCompanyRegistrationPage.enterCompanyIdentityNumberTwo(companyIdentityNumberTwo);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 12, 1, companyIdentityNumberOne);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 13, 1, companyIdentityNumberTwo);
		//
		employerCompanyRegistrationPage.enterDSACompanyTextVariable1("Testing");
		employerCompanyRegistrationPage.selectDSACompanyDateVariable1("1994", "Nov", "12");
		employerCompanyRegistrationPage.enterAddress("Line123", "Line234", "Line345", "Sub District Emp",
				"District emp", "Uttar Pradesh", "Kanpur", "India", "785452", "2004", "Jul", "18", "Double story house",
				"Company Address One");

		employerCompanyRegistrationPage.clickRegister();

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.validateHeading("Bank Details");
		bankDetailsPage.enterAccountHolderName("Rishav");
		bankDetailsPage.enterAccountNumber("5684521256");
		bankDetailsPage.enterBankName("SBI");
		bankDetailsPage.enterBankAddress("Testing");
		bankDetailsPage.enterIFSC("SBIN999");
		bankDetailsPage.enterDateOfOpeningAccount("1", "Mar", "2001");
		bankDetailsPage.enterMICRCode("Test");
		bankDetailsPage.enterAccountType("Savings");
		bankDetailsPage.enterBranchName("MICO");
		bankDetailsPage.enterSwiftCode("Test");
		bankDetailsPage.enterBranchPinCode("452563");
		bankDetailsPage.enterBranchCity("Bangalore");
		bankDetailsPage.enterNatureOfFacility("Online");
		bankDetailsPage.enterBankDetailsTextVariable1TextBox("Testing");
		bankDetailsPage.enterBankDetailsTextVariable2TextBox("Testing");
		bankDetailsPage.enterBankDetailsTextVariable3TextBox("Testing");
		bankDetailsPage.enterBankDetailsTextVariable4TextBox("Testing");
		bankDetailsPage.enterBankDetailsTextVariable5TextBox("Testing");
		bankDetailsPage.enterBankDetailsTextVariable6TextBox("Testing");
		bankDetailsPage.enterBankDetailsTextVariable7TextBox("Testing");
		bankDetailsPage.enterBankDetailsTextVariable8TextBox("Testing");
		bankDetailsPage.enterBankDetailsTextVariable9TextBox("Testing");
		bankDetailsPage.enterBankDetailsTextVariable10TextBox("Testing");

		bankDetailsPage.clickSubmit();

		DSAQuestionGroup1Page dSAQuestionGroup1Page = new DSAQuestionGroup1Page(driver);
		dSAQuestionGroup1Page.validateHeading("DSA Question Group 1");
		dSAQuestionGroup1Page.enterDownpayment("50000");
		dSAQuestionGroup1Page.selectBorrowerNationality("Indian");
		dSAQuestionGroup1Page.clickSubmit();

		SupportingDocumentsPage supportingDocumentsPage = new SupportingDocumentsPage(driver);
		supportingDocumentsPage.validateSupportingDocumentsHeading("Supporting Documents");
		supportingDocumentsPage.uploadDocument("Adhar Card", text_upload_file_path);
		Generics.waitForFewSecondstoLoad(1000);
		Generics.refreshPage(driver);

		// multiple upload
		Generics.waitForFewSecondstoLoad(1000);
		supportingDocumentsPage.uploadMoreDocument("Adhar Card", png_upload_file_path);
		Generics.waitForFewSecondstoLoad(5000);
		Generics.refreshPage(driver);

		// delete one document and validate

		supportingDocumentsPage.validateUploadedDocument("Adhar Card", 2);
		Generics.refreshPage(driver);
		supportingDocumentsPage.deleteUploadedDocument("Adhar Card", 1);
		Generics.refreshPage(driver);
		supportingDocumentsPage.validateUploadedDocument("Adhar Card", 1);
		Generics.refreshPage(driver);

		// t&c
		supportingDocumentsPage.checkTermsAndConditions();
		supportingDocumentsPage.clickSubmit();

		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 1, 1, individualEmailId);

		DashboardPage dashboardPage = new DashboardPage(driver);
		String DSAName = dashboardPage.getDSAName();
		String[] splittedDsaName = DSAName.split("\\n");
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 2, 1, splittedDsaName[0]);
		String DSAId = dashboardPage.getDSAId();
		String[] splittedDsaId = DSAId.split("\\n");
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 3, 1, splittedDsaId[1]);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 4, 1, phoneNumber);
	}
}