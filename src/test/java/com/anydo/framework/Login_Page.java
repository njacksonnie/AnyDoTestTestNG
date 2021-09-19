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
	public LoginPage lp;
	public HomePage hp;

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
		lp = new LoginPage(driver);
		lp.login().click();
		lp.loginWithEmail().click();
		lp.email().sendKeys(prop.getProperty("email"));
		lp.next().click();
		lp.password().sendKeys(prop.getProperty("password"));
		lp.submit().click();
	}
	
	@Test(dependsOnMethods= {"login"})
	public void CreateTask()
	{
		hp = new HomePage(driver);
		hp.createTask().click();
		hp.taskName().sendKeys("Assigned to user");
		hp.submitTask().click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
