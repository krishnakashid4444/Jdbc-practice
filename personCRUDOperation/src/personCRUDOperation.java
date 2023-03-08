
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class personCRUDOperation {
	
	
	public void saveperson(int id, String name,String phone,int age,String email_id,String password)
	{
		String qry="insert into person.info values(?,?,?,?,?,?)";
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("step 1 is done");
		    
		    Connection con=DriverManager.getConnection(url);
		    
		    System.out.println("step 2 is done");
		    
		    PreparedStatement ps=con.prepareStatement(qry);
		    
		    System.out.println("step 3 is done");
		    
		    ps.setInt(1,id);
		    ps.setString(2,name);
		    ps.setString(3,phone);
		    ps.setInt(4,age);
		    ps.setString(5,email_id );
		    ps.setString(6,password);
		    
		    ps.executeUpdate();
		    
		    con.close();
		    
		       
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void getPersonById(int id)
	{
		
		String qry="select * from person.info where id=?";
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url);
			
			PreparedStatement ps=con.prepareStatement(qry);
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				int sid=rs.getInt(1);
				String namee=rs.getString(2);
				String phonee=rs.getString(3);
				int age=rs.getInt(4);
				String email=rs.getString(5);
				String pass=rs.getString(6);
				
				System.out.println("id-->"+sid+" name-->"+namee+" phone-->"+phonee+" age-->"+age+" email-->"+email+" password-->"+pass);
				
				
				con.close();
				
				
				
			}
			
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void getAllPerson()
	{
		
		String qry="select * from person.info";
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url);
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery(qry);
			
			
			
			
			while(rs.next())
			{
				int sid=rs.getInt(1);
				String namee=rs.getString(2);
				String phonee=rs.getString(3);
				int age=rs.getInt(4);
				String email=rs.getString(5);
				String pass=rs.getString(6);
				
				System.out.println("id-->"+sid+" name-->"+namee+" phone-->"+phonee+" age-->"+age+" email-->"+email+" password-->"+pass);
				
			}
			
			con.close();
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deletePerson(int id)
	{
		String qry="delete from person.info where id=?";
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url);
			
			PreparedStatement ps=con.prepareStatement(qry);
			
			ps.setInt(1,id);
			
			ps.executeUpdate();
		
		    con.close();
		
			
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void validatePerson(String email_id, String password)
	{
		
		String qry="select * from person.info where email_id=? and password=?";
		String url="jdbc:mysql://localhost:3306?user=root&password=root";
		
		try
		{
            Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url);
			
			PreparedStatement ps=con.prepareStatement(qry);
			
			ps.setString(1,email_id);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				
				int sid=rs.getInt(1);
				String namee=rs.getString(2);
				String phonee=rs.getString(3);
				int age=rs.getInt(4);
				String email=rs.getString(5);
				String pass=rs.getString(6);
				
				System.out.println("id-->"+sid+" name-->"+namee+" phone-->"+phonee+" age-->"+age+" email-->"+email+" password-->"+pass);
				
				
			}
			
			con.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		personCRUDOperation pp=new personCRUDOperation();
		
		//pp.saveperson(1,"krishna","9699945482",25,"krishnakashid4444@gmail.com","Krish24");
		//pp.saveperson(2,"Mama","9702342997",34,"krishnakashid4444@gmail.com","Mama@27");
		//pp.saveperson(3,"shravni","5647889563",30,"krishnakashid4444@gmail.com","Shravni@27");
		//pp.saveperson(4,"Jenny","2347845367",27,"krishnakashid4444@gmail.com","Jenny@123");
		//pp.saveperson(5,"katrina","4567387589",32,"krishnakashid4444@gmail.com","Katrina@34");
		
		// pp.getPersonById(4);
		
		// pp.getAllPerson();
		
		//pp.deletePerson(2);
		
		//pp.validatePerson("krishnakashid4444@gmail.com", "Krish24");
	}

}
