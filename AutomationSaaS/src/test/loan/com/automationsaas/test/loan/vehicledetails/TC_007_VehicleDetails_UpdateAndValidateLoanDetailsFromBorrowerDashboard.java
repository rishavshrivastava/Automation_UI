package com.automationsaas.test.loan.vehicledetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_007_VehicleDetails_UpdateAndValidateLoanDetailsFromBorrowerDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/borrower");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Borrower Dashboard
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		
		borrowerDashboardPage.validateBorrowerId(borrowerId);
		borrowerDashboardPage.validateLoanId(loanId);

		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Initialized");
		borrowerDashboardPage.clickLoanDetailsButton();
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.clickDetails();
		loanDetailsPage.clickVehicleDetailsAccordion();
		
		loanDetailsPage.clickVehicleDetailsEdit();
		ArrayList<String> vehicleDetails = new ArrayList<String>();
		vehicleDetails.add("Royal");
		vehicleDetails.add("DL875TD");
		vehicleDetails.add("Testing");
		for(int i=0; i<vehicleDetails.size();i++) {
			loanDetailsPage.editVehicleDetails(i, vehicleDetails.get(i));
		}
		loanDetailsPage.clickEditVehicleDetailsDone();
		
		ArrayList<String> updatedVehicleDetails = new ArrayList<String>();
		updatedVehicleDetails.add("Royal");
		updatedVehicleDetails.add("DL875TD");
		updatedVehicleDetails.add("Testing");
		for(int i=0; i<updatedVehicleDetails.size();i++) {
			loanDetailsPage.validateVehicleDetails(i, updatedVehicleDetails.get(i));
		}
	}
}