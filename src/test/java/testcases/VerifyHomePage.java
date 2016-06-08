package testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePage
{
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=BrowserFactory.getBrowser("Chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
	}
	
	@Test
	public void testHomePage()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Demo Store"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
