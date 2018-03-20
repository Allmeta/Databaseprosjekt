package src.dagbok;

import java.sql.*;

public class JdbcTest1 {

	public static void main(String[] args) {
		try {
			// Step 1: "Load" the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Establish the connection to the database
			String url = "jdbc:mysql://mysql.stud.ntnu.no/thomalme_124";

			Connection conn = DriverManager.getConnection(url, "thomalme", "test1");
			System.out.println("Worked nais");
		} catch (Exception e) {
			System.err.println("D'oh! Got an exception!");
			System.err.println(e.getMessage());
		}
	}

}
