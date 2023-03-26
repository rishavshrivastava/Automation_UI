package com.automationsaas.test.borrower.borroweronboarding;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borroweronboarding.ApplyForLoanPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_BorrowerOnboarding_ApplyLoan_ForExistingBorrower extends Base {

	@Test
	(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void validateIndividualBorrowerOnboarding() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickApplyLoan();
		ApplyForLoanPage applyForLoanPage = new ApplyForLoanPage(driver);
		applyForLoanPage.clickContinueWithoutValidation();
		applyForLoanPage.validateApplyForLoanHeading("Apply for Loan");
		applyForLoanPage.selectLoanProduct("Personal Loan");
		applyForLoanPage.enterLoanAmount("200000");
		Generics.waitForFewSecondstoLoad(1000);
		applyForLoanPage.selectInterest("9 %");
		Generics.waitForFewSecondstoLoad(1000);
		applyForLoanPage.selectLoanRepaymentType("Even Repayments");
		Generics.waitForFewSecondstoLoad(1000);
		applyForLoanPage.selectTenure("1 Year");
		applyForLoanPage.clickGetDetails();
		
		ArrayList<String> loanDetails = new ArrayList<String>();
		loanDetails.add("Rs200,000");
		loanDetails.add("9.00%");
		loanDetails.add("Rs0");
		loanDetails.add("12 Months");
		loanDetails.add("Rs209,884");
		loanDetails.add("");
		
		for(int i=0; i<loanDetails.size(); i++) {
			applyForLoanPage.validateLoanDetails(i, loanDetails.get(i));
		}
		
		applyForLoanPage.clickApplyLoan();
		applyForLoanPage.clickTenantLogo();
		
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);
		String borrowerId = borrowerDashboardPage.getBorrowerId();
		String[] splittedBorrowerId = borrowerId.split("\\n");
		System.out.println(splittedBorrowerId[1]);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 2, 1, splittedBorrowerId[1]);
		borrowerDashboardPage.validateProfileStatus("Approved");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		String loanId = borrowerDashboardPage.getGeneratedLoanIdBasedOnSequenceProvided(0);
		System.out.println(loanId);
		ReadWriteExcel.putData(excel_path, borrower_sheet_name, 3, 1, loanId);
	}
}
