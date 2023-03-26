package com.automationsaas.test.loan.borrowercontract;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanContractListPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_BorrowerContract_AcceptRejectBorrowerContract extends Base {
	
	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void acceptContract() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
		LoginPage loginPage = new LoginPage(driver);
		String borrowerUsername = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String borrowerPassword = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(borrowerUsername);
		loginPage.enterPassword(borrowerPassword);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);
		borrowerDashboardPage.validateProfileStatus("Approved");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Application Approved");
		
		LoanContractListPage loanContractListPage = new LoanContractListPage(driver);
		borrowerDashboardPage.clickViewAndAcceptContract();
		loanContractListPage.acceptRejectContract(0, "Accept");
		
		borrowerDashboardPage.clickViewAndAcceptContract();
		loanContractListPage.acceptRejectContract(0, "Reject");
		
		borrowerDashboardPage.clickViewAndAcceptContract();
		loanContractListPage.acceptRejectContract(0, "Accept");
	}
}
