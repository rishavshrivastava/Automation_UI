package com.automationsaas.utilities;

import java.io.File;

public interface Interface {

	String basePath = new File("").getAbsolutePath();
	
	final String excel_path = basePath + "/data/automationsaasdetails.xlsx";	
	final String credential_sheet_name = "Credentials";	
	final String borrower_sheet_name = "BorrowerDetails";
	final String investor_sheet_name = "InvestorDetails";
	final String dsa_sheet_name = "DSADetails";
	final String loan_sheet_name = "LoanDetails";
	final String repayments_sheet_name = "Repayment Dates";
	final String loanfile_sheet_name = "LoanFIles";
	final String fia_sheet_name = "FIADetails";
	
	final String loan_generate_file_path = basePath + "/downloadedFiles/LoanGenerate.xlsx";
	final String loan_generate_file_sheet_name = "Sheet1";
	final String loan_statuschange_file_path = basePath + "/downloadedFiles/ChangeLoanApplicationStatus.xls";
	final String loan_statuschange_file_sheet_name = "Sheet1";
	final String loan_repayment_file_path = basePath + "/downloadedFiles/LoanRepaymentFile.xls";
	final String loan_repayment_file_sheet_name = "Sheet1";
	
	final String png_upload_file_path = basePath + "/data/PNGFile.png";
	final String jpeg_upload_file_path = basePath + "/data/JPEGFile.jpeg";
	final String jpg_upload_file_path = basePath + "/data/JPGFile.jpg";
	final String text_upload_file_path = basePath + "/data/TextFile.txt";
	final String pdf_upload_file_path = basePath + "/data/PDFFile.pdf";
	final String excel_upload_file_path = basePath + "ExcelFile.xlsx";
	
	final String upload_contractfile_path = basePath + "/downloadedFiles/";
	
	final String execution_report_path = basePath + "/executionReports/";
	
	//Borrower
	final String TC_001_AddressDetails_ValidateIndividualBorrowerDetailsDashboard = basePath + "/src/testdata/borrower/com/automationsaas/testdata/borrower/addressdetails/TC_001_AddressDetails_ValidateIndividualBorrowerDetailsDashboard.json";
	final String TC_002_AddressDetails_ValidateIndividualBorrowerDetailsAdmin = basePath + "/src/testdata/borrower/com/automationsaas/testdata/borrower/addressdetails/TC_002_AddressDetails_ValidateIndividualBorrowerDetailsAdmin.json";
	final String TC_003_AddressDetails_DeleteAndValidateOldBorrowerDetailsAdmin = basePath + "/src/testdata/borrower/com/automationsaas/testdata/borrower/addressdetails/TC_003_AddressDetails_DeleteAndValidateOldBorrowerDetailsAdmin.json";
	
	//Investor
	final String TC_001_AddressDetails_DeleteAndValidateOldInvestorDetailsAdmin = basePath + "/src/testdata/investor/com/automationsaas/testdata/investor/addressdetails/TC_001_AddressDetails_DeleteAndValidateOldInvestorDetailsAdmin.json";
	
	//DSA
	final String TC_001_BankDetails_ValidateDsaDetailsDashboard = basePath + "/src/testdata/dsa/com/automationsaas/testdata/dsa/bankdetails/TC_001_BankDetails_ValidateDsaDetailsDashboard.json";
	
	//FIA
	final String TC_01_FIAOnboarding = basePath + "/src/testdata/fia/com/automationsaas/testdata/validatefia/TC_01_FIAOnboarding.json";
	
	//Loan
	final String TC_001_BorrowerContract_ValidateLoanFromBorrowerDashboard = basePath + "/src/testdata/loan/com/automationsaas/testdata/loan/borrowercontract/TC_001_BorrowerContract_ValidateLoanFromBorrowerDashboard.json";
}
