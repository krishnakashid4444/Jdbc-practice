// wap to insert the record using placeholder


package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
//import java.sql.Statement;

public class DmlOperation {

	public static void main(String[] args) {
	
		
		String qry = "insert into student.info into values(15,'canon') ";
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");   // step 1
			System.out.println("step 1");
			Connection con=DriverManager.getConnection(url); // step 2 
			System.out.println("step 2");
			
			
		   PreparedStatement pstmt=con.prepareStatement(qry); // step 3
		    System.out.println("step 3");
		    
		    pstmt.executeUpdate();
		    
		    
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}


