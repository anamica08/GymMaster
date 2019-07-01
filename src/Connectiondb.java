import java.sql.*;
public class Connectiondb {
	public Connection con1;
	public Connection connectionMYSQL(){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","root");    
		//Statement stmt=conn.createStatement(); 
		System.out.println("connected");
		
		}catch(Exception e)
		{ 
			System.out.println(e);
		}
		return con1;  
		} 
}
