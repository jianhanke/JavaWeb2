package cn.itcast.jdbc.example.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

public class UserDao {

	public boolean insert(User user) throws Exception {
		Connection conn=null;
		Statement stmt=null;
		Result rs=null;
		conn=JDBCUtils.getConnection();
		stmt=conn.createStatement();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		String birthday=sdf.format(user.getBirthday());
		String sql="INSERT INTO users(id,name,password,email,birthday)"+"value('"+user.getId()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+birthday+"')";
		System.out.println(sql);
		int num=stmt.executeUpdate(sql);
		if(num>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public ArrayList<User> findAll() throws Exception{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<User>list=new ArrayList<User>();
		conn=JDBCUtils.getConnection();
		stmt=conn.createStatement();
		String sql="select * from users";
		rs= stmt.executeQuery(sql);
		while(rs.next()) {
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setBirthday(rs.getDate("birthday"));
			list.add(user);
		}
		return list;
	}
	public User find(int id) throws Exception {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		conn=JDBCUtils.getConnection();
		stmt=conn.createStatement();
		String sql="select * from users where id="+id;
		rs=stmt.executeQuery(sql);
		while(rs.next()) {
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setBirthday(rs.getDate("birthday"));
			return user;
		}
		return null;
	}
	
	public boolean update(User user) throws Exception {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		conn=JDBCUtils.getConnection();
		stmt=conn.createStatement();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String birthday=sdf.format(user.getBirthday());
		
		String sql="UPDATE users set name='"+user.getUsername()+"',password='"+user.getPassword()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"',birthday='"+
		birthday+"'WHERE id="+user.getId();
		System.out.println(sql);
		int num=stmt.executeUpdate(sql);
		if(num>0) {
			return true;
		}else {
			return false;
		}	
	}
	public boolean delete(int id) throws Exception {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		conn=JDBCUtils.getConnection();
		stmt=conn.createStatement();
		
		String sql="DELETE FROM users WHERE id="+id;
		int num=stmt.executeUpdate(sql);
		if(num>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
