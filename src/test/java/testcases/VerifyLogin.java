package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;

public class VerifyLogin extends BaseClass {

	@Test
	public void LoginSuccessTest() throws InterruptedException {

		LoginPage lPage = new LoginPage();
		lPage.LoginFunction("user1@yahoo.com", "medicare");

	}

}
