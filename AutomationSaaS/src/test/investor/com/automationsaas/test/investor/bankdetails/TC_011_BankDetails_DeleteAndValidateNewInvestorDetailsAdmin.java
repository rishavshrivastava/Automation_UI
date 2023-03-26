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

public class TC_011_BankDetails_DeleteAndValidateNewInvestorDetailsAdmin extends Base {

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
		String investorEmailId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID")
				.get(1);
		investorsPage.enterInvestorIdInSearchField(investorId);
		investorsPage.clickSearch();
		investorsPage.waitForResults();
		investorsPage.clickSearchedInvestorId(investorId);

		InvestorDetailsPage investorDetailsPage = new InvestorDetailsPage(driver);
		investorDetailsPage.validateInvestorEmailId(investorEmailId);
		investorDetailsPage.clickBankDetailsAccordion();

		investorDetailsPage.clickBankDetailsDelete(1);
		
		Generics.refreshPage(driver);
		investorDetailsPage.clickBankDetailsAccordion();

		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("23234545");
		bankDetails.add("Current");
		bankDetails.add("Kotak");
		bankDetails.add("Kotak96");

		for (int i = 0; i < investorDetailsPage.getBankDetailsCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < bankDetails.size(); j++) {
					investorDetailsPage.validateBankDetails(i, j, bankDetails.get(j));
				}
			}
		}
	}
}
