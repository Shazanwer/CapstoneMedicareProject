package restAPI;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testcases.BaseClass;

public class GetRequest {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;

	@Test
	public void GetAllProductList() {
		RestAssured.baseURI = "http://localhost:8087/medicare/json/data/all/products";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		String ResponseBody = response.getBody().asString();
		test.log(LogStatus.PASS, "Get All Product List", ResponseBody);

		// Print all the product names
		JsonPath jspath = response.jsonPath();
		List<String> names = jspath.get("name");
		for (int count = 0; count < names.size(); count++) {
			test.log(LogStatus.PASS, "Product Name", names.get(count));
		}
	}

	@Test
	public void GetMostValuedProducts() {
		RestAssured.baseURI = "http://localhost:8087/medicare/json/data/mv/products";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		String ResponseBody = response.getBody().asString();
		test.log(LogStatus.PASS, "Get All Product List", ResponseBody);

		// Print all the product names
		JsonPath jspath = response.jsonPath();
		List<String> names = jspath.get("name");
		for (int count = 0; count < names.size(); count++) {
			test.log(LogStatus.PASS, "Product Name", names.get(count));
		}
	}

	@Test
	public void GetMostPurchasedProducts() {
		RestAssured.baseURI = "http://localhost:8087/medicare/json/data/mv/products";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		String ResponseBody = response.getBody().asString();
		test.log(LogStatus.PASS, "Get All Product List", ResponseBody);

		// Print all the product names
		JsonPath jspath = response.jsonPath();
		List<String> names = jspath.get("name");
		for (int count = 0; count < names.size(); count++) {
			test.log(LogStatus.PASS, "Product Name", names.get(count));
		}
	}

	@Test
	public void GetProductListByCategory() {
		RestAssured.baseURI = "http://localhost:8087/medicare/json/data/mv/products";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		String ResponseBody = response.getBody().asString();
		test.log(LogStatus.PASS, "Get All Product List", ResponseBody);

		// Print all the product names
		JsonPath jspath = response.jsonPath();
		List<String> names = jspath.get("name");
		for (int count = 0; count < names.size(); count++) {
			test.log(LogStatus.PASS, "Product Name", names.get(count));
		}
	}

}
