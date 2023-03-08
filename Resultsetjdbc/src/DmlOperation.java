import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DmlOperation {

public static void main(String[] args) {
		
		String qry="select * from student.info";
		
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		
		
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection(url);
			
			Statement pstmt=con.createStatement();
			
			
			
			ResultSet rs=pstmt.executeQuery(qry);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				
				String name=rs.getString(2);
				
				System.out.println("id==="+id+"name"+name);
			}
			
			
			
			
		
		}
		catch(Exception e)
        {
			
			e.printStackTrace();
			
		}

	}

}
