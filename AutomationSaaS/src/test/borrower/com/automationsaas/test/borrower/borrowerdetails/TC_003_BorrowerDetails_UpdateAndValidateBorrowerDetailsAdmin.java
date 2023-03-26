package com.automationsaas.test.borrower.borrowerdetails;

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

public class TC_003_BorrowerDetails_UpdateAndValidateBorrowerDetailsAdmin extends Base {

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
		
		//@author : Divya
		String identityNumberOne = Generics.getRandomNumber(10);
		String identityNumberTwo = Generics.getRandomAlphaString(5) + Generics.getRandomNumber(4) +  Generics.getRandomAlphaString(1);
		
		ArrayList<String> updateBorrowerDetails = new ArrayList<String>();
		updateBorrowerDetails.add("Mrs");
		updateBorrowerDetails.add("Rishu");
		updateBorrowerDetails.add("Shr");
		updateBorrowerDetails.add("");	
		updateBorrowerDetails.add("Female");
		updateBorrowerDetails.add("Married");
		updateBorrowerDetails.add("13"+identityNumberOne);
		updateBorrowerDetails.add(identityNumberTwo);
		updateBorrowerDetails.add("Test_1");
		
		for(int i=0; i<updateBorrowerDetails.size(); i++) {
			borrowerDetailsPage.editBorrowerDetails(i, updateBorrowerDetails.get(i), "1996", "Jun", "10");
		}
		borrowerDetailsPage.clickUpdateBorrowerDetails();	
		
		// @author: Divya
		//invalid id no.1 : 11 digits  ; invalid id no.2: 6 alphabets + 5 numbers 
		String invalid11IdentityNumberOne= "1"+ identityNumberOne;
		String invalid650IdentityNumberTwo= Generics.getRandomAlphaString(6)+ Generics.getRandomNumber(5);
		borrowerDetailsPage.enterIdentityNumberOne(invalid11IdentityNumberOne);
		borrowerDetailsPage.enterIdentityNumberTwo(invalid650IdentityNumberTwo);
		borrowerDetailsPage.clickUpdateBorrowerDetails();
		borrowerDetailsPage.invalidIdentityNumberErrorMessage();
	
		//invalid id no.1: 13 digits  ; invalid id no.2: 4 alphabets + 3 numbers + 2 alphabets  
		String invalid13IdentityNumberOne= "130"+ identityNumberOne;
		String invalid432IdentityNumberTwo= Generics.getRandomAlphaString(4)+ Generics.getRandomNumber(3)+ Generics.getRandomAlphaString(2);
		borrowerDetailsPage.enterIdentityNumberOne(invalid13IdentityNumberOne);
		borrowerDetailsPage.enterIdentityNumberTwo(invalid432IdentityNumberTwo);
		borrowerDetailsPage.clickUpdateBorrowerDetails();
		borrowerDetailsPage.invalidIdentityNumberErrorMessage();
		
		//invalid id no.1: 12 Alphabets   ; invalid id no.2: 5 numbers + 4 alphabets + 1 Number
	    String invalidAlphabetIdentityNumberOne = Generics.getRandomAlphaString(12);
	    String invalid541IdentityNumberTwo= Generics.getRandomNumber(5)+ Generics.getRandomAlphaString(4)+ Generics.getRandomNumber(1);
	    borrowerDetailsPage.enterIdentityNumberOne(invalidAlphabetIdentityNumberOne);
	    borrowerDetailsPage.enterIdentityNumberTwo(invalid541IdentityNumberTwo);
		borrowerDetailsPage.clickUpdateBorrowerDetails();
		borrowerDetailsPage.invalidIdentityNumberErrorMessage();
		
		//valid idno.1(12 digits) and idno.2(5 alphabets + 4 number + 1 alphabets)
		String validIdentityNumberOne=  "12"+ identityNumberOne;
		String validIdentityNumberTwo= identityNumberTwo;
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 5, 1, validIdentityNumberOne);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 6, 1, validIdentityNumberTwo);
        borrowerDetailsPage.enterIdentityNumberOne(validIdentityNumberOne);
		borrowerDetailsPage.enterIdentityNumberTwo(validIdentityNumberTwo);
		borrowerDetailsPage.clickUpdateBorrowerDetails();
		
		//Divya
		String IdentityNumber1 = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Identity Number One").get(1);
		String IdentityNumber2= ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Identity Number Two").get(1);
		//
		
		//Validate Borrower Details
		Generics.refreshPage(driver);
		Generics.waitForFewSecondstoLoad(3000);
		
		ArrayList<String> borrowerDetails = new ArrayList<String>();
		borrowerDetails.add("Mrs");
		borrowerDetails.add("Rishu");
		borrowerDetails.add("Shr");
		borrowerDetails.add("10/06/1996");
		borrowerDetails.add("Female");
		borrowerDetails.add("Married");
		borrowerDetails.add(IdentityNumber1);
		borrowerDetails.add(IdentityNumber2);
		borrowerDetails.add("Test_1");
		
		for(int i=0; i<borrowerDetails.size(); i++) {
			borrowerDetailsPage.validateBasicProfile(i, borrowerDetails.get(i));
		}
	}
}
