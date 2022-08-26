package dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class SelectDataFromDB {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;
	Connection dbcon = BaseClass.dbcon;

	public void GetDBData() throws SQLException, ClassNotFoundException {

//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare", "root", "root");

		Statement stm = dbcon.createStatement();

		ResultSet getUser = stm.executeQuery("Select * from user_detail where first_name = 'User'");
		while (getUser.next()) {
			String getUserResult = getUser.getInt("ID") + "," + getUser.getString("role") + ","
					+ getUser.getString("email");
			test.log(LogStatus.PASS, "Get User from DB", getUserResult);
		}

		ResultSet getSupplier = stm.executeQuery("Select * from user_detail where first_name = 'Supplier'");
		while (getSupplier.next()) {
			String getSupplierResult = getSupplier.getInt("ID") + "," + getSupplier.getString("role") + ","
					+ getSupplier.getString("email");
			test.log(LogStatus.PASS, "Get Supplier from DB", getSupplierResult);
		}

//		dbcon.close();
	}

}
