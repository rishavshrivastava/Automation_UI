package com.automationsaas.test.borrower.borroweronboarding;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borroweronboarding.ApplyForLoanPage;
import com.automationsaas.pom.borroweronboarding.BankDetailsPage;
import com.automationsaas.pom.borroweronboarding.BorrowerQuestionGroup1Page;
import com.automationsaas.pom.borroweronboarding.BorrowerRegistrationPage;
import com.automationsaas.pom.borroweronboarding.Co_ApplicantDetailsPage;
import com.automationsaas.pom.borroweronboarding.CompanyDetailsPage;
import com.automationsaas.pom.borroweronboarding.CompanyRepresentativePage;
import com.automationsaas.pom.borroweronboarding.FamilyMemberDetailsPage;
import com.automationsaas.pom.borroweronboarding.InsuranceDetailsPage;
import com.automationsaas.pom.borroweronboarding.OtherLoanDetailsPage;
import com.automationsaas.pom.borroweronboarding.ReferenceDetailsPage;
import com.automationsaas.pom.borroweronboarding.SupportingDocumentsPage;
import com.automationsaas.pom.borroweronboarding.VehicleDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_BorrowerOnboarding_CompanyBorrowerOnboarding extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateCompanyBorrowerOnboarding() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterButton();
		loginPage.clickBorrower();

		BorrowerRegistrationPage borrowerRegistrationPage = new BorrowerRegistrationPage(driver);
		borrowerRegistrationPage.validateBorrowerRegistrationHeading("Borrower Registration");
		borrowerRegistrationPage.selectTitle("Mr");
		borrowerRegistrationPage.enterFirstName("Rishav");
		borrowerRegistrationPage.enterLastName("Shrivastava");
		String companyEmailId = "rishav.s+companyborrower" + Generics.generateTimeStamp() + "@perfios.com";
		borrowerRegistrationPage.enterEmailAddress(companyEmailId);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 10, 1, companyEmailId);
		borrowerRegistrationPage.checkAvailabilityOfEmailAddress();
		borrowerRegistrationPage.enterPassword(companyEmailId);
		borrowerRegistrationPage.enterConfirmPassword(companyEmailId);
		borrowerRegistrationPage.selectGender("Male");
		borrowerRegistrationPage.selectMaritialStatus("Unmarried");
		String mobileNumber = Generics.getRandomNumber(10);
		borrowerRegistrationPage.enterMobileNumber(mobileNumber);
		borrowerRegistrationPage.checkAvailabilityOfMobileNumber();
		String landlineNumber = Generics.getRandomNumber(10);
		borrowerRegistrationPage.enterLandlineNumber(landlineNumber);
		borrowerRegistrationPage.checkAvailabilityOfLandlineNumber();
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 13, 1, mobileNumber);
		borrowerRegistrationPage.selectDateOfBirth("1994", "Mar", "2");
		String identityNumberOne = Generics.getRandomNumber(10);
		String identityNumberTwo = Generics.getRandomAlphaString(5) + Generics.getRandomNumber(4)
				+ Generics.getRandomAlphaString(1);
		borrowerRegistrationPage.enterIdentityNumberOne("12" + identityNumberOne);
		borrowerRegistrationPage.enterIdentityNumberTwo(identityNumberTwo);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 14, 1, "12" + identityNumberOne);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 15, 1, identityNumberTwo);
		borrowerRegistrationPage.enterIdentityNumberThree("4525485");
		borrowerRegistrationPage.enterIdentityNumberFour("45254785");
		borrowerRegistrationPage.enterIdentityNumberFive("54521452");
		borrowerRegistrationPage.enterIdentityNumberSix("54582785");
		borrowerRegistrationPage.enterReferalCode("838XYZ");
		borrowerRegistrationPage.enterBorrowerCategory("Individual");
		borrowerRegistrationPage.enterFatherFullName("Testing");
		borrowerRegistrationPage.enterFatherFirstName("Testing1");
		borrowerRegistrationPage.enterFatherMiddleName("Testing2");
		borrowerRegistrationPage.enterFatherLastName("Testing3");
		borrowerRegistrationPage.enterMotherFullName("Testing");
		borrowerRegistrationPage.enterMotherFirstName("Testing1");
		borrowerRegistrationPage.enterMotherMiddleName("Testing2");
		borrowerRegistrationPage.enterMotherLastName("Testing3");
		borrowerRegistrationPage.enterNumberOfDependents("2");
		borrowerRegistrationPage.enterPromotionCode("Testing");
		borrowerRegistrationPage.enterWorkExperience("5");
		borrowerRegistrationPage.selectTypeAsIndividualOrCompany("Company");
		borrowerRegistrationPage.enterPersonalAddress("Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2005", "Sep", "3", "Double story house", "Address Three");
		borrowerRegistrationPage.enterAddressOne("Line1", "Line2", "Line3", "Sub District", "District", "Karnataka",
				"City", "Country", "785452", "2005", "Sep", "3", "Staff Residence", "Address Three");
		borrowerRegistrationPage.enterAddressTwo("Line1", "Line2", "Line3", "Sub District", "District", "Karnataka",
				"City", "Country", "785452", "2005", "Sep", "3", "Single Story House", "Address Three");
		borrowerRegistrationPage.selectBorrowerProfileTextVariable1("Test_1");
		borrowerRegistrationPage.selectBorrowerProfileTextVariable2("Test_4");
		borrowerRegistrationPage.enterBorrowerProfileTextVariable3("Testing");
		borrowerRegistrationPage.clickApplyNow();

		ApplyForLoanPage applyForLoanPage = new ApplyForLoanPage(driver);
		applyForLoanPage.clickContinueWithoutValidation();
		applyForLoanPage.validateApplyForLoanHeading("Apply for Loan");
		applyForLoanPage.selectLoanProduct("Personal Loan");
		applyForLoanPage.enterLoanAmount("200000");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		applyForLoanPage.selectInterest("9 %");
		applyForLoanPage.selectLoanRepaymentType("Even Repayments");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		applyForLoanPage.selectTenure("1 Year");
		Generics.scrollPage(driver, 1000);

		// applyForLoanPage.clickGetDetails();
		applyForLoanPage.clickApplyForLoan();

		CompanyDetailsPage companyDetailsPage = new CompanyDetailsPage(driver);
		companyDetailsPage.validateCompanyDetailsHeading("Company Details");
		companyDetailsPage.enterCompanyName("Perfios");
		companyDetailsPage.enterCompanyRegistrationNumber("300302");
		companyDetailsPage.enterCompanyTurnOver("56");
		companyDetailsPage.selectDateOfArticles("2016", "Mar", "23");
		companyDetailsPage.enterAddress("Line1", "Line2", "Line3", "Karnataka", "Bangalore", "560090");
		companyDetailsPage.clickContinue();

		CompanyRepresentativePage companyRepresentativePage = new CompanyRepresentativePage(driver);
		companyRepresentativePage.validateCompanyRepresentativeHeading("Add Company Representative");

		companyRepresentativePage.clickCreateShareHolder();
		companyRepresentativePage.enterShareHolderFirstName("Tester");
		companyRepresentativePage.enterShareHolderLastName("AAA");
		companyRepresentativePage.enterShareHolderEmail("divya.s@perfios.com");
		companyRepresentativePage.enterShareHolderMobileNumber("9876543211");
		companyRepresentativePage.enterShareHolderDob("1992", "Aug", "9");
		companyRepresentativePage.enterShareHolderCitizenship("Indians");
		companyRepresentativePage.enterShareHolderIdentityNumberOne("273528359899");
		companyRepresentativePage.enterShareHolderIdentityNumberTwo("TYPER1236Q");
		companyRepresentativePage.enterShareHolderDateOfAppointment("2016", "Mar", "23");
		companyRepresentativePage.enterShareHolderAddressOne("SHLine1", "SHLine2", "SHLine3", "SHSubDistrict",
				"SHDistrict", "Karnataka", "SHCity", "SHCountry", "125098", "2007", "Feb", "22", "Staff Residence",
				"Address Two");
		companyRepresentativePage.clickAddShareHolderContinue();

