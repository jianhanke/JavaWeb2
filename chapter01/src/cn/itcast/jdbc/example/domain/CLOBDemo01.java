package cn.itcast.jdbc.example.domain;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CLOBDemo01 {

	public static void main(String[] args)throws Exception {
		Connection conn=null;
		PreparedStatement preStmt=null;
		
		conn=JDBCUtils.getConnection();
		String sql="insert into testclob values(?,?)";
		preStmt=conn.prepareStatement(sql);
		File file=new File("D:\\itcast.txt");
		Reader reader=new InputStreamReader(new FileInputStream(file),"utf-8");
		preStmt.setInt(1, 1);
		preStmt.setCharacterStream(2, reader,(int)file.length());
		preStmt.executeUpdate();
	}
	
}
