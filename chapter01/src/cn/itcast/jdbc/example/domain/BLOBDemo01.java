package cn.itcast.jdbc.example.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BLOBDemo01 {

	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement preStmt=null;
		
		conn=JDBCUtils.getConnection();
		
		String sql="insert into testblob values(?,?)";
		preStmt=conn.prepareStatement(sql);
		preStmt.setInt(1, 1);
		File file=new File("D://itcast.jpg");
		InputStream in=new FileInputStream(file);
		preStmt.setBinaryStream(2,in,(int)file.length());
		preStmt.executeUpdate();

	}

}
