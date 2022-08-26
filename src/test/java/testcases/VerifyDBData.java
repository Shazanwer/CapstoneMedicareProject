package testcases;
import java.sql.SQLException;

import org.testng.annotations.Test;

import dbConnection.SelectDataFromDB;

public class VerifyDBData extends BaseClass {
	
	@Test
	public void verifyDbData() throws ClassNotFoundException, SQLException {		
		SelectDataFromDB dbConn = new SelectDataFromDB();
		dbConn.GetDBData();
	}

}
