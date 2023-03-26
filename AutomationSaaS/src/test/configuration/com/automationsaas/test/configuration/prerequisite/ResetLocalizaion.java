package com.automationsaas.test.configuration.prerequisite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.HomePage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;
import com.automationsaas.utilities.Interface;
import com.automationsaas.utilities.RetryAnalyzer;



public class ResetLocalizaion extends Base implements Interface {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testUntitledTestCase() throws Exception {
		System.out.println("Starting - ResetLocalization");
		String url = "https://automationtest.sandbox.integreat.perfios.com/hazelCastReset/index";
		String username = "admin@automationtest.com";
		String password = "admin@automationtest.com123";
		
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Localization Page
		WebElement resetLocalizationHeading = driver.findElement(By.xpath("//h2[contains(text(),'Reset Localization')]"));
		Generics.waitForElement(driver, resetLocalizationHeading);
		
		List<WebElement> listOfLocalizations = driver.findElements(By.xpath("//a[text()='Reset']"));
		for(int i=1;i<=listOfLocalizations.size();i++){
			driver.findElement(By.xpath("(//th[text()='Localization']/../../following-sibling::tbody/tr/td/a)["+i+"]")).click();
			System.out.println(driver.findElement(By.xpath("(//th[text()='Localization']/../../following-sibling::tbody/tr/td/a)["+i+"]")).getAttribute("href"));
			driver.navigate().refresh();
		}

		// Logout
		HomePage homePage = new HomePage(driver);
		homePage.logout();
	}
}
