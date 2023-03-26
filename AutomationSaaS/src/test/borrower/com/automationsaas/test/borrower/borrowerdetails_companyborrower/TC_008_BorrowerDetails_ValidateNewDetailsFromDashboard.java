package com.automationsaas.test.borrower.borrowerdetails_companyborrower;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.CompanyRepresentativePage;
import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_008_BorrowerDetails_ValidateNewDetailsFromDashboard extends Base {

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
		addedshareholderdetails_1.add("TYPER1233D");
		addedshareholderdetails_1.add("divya.s+one@perfios.com");
		addedshareholderdetails_1.add("Indians one");
		addedshareholderdetails_1.add("31/01/2017");
		addedshareholderdetails_1.add("9876543072");
		addedshareholderdetails_1.add("18/03/1995");
		addedshareholderdetails_1
				.add("SHLine1 one, SHLine2 one, SHLine3 one, SHCity one, Uttar Pradesh, 125193, SHCountry one");
		addedshareholderdetails_1.add("Tester one");
		addedshareholderdetails_1.add("276528359893");
		addedshareholderdetails_1.add("AAA one");

		ArrayList<String> addedshareholderdetails_2 = new ArrayList<String>();
		addedshareholderdetails_2.add("TYPER1234D");
		addedshareholderdetails_2.add("divya.s+two@perfios.com");
		addedshareholderdetails_2.add("Indians two");
		addedshareholderdetails_2.add("18/01/2018");
		addedshareholderdetails_2.add("9876543074");
		addedshareholderdetails_2.add("28/03/1996");
		addedshareholderdetails_2
				.add("SHLine1 two, SHLine2 two, SHLine3 two, SHCity two, Karnataka, 125199, SHCountry two");
		addedshareholderdetails_2.add("Tester two");
		addedshareholderdetails_2.add("276528359894");
		addedshareholderdetails_2.add("AAA two");

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
			if (i == 2) {
				{
					for (int j = 0; j < addedshareholderdetails_2.size(); j++) {
						companyRepresentativePage.validateShareHolderDetails(i, j, addedshareholderdetails_2.get(j));
					}
				}
			}

		}
	}
}
