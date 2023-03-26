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

public class TC_011_BorrowerDetails_UpdateAndValidateNewDetailsFromAdmin extends Base {

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

		loanDetailsPage.editCompanyRepresentative(2);

		loanDetailsPage.enterShareHolderFirstName("Tester admin");
		loanDetailsPage.enterShareHolderLastName("AAA admin");
		loanDetailsPage.enterShareHolderEmail("divya.s+admin@perfios.com");
		loanDetailsPage.enterShareHolderMobileNumber("9876543070");
		loanDetailsPage.enterShareHolderDob("1994", "Mar", "18");
		loanDetailsPage.enterShareHolderCitizenship("Indians admin");
		loanDetailsPage.enterShareHolderIdentityNumberOne("276528359891");
		loanDetailsPage.enterShareHolderIdentityNumberTwo("TYPER1231D");
		loanDetailsPage.enterShareHolderDateOfAppointment("2019", "Jan", "31");

		loanDetailsPage.enterShareHolderAddressOne("SHLine1 admin", "SHLine2 admin", "SHLine3 admin",
				"SHSubDistrict admin", "SHDistrict admin", "Karnataka", "SHCity admin", "SHCountry admin", "125191",
				"2008", "Apr", "11", "Double story house", "Address One");
		loanDetailsPage.clickEditShareHolderContinueButton();
		loanDetailsPage.clickShareHolderAccordion();

		// Divya: update script once
		// https://emu.hinagro.com/perfios/integreat/-/issues/16871 is fixed.

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
		addedshareholderdetails_1.add("18/04/1994");
		addedshareholderdetails_1.add("TYPER1001D");
		addedshareholderdetails_1.add("AAA borrower");
		addedshareholderdetails_1.add("divya.s+borrower@perfios.com");
		addedshareholderdetails_1.add("276528359001");
		addedshareholderdetails_1.add("Tester borrower");
		addedshareholderdetails_1.add(
				"SHLine1 borrower, SHLine2 borrower, SHLine3 borrower, SHCity borrower, Uttar Pradesh, 125000, SHCountry one");
		addedshareholderdetails_1.add("9876543001");
		addedshareholderdetails_1.add("Indians borrower");
		addedshareholderdetails_1.add("21/02/2019");

		ArrayList<String> addedshareholderdetails_2 = new ArrayList<String>();
		addedshareholderdetails_2.add("18/03/1994");
		addedshareholderdetails_2.add("TYPER1231D");
		addedshareholderdetails_2.add("AAA admin");
		addedshareholderdetails_2.add("divya.s+admin@perfios.com");
		addedshareholderdetails_2.add("276528359891");
		addedshareholderdetails_2.add("Tester admin");
		addedshareholderdetails_2
				.add("SHLine1 admin, SHLine2 admin, SHLine3 admin, SHCity admin, Karnataka, 125191, SHCountry two");
		addedshareholderdetails_2.add("9876543070");
		addedshareholderdetails_2.add("Indians admin");
		addedshareholderdetails_2.add("31/01/2019");

		for (int i = 0; i < loanDetailsPage.getShareholderCount(); i++) {
			if (i == 0) {
				for (int j = 0; j < addedshareholderdetails_0.size(); j++) {
					loanDetailsPage.validateShareHolderDetails(i, j, addedshareholderdetails_0.get(j));
				}
			} else if (i == 1) {
				for (int j = 0; j < addedshareholderdetails_1.size(); j++) {
					loanDetailsPage.validateShareHolderDetails(i, j, addedshareholderdetails_1.get(j));
				}
			} else if (i == 2) {
				for (int j = 0; j < addedshareholderdetails_2.size(); j++) {
					loanDetailsPage.validateShareHolderDetails(i, j, addedshareholderdetails_2.get(j));
				}
			}
		}
	}
}
