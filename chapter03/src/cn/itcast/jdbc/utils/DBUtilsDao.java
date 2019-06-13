package cn.itcast.jdbc.utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import chapter03.User;

public class DBUtilsDao {
	
	public static void main(String[] args) throws Exception {
		List list=findAll();
		for(int i=0;i<list.size();i++) {
			System.out.println( ((User)list.get(i)).getName());
		}
		
	}
	
	public static List findAll() throws Exception{
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from userss";
		List list=(List)runner.query(sql, new BeanListHandler(User.class));
		return list;
	}

	public Boolean insert(User user)throws Exception{
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="insert into userss (name,password) values(?,?)";
		int num=runner.update(sql,new Object[] {
				user.getName(),
				user.getPassword(),
		});
		if(num>0)
			return true;
		return false;	
	}

	public boolean update(User user) throws Exception {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
	String	sql="update userss set name=?,password=? where id=?";
	int num=runner.update(sql,new Object[] {
			user.getName(),
			user.getPassword(),
			user.getId()
	});
	if(num>0)
		return true;
	return false;
	}

	public boolean delete(int i) throws Exception {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
	String sql="delete  from userss where id=?";
	int num=runner.update(sql,i);
	if(num>0)
		return true;
	return false;
		
	}

	public User find(int i) throws Exception {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from userss where id=?";
		User user=(User) runner.query(sql, new BeanHandler(User.class),new Object[]{i});
		return user;
	}
	
}
