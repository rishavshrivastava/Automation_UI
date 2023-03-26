package com.automationsaas.test.borrower.addressdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminborrower.BorrowerDetailsPage;
import com.automationsaas.pom.adminborrower.BorrowersPage;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_AddressDetails_AddNewAddressAndValidateFromAdmin extends Base {

	@Test  (retryAnalyzer = RetryAnalyzer.class)
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
		searchPage.clickBorrower(borrowerId);
		
		BorrowerDetailsPage borrowerDetailsPage = new BorrowerDetailsPage(driver);
		borrowerDetailsPage.validateBorrowerId(borrowerId);
		borrowerDetailsPage.validateBorrowerEmailId(borrowerMailId);
		
		borrowerDetailsPage.clickAddressDetailsAccordion();
		
        borrowerDetailsPage.clickEditAddressDetails();
		
		ArrayList<String> updateAddressDetails = new ArrayList<String>();
		updateAddressDetails.add("D Pillar 123");
		updateAddressDetails.add("Tower NA");
		updateAddressDetails.add("DLF Cybercity");
		updateAddressDetails.add("Karnataka");
		updateAddressDetails.add("Bangalore");
		updateAddressDetails.add("355218");
		for(int i=0; i<updateAddressDetails.size(); i++) {
			borrowerDetailsPage.editAddressDetails(i, updateAddressDetails.get(i));
		}
		borrowerDetailsPage.clickSaveEditAddress();
		ArrayList<String> addressDetails = new ArrayList<String>();
		addressDetails.add("1");
		addressDetails.add("Address");
		addressDetails.add("D Pillar 123");
		addressDetails.add("Tower NA");
		addressDetails.add("DLF Cybercity");
		addressDetails.add("Bangalore");
		addressDetails.add("Karnataka");
		addressDetails.add("355218");
		for (int i = 0; i < addressDetails.size(); i++) {
			borrowerDetailsPage.validateAddressDetails(i, addressDetails.get(i));
		}
	}
		
}
