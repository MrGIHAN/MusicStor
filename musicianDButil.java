 package musician;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class musicianDButil implements imusicianDButil {
	
	//create database connection
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//Login validation
	
	public  List<musicin> validate(String username, String password){
		
		ArrayList<musicin> mus = new ArrayList<>();

		
		//validate
		
		try {
				
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			
			//sql query
			
			String sql = "select * from musician where m_username = '"+username+"' and m_password = '"+password+"'";
			rs = stmt.executeQuery(sql);
			//run sql query
			ResultSet rs = stmt.executeQuery(sql);
			
			//catch user detail
			
			if(rs.next())
			{
				int m_id = rs.getInt(1);
				String m_name = rs.getString(2);
				String m_email = rs.getString(3);
				String m_username = rs.getString(4);
				String m_password = rs.getString(5);
				
				
				musicin m = new musicin(m_id,m_name,m_email,m_username,m_password);
				mus.add(m);
		}
		}	
		catch(Exception e){
			e.printStackTrace(); 
		}
			
		return mus;
		
	}
	
	
	//musician data insert
	
	public boolean insertmusician(String name,String email,String username, String Password) {
		
		boolean isSuccess = false;

		
		try {
			
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			
	
			String sql = "insert into musician values(0,'"+name+"','"+email+"','"+username+"','"+Password+"')";
			int insert = stmt.executeUpdate(sql);
			
			if(insert > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	//update musician data
	
	public  boolean updatemusician(String id, String name,String email,String username,String password) {
		
		try {
			
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			
			String sql ="update musician set m_name='"+name+"', m_email='"+email+"', m_username='"+username+"',m_password='"+password+"'"
						+"where m_id='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else{
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	//retrieve
	public  List<musicin> getmusicianDetails(String id){
		
		int convertedID = Integer.parseInt(id);
		
		ArrayList<musicin> mus = new ArrayList<>();
		
		try {
			
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from musician where m_id ='"+convertedID+"' ";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int m_id = rs.getInt(1);
				String m_name = rs.getString(2);
				String m_email = rs.getString(3);
				String m_username = rs.getString(4);
				String m_password = rs.getString(5);
				
				musicin m = new musicin(m_id,m_name,m_email,m_username,m_password);
				mus.add(m);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mus;
	}
	
	
	//delete account
	
	public  boolean deletemusician(String id) {
		
		int convID = Integer.parseInt(id);
		
		try {
			con =DBconnect.getConnection();
			stmt = con.createStatement();
			String sql ="delete from musician where m_id='"+convID+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}

}






