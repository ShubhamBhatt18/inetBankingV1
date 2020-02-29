package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException,IOException{
		LoginPage lp=new LoginPage(driver);
		logger.info("Entered the website unprotected mode");
		lp.clickAdvancedButton();
		lp.clickProceedLink();
		logger.info("entered the website");
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCust();
		logger.info("Providing customer details");
		addcust.setUserName("Pavan");
		addcust.setDateOfBirth("10", "12", "1995");
		
		Thread.sleep(3000);
		addcust.setAddress("India");
		addcust.setCity("Noida");
		addcust.setState("UP");
		addcust.setPin("201305");
		addcust.setPhone("9897525789");
		
		String email=randomstring()+"@gmail.com";
		addcust.setEmail(email);
		
		addcust.setPassword("abcdef");
		addcust.clickSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation has started");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			logger.info("Test Case passed");
			Assert.assertTrue(true);
			
			
		}
		else {
			logger.info("Test Case failed");
		    captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			
			}
	}
	
	
	
}
