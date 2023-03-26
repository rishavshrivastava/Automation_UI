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

public class TC_005_BankDetails_UpdateAndValidateInvestorAdmin extends Base {

	@Test  (retryAnalyzer = RetryAnalyzer.class)
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

		ArrayList<String> searchedInvestorDetails = new ArrayList<String>();
		searchedInvestorDetails.add("Mr Rishav Shrivastava");
		searchedInvestorDetails.add("Category 1");
		searchedInvestorDetails.add(investorId);
		searchedInvestorDetails.add("COMPLETED");
		searchedInvestorDetails.add("Rs50,000");
		searchedInvestorDetails.add(investorEmailId);
		for (int i = 0; i < searchedInvestorDetails.size(); i++) {
		investorsPage.validateSearchedInvestor(i, searchedInvestorDetails.get(i));
		}

		investorsPage.clickSearchedInvestorId(investorId);

		InvestorDetailsPage investorDetailsPage = new InvestorDetailsPage(driver);
		investorDetailsPage.validateInvestorStatus("Completed", "Completed");
		investorDetailsPage.validateAccountBalance("Rs0");
		investorDetailsPage.validateInvestorEmailId(investorEmailId);
		investorDetailsPage.clickBankDetailsAccordion();

		investorDetailsPage.clickBankDetailsEdit(0);
		ArrayList<String> bankDetailsInPopUp = new ArrayList<String>();
		bankDetailsInPopUp.add("85478547845");
		bankDetailsInPopUp.add("AXIS");
		bankDetailsInPopUp.add("AXN00303");
		bankDetailsInPopUp.add("Current");

		for (int i = 0; i < bankDetailsInPopUp.size(); i++) {
			investorDetailsPage.validateBankDetailsInPopup(i, bankDetailsInPopUp.get(i));
		}
		investorDetailsPage.close_bankdetails();

		investorDetailsPage.clickBankDetailsEdit(0);

		ArrayList<String> investorBankDetails_edit = new ArrayList<String>();
		investorBankDetails_edit.add("7854521478");
		investorBankDetails_edit.add("SBI");
		investorBankDetails_edit.add("SBIN555");
		investorBankDetails_edit.add("Savings");
		for (int i = 0; i < investorBankDetails_edit.size(); i++) {
			investorDetailsPage.editBankDetails(i, investorBankDetails_edit.get(i));
		}
		investorDetailsPage.clickBankDetailsDone();

		// Validate Bank Details
		Generics.refreshPage(driver);
		investorDetailsPage.clickBankDetailsAccordion();
		ArrayList<String> bankDetails = new ArrayList<String>();
		bankDetails.add("7854521478");
		bankDetails.add("Savings");
		bankDetails.add("SBI");
		bankDetails.add("SBIN555");
		for (int j = 0; j < bankDetails.size(); j++) {
			investorDetailsPage.validateBankDetails(0, j, bankDetails.get(j));
		}
	}
}