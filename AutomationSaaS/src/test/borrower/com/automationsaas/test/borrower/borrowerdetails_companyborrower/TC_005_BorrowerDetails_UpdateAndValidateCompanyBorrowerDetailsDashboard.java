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

public class TC_005_BorrowerDetails_UpdateAndValidateCompanyBorrowerDetailsDashboard extends Base {

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
		companyRepresentativePage.clickShareHolderEditButton(0);
		companyRepresentativePage.enterShareHolderFirstName("Tester dashboard");
		companyRepresentativePage.enterShareHolderLastName("AAA dashboard");
		companyRepresentativePage.enterShareHolderEmail("divya.s+dashboard@perfios.com");
		companyRepresentativePage.enterShareHolderMobileNumber("9876543000");
		companyRepresentativePage.enterShareHolderDob("1993", "Apr", "29");
		companyRepresentativePage.enterShareHolderCitizenship("Indians dashboard");
		companyRepresentativePage.enterShareHolderIdentityNumberOne("276528359000");
		companyRepresentativePage.enterShareHolderIdentityNumberTwo("TYPER1000D");
		companyRepresentativePage.enterShareHolderDateOfAppointment("2018", "Feb", "20");

		companyRepresentativePage.enterShareHolderAddressOne("SHLine1 dashboard", "SHLine2 dashboard",
				"SHLine3 dashboard", "SHSubDistrict dashboard", "SHDistrict dashboard", "Uttar Pradesh",
				"SHCity dashboard", "SHCountry dashboard", "125000", "2009", "Jun", "22", "Staff Residence",
				"Address Two");
		companyRepresentativePage.clickEditShareHolderContinueButton();
		companyRepresentativePage.clickshareHolderAccordion();

		int shareholderDetailsCount = companyRepresentativePage.getShareholderCount();
		assertEquals(shareholderDetailsCount, 1);

		ArrayList<String> shareHolderDetails = new ArrayList<String>();
		shareHolderDetails.add("TYPER1000D");
		shareHolderDetails.add("divya.s+dashboard@perfios.com");
		shareHolderDetails.add("Indians dashboard");
		shareHolderDetails.add("20/02/2018");
		shareHolderDetails.add("9876543000");
		shareHolderDetails.add("29/04/1993");
		shareHolderDetails.add(
				"SHLine1 dashboard, SHLine2 dashboard, SHLine3 dashboard, SHCity dashboard, Uttar Pradesh, 125000, SHCountry");
		shareHolderDetails.add("Tester dashboard");
		shareHolderDetails.add("276528359000");
		shareHolderDetails.add("AAA dashboard");

		for (int i = 0; i < shareHolderDetails.size(); i++) {
			companyRepresentativePage.validateShareHolderDetails(shareholderDetailsCount - 1, i,
					shareHolderDetails.get(i));
		}
	}
}
