package mainpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import askhsh1.Program;
import askhsh1.Seller;
import dao.AdministratorDao;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("registerSeller.jsp").include(request, response);
	
		
		String sellerFirstName = request.getParameter("name");
		String sellerLastName = request.getParameter("surname");
		String sellerUsername = request.getParameter("username");
		String sellerPassword = request.getParameter("password");
		Seller s = new Seller(sellerUsername, sellerFirstName, sellerLastName, sellerPassword);
		
		if(sellerUsername == "" || sellerFirstName == "" || sellerLastName == "" || sellerPassword == "")	
			out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Unable to add seller!</h3>");
		else {
			int status = AdministratorDao.save(s);
			if(status>0)	
				out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Seller added successfully</h3>");
			else
				out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Unable to add seller!</h3>");		
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("newProgram.jsp").include(request, response);
		
		String pname = request.getParameter("pname");
		int calls = Integer.parseInt(request.getParameter("calls"));
		int sms = Integer.parseInt(request.getParameter("sms"));
		int data = Integer.parseInt(request.getParameter("data"));
		float price = Float.parseFloat(request.getParameter("price"));
		Program p = new Program(pname, data, sms, calls, price);
		
		if(pname == "" )	
			out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Unable to add program!</h3>");
		else {
			int status = AdministratorDao.save2(p);
			if(status>0)	
				out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Program added successfully</h3>");
			else
				out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Unable to add program!</h3>");		
		}
		out.close();
		
		
	}

}
