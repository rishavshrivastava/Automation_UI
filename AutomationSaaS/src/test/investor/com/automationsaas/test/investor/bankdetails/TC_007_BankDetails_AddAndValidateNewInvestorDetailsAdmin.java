package com.automationsaas.test.investor.bankdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admininvestor.InvestorDetailsPage;
import com.automationsaas.pom.admininvestor.InvestorsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_007_BankDetails_AddAndValidateNewInvestorDetailsAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateInvestor() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		HomePage adminHomePage = new HomePage(driver);
		adminHomePage.clickInvestor();
		adminHomePage.clickInvestorAll();

		InvestorsPage investorsPage = new InvestorsPage(driver);
		String investorId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor ID").get(1);
		String investorEmailId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		investorsPage.enterInvestorIdInSearchField(investorId);
		investorsPage.clickSearch();
		investorsPage.waitForResults();
		investorsPage.clickSearchedInvestorId(investorId);

		InvestorDetailsPage investorDetailsPage = new InvestorDetailsPage(driver);
		investorDetailsPage.validateInvestorEmailId(investorEmailId);
		investorDetailsPage.clickBankDetailsAccordion();

		investorDetailsPage.clickAddBankDetails();
		ArrayList<String> investorBankDetails_add = new ArrayList<String>();
		investorBankDetails_add.add("23234545");
		investorBankDetails_add.add("Kotak");
		investorBankDetails_add.add("Kotak96");
		investorBankDetails_add.add("Current");
		for (int i = 0; i < investorBankDetails_add.size(); i++) {
			investorDetailsPage.addBankDetails(i, investorBankDetails_add.get(i));
		}
		investorDetailsPage.clickBankDetailsDone();

		Generics.refreshPage(driver);
		investorDetailsPage.clickBankDetailsAccordion();

		ArrayList<String> bankDetails_1 = new ArrayList<String>();
		bankDetails_1.add("23234545");
		bankDetails_1.add("Current");
		bankDetails_1.add("Kotak");
		bankDetails_1.add("Kotak96");
		
		ArrayList<String> bankDetails_2 = new ArrayList<String>();
		bankDetails_2.add("7854521478");
		bankDetails_2.add("Savings");
		bankDetails_2.add("SBI");
		bankDetails_2.add("SBIN555");

		for (int i = 0; i < investorDetailsPage.getBankDetailsCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < bankDetails_1.size(); j++) {
					investorDetailsPage.validateBankDetails(i, j, bankDetails_1.get(j));
				}
			} else if (i == 1) {
				for (int j = 0; j < bankDetails_2.size(); j++) {
					investorDetailsPage.validateBankDetails(i, j, bankDetails_2.get(j));
				}
			}
		}
	}
}
