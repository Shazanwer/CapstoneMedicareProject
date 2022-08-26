package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;

public class VerifyLogin extends BaseClass {

	@Test
	public void LoginSuccessTest() throws InterruptedException {

		LoginPage lPage = new LoginPage();
		lPage.LoginFunction("ShazUser", "1", "shazuser1@yahoo.com", "medicare");

		lPage.LogOut("ShazUser", "1", "shazuser1@yahoo.com");

		lPage.LoginFunction("ShazSupplier", "1", "shazsupplier1@yahoo.com", "medicare");

		lPage.LogOut("ShazSupplier", "1", "shazuser1@yahoo.com");
	}

}
