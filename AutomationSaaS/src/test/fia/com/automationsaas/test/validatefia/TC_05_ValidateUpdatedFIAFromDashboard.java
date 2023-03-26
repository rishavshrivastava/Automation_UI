
package com.automationsaas.test.validatefia;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.fia.BasicProfilePage;
import com.automationsaas.pom.fia.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_05_ValidateUpdatedFIAFromDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testing() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
		String password  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		// FIA Dashboard
		
		DashboardPage fiaDashboardPage = new DashboardPage(driver);
		
		String fiaid  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA ID").get(1);
		fiaDashboardPage.validateFIAId(fiaid);
		fiaDashboardPage.validateProfileStatus("Profile Status : Awaiting Approval");
		fiaDashboardPage.validateAccountBalance("Rs0");
		fiaDashboardPage.clickAccount();
		fiaDashboardPage.clickProfile();
		
		// basic details tab

		BasicProfilePage basicProfilePage = new BasicProfilePage(driver);
	//	basicProfilePage.clickBasicDetail();

		String updatedfiamobilenumber  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "Updated Mobile Number").get(1);
		String  identitynumberone = ReadWriteExcel.getData(excel_path, fia_sheet_name, "Identity Number One").get(1);
		String  identitynumbertwo = ReadWriteExcel.getData(excel_path, fia_sheet_name, "Identity Number two").get(1);
		
		ArrayList<String> basicProfile = new ArrayList<String>();
		
		basicProfile.add("Mrs");
		basicProfile.add("Divya");
		basicProfile.add("Sachan");
		basicProfile.add(updatedfiamobilenumber);
		basicProfile.add("Female");
		basicProfile.add("01/02/2004");
		basicProfile.add(identitynumberone);
		basicProfile.add("01/02/2004");
		basicProfile.add(identitynumbertwo);
		basicProfile.add("02/02/2004");
		basicProfile.add("ONE");
		basicProfile.add("TWO");
		//Personal Address
		basicProfile.add("Line111");
		basicProfile.add("Line222");
		basicProfile.add("Line333");
		basicProfile.add("Noida");
		basicProfile.add("Greater Noida");
		basicProfile.add("Uttar Pradesh");
		basicProfile.add("Noida");
		basicProfile.add("IND");
		basicProfile.add("208011");
		basicProfile.add("12/03/2015");
		basicProfile.add("Single Story House");
		basicProfile.add("ADDRESS_TWO");
		
		//Address One
		basicProfile.add("111");
		basicProfile.add("222");
		basicProfile.add("333");
		basicProfile.add("Bangalore Rural");
		basicProfile.add("Bangalore");
		basicProfile.add("Karnataka");
		basicProfile.add("Bangalore");
		basicProfile.add("IN");
		basicProfile.add("560001");
		basicProfile.add("02/09/2016");
		basicProfile.add("Staff Residence");
		basicProfile.add("ADDRESS_ONE");
		
		//citizen
		basicProfile.add("Bharatiya");
		

		for (int i = 0; i < basicProfile.size(); i++) {
			basicProfilePage.validateBasicProfile(i, basicProfile.get(i));
		}

	}
}
