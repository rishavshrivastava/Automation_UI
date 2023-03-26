package com.automationsaas.test.loan.repaymentschedulerestructure;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;

public class ValidateRepaymenPartialRepayment extends Base {

	@Test(priority=1, dependsOnGroups="movingLoanStatusToUnderRepayment")
	public void enterPaymentAmount() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickPartialRepayment();
		loanDetailsPage.enterPaymentAmount("5000");
		loanDetailsPage.uncheckAllowGapDayInterest();
		loanDetailsPage.clickPay();
		loanDetailsPage.waitForRepaymnentScheduleChangedNotification();
	}
	
	@Test(dependsOnGroups="movingLoanStatusToUnderRepayment")
	public void selectNewTenure() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickPartialRepayment();
		loanDetailsPage.selectNewTenure("2 Months");
		loanDetailsPage.uncheckAllowGapDayInterest();
		loanDetailsPage.clickPay();
		loanDetailsPage.waitForRepaymnentScheduleChangedNotification();
	}
	
	@Test(dependsOnGroups="movingLoanStatusToUnderRepayment")
	public void selectNewInterestRate() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickPartialRepayment();
		loanDetailsPage.selectNewInterest("10 %");
		loanDetailsPage.uncheckAllowGapDayInterest();
		loanDetailsPage.clickPay();
		loanDetailsPage.waitForRepaymnentScheduleChangedNotification();
	}
	
	@Test(dependsOnGroups="movingLoanStatusToUnderRepayment")
	public void selectNewRepaymentDate() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickPartialRepayment();
		loanDetailsPage.selectNewRepaymentDate("5");
		loanDetailsPage.uncheckAllowGapDayInterest();
		loanDetailsPage.clickPay();
		loanDetailsPage.waitForRepaymnentScheduleChangedNotification();
	}
	
	@Test(dependsOnGroups="movingLoanStatusToUnderRepayment")
	public void selectGapDayInterest() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickPartialRepayment();
		loanDetailsPage.uncheckAllowGapDayInterest();
		loanDetailsPage.clickPay();
		loanDetailsPage.waitForRepaymnentScheduleChangedNotification();
	}
	
	@Test(dependsOnGroups="movingLoanStatusToUnderRepayment")
	public void enterEarlyRepaymentPenalty() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickPartialRepayment();
		loanDetailsPage.enterEarlyRepaymentPenalty("500");
		loanDetailsPage.uncheckAllowGapDayInterest();
		loanDetailsPage.clickPay();
		loanDetailsPage.waitForRepaymnentScheduleChangedNotification();
	}
	
	@Test(dependsOnGroups="movingLoanStatusToUnderRepayment")
	public void enterEarlyRepaymentTax() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickPartialRepayment();
		loanDetailsPage.enterEarlyRepaymentTax("1000");
		loanDetailsPage.uncheckAllowGapDayInterest();
		loanDetailsPage.clickPay();
		loanDetailsPage.waitForRepaymnentScheduleChangedNotification();
	}
	
	@Test(dependsOnGroups="movingLoanStatusToUnderRepayment")
	public void enterEarlyRepaymentDiscount() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickPartialRepayment();
		loanDetailsPage.enterEarlyRepaymentDiscount("300");
		loanDetailsPage.uncheckAllowGapDayInterest();
		loanDetailsPage.clickPay();
		loanDetailsPage.waitForRepaymnentScheduleChangedNotification();
	}
	
	@Test(dependsOnGroups="movingLoanStatusToUnderRepayment")
	public void enterPartialRepayment() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickPartialRepayment();
		loanDetailsPage.enterPaymentAmount("5000");
		loanDetailsPage.selectNewTenure("5 Months");
		loanDetailsPage.selectNewInterest("8 %");
		loanDetailsPage.selectNewRepaymentDate("2");
		loanDetailsPage.checkAllowGapDayInterest();
		loanDetailsPage.enterEarlyRepaymentPenalty("500");
		loanDetailsPage.enterEarlyRepaymentTax("1000");
		loanDetailsPage.enterEarlyRepaymentDiscount("300");
	}
}
