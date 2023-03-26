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

public class TC_02_ValidateDSADashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		String dsaname  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA Name").get(1);
		dashboardPage.validateDSAName(dsaname);
		String dsaid  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
     	System.out.println();
		dashboardPage.validateDSAId(dsaid);
		dashboardPage.validateProfileStatus("Awaiting Approval");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		String last4CharsId1=Generics.getLastNCharsOfString(ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberOne").get(1), 4);
		String last4CharsId2=Generics.getLastNCharsOfString(ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberTwo").get(1), 4);	
		BasicDetailPage basicDetailPage = new BasicDetailPage(driver);
		
		ArrayList<String> basicDetails = new ArrayList<String>();
		basicDetails.add(username);
		basicDetails.add("Mr");
		basicDetails.add("Rishav");
		basicDetails.add("Shrivastava");
		basicDetails.add("12/11/1994");
		basicDetails.add("Male");
		basicDetails.add("Testing");
		basicDetails.add("12/11/1994");
		basicDetails.add("Line1");
		basicDetails.add("Line2");
		basicDetails.add("Line3");
		basicDetails.add("Sub District Per");
		basicDetails.add("District Per");
		basicDetails.add("Haryana");
		basicDetails.add("Gurgoan");
		basicDetails.add("India A");
		basicDetails.add("213190");
		basicDetails.add("14/11/2007");
		basicDetails.add("Staff Residence");
		basicDetails.add("Line1");
		basicDetails.add("Line2");
		basicDetails.add("Line3");
		basicDetails.add("Sub District");
		basicDetails.add("District");
		basicDetails.add("Karnataka");
	    basicDetails.add("City");
	    basicDetails.add("Country");
	    basicDetails.add("785452");
	    basicDetails.add("03/09/2005");
	    basicDetails.add("Double story house");
		basicDetails.add(last4CharsId1);
		basicDetails.add(last4CharsId2);
		
		for (int i=0; i<basicDetails.size(); i++) {
			basicDetailPage.validateBasicDetail(i, basicDetails.get(i));
		}
		
		CompanyDetailsPage companyDetailsPage = new CompanyDetailsPage(driver);
		companyDetailsPage.clickCompanyDetails();
		
		String last4CharscompanyId1=Generics.getLastNCharsOfString(ReadWriteExcel.getData(excel_path, dsa_sheet_name, "CompanyIdentityNumberOne").get(1), 4);
		String last4CharscompanyId2=Generics.getLastNCharsOfString(ReadWriteExcel.getData(excel_path, dsa_sheet_name, "CompanyIdentityNumberTwo").get(1), 4);	
		
		ArrayList<String> companyDetails = new ArrayList<String>();
		companyDetails.add("Perfios");
		companyDetails.add("3892");
		companyDetails.add("Testing");
		companyDetails.add("12/11/1994");
		companyDetails.add("Line123");
		companyDetails.add("Line234");
		companyDetails.add("Line345");
		companyDetails.add("Uttar Pradesh");
		companyDetails.add("Kanpur");
		companyDetails.add("785452");
		
		companyDetails.add(last4CharscompanyId1);
		companyDetails.add(last4CharscompanyId2);
		
		for (int i=0; i<companyDetails.size(); i++) {
			companyDetailsPage.validateCompanyDetails(i, companyDetails.get(i));
		}
//		
//		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
//		bankDetailsPage.clickBankDetails();
//		
//		ArrayList<String> bankDetails = new ArrayList<String>();
//		bankDetails.add("458784521485");
//		bankDetails.add("Savings");
//		bankDetails.add("SBI");
//		bankDetails.add("SBI78585");
//		
//		for (int i=0; i<bankDetails.size(); i++) {
//			bankDetailsPage.validateBankDetails(i, bankDetails.get(i));
//		}
		
		CreditAnswersPage creditAnswersPage = new CreditAnswersPage(driver);
		creditAnswersPage.clickCreditAnswers();
		creditAnswersPage.clickDSAQuestionGroup1Accordion();
		
		ArrayList<String> creditAnswers = new ArrayList<String>();
		creditAnswers.add("50000");
		creditAnswers.add("Indian");
		
		for (int i=0; i<creditAnswers.size(); i++) {
			creditAnswersPage.validateCreditAnswers(i, creditAnswers.get(i));
		}
	}
}
