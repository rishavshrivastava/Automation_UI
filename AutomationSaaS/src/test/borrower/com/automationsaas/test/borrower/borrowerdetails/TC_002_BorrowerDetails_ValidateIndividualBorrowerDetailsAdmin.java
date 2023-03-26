package com.automationsaas.test.borrower.borrowerdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminborrower.BorrowerDetailsPage;
import com.automationsaas.pom.adminborrower.BorrowersPage;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_BorrowerDetails_ValidateIndividualBorrowerDetailsAdmin extends Base {

	@Test   (retryAnalyzer = RetryAnalyzer.class)
	public void validateBorrowerDetails() {
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
		
		//Divya
		String identityNumberOne = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Identity Number One").get(1);
		String IdentityNumberTwo = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Identity Number Two").get(1);
		String BorrowerMobileNumber = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Borrower Mobile Number").get(1);
		String BorrowerLandlineNumber = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Landline Number").get(1);
		
		ArrayList<String> borrowerDetails = new ArrayList<String>();
		borrowerDetails.add("Mr");
		borrowerDetails.add("Rishav");
		borrowerDetails.add("Shrivastava");
		borrowerDetails.add("02/03/1994");
		borrowerDetails.add("Male");
		borrowerDetails.add("Unmarried");
		borrowerDetails.add(identityNumberOne);
		borrowerDetails.add(IdentityNumberTwo);
		borrowerDetails.add("Test_1");
		borrowerDetails.add(BorrowerMobileNumber);
		borrowerDetails.add(BorrowerLandlineNumber);
		borrowerDetails.add("4525485");
		borrowerDetails.add("45254785");
		borrowerDetails.add("54521452");
		borrowerDetails.add(borrowerMailId);
		
		for(int i=0; i<borrowerDetails.size(); i++) {
			borrowerDetailsPage.validateBorrowerBasicDetails(i, borrowerDetails.get(i));
		}
	}
}
