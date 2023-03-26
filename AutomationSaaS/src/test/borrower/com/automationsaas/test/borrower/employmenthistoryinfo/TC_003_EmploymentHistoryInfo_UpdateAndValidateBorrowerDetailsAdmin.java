package com.automationsaas.test.borrower.employmenthistoryinfo;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminborrower.BorrowerDetailsPage;
import com.automationsaas.pom.adminborrower.BorrowersPage;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_EmploymentHistoryInfo_UpdateAndValidateBorrowerDetailsAdmin extends Base {

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
		
		borrowerDetailsPage.clickEmploymentHistoryInfoAccordion();
		
		ArrayList<String> updateEmploymentHistoryInfoDetails = new ArrayList<String>();
		updateEmploymentHistoryInfoDetails.add("Perfios");
		updateEmploymentHistoryInfoDetails.add("Accounts");
		updateEmploymentHistoryInfoDetails.add("Developer");
		updateEmploymentHistoryInfoDetails.add("PER78596");
		for(int i=0; i<updateEmploymentHistoryInfoDetails.size(); i++) {
			borrowerDetailsPage.editEmploymentHistoryInfo(i, updateEmploymentHistoryInfoDetails.get(i));
		}
		borrowerDetailsPage.updateEmploymentHistoryInfo();
		
		ArrayList<String> borrowerDetails = new ArrayList<String>();
		borrowerDetails.add("Perfios");
		borrowerDetails.add("Accounts");
		borrowerDetails.add("Developer");
		borrowerDetails.add("PER78596");
		
		for(int i=0; i<borrowerDetails.size(); i++) {
			borrowerDetailsPage.validateEmploymentHistoryInfo(i, borrowerDetails.get(i));
		}
	}
}
