package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
     ReadConfig con=new ReadConfig();
	public String baseURL=con.getApplicationUrl();
	public String userName=con.getUsername();
	public String password=con.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
	   		driver=new ChromeDriver();
	   		
	   	 
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/geckodriver");
	   		driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	
	@AfterClass
	public void tearDown() {
	driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
	}
	public String randomstring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
}
