package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	public static Connection dbcon;

	@BeforeTest
	public void DataSetup() throws IOException {

		report = new ExtentReports("ExtentReport.html");

	}

	@AfterTest
	public void DataTearDown(){
		report.flush();
		report.close();

	}

	@BeforeMethod
	public void Setup(Method method) throws ClassNotFoundException, SQLException {
		test = report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8087/medicare/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		Class.forName("com.mysql.cj.jdbc.Driver");
		dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare", "root", "root");

	}

	@AfterMethod
	public void TearDown() throws SQLException {
		report.endTest(test);
		dbcon.close();
		driver.quit();
	}

}
