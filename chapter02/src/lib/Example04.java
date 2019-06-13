package lib;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Example04 {
	public static ComboPooledDataSource ds=null;
		
	static {
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/learn?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false");
			cpds.setUser("root");
			cpds.setPassword("zhao/980931");
			cpds.setInitialPoolSize(5);
			cpds.setMaxPoolSize(15);
			ds=cpds;
			
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.out.println(ds.getConnection());
	}
}
