package cn.itcast.jdbc.example.domain;

import java.sql.Connection;
import java.sql.Statement;

public class Example10 {

	public static void main(String[] args) throws Exception {
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=JDBCUtils.getConnection();
		stmt=conn.createStatement();
		
		String sql1="DROP TABLE IF EXISTS school";
		String sql2="CREATE TABLE school (id int,name varchar(20))";
		String sql3="INSERT INTO school VALUES(2,'´«²¥Ö¹¿È')";
		String sql4="UPDATE school SET id=1";
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			stmt.addBatch(sql4);
			stmt.executeBatch();	
	}
	
}
