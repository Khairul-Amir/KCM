package dao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import bean.member.Member;
import bean.member.Child;
import bean.member.PublicMember;
import bean.member.ParentMember;
import bean.admin.Admin;
import bean.fee.Fee;
import bean.fee.KDSFFee;
import bean.fee.Event;
import bean.fee.Membership;
import bean.receipt.Receipt;
import bean.member.RegisterMember;
import loginBean.memberLogin;

public class MemberDAO {
    private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String jdbcUsername = "db502";
    private String jdbcPassword = "system";

    private static final String INSERT_USERS_SQL = "INSERT INTO member" + "  (memberid, membername, memberaddress, memberpostcode, memberstate, memberphoneno, "
    		+ "membergender, membericno, membermsstatus, memberpassword, membertype) VALUES " + " (MEMBER_ID_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String INSERT_FEE_SQL = "INSERT INTO fee (feeid, feeamount, feedesc, feetype, adminid) VALUES (FEE_ID_SEQ.NEXTVAL, ?, ?, ?, ?)";
    
    private static final String INSERT_CHILD_SQL = "INSERT INTO child (childid, childname, childage, childcategory, memberid) "
    		+ "VALUES (CHILD_ID_SEQ.NEXTVAL, ?, ?, ?, ?)";
    
    private static final String INSERT_RECEIPT_SQL = "INSERT INTO receipt (receiptid, memberid, feeid, receiptdate, receiptstatus, receiptamount)"
    		+ " VALUES (RECEIPT_ID_SEQ.NEXTVAL, ?, ?, TRUNC(SYSDATE), ?, ?)";
    
    private static final String INSERT_ADMIN_SQL = "INSERT INTO admin (adminid, managerid, adminname, adminphoneno) VALUES (ADMIN_ID_SEQ.NEXTVAL, ?, ?, ?)";
    
    private static final String INSERT_PUBLICS_SQL = "INSERT INTO publics (memberid, applicantstatus) VALUES (?, ?)";
    
    private static final String INSERT_PARENTS_SQL = "INSERT INTO parents (memberid, numberofchild) VALUES (?, ?)";
    
    private static final String INSERT_KDSF_SQL = "INSERT INTO kdsffee (feeid, categories) VALUES (?, ?)";
    
    private static final String INSERT_EVENT_SQL = "INSERT INTO event (feeid, eventid, eventdescription) VALUES (?, ?, ?)";
    
    private static final String INSERT_MEMBERSHIP_SQL = "INSERT INTO membership (feeid, startdate, enddate) VALUES (?, ?, ?)";

    private static final String SELECT_USER_BY_ID = "select memberid, membername, memberaddress, memberpostcode, memberstate, memberphoneno, membergender, "
    		+ "membericno, membermsstatus, memberpassword, membertype from member where memberid = ?";
    
    private static final String SELECT_FEE_BY_ID = "select feeid, feeamount, feedesc, feetype, adminid from fee where feeid = ?";
    
    private static final String SELECT_EVENT_BY_ID = "select feeid, eventid, eventdescription from event where feeid = ?";
    
    private static final String SELECT_ADMIN_BY_ID = "select adminid, managerid, adminname, adminphoneno from admin where adminid = ?";
    
    private static final String SELECT_ALL_USERS = "select * from member";
    
    private static final String SELECT_ALL_FEES = "select * from fee";
    
    private static final String SELECT_ALL_ADMINS = "select * from admin";
    
    private static final String SELECT_ALL_APPLICANTS = "select * from publics where applicantstatus = 'New Applicant'";
    
    private static final String SELECT_ALL_EVENTS = "select * from event";
    
    private static final String SELECT_ALL_RECEIPTS_BY_FEEID = "select * from receipt where feeid = ?";
    
    private static final String SELECT_ALL_RECEIPTS_BY_MEMBERID = "select * from receipt where memberid = ?";
    
    private static final String DELETE_USERS_SQL = "delete member where memberid = ?";
    
    private static final String DELETE_FEE_SQL = "delete fee where feeid = ?";
    
    private static final String DELETE_ADMIN_SQL = "delete admin where adminid = ?";
    
    private static final String UPDATE_USERS_SQL = "update member set memberid = ?, membername = ?, memberaddress = ?, memberpostcode = ?, memberstate = ?,"
    		+ " memberphoneno = ?, membergender = ?, membericno = ?, membermsstatus = ?, memberpassword = ?, membertype = ? where memberid = ?";
    
