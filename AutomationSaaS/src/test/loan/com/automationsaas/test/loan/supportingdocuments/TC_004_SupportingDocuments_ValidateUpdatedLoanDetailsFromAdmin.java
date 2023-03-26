package com.automationsaas.test.loan.supportingdocuments;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_004_SupportingDocuments_ValidateUpdatedLoanDetailsFromAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void updateBorrower() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		HomePage homePage = new HomePage(driver);
		homePage.clickLoanApplications();
		homePage.clickLoanApplicationsAll();

		String loanId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower Loan ID").get(1);
		String borrowerMailId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID")
				.get(1);

		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();

		ArrayList<String> searchedLoan = new ArrayList<String>();
		searchedLoan.add(loanId);
		searchedLoan.add("Rs200,000");
		searchedLoan.add("12 Months");
		searchedLoan.add("9.00 %");
		searchedLoan.add("Initialized");
		searchedLoan.add("Personal Loan");
		searchedLoan.add("Individual");
		searchedLoan.add(borrowerMailId);

		for (int i = 0; i < searchedLoan.size(); i++) {
			loanApplicationsPage.validateSearchedLoan(i, searchedLoan.get(i));
		}

		loanApplicationsPage.clickLoanId();

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.clickSupportingDocument();
		loanDetailsPage.clickLoanApplicationDocumentAccordion();
		loanDetailsPage.clickCoApplicantDocumentAccordion();
		loanDetailsPage.clickReferenceDocumentAccordion();

		ArrayList<String> loanApplicationSupportingDocumentsSerialNumber = new ArrayList<String>();
		ArrayList<String> loanApplicationSupportingDocumentsDocumentCategory = new ArrayList<String>();
		ArrayList<String> loanApplicationSupportingDocumentsDocumentName = new ArrayList<String>();
		ArrayList<String> loanApplicationSupportingDocumentsVisibleToBorrower = new ArrayList<String>();
		ArrayList<String> loanApplicationSupportingDocumentsVisibleToInvestor = new ArrayList<String>();
		ArrayList<String> loanApplicationSupportingDocumentsVisibleToBusinessPartner = new ArrayList<String>();
		ArrayList<String> loanApplicationSupportingDocumentsVisibleToFIA = new ArrayList<String>();

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

		loanApplicationSupportingDocumentsVisibleToBorrower.add("yes");
		loanApplicationSupportingDocumentsVisibleToBorrower.add("yes");
		loanApplicationSupportingDocumentsVisibleToBorrower.add("yes");
		loanApplicationSupportingDocumentsVisibleToBorrower.add("yes");

		loanApplicationSupportingDocumentsVisibleToInvestor.add("Yes");
		loanApplicationSupportingDocumentsVisibleToInvestor.add("Yes");
		loanApplicationSupportingDocumentsVisibleToInvestor.add("Yes");
		loanApplicationSupportingDocumentsVisibleToInvestor.add("Yes");

		loanApplicationSupportingDocumentsVisibleToBusinessPartner.add("Yes");
		loanApplicationSupportingDocumentsVisibleToBusinessPartner.add("Yes");
		loanApplicationSupportingDocumentsVisibleToBusinessPartner.add("Yes");
		loanApplicationSupportingDocumentsVisibleToBusinessPartner.add("Yes");

		loanApplicationSupportingDocumentsVisibleToFIA.add("No");
		loanApplicationSupportingDocumentsVisibleToFIA.add("No");
		loanApplicationSupportingDocumentsVisibleToFIA.add("No");
		loanApplicationSupportingDocumentsVisibleToFIA.add("No");

		for (int i = 0; i < loanApplicationSupportingDocumentsSerialNumber.size(); i++) {
			loanDetailsPage.validateLoanApplicationDocument(i, loanApplicationSupportingDocumentsSerialNumber.get(i),
					loanApplicationSupportingDocumentsDocumentCategory.get(i),
					loanApplicationSupportingDocumentsDocumentName.get(i),
					loanApplicationSupportingDocumentsVisibleToBorrower.get(i),
					loanApplicationSupportingDocumentsVisibleToInvestor.get(i),
					loanApplicationSupportingDocumentsVisibleToBusinessPartner.get(i),
					loanApplicationSupportingDocumentsVisibleToFIA.get(i));
		}
		
		ArrayList<String> coApplicantSupportingDocumentsSerialNumber = new ArrayList<String>();
		ArrayList<String> coApplicantSupportingDocumentsDocumentCategory = new ArrayList<String>();
		ArrayList<String> coApplicantSupportingDocumentsDocumentName = new ArrayList<String>();
		ArrayList<String> coApplicantSupportingDocumentsVisibleToBorrower = new ArrayList<String>();
		ArrayList<String> coApplicantSupportingDocumentsVisibleToInvestor = new ArrayList<String>();
		ArrayList<String> coApplicantSupportingDocumentsVisibleToBusinessPartner = new ArrayList<String>();
		ArrayList<String> coApplicantSupportingDocumentsVisibleToFIA = new ArrayList<String>();

		coApplicantSupportingDocumentsSerialNumber.add("1");
		coApplicantSupportingDocumentsDocumentCategory.add("Adhar Card");
		coApplicantSupportingDocumentsDocumentName.add("PNGFile.png");
		coApplicantSupportingDocumentsVisibleToBorrower.add("Yes");
		coApplicantSupportingDocumentsVisibleToInvestor.add("Yes");
		coApplicantSupportingDocumentsVisibleToBusinessPartner.add("No");
		coApplicantSupportingDocumentsVisibleToFIA.add("No");

		for (int i = 0; i < coApplicantSupportingDocumentsSerialNumber.size(); i++) {
			loanDetailsPage.validateCoApplicantDocument(i, coApplicantSupportingDocumentsSerialNumber.get(i),
					coApplicantSupportingDocumentsDocumentCategory.get(i),
					coApplicantSupportingDocumentsDocumentName.get(i),
					coApplicantSupportingDocumentsVisibleToBorrower.get(i),
					coApplicantSupportingDocumentsVisibleToInvestor.get(i),
					coApplicantSupportingDocumentsVisibleToBusinessPartner.get(i),
					coApplicantSupportingDocumentsVisibleToFIA.get(i));
		}
		
		ArrayList<String> referenceSupportingDocumentsSerialNumber = new ArrayList<String>();
		ArrayList<String> referenceSupportingDocumentsDocumentCategory = new ArrayList<String>();
		ArrayList<String> referenceSupportingDocumentsDocumentName = new ArrayList<String>();
		ArrayList<String> referenceSupportingDocumentsVisibleToBorrower = new ArrayList<String>();
		ArrayList<String> referenceSupportingDocumentsVisibleToInvestor = new ArrayList<String>();
		ArrayList<String> referenceSupportingDocumentsVisibleToBusinessPartner = new ArrayList<String>();
		ArrayList<String> referenceSupportingDocumentsVisibleToFIA = new ArrayList<String>();

		referenceSupportingDocumentsSerialNumber.add("1");
		referenceSupportingDocumentsDocumentCategory.add("Adhar Card");
		referenceSupportingDocumentsDocumentName.add("PNGFile.png");
		referenceSupportingDocumentsVisibleToBorrower.add("Yes");
		referenceSupportingDocumentsVisibleToInvestor.add("Yes");
		referenceSupportingDocumentsVisibleToBusinessPartner.add("No");
		referenceSupportingDocumentsVisibleToFIA.add("No");

		for (int i = 0; i < referenceSupportingDocumentsSerialNumber.size(); i++) {
			loanDetailsPage.validateReferenceDocument(i, referenceSupportingDocumentsSerialNumber.get(i),
					referenceSupportingDocumentsDocumentCategory.get(i),
					referenceSupportingDocumentsDocumentName.get(i),
					referenceSupportingDocumentsVisibleToBorrower.get(i),
					referenceSupportingDocumentsVisibleToInvestor.get(i),
					referenceSupportingDocumentsVisibleToBusinessPartner.get(i),
					referenceSupportingDocumentsVisibleToFIA.get(i));
		}
	}
}