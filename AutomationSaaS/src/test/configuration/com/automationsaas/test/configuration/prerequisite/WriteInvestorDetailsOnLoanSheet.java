package com.automationsaas.test.configuration.prerequisite;

import org.testng.annotations.Test;

import com.automationsaas.utilities.Interface;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class WriteInvestorDetailsOnLoanSheet implements Interface {

	@Test(priority = 4, retryAnalyzer = RetryAnalyzer.class, groups={"WriteInvestorDetailsOnLoanSheet.updateBorrower"})
	public void updateBorrower() {
		String individualInvestorMailId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		String individualInvestorId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor ID").get(1);
		
		ReadWriteExcel.putData(excel_path, loan_sheet_name, 4, 1, individualInvestorId);
		ReadWriteExcel.putData(excel_path, loan_sheet_name, 5, 1, individualInvestorMailId);
	}
}