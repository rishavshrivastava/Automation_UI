package com.automationsaas.test.validatefia;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.fia.BasicProfilePage;
import com.automationsaas.pom.fia.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_02_ValidateFIADashboard extends Base {

		@Test(retryAnalyzer = RetryAnalyzer.class)
		public void test() {
			driver.get("https://automationtest.sandbox.integreat.perfios.com");
			LoginPage loginPage = new LoginPage(driver);
			String username  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
			String password  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
			System.out.println(username);
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
			loginPage.clickLogin();
			
			DashboardPage fiaDashboardPage = new DashboardPage(driver);
			String fianame  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA Name").get(1).toUpperCase();
			fiaDashboardPage.validateFIAName(fianame);
			String fiaid  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA ID").get(1);
			fiaDashboardPage.validateFIAId(fiaid);
			fiaDashboardPage.validateProfileStatus("Profile Status : Awaiting Approval");
			fiaDashboardPage.validateAccountBalance("Rs0");
			fiaDashboardPage.clickAccount();
			fiaDashboardPage.clickProfile();
			
			BasicProfilePage basicProfilePage = new BasicProfilePage(driver);
			
			String fiamobilenumber  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MobileNumber").get(1);
			String  identitynumberone = ReadWriteExcel.getData(excel_path, fia_sheet_name, "Identity Number One").get(1);
			String identitynumbertwo  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "Identity Number Two").get(1);
			
			ArrayList<String> basicProfile = new ArrayList<String>();
			basicProfile.add("Mr");
			basicProfile.add("Chandrashekhar");
			basicProfile.add("Yaragall");
			basicProfile.add(fiamobilenumber);
			basicProfile.add("Male");
			basicProfile.add("01/01/2004");
			basicProfile.add(identitynumberone);
			basicProfile.add("01/01/2004");
			basicProfile.add(identitynumbertwo);
			basicProfile.add("01/01/2004");
			basicProfile.add("TestOne");
			basicProfile.add("TestTwo");
			//Personal Address
			basicProfile.add("Line1");
			basicProfile.add("Line2");
			basicProfile.add("Line3");
			basicProfile.add("Sub District");
			basicProfile.add("District");
			basicProfile.add("Karnataka");
			basicProfile.add("City");
			basicProfile.add("Country");
			basicProfile.add("785452");
			basicProfile.add("03/09/2016");
			basicProfile.add("Double story house");
			basicProfile.add("ADDRESS");
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
			basicProfile.add("INDIAN");
		
			
			for (int i=0; i<basicProfile.size(); i++) {
				basicProfilePage.validateBasicProfile(i, basicProfile.get(i));
			}
		}			
}
