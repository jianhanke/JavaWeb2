package lib;

import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Example05 {
	public static ComboPooledDataSource ds=null;
	
	static {
		ComboPooledDataSource cpds=new ComboPooledDataSource("itcast");
		ds=cpds;
	}	

	public static void main(String[] args) throws Exception {
		System.out.println(ds.getConnection());
		System.out.println(ds.getConnection().getMetaData().getURL());
	}
	
}
