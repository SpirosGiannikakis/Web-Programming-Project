package mainpackage;

import askhsh1.Client;
import dao.ProgramDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SellerServlet")
public class SellerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("addClient.jsp").include(request, response);
	
		
		String clientUsername = request.getParameter("username");
		String clientFirstName = request.getParameter("name");
		String clientLastName = request.getParameter("surname");
		String clientPassword = request.getParameter("password");
		String clientAfm = request.getParameter("afm");
		String clientPhone = request.getParameter("phone");
			
		Client c = new Client(clientUsername, clientFirstName, clientLastName, clientPassword, clientAfm, clientPhone);
		
		if(clientUsername == "" || clientFirstName == "" || clientLastName == "" || clientPassword == "")	
			out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Unable to add client!</h3>");
		else {
			int status = ProgramDao.save(c);
			if(status>0)	
				out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Client added successfully</h3>");
			else
				out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Unable to add client!</h3>");		
		}
		out.close();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("assignProgramToClient.jsp").include(request, response);
		
		String clientPhone = request.getParameter("phone");
		String clientProgram = request.getParameter("program");
			
		if(clientPhone == "" || clientProgram== "") {
			
			out.print("<h3 style= \"color:white;\">Unable to assign program!</h3>");
			
		}else {
			
			int status = ProgramDao.assignProgramToClient(clientPhone, clientProgram);
			
			if(status>0){
				
				out.print("<h3 style= \"color:white;\">Program assigned succesfully!</h3>");
				
			}else{
				out.print("<h3 style= \"color:white;\">Unable to assign program!</h3>");
			}		
			
		}
		
		
		out.close();
	}



}
