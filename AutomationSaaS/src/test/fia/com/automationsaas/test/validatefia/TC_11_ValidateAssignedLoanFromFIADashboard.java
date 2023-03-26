package com.automationsaas.test.validatefia;

import org.testng.annotations.Test;
import com.automationsaas.pom.fia.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_11_ValidateAssignedLoanFromFIADashboard extends Base {
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyAssignLoanFromFIADashboard() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
		String password  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		DashboardPage fiaDashboardPage = new DashboardPage(driver);
		String fiaid  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA ID").get(1);
		fiaDashboardPage.validateFIAId(fiaid);
		fiaDashboardPage.clickOnLoanDetailsLink();
		fiaDashboardPage.validateLoanIDassignedtoFIA(ReadWriteExcel.getData(excel_path, fia_sheet_name, "Assigned Loan ID").get(1));
	}
}

