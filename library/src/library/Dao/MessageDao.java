package library.Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import library.Entity.Message;
import library.Utils.C3p0Utils;

public class MessageDao {
	public static void main(String[] args) throws SQLException {
		MessageDao dao=new MessageDao();
		
	}
	public boolean top(String message_id) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="update message set user_status=user_status-10 where user_status=11 or user_status=10";
		int num=runner.update(sql, null);
		String sql2="update message set user_status=user_status+10 where message_id=? ";
		int num2=runner.update(sql2,message_id);
		if(num2>0) {
			return true;
		}
		return false;
		
	}
	public List findAll() throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select  t1.*,t2.user_name from message as t1,user as t2 where t1.user_id=t2.user_id and  (t1.user_status=1 or t1.user_status=0) ";
		List list=(List) runner.query(sql,new BeanListHandler(Message.class));
		return list;
	}
	public Message findOne() throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select  t1.*,t2.user_name from message as t1,user as t2 where t1.user_id=t2.user_id and (t1.user_status=11 or t1.user_status=10) ";
		Message message=(Message) runner.query(sql, new BeanHandler(Message.class));
		return message;
	}
	public boolean delteById(String id) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="delete from message where message_id=? ";
		int num=runner.update(sql, id);
		if(num>0) {
			return true;
		}
		return false;
	}
	
}
