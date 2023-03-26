package com.automationsaas.test.validatefia;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminfia.FIADetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_04_UpdateFIAAdmin  extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void updateFIA() throws InterruptedException {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		HomePage homePage = new HomePage(driver);
		homePage.clickFIA();
		homePage.clickFIAAll();
		
		homePage.fiaEmailsList();
	
		String fiaid  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA ID").get(1);
		String fiaemail  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA MailID").get(1);
	
		
		FIADetailsPage fiaDetailsPage = new FIADetailsPage(driver);
		fiaDetailsPage.validateFiaId(fiaid);
		fiaDetailsPage.validateFiaStatus("Awaiting Approval", "Awaiting_Approval");
		fiaDetailsPage.validateFiaEmailId(fiaemail);
		
		// update FIA details tab
		
//		String updatedMobileNumber = Generics.getRandomNumber(8);
//		fiaDetailsPage.enterPhoneNumber("11"+updatedMobileNumber);


		ArrayList<String> updateFIADetails = new ArrayList<String>();
		updateFIADetails.add("Mrs");
		updateFIADetails.add("Divya");
		updateFIADetails.add("Sachan");
		updateFIADetails.add("Female");
		updateFIADetails.add("123456789012");
		updateFIADetails.add("INFIA1234U");
		updateFIADetails.add("ONE");
		updateFIADetails.add("TWO");
		updateFIADetails.add("Line111");
		updateFIADetails.add("Line222");
		updateFIADetails.add("Line333");
		updateFIADetails.add("Noida");
		updateFIADetails.add("Greater Noida");
		updateFIADetails.add("Uttar Pradesh");
		updateFIADetails.add("Noida");
		updateFIADetails.add("IND");
		updateFIADetails.add("208011");
		updateFIADetails.add("");
		updateFIADetails.add("Single Story House");
		updateFIADetails.add("Address Two");
		updateFIADetails.add("Bharatiya");

	for (int i = 0; i < updateFIADetails.size(); i++) {
			fiaDetailsPage.editFiaDetails(i, updateFIADetails.get(i),"2015", "Mar", "12");
		}
	
		String updatedMobileNumber = Generics.getRandomNumber(8);
		fiaDetailsPage.enterPhoneNumber1("11"+updatedMobileNumber);
		fiaDetailsPage.selectDateOfBirth("2004", "Feb", "1");
		fiaDetailsPage.selectIdentityNumberOneIssueDate("2004", "Feb", "1");
		fiaDetailsPage.selectIdentityNumberTwoIssueDate("2004", "Feb", "2");

		fiaDetailsPage.clickUpdateFIADetails();
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 8, 1, "11"+updatedMobileNumber);
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 2, 1, "123456789012");
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 3, 1, "INFIA1234U");
	
	}
}