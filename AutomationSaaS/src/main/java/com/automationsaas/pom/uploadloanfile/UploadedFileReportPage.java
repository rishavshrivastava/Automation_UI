package com.automationsaas.pom.uploadloanfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class UploadedFileReportPage extends Base {
	
	public WebDriver driver;
	public UploadedFileReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//table[@id='uploadedDocuments']//td)[3]")
	private WebElement firstfiletypetext;
	
	@FindBy(xpath="(//i[@class='fa fa-eye'])[1]")
	private WebElement firstuploadresultlink;
	
	@FindBy(xpath="//h4[text()='Uploaded Document Result']")
	private WebElement uploadeddocumentresultpopup;
	
	@FindBy(xpath="//table[@id='uploadedFile_result']//td[2]")
	private WebElement loanuploadresultstatus;
	
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement closebutton;
	
	public void validateFileType(String fileType) {
		try {
			Generics.waitForElement(driver, firstfiletypetext);
			if(firstfiletypetext.getText().equalsIgnoreCase(fileType)) {
				Reporter.log("File type is correct", true);
			}
			else Reporter.log("File type is not correct", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickViewResult() {
		try {
			Generics.waitForElement(driver, firstuploadresultlink);
			firstuploadresultlink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateLoanFileUploadStatus(String status) {
		try {			
			Generics.waitForElement(driver, uploadeddocumentresultpopup);
			if(loanuploadresultstatus.getText().equalsIgnoreCase(status)) {
				Reporter.log("Task created successfully", true);
			}
			else Reporter.log("Task has not been created", true);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickClose() {
		try {
			Generics.waitForElement(driver, closebutton);
			closebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
