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

public class TC_002_BorrowerDetails_ValidateCompanyBorrowerDetailsAdmin extends Base {

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

		addedshareholderdetails_0.add("09/08/1992");
		addedshareholderdetails_0.add("TYPER1236Q");
		addedshareholderdetails_0.add("AAA");
		addedshareholderdetails_0.add("divya.s@perfios.com");
		addedshareholderdetails_0.add("273528359899");
		addedshareholderdetails_0.add("Tester");
		addedshareholderdetails_0.add("SHLine1, SHLine2, SHLine3, SHCity, Karnataka, 125098, SHCountry");
		addedshareholderdetails_0.add("9876543211");
		addedshareholderdetails_0.add("Indians");
		addedshareholderdetails_0.add("23/03/2016");

		int shareholderDetailsCount = loanDetailsPage.getShareholderCount();
		assertEquals(shareholderDetailsCount, 1);

		for (int i = 0; i < addedshareholderdetails_0.size(); i++) {
			loanDetailsPage.validateShareHolderDetails(shareholderDetailsCount - 1, i,
					addedshareholderdetails_0.get(i));
		}
	}
}
