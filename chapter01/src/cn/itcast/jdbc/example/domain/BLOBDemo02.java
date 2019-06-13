package cn.itcast.jdbc.example.domain;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BLOBDemo02 {

	public  static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		conn=JDBCUtils.getConnection();
		String sql="select * from testblob where id=1";
		stmt=conn.prepareStatement(sql);
		rs=stmt.executeQuery();
		if(rs.next()) {
			InputStream in=new BufferedInputStream(rs.getBinaryStream("img"));
			OutputStream out=new BufferedOutputStream(new FileOutputStream("img.jpg"));
			int temp;
			while((temp=in.read())!=-1) {
				out.write(temp);
				System.out.println(temp);
			}
			out.close();
			in.close();
		}
		
		
	}
}
