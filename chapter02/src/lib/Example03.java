package lib;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Example03 {
	
	public static BasicDataSource ds=null;
	
	static {
		Properties prop=new Properties();
		try {
			InputStream in=new Example03().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
			prop.load(in);
			ds=BasicDataSourceFactory.createDataSource(prop);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection conn=ds.getConnection();
		DatabaseMetaData metaData=conn.getMetaData();
		System.out.println(metaData.getURL()+",UserName="+metaData.getUserName()+","+metaData.getDriverName());
		
	}

}
