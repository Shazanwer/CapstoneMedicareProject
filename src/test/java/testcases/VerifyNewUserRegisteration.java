package testcases;

import org.testng.annotations.Test;

import pages.NewUserRegisterPage;

public class VerifyNewUserRegisteration extends BaseClass {

	@Test
	public void NewUserRegisteration() throws InterruptedException {

		
		NewUserRegisterPage newUsrRegPage = new NewUserRegisterPage();
		newUsrRegPage.UserRegisteration("User","1","1234567890","user1@yahoo.com","medicare","medicare"," user ", "addLine1", "addLine2", "city", "postCode", "state", "country");
		
		newUsrRegPage.UserRegisteration("Supplier","1","1234567890","supplier1@yahoo.com","medicare","medicare"," supplier ", "addLine1", "addLine2", "city", "postCode", "state", "country");

	}
	
	

}
