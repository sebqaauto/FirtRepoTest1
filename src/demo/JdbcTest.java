package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {
	
	public static void main(String args[]){  
		
		try{  
			
		Class.forName("com.mysql.jdbc.Driver");  
		
		// 1) Establish the connection with the database
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","student","password");  
		
		// 2) Create a Statement to run a query in database
		Statement stmt= con.createStatement();
		
		// 3) Execute the query and store the result in ResultSet Object
		ResultSet rs=stmt.executeQuery("select * from colgStudents");  
		
		//
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		}  

}
