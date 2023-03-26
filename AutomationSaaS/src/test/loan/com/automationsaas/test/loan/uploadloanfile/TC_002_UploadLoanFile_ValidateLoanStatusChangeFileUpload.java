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
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_UploadLoanFile_ValidateLoanStatusChangeFileUpload extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
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
		uploadLoanFilePage.selectFileFormat("Loan Application Status Change File");

		// Update File
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String LoanId = ReadWriteExcel.getData(excel_path, loanfile_sheet_name, "Loan Id").get(1);

		ArrayList<String> loanStatusChangeDetails = new ArrayList<String>();
		loanStatusChangeDetails.add("1");
		loanStatusChangeDetails.add(LoanId);
		loanStatusChangeDetails.add("APPROVED");
		loanStatusChangeDetails.add("Status change for testing");

		for (int i = 0; i < (loanStatusChangeDetails.size() - (loanStatusChangeDetails.size() - 1)); i++) {
			ReadWriteExcel.createCellData(loan_statuschange_file_path, loan_statuschange_file_sheet_name, 1, i,
					loanStatusChangeDetails.get(i));
		}

		for (int i = 1; i < loanStatusChangeDetails.size(); i++) {
			ReadWriteExcel.putData(loan_statuschange_file_path, loan_statuschange_file_sheet_name, 1, i,
					loanStatusChangeDetails.get(i));
		}
		
		
		uploadLoanFilePage.selectUploadFileType("Loan Application Status Change File");
		uploadLoanFilePage.chooseLoanFile(loan_statuschange_file_path);
		uploadLoanFilePage.clickSubmit();
		uploadLoanFilePage.validateUploadLoanFileNotification("Loan Application Status Change File has been saved.");
		
		//Validate if uploaded file got processed
		driver.get("https://automationtest.sandbox.integreat.perfios.com/uploadedFile/list");
		UploadedFileReportPage uploadedFileReportPage = new UploadedFileReportPage(driver);
		uploadedFileReportPage.validateFileType("LOAN_APPLICATION_STATUS_CHANGE_FILE");
		uploadedFileReportPage.clickViewResult();
		uploadedFileReportPage.validateLoanFileUploadStatus("APPROVED");
		uploadedFileReportPage.clickClose();
		
		//Validate if loan status has been changed
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/ALL");
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		String loanId = ReadWriteExcel.getDataXY(loan_statuschange_file_path, loan_statuschange_file_sheet_name, 1, 1);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanId);
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.validateLoanStatus("Application Approved");
	}
}
