package com.automationsaas.test.validatedsa;

import java.util.ArrayList;
import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.BasicDetailPage;
import com.automationsaas.pom.dsa.CompanyDetailsPage;
import com.automationsaas.pom.dsa.CreditAnswersPage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_06_UpdateDSADashboard extends Base {

	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void updateDSA() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// DSA Dashboard
		DashboardPage dsaDashboardPage = new DashboardPage(driver);

		dsaDashboardPage.clickAccount();
		dsaDashboardPage.clickProfile();

		dsaDashboardPage.validateProfileStatus("Awaiting Approval");
		dsaDashboardPage.validateAccountBalance("Rs0");

		BasicDetailPage basicDetailsPage = new BasicDetailPage(driver);
		basicDetailsPage.clickBasicDetail();

		// Validate Identity Number 1 From DSA Basic Details Page
		String valididentityNumberOne = "11" + Generics.getRandomNumber(10);
		String invalididentityNumberOne11 = "12" + Generics.getRandomNumber(9);
		String invalididentityNumberOne13 = "123" + Generics.getRandomNumber(10);

		// case 1 - Invalid: Identity Number 1= 11 digits
		basicDetailsPage.validateDSAIdentityNumbersInValidCase("^[0-9]{12}$", invalididentityNumberOne11);
		// case 2 - Invalid: Identity Number 1= 13 digits
		basicDetailsPage.validateDSAIdentityNumbersInValidCase("^[0-9]{12}$", invalididentityNumberOne13);
		// case 3 - Invalid: Identity Number 1= 12 Alphabets
		basicDetailsPage.validateDSAIdentityNumbersInValidCase("^[0-9]{12}$", "ABCDEFGHijkL");
		// case 4 - Valid: Identity Number 1= 12 digits
		basicDetailsPage.validateDSAIdentityNumbersValidCase("^[0-9]{12}$", valididentityNumberOne);

		// Validate Identity Number 2 From DSA Basic Details Page
		String valididentityNumberTwo = "ABCDE" + Generics.getRandomNumber(4) + "F";
		String invalididentityNumberTwo36 = "ABC" + Generics.getRandomNumber(6);
		String invalididentityNumberTwo35 = "ABC" + Generics.getRandomNumber(5);
		String invalididentityNumberTwo10 = Generics.getRandomNumber(10);
		String invalididentityNumberTwo451 = Generics.getRandomNumber(5) + "ABCD" + 1;

		Generics.scrollPage(driver, -800);
		// case 1 - Invalid: Identity Number 2= 3 Alphabets + 6 numbers
		basicDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$", invalididentityNumberTwo36);
		// case 2 - Invalid: Identity Number 2= 3 Alphabets + 5 numbers
		basicDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$", invalididentityNumberTwo35);
		// case 3 - Invalid: Identity Number 2= 12 numbers
		basicDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$", invalididentityNumberTwo10);
		// case 3 - Invalid: Identity Number 2= 4 numbers + 5 Alphabets + 1 number
		basicDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				invalididentityNumberTwo451);
		// case 4 - Valid: Identity Number 2= 5 Alphabets+ 4 numbers + 1 Alphabet
		basicDetailsPage.validateDSAIdentityNumberTwoValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$", valididentityNumberTwo);
		Generics.refreshPage(driver);
		Generics.scrollPage(driver, -800);

		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 10, 1, valididentityNumberOne);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 11, 1, valididentityNumberTwo);

		ArrayList<String> basicProfile = new ArrayList<String>();
		basicProfile.add("Mr");
		basicProfile.add("DivyaDSA");
		basicProfile.add("SachanDSA");
		basicProfile.add("");
		basicProfile.add("Male");
		basicProfile.add("Testing1");
		basicProfile.add("Line111");
		basicProfile.add("Line112");
		basicProfile.add("Line113");
		basicProfile.add("Karnataka");
		basicProfile.add("Kanpur");
		basicProfile.add("208080");
		basicProfile.add("Line120");
		basicProfile.add("Line121");
		basicProfile.add("Line131");
		basicProfile.add("Karnataka");
		basicProfile.add("Pune");
		basicProfile.add("Zip Code1");

		for (int i = 0; i < basicProfile.size(); i++) {
			basicDetailsPage.editBasicDetails(i, basicProfile.get(i), "1995", "Nov", "12");
		}
		basicDetailsPage.clickBasicDetailsUpdate();
		Generics.waitForFewSecondstoLoad(2000);

		Generics.scrollPage(driver, -800);
		Generics.refreshPage(driver);

		// validate basic detail after update

		ArrayList<String> basicProfileValidate = new ArrayList<String>();
		basicProfileValidate.add(username);
		basicProfileValidate.add("Mr");
		basicProfileValidate.add("DivyaDSA");
		basicProfileValidate.add("SachanDSA");
		basicProfileValidate.add("12/11/1995");
		basicProfileValidate.add("Male");
		basicProfileValidate.add("Testing1");
		basicProfileValidate.add("10/06/1996");
		basicProfileValidate.add("Line111");
		basicProfileValidate.add("Line112");
		basicProfileValidate.add("Line113");
		basicProfileValidate.add("Sub District Per");
		basicProfileValidate.add("District Per");
		basicProfileValidate.add("Karnataka");
		basicProfileValidate.add("Kanpur");
		basicProfileValidate.add("India A");
		basicProfileValidate.add("208080");
		basicProfileValidate.add("14/11/2007");
		basicProfileValidate.add("Staff Residence");
		basicProfileValidate.add("Line120");
		basicProfileValidate.add("Line121");
		basicProfileValidate.add("Line131");
		basicProfileValidate.add("Sub District");
		basicProfileValidate.add("District");
		basicProfileValidate.add("Karnataka");
		basicProfileValidate.add("Pune");
		basicProfileValidate.add("Country");
		basicProfileValidate.add("Zip Code1");
		basicProfileValidate.add("03/09/2005");
		basicProfileValidate.add("Double story house");
		

		for (int i = 0; i < basicProfileValidate.size(); i++) {
			basicDetailsPage.validateBasicDetail(i, basicProfileValidate.get(i));
		}

		CompanyDetailsPage companyDetailsPage = new CompanyDetailsPage(driver);
		// Validate Identity Number 1 From DSA Company Details Page
		String validcompanyidentityNumberOne = "11" + Generics.getRandomNumber(10);

		// case 1 - Invalid: Identity Number 1= 11 digits
		companyDetailsPage.validateDSAIdentityNumbersInValidCase("^[0-9]{12}$", invalididentityNumberOne11);
		// case 2 - Invalid: Identity Number 1= 13 digits
		companyDetailsPage.validateDSAIdentityNumbersInValidCase("^[0-9]{12}$", invalididentityNumberOne13);
		// case 3 - Invalid: Identity Number 1= 12 Alphabets
		companyDetailsPage.validateDSAIdentityNumbersInValidCase("^[0-9]{12}$", "ABCDEFGHijkL");
		// case 4 - Valid: Identity Number 1= 12 digits
		companyDetailsPage.validateDSAIdentityNumbersValidCase("^[0-9]{12}$", validcompanyidentityNumberOne);

		// Validate Identity Number 2 From DSA Company Details Page
		Generics.refreshPage(driver);
		companyDetailsPage.clickCompanyDetails();
		String validcompanyidentityNumberTwo = "ABCDE" + Generics.getRandomNumber(4) + "F";
		// case 1 - Invalid: Identity Number 2= 3 Alphabets + 6 numbers
		companyDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				invalididentityNumberTwo36);
		// case 2 - Invalid: Identity Number 2= 3 Alphabets + 5 numbers
		companyDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				invalididentityNumberTwo35);
		// case 3 - Invalid: Identity Number 2= 12 numbers
		companyDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				invalididentityNumberTwo10);
		// case 3 - Invalid: Identity Number 2= 4 numbers + 5 Alphabets + 1 number
		companyDetailsPage.validateDSAIdentityNumberTwoInValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				invalididentityNumberTwo451);
		// case 4 - Valid: Identity Number 2= 5 Alphabets+ 4 numbers + 1 Alphabet
		companyDetailsPage.validateDSAIdentityNumberTwoValidCase("^[A-Z]{5}[0-9]{4}[A-Z]$",
				validcompanyidentityNumberTwo);

		// company details update
		Generics.refreshPage(driver);
		companyDetailsPage.clickCompanyDetails();

		ArrayList<String> companyDetails = new ArrayList<String>();
		companyDetails.add("def private");
		companyDetails.add("3030");
		companyDetails.add("Testing");
		companyDetails.add("");
		companyDetails.add("Line21");
		companyDetails.add("Line22");
		companyDetails.add("Line23");
		companyDetails.add("Karnataka");
		companyDetails.add("Pune");
		companyDetails.add("888777");

		for (int i = 0; i < companyDetails.size(); i++) {
			companyDetailsPage.editCompanyDetails(i, companyDetails.get(i), "1995", "Nov", "12");
		}
		companyDetailsPage.clickCompanyDetailsUpdateButton();
		Generics.refreshPage(driver);

		// validate company details after update
		companyDetailsPage.clickCompanyDetails();

		ArrayList<String> companyDetailsValidate = new ArrayList<String>();
		companyDetailsValidate.add("def private");
		companyDetailsValidate.add("3030");
		companyDetailsValidate.add("Testing");
		companyDetailsValidate.add("12/11/1995");
		companyDetailsValidate.add("Line21");
		companyDetailsValidate.add("Line22");
		companyDetailsValidate.add("Line23");
		companyDetailsValidate.add("Karnataka");
		companyDetailsValidate.add("Pune");
		companyDetailsValidate.add("888777");

		for (int i = 0; i < companyDetailsValidate.size(); i++) {
			companyDetailsPage.validateCompanyDetails(i, companyDetailsValidate.get(i));
		}

