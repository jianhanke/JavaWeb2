package chapter03;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.KeyedHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ResultSetTest9 {
	public static DataSource ds=null;
	static {
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		ds=cpds;
	}
	public static void testKeyedHandler()throws Exception{
		String sql="select id,name,password from userss";
		QueryRunner qr=new QueryRunner(ds);
		Map<Object,Map<String,Object>>map=qr.query(sql, new KeyedHandler<Object>("id"));
		Map uMap=(Map)map.get(new Integer(1));
		
		String uName=(String)uMap.get("name");
		String uPassword=(String)uMap.get("password");
		System.out.println(uName+":"+uPassword);
	}
	
	public static void main(String[] args) throws Exception {
		testKeyedHandler();
	}

}
