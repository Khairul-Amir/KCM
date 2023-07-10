package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.admin.Admin;

public class AdminDAO {
	 private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	    private String jdbcUsername = "db502";
	    private String jdbcPassword = "system";

	    private static final String INSERT_USERS_SQL = "INSERT INTO admin" + "  (adminid, managerid, adminname, adminphoneno) "
	    		+ "VALUES (ADMIN_ID_SEQ.NEXTVAL, ?, ?, ?)";

	    private static final String SELECT_USER_BY_ID = "select adminid, managerid, adminname, adminphoneno where adminid=?";
	    
	    private static final String SELECT_ALL_USERS = "select * from admin";
	    
	    private static final String DELETE_USERS_SQL = "delete admin where adminid = ?";
	    
	    private static final String UPDATE_USERS_SQL = "update admin set managerid = ?, adminname = ?, adminphoneno = ? where adminid = ?";

	    public AdminDAO() {}

	    protected Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    
	    public Admin adminLogin(String id, String phoneno){
	    	Admin admin = null;
	    	  
	    	try{  
	    	Connection con = getConnection();  
	    	              
	    	PreparedStatement ps=con.prepareStatement("select adminid, managerid, adminname, adminphoneno from admin where adminid=? and adminphoneno=?");  
	    	  
	    	ps.setString(1, id);  
	    	ps.setString(2, phoneno);  
	    	              
	    	ResultSet rs=ps.executeQuery();
	    	while (rs.next()) {
	    		String adminid = rs.getString("adminid");
	            String managerid = rs.getString("managerid");
	            String adminname = rs.getString("adminname");
	            String adminphoneno = rs.getString("adminphoneno");
	            admin = new Admin(adminid, managerid, adminname, adminphoneno);
	        }
	    	
	    	              
	    	}catch(Exception e){}  
	    	
	    	return admin;
	    	  
	    	}  

	    

	    public boolean deleteAdmin(String id) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
	            statement.setString(1, id);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }


}
