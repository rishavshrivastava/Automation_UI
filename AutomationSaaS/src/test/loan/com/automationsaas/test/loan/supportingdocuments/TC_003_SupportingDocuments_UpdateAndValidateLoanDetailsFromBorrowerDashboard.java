package com.automationsaas.test.loan.supportingdocuments;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.borrower.LoanDetailsPage;
import com.automationsaas.pom.borrower.SupportingDocumentPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_SupportingDocuments_UpdateAndValidateLoanDetailsFromBorrowerDashboard extends Base {

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
		loanDetailsPage.validateLoanId(loanId);
		
		SupportingDocumentPage supportingDocumentPage = new SupportingDocumentPage(driver);
		supportingDocumentPage.clickSupportingDocument();
		supportingDocumentPage.clickLoanApplicationDocumentAccordion();
		supportingDocumentPage.clickCoApplicantDocumentAccordion();
		supportingDocumentPage.clickDocumentForReferenceAccordionLink();
		supportingDocumentPage.downloadDocument("Adhar Card");
		Generics.refreshPage(driver);
		supportingDocumentPage.clickSupportingDocument();
		supportingDocumentPage.clickLoanApplicationDocumentAccordion();
		supportingDocumentPage.clickCoApplicantDocumentAccordion();
		supportingDocumentPage.clickDocumentForReferenceAccordionLink();
		supportingDocumentPage.uploadDocument("Adhar Card", text_upload_file_path);
		Generics.refreshPage(driver);
		supportingDocumentPage.clickSupportingDocument();
		supportingDocumentPage.clickLoanApplicationDocumentAccordion();
		supportingDocumentPage.clickCoApplicantDocumentAccordion();
		supportingDocumentPage.clickDocumentForReferenceAccordionLink();
		supportingDocumentPage.uploadDocument("Adhar Card", jpg_upload_file_path);
		Generics.refreshPage(driver);
		supportingDocumentPage.clickSupportingDocument();
		supportingDocumentPage.clickLoanApplicationDocumentAccordion();
		supportingDocumentPage.clickCoApplicantDocumentAccordion();
		supportingDocumentPage.clickDocumentForReferenceAccordionLink();
		supportingDocumentPage.validateDocumentCount("Adhar Card", 4);
		Generics.refreshPage(driver);
		supportingDocumentPage.clickSupportingDocument();
		supportingDocumentPage.clickLoanApplicationDocumentAccordion();
		supportingDocumentPage.clickCoApplicantDocumentAccordion();
		supportingDocumentPage.clickDocumentForReferenceAccordionLink();
		supportingDocumentPage.deleteUploadedDocument("Adhar Card", 1);
		Generics.refreshPage(driver);
		supportingDocumentPage.clickSupportingDocument();
		supportingDocumentPage.clickLoanApplicationDocumentAccordion();
		supportingDocumentPage.clickCoApplicantDocumentAccordion();
		supportingDocumentPage.clickDocumentForReferenceAccordionLink();
		supportingDocumentPage.validateDocumentCount("Adhar Card", 3);
		
		Generics.refreshPage(driver);
		supportingDocumentPage.clickSupportingDocument();
		supportingDocumentPage.clickLoanApplicationDocumentAccordion();
		supportingDocumentPage.clickCoApplicantDocumentAccordion();
		supportingDocumentPage.clickDocumentForReferenceAccordionLink();

		ArrayList<String> loanApplicationSupportingDocumentsSerialNumber = new ArrayList<String>();
		ArrayList<String> loanApplicationSupportingDocumentsDocumentCategory = new ArrayList<String>();
		ArrayList<String> loanApplicationSupportingDocumentsDocumentName = new ArrayList<String>();

		loanApplicationSupportingDocumentsSerialNumber.add("1");
		loanApplicationSupportingDocumentsSerialNumber.add("2");
		loanApplicationSupportingDocumentsSerialNumber.add("3");
		loanApplicationSupportingDocumentsSerialNumber.add("4");

		loanApplicationSupportingDocumentsDocumentCategory.add("Adhar Card");
		loanApplicationSupportingDocumentsDocumentCategory.add("Pan Card");
		loanApplicationSupportingDocumentsDocumentCategory.add("Address Proof");
		loanApplicationSupportingDocumentsDocumentCategory.add("Bank Statement");

		loanApplicationSupportingDocumentsDocumentName.add("JPGFile.jpg, TextFile.txt, JPGFile.jpg");
		loanApplicationSupportingDocumentsDocumentName.add("PDFFile.pdf");
		loanApplicationSupportingDocumentsDocumentName.add("JPGFile.jpg");
		loanApplicationSupportingDocumentsDocumentName.add("TextFile.txt");

		for (int i = 0; i < loanApplicationSupportingDocumentsSerialNumber.size(); i++) {
			supportingDocumentPage.validateLoanApplicationDocument(i,
					loanApplicationSupportingDocumentsSerialNumber.get(i),
					loanApplicationSupportingDocumentsDocumentCategory.get(i),
					loanApplicationSupportingDocumentsDocumentName.get(i));
		}

		ArrayList<String> coApplicantSupportingDocumentsSerialNumber = new ArrayList<String>();
		ArrayList<String> coApplicantSupportingDocumentsDocumentCategory = new ArrayList<String>();
		ArrayList<String> coApplicantSupportingDocumentsDocumentName = new ArrayList<String>();

		coApplicantSupportingDocumentsSerialNumber.add("1");
		coApplicantSupportingDocumentsDocumentCategory.add("Adhar Card");
		coApplicantSupportingDocumentsDocumentName.add("PNGFile.png");

		for (int i = 0; i < coApplicantSupportingDocumentsSerialNumber.size(); i++) {
			supportingDocumentPage.validateCoApplicantDocument(i, coApplicantSupportingDocumentsSerialNumber.get(i),
					coApplicantSupportingDocumentsDocumentCategory.get(i),
					coApplicantSupportingDocumentsDocumentName.get(i));
		}

		ArrayList<String> referenceSupportingDocumentsSerialNumber = new ArrayList<String>();
		ArrayList<String> referenceSupportingDocumentsDocumentCategory = new ArrayList<String>();
		ArrayList<String> referencetSupportingDocumentsDocumentName = new ArrayList<String>();

		referenceSupportingDocumentsSerialNumber.add("1");
		referenceSupportingDocumentsDocumentCategory.add("Adhar Card");
		referencetSupportingDocumentsDocumentName.add("PNGFile.png");
		
		for (int i = 0; i < referenceSupportingDocumentsSerialNumber.size(); i++) {
			supportingDocumentPage.validateReferenceDocument(i, referenceSupportingDocumentsSerialNumber.get(i),
					referenceSupportingDocumentsDocumentCategory.get(i),
					referencetSupportingDocumentsDocumentName.get(i));
		}
	}
}