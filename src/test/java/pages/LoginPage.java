package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;

	// ==============Web Elements=======================//

	@FindBy(name = "username")
	WebElement UserName;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement LoginBtn;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	// ======================Functions====================//

	public void LoginFunction(String UserID, String UserPassword) throws InterruptedException {

		UserName.sendKeys(UserID);
		test.log(LogStatus.PASS, "Enter UserName", "Username entered successfully");

		Thread.sleep(2000);

		Password.sendKeys(UserPassword);
		test.log(LogStatus.PASS, "Enter Password", "Password entered successfully");

		Thread.sleep(2000);

		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Login Button clicked successfully");

		Thread.sleep(2000);

	}

	public void UICheck() {
		Assert.assertTrue(UserName.isDisplayed());
	}

}
