package dao;


import java.security.SecureRandom;
import java.sql.*;
import java.util.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import askhsh1.Program;
import mainpackage.SaltedHashed;
import askhsh1.Client;

public class ProgramDao {
	
	public static int save(Client c){
		
		int status = 0;
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into phone(phone, program) values (?, ?)");
			ps.setString(1, c.getPhone());
			ps.setString(2, null);
			status = ps.executeUpdate();
			
			SecureRandom random = new SecureRandom(); 
			byte bytes[] = c.getPassword().getBytes();
		    random.nextBytes(bytes);
		    
			PreparedStatement ps2 = con.prepareStatement("insert into clients(username,firstname,lastname,afm, salt, hashed_password, phone) values(?,?,?,?,?,?,?)");
			ps2.setString(1,c.getUsername());
			ps2.setString(2,c.getName());
			ps2.setString(3,c.getSurname());
			ps2.setString(4, c.getAfm());
			ps2.setString(5, SaltedHashed.getHashMD5(c.getPassword() ,random.toString()));
			ps2.setString(6,SaltedHashed.getHashMD5(c.getPassword()));
			ps2.setString(7, c.getPhone());
			status = ps2.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static List<Program> getAllRecords(){
		
		List<Program> list = new ArrayList<Program>();
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from program");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Program p = new Program();
				p.setProgramName(rs.getString(1));
				p.setData(rs.getInt(2));
				p.setSms(rs.getInt(3));
				p.setCalls(rs.getInt(4));
				p.setBillingFee(rs.getFloat(5));
				list.add(p);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static int assignProgramToClient(String clientPhone, String clientProgram) {
		int status = 0;
		try{
			InitialContext ctx = new InitialContext();
			DataSource datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/postgres");
			Connection con = datasource.getConnection();

			PreparedStatement ps = con.prepareStatement("update phone set phone=?, program=? where phone=?");
			ps.setString(1,clientPhone);
			ps.setString(2,clientProgram);
			ps.setString(3,clientPhone);
			status = ps.executeUpdate();

			con.close();

		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
