package lib;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Example055 {
	
	public static DataSource ds=null;
	
	static {
		 ds=new ComboPooledDataSource();
		
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(ds.getConnection());
	}
	
	
}
