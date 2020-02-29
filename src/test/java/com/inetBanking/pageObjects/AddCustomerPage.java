package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver driver) {
		
		ldriver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(name="name")
	WebElement name;
	
	@FindBy(name="dob")
	WebElement dob;
	
	@FindBy(name="addr")
	WebElement addr;
	

	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pin;
	
	@FindBy(name="telephoneno")
	WebElement phone;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(name="sub")
	WebElement subButton;
	
	
	public void clickAddNewCust() {
		lnkAddNewCustomer.click();
		
	}
	
	
	public void setUserName(String uname) {
		name.sendKeys(uname);
	}
	
	public void setDateOfBirth(String dd,String mm,String yy) {
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yy);
	}
	
	public void setAddress(String add) {
		addr.sendKeys(add);
	}
	
	public void setCity(String ucity) {
		city.sendKeys(ucity);
	}
	
	public void setState(String ustate) {
	state.sendKeys(ustate);
	}
	
	public void setPin(String upin) {
		pin.sendKeys(upin);
	}
	
	public void setPhone(String uphone) {
		phone.sendKeys(uphone);
	}
	
	public void setEmail(String uemail) {
		email.sendKeys(uemail);
	}
	
  public void setPassword(String upass) {
	  pass.sendKeys(upass);
  }
  public void clickSubmit() {
	  subButton.click();
  }
}
