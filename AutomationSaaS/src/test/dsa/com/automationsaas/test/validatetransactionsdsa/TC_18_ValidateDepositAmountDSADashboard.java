package com.automationsaas.test.validatetransactionsdsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;

public class TC_18_ValidateDepositAmountDSADashboard extends Base {

	@Test
	public void transactionFromDsaSide() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		 String username  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		 String password  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1); 
		 System.out.println(username);
		 loginPage.enterUsername(username);
		 loginPage.enterPassword(password);
		 loginPage.clickLogin(); 
		
		 DashboardPage dashboardPage = new DashboardPage(driver);
         String dsaid  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
         dashboardPage.validateDSAId(dsaid);
         dashboardPage.validateAccountBalance("Rs25,000");
}
}