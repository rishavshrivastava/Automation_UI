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

public class TC_001_BorrowerDetails_ValidateCompanyBorrowerDetailsDashboard extends Base {

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
		shareHolderDetails.add("TYPER1236Q");
		shareHolderDetails.add("divya.s@perfios.com");
		shareHolderDetails.add("Indians");
		shareHolderDetails.add("23/03/2016");
		shareHolderDetails.add("9876543211");
		shareHolderDetails.add("09/08/1992");
		shareHolderDetails.add("SHLine1, SHLine2, SHLine3, SHCity, Karnataka, 125098, SHCountry");
		shareHolderDetails.add("Tester");
		shareHolderDetails.add("273528359899");
		shareHolderDetails.add("AAA");

		for (int i = 0; i < shareHolderDetails.size(); i++) {
			companyRepresentativePage.validateShareHolderDetails(shareholderDetailsCount - 1, i,
					shareHolderDetails.get(i));
		}
	}
}
