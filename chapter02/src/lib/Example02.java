package lib;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Example02 {
	public static BasicDataSource ds=null;
	static {
		BasicDataSource dbs=new BasicDataSource();
		dbs.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dbs.setUrl("jdbc:mysql://localhost:3306/learn?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false");
		dbs.setUsername("root");
		dbs.setPassword("zhao/980931");
		dbs.setInitialSize(5);
		dbs.setMaxIdle(5);
		ds=dbs;
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn=((BasicDataSource) ds).getConnection();
		Connection conn2=((BasicDataSource) ds).getConnection();
		Connection conn3=((BasicDataSource) ds).getConnection();
		Connection conn4=((BasicDataSource) ds).getConnection();
		Connection conn5=((BasicDataSource) ds).getConnection();
		Connection conn6=((BasicDataSource) ds).getConnection();
		Connection conn7=((BasicDataSource) ds).getConnection();
		
		DatabaseMetaData metaData=conn.getMetaData();
		System.out.println(metaData.getURL()+",UserName="+metaData.getUserName()+","+metaData.getDriverName());

	}

}
