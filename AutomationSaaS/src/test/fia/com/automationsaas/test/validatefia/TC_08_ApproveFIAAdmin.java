package com.automationsaas.test.validatefia;

import org.testng.annotations.Test;
import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminfia.FIADetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_08_ApproveFIAAdmin extends Base {
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void approveDSADetails() throws InterruptedException {
		
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
		
		FIADetailsPage fiaDetailsPage = new FIADetailsPage(driver);
		fiaDetailsPage.validateFiaId(ReadWriteExcel.getData(excel_path, fia_sheet_name, "FIA ID").get(1));
		fiaDetailsPage.validateFiaStatus("Awaiting Approval", "Awaiting_Approval");
		fiaDetailsPage.changeFiaStatus("Approved");
		fiaDetailsPage.validateFiaStatus("Approved", "Approved");
		
	}

}
