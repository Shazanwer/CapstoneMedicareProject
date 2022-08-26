package dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class DeleteDataFromDB {

	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;
	Connection dbcon = BaseClass.dbcon;

	public void DeleteDBData() throws SQLException, ClassNotFoundException {

//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare", "root", "root");

		Statement stm = dbcon.createStatement();

		stm.executeUpdate("delete from cart where user_id in ( select id from user_detail where first_name = 'User')");
		stm.executeUpdate(
				"delete from cart where user_id in ( select id from user_detail where first_name = 'Supplier')");
		stm.executeUpdate(
				"delete from address where user_id in ( select id from user_detail where first_name = 'User')");
		stm.executeUpdate(
				"delete from address where user_id in ( select id from user_detail where first_name = 'Supplier')");
		stm.executeUpdate("delete from user_detail where first_name = 'User'");
		stm.executeUpdate("delete from user_detail where first_name = 'Supplier'");

		ResultSet user_detail = stm.executeQuery("Select first_name from user_detail");
		while (user_detail.next()) {
			String getuserdetail = user_detail.getString("first_name");
			if (getuserdetail.contains("User")) {
				test.log(LogStatus.FAIL, "User still exisits in DB", getuserdetail);
			} else {
				test.log(LogStatus.PASS, "User and Supplier deleted from DB", getuserdetail);
			}
		}

	}

}
