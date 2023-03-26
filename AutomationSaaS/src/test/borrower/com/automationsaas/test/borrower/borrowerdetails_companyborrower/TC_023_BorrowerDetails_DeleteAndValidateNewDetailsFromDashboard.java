package com.automationsaas.test.borrower.borrowerdetails_companyborrower;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.CompanyRepresentativePage;
import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_023_BorrowerDetails_DeleteAndValidateNewDetailsFromDashboard extends Base {

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
		companyRepresentativePage.clickDeleteShareHolder("Yes", 1);

		Generics.refreshPage(driver);
		companyRepresentativePage.clickCompanyRepresentativeTab();
		companyRepresentativePage.clickshareHolderAccordion();

		ArrayList<String> addedshareholderdetails_0 = new ArrayList<String>();
		addedshareholderdetails_0.add("TYPER1000D");
		addedshareholderdetails_0.add("divya.s+dashboard@perfios.com");
		addedshareholderdetails_0.add("Indians dashboard");
		addedshareholderdetails_0.add("20/02/2018");
		addedshareholderdetails_0.add("9876543000");
		addedshareholderdetails_0.add("29/04/1993");
		addedshareholderdetails_0.add(
				"SHLine1 dashboard, SHLine2 dashboard, SHLine3 dashboard, SHCity dashboard, Uttar Pradesh, 125000, SHCountry");
		addedshareholderdetails_0.add("Tester dashboard");
		addedshareholderdetails_0.add("276528359000");
		addedshareholderdetails_0.add("AAA dashboard");

		ArrayList<String> addedshareholderdetails_1 = new ArrayList<String>();
		addedshareholderdetails_1.add("TYPER1000Z");
		addedshareholderdetails_1.add("divya.s+xyz@perfios.com");
		addedshareholderdetails_1.add("Indians xyz");
		addedshareholderdetails_1.add("20/03/2009");
		addedshareholderdetails_1.add("9876543011");
		addedshareholderdetails_1.add("19/05/1994");
		addedshareholderdetails_1
				.add("SHLine1 xyz, SHLine2 xyz, SHLine3 xyz, SHCity xyz, Haryana, 125023, SHCountry xyz");
		addedshareholderdetails_1.add("Tester xyz");
		addedshareholderdetails_1.add("476528359000");
		addedshareholderdetails_1.add("AAA xyz");

		for (int i = 0; i < companyRepresentativePage.getShareholderCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < addedshareholderdetails_0.size(); j++) {
					companyRepresentativePage.validateShareHolderDetails(i, j, addedshareholderdetails_0.get(j));
				}
			}
			if (i == 1) {
				for (int j = 0; j < addedshareholderdetails_1.size(); j++) {
					companyRepresentativePage.validateShareHolderDetails(i, j, addedshareholderdetails_1.get(j));
				}
			}
		}

	}
}
