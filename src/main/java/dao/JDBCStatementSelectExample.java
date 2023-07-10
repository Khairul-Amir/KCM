package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementSelectExample {
	 
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "system";
 
	public static void main(String[] argv) {
 
		try {
 
			selectRecordsFromDbUserTable();
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
	}
 
	private static void selectRecordsFromDbUserTable() throws SQLException {
 
		Connection dbConnection = null;
		Statement statement = null;
 
		String selectTableSQL = "SELECT memberid, membername from member";
 
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
 
			System.out.println(selectTableSQL);
 
			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);
 
			while (rs.next()) {
 
				String mid = rs.getString("memberid");
				String mname = rs.getString("membername");
 
				System.out.println("Member ID : " + mid);
				System.out.println("Name : " + mname);
 
			}
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	}
 
	private static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
 
}
