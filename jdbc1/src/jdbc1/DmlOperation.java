package jdbc1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DmlOperation {

	public static void main(String[] args) {
	
		
		String qry = "insert into student.info values (12,'krishna')";
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");   // step 1
			System.out.println("step 1");
			Connection con=DriverManager.getConnection(url); // step 2 
			System.out.println("step 2");
		    Statement stmt=con.createStatement(); // step 3
		    System.out.println("step 3");
		    
		    stmt.executeUpdate(qry);
		    
		    System.out.println("step 4");
		    
		    
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
