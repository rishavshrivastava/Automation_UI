package com.automationsaas.test.validatedsa;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.admindsa.DSADetailsPage;
import com.automationsaas.pom.admindsa.DSAPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_12_DSAUploadDownloadDeleteContractFromAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void uploadDownloadDeleteContract() throws InterruptedException {

		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		HomePage homePage = new HomePage(driver);
		homePage.clickBusinessPartner();
		homePage.clickBusinessPartnerAll();

		DSAPage dSAsearchPage = new DSAPage(driver);
		String DSAEmail = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(DSAEmail);
		dSAsearchPage.enterEmail(DSAEmail);
		dSAsearchPage.clickSearch();
		Generics.waitForFewSecondstoLoad(4000);
		DSAPage dsapage = new DSAPage(driver);
		dsapage.validatenumberLoanApplications();
		dSAsearchPage.clickAction();
		Generics.waitForFewSecondstoLoad(4000);

		DSADetailsPage dsaDetailsPage = new DSADetailsPage(driver);
		dsaDetailsPage.verifyAndDeleteContractifAnyExisting("There is no Contract Details to be displayed.");

		// Contract 1: Upload Contract - Loan General Term

		// driver.navigate().refresh();
		Generics.scrollPage(driver, 4000);
		dsaDetailsPage.clickContractsAccordion();
		dsaDetailsPage.uploadContractDocument(0, text_upload_file_path, "Loan General Term", "success");

		// Contract 1: Download Contract - Loan General Term
		driver.navigate().refresh();
		Generics.scrollPage(driver, 4000);
		dsaDetailsPage.clickContractsAccordion();
		dsaDetailsPage.downloadContractDocument("Loan General Term", "TextFile.txt");
		Generics.waitForFileDownloaded(driver, upload_contractfile_path, "TextFile.txt");
		dsaDetailsPage.validateDownloadedDocument("TextFile.txt");

		// Contract 1: Delete Contract - Loan General Term
		dsaDetailsPage.deleteContract("Contract Deleted");

		driver.navigate().refresh();
		Generics.scrollPage(driver, 4000);

		// Contract 2 : Upload Contract - Bid Contract

		dsaDetailsPage.clickContractsAccordion();
		dsaDetailsPage.uploadContractDocument(1, png_upload_file_path, "Bid Contract", "success");
		driver.navigate().refresh();
		Generics.scrollPage(driver, 4000);

		// Contract 1: Download Contract - Bid Contract
		dsaDetailsPage.clickContractsAccordion();
		dsaDetailsPage.downloadContractDocument("Bid Contract", "PNGFile.png");

		Generics.waitForFileDownloaded(driver, upload_contractfile_path, "PNGFile.png");
		dsaDetailsPage.validateDownloadedDocument("PNGFile.png");

		// driver.navigate().refresh();
		// Generics.scrollPage(driver, 4000);
		// dsaDetailsPage.clickContractsAccordion();

		// Contract 1: Delete Contract - Bid Contract
		dsaDetailsPage.deleteContract("Contract Deleted");

	}

}
