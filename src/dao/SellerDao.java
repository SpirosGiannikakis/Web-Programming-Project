package dao;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import askhsh1.Bill;
import askhsh1.Program;
import mainpackage.SaltedHashed;

public class SellerDao {
	public static boolean validate(String username, String hashed, String salt){
		
		boolean status = false;
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from sellers where username =? and hashed_password =? and salt =?");
			ps.setString(1,username);
			ps.setString(2,hashed);
			ps.setString(3,salt);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}
	
	public static List<Bill> showClientBill(String clientPhone) {
		List<Bill> list = new ArrayList<Bill>();
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
			
			YearMonth thisMonth    = YearMonth.now();
			DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM");
			//System.out.printf("Today: %s\n", thisMonth.format(monthYearFormatter));
			
			//String month = thisMonth.format(monthYearFormatter);
			String month = "September";
			PreparedStatement ps = con.prepareStatement("select * from bill where month = ?");
			ps.setString(1, month);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Bill b = new Bill();
				b.setPhoneNumber(rs.getString(1));
				b.setBillingMonth(rs.getString(2));
				b.setPrice(rs.getString(3));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	
	}
}
