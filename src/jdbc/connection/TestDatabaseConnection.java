package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDatabaseConnection {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "shubham", "shubham");
			Statement stmt  = conn.createStatement();
			String sql = "SELECT USER_ID, PASSWORD FROM USER_PROFILE";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("USER_ID: " + rs.getString("USER_ID"));
				System.out.println("PASSWORD: " + rs.getString("PASSWORD"));
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT FOUND");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		} 		
	}

}
