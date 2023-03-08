package deletejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DmlOperation {

	public static void main(String[] args) {
		
		String qry = "delete from student.info where id=12 ";
		
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			System.out.println("step 1");
			
			
			Connection con=DriverManager.getConnection(url);
			
			System.out.println("step 2");
			
			Statement stmt= con.createStatement();
			
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