    private static final String UPDATE_FEE_SQL = "update fee set feeid = ?, feeamount = ?, feedesc = ?, feetype = ?, adminid = ? where feeid = ?";
    
    private static final String UPDATE_PUBLICS_SQL = "update publics set memberid = ?, applicantstatus = ? where memberid = ?";
    
    private static final String UPDATE_ADMIN_SQL = "update admin set adminid = ?, managerid = ?, adminname = ?, adminphoneno = ? where adminid = ?";

    public MemberDAO() {}

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
    
    public Member validate(String ic, String pass){
    	boolean status=false;
    	Member member = null;
    	  
    	try{  
    	Connection con = getConnection();  
    	              
    	PreparedStatement ps=con.prepareStatement("select memberid, membername, memberaddress, memberpostcode, memberstate, memberphoneno, membergender, "
    			+ "membericno, membermsstatus, memberpassword, membertype "
    			+ "from member "
    			+ "where membericno=? and memberpassword=?");  
    	  
    	ps.setString(1, ic);  
    	ps.setString(2, pass);  
    	              
    	ResultSet rs=ps.executeQuery();
    	while (rs.next()) {
    		String memberid = rs.getString("memberid");
            String membername = rs.getString("membername");
            String memberaddress = rs.getString("memberaddress");
            int memberpostcode = rs.getInt("memberpostcode");
            String memberstate = rs.getString("memberstate");
            String memberphoneno = rs.getString("memberphoneno");
            String membergender = rs.getString("membergender");
            String membericno = rs.getString("membericno");
            String memberstatus = rs.getString("membermsstatus");
            String memberpassword = rs.getString("memberpassword");
            String membertype = rs.getString("membertype");
            member = new Member(memberid, membername, memberaddress, memberpostcode, memberstate, memberphoneno, membergender, membericno, memberstatus, memberpassword, membertype);
        }
    	
    	status=rs.next();  
    	              
    	}catch(Exception e){}  
    	
    	return member;
    	  
    	}
    
    public Admin validateAdmin(String ic, String pass){
    	Admin admin = null;
    	  
    	try{  
    	Connection con = getConnection();  
    	              
    	PreparedStatement ps=con.prepareStatement("select adminid, managerid, adminname, adminphoneno from admin where adminid=? and adminphoneno=?");  
    	  
    	ps.setString(1, ic);  
    	ps.setString(2, pass);  
    	              
    	ResultSet rs=ps.executeQuery();
    	while (rs.next()) {
    		String adminid = rs.getString("adminid");
            String managerid = rs.getString("managerid");
            String adname = rs.getString("adminname");
            String adminphoneno = rs.getString("adminphoneno");
            admin = new Admin(adminid, managerid, adname, adminphoneno);
        }
    	  
    	              
    	}catch(Exception e){}  
    	
    	return admin;
    	  
    	} 

    public void insertUser(Member member) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
           
