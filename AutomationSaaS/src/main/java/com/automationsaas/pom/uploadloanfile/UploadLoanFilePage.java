package com.automationsaas.pom.uploadloanfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class UploadLoanFilePage extends Base {

	public WebDriver driver;
	public UploadLoanFilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="fileType")
	private WebElement samplefileformatdropdown;
	
	@FindBy(id = "loanFileType")
	private WebElement upoadfiletypedropdown;
	
	@FindBy(id="excelFile")
	private WebElement choosefilelink;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submitbutton;
	
	@FindBy(xpath="//div[@id='flashMessageId']")
	private WebElement uploadloanfilenotification;
	
	public void selectFileFormat(String filetype) {
		try {
			Generics.waitForElement(driver, samplefileformatdropdown);
			Select uploadFileType = new Select(samplefileformatdropdown);
			uploadFileType.selectByVisibleText(filetype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectUploadFileType(String filetype) {
		try {
			Generics.waitForElement(driver, upoadfiletypedropdown);
			Select uploadFileType = new Select(upoadfiletypedropdown);
			uploadFileType.selectByVisibleText(filetype);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void chooseLoanFile(String filepath) {
		try {
			Generics.waitForElement(driver, choosefilelink);
			choosefilelink.sendKeys(filepath);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSubmit() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateUploadLoanFileNotification(String uploadnotification) {
		try {
			Generics.waitForElement(driver, uploadloanfilenotification);
			if(uploadloanfilenotification.getText().equalsIgnoreCase(uploadnotification)){
				Reporter.log("File Saved Successfully", true);
			}
			else Reporter.log("File Not Saved Successfully", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
