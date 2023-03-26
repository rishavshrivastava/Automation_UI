package com.automationsaas.test.borrower.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminborrower.BorrowerDetailsPage;
import com.automationsaas.pom.adminborrower.BorrowersPage;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_018_BankDetails_ValidateUpdatedNewBorrowerDetailsAdmin extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
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
		searchPage.enterUserId(borrowerId);
		searchPage.clickSearch();
		
		searchPage.clickBorrower(borrowerId);
		BorrowerDetailsPage borrowerDetailsPage = new BorrowerDetailsPage(driver);
		borrowerDetailsPage.clickBankDetailsAccordion();
		
		ArrayList<String> bankDetails_validate = new ArrayList<String>();
		bankDetails_validate.add("55588654");
		bankDetails_validate.add("Current");
		bankDetails_validate.add("HDFC");
		bankDetails_validate.add("HDFC5955");
		bankDetails_validate.add("Rishav");
		
		for (int i = 0; i < borrowerDetailsPage.getBankDetailsCount(); i++) {
			if(i==0) {
				for (int j = 0; j < bankDetails_validate.size(); j++) {
					borrowerDetailsPage.validateBankDetails(i, j, bankDetails_validate.get(j));
				}
			}
		}
	}
}
