package com.automationsaas.test.borrower.borrowerdetails_companyborrower;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.CompanyRepresentativePage;
import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_004_BorrowerDetails_ValidateUpdatedCompanyBorrowerDetailsDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Company Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Company Borrower MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);

		borrowerDashboardPage.validateBorrowerName("MR RISHAV SHRIVASTAVA");
		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");

		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Company Borrower ID").get(1);
		borrowerDashboardPage.validateBorrowerId(borrowerId);

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Company Borrower Loan ID").get(1);
		borrowerDashboardPage.validateLoanId(loanId);
		borrowerDashboardPage.clickLoanDetailsButton();

		CompanyRepresentativePage companyRepresentativePage = new CompanyRepresentativePage(driver);
		companyRepresentativePage.clickCompanyRepresentativeTab();
		companyRepresentativePage.clickshareHolderAccordion();

		int shareholderDetailsCount = companyRepresentativePage.getShareholderCount();
		assertEquals(shareholderDetailsCount, 1);

		ArrayList<String> shareHolderDetails = new ArrayList<String>();
		shareHolderDetails.add("TYPER1236D");
		shareHolderDetails.add("divya.s+edit@perfios.com");
		shareHolderDetails.add("Indians edit");
		shareHolderDetails.add("30/01/2019");
		shareHolderDetails.add("9876543071");
		shareHolderDetails.add("19/03/1994");
		shareHolderDetails.add("SHLine1 edit, SHLine2 edit, SHLine3 edit, SHCity edit, Haryana, 125198, SHCountry");
		shareHolderDetails.add("Tester edit");
		shareHolderDetails.add("276528359890");
		shareHolderDetails.add("AAA edit");

		for (int i = 0; i < shareHolderDetails.size(); i++) {
			companyRepresentativePage.validateShareHolderDetails(shareholderDetailsCount - 1, i,
					shareHolderDetails.get(i));
		}
	}
}
