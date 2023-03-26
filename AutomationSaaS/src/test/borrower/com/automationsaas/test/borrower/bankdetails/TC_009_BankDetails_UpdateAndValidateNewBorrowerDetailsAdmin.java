package com.automationsaas.test.borrower.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminborrower.BorrowerDetailsPage;
import com.automationsaas.pom.adminborrower.BorrowersPage;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_009_BankDetails_UpdateAndValidateNewBorrowerDetailsAdmin extends Base {

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
		String borrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		searchPage.enterUserId(borrowerId);
		searchPage.clickSearch();
		
		ArrayList<String> searchBorrowerDetails = new ArrayList<String>();
		searchBorrowerDetails.add(borrowerId);
		searchBorrowerDetails.add(borrowerMailId);
		searchBorrowerDetails.add("Mr Rishav Shrivastava");
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
		borrowerDetailsPage.validateBorrowerStatus("Awaiting Approval", "COMPLETED");
		borrowerDetailsPage.validateAccountBalance("Rs0");
		borrowerDetailsPage.validateBorrowerEmailId(borrowerMailId);
		borrowerDetailsPage.clickBankDetailsAccordion();

		//Bank Details
		ArrayList<String> updateBankDetails = new ArrayList<String>();
		updateBankDetails.add("85471254789");
		updateBankDetails.add("SBITest");
		updateBankDetails.add("SBINTest");
		updateBankDetails.add("Current");
		borrowerDetailsPage.clickEditBankDetails(borrowerDetailsPage.getBankDetailsCount()-1);
		for(int i=0; i<updateBankDetails.size(); i++) {
			borrowerDetailsPage.editBankDetails(i, updateBankDetails.get(i));
		}
		borrowerDetailsPage.eclickSaveEditBankDetails();

		Generics.refreshPage(driver);
		borrowerDetailsPage.clickBankDetailsAccordion();
		
		ArrayList<String> bankDetails_validate_1 = new ArrayList<String>();
		bankDetails_validate_1.add("5845214578");
		bankDetails_validate_1.add("Current");
		bankDetails_validate_1.add("HDFC");
		bankDetails_validate_1.add("HDFC0099");
		bankDetails_validate_1.add("Shrivastava");
		
		ArrayList<String> bankDetails_validate_2 = new ArrayList<String>();
		bankDetails_validate_2.add("85471254789");
		bankDetails_validate_2.add("Current");
		bankDetails_validate_2.add("SBITest");
		bankDetails_validate_2.add("SBINTest");
		bankDetails_validate_2.add("Rishav");
		
		for (int i = 0; i < borrowerDetailsPage.getBankDetailsCount(); i++) {
			if(i==0) {
				for (int j = 0; j < bankDetails_validate_1.size(); j++) {
					borrowerDetailsPage.validateBankDetails(i, j, bankDetails_validate_1.get(j));
				}
			}
			else if(i==1) {
				for (int j = 0; j < bankDetails_validate_2.size(); j++) {
					borrowerDetailsPage.validateBankDetails(i, j, bankDetails_validate_2.get(j));
				}
			}
		}
	}
}
