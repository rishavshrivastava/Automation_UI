package com.automationsaas.test.loan.transactionsafterloandisbursal;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminborrower.BorrowerDetailsPage;
import com.automationsaas.pom.adminborrower.BorrowersPage;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_TransactionsAfterLoanDisbursal_CheckTransactionFromBorrowerAdminSideAfterDisbursal extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void updateBorrower() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		HomePage adminHomePage = new HomePage(driver);
		adminHomePage.clickBorrower();
		adminHomePage.clickBorrowerAll();
		
		BorrowersPage searchPage = new BorrowersPage(driver);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		String borrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
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
		borrowerDetailsPage.validateBorrowerEmailId(borrowerMailId);
		borrowerDetailsPage.validateAccountBalance("Rs1,700,000");
		borrowerDetailsPage.clickPreviousLoan();
		borrowerDetailsPage.clickPreviousLoanAccordion();
		ArrayList<String> previousLoanDetails = new ArrayList<String>();
		previousLoanDetails.add(borrowerMailId);
		String borrowerLoanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		previousLoanDetails.add(borrowerLoanId);
		previousLoanDetails.add("Rs200,000");
		previousLoanDetails.add("12 Months");
		previousLoanDetails.add("9.00 %");
		previousLoanDetails.add("Disbursed");
		previousLoanDetails.add("Individual");
		for(int i=0; i<previousLoanDetails.size(); i++) {
			borrowerDetailsPage.validatePreviousLoanDetails(i, previousLoanDetails.get(i));
		}
		borrowerDetailsPage.clickTransactions();
		borrowerDetailsPage.clickCompletedTransactionsAccordion();
		borrowerDetailsPage.validateCompletedTransactions(1700000, 3200000);
	}
}
