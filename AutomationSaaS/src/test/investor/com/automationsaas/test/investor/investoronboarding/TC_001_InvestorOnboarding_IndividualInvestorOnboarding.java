package com.automationsaas.test.investor.investoronboarding;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investoronboarding.BankDetailsPage;
import com.automationsaas.pom.investoronboarding.EmploymentDetailsPage;
import com.automationsaas.pom.investoronboarding.InvestorQuestionGroup1Page;
import com.automationsaas.pom.investoronboarding.InvestorRegistrationPage;
import com.automationsaas.pom.investoronboarding.ProfilePage;
import com.automationsaas.pom.investoronboarding.SupportingDocumentsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_InvestorOnboarding_IndividualInvestorOnboarding extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateIndividualBorrowerOnboarding() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterButton();
		loginPage.clickInvestor();

		InvestorRegistrationPage investorRegistrationPage = new InvestorRegistrationPage(driver);
		investorRegistrationPage.validateInvestorRegistrationHeading("Investor Registration");
		investorRegistrationPage.selectTitle("Mr");
		investorRegistrationPage.enterFirstName("Rishav");
		investorRegistrationPage.enterLastName("Shrivastava");
		String individualEmailId = "rishav.s+individualinvestor" + Generics.generateTimeStamp() + "@perfios.com";
		investorRegistrationPage.enterEmailAddress(individualEmailId);
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 1, 1, individualEmailId);
		investorRegistrationPage.selectGender("Male");
		investorRegistrationPage.selectMaritialStatus("Unmarried");
		String mobileNumber = Generics.getRandomNumber(10);
		investorRegistrationPage.enterMobileNumber(mobileNumber);
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 2, 1, mobileNumber);
		investorRegistrationPage.enterPassword(individualEmailId);
		investorRegistrationPage.enterConfirmPassword(individualEmailId);
		investorRegistrationPage.selectDateOfBirth("1994", "Mar", "2");
		investorRegistrationPage.selectInvestorCategory("Category 1");
		investorRegistrationPage.enterIdentityNumberOne("123456789123");
		investorRegistrationPage.enterIdentityNumberTwo("HNSYU0876H");
		investorRegistrationPage.enterInvestorDetailTextVariable1("Testing");
		investorRegistrationPage.clickContinue();
		
		ProfilePage profilePage = new ProfilePage(driver);
//		profilePage.clickContinueWithoutValidation();
		profilePage.validateProfilePageHeading("Profile");
		profilePage.enterAmountToInvest("50000");
		profilePage.enterGrossIncome("50000");
		profilePage.enterInvestorProfileTextVariable1("Testing");
		profilePage.enterAddress("Line1", "Line2", "Line3", "Karnataka", "City", "Zip Code");
		profilePage.clickContinue();
		
		EmploymentDetailsPage employmentDetailsPage = new EmploymentDetailsPage(driver);
		employmentDetailsPage.validateEmploymentDetailsHeading("Employment Details");
		employmentDetailsPage.enterEmploymentTypes("QA");
		employmentDetailsPage.enterOrganizationName("Perfios");
		employmentDetailsPage.enterOrganizationType("IT");
		employmentDetailsPage.enterInvestorEmploymentDetailsTextVariable1("Testing");
		employmentDetailsPage.clickSubmitButton();
		
		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.validateBankDetailsHeading("Bank Details");
		bankDetailsPage.enterAccountNumber("857845856");
		bankDetailsPage.enterBankName("SBI");
		bankDetailsPage.enterIFSC("SBIN555");
		bankDetailsPage.enterAccountType("Savings");
		bankDetailsPage.clickSubmit();
		
		InvestorQuestionGroup1Page investorQuestionGroup1Page = new InvestorQuestionGroup1Page(driver);
		investorQuestionGroup1Page.validateInvestorQuestionGroup1Heading("Investor Question Group 1");
		investorQuestionGroup1Page.enterDownPayment("50000");
		investorQuestionGroup1Page.selectBorrowerNationality("Indian");
		investorQuestionGroup1Page.clickSubmit();
		
		SupportingDocumentsPage supportingDocumentsPage = new SupportingDocumentsPage(driver);
		supportingDocumentsPage.uploadDocument("Adhar", png_upload_file_path);
		Generics.refreshPage(driver);
		supportingDocumentsPage.uploadDocument("Adhar", text_upload_file_path);
		Generics.refreshPage(driver);
		supportingDocumentsPage.uploadDocument("Adhar", jpg_upload_file_path);
		Generics.refreshPage(driver);
		supportingDocumentsPage.validateUploadedDocument("Adhar", 3);
		Generics.refreshPage(driver);
		supportingDocumentsPage.deleteUploadedDocument("Adhar", 1);
		Generics.refreshPage(driver);
		supportingDocumentsPage.validateUploadedDocument("Adhar", 2);
		Generics.refreshPage(driver);
		
		supportingDocumentsPage.uploadDocument("Pan Card", jpg_upload_file_path);
		supportingDocumentsPage.uploadDocument("Address Proof", text_upload_file_path);
		supportingDocumentsPage.checkTermsAndConditions();
		supportingDocumentsPage.clickSubmit();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		String investorID = dashboardPage.getInvestorId();
		String[] splittedInvestorId = investorID.split("\\n");
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 3, 1, splittedInvestorId[1]);
	}
}
