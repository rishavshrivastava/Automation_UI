package com.automationsaas.test.validatefia;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.adminfia.FIADetailsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_07_ValidateUpdatedFIADetailsFromAdmin extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateAssignLoanToFIA() {
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
		String fiamobilenumber  = ReadWriteExcel.getData(excel_path, fia_sheet_name, "Updated Mobile Number").get(1);
		
		FIADetailsPage fiaDetailsPage = new FIADetailsPage(driver);
		fiaDetailsPage.validateFiaId(fiaid);
		
		ArrayList<String> fiaDetails = new ArrayList<String>();
		
		fiaDetails.add("Mr");
		fiaDetails.add(fiaid);
		fiaDetails.add("FIA");
		fiaDetails.add(fiamobilenumber);
		fiaDetails.add("Male");
		fiaDetails.add("01/04/2004");
		fiaDetails.add("112043792667");
		fiaDetails.add("02/04/2004");
		fiaDetails.add("INFIA1887I");
		fiaDetails.add("03/04/2004");
		fiaDetails.add("TextVariableOne");
		fiaDetails.add("TextVariableTwo");
		//Personal Address
		fiaDetails.add("Line11");
		fiaDetails.add("Line22");
		fiaDetails.add("Line33");
		fiaDetails.add("Mysore Rural");
		fiaDetails.add("Mysore");
		fiaDetails.add("Karnataka");
		fiaDetails.add("Mysore");
		fiaDetails.add("India");
		fiaDetails.add("50001");
		fiaDetails.add("11/03/2015");
		fiaDetails.add("Staff Residence");
		fiaDetails.add("ADDRESS");
		//Address One
		fiaDetails.add("111");
		fiaDetails.add("222");
		fiaDetails.add("333");
		fiaDetails.add("Bangalore Rural");
		fiaDetails.add("Bangalore");
		fiaDetails.add("Karnataka");
		fiaDetails.add("Bangalore");
		fiaDetails.add("IN");
		fiaDetails.add("560001");
		fiaDetails.add("02/09/2016");
		fiaDetails.add("Staff Residence");
		fiaDetails.add("ADDRESS_ONE");
		//citizen
		fiaDetails.add("INDIAN");
	

		for (int i = 0; i < fiaDetails.size(); i++) {
			fiaDetailsPage.validateFiaDetails(i, fiaDetails.get(i));
		}
	}
}
