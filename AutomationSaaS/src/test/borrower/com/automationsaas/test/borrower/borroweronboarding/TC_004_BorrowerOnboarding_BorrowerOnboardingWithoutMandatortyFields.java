package com.automationsaas.test.borrower.borroweronboarding;

import java.util.ArrayList;

import org.testng.annotations.Test;

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
import com.automationsaas.pom.borroweronboarding.VehicleDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_004_BorrowerOnboarding_BorrowerOnboardingWithoutMandatortyFields extends Base {

	@Test
	(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void validateIndividualBorrowerOnboarding() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterButton();
		loginPage.clickBorrower();

		BorrowerRegistrationPage borrowerRegistrationPage = new BorrowerRegistrationPage(driver);
		borrowerRegistrationPage.validateBorrowerRegistrationHeading("Borrower Registration");
		
		String mobileNumber = Generics.getRandomNumber(10);
		borrowerRegistrationPage.enterMobileNumber(mobileNumber);
		borrowerRegistrationPage.checkAvailabilityOfMobileNumber();
		String landlineNumber = Generics.getRandomNumber(10);
		borrowerRegistrationPage.enterLandlineNumber(landlineNumber);
		borrowerRegistrationPage.checkAvailabilityOfLandlineNumber();
		borrowerRegistrationPage.selectDateOfBirth("1994", "Mar", "2");
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
		borrowerRegistrationPage.enterPersonalAddress("Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Double story house", "Address Three");
		borrowerRegistrationPage.enterAddressOne(
				"Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Staff Residence", "Address Three");
		borrowerRegistrationPage.enterAddressTwo(
				"Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2003", "Sep", "3", "Single Story House", "Address Three");
		borrowerRegistrationPage.selectBorrowerProfileTextVariable2("Test_4");
		borrowerRegistrationPage.enterBorrowerProfileTextVariable3("Testing");
		borrowerRegistrationPage.clickApplyNow();
		
		ArrayList<String> borrowerRegistrationPageErrorMessages = new ArrayList<String>();
		borrowerRegistrationPageErrorMessages.add("Please Provide EmailId");
		borrowerRegistrationPageErrorMessages.add("Please provide valid password.");
		borrowerRegistrationPageErrorMessages.add("Please provide First Name");
		borrowerRegistrationPageErrorMessages.add("Please provide Last Name");
		borrowerRegistrationPageErrorMessages.add("Please provide Gender");
		borrowerRegistrationPageErrorMessages.add("Please provide Marital Status");
		borrowerRegistrationPageErrorMessages.add("Please Select Type.");
		borrowerRegistrationPageErrorMessages.add("Please provide Title");
		borrowerRegistrationPageErrorMessages.add("Please provide Text Variable 1");
		
		for(int i=0; i<borrowerRegistrationPageErrorMessages.size(); i++) {
			borrowerRegistrationPage.validateMandatoryFieldsErrorMessages(9, borrowerRegistrationPageErrorMessages.get(i));
		}
		
		borrowerRegistrationPage.selectTitle("Mr");
		borrowerRegistrationPage.enterFirstName("Rishav");
		borrowerRegistrationPage.enterLastName("Shrivastava");
		String individualEmailId = "rishav.s+individualborrower" + Generics.generateTimeStamp() + "@perfios.com";
		borrowerRegistrationPage.enterEmailAddress(individualEmailId);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 1, 1, individualEmailId);
		borrowerRegistrationPage.checkAvailabilityOfEmailAddress();
		borrowerRegistrationPage.enterPassword(individualEmailId);
		borrowerRegistrationPage.enterConfirmPassword(individualEmailId);
		borrowerRegistrationPage.selectGender("Male");
		borrowerRegistrationPage.selectMaritialStatus("Unmarried");
		borrowerRegistrationPage.selectTypeAsIndividualOrCompany("Individual");
		borrowerRegistrationPage.selectBorrowerProfileTextVariable1("Test_1");
		borrowerRegistrationPage.clickApplyNow();
		
		ApplyForLoanPage applyForLoanPage = new ApplyForLoanPage(driver);
		applyForLoanPage.clickContinueWithoutValidation();
		applyForLoanPage.selectLoanProduct("Personal Loan");
		applyForLoanPage.clickApplyForLoan();
		
		ArrayList<String> applyForLoanPageErrorMessages = new ArrayList<String>();
		applyForLoanPageErrorMessages.add("Please provide the Loan amount you are looking.");
		applyForLoanPageErrorMessages.add("Please provide the expected loan interest rate.");
		applyForLoanPageErrorMessages.add("Please provide the expected loan repayment type.");
		applyForLoanPageErrorMessages.add("Please provide the expected loan Tenure.");
		
		for(int i=0; i<applyForLoanPageErrorMessages.size(); i++) {
			applyForLoanPage.validateMandatoryFieldsErrorMessages(4, applyForLoanPageErrorMessages.get(i));
		}
		
		applyForLoanPage.validateApplyForLoanHeading("Apply for Loan");
		applyForLoanPage.selectLoanProduct("Personal Loan");
		applyForLoanPage.enterLoanAmount("200000");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		applyForLoanPage.selectInterest("9 %");
		applyForLoanPage.selectLoanRepaymentType("Even Repayments");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		applyForLoanPage.selectTenure("1 Year");
		applyForLoanPage.clickApplyForLoan();
		
		
		DetailsPage detailsPage = new DetailsPage(driver);
		detailsPage.validateDetailsHeading("Details");
		detailsPage.selectEmploymentCategory("Permanent");
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
		
		ArrayList<String> detailsPageErrorMessages = new ArrayList<String>();
		detailsPageErrorMessages.add("Please enter your gross income");
		detailsPageErrorMessages.add("Please enter your Work Experience");
		
		for(int i=0; i<detailsPageErrorMessages.size(); i++) {
			detailsPage.validateMandatoryFieldsErrorMessages(2, detailsPageErrorMessages.get(i));
		}
		
		detailsPage.enterWorkExperience("2 Years");
		detailsPage.selectEmploymentCategory("Permanent");
		detailsPage.enterGrossIncome("50000");
		detailsPage.clickContinueButton();
		
		
		EmploymentDetailsPage employmentDetailsPage = new EmploymentDetailsPage(driver);
		employmentDetailsPage.validateEmploymentDetailsHeading("Employment Details");
		employmentDetailsPage.selectOrganisationType("Organization_1");
		employmentDetailsPage.selectEmploymentType("Contractors");
		employmentDetailsPage.enterAnnualIncome("500000");
		employmentDetailsPage.enterOfficialEmailId("rishav.s@perfios.com");
		employmentDetailsPage.enterOfficeLandline("4578452145");
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
		
		ArrayList<String> employmentDetailsPageErrorMessages = new ArrayList<String>();
		employmentDetailsPageErrorMessages.add("Please Provide Organization Name.");
		employmentDetailsPageErrorMessages.add("Please Provide Department.");
		employmentDetailsPageErrorMessages.add("Please Provide Designation.");
		employmentDetailsPageErrorMessages.add("Employee ID Required");
		
		for(int i=0; i<employmentDetailsPageErrorMessages.size(); i++) {
			employmentDetailsPage.validateMandatoryFieldsErrorMessages(4, employmentDetailsPageErrorMessages.get(i));
		}
		
		employmentDetailsPage.enterOrganisation("Perfios");
		employmentDetailsPage.selectDepartment("Technology");
		employmentDetailsPage.selectDesignation("QA");
		employmentDetailsPage.enterEmployeeId("Per785");
		employmentDetailsPage.clickContinue();
		
		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.validateBankDetailsHeading("Bank Details");
		bankDetailsPage.enterAccountHolderName("Rishav");
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
		
		ArrayList<String> bankDetailsPageErrorMessages = new ArrayList<String>();
		bankDetailsPageErrorMessages.add("Account Number cannot be Blank");
		
		for(int i=0; i<bankDetailsPageErrorMessages.size(); i++) {
			bankDetailsPage.validateMandatoryFieldsErrorMessages(1, bankDetailsPageErrorMessages.get(i));
		}
		
		bankDetailsPage.enterAccountNumber("5684521256");
		bankDetailsPage.clickSubmit();
		
		Co_ApplicantDetailsPage co_ApplicantDetailsPage = new Co_ApplicantDetailsPage(driver);
		co_ApplicantDetailsPage.validateCo_ApplicantDetailsHeading("Co-Applicant Details");
		co_ApplicantDetailsPage.enterAdharCardNumber("414525415412");
		co_ApplicantDetailsPage.enterPanCardNumber("FGTRA7678Z");
		co_ApplicantDetailsPage.enterIdentityNumberThree("Testing");
		co_ApplicantDetailsPage.enterIdentityNumberFour("Testing");
		co_ApplicantDetailsPage.enterIdentityNumberFive("Testing");
		co_ApplicantDetailsPage.enterIdentityNumberSix("Testing");
		
		co_ApplicantDetailsPage.enterDepartmentName("Testing");
		co_ApplicantDetailsPage.enterDesignation("Testing");
		co_ApplicantDetailsPage.enterEmail("rishav.s@perfios.com");
		co_ApplicantDetailsPage.enterMobileNumber("4145214521");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable2("Testing");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable3("Testing");
		co_ApplicantDetailsPage.enterAddress("Line1", "Line2", "Line3", "Bengaluru", "Bangalore", "Karnataka", "Bangalore", "India", "560090",
				"13", "Mar", "2006", "Double story house", "Address");
		co_ApplicantDetailsPage.clickAddAndContinue();
		
		ArrayList<String> co_ApplicantDetailsPageErrorMessages = new ArrayList<String>();
		co_ApplicantDetailsPageErrorMessages.add("First Name Required");
		co_ApplicantDetailsPageErrorMessages.add("Last Name Required");
		co_ApplicantDetailsPageErrorMessages.add("Please provide valid email address.");
		co_ApplicantDetailsPageErrorMessages.add("Company Name Required");
		co_ApplicantDetailsPageErrorMessages.add("Please provide Co Applicant Employment Text Variable 1");
		
		for(int i=0; i<co_ApplicantDetailsPageErrorMessages.size(); i++) {
			co_ApplicantDetailsPage.validateMandatoryFieldsErrorMessages(5, co_ApplicantDetailsPageErrorMessages.get(i));
		}
		
		co_ApplicantDetailsPage.enterFirstName("Rishav");
		co_ApplicantDetailsPage.enterLastName("Shrivastava");
		co_ApplicantDetailsPage.enterEmailId("rishav.s@perfios.com");
		
		co_ApplicantDetailsPage.enterCompanyName("Perfios");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable1("Testing");
		co_ApplicantDetailsPage.clickAddAndContinue();
		
		ReferenceDetailsPage referenceDetailsPage = new ReferenceDetailsPage(driver);
		referenceDetailsPage.validateReferenceDetailsHeading("Reference Details");
		referenceDetailsPage.enterLastName("Shrivastava");
		referenceDetailsPage.enterEmailAddress("rishav.s@perfios.com");
		referenceDetailsPage.enterRelationshipStatus("Single");
		referenceDetailsPage.clickAddAndContinue();
		
		ArrayList<String> referenceDetailsPageErrorMessages = new ArrayList<String>();
		referenceDetailsPageErrorMessages.add("Please provide First Name");
		
		for(int i=0; i<referenceDetailsPageErrorMessages.size(); i++) {
			referenceDetailsPage.validateMandatoryFieldsErrorMessages(1, referenceDetailsPageErrorMessages.get(i));
		}
		
		referenceDetailsPage.enterFirstName("Rishav");
		referenceDetailsPage.enterMobileNumber("8524563524");
		referenceDetailsPage.clickAddAndContinue();
		
		
		OtherLoanDetailsPage otherLoanDetailsPage = new OtherLoanDetailsPage(driver);
		otherLoanDetailsPage.validateOtherLoanDetailsHeading("Other Loan Details");
		otherLoanDetailsPage.enterLoanPurpose("Testing");
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
		
		ArrayList<String> otherLoanDetailsPageErrorMessages = new ArrayList<String>();
		otherLoanDetailsPageErrorMessages.add("Loan Amount Required");
		
		for(int i=0; i<otherLoanDetailsPageErrorMessages.size(); i++) {
			otherLoanDetailsPage.validateMandatoryFieldsErrorMessages(1,otherLoanDetailsPageErrorMessages.get(i));
		}
		
		otherLoanDetailsPage.enterLoanAmount("50000");
		otherLoanDetailsPage.clickAddAndContinue();
		
		VehicleDetailsPage vehicleDetailsPage = new VehicleDetailsPage(driver);
		vehicleDetailsPage.validateVehicleDetailsHeading("Vehicle Details");
		vehicleDetailsPage.enterLicenseNumber("DL9299");
		vehicleDetailsPage.enterPurchaseDate("2018", "Oct", "26");
		vehicleDetailsPage.enterVehicleOwnedExtraTextVariable1("Testing");
		vehicleDetailsPage.enterVehicleOwnedExtraTextVariable2("Testing");
		vehicleDetailsPage.selectVehicleOwnedExtraDateVariable1("2018", "Oct", "26");
		vehicleDetailsPage.selectVehicleOwnedExtraDateVariable2("2019", "Oct", "21");
		vehicleDetailsPage.clickAddAndContinue();
		
		ArrayList<String> vehicleDetailsPageErrorMessages = new ArrayList<String>();
		vehicleDetailsPageErrorMessages.add("Please Provide Brand Name");
		
		for(int i=0; i<vehicleDetailsPageErrorMessages.size(); i++) {
			vehicleDetailsPage.validateMandatoryFieldsErrorMessages(1,vehicleDetailsPageErrorMessages.get(i));
		}
		
		vehicleDetailsPage.enterBrandName("RE");
		vehicleDetailsPage.clickAddAndContinue();
		

		FamilyMemberDetailsPage familyMemberDetailsPage = new FamilyMemberDetailsPage(driver);
		familyMemberDetailsPage.validateFamilyMemberDetailsHeading("Family Member Details");
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
		
		ArrayList<String> familyMemberDetailsPageErrorMessages = new ArrayList<String>();
		familyMemberDetailsPageErrorMessages.add("Please Provide Name");
		
		for(int i=0; i<familyMemberDetailsPageErrorMessages.size(); i++) {
			familyMemberDetailsPage.validateMandatoryFieldsErrorMessages(1,familyMemberDetailsPageErrorMessages.get(i));
		}
		
		familyMemberDetailsPage.enterName("Rishav");
		familyMemberDetailsPage.clickAddAndContinue();
		
		InsuranceDetailsPage insuranceDetailsPage = new InsuranceDetailsPage(driver);
		insuranceDetailsPage.validateInsuranceDetailsHeading("Insurance Details");
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
		
		ArrayList<String> insuranceDetailsPageErrorMessages = new ArrayList<String>();
		insuranceDetailsPageErrorMessages.add("Please provide Insurer Name");
		insuranceDetailsPageErrorMessages.add("Please provide Insurance Amount");
		
		for(int i=0; i<insuranceDetailsPageErrorMessages.size(); i++) {
			insuranceDetailsPage.validateMandatoryFieldsErrorMessages(2,insuranceDetailsPageErrorMessages.get(i));
		}
		
		insuranceDetailsPage.enterInsurerName("Tata");
		insuranceDetailsPage.enterAmount("50000");
		insuranceDetailsPage.clickAddAndContinue();
		
		BorrowerQuestionGroup1Page borrowerQuestionGroup1Page = new BorrowerQuestionGroup1Page(driver);
		borrowerQuestionGroup1Page.validateBorrowerQuestionGroup1Heading("Borrower Question Group 1");
		
		borrowerQuestionGroup1Page.clickSubmit();
		
		ArrayList<String> borrowerQuestionGroup1PageErrorMessages = new ArrayList<String>();
		borrowerQuestionGroup1PageErrorMessages.add("This value is required.");
		borrowerQuestionGroup1PageErrorMessages.add("This value is required.");
		
		for(int i=0; i<borrowerQuestionGroup1PageErrorMessages.size(); i++) {
			borrowerQuestionGroup1Page.validateMandatoryFieldsErrorMessages(2,borrowerQuestionGroup1PageErrorMessages.get(i));
		}
		
		borrowerQuestionGroup1Page.selectBorrowerNationality("Indian");
		borrowerQuestionGroup1Page.enterDownPayment("50000");
		borrowerQuestionGroup1Page.clickSubmit();
	}
}
