package com.automationsaas.test.loan.disabledinvestorfields;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.BasicProfilePage;
import com.automationsaas.pom.investor.CreditAnswersPage;
import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investor.PersonalProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_DisabledInvestorFields_ValidateIfInvestorFieldsAreDisabled extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		String investorId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor ID").get(1);
		dashboardPage.validateInvestorID(investorId);
		dashboardPage.validateProfileStatus("Approved");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.validateEmailVerificationLinks();
		dashboardPage.validatePhoneNumberVerificationLinks();
		dashboardPage.validateDepositButton();
		dashboardPage.validateWithdrawButton();
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		
		BasicProfilePage basicProfilePage = new BasicProfilePage(driver);
		ArrayList<String> basicProfileDisabledValues = new ArrayList<String>();
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		for(int i=0; i<basicProfileDisabledValues.size(); i++) {
			basicProfilePage.checkIfBasicProfileFieldsAreDisabled(i, basicProfileDisabledValues.get(i));
		}
		
		PersonalProfilePage personalProfilePage = new PersonalProfilePage(driver);
		personalProfilePage.clickPersonalProfile();
		ArrayList<String> personalProfileDisabledValues = new ArrayList<String>();
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		for(int i=0;i<personalProfileDisabledValues.size();i++) {
			personalProfilePage.checkIfPersonalProfilePageAreDisabled(i, personalProfileDisabledValues.get(i));
		}
		
		CreditAnswersPage creditAnswersPage = new CreditAnswersPage(driver);
		creditAnswersPage.clickCreditAnswers();
		creditAnswersPage.clickCreditAnswersAccordion();
		ArrayList<String> creditAnswersDisabledValues = new ArrayList<String>();
		creditAnswersDisabledValues.add("true");
		creditAnswersDisabledValues.add("true");
		for(int i=0;i<creditAnswersDisabledValues.size();i++) {
			creditAnswersPage.checkIfCreditAnswersFieldsAreDisabled(i, creditAnswersDisabledValues.get(i));
		}
	}
}
