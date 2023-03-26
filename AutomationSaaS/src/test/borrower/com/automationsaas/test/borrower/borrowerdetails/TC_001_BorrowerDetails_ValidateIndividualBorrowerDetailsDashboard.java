package com.automationsaas.test.borrower.borrowerdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_BorrowerDetails_ValidateIndividualBorrowerDetailsDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);

		borrowerDashboardPage.validateBorrowerName("MR RISHAV SHRIVASTAVA");
		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		borrowerDashboardPage.validateBorrowerId(borrowerId);

		borrowerDashboardPage.clickAccount();
		borrowerDashboardPage.clickProfile();
		
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.clickBasicProfile();
		
		//Divya
		String identityNumberOne = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Identity Number One").get(1);
		String IdentityNumberTwo = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Identity Number Two").get(1);
		
		ArrayList<String> basicProfile = new ArrayList<String>();
		basicProfile.add(username);
		basicProfile.add("Mr");
		basicProfile.add("Rishav");
		basicProfile.add("Shrivastava");
		basicProfile.add("02/03/1994");
		basicProfile.add("Male");
		basicProfile.add("Unmarried");
		basicProfile.add(identityNumberOne);
		basicProfile.add(IdentityNumberTwo);
		basicProfile.add("Test_1");
		
		for(int i=0; i<basicProfile.size(); i++) {
			profilePage.validateBasicProfile(i, basicProfile.get(i));
		}
	}
}
