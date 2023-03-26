package com.automationsaas.test.borrower.employmenthistoryinfo;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_EmploymentHistoryInfo_UpdateAndValidateBorrowerDetailsDashboard extends Base {

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

		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Initialized");

		borrowerDashboardPage.clickAccount();
		borrowerDashboardPage.clickProfile();

		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.clickEmploymentProfile();
		ArrayList<String> employmentProfile = new ArrayList<String>();
		employmentProfile.add("Perfios");
		employmentProfile.add("Technology");
		employmentProfile.add("QA");
		employmentProfile.add("Per785");
		employmentProfile.add("Line1");
		employmentProfile.add("Line2");
		employmentProfile.add("Line3");
		employmentProfile.add("Karnataka");
		employmentProfile.add("Bangalore");
		employmentProfile.add("560090");
		for (int i = 0; i < employmentProfile.size(); i++) {
			profilePage.editEmploymentProfile(i, employmentProfile.get(i));
		}
		profilePage.updateEmploymentProfile();

		// Validate Employment Profile
		profilePage.clickEmploymentProfile();
		ArrayList<String> updatedEmploymentProfile = new ArrayList<String>();
		updatedEmploymentProfile.add("Perfios");
		updatedEmploymentProfile.add("Technology");
		updatedEmploymentProfile.add("QA");
		updatedEmploymentProfile.add("Per785");
		updatedEmploymentProfile.add("Line1");
		updatedEmploymentProfile.add("Line2");
		updatedEmploymentProfile.add("Line3");
		updatedEmploymentProfile.add("Karnataka");
		updatedEmploymentProfile.add("Bangalore");
		updatedEmploymentProfile.add("560090");

		for (int i = 0; i < updatedEmploymentProfile.size(); i++) {
			profilePage.validateEmploymentProfile(i, updatedEmploymentProfile.get(i));
		}
	}
}
