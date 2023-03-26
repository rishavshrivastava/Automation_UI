package com.automationsaas.test.investor.investordetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.BasicProfilePage;
import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_InvestorDetails_UpdateAndValidateInvestorDashboard extends Base {

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
		dashboardPage.validateProfileStatus("Completed");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.validateEmailVerificationLinks();
		dashboardPage.validatePhoneNumberVerificationLinks();
		dashboardPage.validateDepositButton();
		dashboardPage.validateWithdrawButton();
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		BasicProfilePage basicProfilePage = new BasicProfilePage(driver);
		basicProfilePage.clickBasicProfile();
		String phoneNumber = Generics.getRandomNumber(10);
		ArrayList<String> basicProfile = new ArrayList<String>();
		basicProfile.add("Mrs");
		basicProfile.add("Rishu");
		basicProfile.add("Shriva");
		basicProfile.add("");
		basicProfile.add("Female");
		basicProfile.add("Married");
		basicProfile.add(phoneNumber);
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 4, 1, phoneNumber);
		basicProfile.add("154254754525");
		basicProfile.add("BGDJY7865G");
		basicProfile.add("Category 1");
		basicProfile.add("Development");

		for (int i = 0; i < basicProfile.size(); i++) {
			basicProfilePage.editBasicProfile(i, basicProfile.get(i), "1995", "Jun", "6");
		}

		basicProfilePage.clickBasicProfileUpdate();
		
		//Validate Updated Basic Profile
		Generics.refreshPage(driver);
		basicProfilePage.clickBasicProfile();
		ArrayList<String> updatedBasicProfile = new ArrayList<String>();
		updatedBasicProfile.add(username);
		updatedBasicProfile.add("Mrs");
		updatedBasicProfile.add("Rishu");
		updatedBasicProfile.add("Shriva");
		updatedBasicProfile.add("6/6/1995");
		updatedBasicProfile.add("Female");
		updatedBasicProfile.add("Married");
		updatedBasicProfile.add(phoneNumber);
		updatedBasicProfile.add("xxxxxxxx4525");
		updatedBasicProfile.add("xxxxxx865G");
		updatedBasicProfile.add("Category 1");
		updatedBasicProfile.add("Development");

		for (int i = 0; i < updatedBasicProfile.size(); i++) {
			basicProfilePage.validateBasicProfile(i, updatedBasicProfile.get(i));
		}
		
		//Validate Updated Basic fields with negative scenarios (Temporary)
		basicProfilePage.clickBasicProfile();
		ArrayList<String> basicProfile2 = new ArrayList<String>();
		basicProfile2.add("Mrs");
		basicProfile2.add("Rishu");
		basicProfile2.add("Shriva");
		basicProfile2.add("");
		basicProfile2.add("Female");
		basicProfile2.add("Married");
		basicProfile2.add(phoneNumber);
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 4, 1, phoneNumber);
		basicProfile2.add("15425475452");
		basicProfile2.add("BGDJ87865G");
		basicProfile2.add("Category 1");
		basicProfile2.add("Development");

		for (int i = 0; i < basicProfile.size(); i++) {
			basicProfilePage.editBasicProfile(i, basicProfile2.get(i), "1995", "Jun", "6");
		}
		basicProfilePage.clickUpdateToValidateWrongIdentityNumbers();
		
		Generics.refreshPage(driver);
		basicProfilePage.clickBasicProfile();
		ArrayList<String> basicProfile3 = new ArrayList<String>();
		basicProfile3.add("Mrs");
		basicProfile3.add("Rishu");
		basicProfile3.add("Shriva");
		basicProfile3.add("");
		basicProfile3.add("Female");
		basicProfile3.add("Married");
		basicProfile3.add(phoneNumber);
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 4, 1, phoneNumber);
		basicProfile3.add("1542547545254");
		basicProfile3.add("BGDJYG786G");
		basicProfile3.add("Category 1");
		basicProfile3.add("Development");

		for (int i = 0; i < basicProfile.size(); i++) {
			basicProfilePage.editBasicProfile(i, basicProfile3.get(i), "1995", "Jun", "6");
		}
		basicProfilePage.clickUpdateToValidateWrongIdentityNumbers();
		
		Generics.refreshPage(driver);
		basicProfilePage.clickBasicProfile();
		ArrayList<String> basicProfile4 = new ArrayList<String>();
		basicProfile4.add("Mrs");
		basicProfile4.add("Rishu");
		basicProfile4.add("Shriva");
		basicProfile4.add("");
		basicProfile4.add("Female");
		basicProfile4.add("Married");
		basicProfile4.add(phoneNumber);
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 4, 1, phoneNumber);
		basicProfile4.add("HSYSGHDRTYGF");
		basicProfile4.add("76385TYDF");
		basicProfile4.add("Category 1");
		basicProfile4.add("Development");

		for (int i = 0; i < basicProfile.size(); i++) {
			basicProfilePage.editBasicProfile(i, basicProfile4.get(i), "1995", "Jun", "6");
		}
		basicProfilePage.clickUpdateToValidateWrongIdentityNumbers();
		
		Generics.refreshPage(driver);
		basicProfilePage.clickBasicProfile();
		String updatedphoneNumber = Generics.getRandomNumber(10);
		ArrayList<String> basicProfile5 = new ArrayList<String>();
		basicProfile5.add("Mrs");
		basicProfile5.add("Rishu");
		basicProfile5.add("Shriva");
		basicProfile5.add("");
		basicProfile5.add("Female");
		basicProfile5.add("Married");
		basicProfile5.add(updatedphoneNumber);
		ReadWriteExcel.putData(excel_path, investor_sheet_name, 4, 1, updatedphoneNumber);
		basicProfile5.add("154254754525");
		basicProfile5.add("BGDJY7865G");
		basicProfile5.add("Category 1");
		basicProfile5.add("Development");

		for (int i = 0; i < basicProfile.size(); i++) {
			basicProfilePage.editBasicProfile(i, basicProfile5.get(i), "1995", "Jun", "6");
		}

		basicProfilePage.clickBasicProfileUpdate();
		
		//Validate Updated Basic Profile
		Generics.refreshPage(driver);
		basicProfilePage.clickBasicProfile();
		ArrayList<String> updatedBasicProfile2 = new ArrayList<String>();
		updatedBasicProfile2.add(username);
		updatedBasicProfile2.add("Mrs");
		updatedBasicProfile2.add("Rishu");
		updatedBasicProfile2.add("Shriva");
		updatedBasicProfile2.add("6/6/1995");
		updatedBasicProfile2.add("Female");
		updatedBasicProfile2.add("Married");
		updatedBasicProfile2.add(updatedphoneNumber);
		updatedBasicProfile2.add("xxxxxxxx4525");
		updatedBasicProfile2.add("xxxxxx865G");
		updatedBasicProfile2.add("Category 1");
		updatedBasicProfile2.add("Development");
		basicProfilePage.clickBasicProfile();
		for (int i = 0; i < updatedBasicProfile.size(); i++) {
			basicProfilePage.validateBasicProfile(i, updatedBasicProfile2.get(i));
		}
	}
}