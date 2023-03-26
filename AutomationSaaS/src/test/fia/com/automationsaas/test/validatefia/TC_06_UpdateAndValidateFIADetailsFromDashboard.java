package com.automationsaas.test.validatefia;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminfia.FIADetailsPage;
import com.automationsaas.pom.fia.DashboardPage;
import com.automationsaas.pom.fia.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_06_UpdateAndValidateFIADetailsFromDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateAssignLoanToFIA() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();
		
		String fiaid  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA ID").get(1);

		ProfilePage profilePage = new ProfilePage(driver);
		ArrayList<String> profilePageDetails = new ArrayList<String>();
		profilePageDetails.add("Mr");
		profilePageDetails.add(fiaid);
		//profilePageDetails.add("Chandrashekhar Y");
		profilePageDetails.add("FIA");
		String phoneNumber = Generics.getRandomNumber(10);
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 8, 1, phoneNumber);
		System.out.println(phoneNumber);
		profilePageDetails.add(phoneNumber);
		profilePageDetails.add("Male");
		profilePageDetails.add("112043792667");
		profilePageDetails.add("INFIA1887I");
		profilePageDetails.add("TextVariableOne");
		profilePageDetails.add("TextVariableTwo");
		profilePageDetails.add("Line11");
		profilePageDetails.add("Line22");
		profilePageDetails.add("Line33");
		profilePageDetails.add("Mysore Rural");
		profilePageDetails.add("Mysore");
		profilePageDetails.add("Karnataka");
		profilePageDetails.add("Mysore");
		profilePageDetails.add("India");
		profilePageDetails.add("50001");
		profilePageDetails.add("");
		profilePageDetails.add("Staff Residence");
		profilePageDetails.add("Address");
		profilePageDetails.add("Bharat");
		

		for (int i = 0; i < profilePageDetails.size(); i++) {
			profilePage.editBasicProfile(i, profilePageDetails.get(i),"2015", "Mar", "11");
		}
		
		FIADetailsPage fiaDetailsPage = new FIADetailsPage(driver);
		fiaDetailsPage.selectDateOfBirth("2004", "Apr", "1");
		fiaDetailsPage.selectIdentityNumberOneIssueDate("2004", "Apr", "2");
		fiaDetailsPage.selectIdentityNumberTwoIssueDate("2004", "Apr", "3");
		
		profilePage.clickUpdate();
		
		profilePageDetails.add("");
		profilePageDetails.add("");
		profilePageDetails.add("");
		
		for (int i = 0; i < profilePageDetails.size(); i++) {
			profilePage.validateBasicprofile(i, profilePageDetails.get(i),"11/03/2015","01/04/2004","02/04/2004","03/04/2004");
		}
	}
}
