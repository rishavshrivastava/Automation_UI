
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

public class TC_05_ValidateUpdatedDSAFromDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testing() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// DSA Dashboard
		DashboardPage dsaDashboardPage = new DashboardPage(driver);
		dsaDashboardPage.validateProfileStatus("Awaiting Approval");
		dsaDashboardPage.validateAccountBalance("Rs0");
		dsaDashboardPage.clickAccount();
		dsaDashboardPage.clickProfile();

		String last4CharsId1 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberOne").get(1), 4);
		String last4CharsId2 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberTwo").get(1), 4);
		// basic details tab

		BasicDetailPage basicDetailsPage = new BasicDetailPage(driver);
		basicDetailsPage.clickBasicDetail();

		ArrayList<String> basicProfile = new ArrayList<String>();
		basicProfile.add(username);
		basicProfile.add("Mrs");
		basicProfile.add("Divya");
		basicProfile.add("Sachan");
		basicProfile.add("10/06/1996");
		basicProfile.add("Female");
		basicProfile.add("Test");
		basicProfile.add("10/06/1996");
		basicProfile.add("Line1");
		basicProfile.add("Line2");
		basicProfile.add("Line3");
		basicProfile.add("Sub District Per");
		basicProfile.add("District Per");
		basicProfile.add("Haryana");
		basicProfile.add("Gurgoan");
		basicProfile.add("India A");
		basicProfile.add("213190");
		basicProfile.add("14/11/2007");
		basicProfile.add("Staff Residence");
		basicProfile.add("Line1");
		basicProfile.add("Line2");
		basicProfile.add("Line3");
		basicProfile.add("Sub District");
		basicProfile.add("District");
		basicProfile.add("Karnataka");
		basicProfile.add("City");
		basicProfile.add("Country");
		basicProfile.add("785452");
		basicProfile.add("03/09/2005");
		basicProfile.add("Double story house");
		basicProfile.add(last4CharsId1);
		basicProfile.add(last4CharsId2);

		for (int i = 0; i < basicProfile.size(); i++) {
			basicDetailsPage.validateBasicDetail(i, basicProfile.get(i));
		}

		String last4CharscompanyId1 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "CompanyIdentityNumberOne").get(1), 4);
		String last4CharscompanyId2 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "CompanyIdentityNumberTwo").get(1), 4);
		// Company details tab

		CompanyDetailsPage companyDetailsPage = new CompanyDetailsPage(driver);
		companyDetailsPage.clickCompanyDetails();

		ArrayList<String> companyDetails = new ArrayList<String>();
		companyDetails.add("abc software");
		companyDetails.add("2020");
		companyDetails.add("Test");
		companyDetails.add("10/06/1996");
		companyDetails.add("Line11");
		companyDetails.add("Line12");
		companyDetails.add("Line13");
		companyDetails.add("Uttar Pradesh");
		companyDetails.add("Bangalore");
		companyDetails.add("123123");
		companyDetails.add(last4CharscompanyId1);
		companyDetails.add(last4CharscompanyId2);

		for (int i = 0; i < companyDetails.size(); i++) {
			companyDetailsPage.validateCompanyDetails(i, companyDetails.get(i));
		}

//		// Bank Details tab
//
//		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
//		bankDetailsPage.clickBankDetails();
//
//		ArrayList<String> bankDetails = new ArrayList<String>();
//		bankDetails.add("123456789");
//		bankDetails.add("Current");
//		bankDetails.add("SBITest");
//		bankDetails.add("SBINTest");
//		for (int i = 0; i < bankDetails.size(); i++) {
//			bankDetailsPage.validateBankDetails(i, bankDetails.get(i));
//		}

		// Credit Answers tab

		CreditAnswersPage creditAnswersPage = new CreditAnswersPage(driver);
		creditAnswersPage.clickCreditAnswers();
		creditAnswersPage.clickDSAQuestionGroup1Accordion();

		ArrayList<String> creditAnswers = new ArrayList<String>();
		creditAnswers.add("10000");
		creditAnswers.add("Dubai");

		for (int i = 0; i < creditAnswers.size(); i++) {
			creditAnswersPage.validateCreditAnswers(i, creditAnswers.get(i));
		}
	}
}
