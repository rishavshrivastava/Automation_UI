package com.automationsaas.pom.investor;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class SupportingDocumentsPage extends Base {

	public WebDriver driver;
	public SupportingDocumentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Supporting Documents')]")
	private WebElement supportingdocumentstab;
	
	@FindBy(xpath="//div[contains(@id,'investorDocumentsTableDiv')]//th[.='Serial No']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Serial No']/preceding-sibling::th)+1]")
	private List<WebElement> investor_documentserialnumber;
	
	@FindBy(xpath="//div[contains(@id,'investorDocumentsTableDiv')]//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Category']/preceding-sibling::th)+1]")
	private List<WebElement> investor_documentcategory;
	
	@FindBy(xpath="//div[contains(@id,'investorDocumentsTableDiv')]//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)+1]")
	private List<WebElement> investor_documentname;
	
	@FindBy(xpath="//div[contains(@id,'investorDocumentsTableDiv')]//th[.='Document Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Document Name']/preceding-sibling::th)]")
	private List<WebElement> investor_documentname2;
	
	@FindBy(xpath="//span[contains(text(),'uploaded successfully')]")
	private WebElement uploadnotification;
	
	@FindBy(xpath="//th[.='#']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='#']/preceding-sibling::th)+1]")
	private List<WebElement> supportingdocumentuploadedfilecount;
	
	@FindBy(xpath="//div[@id='modal-loan-document-upload']//button[contains(text(),'×')]")
	private WebElement supportingdocument_closebutton;
	
	@FindBy(xpath="//i[@class='fa fa-times']")
	private List<WebElement> documentactionbuttons;
	
	@FindBy(xpath = "//span[contains(text(),'Deleted Successfully')]")
	private WebElement deletenotifications;
	
	
	public void clickSupportingDocument() {
		try {
			Generics.waitForElement(driver, supportingdocumentstab);
			supportingdocumentstab.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void downloadDocument(String documenttype) {
		try {
			WebElement downloadbotton = driver.findElement(By.xpath("//div[@id='investorDocumentsTableDiv']//td/a"));
			downloadbotton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void uploadDocument(String filename, String uploadfilepath) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[text()='"+filename+"']/following-sibling::td/button/i[@class='fa fa-upload']"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();

			WebElement chooseFileLink = driver.findElement(By.xpath("//form[@id='investorDocumentForm']//input[@name='document']"));
			Generics.waitForElement(driver, chooseFileLink);
			chooseFileLink.sendKeys(uploadfilepath);

			WebElement popupUploadButton = driver.findElement(By.xpath("//form[@id='investorDocumentForm']//button[contains(text(),'Done')]"));
			Generics.waitForElement(driver, popupUploadButton);
			popupUploadButton.click();
			
			Generics.waitForElement(driver, uploadnotification);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUploadedDocument(String filename, int numberofdocumentstobedeleted) {
		try {
			for(int i=0; i<numberofdocumentstobedeleted;i++) {
				WebElement fileUploadButton = driver.findElement(By.xpath("//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[text()='"+filename+"']/following-sibling::td/button/i[@class='fa fa-upload']"));
				Generics.waitForElement(driver, fileUploadButton);
				fileUploadButton.click();
				Generics.waitForElement(driver, documentactionbuttons.get(i));
				documentactionbuttons.get(i).click();
				Generics.waitForElement(driver, deletenotifications);
				Generics.waitForElement(driver, supportingdocument_closebutton);
				supportingdocument_closebutton.click();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateDocumentCount(String filename, int count) {
		try {
			WebElement fileUploadButton = driver.findElement(By.xpath("//th[.='Document Category']/ancestor::thead/following-sibling::tbody/tr/td[text()='"+filename+"']/following-sibling::td/button/i[@class='fa fa-upload']"));
			Generics.waitForElement(driver, fileUploadButton);
			fileUploadButton.click();
			assertEquals(supportingdocumentuploadedfilecount.size(), count);
			Generics.waitForElement(driver, supportingdocument_closebutton);
			supportingdocument_closebutton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validateInvestorDocument(int i, String serialnumber, String documentcategory, String documentdetails) {
		try {
			Generics.waitForElement(driver, investor_documentserialnumber.get(i));
			assertEquals(investor_documentserialnumber.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, investor_documentcategory.get(i));
			assertEquals(investor_documentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, investor_documentname.get(i));
			assertEquals(investor_documentname.get(i).getText(), documentdetails);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void updateValidateInvestorDocument(int i, String serialnumber, String documentcategory, String documentdetails) {
		try {
			Generics.waitForElement(driver, investor_documentserialnumber.get(i));
			assertEquals(investor_documentserialnumber.get(i).getText(), serialnumber);

			Generics.waitForElement(driver, investor_documentcategory.get(i));
			assertEquals(investor_documentcategory.get(i).getText(), documentcategory);

			Generics.waitForElement(driver, investor_documentname2.get(i));
			assertEquals(investor_documentname2.get(i).getText(), documentdetails);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
