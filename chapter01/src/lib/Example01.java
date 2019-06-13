package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example01 {

	public static void main(String[] args) throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url="jdbc:mysql://localhost:3306/learn?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String username="root";
		String password="zhao/980931";
		Connection conn=DriverManager.getConnection(url,username,password);
		Statement stmt=conn.createStatement();
		String sql="select * from message";
//		ResultSet rs=stmt.executeQuery(sql);
		boolean str=stmt.execute(sql);
		
		ResultSet rs=stmt.getResultSet();
		
		System.out.println("下面是sql执行后的内容");
		
		while(rs.next()) {
			String userId=rs.getString("user_id");
			String userMessage=rs.getString("user_message");
			String addDate=rs.getString("user_status");
			System.out.println("id:"+userId+",userMessage:"+userMessage+",addDate:"+addDate);
		}
		System.out.println(conn.getMetaData());
		rs.close();
		stmt.close();
		conn.close();

	}

}
