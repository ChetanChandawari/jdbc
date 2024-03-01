package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) throws SQLException {
		
		String url="jdbc:mysql://localhost:3306/data";
		String un="root";
		String pwd="0143";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Successfully Loaded");
			
			Connection con=DriverManager.getConnection(url,un,pwd);
			System.out.println("Connection Established");
			
			Statement stmt=con.createStatement();
			
			String query="select * from model where Empid=3";
			
			ResultSet res=stmt.executeQuery(query);
			System.out.println("Query Executed");
			
			res.next();
			
			while(res.next()==true)
			{
			System.out.println(res.getInt("Empid")+""+res.getString("Name"));
		} 
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver Not Loaded");
			e.printStackTrace();
		}
	
	}
}

