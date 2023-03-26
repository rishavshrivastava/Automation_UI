package com.automationsaas.test.loan.repaymentschedulerestructure;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;

public class ValidateRepaymentFullSettlement extends Base {

	@Test
	public void fullSettlement() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/loanApplicationDetail/f9ead3ce-bbba-4108-b6b5-33ec9b2e0f45");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		loginPage.enterUsername(username);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.waitForRepaymentScheduleTable();
		loanDetailsPage.clickAction();
		loanDetailsPage.clickRepaymentScheduleStructure();
		loanDetailsPage.clickFullSettlement();
		loanDetailsPage.enterFullSettlementPaymentAmount("30000");
		loanDetailsPage.waitForFullSettlementPaymentAmountNotification();
		loanDetailsPage.enterRemainingRepaymentInterest("");
		loanDetailsPage.enterRemainingRepaymentPenalty("");
		loanDetailsPage.enterRemainingRepaymentChequeBouncingCharge("");
		loanDetailsPage.enterRemainingFullSettlementPenalty("");
		loanDetailsPage.enterRemainingFullSettlementTax("");
		loanDetailsPage.enterRemainingFullSettlementDiscount("");
		loanDetailsPage.clickFullSettlementPay();
		loanDetailsPage.waitForFullSettlementPayNotification();
	}
}
