//test for JDBC
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBCDemo{
	public static void main(String[] args){
		String url = "jdbc:mysql://localhost:3306/NewDatabase";// he used port 3306, also have 8080
	
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url,"root","Tummygoat71!");
		
		Statement statement=connection.createStatement();
		
		ResultSet resultset=statement.executeQuery("select * from NewTable");
		
		while(resultset.next()){
			System.out.println("here is data: " + resultset.getString("Name"));
			
		}
	
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		
		
	}
	
	
	
	
	
}//end of class