package mainpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import askhsh1.Bill;
import askhsh1.Call;
import askhsh1.Program;
import dao.ClientDao;
import dao.ProgramDao;

/**
 * Servlet implementation class ClientHistoryServlet
 */
@WebServlet("/ClientHistoryServlet")
public class ClientHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientHistoryServlet() {
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
		
		request.getRequestDispatcher("historyCall.jsp").include(request, response);
		
		HttpSession session = request.getSession(); 
		String username = (String) session.getAttribute("username");
		
		List<Call> list = ClientDao.showCallHistory(username);
		out.print("<table>");
		out.print("<tr><th>"+"Call with"+"</th><th>"+"Date"+"</th><th>"+"Time"+"</th><th>"+"Duration"+"</th><th>"+"Type"+"</th></tr>");
		for(Call c:list){
			out.println("<tr><td>"+c.getReceiver()+"</td><td>"+c.getCallDate()+"</td><td>"+c.getCallTime()+"</td><td>"+c.getCallDuration()+"</td><td>"+c.getCallType()+"</td>");
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	}

}
