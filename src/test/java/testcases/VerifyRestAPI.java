package testcases;

import org.testng.annotations.Test;

import restAPI.GetRequest;

public class VerifyRestAPI extends BaseClass {
	
	@Test
	public void APIChaining() {

		GetRequest getData = new GetRequest();
		getData.GetAllProductList();
		getData.GetMostValuedProducts();
		getData.GetMostPurchasedProducts();
		getData.GetProductListByCategory();

	}

}
