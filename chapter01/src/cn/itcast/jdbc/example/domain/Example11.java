package cn.itcast.jdbc.example.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class Example11 {

	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement preStmt=null;
		
		conn=JDBCUtils.getConnection();
		
		
		String sql="INSERT INTO users (id,name,password,email,birthday) VALUES (?,?,?,?,?)";
		System.out.println(sql);
		preStmt=conn.prepareStatement(sql);
		for(int i=205;i<210;i++) {
			preStmt.setInt(1, i+1);
			preStmt.setString(2, "name"+i);
			preStmt.setString(3, "password"+i);
			preStmt.setString(4,"eamil"+i+"@itcast.cn");
			preStmt.setDate(5,Date.valueOf("1989-02-19"));
			preStmt.addBatch();
		}
		int[] nums=preStmt.executeBatch();
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
		System.out.println(nums.length);
		
	}

}
