package com.automationsaas.test.validatetransactionsdsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_13_WithdrawAmountDSADashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void transactionFromBorrowerSide() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String borrowerUsername = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String borrowerPassword = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		loginPage.enterUsername(borrowerUsername);
		loginPage.enterPassword(borrowerPassword);
		loginPage.clickLogin();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		String borrowerId = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		dashboardPage.validateDSAId(borrowerId);
		dashboardPage.validateAccountBalance("Rs15,000");
		
		dashboardPage.clickWithdraw();
		dashboardPage.enterWithdrawAmount("5000");
		dashboardPage.clickWithdrawButton();
		dashboardPage.validateAccountBalance("Rs15,000");
	}
} 
