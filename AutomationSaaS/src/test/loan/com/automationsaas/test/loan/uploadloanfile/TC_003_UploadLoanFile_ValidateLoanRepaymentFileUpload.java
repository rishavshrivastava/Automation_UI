package com.automationsaas.test.loan.uploadloanfile;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.adminborrower.BorrowerDetailsPage;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.pom.uploadloanfile.UploadLoanFilePage;
import com.automationsaas.pom.uploadloanfile.UploadedFileReportPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_UploadLoanFile_ValidateLoanRepaymentFileUpload extends Base {

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

		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/DISBURSED");
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.clickLoanId();
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		String loanId = loanDetailsPage.getLoanId();
		ReadWriteExcel.putData(excel_path, loanfile_sheet_name, 1, 2, loanId);
		loanDetailsPage.selectStatus("Under Repayment");
		loanDetailsPage.clickBorrower();
		BorrowerDetailsPage borrowerDetailsPage = new BorrowerDetailsPage(driver);
		borrowerDetailsPage.clickDeposit();
		borrowerDetailsPage.enterDepositAmount("100000");
		borrowerDetailsPage.clickDepositButton();
		driver.navigate().back();
		
		loanDetailsPage.clickLoanRepaymentScheduleAccordion();
		int paidEMICountBeforeFileUpload = loanDetailsPage.countLoanRepaymentPaidEMIStatus();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickUploadLoanFile();
		UploadLoanFilePage uploadLoanFilePage = new UploadLoanFilePage(driver);
		uploadLoanFilePage.selectFileFormat("Loan Repayment File");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Update File
		ArrayList<String> loanRepaymentDetails = new ArrayList<String>();
		loanRepaymentDetails.add("1");
		loanRepaymentDetails.add(loanId);
		
		for (int i1 = 0; i1 < (loanRepaymentDetails.size() - (loanRepaymentDetails.size() - 1)); i1++) {
			ReadWriteExcel.createCellData(loan_repayment_file_path, loan_repayment_file_sheet_name, 1, i1,
					loanRepaymentDetails.get(i1));
		}

		for (int i2 = 1; i2 < loanRepaymentDetails.size(); i2++) {
			ReadWriteExcel.putData(loan_repayment_file_path, loan_repayment_file_sheet_name, 1, i2,
					loanRepaymentDetails.get(i2));
		}
		
		uploadLoanFilePage.selectUploadFileType("Loan Repayment File");
		uploadLoanFilePage.chooseLoanFile(loan_repayment_file_path);
		uploadLoanFilePage.clickSubmit();
		uploadLoanFilePage.validateUploadLoanFileNotification("Loan Repayment File has been saved.");
		
		//Validate if file got processed
		driver.get("https://automationtest.sandbox.integreat.perfios.com/uploadedFile/list");
		UploadedFileReportPage uploadedFileReportPage = new UploadedFileReportPage(driver);
		uploadedFileReportPage.validateFileType("LOAN_REPAYMENT_FILE");
		uploadedFileReportPage.clickViewResult();
		uploadedFileReportPage.validateLoanFileUploadStatus("Repayment Paid.");
		uploadedFileReportPage.clickClose();
		
		//Validate if Repayment is paid
		driver.get("https://automationtest.sandbox.integreat.perfios.com/loanApplication/list/IN_REPAYMENT");
		String loanID = ReadWriteExcel.getDataXY(loan_repayment_file_path, loan_repayment_file_sheet_name, 1, 1);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();
		loanApplicationsPage.clickSearchedLoanId(loanID);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.clickLoanRepaymentScheduleAccordion();
		int paidEMICountAfterFileUpload = loanDetailsPage.countLoanRepaymentPaidEMIStatus();
		assertEquals((paidEMICountAfterFileUpload-paidEMICountBeforeFileUpload), 1);
	}
}
