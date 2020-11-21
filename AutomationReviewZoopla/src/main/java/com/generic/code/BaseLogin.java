package com.generic.code;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.page.object.model.MasterPageFactoryLoginPage;
import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.SeleniumWait;



public class BaseLogin {
public static WebDriver getDriverManager() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	////driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.get(BaseConfig.getConfigValue("url"));
	System.out.println("Driver setup finished");
	return driver;
}
	
	
public static WebDriver getLogin(WebDriver driver) throws Throwable {
	
System.out.println("Actual Test started");
//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
//WebDriver driver = new ChromeDriver();
//driver.manage().window().maximize();
////driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//driver.get(BaseConfig.getConfigValue("url"));
MasterPageFactoryLoginPage pf = new  MasterPageFactoryLoginPage(driver);
Highlighter.getcolor(driver, pf.getAcceptCookies());
SeleniumWait.getExplicitWait(driver, pf.getAcceptCookies());
pf.getAcceptCookies().click();

Highlighter.getcolor(driver, pf.getLogin());
SeleniumWait.getExplicitWait(driver,pf.getLogin());
pf.getLogin().click();

Highlighter.getcolor(driver, pf.getEmail());
pf.getEmail().sendKeys(BaseConfig.getConfigValue("email"));

Highlighter.getcolor(driver, pf.getPass());
pf.getPass().sendKeys(BaseConfig.getConfigValue("pass"));

Highlighter.getcolor(driver,pf.getSubmit());
SeleniumWait.getExplicitWait(driver, pf.getSubmit());
pf.getSubmit().click();
System.out.println("Test Finished");
return driver;	

	}
	


}
