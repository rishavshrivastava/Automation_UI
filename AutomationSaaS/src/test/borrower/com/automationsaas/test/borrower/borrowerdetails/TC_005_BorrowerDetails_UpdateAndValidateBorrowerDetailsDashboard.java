package com.automationsaas.test.borrower.borrowerdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_BorrowerDetails_UpdateAndValidateBorrowerDetailsDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void updateBorrower() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		borrowerDashboardPage.validateBorrowerId(borrowerId);
		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Initialized");

		borrowerDashboardPage.clickAccount();
		borrowerDashboardPage.clickProfile();

		ProfilePage profilePage = new ProfilePage(driver);

		// @author: Divya
		String identityNumberOne = Generics.getRandomNumber(10);
		String identityNumberTwo = Generics.getRandomAlphaString(5) + Generics.getRandomNumber(4)+ Generics.getRandomAlphaString(1);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 5, 1, "14" + identityNumberOne);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 6, 1, identityNumberTwo);

		profilePage.clickBasicProfile();
		ArrayList<String> basicProfile = new ArrayList<String>();
		basicProfile.add("Mr");
		basicProfile.add("Rishav");
		basicProfile.add("Shrivastava");
		basicProfile.add("Male");
		basicProfile.add("Unmarried");
		basicProfile.add("14" + identityNumberOne);
		basicProfile.add(identityNumberTwo);
		basicProfile.add("Test_2");
		for (int i = 0; i < basicProfile.size(); i++) {
			profilePage.editBasicProfile(i, basicProfile.get(i));
		}
		profilePage.updateBasicProfile();

		// @author: Divya
		// invalid id no.1 : 11 digits ; invalid id no.2: 6 alphabets + 5 numbers
		String invalid11IdentityNumberOne = "1" + identityNumberOne;
		String invalid650IdentityNumberTwo = Generics.getRandomAlphaString(6) + Generics.getRandomNumber(5);
		profilePage.enterIdentityNumberOne(invalid11IdentityNumberOne);
		profilePage.enterIdentityNumberTwo(invalid650IdentityNumberTwo);
		profilePage.updateBasicProfileButton();
		profilePage.invalidIdentityNumberErrorMessage();

		// invalid id no.1: 13 digits ; invalid id no.2: 4 alphabets + 3 numbers + 2
		// alphabets
		String invalid13IdentityNumberOne = "130" + identityNumberOne;
		String invalid432IdentityNumberTwo = Generics.getRandomAlphaString(4) + Generics.getRandomNumber(3)+ Generics.getRandomAlphaString(2);
		profilePage.enterIdentityNumberOne(invalid13IdentityNumberOne);
		profilePage.enterIdentityNumberTwo(invalid432IdentityNumberTwo);
		profilePage.updateBasicProfileButton();
		profilePage.invalidIdentityNumberErrorMessage();

		// invalid id no.1: 12 Alphabets ; invalid id no.2: 5 numbers + 4 alphabets + 1
		// Number
		String invalidAlphabetIdentityNumberOne = Generics.getRandomAlphaString(12);
		String invalid541IdentityNumberTwo = Generics.getRandomNumber(5) + Generics.getRandomAlphaString(4)+ Generics.getRandomNumber(1);
		profilePage.enterIdentityNumberOne(invalidAlphabetIdentityNumberOne);
		profilePage.enterIdentityNumberTwo(invalid541IdentityNumberTwo);
		profilePage.updateBasicProfileButton();
		profilePage.invalidIdentityNumberErrorMessage();

		// valid idno.1(12 digits) and idno.2(5 alphabets + 4 number + 1 alphabets)
		String validIdentityNumberOne = "12" + identityNumberOne;
		String validIdentityNumberTwo = identityNumberTwo;
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 5, 1, validIdentityNumberOne);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 6, 1, validIdentityNumberTwo);
		profilePage.enterIdentityNumberOne(validIdentityNumberOne);
		profilePage.enterIdentityNumberTwo(validIdentityNumberTwo);
		profilePage.updateBasicProfile();

		String IdentityNumber1 = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Identity Number One").get(1);
		String IdentityNumber2 = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Identity Number Two").get(1);

		// Validate Basic Profile
		Generics.refreshPage(driver);
		ArrayList<String> updatedBasicProfile = new ArrayList<String>();
		updatedBasicProfile.add(username);
		updatedBasicProfile.add("Mr");
		updatedBasicProfile.add("Rishav");
		updatedBasicProfile.add("Shrivastava");
		updatedBasicProfile.add("10/06/1996");
		updatedBasicProfile.add("Male");
		updatedBasicProfile.add("Unmarried");
		updatedBasicProfile.add(IdentityNumber1);
		updatedBasicProfile.add(IdentityNumber2);
		updatedBasicProfile.add("Test_2");

		for (int i = 0; i < updatedBasicProfile.size(); i++) {
			profilePage.validateBasicProfile(i, updatedBasicProfile.get(i));
		}
	}
}
