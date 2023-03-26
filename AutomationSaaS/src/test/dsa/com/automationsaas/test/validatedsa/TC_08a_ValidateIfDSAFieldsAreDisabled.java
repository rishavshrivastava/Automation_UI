package com.automationsaas.test.validatedsa;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.BasicDetailPage;
import com.automationsaas.pom.dsa.CompanyDetailsPage;
import com.automationsaas.pom.dsa.CreditAnswersPage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_08a_ValidateIfDSAFieldsAreDisabled extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// DSA Dashboard

		DashboardPage dashboardPage = new DashboardPage(driver);

		String dsaid = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		dashboardPage.validateDSAId(dsaid);
		dashboardPage.validateProfileStatus("Approved");
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		BasicDetailPage basicdetailtab = new BasicDetailPage(driver);
		ArrayList<String> basicDetailDisabledValues = new ArrayList<String>();
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");
		basicDetailDisabledValues.add("true");

		for (int i = 0; i < basicDetailDisabledValues.size(); i++) {
			basicdetailtab.checkIfBasicDetailsAreDisabled(i, basicDetailDisabledValues.get(i));
		}

		// company details tab

		CompanyDetailsPage companyDetailsTab = new CompanyDetailsPage(driver);
		companyDetailsTab.clickCompanyDetails();

		ArrayList<String> companyDetailsDisabledValues = new ArrayList<String>();
		companyDetailsDisabledValues.add("true");
		companyDetailsDisabledValues.add("true");
		companyDetailsDisabledValues.add("true");
		companyDetailsDisabledValues.add("true");
		companyDetailsDisabledValues.add("true");
		companyDetailsDisabledValues.add("true");
		companyDetailsDisabledValues.add("true");
		companyDetailsDisabledValues.add("true");
		companyDetailsDisabledValues.add("true");
		companyDetailsDisabledValues.add("true");

		for (int i = 0; i < companyDetailsDisabledValues.size(); i++) {
			companyDetailsTab.checkIfCompanyDetailsAreDisabled(i, companyDetailsDisabledValues.get(i));
		}

		// Credit Answer tab

		CreditAnswersPage creditAnswersTab = new CreditAnswersPage(driver);
		creditAnswersTab.clickCreditAnswers();
		creditAnswersTab.clickDSAQuestionGroup1Accordion();

		ArrayList<String> creditAnswersDisabledValues = new ArrayList<String>();
		creditAnswersDisabledValues.add("true");
		creditAnswersDisabledValues.add("true");

		for (int i = 0; i < creditAnswersDisabledValues.size(); i++) {
			creditAnswersTab.checkIfCreditAnswersAreDisabled(i, creditAnswersDisabledValues.get(i));
		}

	}
}
