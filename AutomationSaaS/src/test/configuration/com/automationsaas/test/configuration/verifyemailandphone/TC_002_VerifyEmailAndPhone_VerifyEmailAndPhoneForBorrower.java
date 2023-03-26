package com.automationsaas.test.configuration.verifyemailandphone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.automationsaas.pom.admindashboard.NotificationPage;
import com.automationsaas.pom.borrower.DashboardPage;
import com.automationsaas.pom.dsa.PhoneEmailVerificationPage;
import com.automationsaas.pom.login.LoginPage;
import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.ReadWriteExcel;
import com.automationsaas.utilities.RetryAnalyzer;

public class TC_002_VerifyEmailAndPhone_VerifyEmailAndPhoneForBorrower extends Base {
	
	@Test
	(retryAnalyzer = RetryAnalyzer.class)
	public void verifyphoneSMSotp() throws InterruptedException {
		
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);
		String borrowerId = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		borrowerDashboardPage.validateBorrowerId(borrowerId);
		borrowerDashboardPage.clickonPhoneNumberVerifyLink();

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
			
		String borrowerPhone = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Borrower Mobile Number").get(1);
		String smsOTP = notificationPage.smsOTP(borrowerPhone);
		driverone.close();
			
		PhoneEmailVerificationPage phoneotp = new PhoneEmailVerificationPage(driver);
		phoneotp.enterOTP(smsOTP);
		phoneotp.clickOnValidateOTPbutton("Verify Phone Number");
}
	
	@Test(priority=1,retryAnalyzer = RetryAnalyzer.class)
	public void verifyEmailVerificationLink() {
		
		driver.get("https://automationtest.sandbox.integreat.perfios.com");
		LoginPage loginPage = new LoginPage(driver);
		String username = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		String password = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower MailID").get(1);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		DashboardPage borrowerDashboardPage = new DashboardPage(driver);
		String borrower_Id = ReadWriteExcel.getData(excel_path, borrower_sheet_name, "Individual Borrower ID").get(1);
		borrowerDashboardPage.validateBorrowerId(borrower_Id);
		borrowerDashboardPage.clickonEmailVerifyLink();
		borrowerDashboardPage.validateSentVerificationEmailNotification("We have sent verification email to your email id. To resend Click Here.");
		
		String adminusername = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Username").get(1);
		String adminpassword = ReadWriteExcel.getData(excel_path, credential_sheet_name, "Password").get(1);
		
		WebDriver drivertwo=new ChromeDriver();
		drivertwo.manage().window().maximize();
		drivertwo.get("https://automationtest.sandbox.integreat.perfios.com");
		
		LoginPage loginPagetwo = new LoginPage(drivertwo);
		loginPagetwo.enterUsername(adminusername);
		loginPagetwo.enterPassword(adminpassword);
		loginPagetwo.clickLogin();
		
		NotificationPage emailnotification = new NotificationPage(drivertwo);
		emailnotification.clickOnNotification();
		emailnotification.clickonEmailNotification();
		
		String email_link = emailnotification.userVerificationEmail(username,"Verify The Borrower");
		String verificationlink="https://"+email_link;
		drivertwo.close();
		
		driver.get(verificationlink);
		PhoneEmailVerificationPage phoneEmailVerificationPage = new PhoneEmailVerificationPage(driver);
		phoneEmailVerificationPage.verifyEmailLink("Congratulations. Your application has been submitted successfully.");
			
	}
	
}
