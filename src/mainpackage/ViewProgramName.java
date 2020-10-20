package mainpackage;

import askhsh1.Program;
import dao.ProgramDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewProgramName")
public class ViewProgramName extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<title>View Programs</title>");
		
		request.getRequestDispatcher("viewPrograms.jsp").include(request, response);
		
		//out.println("<h1 style=\"font-family:century gothic; color:#292F33;\">View Programs</h1>");
		List<Program> list = ProgramDao.getAllRecords();
		out.print("<table>");
		out.print("<tr><th>"+"Program Name"+"</th><th>"+"MB"+"</th><th>"+"SMS"+"</th><th>"+"Talk Time"+"</th><th>"+"Price"+"</th></tr>");
		for(Program p:list){
			out.println("<tr><td>"+p.getProgramName()+"</td><td>"+p.getData()+"</td><td>"+p.getSms()+"</td><td>"+p.getCalls()+"</td><td>"+p.getBillingFee()+"</td>");
			
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<center>");
		out.println("<a href=\"index.jsp\">");
		out.println("</br></br></br></br>");
		out.println("<img src=\"logout.png\" alt=\"Logout\" width=\"30\"; height=\"30\";>");
		out.println("</a>");
		out.println("<p>Logout</p>");
		out.close();
	}

}

