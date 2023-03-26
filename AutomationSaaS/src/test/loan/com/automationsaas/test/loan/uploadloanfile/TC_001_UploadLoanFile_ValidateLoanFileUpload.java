package com.automationsaas.test.loan.uploadloanfile;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.pom.uploadloanfile.UploadLoanFilePage;
import com.automationsaas.pom.uploadloanfile.UploadedFileReportPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_UploadLoanFile_ValidateLoanFileUpload extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void validateLoanFileUpload() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickUploadLoanFile();
		
		UploadLoanFilePage uploadLoanFilePage = new UploadLoanFilePage(driver);
		uploadLoanFilePage.selectFileFormat("Loan File");
		
		//Update File
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> loanData = new ArrayList<String>();
		loanData.add("LN"+Generics.getRandomNumber(5));
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		loanData.add(borrowerId);
		ReadWriteExcel.putData(excel_path, loanfile_sheet_name, 1, 1, loanData.get(0));
		String borrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loanData.add(borrowerMailId);
		loanData.add(borrowerMailId);
		loanData.add("Mr");
		loanData.add("Rishav");
		loanData.add("S");
		loanData.add("Shrivastava");
		loanData.add("");
		loanData.add("");
		loanData.add("20/02/1995");
		loanData.add("MALE");
		loanData.add("MARRIED");
		loanData.add("INDIAN");
		loanData.add("Individual");
		loanData.add("");
		loanData.add("ASBPK7657A");
		loanData.add("G-6 STERLING HOUSE STATION ROAD");
		loanData.add("NEAR DENA BANK");
		loanData.add("");
		loanData.add("MUMBAI");
		loanData.add("MAHARASHTRA");
		loanData.add("401101");
		loanData.add("");
		loanData.add("");
		loanData.add("60000");
		loanData.add("Personal Loan	");
		loanData.add("5");
		loanData.add("6");
		loanData.add("Initialized");
		loanData.add("");
		loanData.add("SALARIED");
		loanData.add("");
		loanData.add("");
		loanData.add("");
		loanData.add("87876565454");
		loanData.add("SAVINGS");
		loanData.add("UBIN0539287");
		loanData.add("400026071");
		loanData.add("UNION BANK OF INDIA");
		loanData.add("BHAYANDER EAST");
		loanData.add("Delhi");
		loanData.add("");
		loanData.add("25/03/2022");
 		
		
		for(int i=0; i<(loanData.size()-(loanData.size()-1)); i++) {
			ReadWriteExcel.createCellData(loan_generate_file_path, loan_generate_file_sheet_name, 1,  i, loanData.get(i));
		}
		
		for(int i=1; i<loanData.size(); i++) {
			ReadWriteExcel.putData(loan_generate_file_path, "Sheet1", 1, i, loanData.get(i));
		}
		
		uploadLoanFilePage.selectUploadFileType("Loan File");
		uploadLoanFilePage.chooseLoanFile(loan_generate_file_path);
		uploadLoanFilePage.clickSubmit();
		uploadLoanFilePage.validateUploadLoanFileNotification("Loan File has been saved.");
		
		
		//Validate if uploaded file got processed
		driver.get("https://automationtest.sandbox.integreat.perfios.com/uploadedFile/list");
		UploadedFileReportPage uploadedFileReportPage = new UploadedFileReportPage(driver);
		uploadedFileReportPage.validateFileType("LOAN_FILE");
		uploadedFileReportPage.clickViewResult();
		uploadedFileReportPage.validateLoanFileUploadStatus("Loan created.");
		uploadedFileReportPage.clickClose();
		
		//Validate if Loan has been created
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_generate_file_path, loan_generate_file_sheet_name, 1, 0);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
	}
}
