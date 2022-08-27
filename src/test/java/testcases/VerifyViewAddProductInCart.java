package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ViewProduct;

public class VerifyViewAddProductInCart extends BaseClass {

	@Test
	public void ViewAddProductInCart() throws InterruptedException {

		LoginPage lPage = new LoginPage();
		lPage.LoginFunction("ShazUser", "1", "shazuser1@yahoo.com", "medicare");

		ViewProduct vProd = new ViewProduct();
		vProd.SelectViewAddBuyProduct("Antipyretics", "Combiflame");

	}

}