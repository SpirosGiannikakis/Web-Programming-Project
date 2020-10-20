package mainpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.ProviderException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SellerDao;
import dao.ClientDao;
import dao.AdministratorDao;

/**
 * Servlet implementation class SellerLogin
 */
@WebServlet("/SellerLogin")
public class SellerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SellerLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");	
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			SecureRandom random = new SecureRandom(); 
			byte bytes[] = password.getBytes();
		    random.nextBytes(bytes);
		    String hashed = SaltedHashed.getHashMD5(password);
			String salt = SaltedHashed.getHashMD5(password ,random.toString());
			
			boolean status = SellerDao.validate(username, hashed, salt);
			boolean status1 = AdministratorDao.validate(username, hashed, salt);
			boolean status2 = ClientDao.validate(username, hashed, salt);
			
			if(status){
				HttpSession session = request.getSession();  
		        session.setAttribute("username",username);  
				response.sendRedirect("startPage.jsp");
     		}
			else if(status1) {
				HttpSession session = request.getSession();  
		        session.setAttribute("username",username);  
				response.sendRedirect("startPageAdmin.jsp");  
				
			}
			else if(status2) {
				HttpSession session = request.getSession();  
		        session.setAttribute("username",username);  
				response.sendRedirect("startPageClients.jsp");
			}
			else{
				out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Incorrect username or password. Please try again</h3>");
//				out.print(hashed);
//				out.print(" ");
//				out.print(salt);
//				request.getRequestDispatcher("error.jsp").include(request, response);
			}
			
			}catch (ProviderException e) { 

		        System.out.println("Exception thrown : " + e); 
		    } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
