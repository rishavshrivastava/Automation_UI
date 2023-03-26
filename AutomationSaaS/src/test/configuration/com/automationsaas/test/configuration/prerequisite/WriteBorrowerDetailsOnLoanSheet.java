package com.automationsaas.test.configuration.prerequisite;

import org.testng.annotations.Test;

import com.automationsaas.utilities.Interface;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class WriteBorrowerDetailsOnLoanSheet implements Interface {

	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class, groups={"WriteBorrowerDetailsOnLoanSheet.updateBorrower"})
	public void updateBorrower() {
		String individualBorrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String individualBorrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		String individualBorrowerLoanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		
		ReadWriteExcel.putData(excel_path, loan_sheet_name, 1, 1, individualBorrowerLoanId);
		ReadWriteExcel.putData(excel_path, loan_sheet_name, 2, 1, individualBorrowerId);
		ReadWriteExcel.putData(excel_path, loan_sheet_name, 3, 1, individualBorrowerMailId);
	}
}