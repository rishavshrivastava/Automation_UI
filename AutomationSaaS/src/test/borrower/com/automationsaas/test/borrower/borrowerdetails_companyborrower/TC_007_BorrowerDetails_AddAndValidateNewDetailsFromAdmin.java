package com.automationsaas.test.borrower.borrowerdetails_companyborrower;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_007_BorrowerDetails_AddAndValidateNewDetailsFromAdmin extends Base {

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
		loanDetailsPage.createShareHolder();

		loanDetailsPage.enterShareHolderFirstName("Tester one");
		loanDetailsPage.enterShareHolderLastName("AAA one");
		loanDetailsPage.enterShareHolderEmail("divya.s+one@perfios.com");
		loanDetailsPage.enterShareHolderMobileNumber("9876543072");
		loanDetailsPage.enterShareHolderDob("1995", "Mar", "18");
		loanDetailsPage.enterShareHolderCitizenship("Indians one");
		loanDetailsPage.enterShareHolderIdentityNumberOne("276528359893");
		loanDetailsPage.enterShareHolderIdentityNumberTwo("TYPER1233D");
		loanDetailsPage.enterShareHolderDateOfAppointment("2017", "Jan", "31");

		loanDetailsPage.enterShareHolderAddressOne("SHLine1 one", "SHLine2 one", "SHLine3 one", "SHSubDistrict one",
				"SHDistrict one", "Uttar Pradesh", "SHCity one", "SHCountry one", "125193", "2009", "Apr", "22",
				"Double story house", "Address One");
		loanDetailsPage.clickContinueAddShareHolderButton();

		Generics.refreshPage(driver);
		loanDetailsPage.clickLoanDetailsPageNextSliderForCompanyRepresentative();
		loanDetailsPage.clickCompanyRepresentativeTab();
		loanDetailsPage.createShareHolder();

		loanDetailsPage.enterShareHolderFirstName("Tester two");
		loanDetailsPage.enterShareHolderLastName("AAA two");
		loanDetailsPage.enterShareHolderEmail("divya.s+two@perfios.com");
		loanDetailsPage.enterShareHolderMobileNumber("9876543074");
		loanDetailsPage.enterShareHolderDob("1996", "Mar", "28");
		loanDetailsPage.enterShareHolderCitizenship("Indians two");
		loanDetailsPage.enterShareHolderIdentityNumberOne("276528359894");
		loanDetailsPage.enterShareHolderIdentityNumberTwo("TYPER1234D");
		loanDetailsPage.enterShareHolderDateOfAppointment("2018", "Jan", "18");

		loanDetailsPage.enterShareHolderAddressOne("SHLine1 two", "SHLine2 two", "SHLine3 two", "SHSubDistrict two",
				"SHDistrict two", "Karnataka", "SHCity two", "SHCountry two", "125199", "2007", "Apr", "24",
				"Staff Residence", "Address Two");
		loanDetailsPage.clickContinueAddShareHolderButton();

		Generics.refreshPage(driver);
		loanDetailsPage.clickLoanDetailsPageNextSliderForCompanyRepresentative();
		loanDetailsPage.clickCompanyRepresentativeTab();
		loanDetailsPage.clickShareHolderAccordion();

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
		addedshareholderdetails_1.add("18/03/1995");
		addedshareholderdetails_1.add("TYPER1233D");
		addedshareholderdetails_1.add("AAA one");
		addedshareholderdetails_1.add("divya.s+one@perfios.com");
		addedshareholderdetails_1.add("276528359893");
		addedshareholderdetails_1.add("Tester one");
		addedshareholderdetails_1
				.add("SHLine1 one, SHLine2 one, SHLine3 one, SHCity one, Uttar Pradesh, 125193, SHCountry one");
		addedshareholderdetails_1.add("9876543072");
		addedshareholderdetails_1.add("Indians one");
		addedshareholderdetails_1.add("31/01/2017");

		ArrayList<String> addedshareholderdetails_2 = new ArrayList<String>();
		addedshareholderdetails_2.add("28/03/1996");
		addedshareholderdetails_2.add("TYPER1234D");
		addedshareholderdetails_2.add("AAA two");
		addedshareholderdetails_2.add("divya.s+two@perfios.com");
		addedshareholderdetails_2.add("276528359894");
		addedshareholderdetails_2.add("Tester two");
		addedshareholderdetails_2
				.add("SHLine1 two, SHLine2 two, SHLine3 two, SHCity two, Karnataka, 125199, SHCountry two");
		addedshareholderdetails_2.add("9876543074");
		addedshareholderdetails_2.add("Indians two");
		addedshareholderdetails_2.add("18/01/2018");

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
