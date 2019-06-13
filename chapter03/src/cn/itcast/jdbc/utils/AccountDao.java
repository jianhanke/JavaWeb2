package cn.itcast.jdbc.utils;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class AccountDao {
	
	public Account find(String name)throws Exception{
		QueryRunner runner=new QueryRunner();
		Connection conn=JDBCUtils.getConncetion();
		String sql="select * from account2 where name=?";
		Account account=(Account)runner.query(conn,sql, new BeanHandler(Account.class),new Object[]{name});
		return account;
	}
	public void update(Account account)throws Exception{
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		Connection conn=JDBCUtils.getConncetion();
		String sql="update account2 set money=? where name=?";
		runner.update(conn,sql,new Object[] {account.getMoney(),account.getName()});
		
	}
	
}
