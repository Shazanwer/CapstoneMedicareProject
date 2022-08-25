package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare", "root", "root");

		Statement stm = dbcon.createStatement();

		ResultSet result = stm.executeQuery("Select * from user_detail");

		while (result.next()) {
			System.out.println(result.getInt("ID") + "," + result.getString("name") + "," + result.getInt("price") + ","
					+ result.getTimestamp("date_added"));
//			System.out.println(result.getString("name"));
//			System.out.println(result.getInt("price"));			
		}
		
		
		ResultSet result1 = stm.executeQuery("Select * from eproduct where ID ='1'");
		while (result1.next()) {
			System.out.println(result1.getInt("ID") + "," + result1.getString("name") + "," + result1.getInt("price") + ","
					+ result1.getTimestamp("date_added"));
//			System.out.println(result.getString("name"));
//			System.out.println(result.getInt("price"));			
		}
		
		
		dbcon.close();
	}

}
