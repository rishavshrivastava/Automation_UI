package com.automationsaas.test.validatedsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_07a_ValidateDSAShouldNotAbleToApplyLoanWithoutApproveFromAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateDSAShouldNotAbleToApplyLoanWithoutApproveFromAdmin() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.validateDSAStatus("APPROVED");
		dashboardPage.validateApplyLoanMenu("Apply For Loan");
	}

}
