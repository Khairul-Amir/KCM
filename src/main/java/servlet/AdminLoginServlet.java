package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.AdminDAO;
import bean.admin.Admin;
/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO;
	
	public void init() {
        adminDAO = new AdminDAO();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		Admin logAdmin = adminDAO.adminLogin(id, pass);
		
		if(logAdmin == null)
		{
			response.sendRedirect("adminlogin.jsp");
		}
		else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main_page_admin.jsp");
	        request.setAttribute("member", logAdmin);
			dispatcher.forward(request, response);
		}
	}

	

}
