package com.automationsaas.test.configuration.verifyemailandphone;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.NotificationPage;
import com.automationsaas.pom.dsa.PhoneEmailVerificationPage;
import com.automationsaas.pom.investor.DashboardPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_004_VerifyEmailAndPhone_VerifyEmailAndPhoneForInvestor extends Base{
	
	@Test(priority=0,retryAnalyzer = RetryAnalyzer.class)
	public void verifyphoneSMSotp() throws InterruptedException {
		
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		DashboardPage investorDashboardPage = new DashboardPage(driver);
		String investorId = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor ID").get(1);
		investorDashboardPage.validateInvestorID(investorId);
		investorDashboardPage.clickonPhoneNumberVerifyLink();

		String adminusername = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String adminpassword = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		WebDriver driverone=new ChromeDriver();
		driverone.manage().window().maximize();
		driverone.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage2 = new LoginPage(driverone);
		loginPage2.enterUsername(adminusername);
		loginPage2.enterPassword(adminpassword);
		loginPage2.clickLogin();

		NotificationPage notificationPage = new NotificationPage(driverone);
		notificationPage.clickOnNotification();
		notificationPage.clickonSMSNotification();
			
		String investorPhone = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor Phone Number").get(1);
		String smsOTP = notificationPage.smsOTP(investorPhone);
		driverone.close();
			
		PhoneEmailVerificationPage phoneotp = new PhoneEmailVerificationPage(driver);
		phoneotp.enterOTP(smsOTP);
		phoneotp.clickOnValidateOTPbutton("Verify Phone Number");
}
	
	@Test(priority=1,retryAnalyzer = RetryAnalyzer.class)
	public void verifyEmailVerificationLink() {
		
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor MailID").get(1);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		DashboardPage investorDashboardPage = new DashboardPage(driver);
		String investor_Id = ReadWriteExcel.getData(excel_path, investor_sheet_name, "Individual Investor ID").get(1);
		investorDashboardPage.validateInvestorID(investor_Id);
		investorDashboardPage.clickonEmailVerifyLink();
		investorDashboardPage.validateSentVerificationEmailNotification("We have sent verification email to your email id. To resend Click Here.");
		
		String adminusername = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String adminpassword = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		
		WebDriver drivertwo=new ChromeDriver();
		drivertwo.manage().window().maximize();
		drivertwo.manage().window().setSize(new Dimension(2560,1440));
		Dimension dimension = drivertwo.manage().window().getSize();
		Reporter.log("dimension is " + dimension, true);
		drivertwo.get("https://automationtest.sandbox.integreat.perfios.com");
		
		LoginPage loginPagetwo = new LoginPage(drivertwo);
		loginPagetwo.enterUsername(adminusername);
		loginPagetwo.enterPassword(adminpassword);
		loginPagetwo.clickLogin();
		
		NotificationPage emailnotification = new NotificationPage(drivertwo);
		emailnotification.clickOnNotification();
		emailnotification.clickonEmailNotification();
		
		String email_link = emailnotification.userVerificationEmail(username,"Verify The Investor");
		String verificationlink="https://"+email_link;
		drivertwo.close();
		
		driver.get(verificationlink);
		PhoneEmailVerificationPage emaillink = new PhoneEmailVerificationPage(driver);
		emaillink.verifyEmailLink("Congratulations. Your application has been submitted successfully.");
			
	}

}
