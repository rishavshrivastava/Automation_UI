package com.automationsaas.test.investor.employmenthistory;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investor.EmploymentDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_EmploymentHistory_UpdateAndValidateInvestorDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
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
		dashboardPage.validateProfileStatus("Completed");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.validateEmailVerificationLinks();
		dashboardPage.validatePhoneNumberVerificationLinks();
		dashboardPage.validateDepositButton();
		dashboardPage.validateWithdrawButton();
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();
		
		EmploymentDetailsPage employmentDetailsPage = new EmploymentDetailsPage(driver);
		employmentDetailsPage.clickEmploymentDetails();
		
		ArrayList<String> employmentDetails = new ArrayList<String>();
		employmentDetails.add("Developer");
		employmentDetails.add("Fintech");
		employmentDetails.add("Customer");
		employmentDetails.add("Developer");

		for (int i = 0; i < employmentDetails.size(); i++) {
			employmentDetailsPage.editEmploymentDetails(i, employmentDetails.get(i));
		}
		
		employmentDetailsPage.clickEmploymentDetailsUpdate();
		
		//Validate Updated Employment Details
		Generics.refreshPage(driver);
		employmentDetailsPage.clickEmploymentDetails();
		ArrayList<String> updatedEmploymentDetails = new ArrayList<String>();
		updatedEmploymentDetails.add("Developer");
		updatedEmploymentDetails.add("Fintech");
		updatedEmploymentDetails.add("Customer");
		updatedEmploymentDetails.add("Developer");

		for (int i = 0; i < updatedEmploymentDetails.size(); i++) {
			employmentDetailsPage.validateEmploymentDetails(i, updatedEmploymentDetails.get(i));
		}
	}
}