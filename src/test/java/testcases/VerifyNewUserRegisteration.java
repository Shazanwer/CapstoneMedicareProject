package testcases;

import org.testng.annotations.Test;

import pages.NewUserRegisterPage;

public class VerifyNewUserRegisteration extends BaseClass {

	@Test
	public void NewUserRegisteration() throws InterruptedException {

		
		NewUserRegisterPage newUsrRegPage = new NewUserRegisterPage();
		
		newUsrRegPage.UserRegisteration("ShazUser","1","1234567890","shazuser1@yahoo.com","medicare","medicare","USER", "addLine1", "addLine2", "city", "postCode", "state", "country");
		
		newUsrRegPage.UserRegisteration("ShazSupplier","1","1234567890","shazsupplier1@yahoo.com","medicare","medicare","SUPPLIER", "addLine1", "addLine2", "city", "postCode", "state", "country");

	}
	
	

}
