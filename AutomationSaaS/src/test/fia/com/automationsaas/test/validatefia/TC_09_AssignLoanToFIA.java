package com.automationsaas.test.validatefia;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_09_AssignLoanToFIA extends Base {

	@Test  (retryAnalyzer = RetryAnalyzer.class)
	public void validateAssignLoanToFIA() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickLoanApplications();
		homePage.clickLoanApplicationsInitialized();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String LoanID = loanApplicationsPage.getLoanId();
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 9, 1, LoanID);
		loanApplicationsPage.clickLoanId();
		loanApplicationsPage.clickAction();
		loanApplicationsPage.clickLoanApplicationAssignToFIA();
		String fiaid  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA ID").get(1);
		loanApplicationsPage.selectFIA(fiaid);
		loanApplicationsPage.clickLoanApplicationAssignToFia();
	}
}
