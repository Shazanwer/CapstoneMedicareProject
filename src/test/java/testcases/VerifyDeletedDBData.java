package testcases;
import java.sql.SQLException;

import org.testng.annotations.Test;

import dbConnection.DeleteDataFromDB;

public class VerifyDeletedDBData extends BaseClass {
	
	@Test
	public void verifyDeletedDbData() throws ClassNotFoundException, SQLException {		
		DeleteDataFromDB dbConn = new DeleteDataFromDB();
		dbConn.DeleteDBData();
	}

}
