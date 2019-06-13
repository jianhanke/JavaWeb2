package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Example01 {

	public static void main(String[] args)  {
		String outAccount="aaa";
		String inAccount="bbb";
			double amount=200;
			Connection conn=null;
			PreparedStatement pstmt1=null;
			PreparedStatement pstmt2=null;
		try {
		conn=JDBCUtils.getConnection();
		conn.setAutoCommit(false);
		String sql="UPDATE account SET money=money-? WHERE name=? AND money>=200";
		pstmt1=conn.prepareStatement(sql);
		pstmt1.setDouble(1, amount);
		pstmt1.setString(2, outAccount);
		
		int num2=pstmt1.executeUpdate();
		System.out.println(num2);
		String sql2="update account set money=money+? where name=?";
		pstmt2=conn.prepareStatement(sql2);
		pstmt2.setDouble(1, amount);
		pstmt2.setString(2, inAccount);
		int nums=pstmt2.executeUpdate();
		System.out.println(nums);
		conn.commit();
		System.out.println("转账成功");

		}catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("转账失败");
			}catch (Exception SQLException) {
				e.printStackTrace();
			}
		}
			
	}

}
