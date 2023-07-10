package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class TestConnection {
	public static void main(String[] argv) {
		 
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		
		String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // xe stand for Oracle XE db name
		String USERNAME = "system";
		String PASSWORD = "system";
		// this is the password you set when you installed XE.
 
		try {
 
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("Oracle JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
				//connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:8080:xe", "system","system");
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
 
}

