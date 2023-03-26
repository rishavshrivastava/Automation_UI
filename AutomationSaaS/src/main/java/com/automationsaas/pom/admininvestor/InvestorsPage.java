package com.automationsaas.pom.admininvestor;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.automationsaas.utilities.Base;
import com.automationsaas.utilities.Generics;

public class InvestorsPage extends Base {

	public WebDriver driver;
	public InvestorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userId")
	private WebElement investoridtextbox;
	
	@FindBy(id="searchLoans")
	private WebElement searchbutton;
	
	@FindBy(xpath="//img[@src='/assets/spinner-c7b3cbb3ec8249a7121b722cdd76b870.gif']")
	private WebElement investorsspinner;
	
	@FindBy(xpath="//th[.='Investor ID']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Investor ID']/preceding-sibling::th)+1]/a")
	private List<WebElement> investoridlinks;
	
	@FindBy(xpath="//div[@id='investorList']//th[@id='INVESTOR_NAME']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[@id='INVESTOR_NAME']/preceding-sibling::th)+1]/a")
	private WebElement investorname;
	
	@FindBy(xpath="//div[@id='investorList']//th[.='Investor Category']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Investor Category']/preceding-sibling::th)+1]")
	private WebElement investorcategorytext;
	
	@FindBy(xpath="//div[@id='investorList']//th[.='Investor ID']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Investor ID']/preceding-sibling::th)+1]")
	private WebElement investoridtext;
	
	@FindBy(xpath="//div[@id='investorList']//th[.='Status']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Status']/preceding-sibling::th)+1]")
	private WebElement statustext;
	
	@FindBy(xpath="//div[@id='investorList']//th[.='Amount To Invest']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Amount To Invest']/preceding-sibling::th)+1]")
	private WebElement amounttoinvesttext;
	
	@FindBy(xpath="//div[@id='investorList']//th[.='Username']/ancestor::thead/following-sibling::tbody/tr/td[count(//tr/th[.='Username']/preceding-sibling::th)+1]")
	private WebElement usernametext;
	
	public void enterInvestorIdInSearchField(String investorid) {
		try {
			Generics.waitForElement(driver, investoridtextbox);
			investoridtextbox.click();
			investoridtextbox.clear();
			investoridtextbox.sendKeys(investorid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSearch() {
		try {
			Generics.waitForElement(driver, searchbutton);
			searchbutton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForResults() {
		try {
			Generics.waitForElementToInvisible(driver, investorsspinner);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void validateSearchedInvestor(int i, String product) {
		try {
			switch (i) {
			case 0:
				Generics.waitForElement(driver, investorname);
				assertEquals(investorname.getText(), product);
				break;

			case 1:
				Generics.waitForElement(driver, investorcategorytext);
				assertEquals(investorcategorytext.getText(), product);
				break;

			case 2:
				Generics.waitForElement(driver, investoridtext);
				assertEquals(investoridtext.getText(), product);
				break;

			case 3:
				Generics.waitForElement(driver, statustext);
				assertEquals(statustext.getText(), product);
				break;

			case 4:
				Generics.waitForElement(driver, amounttoinvesttext);
				assertEquals(amounttoinvesttext.getText(), product);
				break;

			case 5:
				Generics.waitForElement(driver, usernametext);
				assertEquals(usernametext.getText(), product);
				break;

			default:
				Reporter.log("No value found", true);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickSearchedInvestorId(String investorid) {
		try {
			Generics.waitForElement(driver, investoridlinks.get(0));
			for (int i=0; i<investoridlinks.size(); i++) {
				if(investoridlinks.get(i).getText().equalsIgnoreCase(investorid)) {
					Reporter.log("Investor ID found", true);
					investoridlinks.get(i).click();
					break;
				}
				else Reporter.log("Investor ID not found", true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getInvestorId() {
		String investorId = null;
		try {
			Generics.waitForElement(driver, investoridlinks.get(0));
			investorId = investoridlinks.get(0).getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return investorId;
	}
	
	public String getInvestorEmailId() {
		String investorId = null;
		try {
			Generics.waitForElement(driver, usernametext);
			investorId = usernametext.getText();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return investorId;
	}
}
