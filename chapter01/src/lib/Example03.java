package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.mysql.cj.jdbc.CallableStatement;
public class Example03 {
		
	static CallableStatement cstmt=null;
	static Connection conn=null;
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/learn?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String username="root";
		String password="zhao/980931";
		conn=DriverManager.getConnection(url,username,password);
		
		cstmt=(CallableStatement) conn.prepareCall("call add_pro(?,?,?)");
		cstmt.setInt(1, 22);
		cstmt.setInt(2, 22);
		cstmt.registerOutParameter(3,Types.INTEGER);
		cstmt.execute();
		System.out.println("½á¹û:"+cstmt.getInt(3));
		
	}
}
