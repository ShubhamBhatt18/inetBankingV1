package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException{
		
		
		LoginPage lp=new LoginPage(driver);
		
		logger.info("Entered the website unprotected mode");
		lp.clickAdvancedButton();
		lp.clickProceedLink();
		logger.info("entered the website");
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage123")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
	}
   
}
