package com.automationsaas.pom.dsaonboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class SupportingDocumentsPage extends Base {
	
	public WebDriver driver;

	public SupportingDocumentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//h2)[1]")
	private WebElement supportingdocumentsheading;
	
	@FindBy(id="submit_all_documents")
	private WebElement submitbutton;
	
	@FindBy(xpath="//th[.='#']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='#']/preceding-sibling::th)+1]")
	private List<WebElement> supportingdocumentuploadedfilecount;
	
	@FindBy(xpath="//div[@id='modal-onboarding-document-template']//button[contains(text(),'×')]")
	private WebElement supportingdocument_closebutton;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	private List<WebElement> documentactionbuttons;
	
	@FindBy(xpath = "//span[contains(text(),'deleted successfully')]")
	private WebElement deletenotifications;
	
	public void validateSupportingDocumentsHeading(String pageheading) {
		try {
			Generics.waitForElement(driver, supportingdocumentsheading);
			if (supportingdocumentsheading.getText().equalsIgnoreCase(pageheading)) {
				Reporter.log("Supporting documents is displayed", true);
			} else
				Reporter.log("Supporting documents is not displayed", true);
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error in validateSupportingDocumentsHeading", true);
		}
	}
	public void validateUploadedDocument(String filename, int filecount) {
		try {
			WebElement uploadMoreButton = driver.findElement(By.xpath("//label[text()='"+filename+"']/following-sibling::div//a"));
            Generics.waitForElement(driver, uploadMoreButton);
			uploadMoreButton.click();

			assertEquals(supportingdocumentuploadedfilecount.size(), filecount);
			supportingdocument_closebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void uploadDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver
					.findElement(By.xpath("(//label[text()='" + filename + "']/following-sibling::div//a)[1]"));

			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//label[contains(text(),'"+filename+"')]/following-sibling::input"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver.findElement(By.xpath("//label[contains(text(),'"+filename+"')]/../following-sibling::div/a"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}   
	}
	public void uploadMoreDocument(String filename, String uploadfilepath) {
		try {
			WebElement uploadMoreButton = driver.findElement(By.xpath("//label[text()='"+filename+"']/following-sibling::div//a"));
            Generics.waitForElement(driver, uploadMoreButton);
			uploadMoreButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//label[contains(text(),'"+filename+"')]/following-sibling::input"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver.findElement(By.xpath("//label[contains(text(),'"+filename+"')]/../following-sibling::div/a"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteDocument(String filename) {
		try {
			WebElement uploadMoreButton = driver.findElement(By.xpath("//label[text()='"+filename+"']/following-sibling::div//a"));
            Generics.waitForElement(driver, uploadMoreButton);
			uploadMoreButton.click();

		
			WebElement deleteIcon = driver.findElement(By.xpath("//div[@id='supportingDocumentListToDelete']//button"));
			Generics.waitForElement(driver, deleteIcon);
			deleteIcon.click();

			WebElement closePopup = driver.findElement(By.xpath("//div[@id='modal-onboarding-document-template']//following-sibling::div/button[@class='close']"));
			Generics.waitForElement(driver, closePopup);
			closePopup.click();
			
			WebElement deleteNotification = driver.findElement(By.xpath("//span[contains(text(),'deleted successfully')]"));
			Generics.waitForElement(driver, deleteNotification);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	

	public void deleteUploadedDocument(String filename, int numberofdocumentstobedeleted) {
		try {
			for(int i=0; i<numberofdocumentstobedeleted;i++) {
				WebElement uploadMoreButton = driver.findElement(By.xpath("//label[text()='"+filename+"']/following-sibling::div//a"));
	            Generics.waitForElement(driver, uploadMoreButton);
				uploadMoreButton.click();
				Generics.waitForElement(driver, documentactionbuttons.get(i));
				documentactionbuttons.get(i).click();
				Generics.waitForElement(driver, deletenotifications);
				supportingdocument_closebutton.click();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void checkTermsAndConditions() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('termsChecked').click()");
	}
	
	public void clickSubmit() {
		try {
			Generics.waitForElement(driver, submitbutton);
			submitbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
