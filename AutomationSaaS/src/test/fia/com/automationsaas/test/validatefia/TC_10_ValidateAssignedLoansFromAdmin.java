package com.automationsaas.test.validatefia;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminfia.AssignedLoansPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_10_ValidateAssignedLoansFromAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateAssignLoanToFIA() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickFIA();
		homePage.clickFIAAll();
		homePage.fiaEmailsList();
		
		AssignedLoansPage assignedLoansPage = new AssignedLoansPage(driver);
		
		assignedLoansPage.clickAppliedLoans();
		assignedLoansPage.clickRecentLoanApplicationsAccordion();
		assignedLoansPage.clickViewDetails();
	}
}
