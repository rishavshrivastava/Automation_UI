package com.automationsaas.test.validatetransactionsdsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admintransaction.AwaitingTransactionsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_14_AcceptTransactionAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String adminUsername = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String adminPassword = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(adminUsername);
		loginPage.enterPassword(adminPassword);
		loginPage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickTransactions();
		homePage.clickAwaiting();
		homePage.clickTransactions();
		homePage.clickAwaiting();
		
		AwaitingTransactionsPage awaitingTransactionsPage = new AwaitingTransactionsPage(driver);
		awaitingTransactionsPage.acceptTransaction();
	}
}
 