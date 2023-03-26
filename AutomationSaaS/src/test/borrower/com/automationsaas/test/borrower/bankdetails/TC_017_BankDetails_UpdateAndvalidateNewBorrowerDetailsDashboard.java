package com.automationsaas.test.borrower.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.ProfilePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_017_BankDetails_UpdateAndvalidateNewBorrowerDetailsDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);

		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Initialized");
		
		ProfilePage profilePage = new ProfilePage(driver);
		borrowerDashboardPage.clickAccount();
		borrowerDashboardPage.clickProfile();
		
		//Bank Details
		profilePage.clickBankDetails();
		profilePage.clickBankDetailsAccordionLink();
		profilePage.clickBankDetailsEdit(0);
		
		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("Rishu");
		bankDetails.add("55588654");
		bankDetails.add("HDFC");
		bankDetails.add("HDFC5955");
		bankDetails.add("Current");
		for(int i=0;i<bankDetails.size();i++) {
			profilePage.editBankDetails(i, bankDetails.get(i));
		}
		profilePage.clickEditBankDetailsDone();
		
		Generics.refreshPage(driver);
		
		profilePage.clickBankDetails();
		profilePage.clickBankDetailsAccordionLink();
		
		ArrayList<String> updatedBankDetails = new ArrayList<String>();
		updatedBankDetails.add("55588654");
		updatedBankDetails.add("Current");
		updatedBankDetails.add("HDFC");
		updatedBankDetails.add("HDFC5955");
		updatedBankDetails.add("Rishav");
		
		for (int i = 0; i < profilePage.getBankDetailsCount(); i++) {
					profilePage.validateBankDetails(0, i, updatedBankDetails.get(i));
		}
	}
}
