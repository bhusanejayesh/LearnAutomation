package testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.LoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage
{
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=BrowserFactory.getBrowser("Firefox");
		
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
	}
	
	@Test
	public void testHomePage()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Demo Store"));
		
		home.clickOnSigninLink();
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
		login.verifySignOutLink();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
