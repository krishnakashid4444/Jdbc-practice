//  insert the record using prepare statement


package preparestmtjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DmlOperation {

	public static void main(String[] args) {
		
		String qry="insert into student.info values (?,?)";
		
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int id=sc.nextInt();
		
		Scanner tt=new Scanner(System.in);
		System.out.println("enter name");
		
		String ss=tt.nextLine();
		
		
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection(url);
			
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			pstmt.setInt(1, id);
			
			pstmt.setString(2, ss);
			
			pstmt.executeUpdate();
			
			System.out.println("data inserted");
			
			
		
		}
		catch(Exception e)
        {
			
			e.printStackTrace();
			
		}

	}

}
