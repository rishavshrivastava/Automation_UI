package com.automationsaas.test.borrower.borrowerdetails_companyborrower;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_024_BorrowerDetails_ValidateDeletedNewDetailsFromAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateBorrowerDetails() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		HomePage homePage = new HomePage(driver);
		homePage.clickLoanApplications();
		homePage.clickLoanApplicationsAll();

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Company Borrower Loan ID").get(1);
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickLoanId();

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.clickLoanDetailsPageNextSliderForCompanyRepresentative();
		loanDetailsPage.clickCompanyRepresentativeTab();
		loanDetailsPage.clickShareHolderAccordion();

		ArrayList<String> addedshareholderdetails_0 = new ArrayList<String>();
		addedshareholderdetails_0.add("29/04/1993");
		addedshareholderdetails_0.add("TYPER1000D");
		addedshareholderdetails_0.add("AAA dashboard");
		addedshareholderdetails_0.add("divya.s+dashboard@perfios.com");
		addedshareholderdetails_0.add("276528359000");
		addedshareholderdetails_0.add("Tester dashboard");
		addedshareholderdetails_0.add(
				"SHLine1 dashboard, SHLine2 dashboard, SHLine3 dashboard, SHCity dashboard, Uttar Pradesh, 125000, SHCountry");
		addedshareholderdetails_0.add("9876543000");
		addedshareholderdetails_0.add("Indians dashboard");
		addedshareholderdetails_0.add("20/02/2018");

		ArrayList<String> addedshareholderdetails_1 = new ArrayList<String>();
		addedshareholderdetails_1.add("19/05/1994");
		addedshareholderdetails_1.add("TYPER1000Z");
		addedshareholderdetails_1.add("AAA xyz");
		addedshareholderdetails_1.add("divya.s+xyz@perfios.com");
		addedshareholderdetails_1.add("476528359000");
		addedshareholderdetails_1.add("Tester xyz");
		addedshareholderdetails_1
				.add("SHLine1 xyz, SHLine2 xyz, SHLine3 xyz, SHCity xyz, Haryana, 125023, SHCountry xyz");
		addedshareholderdetails_1.add("9876543011");
		addedshareholderdetails_1.add("Indians xyz");
		addedshareholderdetails_1.add("20/03/2009");

		for (int i = 0; i < loanDetailsPage.getShareholderCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < addedshareholderdetails_0.size(); j++) {
					loanDetailsPage.validateShareHolderDetails(i, j, addedshareholderdetails_0.get(j));
				}
			} else if (i == 1) {
				for (int j = 0; j < addedshareholderdetails_1.size(); j++) {
					loanDetailsPage.validateShareHolderDetails(i, j, addedshareholderdetails_1.get(j));
				}
			}
		}
	}
}
