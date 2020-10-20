package mainpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import askhsh1.Bill;
import askhsh1.Client;
import askhsh1.Program;
import dao.ProgramDao;
import dao.SellerDao;

/**
 * Servlet implementation class SellerShowBill
 */
@WebServlet("/SellerShowBill")
public class SellerShowBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerShowBill() {
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
		
		out.println("<title>View Film</title>");
		
		request.getRequestDispatcher("viewPrograms.jsp").include(request, response);
		
		//out.println("<h1 style=\"color:orange;\">View All Programs</h1>");
		List<Program> list = ProgramDao.getAllRecords();
		out.print("<center><img src=\"logo3.png\" alt=\"logo\"> <br/><br/> <center> <h1>View all Programs</h1>");
		out.print("<table>");
		for(Program p:list){
			out.println("<tr><td>"+p.getProgramName()+"</td><td>"+p.getCalls()+"</td><td>"+p.getSms()+"</td><td>"+p.getData() + "</td><td>"+p.getBillingFee()+"</td>");
			
			out.println("</tr>");
		}
		out.println("</table>");
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
		
		out.println("<title>View Programs</title>");
		
		request.getRequestDispatcher("billing.jsp").include(request, response);
		
		//out.println("<h1 style=\"font-family:century gothic; color:#292F33;\">View Programs</h1>");
		String phone = request.getParameter("phone");
		List<Bill> list = SellerDao.showClientBill(phone);
		out.print("<table>");
		out.print("<tr><th>"+"Client's Number"+"</th><th>"+"Month"+"</th><th>"+"Price"+"</th></tr>");
		for(Bill b:list){
			out.println("<tr><td>"+b.getPhoneNumber()+"</td><td>"+b.getBillingMonth()+"</td><td>"+b.getPrice()+"</td>");
			
			out.println("</tr>");
		}
		out.println("</table>");
		out.close();
	}
}
