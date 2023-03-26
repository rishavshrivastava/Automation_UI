package com.automationsaas.test.borrower.addressdetails;

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

public class TC_002_AddressDetails_ValidateIndividualBorrowerDetailsAdmin extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void validateBorrowerDetails() {
		String file = TC_002_AddressDetails_ValidateIndividualBorrowerDetailsAdmin;
		
		String title = Generics.jsonParser(file, "title");
		String firstName = Generics.jsonParser(file, "firstName");
		String lastName = Generics.jsonParser(file, "lastName");
		String borrowerType = Generics.jsonParser(file, "borrowerType");
		String profileStatus = Generics.jsonParser(file, "profileStatus");
		String jobType = Generics.jsonParser(file, "jobType");
		String amountToBeInvested = Generics.jsonParser(file, "amountToBeInvested");
		String accountBalance = Generics.jsonParser(file, "accountBalance");
		String serialNo = Generics.jsonParser(file, "serialNo");
		String addressType = Generics.jsonParser(file, "addressType");
		String line1 = Generics.jsonParser(file, "line1");
		String line2 = Generics.jsonParser(file, "line2");
		String line3 = Generics.jsonParser(file, "line3");
		String city = Generics.jsonParser(file, "city");
		String state = Generics.jsonParser(file, "state");
		String pincode = Generics.jsonParser(file, "pincode");
		
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
		searchBorrowerDetails.add(title +" "+ firstName +" "+ lastName);
		searchBorrowerDetails.add(borrowerType);
		searchBorrowerDetails.add(profileStatus);
		searchBorrowerDetails.add(jobType);
		searchBorrowerDetails.add(amountToBeInvested);
		
		for(int i=0; i<searchBorrowerDetails.size(); i++) {
			searchPage.validateSearchedBorrower(i, searchBorrowerDetails.get(i));
		}
		
		searchPage.clickBorrower(borrowerId);
		
		BorrowerDetailsPage borrowerDetailsPage = new BorrowerDetailsPage(driver);
		borrowerDetailsPage.validateBorrowerId(borrowerId);
		borrowerDetailsPage.validateBorrowerStatus("Awaiting Approval", "COMPLETED");
		borrowerDetailsPage.validateAccountBalance(accountBalance);
		borrowerDetailsPage.validateBorrowerEmailId(borrowerMailId);
		
		borrowerDetailsPage.clickAddressDetailsAccordion();
		
		ArrayList<String> borrowerDetails = new ArrayList<String>();
		borrowerDetails.add(serialNo);
		borrowerDetails.add(addressType);
		borrowerDetails.add(line1);
		borrowerDetails.add(line2);
		borrowerDetails.add(line3);
		borrowerDetails.add(city);
		borrowerDetails.add(state);
		borrowerDetails.add(pincode);
		
		for(int i=0; i<borrowerDetails.size(); i++) {
			borrowerDetailsPage.validateAddressDetails(i, borrowerDetails.get(i));
		}
	}
}
