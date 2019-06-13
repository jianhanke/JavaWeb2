package cn.itcast.jdbc.example.domain;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CLOBDemo02 {

	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement preStmt=null;
		ResultSet rs=null;
		
		conn=JDBCUtils.getConnection();
		String sql="select * from testclob";
		preStmt=conn.prepareStatement(sql);
		rs=preStmt.executeQuery();
		
		if(rs.next()) {
			Reader reader=rs.getCharacterStream("resume");
			Writer out=new FileWriter("resume.txt");
			int temp;
			while((temp=reader.read())!=-1) {
				out.write(temp);
			}
			out.close();
			reader.close();
		}

	}

}
