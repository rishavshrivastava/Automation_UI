package com.automationsaas.test.validatedsa.addressdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.BasicDetailPage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_004_Addressdetails_ValidateNewAddressDetailsFromDashboard extends Base {

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

		DashboardPage dashboardPage = new DashboardPage(driver);
		String dsaid = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		dashboardPage.validateDSAId(dsaid);
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		String last4CharsId1 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberOne").get(1), 4);
		String last4CharsId2 = Generics.getLastNCharsOfString(
				ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberTwo").get(1), 4);
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
		basicDetails.add("First line 123");
		basicDetails.add("Second Line 234");
		basicDetails.add("Third Line 345");
		basicDetails.add("Koramangla");
		basicDetails.add("Indira Nagar");
		basicDetails.add("Karnataka");
		basicDetails.add("Bhopal");
		basicDetails.add("India A");
		basicDetails.add("534087");
		basicDetails.add("18/12/2015");
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

		for (int i = 0; i < basicDetails.size(); i++) {
			basicDetailPage.validateBasicDetail(i, basicDetails.get(i));
		}
	}
}
