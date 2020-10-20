package dao;

import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import mainpackage.SaltedHashed;
import askhsh1.Seller;
import askhsh1.Program;

public class AdministratorDao {
	public static boolean validate(String username, String hashed, String salt){
		
		boolean status = false;
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from administrators where username =? and hashed_password =? and salt =?");
			ps.setString(1,username);
			ps.setString(2,hashed);
			ps.setString(3,salt);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return status;
	}
	
	public static int save(Seller s) {
		int status = 0;
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
			
			SecureRandom random = new SecureRandom(); 
			byte bytes[] = s.getPassword().getBytes();
		    random.nextBytes(bytes);
		    
			PreparedStatement ps = con.prepareStatement("insert into sellers(username,firstname,lastname, salt, hashed_password) values(?,?,?,?,?)");
			ps.setString(1,s.getUsername());
			ps.setString(2,s.getName());
			ps.setString(3,s.getSurname());
			ps.setString(4, SaltedHashed.getHashMD5(s.getPassword() ,random.toString()));
			ps.setString(5,SaltedHashed.getHashMD5(s.getPassword()));
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int save2(Program p) {
		int status = 0;
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
		    
			PreparedStatement ps = con.prepareStatement("insert into program(pname, data,sms, calls, fee) values(?,?,?,?,?)");
			ps.setString(1,p.getProgramName());
			ps.setInt(2,p.getData());
			ps.setInt(3,p.getSms());
			ps.setInt(4,p.getCalls());
			ps.setFloat(5,p.getBillingFee());
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int save3(Program p) {
		int status = 0;
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
		    
			PreparedStatement ps = con.prepareStatement("update program set pname = ?, data = ?, sms = ?, calls = ?, fee = ? where pname = ?");
			ps.setString(1,p.getProgramName());
			ps.setInt(2,p.getData());
			ps.setInt(3,p.getSms());
			ps.setInt(4,p.getCalls());
			ps.setFloat(5,p.getBillingFee());
			ps.setString(6,p.getProgramName());
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
