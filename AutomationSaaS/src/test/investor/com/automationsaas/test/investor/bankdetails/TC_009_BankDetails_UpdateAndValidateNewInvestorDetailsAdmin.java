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

public class TC_009_BankDetails_UpdateAndValidateNewInvestorDetailsAdmin extends Base {

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

		investorDetailsPage.clickBankDetailsEdit(1);
		ArrayList<String> investorBankDetails_edit = new ArrayList<String>();
		investorBankDetails_edit.add("45456767");
		investorBankDetails_edit.add("HDFC");
		investorBankDetails_edit.add("HDFCIN678");
		investorBankDetails_edit.add("Current");
		for (int i = 0; i < investorBankDetails_edit.size(); i++) {
			investorDetailsPage.editBankDetails(i, investorBankDetails_edit.get(i));
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
		bankDetails_2.add("45456767");
		bankDetails_2.add("Current");
		bankDetails_2.add("HDFC");
		bankDetails_2.add("HDFCIN678");

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
