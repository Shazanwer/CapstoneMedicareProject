package testcases;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	// TODO Auto-generated method stub

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeTest
	public void DataSetup() throws IOException {

		report = new ExtentReports("ExtentReport.html");
	}

	@AfterTest
	public void DataTearDown() throws IOException {
		report.flush();
		report.close();
	}

	@BeforeMethod
	public void Setup(Method method) {
		test = report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8087/medicare/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

	@AfterMethod
	public void TearDown() {
		report.endTest(test);
		driver.quit();
	}

}
