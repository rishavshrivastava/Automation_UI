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

public class TC_017_BorrowerDetails_AddAndValidateNewDetailsFromDashboard extends Base {

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

		companyRepresentativePage.clickCreateShareHolder();
		companyRepresentativePage.enterShareHolderFirstName("Tester abc");
		companyRepresentativePage.enterShareHolderLastName("AAA abc");
		companyRepresentativePage.enterShareHolderEmail("divya.s+abc@perfios.com");
		companyRepresentativePage.enterShareHolderMobileNumber("8876543000");
		companyRepresentativePage.enterShareHolderDob("1994", "Apr", "20");
		companyRepresentativePage.enterShareHolderCitizenship("Indians abc");
		companyRepresentativePage.enterShareHolderIdentityNumberOne("376528359000");
		companyRepresentativePage.enterShareHolderIdentityNumberTwo("TYPER1000A");
		companyRepresentativePage.enterShareHolderDateOfAppointment("2008", "Feb", "18");

		companyRepresentativePage.enterShareHolderAddressOne("SHLine1 abc", "SHLine2 abc", "SHLine3 abc",
				"SHSubDistrict dashboard", "SHDistrict dashboard", "Karnataka", "SHCity abc", "SHCountry abc", "125022",
				"2010", "Mar", "12", "Single Story House", "Address Three");

		companyRepresentativePage.clickCreateShareHolderContinueButton();
		Generics.refreshPage(driver);

		companyRepresentativePage.clickCompanyRepresentativeTab();
		companyRepresentativePage.clickshareHolderAccordion();
		companyRepresentativePage.clickCreateShareHolder();
		companyRepresentativePage.enterShareHolderFirstName("Tester xyz");
		companyRepresentativePage.enterShareHolderLastName("AAA xyz");
		companyRepresentativePage.enterShareHolderEmail("divya.s+xyz@perfios.com");
		companyRepresentativePage.enterShareHolderMobileNumber("9876543011");
		companyRepresentativePage.enterShareHolderDob("1994", "May", "19");
		companyRepresentativePage.enterShareHolderCitizenship("Indians xyz");
		companyRepresentativePage.enterShareHolderIdentityNumberOne("476528359000");
		companyRepresentativePage.enterShareHolderIdentityNumberTwo("TYPER1000Z");
		companyRepresentativePage.enterShareHolderDateOfAppointment("2009", "Mar", "20");

		companyRepresentativePage.enterShareHolderAddressOne("SHLine1 xyz", "SHLine2 xyz", "SHLine3 xyz",
				"SHSubDistrict xyz", "SHDistrict xyz", "Haryana", "SHCity xyz", "SHCountry xyz", "125023", "2010",
				"Aug", "12", "Double story house", "Address Three");

		companyRepresentativePage.clickCreateShareHolderContinueButton();
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
		addedshareholderdetails_1.add("TYPER1000A");
		addedshareholderdetails_1.add("divya.s+abc@perfios.com");
		addedshareholderdetails_1.add("Indians abc");
		addedshareholderdetails_1.add("18/02/2008");
		addedshareholderdetails_1.add("8876543000");
		addedshareholderdetails_1.add("20/04/1994");
		addedshareholderdetails_1
				.add("SHLine1 abc, SHLine2 abc, SHLine3 abc, SHCity abc, Karnataka, 125022, SHCountry abc");
		addedshareholderdetails_1.add("Tester abc");
		addedshareholderdetails_1.add("376528359000");
		addedshareholderdetails_1.add("AAA abc");

		ArrayList<String> addedshareholderdetails_2 = new ArrayList<String>();
		addedshareholderdetails_2.add("TYPER1000Z");
		addedshareholderdetails_2.add("divya.s+xyz@perfios.com");
		addedshareholderdetails_2.add("Indians xyz");
		addedshareholderdetails_2.add("20/03/2009");
		addedshareholderdetails_2.add("9876543011");
		addedshareholderdetails_2.add("19/05/1994");
		addedshareholderdetails_2
				.add("SHLine1 xyz, SHLine2 xyz, SHLine3 xyz, SHCity xyz, Haryana, 125023, SHCountry xyz");
		addedshareholderdetails_2.add("Tester xyz");
		addedshareholderdetails_2.add("476528359000");
		addedshareholderdetails_2.add("AAA xyz");

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
				for (int j = 0; j < addedshareholderdetails_2.size(); j++) {
					companyRepresentativePage.validateShareHolderDetails(i, j, addedshareholderdetails_2.get(j));
				}
			}
		}

	}
}
