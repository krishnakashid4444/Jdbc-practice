package onerecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DmlOperation {

public static void main(String[] args) {
		
		String qry="select * from student.info  where id=?";
		
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int id=sc.nextInt();
		
		
		
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection(url);
			
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			pstmt.setInt(1, id);
			
			
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				int sid=rs.getInt(1);
				String name=rs.getString(2);
				System.out.println("id--->"+sid+"   name--->"+name);
			}
			
			else
			{
				System.out.println("sorry wrong input");
			}
			
			
		
		}
		catch(Exception e)
        {
			
			e.printStackTrace();
			
		}

	}

}
