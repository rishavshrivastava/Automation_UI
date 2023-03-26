package com.automationsaas.pom.investoronboarding;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Generics;

public class SupportingDocumentsPage {

	public WebDriver driver;

	public SupportingDocumentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2")
	private WebElement investorquestiongroup1heading;

	// Aadhar
	@FindBy(xpath = "//a[@id='upload_button_b20f7fc0-55cb-42e9-abaa-d6286e02b89d']")
	private WebElement aadharuploadbutton;

	@FindBy(xpath = "//a[@id='save_document_button_b20f7fc0-55cb-42e9-abaa-d6286e02b89d']")
	private WebElement popupaadharuploadbutton;

	@FindBy(xpath = "//label[text()='Adhar']/../div//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement aadharuploadspinner;

	@FindBy(xpath = "//label[text()='Adhar']/../div//a[text()='Upload More']")
	private WebElement aadharuploadmorebutton;

	@FindBy(xpath = "//h4[contains(text(),'Upload Adhar Card')]/../following-sibling::div//span")
	private WebElement alreadyuploadedaadhardocuments;

	@FindBy(xpath = "//h4[contains(text(),'Upload Adhar Card')]/../following-sibling::div//button")
	private WebElement alreadyuploadedaadhardocumentdeletebutton;
	
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

	public void uploadDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver
					.findElement(By.xpath("//div[@id='supporting-documents']//label[text()='" + filename + "']/..//a[contains(text(),'Upload')]"));

			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();

			WebElement chooseFileLink = driver
					.findElement(By.xpath("//h4[contains(text(),'Upload')]/../following-sibling::div//label[text()='"
							+ filename + "']/../div/input[@id='document']"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver
					.findElement(By.xpath("//h4[contains(text(),'Upload')]/../following-sibling::div//label[text()='"
							+ filename + "']/../div/a[text()='Upload']"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();
			
			WebElement uploadDocumentSpinner = driver.findElement(By.xpath("//div[@id='supporting-documents']//label[text()='" + filename + "']/..//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']"));
			Generics.waitForElementToInvisible(driver, uploadDocumentSpinner);
			
			WebElement uploadMoreButton = driver
					.findElement(By.xpath("//div[@id='supporting-documents']//label[text()='" + filename + "']/..//a[contains(text(),'Upload')]"));
			Generics.waitForElement(driver, uploadMoreButton);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateUploadedDocument(String filename, int filecount) {
		try {
			WebElement fileUploadButton = driver
					.findElement(By.xpath("//div[@id='supporting-documents']//label[text()='" + filename + "']/..//a[contains(text(),'Upload')]"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();
			assertEquals(supportingdocumentuploadedfilecount.size(), filecount);
			supportingdocument_closebutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUploadedDocument(String filename, int numberofdocumentstobedeleted) {
		try {
			for(int i=0; i<numberofdocumentstobedeleted;i++) {
				WebElement fileUploadButton = driver
						.findElement(By.xpath("//div[@id='supporting-documents']//label[text()='" + filename + "']/..//a[contains(text(),'Upload')]"));
				Generics.waitForElement(driver, fileUploadButton);
				fileUploadButton.click();
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
