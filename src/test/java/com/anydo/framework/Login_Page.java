package com.anydo.framework;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Resources.base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class Login_Page extends base
{
	public WebDriver driver;
	public LoginPage lp1;
	public HomePage hp1;

	@BeforeTest
	public void launchBrowser() throws IOException{

		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void login()
	{
		lp1 = new LoginPage(driver);
		lp1.login().click();
		lp1.loginWithEmail().click();
		lp1.email().sendKeys(prop.getProperty("email"));
		lp1.next().click();
		lp1.password().sendKeys(prop.getProperty("password"));
		lp1.submit().click();
	}
	
	@Test(dependsOnMethods= {"login"})
	public void CreateTask()
	{
		hp1 = new HomePage(driver);
		hp1.createTask().click();
		hp1.taskName().sendKeys("Assigned to user");
		hp1.submitTask().click();
	}

	@Test(dependsOnMethods = {"CreateTask"})
	public void LogOut(){
		hp1.clickSettings().click();
		hp1.clickMyProfile().click();
		hp1.clickSignOut().click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
