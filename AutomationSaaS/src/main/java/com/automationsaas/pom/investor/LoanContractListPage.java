package com.automationsaas.pom.investor;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class LoanContractListPage extends Base {

	public WebDriver driver;
	public LoanContractListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//th[.='Contract Name']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Contract Name']/preceding-sibling::th)+1]/a")
	private List<WebElement> contractnamelinks;
	
	@FindBy(id="accept")
	private WebElement loancontractacceptbutton;
	
	@FindBy(id="reject")
	private WebElement loancontractrejectbutton;
	
	public void acceptRejectContract(int i, String action) {
		try {
			Generics.waitForElement(driver, contractnamelinks.get(i));
			contractnamelinks.get(i).click();
			if(action.equalsIgnoreCase("accept")) {
				loancontractacceptbutton.click();
			}
			else if (action.equalsIgnoreCase("reject")) {
				loancontractrejectbutton.click();
			}
			else {
				System.out.println("No Status Selected");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
