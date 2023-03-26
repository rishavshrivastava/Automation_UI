package com.automationsaas.test.borrower.profileinfo;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_ProfileInfo_UpdateAndValidateBorrowerDetailsDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void updateBorrower() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		borrowerDashboardPage.validateBorrowerId(borrowerId);
		borrowerDashboardPage.validateBorrowerName("MR RISHAV SHRIVASTAVA");
		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Initialized");

		borrowerDashboardPage.clickAccount();
		borrowerDashboardPage.clickProfile();

		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.clickPersonalProfile();
		
		ArrayList<String> personalProfile = new ArrayList<String>();
		personalProfile.add("2 Years");
		personalProfile.add("Permanent");
		personalProfile.add("50,000");
		for (int i = 0; i < personalProfile.size(); i++) {
			profilePage.editPersonalProfile(i, personalProfile.get(i));
		}
		profilePage.updatePersonalProfile();

		// Validate Personal Profile
		Generics.refreshPage(driver);
		profilePage.clickPersonalProfile();
		ArrayList<String> updatedPersonalProfile = new ArrayList<String>();
		updatedPersonalProfile.add("2 Years");
		updatedPersonalProfile.add("Permanent");
		updatedPersonalProfile.add("50,000");

		for (int i = 0; i < updatedPersonalProfile.size(); i++) {
			profilePage.validatePersonalProfile(i, updatedPersonalProfile.get(i));
		}
	}
}
