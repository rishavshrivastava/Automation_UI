package com.automationsaas.test.configuration.rolesandpermissions;

import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.pom.rolesandpermissions.AdminDSAModulePermissionPage;
import com.automationsaas.pom.rolesandpermissions.SystemAdminPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_005_RolesAndPermissions_DisableAdminDSAModulePermission extends Base {

	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void test() {
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String password = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickSystems();
		homePage.clickSystemAdmin();
		
		SystemAdminPage SystemAdminPage = new SystemAdminPage(driver);
		SystemAdminPage.clickEditPermission();
		
		AdminDSAModulePermissionPage AdminDSAModulePermissionPage = new AdminDSAModulePermissionPage(driver);
		AdminDSAModulePermissionPage.clickAdminDSAModulePermissionTab();
		AdminDSAModulePermissionPage.clickCanEdit();
		AdminDSAModulePermissionPage.clickCanEdit();
		AdminDSAModulePermissionPage.clickUpdate();
	}
}
