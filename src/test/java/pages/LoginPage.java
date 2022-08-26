package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath = "//a[@class='btn btn-default dropdown-toggle']")
	WebElement LoggedInUserName;

	@FindBy(xpath = "//ul[@class='dropdown-menu']/li[@id='logout']")
	WebElement LogOutBtn;

	@FindBy(xpath = "//div[@class='panel-heading']")
	WebElement LoginPage;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	// ======================Functions====================//

	public void LoginFunction(String FirstName, String LastName, String UserID, String UserPassword)
			throws InterruptedException {

		UserName.sendKeys(UserID);
		test.log(LogStatus.PASS, "Enter UserName", "Username entered successfully");

		Thread.sleep(2000);

		Password.sendKeys(UserPassword);
		test.log(LogStatus.PASS, "Enter Password", "Password entered successfully");

		Thread.sleep(2000);

		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Login Button clicked successfully");

		Thread.sleep(2000);
		ValidateUserLoggedIn(UserID, FirstName, LastName);

	}

	public void ValidateUserLoggedIn(String emailID, String FName, String LName) {
		String FullName = FName + " " + LName;
		if (LoggedInUserName.getText().trim().equals(FullName)) {
			test.log(LogStatus.PASS, emailID, FullName + " :LoggedIn successfully");
		} else {
			test.log(LogStatus.FAIL, emailID, FullName + "Inorrect LogIn User");
		}
	}

	public void LogOut(String FName, String LName, String emailID) {

		LoggedInUserName.click();
		LogOutBtn.click();
		if (LoginPage.getText().equals("Login")) {
			String FullName = FName + " " + LName;
			test.log(LogStatus.PASS, emailID, FullName + " Logged Out Successfully");
		} else {
			test.log(LogStatus.FAIL, emailID, "LogOut failed");
		}

	}

}