//		// update bank details
//
//		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
//		bankDetailsPage.clickBankDetails();
//		bankDetailsPage.clickBankDetailsEdit();
//
//		ArrayList<String> bankDetails = new ArrayList<String>();
//		bankDetails.add("5684521256");
//		bankDetails.add("SBI");
//		bankDetails.add("SBIN999");
//		bankDetails.add("Savings");
//		for (int i = 0; i < bankDetails.size(); i++) {
//			bankDetailsPage.editBankDetails(i, bankDetails.get(i));
//		}
//
//		bankDetailsPage.clickBankDetailsEditDone();
//		Generics.refreshPage(driver);
//
//		// validate bank details after update
//		bankDetailsPage.clickBankDetails();
//
//		ArrayList<String> bankDetailsValidate = new ArrayList<String>();
//		bankDetailsValidate.add("5684521256");
//		bankDetailsValidate.add("Savings");
//		bankDetailsValidate.add("SBI");
//		bankDetailsValidate.add("SBIN999");
//		for (int i = 0; i < bankDetailsValidate.size(); i++) {
//			bankDetailsPage.validateBankDetails(i, bankDetailsValidate.get(i));
//		}

		// credit answers

		CreditAnswersPage creditAnswersPage = new CreditAnswersPage(driver);
		creditAnswersPage.clickCreditAnswers();
		creditAnswersPage.clickDSAQuestionGroup1Accordion();
		ArrayList<String> creditAnswers = new ArrayList<String>();
		creditAnswers.add("50000");
		creditAnswers.add("Indian");

		for (int i = 0; i < creditAnswers.size(); i++) {
			creditAnswersPage.editCreditAnswers(i, creditAnswers.get(i));
		}
		creditAnswersPage.clickSubmit();
		Generics.refreshPage(driver);

		// Validate Credit Answers tab after update
		creditAnswersPage.clickCreditAnswers();
		creditAnswersPage.clickDSAQuestionGroup1Accordion();

		ArrayList<String> creditAnswersValidate = new ArrayList<String>();
		creditAnswersValidate.add("50000");
		creditAnswersValidate.add("Indian");

		for (int i = 0; i < creditAnswersValidate.size(); i++) {
			creditAnswersPage.validateCreditAnswers(i, creditAnswersValidate.get(i));
		}
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 12, 1, validcompanyidentityNumberOne);
		ReadWriteExcel.putData(excel_path, dsa_sheet_name, 13, 1, validcompanyidentityNumberTwo);

	}
}