//		SupportingDocumentsPage supportingDocumentsPage = new SupportingDocumentsPage(driver);
//		supportingDocumentsPage.clickCompanyRepDocumentModalClose();

		Generics.refreshPage(driver);

		companyRepresentativePage.clickShareHolderAccordion();
		companyRepresentativePage.clickShareHolderEdit();

		companyRepresentativePage.validateShareHolderDetails("Tester", "AAA", "divya.s@perfios.com", "9876543211",
				"09/08/1992", "Indians", "273528359899", "TYPER1236Q", "23/03/2016", "SHLine1", "SHLine2", "SHLine3",
				"SHSubDistrict", "SHDistrict", "Karnataka", "SHCity", "SHCountry", "125098", "22/02/2007",
				"Staff Residence", "Address Two");

		companyRepresentativePage.enterShareHolderFirstName("Tester edit");
		companyRepresentativePage.enterShareHolderLastName("AAA edit");
		companyRepresentativePage.enterShareHolderEmail("divya.s+edit@perfios.com");
		companyRepresentativePage.enterShareHolderMobileNumber("9876543071");
		companyRepresentativePage.enterShareHolderDob("1994", "Mar", "19");
		companyRepresentativePage.enterShareHolderCitizenship("Indians edit");
		companyRepresentativePage.enterShareHolderIdentityNumberOne("276528359899");
		companyRepresentativePage.enterShareHolderIdentityNumberTwo("TYPER1236D");
		companyRepresentativePage.enterShareHolderDateOfAppointment("2019", "Jan", "30");
		companyRepresentativePage.enterShareHolderAddressOne("SHLine1 edit", "SHLine2 edit", "SHLine3 edit",
				"SHSubDistrict edit", "SHDistrict edit", "Haryana", "SHCity edit", "SHCountry edit", "125198", "2008",
				"Apr", "12", "Double story house", "Address One");
		companyRepresentativePage.clickEditShareHolderContinueButton();

		Generics.refreshPage(driver);
		companyRepresentativePage.clickShareHolderAccordion();
		companyRepresentativePage.clickShareHolderEdit();

		// Divya: update the below method once this issue is fixed: 16871)
		companyRepresentativePage.validateShareHolderDetails("Tester edit", "AAA edit", "divya.s+edit@perfios.com",
				"9876543071", "19/03/1994", "Indians edit", "276528359899", "TYPER1236D", "30/01/2019", "SHLine1 edit",
				"SHLine2 edit", "SHLine3 edit", "SHSubDistrict", "SHDistrict", "Haryana", "SHCity edit", "SHCountry",
				"125198", "12/04/2008", "Double story house", "Address One");
		companyRepresentativePage.clickShareHolderModalClose();

		companyRepresentativePage.clickShareHolderDelete();
		Generics.refreshPage(driver);
		companyRepresentativePage.clickShareHolderAccordion();

		companyRepresentativePage.clickCreateShareHolder();
		companyRepresentativePage.enterShareHolderFirstName("Tester");
		companyRepresentativePage.enterShareHolderLastName("AAA");
		companyRepresentativePage.enterShareHolderEmail("divya.s@perfios.com");
		companyRepresentativePage.enterShareHolderMobileNumber("9876543211");
		companyRepresentativePage.enterShareHolderDob("1992", "Aug", "9");
		companyRepresentativePage.enterShareHolderCitizenship("Indians");
		companyRepresentativePage.enterShareHolderIdentityNumberOne("273528359899");
		companyRepresentativePage.enterShareHolderIdentityNumberTwo("TYPER1236Q");
		companyRepresentativePage.enterShareHolderDateOfAppointment("2016", "Mar", "23");
		companyRepresentativePage.enterShareHolderAddressOne("SHLine1", "SHLine2", "SHLine3", "SHSubDistrict",
				"SHDistrict", "Karnataka", "SHCity", "SHCountry", "125098", "2007", "Feb", "22", "Staff Residence",
				"Address Two");
		companyRepresentativePage.clickAddShareHolderContinue();

		companyRepresentativePage.clickContinue();

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.validateBankDetailsHeading("Bank Details");
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

		Co_ApplicantDetailsPage co_ApplicantDetailsPage = new Co_ApplicantDetailsPage(driver);
		co_ApplicantDetailsPage.validateCo_ApplicantDetailsHeading("Co-Applicant Details");
		co_ApplicantDetailsPage.enterFirstName("Rishav");
		co_ApplicantDetailsPage.enterLastName("Shrivastava");
		co_ApplicantDetailsPage.enterEmailId("rishav.s@perfios.com");
		co_ApplicantDetailsPage.enterAdharCardNumber("414525415412");
		co_ApplicantDetailsPage.enterPanCardNumber("FGTRA7678Z");
		co_ApplicantDetailsPage.enterIdentityNumberThree("Testing");
		co_ApplicantDetailsPage.enterIdentityNumberFour("Testing");
		co_ApplicantDetailsPage.enterIdentityNumberFive("Testing");
		co_ApplicantDetailsPage.enterIdentityNumberSix("Testing");

		co_ApplicantDetailsPage.enterCompanyName("Perfios");
		co_ApplicantDetailsPage.enterDepartmentName("Testing");
		co_ApplicantDetailsPage.enterDesignation("Testing");
		co_ApplicantDetailsPage.enterEmail("rishav.s@perfios.com");
		co_ApplicantDetailsPage.enterMobileNumber("4145214521");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable1("Testing");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable2("Testing");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable3("Testing");
		co_ApplicantDetailsPage.enterAddress("Line1", "Line2", "Line3", "Bengaluru", "Bangalore", "Karnataka",
				"Bangalore", "India", "560090", "13", "Mar", "2006", "Double story house", "Address");

		co_ApplicantDetailsPage.clickAddMore();
		Generics.scrollPage(driver, -1500);
		co_ApplicantDetailsPage.validateCoAppplicantDetails("Rishav Shrivastava", "rishav.s@perfios.com",
				"414525415412", "FGTRA7678Z", "Testing", "Testing", "Testing", "Testing", "Perfios", "Testing",
				"Line1, Line2, Line3, Bangalore, Karnataka, 560090, Karnataka, Bangalore, Bengaluru", "+914145214521",
				"rishav.s@perfios.com", "Testing", "Testing", "Testing", "Testing", "");

		co_ApplicantDetailsPage.clickEdit();
		try { // temporary code
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		co_ApplicantDetailsPage.editCoApplicantDetails("test", "test", "rishav.s@perfios.com", "test", "test");
		Generics.scrollPage(driver, -1500);

		co_ApplicantDetailsPage.validateCoAppplicantDetails("test test", "rishav.s@perfios.com", "414525415412",
				"FGTRA7678Z", "Testing", "Testing", "Testing", "Testing", "test", "Testing",
				"Line1, Line2, Line3, Bangalore, Karnataka, 560090, Karnataka, Bangalore, Bengaluru", "+914145214521",
				"rishav.s@perfios.com", "Testing", "test", "Testing", "Testing", "");
		co_ApplicantDetailsPage.clickDelete();
		Generics.refreshPage(driver);
		co_ApplicantDetailsPage.enterFirstName("Rishav");
		co_ApplicantDetailsPage.enterLastName("Shrivastava");
		co_ApplicantDetailsPage.enterEmailId("rishav.s@perfios.com");
		co_ApplicantDetailsPage.enterAdharCardNumber("414525415412");
		co_ApplicantDetailsPage.enterPanCardNumber("FGTRA7678Z");
		co_ApplicantDetailsPage.enterIdentityNumberThree("Testing");
		co_ApplicantDetailsPage.enterIdentityNumberFour("Testing");
		co_ApplicantDetailsPage.enterIdentityNumberFive("Testing");
		co_ApplicantDetailsPage.enterIdentityNumberSix("Testing");

		co_ApplicantDetailsPage.enterCompanyName("Perfios");
		co_ApplicantDetailsPage.enterDepartmentName("Testing");
		co_ApplicantDetailsPage.enterDesignation("Testing");
		co_ApplicantDetailsPage.enterEmail("rishav.s@perfios.com");
		co_ApplicantDetailsPage.enterMobileNumber("4145214521");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable1("Testing");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable2("Testing");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable3("Testing");
		co_ApplicantDetailsPage.enterAddress("Line1", "Line2", "Line3", "Bengaluru", "Bangalore", "Karnataka",
				"Bangalore", "India", "560090", "13", "Mar", "2006", "Double story house", "Address");
		co_ApplicantDetailsPage.clickAddAndContinue();

		ReferenceDetailsPage referenceDetailsPage = new ReferenceDetailsPage(driver);
		referenceDetailsPage.validateReferenceDetailsHeading("Reference Details");
		referenceDetailsPage.enterFirstName("Rishav");
		referenceDetailsPage.enterLastName("Shrivastava");
		referenceDetailsPage.enterEmailAddress("rishav.s@perfios.com");
		referenceDetailsPage.enterMobileNumber("8524563524");
		referenceDetailsPage.enterRelationshipStatus("Single");
		referenceDetailsPage.clickAddMore();
		Generics.scrollPage(driver, -1200);
		referenceDetailsPage.validateReferenceDetails("Rishav  Shrivastava", "rishav.s@perfios.com", "+918524563524",
				"Single");
		referenceDetailsPage.clickEdit();
		referenceDetailsPage.editReferenceDetails("rishav", "Shrivastava", "rishav.s@perfios.com", "8524563524",
				"Single");
		referenceDetailsPage.clickDelete();
		referenceDetailsPage.enterFirstName("Rishav");
		referenceDetailsPage.enterLastName("Shrivastava");
		referenceDetailsPage.enterEmailAddress("rishav.s@perfios.com");
		referenceDetailsPage.enterMobileNumber("8524563524");
		referenceDetailsPage.enterRelationshipStatus("Single");
		referenceDetailsPage.clickAddAndContinue();

		OtherLoanDetailsPage otherLoanDetailsPage = new OtherLoanDetailsPage(driver);
		otherLoanDetailsPage.validateOtherLoanDetailsHeading("Other Loan Details");
		otherLoanDetailsPage.enterLoanPurpose("Testing");
		otherLoanDetailsPage.enterLoanAmount("50000");
		otherLoanDetailsPage.enterRepaymentAmount("60000");
		otherLoanDetailsPage.enterPrincipalOutstanding("50000");
		otherLoanDetailsPage.enterBankName("SBI");
		otherLoanDetailsPage.enterBankAccountNumber("4521452563");
		otherLoanDetailsPage.enterStartDate("2", "Feb", "1992");
		otherLoanDetailsPage.enterEndDate("2", "Nov", "2002");
		otherLoanDetailsPage.enterRemainingTenure("5");
		otherLoanDetailsPage.enterLoanType("PL");
		otherLoanDetailsPage.enterLoanExtraTextVariable("Test");
		otherLoanDetailsPage.enterLoanExtraTextVariable2("Testing");
		otherLoanDetailsPage.clickAddMore();
		Generics.scrollPage(driver, -1000);
		otherLoanDetailsPage.validateSavedOtherLoanDetails("Testing", "50000", "60000", "50000", "SBI", "4521452563",
				"02/02/1992", "02/11/2002", "5", "PL", "Test", "Testing");

		otherLoanDetailsPage.clickEdit();
		otherLoanDetailsPage.editOtherLoanDetails("Testing", "70000", "80000", "7000", "SBI", "4521452512", "1998",
				"Feb", "2", "2003", "Nov", "2", "3", "Car", "Test", "Testing");

		Generics.scrollPage(driver, -1000);
		otherLoanDetailsPage.validateSavedOtherLoanDetails("Testing", "70000", "80000", "7000", "SBI", "4521452512",
				"02/02/1998", "02/11/2003", "3", "Car", "Test", "Testing");

		otherLoanDetailsPage.clickDelete();
		otherLoanDetailsPage.enterLoanPurpose("Testing");
		otherLoanDetailsPage.enterLoanAmount("50000");
		otherLoanDetailsPage.enterRepaymentAmount("60000");
		otherLoanDetailsPage.enterPrincipalOutstanding("50000");
		otherLoanDetailsPage.enterBankName("SBI");
		otherLoanDetailsPage.enterBankAccountNumber("4521452563");
		otherLoanDetailsPage.enterStartDate("2", "Feb", "1992");
		otherLoanDetailsPage.enterEndDate("2", "Nov", "2002");
		otherLoanDetailsPage.enterRemainingTenure("5");
		otherLoanDetailsPage.enterLoanType("PL");
		otherLoanDetailsPage.enterLoanExtraTextVariable("Test");
		otherLoanDetailsPage.enterLoanExtraTextVariable2("Testing");
		otherLoanDetailsPage.clickAddAndContinue();

		VehicleDetailsPage vehicleDetailsPage = new VehicleDetailsPage(driver);
		vehicleDetailsPage.validateVehicleDetailsHeading("Vehicle Details");
		vehicleDetailsPage.enterBrandName("RE");
		vehicleDetailsPage.enterLicenseNumber("DL9299");
		vehicleDetailsPage.enterPurchaseDate("2018", "Oct", "26");
		vehicleDetailsPage.enterVehicleOwnedExtraTextVariable1("Testing");
		vehicleDetailsPage.enterVehicleOwnedExtraTextVariable2("Testing");
		vehicleDetailsPage.selectVehicleOwnedExtraDateVariable1("2018", "Oct", "26");
		vehicleDetailsPage.selectVehicleOwnedExtraDateVariable2("2019", "Oct", "21");
		vehicleDetailsPage.clickAddMore();
		vehicleDetailsPage.validateSavedVehicleDetails("RE", "DL9299", "26/10/2018", "Testing", "Testing", "26/10/2018",
				"21/10/2019");
		vehicleDetailsPage.clickEdit();
		vehicleDetailsPage.editVehicleDetails("RE350", "DL9299", "2019", "Oct", "21", "Testing", "Testing", "2018",
				"Oct", "26", "2019", "Oct", "21");
		vehicleDetailsPage.validateSavedVehicleDetails("RE350", "DL9299", "21/10/2019", "Testing", "Testing",
				"26/10/2018", "21/10/2019");

		vehicleDetailsPage.clickDelete();
		vehicleDetailsPage.enterBrandName("RE");
		vehicleDetailsPage.enterLicenseNumber("DL9299");
		vehicleDetailsPage.enterPurchaseDate("2018", "Oct", "26");
		vehicleDetailsPage.enterVehicleOwnedExtraTextVariable1("Testing");
		vehicleDetailsPage.enterVehicleOwnedExtraTextVariable2("Testing");
		vehicleDetailsPage.selectVehicleOwnedExtraDateVariable1("2018", "Oct", "26");
		vehicleDetailsPage.selectVehicleOwnedExtraDateVariable2("2019", "Oct", "21");
		vehicleDetailsPage.clickAddAndContinue();

		FamilyMemberDetailsPage familyMemberDetailsPage = new FamilyMemberDetailsPage(driver);
		familyMemberDetailsPage.validateFamilyMemberDetailsHeading("Family Member Details");
		familyMemberDetailsPage.enterName("Rishav");
		familyMemberDetailsPage.selectDateOfBirth("1998", "Oct", "2");
		familyMemberDetailsPage.enterOccupation("Testing");
		familyMemberDetailsPage.enterNameOfOrganization("Perfios");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable1("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable2("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable3("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable4("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable5("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable6("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable7("Testing");
		familyMemberDetailsPage.clickAddMore();

		Generics.scrollPage(driver, -500);

		ArrayList<String> familyMemberDetailsData = new ArrayList<String>();
		familyMemberDetailsData.add("Rishav");
		familyMemberDetailsData.add("02/10/1998");
		familyMemberDetailsData.add("Testing");
		familyMemberDetailsData.add("Perfios");
		familyMemberDetailsData.add("Testing");
		familyMemberDetailsData.add("Testing");
		familyMemberDetailsData.add("Testing");
		familyMemberDetailsData.add("Testing");
		familyMemberDetailsData.add("Testing");
		familyMemberDetailsData.add("Testing");
		familyMemberDetailsData.add("Testing");

		for (int i = 0; i < familyMemberDetailsData.size(); i++) {
			familyMemberDetailsPage.validateFamilyMemberDetails(i, familyMemberDetailsData.get(i));
		}

		// Edit scenarios are pending

		familyMemberDetailsPage.clickDelete();
		Generics.refreshPage(driver);

		familyMemberDetailsPage.validateFamilyMemberDetailsHeading("Family Member Details");
		familyMemberDetailsPage.enterName("Rishav");
		familyMemberDetailsPage.selectDateOfBirth("1998", "Oct", "2");
		familyMemberDetailsPage.enterOccupation("Testing");
		familyMemberDetailsPage.enterNameOfOrganization("Perfios");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable1("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable2("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable3("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable4("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable5("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable6("Testing");
		familyMemberDetailsPage.enterFamilyMemberExtraTextVariable7("Testing");
		familyMemberDetailsPage.clickAddAndContinue();

		InsuranceDetailsPage insuranceDetailsPage = new InsuranceDetailsPage(driver);
		insuranceDetailsPage.validateInsuranceDetailsHeading("Insurance Details");
		insuranceDetailsPage.enterInsurerName("Tata");
		insuranceDetailsPage.enterAmount("50000");
		insuranceDetailsPage.enterStartDate("1998", "Oct", "3");
		insuranceDetailsPage.enterEndDate("2001", "Oct", "3");
		insuranceDetailsPage.selectTypeOfInsurance("Bank");
		insuranceDetailsPage.enterInsuranceTextVariable1("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable2("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable4("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable5("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable6("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable7("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable8("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable9("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable10("Testing");

		insuranceDetailsPage.clickAddMore();
		Generics.scrollPage(driver, -1000);
		insuranceDetailsPage.validateSavedInsuranceDetails("Tata", "50000", "03/10/1998", "03/10/2001", "Bank",
				"Testing", "Testing", "Testing", "Testing", "Testing", "Testing", "Testing", "Testing", "Testing");

		insuranceDetailsPage.clickEdit();
		insuranceDetailsPage.editInsuranceDetails("Bajaj", "40000", "1999", "Oct", "4", "2002", "Oct", "3", "Credit",
				"Testing1", "Testing2", "Testing4", "Testing5", "Testing6", "Testing7", "Testing8", "Testing9",
				"Testing10");

		Generics.scrollPage(driver, -1000);
		insuranceDetailsPage.validateSavedInsuranceDetails("Bajaj", "40000", "04/10/1999", "03/10/2002", "Credit",
				"Testing1", "Testing2", "Testing4", "Testing5", "Testing6", "Testing7", "Testing8", "Testing9",
				"Testing10");

		insuranceDetailsPage.clickDelete();

		insuranceDetailsPage.enterInsurerName("Tata");
		insuranceDetailsPage.enterAmount("50000");
		insuranceDetailsPage.enterStartDate("1998", "Oct", "3");
		insuranceDetailsPage.enterEndDate("2001", "Oct", "3");
		insuranceDetailsPage.selectTypeOfInsurance("Bank");
		insuranceDetailsPage.enterInsuranceTextVariable1("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable2("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable4("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable5("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable6("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable7("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable8("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable9("Testing");
		insuranceDetailsPage.enterInsuranceTextVariable10("Testing");
		insuranceDetailsPage.clickAddAndContinue();

		BorrowerQuestionGroup1Page borrowerQuestionGroup1Page = new BorrowerQuestionGroup1Page(driver);
		borrowerQuestionGroup1Page.validateBorrowerQuestionGroup1Heading("Borrower Question Group 1");
		borrowerQuestionGroup1Page.selectBorrowerNationality("Indian");
		borrowerQuestionGroup1Page.enterDownPayment("50000");
		borrowerQuestionGroup1Page.clickSubmit();

		SupportingDocumentsPage supportingDocumentsPage = new SupportingDocumentsPage(driver);

		supportingDocumentsPage.validateSupportingDocumentsHeading("Supporting Documents");
		supportingDocumentsPage.uploadDocument("Adhar Card", png_upload_file_path);
		supportingDocumentsPage.uploadDocument("Pan Card", pdf_upload_file_path);
		supportingDocumentsPage.uploadDocument("Address Proof", jpg_upload_file_path);
		supportingDocumentsPage.uploadDocument("Bank Statement", text_upload_file_path);
		supportingDocumentsPage.uploadCoApplicantDocument("Adhar Card", png_upload_file_path);
		supportingDocumentsPage.checkTermsAndConditions();
		supportingDocumentsPage.clickSubmit();
		supportingDocumentsPage.clickContinueToProfile();

		DashboardPage borrowerDashboardPage = new DashboardPage(driver);
		String borrowerId = borrowerDashboardPage.getBorrowerId();
		String[] splittedBorrowerId = borrowerId.split("\\n");
		System.out.println(splittedBorrowerId[1]);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 11, 1, splittedBorrowerId[1]);
		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		String loanId = borrowerDashboardPage.getLoanId();
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 12, 1, loanId);
		borrowerDashboardPage.validateLoanStatus("Initialized");

		ArrayList<String> loanDetails = new ArrayList<String>();
		loanDetails.add("Personal Loan");
		loanDetails.add(loanId);
		loanDetails.add("Mr Rishav Shrivastava");
		loanDetails.add("N/A");
		loanDetails.add("Rs209,884");
		loanDetails.add(splittedBorrowerId[1]);
		loanDetails.add("Rs200,000");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add("Rs0");
		String currentDate = Generics.getCurrentDate();
		loanDetails.add(currentDate);
		loanDetails.add("12 Months");
		loanDetails.add("9.00%");
		loanDetails.add("N/A");
		for (int i = 0; i < loanDetails.size(); i++) {
			borrowerDashboardPage.validateLoanDetails(i, loanDetails.get(i));
		}

		borrowerDashboardPage.clickLoanDetailsButton();
	}
}
