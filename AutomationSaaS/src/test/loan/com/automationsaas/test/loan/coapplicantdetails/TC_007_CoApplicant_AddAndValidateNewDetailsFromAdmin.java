package com.automationsaas.test.loan.coapplicantdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminloan.LoanApplicationsPage;
import com.automationsaas.pom.adminloan.LoanDetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_007_CoApplicant_AddAndValidateNewDetailsFromAdmin extends Base {

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
		
		LoanApplicationsPage loanApplicationsPage = new LoanApplicationsPage(driver);
		loanApplicationsPage.enterLoanIdInSearchField(loanId);
		loanApplicationsPage.clickSearch();

		loanApplicationsPage.clickLoanId();

		LoanDetailsPage loanDetailsPage = new LoanDetailsPage(driver);
		loanDetailsPage.validateLoanId(loanId);
		loanDetailsPage.clickCoApplicantAccordion();

		loanDetailsPage.clickAddCoApplicantDetails();
		ArrayList<String> coApplicantDetails1 = new ArrayList<String>();
		coApplicantDetails1.add("DAdminNew");
		coApplicantDetails1.add("SAdminNew");
		coApplicantDetails1.add("divya.s+Adminnew@perfios.com");
		coApplicantDetails1.add("Addednew from admin");
		coApplicantDetails1.add("Development");
		for (int i = 0; i < coApplicantDetails1.size(); i++) {
			loanDetailsPage.addCoApplicantDetails(i, coApplicantDetails1.get(i));
		}
		loanDetailsPage.clickAddCoApplicantDone();
		Generics.refreshPage(driver);
		loanDetailsPage.clickCoApplicantAccordion();
		
		loanDetailsPage.clickAddCoApplicantDetails();
		ArrayList<String> coApplicantDetails2 = new ArrayList<String>();
		coApplicantDetails2.add("DAdminSec");
		coApplicantDetails2.add("SAdminSec");
		coApplicantDetails2.add("divya.s+AdminSec@perfios.com");
		coApplicantDetails2.add("AddedSec from admin");
		coApplicantDetails2.add("Development sec");
		for (int i = 0; i < coApplicantDetails2.size(); i++) {
			loanDetailsPage.addCoApplicantDetails(i, coApplicantDetails2.get(i));
		}
		loanDetailsPage.clickAddCoApplicantDone();
		Generics.refreshPage(driver);
		loanDetailsPage.clickCoApplicantAccordion();

		ArrayList<String> addedCoApplicantDetails_1 = new ArrayList<String>();
		addedCoApplicantDetails_1.add("Divyacoapp CoappDashboard");
		addedCoApplicantDetails_1.add("divya.s+dashboard@perfios.com");
		addedCoApplicantDetails_1.add("From Dashboard");
		addedCoApplicantDetails_1.add("Update");

		ArrayList<String> addedCoApplicantDetails_2 = new ArrayList<String>();
		addedCoApplicantDetails_2.add("DAdminNew SAdminNew");
		addedCoApplicantDetails_2.add("divya.s+Adminnew@perfios.com");
		addedCoApplicantDetails_2.add("Addednew from admin");
		addedCoApplicantDetails_2.add("Development");

		ArrayList<String> addedCoApplicantDetails_3 = new ArrayList<String>();
		addedCoApplicantDetails_3.add("DAdminSec SAdminSec");
		addedCoApplicantDetails_3.add("divya.s+AdminSec@perfios.com");
		addedCoApplicantDetails_3.add("AddedSec from admin");
		addedCoApplicantDetails_3.add("Development sec");

		for (int i = 0; i < loanDetailsPage.getCoApplicantsCount(); i++) {
			if (i == 0)
				for (int j = 0; j < addedCoApplicantDetails_1.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, addedCoApplicantDetails_1.get(j));
				}
			if (i == 1) {
				for (int j = 0; j < addedCoApplicantDetails_2.size(); j++) {
					loanDetailsPage.validateCoApplicantDetails(i, j, addedCoApplicantDetails_2.get(j));
				}

				if (i == 2) {
					for (int j = 0; j < addedCoApplicantDetails_3.size(); j++) {
						loanDetailsPage.validateCoApplicantDetails(i, j, addedCoApplicantDetails_3.get(j));
					}
				}
			}
			Generics.refreshPage(driver);
			loanDetailsPage.clickCoApplicantAccordion();

			// validate coapplicant details in pop up
			loanDetailsPage.clickCoApplicantDetailsEdit(1);
			ArrayList<String> coApplicantDetailsinPopUp = new ArrayList<String>();
			coApplicantDetailsinPopUp.add("DAdminNew");
			coApplicantDetailsinPopUp.add("SAdminNew");
			coApplicantDetailsinPopUp.add("divya.s+Adminnew@perfios.com");
			coApplicantDetailsinPopUp.add("Addednew from admin");
			coApplicantDetailsinPopUp.add("Development");
			for (int k = 0; k < coApplicantDetailsinPopUp.size(); k++) {
				loanDetailsPage.editCoApplicantDetails(k, coApplicantDetailsinPopUp.get(k));
			}
			loanDetailsPage.clickEditCoApplicantClose();
		}
	}
}
