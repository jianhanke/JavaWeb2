package library.Dao;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import library.Entity.BookUser;
import library.Entity.Books;

import library.Utils.C3p0Utils;

public class BooksDao {
	
	
	public static void main(String[] args) throws SQLException {
		BooksDao book=new BooksDao();
		book.findCirculate();
	}
	public List findByKeys(String search_sort,String keywords) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from books where "+search_sort+" LIKE" +" '%"+keywords+"%'";
		return (List) runner.query(sql, new BeanListHandler(Books.class));
	}
	
	
	public List findCirculate() throws SQLException {
		List all=new ArrayList();
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select distinct book_id from record ";
		List list=(List) runner.query(sql, new ColumnListHandler());
		for(int i=0;i<list.size();i++) {
			List one =new ArrayList();
			int index=(int) list.get(i);
			
		String sql2=" select distinct t2.user_name from record as t1,user as t2,books as t3 where t1.book_id=?  and t1.user_id=t2.user_id and t1.book_id=t3.id  ";
		 List list2= (List) runner.query(sql2, new ColumnListHandler("user_name"),index);
		 Object[] a =new Object[list2.size()];
		 a =list2.toArray(a);
		 one.add(a);
		 
		 String sql3="select distinct t1.book_id,t2.book_name from record as t1,books as t2 where t1.book_id=? and t1.book_id=t2.id ";
		Object[] object= runner.query(sql3, new ArrayHandler() ,index);
			
			one.add(object);
			all.add(one);
		}
		return all;
	}
	public Books find(String book_id) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from books where id=?";
		return (Books) runner.query(sql,new BeanHandler(Books.class),book_id );
	}
	
	public boolean add(Books book) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="insert into books (book_name,author,press,picture,remark) values(?,?,?,?,?) ";
		int num= runner.update(sql,new Object[] {book.getBook_name(),book.getAuthor(),book.getPress(),book.getPicture(),book.getRemark()});
		if(num>0) {
			return true;
		}
			return false;
	}

	public List findExist() throws Exception {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from books where status=0";
		return (List) runner.query(sql, new BeanListHandler(Books.class) );
	}
	
	public List findAll() throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from books ";
		return (List) runner.query(sql, new BeanListHandler(Books.class) );
	}
	public Object count() throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select count(*) as count from books";
		return (Object) runner.query(sql,new ScalarHandler("count"));
	}
	public List findBorrowed() throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select distinct t3.*,t2.user_name from record as t1,user as t2,books as t3  where t1.status=1 and t3.now_borrow=t2.user_id";
		return (List) runner.query(sql, new BeanListHandler(BookUser.class) );
	}
	public boolean modify(Books book) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="update books set book_name=?,picture=?,remark=?,author=?,press=? where id=?";
		int num=runner.update(sql,new Object[] {book.getBook_name(),book.getPicture(),book.getRemark(),book.getAuthor(), book.getPress(),book.getId()} );
		if(num>0) {
			return true;
		}
		return false;
	}
	
	
	
	
}
