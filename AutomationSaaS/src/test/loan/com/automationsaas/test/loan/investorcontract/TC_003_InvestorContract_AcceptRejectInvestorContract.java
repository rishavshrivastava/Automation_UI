package com.automationsaas.test.loan.investorcontract;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investor.LoanContractListPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_InvestorContract_AcceptRejectInvestorContract extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
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
		dashboardPage.validateProfileStatus("Approved");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.validateEmailVerificationLinks();
		dashboardPage.validatePhoneNumberVerificationLinks();
		dashboardPage.validateDepositButton();
		dashboardPage.validateWithdrawButton();
		
		LoanContractListPage loanContractListPage = new LoanContractListPage(driver);
		dashboardPage.clickViewContract();
		loanContractListPage.acceptRejectContract(0, "Accept");
		
		dashboardPage.clickViewContract();
		loanContractListPage.acceptRejectContract(0, "Reject");
		
		dashboardPage.clickViewContract();
		loanContractListPage.acceptRejectContract(0, "Accept");
		
		dashboardPage.clickViewContract();
		loanContractListPage.acceptRejectContract(0, "Reject");
		
		dashboardPage.clickViewContract();
		loanContractListPage.acceptRejectContract(0, "Accept");
		
		dashboardPage.clickViewContract();
		loanContractListPage.acceptRejectContract(0, "Reject");
		
		dashboardPage.clickViewContract();
		loanContractListPage.acceptRejectContract(0, "Accept");
	}
}
