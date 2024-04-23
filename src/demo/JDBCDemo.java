package demo;
import java.sql.*;

public class JDBCDemo {

	public static void main(String args[])
		throws SQLException, ClassNotFoundException
	{
		String driverClassName = "org.sqlite.JDBC";
		
		String query = "select * from dept where deptno not in(10,20,40)";

		// Load driver class
		Class.forName(driverClassName);

		// Obtain a connection
		Connection con = DriverManager.getConnection(
			"jdbc:sqlite:/Users/Sebastian/Desktop/SQL_Lite/collegeStudents.db");

		// Obtain a statement
		Statement st = con.createStatement();

		// Execute the query
		ResultSet rs = st.executeQuery(query);
		
		
		while(rs.next()){
			
			int dept = rs.getInt("deptno");
			String dName = rs.getString("dname");
			System.out.println(dept+ " | "+dName);
		}
		// Store the data from query results

		// Closing the connection as per the
		// requirement with connection is completed
		con.close();
	}

    
}
