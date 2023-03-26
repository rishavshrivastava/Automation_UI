package com.automationsaas.test.validatedsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.DSAContractsPage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_08b_ValidateDSAAcceptRejectContract extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateDSAAcceptRejectContract() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// DSA Dash-board
		DashboardPage dashboardPage = new DashboardPage(driver);
		String dsaid = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		dashboardPage.validateDSAId(dsaid);
		dashboardPage.validateProfileStatus("Approved");

		// DSA Contracts
		DSAContractsPage dsacontractspage = new DSAContractsPage(driver);
		dsacontractspage.clickViewDetails();

		// DSA Accept Contract - Loan General Term
		dsacontractspage.clickLoanGeneralTermContract();
		dsacontractspage.clickAcceptContract();

		// DSA Reject Contract - Bid Contract
		dsacontractspage.clickViewDetails();
		dsacontractspage.clickBidContract();
		dsacontractspage.clickRejectContract();

	}
}
