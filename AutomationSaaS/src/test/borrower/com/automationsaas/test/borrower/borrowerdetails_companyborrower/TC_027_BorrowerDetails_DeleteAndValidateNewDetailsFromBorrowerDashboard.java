package com.automationsaas.test.borrower.borrowerdetails_companyborrower;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.CompanyRepresentativePage;
import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_027_BorrowerDetails_DeleteAndValidateNewDetailsFromBorrowerDashboard extends Base {

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
		companyRepresentativePage.clickDeleteShareHolder("Yes", 0);

		Generics.refreshPage(driver);
		companyRepresentativePage.clickCompanyRepresentativeTab();
		companyRepresentativePage.clickshareHolderAccordion();
		companyRepresentativePage.validateIfNoShareHolderDetailsAreDisplayed("No records found");
	}
}