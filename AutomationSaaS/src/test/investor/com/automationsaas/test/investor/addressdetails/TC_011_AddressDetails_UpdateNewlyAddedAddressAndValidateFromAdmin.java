package com.automationsaas.test.investor.addressdetails;

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

public class TC_011_AddressDetails_UpdateNewlyAddedAddressAndValidateFromAdmin extends Base {

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
		
		investorDetailsPage.clickAddressDetailsAccordion();
		investorDetailsPage.clickAddressDetailsEdit();

		ArrayList<String> investorAddressDetails = new ArrayList<String>();
		investorAddressDetails.add("Line213");
		investorAddressDetails.add("Line315");
		investorAddressDetails.add("Line417");
		investorAddressDetails.add("Karnataka");
		investorAddressDetails.add("Hyderabad");
		investorAddressDetails.add("579432");
		for (int i = 0; i < investorAddressDetails.size(); i++) {
			investorDetailsPage.editAddressDetails(i, investorAddressDetails.get(i));
		}
		investorDetailsPage.clickAddressDetailsDone();

		// Validate Updated
		Generics.refreshPage(driver);
		investorDetailsPage.clickAddressDetailsAccordion();
		ArrayList<String> updatedAddressDetails = new ArrayList<String>();
		updatedAddressDetails.add("1");
		updatedAddressDetails.add("Personal Address");
		updatedAddressDetails.add("Line213");
		updatedAddressDetails.add("Line315");
		updatedAddressDetails.add("Line417");
		updatedAddressDetails.add("Hyderabad");
		updatedAddressDetails.add("Karnataka");
		updatedAddressDetails.add("579432");
		for (int i = 0; i < updatedAddressDetails.size(); i++) {
			investorDetailsPage.validateAddressDetails(i, updatedAddressDetails.get(i));
		}
		
}}


