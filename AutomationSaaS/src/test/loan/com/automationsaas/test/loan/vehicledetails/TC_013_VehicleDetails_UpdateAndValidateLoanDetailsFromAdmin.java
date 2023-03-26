package com.automationsaas.test.loan.vehicledetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_013_VehicleDetails_UpdateAndValidateLoanDetailsFromAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void updateBorrower() {
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

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		String borrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);

		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();

		ArrayList<String> searchedLoan = new ArrayList<String>();
		searchedLoan.add(loanId);
		searchedLoan.add("Rs200,000");
		searchedLoan.add("12 Months");
		searchedLoan.add("9.00 %");
		searchedLoan.add("Initialized");
		searchedLoan.add("Personal Loan");
		searchedLoan.add("Individual");
		searchedLoan.add(borrowerMailId);

		for (int i = 0; i < searchedLoan.size(); i++) {
			loanApplicationsPage.validateSearchedLoan(i, searchedLoan.get(i));
		}

		loanApplicationsPage.clickLoanId();

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.clickVehicleDetailsAccordion();
		
		loanDetailsPage.clickVehicleDetailsEdit();
		ArrayList<String> vehicleDetails = new ArrayList<String>();
		vehicleDetails.add("TVS");
		vehicleDetails.add("DL76TY");
		vehicleDetails.add("Test");
		for(int i=0;i<vehicleDetails.size();i++) {
			loanDetailsPage.editVehicleDetails(i, vehicleDetails.get(i));
		}
		loanDetailsPage.clickEditVehicleDetailsDone();
		ArrayList<String> editedVehicleDetails = new ArrayList<String>();
		editedVehicleDetails.add("TVS");
		editedVehicleDetails.add("DL76TY");
		editedVehicleDetails.add("Test");
		for(int i=0;i<editedVehicleDetails.size();i++) {
			loanDetailsPage.validateVehicleDetails(i, editedVehicleDetails.get(i));
		}
	}
}