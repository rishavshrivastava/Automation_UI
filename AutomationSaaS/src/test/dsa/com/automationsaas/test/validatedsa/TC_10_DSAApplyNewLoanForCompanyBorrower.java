package com.automationsaas.test.validatedsa;

import java.util.ArrayList;

import org.testng.annotations.Test;

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
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.dsa.ExistingBorrowerPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_10_DSAApplyNewLoanForCompanyBorrower extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void validateApplyNewLoanForCompanyBorrower() {

		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		String dsaid = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		dashboardPage.validateDSAId(dsaid);
		dashboardPage.validateProfileStatus("Approved");
		dashboardPage.clickApplyForLoan();
		dashboardPage.clickApplyLoanForNewBorrower();

		BorrowerRegistrationPage borrowerRegistrationPage = new BorrowerRegistrationPage(driver);
		borrowerRegistrationPage.validateBorrowerRegistrationHeading("Borrower Registration");
		borrowerRegistrationPage.selectTitle("Mr");
		borrowerRegistrationPage.enterFirstName("Chandrashekhar");
		borrowerRegistrationPage.enterLastName("Yaragall");
		String companyEmailId = "chandrasekar.y+dsacompanyborrower" + Generics.generateTimeStamp() + "@perfios.com";
		borrowerRegistrationPage.enterborrowerEmail(companyEmailId);
		borrowerRegistrationPage.checkAvailabilityOfEmailAddress();
		borrowerRegistrationPage.selectGender("Male");
		borrowerRegistrationPage.selectMaritialStatus("Unmarried");
		String mobileNumber = Generics.getRandomNumber(10);
		borrowerRegistrationPage.enterMobileNumber(mobileNumber);
		borrowerRegistrationPage.checkAvailabilityOfMobileNumber();
		borrowerRegistrationPage.selectDateOfBirth("1994", "Sep", "23");
		borrowerRegistrationPage.selectTypeAsIndividualOrCompany("Company");
		borrowerRegistrationPage.selectBorrowerProfileTextVariable1("Test_2");
		borrowerRegistrationPage.clickApplyNow();

		ApplyForLoanPage applyForLoanPage = new ApplyForLoanPage(driver);
		applyForLoanPage.clickContinueWithoutValidation();
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

		CompanyDetailsPage companyDetailsPage = new CompanyDetailsPage(driver);
		companyDetailsPage.validateCompanyDetailsHeading("Company Details");
		companyDetailsPage.enterCompanyName("Perfios");
		companyDetailsPage.enterCompanyRegistrationNumber("300302");
		companyDetailsPage.enterCompanyTurnOver("56");
		companyDetailsPage.selectDateOfArticles("2016", "Mar", "23");
		companyDetailsPage.enterAddress("Line1", "Line2", "Line3", "Karnataka", "Bangalore", "560001");
		companyDetailsPage.clickContinue();

		CompanyRepresentativePage companyRepresentativePage = new CompanyRepresentativePage(driver);
		companyRepresentativePage.validateCompanyRepresentativeHeading("Add Company Representative");
		companyRepresentativePage.clickcreateCEO();
		companyRepresentativePage.enterCEODetailsForDSACompanyBorrower("Chandrashekhar", "Yaragall", "chandrasekar.y@perfios.com");
		companyRepresentativePage.clickAddCeoContinue();
		
			
	//	try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		companyRepresentativePage.clickCreateShareHolder();
		companyRepresentativePage.enterShareHolderDetailsForDSACompanyBorrower("Chandrashekhar", "Yaragall", "chandrasekar.y@perfios.com");
		companyRepresentativePage.clickAddShareHolderContinue();
		
		
		//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		SupportingDocumentsPage supportingDocumentsPage = new SupportingDocumentsPage(driver);
		
		supportingDocumentsPage.uploadCompanyRepresentativeDocument("Adhar Card", png_upload_file_path);
		supportingDocumentsPage.clickCompanyRepresentativeDocumentsSubmit();

		companyRepresentativePage.clickContinue();

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.validateBankDetailsHeading("Bank Details");
		bankDetailsPage.enterAccountNumber("5684521256");
		bankDetailsPage.enterBankName("SBI");
		bankDetailsPage.enterIFSC("SBIN999");
		bankDetailsPage.enterAccountType("Savings");
		bankDetailsPage.clickSubmit();

//Divya

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
		Generics.scrollPage(driver, -1700);
		co_ApplicantDetailsPage.validateCoAppplicantDetails("Rishav Shrivastava", "rishav.s@perfios.com",
				"414525415412", "FGTRA7678Z", "Testing", "Testing", "Testing", "Testing", "Perfios", "Testing",
				"Line1, Line2, Line3, Bangalore, Karnataka, 560090, Karnataka, Bangalore, Bengaluru", "+914145214521",
				"rishav.s@perfios.com", "Testing", "Testing", "Testing", "Testing", "");

		co_ApplicantDetailsPage.clickEdit();
		co_ApplicantDetailsPage.editCoApplicantDetails("test", "test", "chandrasekar.y@perfios.com", "test", "test");
		Generics.scrollPage(driver, -1700);
		co_ApplicantDetailsPage.validateCoAppplicantDetails("test test", "chandrasekar.y@perfios.com", "414525415412",
				"FGTRA7678Z", "Testing", "Testing", "Testing", "Testing", "test", "Testing",
				"Line1, Line2, Line3, Bangalore, Karnataka, 560090, Karnataka, Bangalore, Bengaluru", "+914145214521",
				"rishav.s@perfios.com", "Testing", "test", "Testing", "Testing", "");
		co_ApplicantDetailsPage.clickDelete();
		co_ApplicantDetailsPage.enterFirstName("Chandrashekhar");
		co_ApplicantDetailsPage.enterLastName("Yaragall");
		co_ApplicantDetailsPage.enterEmailId("chandrasekar.y@perfios.com");
		co_ApplicantDetailsPage.enterCompanyName("Perfios");
		co_ApplicantDetailsPage.enterCoApplicantEmploymentTextVariable1("Test");
		co_ApplicantDetailsPage.clickAddAndContinue();

		ReferenceDetailsPage referenceDetailsPage = new ReferenceDetailsPage(driver);
		referenceDetailsPage.validateReferenceDetailsHeading("Reference Details");
		referenceDetailsPage.enterFirstName("Chandrashekhar");
		referenceDetailsPage.enterLastName("Yaragall");
		referenceDetailsPage.enterEmailAddress("chandrasekar.y@perfios.com");
		referenceDetailsPage.enterMobileNumber("8000000001");
		referenceDetailsPage.enterRelationshipStatus("Single");
		referenceDetailsPage.clickAddMore();
		Generics.scrollPage(driver, -1700);
		referenceDetailsPage.validateReferenceDetails("Chandrashekhar  Yaragall", "chandrasekar.y@perfios.com",
				"+918000000001", "Single");

		referenceDetailsPage.clickEdit();
		referenceDetailsPage.editReferenceDetails("Chandru", "Yaragall", "chandrasekar.y@perfios.com", "8000000001",
				"Single");
		Generics.scrollPage(driver, -1700);
		referenceDetailsPage.validateReferenceDetails("Chandru  Yaragall", "chandrasekar.y@perfios.com",
				"+918000000001", "Single");
		referenceDetailsPage.clickDelete();
		referenceDetailsPage.enterFirstName("Chandrashekhar");
		referenceDetailsPage.enterLastName("Yaragall");
		referenceDetailsPage.enterEmailAddress("chandrasekar.y@perfios.com");
		referenceDetailsPage.enterMobileNumber("8000000001");
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
		Generics.scrollPage(driver, -1500);
		otherLoanDetailsPage.validateSavedOtherLoanDetails("Testing", "50000", "60000", "50000", "SBI", "4521452563",
				"02/02/1992", "02/11/2002", "5", "PL", "Test", "Testing");
		otherLoanDetailsPage.clickEdit();
		otherLoanDetailsPage.editOtherLoanDetails("Testing", "70000", "80000", "7000", "SBI", "4521452512", "1998",
				"Feb", "2", "2003", "Nov", "2", "3", "Car", "Test", "Testing");
		Generics.scrollPage(driver, -1500);
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
		Generics.scrollPage(driver, -1500);
		vehicleDetailsPage.validateSavedVehicleDetails("RE", "DL9299", "26/10/2018", "Testing", "Testing", "26/10/2018",
				"21/10/2019");
		vehicleDetailsPage.clickEdit();
		vehicleDetailsPage.editVehicleDetails("RE350", "DL9299", "2019", "Oct", "21", "Testing", "Testing", "2018",
				"Oct", "26", "2019", "Oct", "21");
		Generics.scrollPage(driver, -1500);
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
		Generics.scrollPage(driver, -500);

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
		Generics.scrollPage(driver, -1500);
		insuranceDetailsPage.validateSavedInsuranceDetails("Tata", "50000", "03/10/1998", "03/10/2001", "Bank",
				"Testing", "Testing", "Testing", "Testing", "Testing", "Testing", "Testing", "Testing", "Testing");
		insuranceDetailsPage.clickEdit();
		insuranceDetailsPage.editInsuranceDetails("Bajaj", "40000", "1999", "Oct", "4", "2002", "Oct", "3", "Credit",
				"Testing1", "Testing2", "Testing4", "Testing5", "Testing6", "Testing7", "Testing8", "Testing9",
				"Testing10");
		Generics.scrollPage(driver, -1500);
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

		supportingDocumentsPage.validateSupportingDocumentsHeading("Supporting Documents");
		supportingDocumentsPage.uploadDocument("Adhar Card", png_upload_file_path);
		supportingDocumentsPage.uploadDocument("Address Proof", jpg_upload_file_path);
		supportingDocumentsPage.uploadDocument("Bank Statement", text_upload_file_path);
		supportingDocumentsPage.uploadDocument("Pan Card", text_upload_file_path);

		Generics.refreshPage(driver);

		// multiple upload
		supportingDocumentsPage.uploadMoreDocument("Adhar Card", jpg_upload_file_path);
		Generics.refreshPage(driver);
		supportingDocumentsPage.uploadMoreDocument("Address Proof", png_upload_file_path);
		Generics.refreshPage(driver);

		// delete one document and validate

		supportingDocumentsPage.validateUploadedDocument("Adhar Card", 2);
		Generics.refreshPage(driver);
		supportingDocumentsPage.deleteUploadedDocument("Adhar Card", 1);
		Generics.refreshPage(driver);
		supportingDocumentsPage.validateUploadedDocument("Adhar Card", 1);
		Generics.refreshPage(driver);

		supportingDocumentsPage.uploadCoApplicantDocument("Adhar Card", png_upload_file_path);
		supportingDocumentsPage.uploadReferenceDocument("Adhar Card", png_upload_file_path);
		// supportingDocumentsPage.checkTermsAndConditions();
		supportingDocumentsPage.clickSubmit();
		supportingDocumentsPage.clickContinueToProfile();

		dashboardPage.clickApplyForLoan();
		dashboardPage.clickApplyLoanForExistingBorrower();

		ExistingBorrowerPage existingBorrowerPage = new ExistingBorrowerPage(driver);
		existingBorrowerPage.clickOnShowAllFiltersLink(); // cmy
		existingBorrowerPage.fillEmailFilter(companyEmailId);
		existingBorrowerPage.clickOnSearch();
		String dsaborrowerId = existingBorrowerPage.getBorrowerId();
		System.out.println("Company Type Borrower ID Created : " + dsaborrowerId);

		dashboardPage.clickonActiveLoan();
		String activeLoanID = dashboardPage.verifyAndCopyActiveLoanID(dsaborrowerId);
		System.out.println("Loan ID created : " + activeLoanID);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 8, 1, activeLoanID);

		dashboardPage.clickSupportingDocumentsTab();
		dashboardPage.clickLoanApplicationDocAccordion();

		// Documents

		// single doc download
		dashboardPage.clickDownloadDocument("Pan Card");

		// validate single document download
		String documentDownloaded = "TextFile.png";
		dashboardPage.validateDownloadedDocument(documentDownloaded);
		Generics.refreshPage(driver);
		dashboardPage.clickSupportingDocumentsTab();
		dashboardPage.clickLoanApplicationDocAccordion();

		// upload doc
		dashboardPage.uploadDocument("Adhar Card", text_upload_file_path);
		Generics.refreshPage(driver);
		dashboardPage.clickSupportingDocumentsTab();
		dashboardPage.clickLoanApplicationDocAccordion();

		// download multiple doc zip and validate the downloaded doc
		dashboardPage.clickDownloadDocument("Adhar Card");
		String multipleDocumentDownload = "Adhar_Card.zip";
		dashboardPage.validateDownloadedDocument(multipleDocumentDownload);
		Generics.refreshPage(driver);
		dashboardPage.clickSupportingDocumentsTab();
		dashboardPage.clickLoanApplicationDocAccordion();

		dashboardPage.clickDownloadDocument("Address Proof");
		String multipleDocumentDownload2 = "Address_Proof.zip";
		dashboardPage.validateDownloadedDocument(multipleDocumentDownload2);
		Generics.refreshPage(driver);
		dashboardPage.clickSupportingDocumentsTab();
		dashboardPage.clickLoanApplicationDocAccordion();

		// delete document from upload pop up
		dashboardPage.deleteDocument("Address Proof");

	}
}