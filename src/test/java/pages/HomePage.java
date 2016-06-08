package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(xpath="//a[text() = 'Sign In']") WebElement signInLink;
	@FindBy(xpath="//a[text() = 'My Account']") WebElement myAccountLink;
	@FindBy(xpath="//a[text() = 'My cart']") WebElement myCartLink;
	@FindBy(xpath="//a[text() = 'Checkout']") WebElement checkOutLink;
	
	public void clickOnSigninLink()
	{
		signInLink.click();
	}
	public void clickOnMyAccountLink()
	{
		myAccountLink.click();
	}
	public void clickOnMyCartLinkLink()
	{
		myCartLink.click();
	}
	public void clickOnCheckOutLink()
	{
		checkOutLink.click();
	}
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
}
