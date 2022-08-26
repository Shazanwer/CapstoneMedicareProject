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
		try {
			stm.executeUpdate(
					"delete from order_item where id in ( select id from order_detail where user_id in ( select id from user_detail where first_name = 'ShazUser'))");
			stm.executeUpdate(
					"delete from order_item where id in ( select id from order_detail where user_id in ( select id from user_detail where first_name = 'ShazSupplier'))");
			stm.executeUpdate(
					"delete from order_detail where user_id in ( select id from user_detail where first_name = 'ShazUser')");
			stm.executeUpdate(
					"delete from order_detail where user_id in ( select id from user_detail where first_name = 'ShazSupplier')");
			stm.executeUpdate(
					"delete from cart where user_id in ( select id from user_detail where first_name = 'ShazUser')");
			stm.executeUpdate(
					"delete from cart where user_id in ( select id from user_detail where first_name = 'ShazSupplier')");
			stm.executeUpdate(
					"delete from address where user_id in ( select id from user_detail where first_name = 'ShazUser')");
			stm.executeUpdate(
					"delete from address where user_id in ( select id from user_detail where first_name = 'ShazSupplier')");
			stm.executeUpdate("delete from user_detail where first_name = 'ShazUser'");
			stm.executeUpdate("delete from user_detail where first_name = 'ShazSupplier'");
		} catch (Exception e1) {
			System.out.println(e1.getStackTrace());
		}

		ResultSet user_detail = stm.executeQuery("Select first_name from user_detail");
		while (user_detail.next()) {
			String getuserdetail = user_detail.getString("first_name");
			if (getuserdetail.equals("ShazUser")) {
				test.log(LogStatus.FAIL, "User still exisits in DB", getuserdetail);
			} else {
				test.log(LogStatus.PASS, "User deleted from DB", getuserdetail + " does not matches ShazUser");
			}
			
			if (getuserdetail.equals("ShazSupplier")) {
				test.log(LogStatus.FAIL, "Supplier still exisits in DB", getuserdetail);
			} else {
				test.log(LogStatus.PASS, "Supplier deleted from DB", getuserdetail + " does not matches ShazSupplier");
			}
		}

	}

}
