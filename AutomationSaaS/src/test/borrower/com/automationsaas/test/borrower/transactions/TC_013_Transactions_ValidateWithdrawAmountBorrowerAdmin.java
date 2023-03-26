package com.automationsaas.test.borrower.transactions;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminborrower.BorrowerDetailsPage;
import com.automationsaas.pom.adminborrower.BorrowersPage;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_013_Transactions_ValidateWithdrawAmountBorrowerAdmin extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void transactionFromBorrowerSide() {
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
		String borrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		searchPage.enterUserId(borrowerId);
		searchPage.clickSearch();
		
		ArrayList<String> searchBorrowerDetails = new ArrayList<String>();
		searchBorrowerDetails.add(borrowerId);
		searchBorrowerDetails.add(borrowerMailId);
		searchBorrowerDetails.add("Mr Rishav Shrivastava");
		searchBorrowerDetails.add("Individual");
		searchBorrowerDetails.add("APPROVED");
		searchBorrowerDetails.add("Permanent");
		searchBorrowerDetails.add("Rs50,000");
		
		for(int i=0; i<searchBorrowerDetails.size(); i++) {
			searchPage.validateSearchedBorrower(i, searchBorrowerDetails.get(i));
		}
		
		searchPage.clickBorrower(borrowerId);
		
		BorrowerDetailsPage borrowerDetailsPage = new BorrowerDetailsPage(driver);
		borrowerDetailsPage.validateBorrowerId(borrowerId);
		borrowerDetailsPage.validateBorrowerEmailId(borrowerMailId);
		borrowerDetailsPage.validateBorrowerStatus("Approved", "APPROVED");
		borrowerDetailsPage.validateAccountBalance("Rs1,500,000");
	}
}
