package com.automationsaas.test.borrower.addressdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_006_AddressDetails_ValidateNewAddressDetailsFromDashboard extends Base {

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
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		borrowerDashboardPage.validateBorrowerId(borrowerId);
		borrowerDashboardPage.validateBorrowerName("MR RISHAV SHRIVASTAVA");
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
		employmentProfile.add("D Pillar 123");
		employmentProfile.add("Tower NA");
		employmentProfile.add("DLF Cybercity");
		employmentProfile.add("Karnataka");
		employmentProfile.add("Bangalore");
		employmentProfile.add("355218");

		for (int i = 0; i < employmentProfile.size(); i++) {
			profilePage.validateEmploymentProfile(i, employmentProfile.get(i));
		}
	}
}
