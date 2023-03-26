package com.automationsaas.test.investor.addressdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investor.PersonalProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_AddressDetails_UpdateNewlyAddedAddressAndValidateFromDashboard extends Base {

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
	
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		PersonalProfilePage personalProfilePage = new PersonalProfilePage(driver);
		personalProfilePage.clickPersonalProfile();
		
		ArrayList<String> personalProfile = new ArrayList<String>();
		personalProfile.add("50000.00");
		personalProfile.add("50000.00");
		personalProfile.add("Testing");
		personalProfile.add("Jkl121");
		personalProfile.add("Mno131");
		personalProfile.add("Pqr141");
		personalProfile.add("Uttar Pradesh");
		personalProfile.add("Lucknow");
		personalProfile.add("342678");

		for (int i = 0; i < personalProfile.size(); i++) {
			personalProfilePage.editPersonalProfile(i, personalProfile.get(i));
		}
		
		personalProfilePage.clickPersonalProfileUpdate();
		
		//Validate Updated Personal Profile
		Generics.refreshPage(driver);
		personalProfilePage.clickPersonalProfile();
		ArrayList<String> updatedPersonalProfile = new ArrayList<String>();
		updatedPersonalProfile.add("50000.00");
		updatedPersonalProfile.add("50000.00");
		updatedPersonalProfile.add("Testing");
		updatedPersonalProfile.add("Jkl121");
		updatedPersonalProfile.add("Mno131");
		updatedPersonalProfile.add("Pqr141");
		updatedPersonalProfile.add("Uttar Pradesh");
		updatedPersonalProfile.add("Lucknow");
		updatedPersonalProfile.add("342678");

		for (int i = 0; i < updatedPersonalProfile.size(); i++) {
			personalProfilePage.validatePersonalProfile(i, updatedPersonalProfile.get(i));
		}
}}
