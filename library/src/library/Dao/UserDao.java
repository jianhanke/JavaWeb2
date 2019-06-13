package library.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import library.Entity.Sex;
import library.Entity.User;
import library.Utils.C3p0Utils;

public class UserDao {
	
	public static void main(String[] args) throws SQLException {
		UserDao userdao=new UserDao();
		userdao.findSex();
	}
	
	public User find(String id) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from user where user_id=?";
		return (User) runner.query(sql,new BeanHandler(User.class),id);
	}
	
	public List findAll() throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from user";
		return (List) runner.query(sql,new BeanListHandler(User.class));
	}
	public boolean insert(User user) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="insert into user values(?,?,?,?,?) ";
		try {
		int num=runner.update(sql,new Object[]{user.getUser_id(),user.getUser_pwd(),user.getUser_name(),user.getUser_sex(),user.getUser_tele() } );
		if(num>0) {
			return true;
		}
		}catch(Exception e) {
			return false;
		}
		return false;
	}
	public boolean delete(String string) {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="delete from user where user_id=?";
		int num;
		try {
			num = runner.update(sql,string);
		} catch (SQLException e) {
			return false;
		}
		if(num>0) {
			return true;
		}
		return false;
	}
	public boolean update(User user) {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="update user set user_id=?,user_pwd=?,user_name=?,user_sex=?,user_tele=? where user_id=? ";
		try {
			int num=runner.update(sql,new Object[] {user.getUser_id(),user.getUser_pwd(),user.getUser_name(),user.getUser_sex(),user.getUser_tele(),user.getUser_id()});
			if(num>0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}	
	}
	public Sex findSex() throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		Sex sex=new Sex();
		String sql="select count(*) as count from user where user_sex='ÄÐ' ";
		Object man=(Object) runner.query(sql, new ScalarHandler("count") );
		sex.setMan(man.toString());
		
		String sql2="select count(*) as count from user where user_sex='Å®' ";
		Object woman=(Object) runner.query(sql2, new ScalarHandler("count") );
		sex.setWoman(woman.toString());
		
		String sql3="select count(*) as count from user where user_sex='' or user_sex is NULL ";
		Object unknow=(Object) runner.query(sql3, new ScalarHandler("count") );
		sex.setUnkonw(unknow.toString());
		return sex;
	}
	
	
	
}
