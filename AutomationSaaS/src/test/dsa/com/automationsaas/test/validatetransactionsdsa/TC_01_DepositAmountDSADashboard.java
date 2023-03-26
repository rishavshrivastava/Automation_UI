package com.automationsaas.test.validatetransactionsdsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_01_DepositAmountDSADashboard extends Base {

		@Test(retryAnalyzer = RetryAnalyzer.class)
		public void transactionFromDSASide() {
			driver.get("https://automationtest.sandbox.integreat.perfios.com");
			LoginPage loginPage = new LoginPage(driver);
			String username  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
			String password  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
			System.out.println(username);
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
			loginPage.clickLogin();
			
			
			// DSA Dashboard
			DashboardPage dashboardPage = new DashboardPage(driver);
			String dsaid  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
			dashboardPage.validateDSAId(dsaid);
			
			//Deposit Transactions
			dashboardPage.clickDeposit();
			dashboardPage.enterDepositAmount("15000");
			dashboardPage.clickDepositButton();
			dashboardPage.validateAccountBalance("Rs0");
		}
	}