            preparedStatement.setString(1, member.getMembername());
            preparedStatement.setString(2, member.getMemberaddress());
            preparedStatement.setInt(3, member.getMemberpostcode());
            preparedStatement.setString(4, member.getMemberstate());
            preparedStatement.setString(5, member.getMemberphoneno());
            preparedStatement.setString(6, member.getMembergender());
            preparedStatement.setString(7, member.getMembericno());
            preparedStatement.setString(8, member.getMemberstatus());
            preparedStatement.setString(9, member.getMemberpassword());
            preparedStatement.setString(10, member.getMembertype());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void insertParent(ParentMember pmember) throws SQLException {
        System.out.println(INSERT_PARENTS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PARENTS_SQL)) {
           
            preparedStatement.setString(1, pmember.getMemberid());
            preparedStatement.setInt(2, pmember.getNumberofchild());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void insertFee(Fee fee) throws SQLException {
        System.out.println(INSERT_FEE_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FEE_SQL)) {
           
            preparedStatement.setDouble(1, fee.getFeeamount());
            preparedStatement.setString(2, fee.getFeedesc());
            preparedStatement.setString(3, fee.getFeetype());
            preparedStatement.setString(4, fee.getAdminid());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void insertChild(Child child) throws SQLException {
        System.out.println(INSERT_CHILD_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CHILD_SQL)) {
           
            preparedStatement.setString(1, child.getChildname());
            preparedStatement.setInt(2, child.getChildage());
            preparedStatement.setString(3, child.getChildcategory());
            preparedStatement.setString(4, child.getMemberid());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void insertRegPay(Receipt receipt) throws SQLException {
        System.out.println(INSERT_RECEIPT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RECEIPT_SQL)) {
           
            preparedStatement.setString(1, receipt.getMemberid());
            preparedStatement.setString(2, receipt.getFeeid());
            preparedStatement.setString(3, receipt.getReceiptstatus());
            preparedStatement.setDouble(4, receipt.getReceiptamount());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void insertAdmin(Admin admin) throws SQLException {
        System.out.println(INSERT_ADMIN_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
           
            preparedStatement.setString(1, admin.getManagerid());
            preparedStatement.setString(2, admin.getAdminname());
            preparedStatement.setString(3, admin.getAdminphoneno());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void addKDSF(KDSFFee kdsf) throws SQLException {
        System.out.println(INSERT_KDSF_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_KDSF_SQL)) {
           
            preparedStatement.setString(1, kdsf.getFeeid());
            preparedStatement.setString(2, kdsf.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void addEvent(Event event) throws SQLException {
        System.out.println(INSERT_EVENT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVENT_SQL)) {
           
            preparedStatement.setString(1, event.getFeeid());
            preparedStatement.setString(2, event.getEventid());
            preparedStatement.setString(3, event.getEventdescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public void addMembership(Membership membership) throws SQLException {
        System.out.println(INSERT_MEMBERSHIP_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MEMBERSHIP_SQL)) {
           
            preparedStatement.setString(1, membership.getFeeid());
            preparedStatement.setDate(2, membership.getStartdate());
            preparedStatement.setDate(3, membership.getEnddate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public Member registerUser(RegisterMember member) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        Member regmem = null;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
           
            preparedStatement.setString(1, member.getMembername());
            preparedStatement.setString(2, member.getMemberaddress());
            preparedStatement.setInt(3, member.getMemberpostcode());
            preparedStatement.setString(4, member.getMemberstate());
            preparedStatement.setString(5, member.getMemberphoneno());
            preparedStatement.setString(6, member.getMembergender());
            preparedStatement.setString(7, member.getMembericno());
            preparedStatement.setString(8, member.getMemberstatus());
            preparedStatement.setString(9, member.getMemberpassword());
            preparedStatement.setString(10, member.getMembertype());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
            try{            	              
            	PreparedStatement ps=connection.prepareStatement("select member_id_seq.currval from dual");  
            	             
            	ResultSet rs=ps.executeQuery();
            	while (rs.next()) {
            		String memberid = rs.getString(1);
            		addPublics(memberid);
            		regmem = selectUser(memberid);
                }
            	  
            	              
            	}catch(Exception e){} 
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return regmem;
    }
    
    public void addPublics(String id) throws SQLException {
        System.out.println(INSERT_PUBLICS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PUBLICS_SQL)) {
        	preparedStatement.setString(1, id);
            preparedStatement.setString(2, "New Applicant");           
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public Member addParentMember(Member member) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        Member prtmem = null;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
           
            preparedStatement.setString(1, member.getMembername());
            preparedStatement.setString(2, member.getMemberaddress());
            preparedStatement.setInt(3, member.getMemberpostcode());
            preparedStatement.setString(4, member.getMemberstate());
            preparedStatement.setString(5, member.getMemberphoneno());
            preparedStatement.setString(6, member.getMembergender());
            preparedStatement.setString(7, member.getMembericno());
            preparedStatement.setString(8, member.getMemberstatus());
            preparedStatement.setString(9, member.getMemberpassword());
            preparedStatement.setString(10, member.getMembertype());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
            try{            	              
            	PreparedStatement ps=connection.prepareStatement("select member_id_seq.currval from dual");  
            	             
            	ResultSet rs=ps.executeQuery();
            	while (rs.next()) {
            		String memberid = rs.getString(1);
            		prtmem = selectUser(memberid);
                }
            	  
            	              
            	}catch(Exception e){} 
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return prtmem;
    }
    
    public Member addPublicMember(Member member) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        Member pubmem = null;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
           
            preparedStatement.setString(1, member.getMembername());
            preparedStatement.setString(2, member.getMemberaddress());
            preparedStatement.setInt(3, member.getMemberpostcode());
            preparedStatement.setString(4, member.getMemberstate());
            preparedStatement.setString(5, member.getMemberphoneno());
            preparedStatement.setString(6, member.getMembergender());
            preparedStatement.setString(7, member.getMembericno());
            preparedStatement.setString(8, member.getMemberstatus());
            preparedStatement.setString(9, member.getMemberpassword());
            preparedStatement.setString(10, member.getMembertype());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
            try{            	              
            	PreparedStatement ps=connection.prepareStatement("select member_id_seq.currval from dual");  
            	             
            	ResultSet rs=ps.executeQuery();
            	while (rs.next()) {
            		String memberid = rs.getString(1);
            		adminAddPublics(memberid);
            		pubmem = selectUser(memberid);
                }
            	  
            	              
            	}catch(Exception e){} 
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return pubmem;
    }
    
    public Fee addFee(Fee fee) throws SQLException {
        System.out.println(INSERT_FEE_SQL);
        Fee curfee = null;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FEE_SQL)) {
           
            preparedStatement.setDouble(1, fee.getFeeamount());
            preparedStatement.setString(2, fee.getFeedesc());
            preparedStatement.setString(3, fee.getFeetype());
            preparedStatement.setString(4, fee.getAdminid());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
            try{            	              
            	PreparedStatement ps=connection.prepareStatement("select fee_id_seq.currval from dual");  
            	             
            	ResultSet rs=ps.executeQuery();
            	while (rs.next()) {
            		String feeid = rs.getString(1);
            		curfee = selectFee(feeid);
                }
            	  
            	              
            	}catch(Exception e){} 
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return curfee;
    }
    
    public void adminAddPublics(String id) throws SQLException {
    	System.out.println(INSERT_PUBLICS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PUBLICS_SQL)) {
        	preparedStatement.setString(1, id);
            preparedStatement.setString(2, "Approved");           
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public Fee selectFee(String feeid) {
        Fee fee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FEE_BY_ID);) {
            preparedStatement.setString(1, feeid);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String fid = rs.getString("feeid");
                Double feeamount = rs.getDouble("feeamount");
                String feedesc = rs.getString("feedesc");
                String feetype = rs.getString("feetype");
                String adminid = rs.getString("adminid");
                fee = new Fee(fid, feeamount, feedesc, feetype, adminid);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return fee;
    }
    
    public Event selectEvent(String feeid) {
        Event event = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EVENT_BY_ID);) {
            preparedStatement.setString(1, feeid);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String fid = rs.getString("feeid");
                String eid = rs.getString("eventid");
                String edesc = rs.getString("eventdescription");
                event = new Event(fid, eid, edesc);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return event;
    }
    
    public Admin selectAdmin(String adminid) {
        Admin admin = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_ID);) {
            preparedStatement.setString(1, adminid);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String managerid = rs.getString("managerid");
                String adminname = rs.getString("adminname");
                String adminphoneno = rs.getString("adminphoneno");
                admin = new Admin(adminid, managerid, adminname, adminphoneno);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return admin;
    }

    public Member selectUser(String memberid) {
        Member member = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setString(1, memberid);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String membid = rs.getString("memberid");
                String membername = rs.getString("membername");
                String memberaddress = rs.getString("memberaddress");
                int memberpostcode = rs.getInt("memberpostcode");
                String memberstate = rs.getString("memberstate");
                String memberphoneno = rs.getString("memberphoneno");
                String membergender = rs.getString("membergender");
                String membericno = rs.getString("membericno");
                String memberstatus = rs.getString("membermsstatus");
                String memberpassword = rs.getString("memberpassword");
                String membertype = rs.getString("membertype");
                member = new Member(membid, membername, memberaddress, memberpostcode, memberstate, memberphoneno, membergender, membericno, memberstatus, memberpassword, membertype);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return member;
    }
    
    public List < Fee > selectAllFees() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Fee > fees = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FEES);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String feeid = rs.getString("feeid");
            	Double feeamount = rs.getDouble("feeamount");
                String feedesc = rs.getString("feedesc");
                String feetype = rs.getString("feetype");
                String adminid = rs.getString("adminid");
                fees.add(new Fee(feeid, feeamount, feedesc, feetype, adminid));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return fees;
    }
    
    public List < Event > selectAllEvents() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Event > events = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EVENTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String feeid = rs.getString("feeid");
                String eventid = rs.getString("eventid");
                String eventdescription = rs.getString("eventdescription");
                events.add(new Event(feeid, eventid, eventdescription));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return events;
    }
    
    public List < Receipt > selectReceiptByFeeId(String fid) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Receipt > receipts = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RECEIPTS_BY_FEEID);) {
        	preparedStatement.setString(1, fid);
        	System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String receiptid = rs.getString("receiptid");
            	String memberid = rs.getString("memberid");
                String feeid = rs.getString("feeid");
                Date receiptdate = rs.getDate("receiptdate");
                String receiptstatus = rs.getString("receiptstatus");
                double receiptamount = rs.getDouble("receiptamount");
                receipts.add(new Receipt(receiptid, memberid, feeid, receiptdate, receiptstatus, receiptamount));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return receipts;
    }
    
    public List < Receipt > selectReceiptByMemberId(String mid) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Receipt > receipts = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RECEIPTS_BY_MEMBERID);) {
        	preparedStatement.setString(1, mid);
        	System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String receiptid = rs.getString("receiptid");
            	String memberid = rs.getString("memberid");
                String feeid = rs.getString("feeid");
                Date receiptdate = rs.getDate("receiptdate");
                String receiptstatus = rs.getString("receiptstatus");
                double receiptamount = rs.getDouble("receiptamount");
                receipts.add(new Receipt(receiptid, memberid, feeid, receiptdate, receiptstatus, receiptamount));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return receipts;
    }
    
