// fetch all the database using preparedstatement


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DmlOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String qry="select * from student.info";
		
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url);
			
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				
				int id=rs.getInt(1);
				String name=rs.getString(2);
				
				System.out.println("id---->"+id+"  name--->"+name);
				
				
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
