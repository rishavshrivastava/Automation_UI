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

public class TC_001_SupportingDocuments_ValidateLoanFromBorrowerDashboard extends Base {

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
		borrowerDashboardPage.validateLoanId(loanId);
		borrowerDashboardPage.validateProfileStatus("Awaiting Approval");
		borrowerDashboardPage.validateAccountBalance("Rs0");
		borrowerDashboardPage.validateLoanStatus("Initialized");

		ArrayList<String> loanDetails = new ArrayList<String>();
		loanDetails.add("Personal Loan");
		loanDetails.add(loanId);
		loanDetails.add("Mr Rishav Shrivastava");
		loanDetails.add("N/A");
		loanDetails.add("Rs209,884");
		loanDetails.add(borrowerId);
		loanDetails.add("Rs200,000");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add("N/A");
		loanDetails.add("Rs0");
		String currentDate = Generics.getCurrentDate();
		loanDetails.add(currentDate);
		loanDetails.add("12 Months");
		loanDetails.add("9.00%");
		loanDetails.add("N/A");
		for (int i = 0; i < loanDetails.size(); i++) {
			borrowerDashboardPage.validateLoanDetails(i, loanDetails.get(i));
		}

		borrowerDashboardPage.clickLoanDetailsButton();
		
		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);

		// Borrower Supporting Page
		SupportingDocumentPage supportingDocumentPage = new SupportingDocumentPage(driver);
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

		loanApplicationSupportingDocumentsDocumentName.add("TextFile.txt, JPGFile.jpg");
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