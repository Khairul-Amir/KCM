package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 
public class JDBCStatementDeleteExample {
 
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "system";
	private static final String DB_PASSWORD = "system";
 
	public static void main(String[] argv) {
 
		try {
 
			deleteRecordFromDbUserTable();
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
	}
 
	private static void deleteRecordFromDbUserTable() throws SQLException {
 
		Connection dbConnection = null;
		Statement statement = null;
 
		String deleteTableSQL = "DELETE member WHERE memberid = '002'";
 
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
 
			System.out.println(deleteTableSQL);
 
			// execute delete SQL stetement
			statement.execute(deleteTableSQL);
 
			System.out.println("Record is deleted from member table!");
 
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
 
			dbConnection = DriverManager.getConnection(
                             DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
 
}
