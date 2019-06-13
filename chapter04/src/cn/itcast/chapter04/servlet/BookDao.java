package cn.itcast.chapter04.servlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.itcast.jdbc.utils.JDBCUtils;

public class BookDao {
	private QueryRunner qr=new QueryRunner();
	Connection conn=null;

	public List<Book> findAll() throws Exception{
			conn=JDBCUtils.getConncetion();
			String sql="select * from t_book";
			List<Book> list=qr.query(conn,sql,new BeanListHandler<Book>(Book.class));
			return list;
	}
	public List<Book> findByCategory (int category) throws Exception{		
		try {
			conn=JDBCUtils.getConncetion();
			String sql2="select * from t_book where category=?";
			List<Book> list= (List<Book>) qr.query(conn,sql2,new BeanListHandler<Book>(Book.class),category);
			return list;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
