package com.automationsaas.test.loan.disabledborrowerfields;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_DisabledBorrowerFields_ValidateIfBorrowerFieldsAreDisabled extends Base {

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

		borrowerDashboardPage.validateProfileStatus("Approved");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Application Approved");
		borrowerDashboardPage.clickAccount();
		borrowerDashboardPage.clickProfile();
		
		ProfilePage profilePage = new ProfilePage(driver);
		ArrayList<String> basicProfileDisabledValues = new ArrayList<String>();
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		basicProfileDisabledValues.add("true");
		profilePage.clickBasicProfile();
		for(int i=0; i<basicProfileDisabledValues.size(); i++) {
			profilePage.checkIfBasicProfileDetailsAreDisabled(i, basicProfileDisabledValues.get(i));
		}
		
		profilePage.clickPersonalProfile();
		ArrayList<String> personalProfileDisabledValues = new ArrayList<String>();
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		personalProfileDisabledValues.add("true");
		for(int i=0; i<personalProfileDisabledValues.size(); i++) {
			profilePage.checkIfPersonalProfileFieldsAreDisabled(i, personalProfileDisabledValues.get(i));
		}
		
		profilePage.clickEmploymentProfile();
		ArrayList<String> employmentProfileDisabledValues = new ArrayList<String>();
		employmentProfileDisabledValues.add("true");
		employmentProfileDisabledValues.add("true");
		employmentProfileDisabledValues.add("true");
		employmentProfileDisabledValues.add("true");
		employmentProfileDisabledValues.add("true");
		employmentProfileDisabledValues.add("true");
		employmentProfileDisabledValues.add("true");
		employmentProfileDisabledValues.add("true");
		employmentProfileDisabledValues.add("true");
		employmentProfileDisabledValues.add("true");
		for(int i=0; i<employmentProfileDisabledValues.size(); i++) {
			profilePage.checkIfEmploymentProfileFieldsAreDisabled(i, employmentProfileDisabledValues.get(i));
		}
	}
}
