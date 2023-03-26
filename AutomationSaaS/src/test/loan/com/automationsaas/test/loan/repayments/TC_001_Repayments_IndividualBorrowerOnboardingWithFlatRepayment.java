package com.automationsaas.test.loan.repayments;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borroweronboarding.ApplyForLoanPage;
import com.automationsaas.pom.borroweronboarding.BankDetailsPage;
import com.automationsaas.pom.borroweronboarding.BorrowerQuestionGroup1Page;
import com.automationsaas.pom.borroweronboarding.BorrowerRegistrationPage;
import com.automationsaas.pom.borroweronboarding.Co_ApplicantDetailsPage;
import com.automationsaas.pom.borroweronboarding.DetailsPage;
import com.automationsaas.pom.borroweronboarding.EmploymentDetailsPage;
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

public class TC_001_Repayments_IndividualBorrowerOnboardingWithFlatRepayment extends Base {

	@Test
	(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void validateIndividualBorrowerOnboarding() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterButton();
		loginPage.clickBorrower();

		BorrowerRegistrationPage borrowerRegistrationPage = new BorrowerRegistrationPage(driver);
		borrowerRegistrationPage.validateBorrowerRegistrationHeading("Borrower Registration");
		borrowerRegistrationPage.selectTitle("Mr");
		borrowerRegistrationPage.enterFirstName("Rishav");
		borrowerRegistrationPage.enterLastName("Shrivastava");
		String individualEmailId = "rishav.s+individualborrower" + Generics.generateTimeStamp() + "@perfios.com";
		borrowerRegistrationPage.enterEmailAddress(individualEmailId);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 1, 2, individualEmailId);
		borrowerRegistrationPage.checkAvailabilityOfEmailAddress();
		borrowerRegistrationPage.enterPassword(individualEmailId);
		borrowerRegistrationPage.enterConfirmPassword(individualEmailId);
		borrowerRegistrationPage.selectGender("Male");
		borrowerRegistrationPage.selectMaritialStatus("Unmarried");
		String mobileNumber = Generics.getRandomNumber(10);
		borrowerRegistrationPage.enterMobileNumber(mobileNumber);
		borrowerRegistrationPage.checkAvailabilityOfMobileNumber();
		String landlineNumber = Generics.getRandomNumber(10);
		borrowerRegistrationPage.enterLandlineNumber(landlineNumber);
		borrowerRegistrationPage.checkAvailabilityOfLandlineNumber();
		
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 4, 1, mobileNumber);
		borrowerRegistrationPage.selectDateOfBirth("1994", "Mar", "2");
		//Divya
		String identityNumberOne = Generics.getRandomNumber(10);
		String identityNumberTwo = Generics.getRandomAlphaString(5)+ Generics.getRandomNumber(4)+ Generics.getRandomAlphaString(1) ;
		borrowerRegistrationPage.enterIdentityNumberOne("12"+identityNumberOne);
		borrowerRegistrationPage.enterIdentityNumberTwo(identityNumberTwo);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 5, 1, "12"+identityNumberOne);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 6, 1,identityNumberTwo);
	
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
	
		borrowerRegistrationPage.selectTypeAsIndividualOrCompany("Individual");
		
		borrowerRegistrationPage.enterPersonalAddress("Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Double story house", "Address Three");
		
		borrowerRegistrationPage.enterAddressOne(
				"Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Staff Residence", "Address Three");
		
		borrowerRegistrationPage.enterAddressTwo(
				"Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Single Story House", "Address Three");
		
		borrowerRegistrationPage.selectBorrowerProfileTextVariable1("Test_1");
		borrowerRegistrationPage.selectBorrowerProfileTextVariable2("Test_4");
		borrowerRegistrationPage.enterBorrowerProfileTextVariable3("Testing");
		
		borrowerRegistrationPage.clickApplyNow();

		ApplyForLoanPage applyForLoanPage = new ApplyForLoanPage(driver);
		applyForLoanPage.clickContinueWithoutValidation();
		applyForLoanPage.validateApplyForLoanHeading("Apply for Loan");
		applyForLoanPage.selectLoanProduct("Business");
		applyForLoanPage.enterLoanAmount("200000");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		applyForLoanPage.selectInterest("9 %");
		applyForLoanPage.selectLoanRepaymentType("Flat Repayments");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		applyForLoanPage.selectTenure("1 Year");
		applyForLoanPage.clickApplyForLoan();

		DetailsPage detailsPage = new DetailsPage(driver);
		detailsPage.validateDetailsHeading("Details");
		detailsPage.enterWorkExperience("2 Years");
		detailsPage.selectEmploymentCategory("Permanent");
		detailsPage.enterGrossIncome("50000");
		detailsPage.selectEmployerType("Contractor");
		detailsPage.enterTransportationExpenses("20000");
		detailsPage.enterUtilitiesExpenses("2000");
		detailsPage.enterEntertainmentExpenses("10000");
		detailsPage.enterCreditCardExpenses("0");
		detailsPage.enterNumberOfDependents("1");
		detailsPage.enterIdentityNumberSeven("Test");
		detailsPage.enterIdentityNumberEight("Test");
		detailsPage.selectBorrowerDetailTextVariable1("Text_1");
		detailsPage.selectBorrowerDetailTextVariable2("Text_2");
		detailsPage.enterBorrowerTextVariable5("Testing");
		detailsPage.enterBorrowerTextVariable6("Testing");
		detailsPage.enterBorrowerDetailNumberVariable1("123456");
		detailsPage.enterPersonalAddress("Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Double story house", "Address");
		detailsPage.enterAddressOne("Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Double story house", "Address One");
		detailsPage.enterAddressTwo("Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Double story house", "Address Two");
		detailsPage.enterAddressThree("Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Double story house", "Address Three");
		detailsPage.clickContinueButton();

		EmploymentDetailsPage employmentDetailsPage = new EmploymentDetailsPage(driver);
		employmentDetailsPage.validateEmploymentDetailsHeading("Employment Details");
		employmentDetailsPage.enterOrganisation("Perfios");
		employmentDetailsPage.selectOrganisationType("Organization_1");
		employmentDetailsPage.selectEmploymentType("Contractors");
		employmentDetailsPage.selectDepartment("Technology");
		employmentDetailsPage.selectDesignation("QA");
		employmentDetailsPage.enterAnnualIncome("500000");
		employmentDetailsPage.enterOfficialEmailId("rishav.s@perfios.com");
		employmentDetailsPage.enterOfficeLandline("4578452145");
		employmentDetailsPage.enterEmployeeId("Per785");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable1("Testing");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable2("Testing");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable3("Testing");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable4("Testing");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable5("Testing");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable6("Testing");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable7("Testing");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable8("Testing");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable9("Testing");
		employmentDetailsPage.enterBorrowerEmploymentHistoryTextVariable10("Testing");
		employmentDetailsPage.enterEmploymentHistoryNumberVariable1("123456");
		employmentDetailsPage.enterEmploymentHistoryNumberVariable2("123456");
		employmentDetailsPage.enterEmploymentHistoryNumberVariable3("123456");
		employmentDetailsPage.enterEmploymentHistoryNumberVariable4("123456");
		employmentDetailsPage.enterEmploymentHistoryNumberVariable5("123456");
		employmentDetailsPage.enterBorrowerEmploymentHistoryDateVariable1("1", "Oct", "2022");
		employmentDetailsPage.enterBorrowerEmploymentHistoryDateVariable2("1", "Oct", "2022");
		employmentDetailsPage.enterBorrowerEmploymentHistoryDateVariable3("1", "Oct", "2022");
		employmentDetailsPage.enterBorrowerEmploymentHistoryDateVariable4("1", "Oct", "2022");
		employmentDetailsPage.enterAddress("Line1", "Line2", "Line3", "Bengaluru", "Bangalore", "Karnataka", "Bangalore", "India", "560090",
				"13", "Mar", "2006", "Double story house", "Address");
		employmentDetailsPage.clickContinue();

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
		co_ApplicantDetailsPage.enterAddress("Line1", "Line2", "Line3", "Bengaluru", "Bangalore", "Karnataka", "Bangalore", "India", "560090",
				"13", "Mar", "2006", "Double story house", "Address");
		
		co_ApplicantDetailsPage.clickAddMore();
		Generics.scrollPage(driver, -1000);
		co_ApplicantDetailsPage.validateCoAppplicantDetails("Rishav Shrivastava", "rishav.s@perfios.com", "414525415412", "FGTRA7678Z", "Testing", "Testing",  "Testing", "Testing",
				"Perfios", "Testing", "Line1, Line2, Line3, Bangalore, Karnataka, 560090, Karnataka, Bangalore, Bengaluru", "+914145214521", "rishav.s@perfios.com", "Testing",
				"Testing", "Testing", "Testing", "");
		Generics.scrollPage(driver, -250);
		co_ApplicantDetailsPage.clickEdit();
		try { //temporary code
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		co_ApplicantDetailsPage.editCoApplicantDetails("test", "test", "rishav.s@perfios.com", "test", "test");
		co_ApplicantDetailsPage.validateCoAppplicantDetails("test test", "rishav.s@perfios.com", "414525415412", "FGTRA7678Z", "Testing", "Testing",  "Testing", "Testing",
				"test", "Testing", "Line1, Line2, Line3, Bangalore, Karnataka, 560090, Karnataka, Bangalore, Bengaluru", "+914145214521", "rishav.s@perfios.com", "Testing",
				"test", "Testing", "Testing", "");
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
		co_ApplicantDetailsPage.enterAddress("Line1", "Line2", "Line3", "Bengaluru", "Bangalore", "Karnataka", "Bangalore", "India", "560090",
				"13", "Mar", "2006", "Double story house", "Address");
		co_ApplicantDetailsPage.clickAddAndContinue();

		ReferenceDetailsPage referenceDetailsPage = new ReferenceDetailsPage(driver);
		referenceDetailsPage.validateReferenceDetailsHeading("Reference Details");
		referenceDetailsPage.enterFirstName("Rishav");
		referenceDetailsPage.enterLastName("Shrivastava");
		referenceDetailsPage.enterEmailAddress("rishav.s@perfios.com");
		referenceDetailsPage.enterMobileNumber("8524563524");
		referenceDetailsPage.enterRelationshipStatus("Single");
		referenceDetailsPage.clickAddMore();
		Generics.scrollPage(driver, -1000);
		referenceDetailsPage.validateReferenceDetails("Rishav  Shrivastava", "rishav.s@perfios.com", "+918524563524",
				"Single");
		referenceDetailsPage.clickEdit();
		referenceDetailsPage.editReferenceDetails("rishav", "Shrivastava", "rishav.s@perfios.com", "8524563524", "Single");
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
		otherLoanDetailsPage.validateSavedOtherLoanDetails("Testing", "50000", "60000", "50000" ,"SBI", "4521452563", 
				"02/02/1992", "02/11/2002", "5", "PL", "Test", "Testing");
		Generics.scrollPage(driver, -500);
		otherLoanDetailsPage.clickEdit();
		otherLoanDetailsPage.editOtherLoanDetails("Testing", "70000", "80000", "7000", "SBI", "4521452512",
				"1998","Feb", "2", "2003", "Nov", "2", "3", "Car", "Test" , "Testing");
		otherLoanDetailsPage.validateSavedOtherLoanDetails("Testing", "70000", "80000", "7000" ,"SBI", "4521452512", 
				"02/02/1998", "02/11/2003", "3", "Car", "Test", "Testing");
		Generics.scrollPage(driver, -500);
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
		vehicleDetailsPage.validateSavedVehicleDetails("RE", "DL9299", "26/10/2018", "Testing", "Testing", "26/10/2018", "21/10/2019");
		vehicleDetailsPage.clickEdit();
		vehicleDetailsPage.editVehicleDetails("RE350", "DL9299", "2019", "Oct", "21", "Testing", "Testing", "2018", "Oct", "26", "2019", "Oct", "21");
		vehicleDetailsPage.validateSavedVehicleDetails("RE350", "DL9299", "21/10/2019", "Testing", "Testing", "26/10/2018", "21/10/2019");
		
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
		
		for(int i=0; i<familyMemberDetailsData.size(); i++) {
			familyMemberDetailsPage.validateFamilyMemberDetails(i, familyMemberDetailsData.get(i));
		}
		Generics.scrollPage(driver, -500);
		
		//Edit scenarios are pending
		
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
		insuranceDetailsPage.validateSavedInsuranceDetails("Tata", "50000", "03/10/1998", "03/10/2001", "Bank", "Testing", "Testing", "Testing", "Testing", "Testing",
				"Testing", "Testing", "Testing", "Testing");
		Generics.scrollPage(driver,-500);
		insuranceDetailsPage.clickEdit();
		insuranceDetailsPage.editInsuranceDetails("Bajaj", "40000", "1999", "Oct", "4", "2002", "Oct", "3", "Credit", "Testing1", "Testing2", "Testing4", "Testing5", "Testing6",
				"Testing7", "Testing8", "Testing9", "Testing10");
		insuranceDetailsPage.validateSavedInsuranceDetails("Bajaj", "40000", "04/10/1999", "03/10/2002", "Credit", "Testing1", "Testing2", "Testing4", "Testing5", "Testing6",
				"Testing7", "Testing8", "Testing9", "Testing10");
		
		Generics.scrollPage(driver, -500);
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
		supportingDocumentsPage.uploadCoApplicantDocument("Adhar Card", png_upload_file_path);
		supportingDocumentsPage.uploadCoApplicantDocument("Pan Card", png_upload_file_path);
		supportingDocumentsPage.checkTermsAndConditions();
		supportingDocumentsPage.clickSubmit();
		supportingDocumentsPage.clickContinueToProfile();
		
		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);
		String borrowerId = borrowerDashboardPage.getBorrowerId();
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 2, 2, borrowerId);
		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		String loanId = borrowerDashboardPage.getLoanId();
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 3, 2, loanId);
		borrowerDashboardPage.validateLoanStatus("Initialized");
		

	}
}
