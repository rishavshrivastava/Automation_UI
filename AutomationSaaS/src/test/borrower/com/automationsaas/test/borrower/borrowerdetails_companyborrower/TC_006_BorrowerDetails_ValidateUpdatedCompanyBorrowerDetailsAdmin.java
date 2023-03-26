package com.automationsaas.test.borrower.borrowerdetails_companyborrower;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_006_BorrowerDetails_ValidateUpdatedCompanyBorrowerDetailsAdmin extends Base {

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

		ArrayList<String> addedshareholderdetails = new ArrayList<String>();

		addedshareholderdetails.add("29/04/1993");
		addedshareholderdetails.add("TYPER1000D");
		addedshareholderdetails.add("AAA dashboard");
		addedshareholderdetails.add("divya.s+dashboard@perfios.com");
		addedshareholderdetails.add("276528359000");
		addedshareholderdetails.add("Tester dashboard");
		addedshareholderdetails.add(
				"SHLine1 dashboard, SHLine2 dashboard, SHLine3 dashboard, SHCity dashboard, Uttar Pradesh, 125000, SHCountry");
		addedshareholderdetails.add("9876543000");
		addedshareholderdetails.add("Indians dashboard");
		addedshareholderdetails.add("20/02/2018");

		int shareHolderCount = loanDetailsPage.getShareholderCount();
		assertEquals(shareHolderCount, 1);

		for (int i = 0; i < addedshareholderdetails.size(); i++) {
			loanDetailsPage.validateShareHolderDetails(shareHolderCount - 1, i, addedshareholderdetails.get(i));
		}

	}
}
