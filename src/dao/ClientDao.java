package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import askhsh1.Bill;
import askhsh1.Call;
import askhsh1.Program;

public class ClientDao {
	public static boolean validate(String username, String hashed, String salt){
		
		boolean status = false;
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from clients where username =? and hashed_password =? and salt =?");
			ps.setString(1,username);
			ps.setString(2,hashed);
			ps.setString(3,salt);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}
	
	public static List<Call> showCallHistory(String username){
		
		List<Call> list = new ArrayList<Call>();
		String phone = null;
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
			
			PreparedStatement ps2 = con.prepareStatement("select phone from clients where username = ?");
			ps2.setString(1, username);
			ResultSet rs = ps2.executeQuery();
			while(rs.next()){
				phone = rs.getString(1);
			}
			
			PreparedStatement ps = con.prepareStatement("select * from call where phone = ?");
			ps.setString(1, phone);
			ResultSet rs2 = ps.executeQuery();
			while(rs2.next()){
				Call c = new Call();
				c.setReceiver(rs.getString(1));
				c.setCallDate(rs.getString(2));
				c.setCallTime(rs.getString(3));
				c.setCallDuration(rs.getString(4));
				c.setCallType(rs.getString(5));
				list.add(c);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	
		
	}
}
