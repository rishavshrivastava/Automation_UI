package com.automationsaas.test.validatedsa.addressdetails;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.BasicDetailPage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_009_Addressdetails_AddNewAddressFromDashboardAndValidate extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		String dsaid  = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		dashboardPage.validateDSAId(dsaid);
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		String last4CharsId1=Generics.getLastNCharsOfString(ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberOne").get(1), 4);
		String last4CharsId2=Generics.getLastNCharsOfString(ReadWriteExcel.getData(excel_path, dsa_sheet_name, "IdentityNumberTwo").get(1), 4);	
		BasicDetailPage basicDetailPage = new BasicDetailPage(driver);
		basicDetailPage.clickBasicDetail();
		
		ArrayList<String> personalAddress = new ArrayList<String>();
		personalAddress.add("Rajiv Gandhi Park 34");
		personalAddress.add("Hinjewadi chowk 624");
		personalAddress.add("Pimple Saudagar Phase3");
		personalAddress.add("Pimple Saudagar");
		personalAddress.add("Pimpri Chinchwad");
		personalAddress.add("Karnataka");
		personalAddress.add("Mangalore");
		personalAddress.add("India D");
		personalAddress.add("893512");
		personalAddress.add("");
		personalAddress.add("Staff Residence");
		
		for (int i = 0; i < personalAddress.size(); i++) {
			basicDetailPage.editPersonalAddress(i, personalAddress.get(i),"2017","Jul","14");
			}
		basicDetailPage.clickBasicDetailsUpdate();
		
		Generics.refreshPage(driver);
		
		ArrayList<String> basicDetails = new ArrayList<String>();
		basicDetails.add(username);
		basicDetails.add("Mr");
		basicDetails.add("Rishav");
		basicDetails.add("Shrivastava");
		basicDetails.add("12/11/1994");
		basicDetails.add("Male");
		basicDetails.add("Testing");
		basicDetails.add("12/11/1994");
		basicDetails.add("Rajiv Gandhi Park 34");
		basicDetails.add("Hinjewadi chowk 624");
		basicDetails.add("Pimple Saudagar Phase3");
		basicDetails.add("Pimple Saudagar");
		basicDetails.add("Pimpri Chinchwad");
		basicDetails.add("Karnataka");
		basicDetails.add("Mangalore");
		basicDetails.add("India D");
		basicDetails.add("893512");
		basicDetails.add("14/07/2017");
		basicDetails.add("Staff Residence");
		basicDetails.add("Line1");
		basicDetails.add("Line2");
		basicDetails.add("Line3");
		basicDetails.add("Sub District");
		basicDetails.add("District");
		basicDetails.add("Karnataka");
		basicDetails.add("City");
		basicDetails.add("Country");
		basicDetails.add("785452");	
		basicDetails.add("03/09/2005");
		basicDetails.add("Double story house");
		basicDetails.add(last4CharsId1);
		basicDetails.add(last4CharsId2);
		
		for (int i=0; i<basicDetails.size(); i++) {
			basicDetailPage.validateBasicDetail(i, basicDetails.get(i));
		}
}
}
