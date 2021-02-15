package database.connection.com;


/*import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/edubridge","root","root");
		    Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("select * from user");
		    while(rs.next())
		    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		        con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}*/


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.bean.MobileUser;
import com.javatpoint.bean.User;
public class DBConnection {
public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge","root","root");
	}catch(Exception e){System.out.println(e);}
	return con;
}
public static int save(MobileUser mu){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into mobileuser(fname,lname,m_email,m_pass,mobile,price) values(?,?,?,?,?,?)");
		ps.setString(1,mu.getFname());
		ps.setString(2, mu.getLname());
		ps.setString(3, mu.getM_email());
		ps.setString(4, mu.getM_pass());
		ps.setString(5, mu.getMobile());
		ps.setLong(6, mu.getPrice());
		
		
		
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int update(MobileUser mu){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update mobileuser set fname=?,lname=?, m_pass=?,mobile=?,price=? where m_email=?");
		ps.setString(1,mu.getFname());
		ps.setString(2, mu.getLname());
		ps.setString(3,mu.getM_pass());
		ps.setString(4,mu.getMobile());
		ps.setLong(5, mu.getPrice());
		ps.setString(6,mu.getM_email());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int delete(MobileUser mu){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from mobileuser where m_email=?");
		ps.setString(1,mu.getM_email());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}

	return status;
}
public static List<MobileUser> getAllRecords(){
	List<MobileUser> list=new ArrayList<MobileUser>();
	
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from mobileuser");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			MobileUser mu=new MobileUser();
			
			mu.setFname(rs.getString("fname"));
			mu.setLname(rs.getString("lname"));
			mu.setM_email(rs.getString("m_email"));
			mu.setM_pass(rs.getString("m_pass"));
			mu.setMobile(rs.getString("mobile"));
			mu.setPrice(rs.getLong("price"));
			
			
			list.add(mu);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}
public static MobileUser getRecordById(String m_email){
	MobileUser mu=null;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from mobileusers where m_email=?");
		ps.setString(1,m_email);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			mu=new MobileUser();
			
			mu.setFname(rs.getString("fname"));
			mu.setLname(rs.getString("lname"));
			mu.setM_email(rs.getString("m_email"));
			
			mu.setM_pass(rs.getString("m_pass"));
			mu.setMobile(rs.getString("mobile"));
			mu.setPrice(rs.getLong("price"));
			
		}
	}catch(Exception e){System.out.println(e);}
	return mu;

}}

