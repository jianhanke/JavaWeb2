package lib;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Example02 {
	
	 static Connection conn=null;
	static PreparedStatement preStmt=null;
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/learn?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String username="root";
		String password="zhao/980931";
		conn=DriverManager.getConnection(url,username,password);
		String sql="INSERT INTO user "+"VALUES(?,?,?,?,?)";
		preStmt=conn.prepareStatement(sql);
		preStmt.setString(1,"2233");
		preStmt.setString(2,"java2");
		preStmt.setString(3,"java2");
		preStmt.setString(4,"ÄÐ");
		preStmt.setString(5,"java");
		preStmt.executeUpdate();
		
		
	}

}
