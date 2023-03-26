package com.automationsaas.test.investor.investoronboarding;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investoronboarding.BankDetailsPage;
import com.automationsaas.pom.investoronboarding.EmploymentDetailsPage;
import com.automationsaas.pom.investoronboarding.InvestorQuestionGroup1Page;
import com.automationsaas.pom.investoronboarding.InvestorRegistrationPage;
import com.automationsaas.pom.investoronboarding.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_InvestorOnboarding_IndividualInvestorOnboardingWithoutMandatoryFields extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateIndividualBorrowerOnboarding() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterButton();
		loginPage.clickInvestor();

		InvestorRegistrationPage investorRegistrationPage = new InvestorRegistrationPage(driver);
		investorRegistrationPage.validateInvestorRegistrationHeading("Investor Registration");
		String mobileNumber = Generics.getRandomNumber(10);
		investorRegistrationPage.enterMobileNumber(mobileNumber);
		investorRegistrationPage.selectDateOfBirth("1994", "Mar", "2");
		investorRegistrationPage.enterIdentityNumberOne("123456789123");
		investorRegistrationPage.enterIdentityNumberTwo("HNSYU0876H");
		investorRegistrationPage.clickContinue();
		
		ArrayList<String> investorRegistrationPageErrorMessages = new ArrayList<String>();
		investorRegistrationPageErrorMessages.add("Please provide First Name");
		investorRegistrationPageErrorMessages.add("Please provide Last Name");
		investorRegistrationPageErrorMessages.add("Please provide valid email address.");
		investorRegistrationPageErrorMessages.add("Password is Mandatory");
		investorRegistrationPageErrorMessages.add("Investor Category required");
		investorRegistrationPageErrorMessages.add("Please provide Gender");
		investorRegistrationPageErrorMessages.add("Please provide Marital Status");
		investorRegistrationPageErrorMessages.add("Please provide Title");
		investorRegistrationPageErrorMessages.add("Please provide Investor Detail Text Variable 1");
		
		for(int i=0; i<investorRegistrationPageErrorMessages.size(); i++) {
			investorRegistrationPage.validateMandatoryFieldsErrorMessages(9, investorRegistrationPageErrorMessages.get(i));
		}
		
		investorRegistrationPage.selectTitle("Mr");
		investorRegistrationPage.enterFirstName("Rishav");
		investorRegistrationPage.enterLastName("Shrivastava");
		String individualEmailId = "rishav.s+individualinvestor" + Generics.generateTimeStamp() + "@perfios.com";
		investorRegistrationPage.enterEmailAddress(individualEmailId);
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 1, 1, individualEmailId);
		investorRegistrationPage.selectGender("Male");
		investorRegistrationPage.selectMaritialStatus("Unmarried");
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 2, 1, mobileNumber);
		investorRegistrationPage.enterPassword(individualEmailId);
		investorRegistrationPage.enterConfirmPassword(individualEmailId);
		investorRegistrationPage.selectInvestorCategory("Category 1");
		investorRegistrationPage.enterInvestorDetailTextVariable1("Testing");
		investorRegistrationPage.clickContinue();
		
		ProfilePage profilePage = new ProfilePage(driver);
//		profilePage.clickContinueWithoutValidation();
		profilePage.validateProfilePageHeading("Profile");
		profilePage.clickContinue();
		
		ArrayList<String> investorProfilePageErrorMessages = new ArrayList<String>();
		investorProfilePageErrorMessages.add("Please enter amount you want to invest");
		investorProfilePageErrorMessages.add("Please enter your gross income");
		investorProfilePageErrorMessages.add("Please provide Investor profile Text Variable 1");
		
		for(int i=0; i<investorProfilePageErrorMessages.size(); i++) {
			profilePage.validateMandatoryFieldsErrorMessages(3, investorProfilePageErrorMessages.get(i));
		}
		
		profilePage.enterAmountToInvest("50000");
		profilePage.enterGrossIncome("50000");
		profilePage.enterInvestorProfileTextVariable1("Testing");
		profilePage.enterAddress("Line1", "Line2", "Line3", "Karnataka", "City", "Zip Code");
		profilePage.clickContinue();
		
		EmploymentDetailsPage employmentDetailsPage = new EmploymentDetailsPage(driver);
		employmentDetailsPage.validateEmploymentDetailsHeading("Employment Details");
		employmentDetailsPage.clickSubmitButton();
		
		ArrayList<String> investorEmploymentDetailsPageErrorMessages = new ArrayList<String>();
		investorEmploymentDetailsPageErrorMessages.add("Please Provide Organization Type");
		investorEmploymentDetailsPageErrorMessages.add("Please Provide Organization Name");
		
		for(int i=0; i<investorEmploymentDetailsPageErrorMessages.size(); i++) {
			employmentDetailsPage.validateMandatoryFieldsErrorMessages(2, investorEmploymentDetailsPageErrorMessages.get(i));
		}
		
		employmentDetailsPage.enterEmploymentTypes("QA");
		employmentDetailsPage.enterOrganizationName("Perfios");
		employmentDetailsPage.enterOrganizationType("IT");
		employmentDetailsPage.enterInvestorEmploymentDetailsTextVariable1("Testing");
		employmentDetailsPage.clickSubmitButton();
		
		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.validateBankDetailsHeading("Bank Details");
		bankDetailsPage.enterBankName("SBI");
		bankDetailsPage.enterIFSC("SBIN555");
		bankDetailsPage.enterAccountType("Savings");
		bankDetailsPage.clickSubmit();
		
		ArrayList<String> investorBankDetailsPageErrorMessages = new ArrayList<String>();
		investorBankDetailsPageErrorMessages.add("Account Number cannot be Blank");
		
		for(int i=0; i<investorBankDetailsPageErrorMessages.size(); i++) {
			employmentDetailsPage.validateMandatoryFieldsErrorMessages(1, investorEmploymentDetailsPageErrorMessages.get(i));
		}
		
		bankDetailsPage.enterAccountNumber("857845856");
		bankDetailsPage.clickSubmit();
		
		InvestorQuestionGroup1Page investorQuestionGroup1Page = new InvestorQuestionGroup1Page(driver);
		investorQuestionGroup1Page.validateInvestorQuestionGroup1Heading("Investor Question Group 1");
		investorQuestionGroup1Page.enterDownPayment("50000");
		investorQuestionGroup1Page.selectBorrowerNationality("Indian");
		investorQuestionGroup1Page.clickSubmit();
	}
}
