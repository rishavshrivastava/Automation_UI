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

public class TC_003_BorrowerDetails_UpdateAndValidateCompanyBorrowerDetailsAdmin extends Base {

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
		loanDetailsPage.editCompanyRepresentative(0);

		loanDetailsPage.enterShareHolderFirstName("Tester edit");
		loanDetailsPage.enterShareHolderLastName("AAA edit");
		loanDetailsPage.enterShareHolderEmail("divya.s+edit@perfios.com");
		loanDetailsPage.enterShareHolderMobileNumber("9876543071");
		loanDetailsPage.enterShareHolderDob("1994", "Mar", "19");
		loanDetailsPage.enterShareHolderCitizenship("Indians edit");
		loanDetailsPage.enterShareHolderIdentityNumberOne("276528359890");
		loanDetailsPage.enterShareHolderIdentityNumberTwo("TYPER1236D");
		loanDetailsPage.enterShareHolderDateOfAppointment("2019", "Jan", "30");

		loanDetailsPage.enterShareHolderAddressOne("SHLine1 edit", "SHLine2 edit", "SHLine3 edit", "SHSubDistrict edit",
				"SHDistrict edit", "Haryana", "SHCity edit", "SHCountry edit", "125198", "2008", "Apr", "12",
				"Double story house", "Address One");
		loanDetailsPage.clickEditShareHolderContinueButton();
		loanDetailsPage.clickShareHolderAccordion();

		// Divya: update script once
		// https://emu.hinagro.com/perfios/integreat/-/issues/16871 is fixed.

		ArrayList<String> addedshareholderdetails = new ArrayList<String>();

		addedshareholderdetails.add("19/03/1994");
		addedshareholderdetails.add("TYPER1236D");
		addedshareholderdetails.add("AAA edit");
		addedshareholderdetails.add("divya.s+edit@perfios.com");
		addedshareholderdetails.add("276528359890");
		addedshareholderdetails.add("Tester edit");
		addedshareholderdetails
				.add("SHLine1 edit, SHLine2 edit, SHLine3 edit, SHCity edit, Haryana, 125198, SHCountry");
		addedshareholderdetails.add("9876543071");
		addedshareholderdetails.add("Indians edit");
		addedshareholderdetails.add("30/01/2019");

		int shareHolderCount = loanDetailsPage.getShareholderCount();
		assertEquals(shareHolderCount, 1);

		for (int i = 0; i < addedshareholderdetails.size(); i++) {
			loanDetailsPage.validateShareHolderDetails(shareHolderCount - 1, i, addedshareholderdetails.get(i));
		}

	}
}
