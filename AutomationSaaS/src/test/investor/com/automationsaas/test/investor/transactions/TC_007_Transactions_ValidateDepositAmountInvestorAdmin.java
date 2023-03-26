package com.automationsaas.test.investor.transactions;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admininvestor.InvestorDetailsPage;
import com.automationsaas.pom.admininvestor.InvestorsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_007_Transactions_ValidateDepositAmountInvestorAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String adminUsername = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String adminPassword = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(adminUsername);
		loginPage.enterPassword(adminPassword);
		loginPage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickInvestor();
		homePage.clickInvestorAll();
		
		InvestorsPage investorsPage = new InvestorsPage(driver);
		String investorId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor ID").get(1);
		investorsPage.enterInvestorIdInSearchField(investorId);
		investorsPage.clickSearch();
		investorsPage.waitForResults();
		
		ArrayList<String> investorsDetails = new ArrayList<String>();
		investorsDetails.add("Mr Rishav Shrivastava");
		investorsDetails.add("Category 1");
		investorsDetails.add(investorId);
		investorsDetails.add("APPROVED");
		investorsDetails.add("Rs50,000");
		String investorEmailId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		investorsDetails.add(investorEmailId);
		
		for(int i=0; i<investorsDetails.size(); i++) {
			investorsPage.validateSearchedInvestor(i, investorsDetails.get(i));
		}
		investorsPage.clickSearchedInvestorId(investorId);
		
		InvestorDetailsPage investorDetailsPage = new InvestorDetailsPage(driver);
		investorDetailsPage.validateInvestorID(investorId);
		investorDetailsPage.validateInvestorStatus("Approved", "Approved");
		investorDetailsPage.validateAccountBalance("Rs1,500,000");
	}
}
