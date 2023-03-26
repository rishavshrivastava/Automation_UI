package com.automationsaas.test.validatefia;

import org.testng.annotations.Test;

import com.automationsaas.pom.borroweronboarding.BorrowerRegistrationPage;
import com.automationsaas.pom.fia.DashboardPage;
import com.automationsaas.pom.fia.FIARegistrationPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_01_FIAOnboarding extends Base{
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void validateFIAOnboarding() {
		String file = TC_01_FIAOnboarding;
		
		String title = Generics.jsonParser(file, "title");
		String firstName = Generics.jsonParser(file, "firstName");

		driver.get("https://automationtest.sandbox.integreat.perfios.com/signUp/createFieldInvestigationAssociate");
		FIARegistrationPage fiaregistrationpage=new FIARegistrationPage(driver);
		fiaregistrationpage.validateFIARegistrationHeading("Field Investigation Associate Registration");
		
		BorrowerRegistrationPage fia = new BorrowerRegistrationPage(driver);
		fia.selectTitle(title);
		fia.enterFirstName(firstName);
		fia.enterLastName("Yaragall");
		String fiaEmailId = "chandrasekar.y+fia" + Generics.generateTimeStamp() + "@perfios.com";

		fiaregistrationpage.enteremailid(fiaEmailId);
		fia.checkAvailabilityOfEmailAddress();
		
		fia.enterPassword(fiaEmailId);
		fia.enterConfirmPassword(fiaEmailId);
		
		String mobileNumber = Generics.getRandomNumber(8);
		fiaregistrationpage.enterPhoneNumber("11"+mobileNumber);
		fia.checkAvailabilityOfMobileNumber();
		

		//String FIAMobileNumber = fiaregistrationpage.getMobileNumber();
	
		
		fia.selectGender("Male");
		fia.selectDateOfBirth("2004", "Jan", "1");//
		String identityNumberOne = Generics.getRandomNumber(10);
		String identityNumberTwo = Generics.getRandomNumber(4);
		fiaregistrationpage.enterIdentityNumberOne("11"+identityNumberOne);
		fiaregistrationpage.selectIdentityNumberOneIssueDate("2004", "Jan", "1"); //
		fiaregistrationpage.enterIdentityNumberTwo("INFIA"+identityNumberTwo+"I");
		fiaregistrationpage.selectIdentityNumberTwoIssueDate("2004", "Jan", "1"); //
		fiaregistrationpage.enterTextVariableOne("TestOne");
		fiaregistrationpage.enterTextVariableTwo("TestTwo");
		
		//Address
		fiaregistrationpage.enterPersonalAddress("Line1", "Line2", "Line3", "Sub District", "District",
				"Karnataka", "City", "Country", "785452", "2016", "Sep", "3", "Double story house", "Address");
		fiaregistrationpage.enterAddressOne(
				"111", "222", "333", "Bangalore Rural", "Bangalore",
				"Karnataka", "Bangalore", "IN", "560001", "2016", "Sep", "2", "Staff Residence", "Address One");
		fiaregistrationpage.enterCitizenship("INDIAN");
		fiaregistrationpage.clickSubmit();
	
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 1, 1, "11"+mobileNumber);
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 2, 1, "11"+identityNumberOne);
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 3, 1, "INFIA"+identityNumberTwo+"I");
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 4, 1, fiaEmailId);
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		String FIAName = dashboardPage.getFIAName();
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 5, 1, FIAName);
		
		//http://emu.hinagro.com/perfios/integreat/-/issues/16371   once this issue is fixed remove the below refresh statement
		Generics.refreshPage(driver);
		String FIAId = dashboardPage.getFIAId();
		System.out.println(FIAId);
		ReadWriteExcel.putData(excel_path, fia_sheet_name, 6, 1, FIAId);
		
	}
}
