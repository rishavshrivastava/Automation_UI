package com.automationsaas.test.validatetransactionsdsa;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminborrower.BorrowerDetailsPage;
import com.automationsaas.pom.adminborrower.BorrowersPage;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.dsa.ExistingBorrowerPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_21_DepositAmountFromDSADashboardIntoBorrowerWallet extends Base {
	
	@Test(priority=0 ,retryAnalyzer = RetryAnalyzer.class)
	public void DepositAmountFromDSAintoBorrowerWallet() {
		
		
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		String dsaid  =ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		System.out.println(dsaid);
		dashboardPage.validateDSAId(dsaid);
		dashboardPage.validateProfileStatus("Approved");
		dashboardPage.clickApplyForLoan();
		dashboardPage.clickApplyLoanForExistingBorrower();
		
		ExistingBorrowerPage existingBorrowerPage = new ExistingBorrowerPage(driver);
		String emailId  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA Individual Borrower MailID").get(1);
		System.out.println(emailId);
		String borrowerId  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA Individual Borrower ID").get(1);
		System.out.println(borrowerId);
		existingBorrowerPage.clickOnShowAllFiltersLink();
		existingBorrowerPage.fillEmailFilter(emailId);
		existingBorrowerPage.clickOnSearch();
		existingBorrowerPage.clickOnExistingBorrowerIDLink();
		existingBorrowerPage.clickDepositMoneyInBorrowerAccountbutton();
		existingBorrowerPage.enterDepositAmountforBorrower("100");
		existingBorrowerPage.enterDepositDescription("Depositing 100 Rupees into Borrower Wallet");
		existingBorrowerPage.clickSubmitButton();
		
	}
	
	@Test(priority=1, dependsOnMethods = {"DepositAmountFromDSAintoBorrowerWallet"}, retryAnalyzer = RetryAnalyzer.class)
	public void acceptDepositFromAdmin() {
		TC_06_AcceptTransactionAdmin acceptTransaction=new TC_06_AcceptTransactionAdmin();
		acceptTransaction.test();
	}
	
	@Test(priority=2, dependsOnMethods = {"acceptDepositFromAdmin"},retryAnalyzer = RetryAnalyzer.class)
	public void ValidateBorrowerDepositFromAdmin() {
		
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String adminUsername = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String adminPassword = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(adminUsername);
		loginPage.enterPassword(adminPassword);
		loginPage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickBorrower();
		homePage.clickBorrowerAll();
		
		BorrowersPage searchPage = new BorrowersPage(driver);
		String borrowerMailId = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA Individual Borrower MailID").get(1);
		String borrowerId = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA Individual Borrower ID").get(1);
		searchPage.enterUserId(borrowerId);
		searchPage.clickSearch();
		
		ArrayList<String> searchBorrowerDetails = new ArrayList<String>();
		searchBorrowerDetails.add(borrowerId);
		searchBorrowerDetails.add(borrowerMailId);
		searchBorrowerDetails.add("Mr Chandrashekhar Yaragall");
		searchBorrowerDetails.add("Individual");
		searchBorrowerDetails.add("COMPLETED");
		searchBorrowerDetails.add("Permanent");
		searchBorrowerDetails.add("Rs50,000");
		
		for(int i=0; i<searchBorrowerDetails.size(); i++) {
			searchPage.validateSearchedBorrower(i, searchBorrowerDetails.get(i));
		}
		
		searchPage.clickBorrower(borrowerId);
		
		BorrowerDetailsPage borrowerDetailsPage = new BorrowerDetailsPage(driver);
		borrowerDetailsPage.validateBorrowerId(borrowerId);
		borrowerDetailsPage.validateBorrowerEmailId(borrowerMailId);
		borrowerDetailsPage.validateBorrowerStatus("Awaiting Approval", "COMPLETED");
		borrowerDetailsPage.validateAccountBalance("Rs100");
		
		//Withdraw the same deposited amount from Admin
		borrowerDetailsPage.clickWithdraw();
		borrowerDetailsPage.enterWithdrawAmount("100");
		borrowerDetailsPage.clickWithdrawButton();
		borrowerDetailsPage.validateAccountBalance("Rs0");
	}

}
