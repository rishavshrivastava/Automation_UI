package com.automationsaas.test.dsa.bankdetails;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.automationsaas.pom.dsa.BankDetailsPage;
import com.automationsaas.pom.dsa.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_001_BankDetails_ValidateDsaDetailsDashboard extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		String file = TC_001_BankDetails_ValidateDsaDetailsDashboard;

		String accountNumber = Generics.jsonParser(file, "accountNumber");
		String accounType = Generics.jsonParser(file, "accounType");
		String bankName = Generics.jsonParser(file, "bankName");
		String IFSCCode = Generics.jsonParser(file, "IFSCCode");
		String accountHolderName = Generics.jsonParser(file, "accountHolderName");
		String bankAddress = Generics.jsonParser(file, "bankAddress");
		// String dateofopeningaccount_date = Generics.jsonParser(file,
		// "dateofopeningaccount_date");
		String dateofopeningaccount_month = Generics.jsonParser(file, "dateofopeningaccount_month");
		String dateofopeningaccount_year = Generics.jsonParser(file, "dateofopeningaccount_year");

		String micrcode = Generics.jsonParser(file, "micrcode");
		String branchname = Generics.jsonParser(file, "branchname");
		String swiftcode = Generics.jsonParser(file, "swiftcode");
		String branchpincode = Generics.jsonParser(file, "branchpincode");
		String branchcity = Generics.jsonParser(file, "branchcity");
		String natureoffacility = Generics.jsonParser(file, "natureoffacility");
		String bankdetailstextvariable1textbox = Generics.jsonParser(file, "bankdetailstextvariable1textbox");

		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA MailID").get(1);
		System.out.println(username);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		String dsaname = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA Name").get(1);
		dashboardPage.validateDSAName(dsaname);
		String dsaid = ReadWriteExcel.getData(excel_path, dsa_sheet_name, "DSA ID").get(1);
		System.out.println();
		dashboardPage.validateDSAId(dsaid);
		dashboardPage.validateProfileStatus("Awaiting Approval");
		dashboardPage.validateAccountBalance("Rs0");
		dashboardPage.clickAccount();
		dashboardPage.clickProfile();

		BankDetailsPage bankDetailsPage = new BankDetailsPage(driver);
		bankDetailsPage.clickBankDetails();

		int bankDetailsCount = bankDetailsPage.getBankDetailsCount();
		assertEquals(bankDetailsCount, 1);

		ArrayList<String> bankDetails = new ArrayList<String>();

		bankDetails.add(accountHolderName);
		bankDetails.add(accountNumber);
		bankDetails.add(accounType);
		bankDetails.add(bankName);
		bankDetails.add(IFSCCode);
		bankDetails.add(bankAddress);
		bankDetails.add("01/03/2001");
		bankDetails.add(micrcode);
		bankDetails.add(branchname);
		bankDetails.add(swiftcode);
		bankDetails.add(branchpincode);
		bankDetails.add(branchcity);
		bankDetails.add(natureoffacility);
		bankDetails.add(bankdetailstextvariable1textbox);

		for (int i = 0; i < bankDetails.size(); i++) {
			bankDetailsPage.validateBankDetails(bankDetailsCount - 1, i, bankDetails.get(i));
		}
	}
}
