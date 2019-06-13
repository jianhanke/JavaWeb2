package ceshi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.itcast.jdbc.utils.JDBCUtils;

public class BookDao {
	private QueryRunner qr=new QueryRunner();
	private QueryRunner qr2=new QueryRunner(JDBCUtils.getDataSource());
	Connection conn=null;
	public List<Book> findAll() throws Exception {
		
		String sql="select * from t_book";
		List<Book> list=qr2.query(sql,new BeanListHandler<Book>(Book.class));
		return list;
	}
	public List<Book> findByCategory(int category) throws Exception{
		Connection conn=JDBCUtils.getConncetion();
		String sql="select * from t_book where category=?";
		return  qr2.query(conn,sql,new BeanListHandler<Book>(Book.class),category);
	}
	
}
