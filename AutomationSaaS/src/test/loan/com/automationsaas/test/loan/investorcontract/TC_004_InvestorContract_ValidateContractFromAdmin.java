package com.automationsaas.test.loan.investorcontract;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admininvestor.InvestorDetailsPage;
import com.automationsaas.pom.admininvestor.InvestorsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_004_InvestorContract_ValidateContractFromAdmin extends Base {

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

		ArrayList<String> searchedInvestorDetails = new ArrayList<String>();
		searchedInvestorDetails.add("Mr Rishav Shrivastava");
		searchedInvestorDetails.add("Category 1");
		searchedInvestorDetails.add(investorId);
		searchedInvestorDetails.add("APPROVED");
		searchedInvestorDetails.add("Rs50,000");
		searchedInvestorDetails.add(investorEmailId);
		for (int i = 0; i < searchedInvestorDetails.size(); i++) {
			investorsPage.validateSearchedInvestor(i, searchedInvestorDetails.get(i));
		}

		investorsPage.clickSearchedInvestorId(investorId);

		InvestorDetailsPage investorDetailsPage = new InvestorDetailsPage(driver);
		investorDetailsPage.validateInvestorStatus("Approved", "Approved");
		investorDetailsPage.validateAccountBalance("Rs0");
		investorDetailsPage.validateInvestorEmailId(investorEmailId);
		investorDetailsPage.clickContractsAccordion();

		ArrayList<String> contractnamedetails = new ArrayList<String>();
		contractnamedetails.add("Loan General Term");
		contractnamedetails.add("Bid Contract");
		contractnamedetails.add("Loan General Term");
		contractnamedetails.add("Loan General Term");
		contractnamedetails.add("Loan General Term");
		contractnamedetails.add("Bid Contract");
		contractnamedetails.add("Loan General Term");

		ArrayList<String> currentstatusdetails = new ArrayList<String>();
		currentstatusdetails.add("ACCEPTED");
		currentstatusdetails.add("REJECTED");
		currentstatusdetails.add("REJECTED");
		currentstatusdetails.add("ACCEPTED");
		currentstatusdetails.add("ACCEPTED");
		currentstatusdetails.add("ACCEPTED");
		currentstatusdetails.add("REJECTED");

		ArrayList<String> accepteduploadedbydetails = new ArrayList<String>();
		accepteduploadedbydetails.add(investorEmailId);
		accepteduploadedbydetails.add(investorEmailId);
		accepteduploadedbydetails.add(investorEmailId);
		accepteduploadedbydetails.add(investorEmailId);
		accepteduploadedbydetails.add(investorEmailId);
		accepteduploadedbydetails.add(investorEmailId);
		accepteduploadedbydetails.add(investorEmailId);

		ArrayList<String> accepteduploadedatstatus = new ArrayList<String>();
		accepteduploadedatstatus.add("APPROVED");
		accepteduploadedatstatus.add("APPROVED");
		accepteduploadedatstatus.add("APPROVED");
		accepteduploadedatstatus.add("APPROVED");
		accepteduploadedatstatus.add("APPROVED");
		accepteduploadedatstatus.add("APPROVED");
		accepteduploadedatstatus.add("APPROVED");

		for (int i = 0; i < contractnamedetails.size(); i++) {
			investorDetailsPage.validateContracts(i, contractnamedetails.get(i), currentstatusdetails.get(i),
					accepteduploadedbydetails.get(i), accepteduploadedatstatus.get(i));
		}
	}
}