    public List < Admin > selectAllAdmins() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Admin > admins = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMINS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String adminid = rs.getString("adminid");
            	String managerid = rs.getString("managerid");
                String adminname = rs.getString("adminname");
                String adminphoneno = rs.getString("adminphoneno");
                admins.add(new Admin(adminid, managerid, adminname, adminphoneno));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return admins;
    }

    public List < Member > selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Member > members = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String memberid = rs.getString("memberid");
            	String membername = rs.getString("membername");
                String memberaddress = rs.getString("memberaddress");
                int memberpostcode = rs.getInt("memberpostcode");
                String memberstate = rs.getString("memberstate");
                String memberphoneno = rs.getString("memberphoneno");
                String membergender = rs.getString("membergender");
                String membericno = rs.getString("membericno");
                String memberstatus = rs.getString("membermsstatus");
                String memberpassword = rs.getString("memberpassword");
                String membertype = rs.getString("membertype");
                members.add(new Member(memberid, membername, memberaddress, memberpostcode, memberstate, memberphoneno, membergender, membericno, memberstatus, memberpassword, membertype));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return members;
    }
    
    public List < PublicMember > selectAllApplicants() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List < PublicMember > applicants = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPLICANTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	String memberid = rs.getString("memberid");
            	String applicantstatus = rs.getString("applicantstatus");
                applicants.add(new PublicMember(memberid,applicantstatus));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return applicants;
    }

    public boolean deleteUser(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public boolean deleteFee(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_FEE_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public boolean deleteAdmin(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(Member member) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, member.getMemberid());
            statement.setString(2, member.getMembername());
            statement.setString(3, member.getMemberaddress());
            statement.setInt(4, member.getMemberpostcode());
            statement.setString(5, member.getMemberstate());
            statement.setString(6, member.getMemberphoneno());
            statement.setString(7, member.getMembergender());
            statement.setString(8, member.getMembericno());
            statement.setString(9, member.getMemberstatus());
            statement.setString(10, member.getMemberpassword());
            statement.setString(11, member.getMembertype());
            statement.setString(12, member.getMemberid());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean updateFee(Fee fee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_FEE_SQL);) {
            statement.setString(1, fee.getFeeid());
            statement.setDouble(2, fee.getFeeamount());
            statement.setString(3, fee.getFeedesc());
            statement.setString(4, fee.getFeetype());
            statement.setString(5, fee.getAdminid());
            statement.setString(6, fee.getFeeid());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean updateAdmin(Admin admin) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN_SQL);) {
            statement.setString(1, admin.getAdminid());
            statement.setString(2, admin.getManagerid());
            statement.setString(3, admin.getAdminname());
            statement.setString(4, admin.getAdminphoneno());
            statement.setString(5, admin.getAdminid());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public boolean updatePublics(PublicMember applicant) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PUBLICS_SQL);) {
            statement.setString(1, applicant.getMemberid());
            statement.setString(2, applicant.getApplicantstatus());
            statement.setString(3, applicant.getMemberid());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
