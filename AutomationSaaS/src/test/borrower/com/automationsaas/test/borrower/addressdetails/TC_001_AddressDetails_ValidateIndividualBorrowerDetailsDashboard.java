package com.automationsaas.test.borrower.addressdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_AddressDetails_ValidateIndividualBorrowerDetailsDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		String file = TC_001_AddressDetails_ValidateIndividualBorrowerDetailsDashboard;
		
		String title = Generics.jsonParser(file, "title");
		String firstName = Generics.jsonParser(file, "firstName");
		String lastName = Generics.jsonParser(file, "lastName");
		String profileStatus = Generics.jsonParser(file, "profileStatus");
		String accountBalance = Generics.jsonParser(file, "accountBalance");
		String loanStatus = Generics.jsonParser(file, "loanStatus");
		String companyName = Generics.jsonParser(file, "companyName");
		String department = Generics.jsonParser(file, "department");
		String designation = Generics.jsonParser(file, "designation");
		String employeeId = Generics.jsonParser(file, "employeeId");
		String addressLine1 = Generics.jsonParser(file, "addressLine1");
		String addressLine2 = Generics.jsonParser(file, "addressLine2");
		String addressLine3 = Generics.jsonParser(file, "addressLine3");
		String state = Generics.jsonParser(file, "state");
		String district = Generics.jsonParser(file, "district");
		String pincode = Generics.jsonParser(file, "pincode");
		
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
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
		borrowerDashboardPage.validateBorrowerName(title + " " +firstName + " " + lastName);
		borrowerDashboardPage.validateProfileStatus(profileStatus);
		borrowerDashboardPage.validateAccountBalance(accountBalance);
		borrowerDashboardPage.validateLoanStatus(loanStatus);

		borrowerDashboardPage.clickAccount();
		borrowerDashboardPage.clickProfile();
		
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.clickEmploymentProfile();
		
		ArrayList<String> employmentProfile = new ArrayList<String>();
		employmentProfile.add(companyName);
		employmentProfile.add(department);
		employmentProfile.add(designation);
		employmentProfile.add(employeeId);
		employmentProfile.add(addressLine1);
		employmentProfile.add(addressLine2);
		employmentProfile.add(addressLine3);
		employmentProfile.add(state);
		employmentProfile.add(district);
		employmentProfile.add(pincode);
		
		for(int i=0; i<employmentProfile.size(); i++) {
			profilePage.validateEmploymentProfile(i, employmentProfile.get(i));
		}
	}
}
