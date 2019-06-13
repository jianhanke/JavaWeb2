package chapter03;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtils {

	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/learn?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String username="root";
		String password="zhao/980931";
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}

	public static void release(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
		
	}
	
}

