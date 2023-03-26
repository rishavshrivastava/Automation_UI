package com.automationsaas.test.configuration.configuresettings;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automationsaas.pom.configuresettings.ConfigureSettingsPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;

public class TC_001_ConfigureSettings_EnableDisableShowLoanRepaymentDetailsWhileOnboarding extends Base {

	@Parameters({ "value" })
	@Test
	public void enableDisableShowLoanRepaymentDetailsWhileOnboarding(String value) {
		driver.get("https://automationtest.sandbox.integreat.perfios.com/configure-settings");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		ConfigureSettingsPage configureSettingsPage = new ConfigureSettingsPage(driver);
		configureSettingsPage.clickCategory5();
		configureSettingsPage.clickShowLoanRepaymentRescheduleSummaryWhileBorrowerOnboarding(value);
	}
}
