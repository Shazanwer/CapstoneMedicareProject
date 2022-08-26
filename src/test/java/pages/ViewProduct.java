package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class ViewProduct {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;

	// ==============Web Elements=======================//

	@FindBy(xpath = "//div[@class='list-group']/a[@class='list-group-item']")
	List<WebElement> CategoryList;

	@FindBy(xpath = "//div[@class='thumbnail card-layout']")
	List<WebElement> HomePageProductList;

	@FindBy(xpath = "//div[@class='thumbnail card-layout']/h5[@class='ng-binding']")
	List<WebElement> HomePageProductName;

	@FindBy(xpath = "//tbody/tr")
	List<WebElement> ProductList;

	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> ProductName;

	@FindBy(xpath = "//div[@class='thumbnail card-layout']/div/a[@class='btn btn-primary pull-right']")
	List<WebElement> HomePageViewBtn;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-eye-open']")
	List<WebElement> ViewBtn;

	@FindBy(xpath = "//div/h3")
	WebElement ViewProductName;

	@FindBy(xpath = "//a[@class='btn btn-success']")
	WebElement AddToCartBtn;

	@FindBy(xpath = "//a[@class='btn btn-success btn-block']")
	WebElement CheckoutBtn;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement SelectAddrBtn;

	@FindBy(id = "cardNumber")
	WebElement CardNoField;

	@FindBy(id = "expityMonth")
	WebElement ExpiryMonthField;

	@FindBy(id = "expityYear")
	WebElement ExpiryYearField;

	@FindBy(id = "cvCode")
	WebElement CVCodeField;

	@FindBy(xpath = "//a[@class='btn btn-success btn-lg btn-block']")
	WebElement PayBtn;

	@FindBy(xpath = "//h3[@class='text-center']")
	WebElement OrderSummaryPage;

	@FindBy(xpath = "//a[@class='btn btn-lg btn-warning']")
	WebElement ContShpngBtn;

	public ViewProduct() {

		PageFactory.initElements(driver, this);

	}

	public void SelectViewAddBuyProduct(String Category, String prodName) throws InterruptedException {
		for (int catCount = 0; catCount < CategoryList.size(); catCount++) {

			if (CategoryList.get(catCount).getText().equals(Category)) {
				CategoryList.get(catCount).click();
				test.log(LogStatus.PASS, "CategoryName " + CategoryList.get(catCount).getText(),
						"Category clicked Successfully");
				for (int count = 0; count < ProductList.size(); count++) {

					if (ProductName.get(count).getText().equals(prodName)) {
						ViewBtn.get(count).click();
						test.log(LogStatus.PASS, "ProductName: " + ViewProductName.getText(),
								"Searched Product Viewed Successfully");
						Thread.sleep(1000);
						AddToCartBtn.click();
						test.log(LogStatus.PASS, "Add to Cart", "Product added to cart Successfully");
						Thread.sleep(1000);
						CheckoutBtn.click();
						test.log(LogStatus.PASS, "Checkout", "Product checked-out Successfully");
						Thread.sleep(1000);
						SelectAddrBtn.click();
						test.log(LogStatus.PASS, "Select Address", "Address selected Successfully");
						Thread.sleep(1000);
						CardNoField.sendKeys("1234567890");
						Thread.sleep(1000);
						ExpiryMonthField.sendKeys("01");
						Thread.sleep(1000);
						ExpiryYearField.sendKeys("2025");
						Thread.sleep(1000);
						CVCodeField.sendKeys("123");
						Thread.sleep(1000);
						test.log(LogStatus.PASS, "ENter Card Info", "Card Info entered Successfully");
						PayBtn.click();
						Thread.sleep(1000);
						test.log(LogStatus.PASS, "Pay", "Paid Successfully");
						test.log(LogStatus.PASS, "Order Summary Page",
								OrderSummaryPage.getText() + " displayed Successfully");
						Thread.sleep(1000);
						ContShpngBtn.click();
						test.log(LogStatus.PASS, "Home Page", "Medicare Home Page displayed successfully");
						Thread.sleep(1000);
					} else {
						test.log(LogStatus.PASS, "ProductName: " + ProductName.get(catCount).getText(),
								"Searched Product does not matches");
					}
				}
			} else {
				test.log(LogStatus.PASS, "CategoryName " + CategoryList.get(catCount).getText(),
						"Category does not matches");
			}
		}

	}

}
