package com.automationsaas.test.investor.supportingdocuments;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.investor.SupportingDocumentsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_003_SupportingDocuments_UpdateAndValidateInvestorDashboard extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		String investorId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor ID").get(1);
		dashboardPage.validateInvestorID(investorId);
		dashboardPage.validateProfileStatus("Completed");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.validateEmailVerificationLinks();
		dashboardPage.validatePhoneNumberVerificationLinks();
		dashboardPage.validateDepositButton();
		dashboardPage.validateWithdrawButton();
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		SupportingDocumentsPage supportingDocumentsPage = new SupportingDocumentsPage(driver);
		supportingDocumentsPage.clickSupportingDocument();
		
		supportingDocumentsPage.downloadDocument("Adhar Card");
		Generics.refreshPage(driver);
		supportingDocumentsPage.clickSupportingDocument();
		supportingDocumentsPage.uploadDocument("Adhar", text_upload_file_path);
		Generics.refreshPage(driver);
		supportingDocumentsPage.clickSupportingDocument();
		supportingDocumentsPage.uploadDocument("Adhar", jpg_upload_file_path);
		Generics.refreshPage(driver);
		supportingDocumentsPage.clickSupportingDocument();
		supportingDocumentsPage.validateDocumentCount("Adhar", 4);
		Generics.refreshPage(driver);
		supportingDocumentsPage.clickSupportingDocument();
		supportingDocumentsPage.deleteUploadedDocument("Adhar", 1);
		Generics.refreshPage(driver);
		supportingDocumentsPage.clickSupportingDocument();
		supportingDocumentsPage.validateDocumentCount("Adhar", 3);

		ArrayList<String> SerialNumber = new ArrayList<String>();
		ArrayList<String> documentCategory = new ArrayList<String>();
		ArrayList<String> documentName = new ArrayList<String>();
		SerialNumber.add("1");
		SerialNumber.add("2");
		SerialNumber.add("3");

		documentCategory.add("Adhar");
		documentCategory.add("Pan Card");
		documentCategory.add("Address Proof");

		documentName.add("JPGFile.jpg, TextFile.txt, JPGFile.jpg");
		documentName.add("JPGFile.jpg");
		documentName.add("TextFile.txt");

		for (int i = 0; i < SerialNumber.size(); i++) {
			supportingDocumentsPage.updateValidateInvestorDocument(i, SerialNumber.get(i), documentCategory.get(i),
					documentName.get(i));
		}
	}
}