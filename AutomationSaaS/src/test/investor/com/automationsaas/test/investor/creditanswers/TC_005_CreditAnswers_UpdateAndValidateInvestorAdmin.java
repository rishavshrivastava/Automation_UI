package com.automationsaas.test.investor.creditanswers;

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

public class TC_005_CreditAnswers_UpdateAndValidateInvestorAdmin extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
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

		Generics.scrollPage(driver, -800);
		investorDetailsPage.clickCreditAnswers();
		investorDetailsPage.clickInvestorQuestionGroup1Accordion();
		ArrayList<String> investorQuestionGroup1 = new ArrayList<String>();
		investorQuestionGroup1.add("50000");
		investorQuestionGroup1.add("Indian");
		for (int i = 0; i < investorQuestionGroup1.size(); i++) {
			investorDetailsPage.editInvestorQuestionGroup1(i, investorQuestionGroup1.get(i));
		}
		investorDetailsPage.clickInvestorQuestionGroup1Submit();

		// Validate Updated
		Generics.refreshPage(driver);
		investorDetailsPage.clickCreditAnswers();
		investorDetailsPage.clickInvestorQuestionGroup1Accordion();
		ArrayList<String> updatedInvestorQuestionGroup1 = new ArrayList<String>();
		updatedInvestorQuestionGroup1.add("50000");
		updatedInvestorQuestionGroup1.add("Indian");
		for (int i = 0; i < updatedInvestorQuestionGroup1.size(); i++) {
			investorDetailsPage.validateInvestorQuestionGroup1(i, updatedInvestorQuestionGroup1.get(i));
		}
	}
}