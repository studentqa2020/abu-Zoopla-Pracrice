package com.testexecution;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.code.BaseLogin;

public class SmokeTestWithTestNG {
	 WebDriver driver;	
@BeforeTest	
public void getDriverSetup() throws Throwable {
	driver=BaseLogin.getDriverManager();	
}
@Test	
public void getSalary() throws Throwable {	
	//System.out.println("hi");
	driver = BaseLogin.getLogin(driver);

}
@AfterTest
public void getDriveClose() {
	driver.quit();	
}



}
