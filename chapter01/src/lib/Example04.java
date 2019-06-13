package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

public class Example04 {
	static CallableStatement cstmt=null;
	static Connection conn=null;
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/learn?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String username="root";
		String password="zhao/980931";
		conn=DriverManager.getConnection(url,username,password);
		
		String sql="select * from user";
		Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery(sql);
		System.out.print("第二条语句是:");
		rs.absolute(2);
		System.out.println(rs.getString("user_pwd"));
		System.out.print("第一条语句是:");
		rs.beforeFirst();
		rs.next();
		System.out.println(rs.getString("user_id"));
		System.out.println("最后一跳语句");
		rs.afterLast();
		rs.previous();
		System.out.println(rs.getString("user_id"));
		
	}
	
}
