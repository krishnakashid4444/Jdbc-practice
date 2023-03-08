package close;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DmlOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		
		
        String qry="select * from student.info  where id=?";
		
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int id=sc.nextInt();
		

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			 con= DriverManager.getConnection(url);
			
			 pstmt=con.prepareStatement(qry);
			
			pstmt.setInt(1, id);
			
			
			
			 rs=pstmt.executeQuery();
			
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
		
		finally
		{
			if(rs!=null)
			{
				try 
				{
					rs.close();
					System.out.println("ResultSet close");
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				
				if(pstmt!=null)
				{
					
					try
					{
						pstmt.close();
						System.out.println("prepareStatement close");
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
					
					if(con!=null)
					{
						try
						{
							con.close();
							System.out.println("connection close");
						}
						catch(SQLException e)
						{
							e.printStackTrace();
						}
					}
					
				}
			}
		}

	}

}



	