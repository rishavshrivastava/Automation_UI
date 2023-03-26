package com.automationsaas.test.investor.addressdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investor.PersonalProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_009_AddressDetails_AddNewAddressFromDashboardAndValidate extends Base {

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
		personalProfile.add("Stu151");
		personalProfile.add("Vwx161");
		personalProfile.add("Yza171");
		personalProfile.add("Uttar Pradesh");
		personalProfile.add("Bhopal");
		personalProfile.add("892435");

		for (int i = 0; i < personalProfile.size(); i++) {
			personalProfilePage.editPersonalProfile(i, personalProfile.get(i));
		}
		personalProfilePage.clickPersonalProfileUpdate();
		
		ArrayList<String> validatepersonalProfile = new ArrayList<String>();
		validatepersonalProfile.add("50000.00");
		validatepersonalProfile.add("50000.00");
		validatepersonalProfile.add("Testing");
		validatepersonalProfile.add("Stu151");
		validatepersonalProfile.add("Vwx161");
		validatepersonalProfile.add("Yza171");
		validatepersonalProfile.add("Uttar Pradesh");
		validatepersonalProfile.add("Bhopal");
		validatepersonalProfile.add("892435");

		for (int i = 0; i < personalProfile.size(); i++) {
			personalProfilePage.validatePersonalProfile(i, personalProfile.get(i));
		}
}
}
