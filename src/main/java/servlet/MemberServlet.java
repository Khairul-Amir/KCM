package servlet;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

import bean.admin.Admin;
import bean.member.Member;
import bean.member.Child;
import bean.member.PublicMember;
import bean.member.ParentMember;
import bean.fee.Fee;
import bean.fee.KDSFFee;
import bean.fee.Event;
import bean.fee.Membership;
import bean.receipt.Receipt;
import bean.member.RegisterMember;
import dao.MemberDAO;
import loginBean.memberLogin;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;
	
	public void init() {
        memberDAO = new MemberDAO();
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		// Retrieve the session from the request
        HttpSession session = request.getSession();

        // Retrieve the values of the session variables
        String userName = (String) session.getAttribute("userName");
        String userID = (String) session.getAttribute("userID");
		
		try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/list":
                    listUser(request, response);
                    break;
                case "/register":
                    registerMember(request, response);
                    break;
                case "/registerpay":
                    registerPay(request, response);
                    break;
                case "/loginmember":
                    loginMember(request, response);
                    break;
                case "/showMemberForm":
                	showNewMemberForm(request,response);
                	break;
                case "/listmember":
                    listMember(request, response);
                    break;
                case "/loginadmin":
                	loginAdmin(request,response);
                	break;
                case "/listfee":
                	listFee(request,response);
                	break;
                case "/listfeeformember":
                	listFeeForMember(request,response);
                	break;
                case "/listfeepay":
                	listFeePay(request,response);
                	break;
                case "/showNewFeeForm":
                	showNewFeeForm(request,response);
                	break;
                case "/addfee":
                	addFee(request,response);
                	break;
                case "/addkdsffee":
                    addKdsfFee(request, response);
                    break;
                case "/addeventfee":
                    addEventFee(request, response);
                    break;
                case "/addmembershipfee":
                    addMembershipFee(request, response);
                    break;
                case "/editfee":
                	showEditFeeForm(request,response);
                	break;
                case "/updatefee":
                	updateFee(request,response);
                    break;
                case "/deletefee":
                    deleteFee(request, response);
                    break;
                case "/listadmin":
                    listAdmin(request, response);
                    break;
                case "/showNewAdminForm":
                	showNewAdminForm(request,response);
                	break;
                case "/addadmin":
                	addAdmin(request,response);
                	break;
                case "/editadmin":
                	showEditAdminForm(request,response);
                	break;
                case "/updateadmin":
                	updateAdmin(request,response);
                    break;
                case "/deleteadmin":
                    deleteAdmin(request, response);
                    break;
                case "/listapplicant":
                    listApplicant(request, response);
                    break;
                case "/showapplicantdetail":
                    showApplicantDetail(request, response);
                    break;
                case "/approveapplicant":
                    approveApplicant(request, response);
                    break;
                case "/rejectapplicant":
                    rejectApplicant(request, response);
                    break;
                case "/insertparent":
                    insertParent(request, response);
                    break;
                case "/listreceiptbyfeeid":
                    listReceiptByFeeId(request, response);
                    break;
                case "/showAdminProfileForm":
                    showAdminProfileForm(request, response);
                    break;
                case "/updateadminprofile":
                    updateAdminProfile(request, response);
                    break;
                case "/showmainpage":
                    showMainPage(request, response);
                    break;
                case "/showmemberprofileform":
                    showMemberProfileForm(request, response);
                    break;
                case "/updatememberprofile":
                    updateMemberProfile(request, response);
                    break;
                case "/listeventmember":
                    listEventMember(request, response);
                    break;
                case "/joinevent":
                    showJoinEventForm(request, response);
                    break;
                case "/payevent":
                    eventPay(request, response);
                    break;
                case "/listreceiptbymid":
                    listReceiptMember(request, response);
                    break;
                case "/showmainpagemember":
                    mainpagemember(request, response);
                    break;
                case "/showpayformmember":
                    showPayFormMember(request, response);
                    break;
                case "/logout":
                    logout(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		// Retrieve the session from the request
	    HttpSession session = request.getSession();

	    // Invalidate the session
	    session.invalidate();
	    
	    response.sendRedirect("index.jsp");
    }
	
	private void showMainPage(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("main_page_admin.jsp");
        dispatcher.forward(request, response);
    }
	
	private void mainpagemember(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("main_page_member.jsp");
        dispatcher.forward(request, response);
    }
	
	private void showNewFeeForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_fee.jsp");
        dispatcher.forward(request, response);
    }
	
	private void showMemberProfileForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
        Member curLogMem = memberDAO.selectUser(userID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member_profile.jsp");
        request.setAttribute("user", curLogMem);
        dispatcher.forward(request, response);

    }
	
	private void showAdminProfileForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
        Admin existingAdmin = memberDAO.selectAdmin(userID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_profile.jsp");
        request.setAttribute("user", existingAdmin);
        dispatcher.forward(request, response);

    }
	

    private void updateAdminProfile(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException,  IOException {
    	String adid = request.getParameter("adid");
        String managerid = request.getParameter("managerid");
        String adname = request.getParameter("adname");
        String adphoneno = request.getParameter("adphoneno");

        Admin updated = new Admin(adid, managerid, adname, adphoneno);
        memberDAO.updateAdmin(updated);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_profile.jsp");
        request.setAttribute("user", updated);
        dispatcher.forward(request, response);
    }
    
    private void updateMemberProfile(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException,  IOException {
    	String id = request.getParameter("mid");
    	String name = request.getParameter("mname");
        String add = request.getParameter("madd");
        int pc = Integer.parseInt(request.getParameter("mpc"));
        String stt = request.getParameter("mstate");
        String pn = request.getParameter("mphone");
        String gend = request.getParameter("mgen");
        String icno = request.getParameter("mic");
        String status = request.getParameter("mstatus");
        String pass = request.getParameter("mpass");
        String type = request.getParameter("mtype");

        Member updated = new Member(id, name, add, pc, stt, pn, gend, icno, status, pass, type);
        memberDAO.updateUser(updated);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member_profile.jsp");
        request.setAttribute("user", updated);
        dispatcher.forward(request, response);
    }
	
	private void showNewAdminForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_admin.jsp");
        dispatcher.forward(request, response);
    }
	
	private void listFee(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Fee > listFee = memberDAO.selectAllFees();
        request.setAttribute("listFee", listFee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_fee.jsp");
        dispatcher.forward(request, response);
    }
	
	private void listFeeForMember(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Fee > listFee = memberDAO.selectAllFees();
        request.setAttribute("listFee", listFee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_fee_member.jsp");
        dispatcher.forward(request, response);
    }
	
	private void listEventMember(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Event > listEvent = memberDAO.selectAllEvents();
        request.setAttribute("listEvent", listEvent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_event_member.jsp");
        dispatcher.forward(request, response);
    }
	
	private void listFeePay(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Fee > listFee = memberDAO.selectAllFees();
        request.setAttribute("listFee", listFee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_fee_pay.jsp");
        dispatcher.forward(request, response);
    }
	
	private void listReceiptByFeeId(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
		String feeid = request.getParameter("id");
        List < Receipt > listReceipt = memberDAO.selectReceiptByFeeId(feeid);
        request.setAttribute("listReceipt", listReceipt);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_receipt_by_feeid.jsp");
        dispatcher.forward(request, response);
    }
	
	private void listReceiptMember(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
		// Get the current session
		HttpSession session = request.getSession();

		// Retrieve the value of the "userID" attribute from the session
		String userID = (String) session.getAttribute("userID");
		
        List < Receipt > listReceipt = memberDAO.selectReceiptByMemberId(userID);
        request.setAttribute("listReceipt", listReceipt);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_receipt_member.jsp");
        dispatcher.forward(request, response);
    }
	
	private void listApplicant(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < PublicMember > listApplicant = memberDAO.selectAllApplicants();
        request.setAttribute("listApplicant", listApplicant);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_new_applicant.jsp");
        dispatcher.forward(request, response);
    }	
	
	private void listAdmin(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Admin > listAdmin = memberDAO.selectAllAdmins();
        request.setAttribute("listAdmin", listAdmin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_admin.jsp");
        dispatcher.forward(request, response);
    }
	
	private void loginAdmin(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException, IOException, ServletException{
		String icno = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		Admin logAdmin= memberDAO.validateAdmin(icno,pass);		        
        
		if(logAdmin != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("main_page_admin.jsp");
	        request.setAttribute("logadmin", logAdmin);
			dispatcher.forward(request, response);
		}  
		else  
		{  
			response.sendRedirect("adminlogin.jsp");
		}
		
	}
	
	private void listMember(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Member > listMember = memberDAO.selectAllUsers();
        request.setAttribute("listMember", listMember);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_member.jsp");
        dispatcher.forward(request, response);
    }
	
	private void addKdsfFee(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
		String fid = request.getParameter("fid");
        String category = request.getParameter("category");
        KDSFFee newKDSF = new KDSFFee(fid,category);
        memberDAO.addKDSF(newKDSF);
        response.sendRedirect("listfee");
    }
	
	private void addEventFee(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
		String fid = request.getParameter("fid");
		String eid = request.getParameter("eid");
        String edesc = request.getParameter("edesc");
        Event newEvent = new Event(fid,eid,edesc);
        memberDAO.addEvent(newEvent);
        response.sendRedirect("listfee");
    }
	
	private void addMembershipFee(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
		String feeId = request.getParameter("fid");
        String startDateString = request.getParameter("sd");
        String endDateString = request.getParameter("ed");

        // Convert the date strings to java.sql.Date objects
        Date startDate = Date.valueOf(startDateString);
        Date endDate = Date.valueOf(endDateString);

        Membership newMembership = new Membership(feeId, startDate, endDate);
        
        memberDAO.addMembership(newMembership);
        response.sendRedirect("listfee");
    }
	
	private void showNewMemberForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("admin_add_member.jsp");
    }

	private void loginMember(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException{
				String icno = request.getParameter("ic");
				String pass = request.getParameter("pass");
				
				Member logMember = memberDAO.validate(icno,pass);		        
		        
				if(logMember != null){
					RequestDispatcher dispatcher = request.getRequestDispatcher("main_page_member.jsp");
			        request.setAttribute("member", logMember);
					dispatcher.forward(request, response);
				}  
				else  
				{  
					response.sendRedirect("index.jsp");
				}
		
	}

	private void registerMember(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
		String name = request.getParameter("name");
        String add = request.getParameter("address");
        int pc = Integer.parseInt(request.getParameter("postcode"));
        String stt = request.getParameter("state");
        String pn = request.getParameter("phoneno");
        String gend = request.getParameter("gender");
        String icno = request.getParameter("icno");
        String status = request.getParameter("status");
        String pass = request.getParameter("password");
        String type = request.getParameter("type");
        String feeid = "1";
        RegisterMember newMember = new RegisterMember(name, add, pc, stt, pn, gend, icno, status, pass, type);  
        Member regmen = memberDAO.registerUser(newMember);
        Fee regFee = memberDAO.selectFee(feeid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("register_pay.jsp");
        request.setAttribute("fee", regFee);
        request.setAttribute("member", regmen);
		dispatcher.forward(request, response);
    }
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Member > listMember = memberDAO.selectAllUsers();
        request.setAttribute("listMember", listMember);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("member-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Member existingUser = memberDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_edit_member.jsp");
        request.setAttribute("member", existingUser);
        dispatcher.forward(request, response);

    }
    
    private void showApplicantDetail(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Member existingUser = memberDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("approve_applicant.jsp");
        request.setAttribute("applicant", existingUser);
        dispatcher.forward(request, response);

    }
    
    private void showEditFeeForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Fee existingFee= memberDAO.selectFee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit_fee.jsp");
        request.setAttribute("fee", existingFee);
        dispatcher.forward(request, response);

    }
    
    private void showJoinEventForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Event existingEvent = memberDAO.selectEvent(id);
        Fee relatedFee = memberDAO.selectFee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("join_event.jsp");
        request.setAttribute("event", existingEvent);
        request.setAttribute("fee", relatedFee);
        dispatcher.forward(request, response);

    }
    
    private void showPayFormMember(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Fee relatedFee = memberDAO.selectFee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pay_form_member.jsp");
        request.setAttribute("fee", relatedFee);
        dispatcher.forward(request, response);

    }
    
    private void showEditAdminForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Admin existingAdmin = memberDAO.selectAdmin(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit_admin.jsp");
        request.setAttribute("admin", existingAdmin);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String add = request.getParameter("address");
        int pc = Integer.parseInt(request.getParameter("postcode"));
        String stt = request.getParameter("state");
        String pn = request.getParameter("phoneno");
        String gend = request.getParameter("gender");
        String icno = request.getParameter("icno");
        String status = request.getParameter("status");
        String pass = request.getParameter("password");
        String type = request.getParameter("type");
        Member newMember = new Member(name, add, pc, stt, pn, gend, icno, status, pass, type);
        if(newMember.getMembertype().equals("Parent")) {
        	Member prnt = memberDAO.addParentMember(newMember);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("add_parent.jsp");
            request.setAttribute("parent", prnt);
            dispatcher.forward(request, response);
        }
        else {
        	Member pblc = memberDAO.addPublicMember(newMember);
        	response.sendRedirect("listmember");
        }
    }
    
    private void registerPay(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String memberid = request.getParameter("mid");
        String feeid = request.getParameter("fid");
        String rstatus = request.getParameter("rstatus");
        Double ramount = Double.parseDouble(request.getParameter("ramount"));
        Receipt newPay = new Receipt(memberid, feeid, rstatus, ramount);
        memberDAO.insertRegPay(newPay);
        response.sendRedirect("success.jsp");
    }
    
    private void eventPay(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String memberid = request.getParameter("mid");
        String feeid = request.getParameter("fid");
        String rstatus = request.getParameter("rstatus");
        Double ramount = Double.parseDouble(request.getParameter("famount"));
        Receipt newPay = new Receipt(memberid, feeid, rstatus, ramount);
        memberDAO.insertRegPay(newPay);
        response.sendRedirect("success_pay_fee.jsp");
    }
    
    private void addFee(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String fdesc = request.getParameter("fdesc");
        Double famount = Double.parseDouble(request.getParameter("famount"));
        String ftype = request.getParameter("ftype");
        String faid = request.getParameter("faid");
        Fee newFee = new Fee(famount, fdesc, ftype, faid);
        
        if(newFee.getFeetype().equals("Membership")) {
        	Fee mfee = memberDAO.addFee(newFee);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("add_membership.jsp");
            request.setAttribute("mfee", mfee);
            dispatcher.forward(request, response);
        }
        else if(newFee.getFeetype().equals("Event")) {
        	Fee efee = memberDAO.addFee(newFee);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("add_event.jsp");
            request.setAttribute("efee", efee);
            dispatcher.forward(request, response);
        }else
        {
        	Fee kfee = memberDAO.addFee(newFee);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("add_kdsf.jsp");
            request.setAttribute("kfee", kfee);
            dispatcher.forward(request, response);
        }
        response.sendRedirect("listfee");
    }
    
    private void insertParent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
	    String parentid = request.getParameter("pid");
	    int noc = Integer.parseInt(request.getParameter("noc"));
	    ParentMember newParent = new ParentMember(parentid, noc);
	    memberDAO.insertParent(newParent);
	        
	    // Retrieve child details
	    List < Child > children = new ArrayList<>();
	    for (int i = 1; i <= noc; i++) {
	        String childName = request.getParameter("childName" + i);
	        int childAge = Integer.parseInt(request.getParameter("childAge" + i));
	        String childCategory = request.getParameter("childCategory" + i);
	            
	        Child child = new Child(childName, childAge, childCategory, parentid);
	        children.add(child);
	        
	        memberDAO.insertChild(child);
	    }
        
	    // Perform necessary operations with parent and child data
	    
	    // Forward to the same page to continue entering child details
	    response.sendRedirect("listmember");
    }
    
    private void addAdmin(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String managerid = request.getParameter("managerid");
        String adname = request.getParameter("adname");
        String adphoneno = request.getParameter("adphoneno");
        Admin newAdmin = new Admin(managerid, adname, adphoneno);
        memberDAO.insertAdmin(newAdmin);
        response.sendRedirect("listadmin");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	String id = request.getParameter("id");
        String name = request.getParameter("name");
        String add = request.getParameter("address");
        int pc = Integer.parseInt(request.getParameter("postcode"));
        String stt = request.getParameter("state");
        String pn = request.getParameter("phoneno");
        String gend = request.getParameter("gender");
        String icno = request.getParameter("icno");
        String status = request.getParameter("status");
        String pass = request.getParameter("password");
        String type = request.getParameter("type");

        Member book = new Member(id, name, add, pc, stt, pn, gend, icno, status, pass, type);
        memberDAO.updateUser(book);
        response.sendRedirect("listmember");
    }
    
    private void updateFee(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	String fid = request.getParameter("fid");
        String fdesc = request.getParameter("fdesc");
        Double famount = Double.parseDouble(request.getParameter("famount"));
        String ftype = request.getParameter("ftype");
        String faid = request.getParameter("faid");

        Fee book = new Fee(fid, famount, fdesc, ftype, faid);
        memberDAO.updateFee(book);
        response.sendRedirect("listfee");
    }
    
    private void updateAdmin(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	String adid = request.getParameter("adid");
        String managerid = request.getParameter("managerid");
        String adname = request.getParameter("adname");
        String adphoneno = request.getParameter("adphoneno");

        Admin book = new Admin(adid, managerid, adname, adphoneno);
        memberDAO.updateAdmin(book);
        response.sendRedirect("listadmin");
    }
    
    private void approveApplicant(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	String appid = request.getParameter("id");
    	String appstatus = "Approved";
        PublicMember book = new PublicMember(appid, appstatus);
        memberDAO.updatePublics(book);
        response.sendRedirect("listapplicant");
    }
    
    private void rejectApplicant(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	String appid = request.getParameter("id");
    	String appstatus = "Rejected";
        PublicMember book = new PublicMember(appid, appstatus);
        memberDAO.updatePublics(book);
        response.sendRedirect("listapplicant");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String id = request.getParameter("id");
        memberDAO.deleteUser(id);
        response.sendRedirect("listmember");

    }
    
    private void deleteFee(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String id = request.getParameter("id");
        memberDAO.deleteFee(id);
        response.sendRedirect("listfee");

    }
    
    private void deleteAdmin(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String id = request.getParameter("id");
        memberDAO.deleteAdmin(id);
        response.sendRedirect("listadmin");

    }

	

}
