package com.automationsaas.test.configuration.verifyemailandphone;

import org.testng.annotations.Test;

import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.pom.userslist.UserDetailsPage;
import com.automationsaas.pom.userslist.UsersPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_VerifyEmailAndPhone_CheckEmailAndPhoneForBorrower extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/user/list");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		UsersPage usersPage = new UsersPage(driver);
		String emailAddress = ReadWriteExcel.getData(excel_path, loan_sheet_name, "Individual Investor MailID").get(1);
		usersPage.enterEmailAddress(emailAddress);
		usersPage.clickSearch();
		usersPage.clickEdit();

		UserDetailsPage userDetailsPage = new UserDetailsPage(driver);
		userDetailsPage.validateUsername(emailAddress);
		userDetailsPage.checkIfPhoneVerified();
		userDetailsPage.checkIfEmailVerified();
		userDetailsPage.clickUpdate();
	}
}
