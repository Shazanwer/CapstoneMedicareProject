package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class NewUserRegisterPage {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;

	// ==============Web Elements=======================//
	
	@FindBy(xpath = "//div[@class='panel-heading']/h4[text()='Login']")
	WebElement LoginPage;

	@FindBy(xpath = "//div[@class='text-right']/a[text()='Register Here']")
	WebElement RegisterHere;

	@FindBy(xpath = "//div[@class='panel-heading']/h4[text()='Sign Up - Personal']")
	WebElement PageHeading;

	@FindBy(name = "firstName")
	WebElement firstName;

	@FindBy(name = "lastName")
	WebElement lastName;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "contactNumber")
	WebElement contactNo;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "confirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "role1")
	WebElement userRole;

	@FindBy(id = "role2")
	WebElement supplierRole;

	@FindBy(name = "_eventId_billing")
	WebElement nextBillingBtn;

	@FindBy(xpath = "//div[@class='panel-heading']/h4[text()='Sign Up - Address']")
	WebElement AddressPage;

	@FindBy(name = "addressLineOne")
	WebElement AddressLine1;

	@FindBy(name = "addressLineTwo")
	WebElement AddressLine2;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "postalCode")
	WebElement postalCode;

	@FindBy(name = "state")
	WebElement state;

	@FindBy(name = "country")
	WebElement country;

	@FindBy(name = "_eventId_confirm")
	WebElement NextConfirmBtn;

	@FindBy(xpath = "//div[@class='panel-heading']/h4[text()='Personal Details']")
	WebElement personalDetails;

	@FindBy(xpath = "//div[@class='panel-heading']/h4[text()='Billing Address']")
	WebElement billingAddress;

	@FindBy(xpath = "//div/a[text()='Confirm']")
	WebElement confirmBtn;

	@FindBy(xpath = "//h1[text()='Welcome!']")
	WebElement welcomePage;

	@FindBy(xpath = "//div/a[text()='Login Here']")
	WebElement loginHereBtn;

	public NewUserRegisterPage() {

		PageFactory.initElements(driver, this);

	}

	// ======================Functions====================//

	public void UserRegisteration(String fName, String lName, String cNo, String emailId, String pword, String cpword,
			String role, String addLine1, String addLine2, String cityName, String postCode, String stateName,
			String countryName) throws InterruptedException {
		
		UILoginPageCheck();

		RegisterHere.click();
		test.log(LogStatus.PASS, "Click Register Here", "New User Register Here link clicked successfully");
		Thread.sleep(2000);

		UICheck();

		firstName.sendKeys(fName);
		test.log(LogStatus.PASS, "Enter First Name", "First Name entered successfully");
		Thread.sleep(1000);

		lastName.sendKeys(lName);
		test.log(LogStatus.PASS, "Enter Last Name", "Last Name entered successfully");
		Thread.sleep(1000);

		contactNo.sendKeys(cNo);
		test.log(LogStatus.PASS, "Enter Contact No", "Contact No entered successfully");
		Thread.sleep(1000);

		email.sendKeys(emailId);
		test.log(LogStatus.PASS, "Enter Email ID", "Email ID entered successfully");
		Thread.sleep(1000);

		password.sendKeys(pword);
		test.log(LogStatus.PASS, "Enter Password", "Password entered successfully");
		Thread.sleep(1000);

		confirmPassword.sendKeys(cpword);
		test.log(LogStatus.PASS, "Enter Confirm Password", "Confirm Password entered successfully");
		Thread.sleep(1000);

		if (role.equals("USER")) {
			userRole.click();
			test.log(LogStatus.PASS, "Select " + userRole.getText(), "User Role selected/checked successfully");
			Thread.sleep(1000);
		} else if (role.equals("SUPPLIER")) {
			supplierRole.click();
			test.log(LogStatus.PASS, "Select " + supplierRole.getText(), "Supplier Role selected/checked successfully");
			Thread.sleep(1000);
		}

		nextBillingBtn.click();
		test.log(LogStatus.PASS, "Click on Next Billing Button", "Next Billing Button clicked successfully");
		Thread.sleep(2000);

		// Enter address information

		UIAddressPageCheck();

		AddressLine1.sendKeys(addLine1);
		test.log(LogStatus.PASS, "Enter Address Line 1", "Address Line 1 entered successfully");
		Thread.sleep(1000);

		AddressLine2.sendKeys(addLine2);
		test.log(LogStatus.PASS, "Enter Address Line 2", " Address Line 2 entered successfully");
		Thread.sleep(1000);

		city.sendKeys(cityName);
		test.log(LogStatus.PASS, "Enter City Name", "City Name entered successfully");
		Thread.sleep(1000);

		postalCode.sendKeys(postCode);
		test.log(LogStatus.PASS, "Enter Postal Code", "Postal Code entered successfully");
		Thread.sleep(1000);

		state.sendKeys(stateName);
		test.log(LogStatus.PASS, "Enter State Name", "State Name entered successfully");
		Thread.sleep(1000);

		country.sendKeys(countryName);
		test.log(LogStatus.PASS, "Enter Country Name", "Country Name entered successfully");
		Thread.sleep(1000);

		NextConfirmBtn.click();
		test.log(LogStatus.PASS, "Click on Next Confirm Button", "Next Confirm Button clicked successfully");
		Thread.sleep(2000);
		
		UIPanelPersonalDetails();
		
		UIPanelAddressDetails();
		
		confirmBtn.click();
		test.log(LogStatus.PASS, "Click on Confirm Button", "Confirm Button clicked successfully");
		Thread.sleep(2000);
		
		loginHereBtn.click();
		test.log(LogStatus.PASS, "Click on Login Here Button", "Login Here Button clicked successfully");
		Thread.sleep(2000);
		
		UILoginPageCheck();
	}

	public void UILoginPageCheck() {
		Assert.assertTrue(LoginPage.isDisplayed());
		test.log(LogStatus.PASS, LoginPage.getText(), "Login page displayed successfully");
	}
	public void UICheck() {
		Assert.assertTrue(PageHeading.isDisplayed());
		test.log(LogStatus.PASS, PageHeading.getText(), "Signup User page displayed successfully");
	}

	public void UIAddressPageCheck() {
		Assert.assertTrue(AddressPage.isDisplayed());
		test.log(LogStatus.PASS, AddressPage.getText(), "Signup Address page displayed successfully");
	}

	public void UIPanelPersonalDetails() {
		Assert.assertTrue(personalDetails.isDisplayed());
		test.log(LogStatus.PASS, personalDetails.getText(), "Personal Details panel displayed successfully");
	}

	public void UIPanelAddressDetails() {
		Assert.assertTrue(billingAddress.isDisplayed());
		test.log(LogStatus.PASS, billingAddress.getText(), "Billing Address panel displayed successfully");
	}

	public void UIWelComePage() {
		Assert.assertTrue(welcomePage.isDisplayed());
		test.log(LogStatus.PASS, welcomePage.getText(), "Medicare Welcome page is displayed successfully");
	}

}
