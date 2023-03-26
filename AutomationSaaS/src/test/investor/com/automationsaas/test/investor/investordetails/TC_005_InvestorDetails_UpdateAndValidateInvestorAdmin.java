package com.automationsaas.test.investor.investordetails;

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

public class TC_005_InvestorDetails_UpdateAndValidateInvestorAdmin extends Base {

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
		String investorPhoneNumber = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor Phone Number").get(1);
		investorsPage.enterInvestorIdInSearchField(investorId);
		investorsPage.clickSearch();
		investorsPage.waitForResults();

		ArrayList<String> searchedInvestorDetails = new ArrayList<String>();
		searchedInvestorDetails.add("Mrs Rishu Shriva");
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

		ArrayList<String> investorDetails = new ArrayList<String>();
		investorDetails.add("Mr");
		investorDetails.add("Rishav");
		investorDetails.add("Shrivastava");
		investorDetails.add("");
		investorDetails.add("Male");
		investorDetails.add("Unmarried");
		investorDetails.add(investorPhoneNumber);
		investorDetails.add("451548762354");
		investorDetails.add("BGDTR9542R");
		investorDetails.add("Category 1");
		investorDetails.add("Testing");
		for (int i = 0; i < investorDetails.size(); i++) {
			investorDetailsPage.editDetails(i, investorDetails.get(i), "1995", "Nov", "11");
		}
		investorDetailsPage.clickDetailsUpdate();

		// Validate Updated Details
		Generics.refreshPage(driver);
		ArrayList<String> updatedInvestorDetails = new ArrayList<String>();
		updatedInvestorDetails.add("Mr");
		updatedInvestorDetails.add("Rishav");
		updatedInvestorDetails.add("Shrivastava");
		updatedInvestorDetails.add("11/11/1995");
		updatedInvestorDetails.add("Male");
		updatedInvestorDetails.add("Unmarried");
		updatedInvestorDetails.add(investorPhoneNumber);
		updatedInvestorDetails.add("xxxxxxxx2354");
		updatedInvestorDetails.add("xxxxxx542R");
		updatedInvestorDetails.add("Category 1");
		updatedInvestorDetails.add("Testing");
		for (int i = 0; i < updatedInvestorDetails.size(); i++) {
			investorDetailsPage.validateDetails(i, updatedInvestorDetails.get(i));
		}

		// Validate negative scenarios (Temporary)
		Generics.refreshPage(driver);
		ArrayList<String> investorDetails2 = new ArrayList<String>();
		investorDetails2.add("Mr");
		investorDetails2.add("Rishav");
		investorDetails2.add("Shrivastava");
		investorDetails2.add("");
		investorDetails2.add("Male");
		investorDetails2.add("Unmarried");
		investorDetails2.add(investorPhoneNumber);
		investorDetails2.add("45154876235");
		investorDetails2.add("BGDTRW542R");
		investorDetails2.add("Category 1");
		investorDetails2.add("Testing");
		for (int i = 0; i < investorDetails.size(); i++) {
			investorDetailsPage.editDetails(i, investorDetails2.get(i), "1995", "Nov", "11");
		}
		investorDetailsPage.clickUpdateToValidateWrongIdentityNumbers();

		Generics.refreshPage(driver);
		ArrayList<String> investorDetails3 = new ArrayList<String>();
		investorDetails3.add("Mr");
		investorDetails3.add("Rishav");
		investorDetails3.add("Shrivastava");
		investorDetails3.add("");
		investorDetails3.add("Male");
		investorDetails3.add("Unmarried");
		investorDetails3.add(investorPhoneNumber);
		investorDetails3.add("4515487623534");
		investorDetails3.add("BGDT87542R");
		investorDetails3.add("Category 1");
		investorDetails3.add("Testing");
		for (int i = 0; i < investorDetails.size(); i++) {
			investorDetailsPage.editDetails(i, investorDetails3.get(i), "1995", "Nov", "11");
		}
		investorDetailsPage.clickUpdateToValidateWrongIdentityNumbers();

		Generics.refreshPage(driver);
		ArrayList<String> investorDetails4 = new ArrayList<String>();
		investorDetails4.add("Mr");
		investorDetails4.add("Rishav");
		investorDetails4.add("Shrivastava");
		investorDetails4.add("");
		investorDetails4.add("Male");
		investorDetails4.add("Unmarried");
		investorDetails4.add(investorPhoneNumber);
		investorDetails4.add("DHSYRTFGSKFH");
		investorDetails4.add("54893HFUK8");
		investorDetails4.add("Category 1");
		investorDetails4.add("Testing");
		for (int i = 0; i < investorDetails.size(); i++) {
			investorDetailsPage.editDetails(i, investorDetails4.get(i), "1995", "Nov", "11");
		}
		investorDetailsPage.clickUpdateToValidateWrongIdentityNumbers();

		Generics.refreshPage(driver);
		for (int i = 0; i < investorDetails.size(); i++) {
			investorDetailsPage.editDetails(i, investorDetails.get(i), "1995", "Nov", "11");
		}
		investorDetailsPage.clickDetailsUpdate();
		Generics.refreshPage(driver);
		for (int i = 0; i < updatedInvestorDetails.size(); i++) {
			investorDetailsPage.validateDetails(i, updatedInvestorDetails.get(i));
		}
	}
}