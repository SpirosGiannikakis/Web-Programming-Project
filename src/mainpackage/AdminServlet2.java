package mainpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import askhsh1.Program;
import dao.AdministratorDao;
import dao.ProgramDao;

/**
 * Servlet implementation class AdminServlet2
 */
@WebServlet("/AdminServlet2")
public class AdminServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("programModify.jsp").include(request, response);
		
		List<Program> list = ProgramDao.getAllRecords();
		out.println("<head>\r\n" + 
				"<center><img src=\"logo3.png\" alt=\"logo\">\r\n" + 
				"	</br></br>\r\n" + 
				"	<center><h1>Modify an existing Program</h1>\r\n" + 
				"</head>");
		out.println("<body>\r\n" + 
				"<form method=\"get\" action=\"AdminServlet2\">");
		out.println("<label for=\"program\">Select the Program you want to modify:</label><br>");
		out.println("<select id=\"program\" name=\"pname\"></br></br>");
		for(Program p:list){
			
			out.println("<option value=\"pname\" name=\"pname\">" +p.getProgramName() + "</option>");
		}
		out.println("</select><br/><br/>");
		out.println("<label for=\"program\">Modify the wanted fields:</label><br>\r\n" + 
				"<br/><br/>\r\n" + 
				"<label for=\"calls\">Calls:</label>\r\n" + 
				"	</br>\r\n" + 
				"	<input type=\"text\" id=\"calls\" name=\"calls\">\r\n" + 
				"	</br></br>\r\n" + 
				"	<label for=\"sms\">SMS:</label>\r\n" + 
				"	</br>\r\n" + 
				"	<input type=\"text\" id=\"sms\" name=\"sms\">\r\n" + 
				"	</br></br>\r\n" + 
				"	<label for=\"data\">Data:</label>\r\n" + 
				"	</br>\r\n" + 
				"	<input type=\"text\" id=\"data\" name=\"data\">\r\n" + 
				"	</br></br>\r\n" + 
				"	<label for=\"price\">Price:</label>\r\n" + 
				"	</br>\r\n" + 
				"	<input type=\"text\" id=\"price\" name=\"price\">\r\n" + 
				"	</br></br></br></br>");
		out.println("<a href=\"index.jsp\"><button  class=\"button button2\">Cancel</button></a>\r\n" + 
				"	<button class=\"button button1\">Save</button>\r\n" + 
				"	</br></br>\r\n");
		out.println("</form>\r\n" + 
				"</br></br></br>\r\n" + 
				"<center><a href=\"index.jsp\">\r\n" + 
				"  <img src=\"logout.png\" alt=\"Logout\" width=\"30\"; height=\"30\";>\r\n" + 
				"  </a>\r\n" + 
				"  <p>Logout</p>\r\n" + 
				"</body>");
		out.close();
		
		String pname = request.getParameter("pname");
		int calls = Integer.parseInt(request.getParameter("calls"));
		int sms = Integer.parseInt(request.getParameter("sms"));
		int data = Integer.parseInt(request.getParameter("data"));
		float price = Float.parseFloat(request.getParameter("price"));
		Program p = new Program(pname, data, sms, calls, price);
		
		if(pname == "" )	
			out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Unable to add program!</h3>");
		else {
			int status = AdministratorDao.save3(p);
			if(status>0)	
				out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Program added successfully</h3>");
			else
				out.print("<h3 style= \"font-family:century gothic; color:#292F33;\">Unable to add program!</h3>");		
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
