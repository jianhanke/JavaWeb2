package cn.itcast.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.itcast.chapter04.servlet.Book;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static ThreadLocal<Connection>threadLocal=new ThreadLocal<Connection>();
	private static DataSource ds=new ComboPooledDataSource();
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConncetion()throws Exception{
		Connection conn=threadLocal.get();
		if(conn==null) {
			conn=ds.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	public static void startTransaction() {
		try {
			Connection conn=getConncetion();
			conn.setAutoCommit(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void commit() {
		try {
			Connection conn=threadLocal.get();
			if(conn!=null) 
				conn.commit();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	public static void rollback() {
		try {
			Connection conn=threadLocal.get();
			if(conn!=null) 
				conn.rollback();
			}catch(Exception e) {
				e.printStackTrace();
		}
	}
	public static void close() {
		Connection conn=threadLocal.get();
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				threadLocal.remove();
				conn=null;
			}
		}
	}
}