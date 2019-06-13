package library.Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import library.Entity.Admin;
import library.Utils.C3p0Utils;

public class AdminDao {
	
	public boolean checkLogin(Admin admin) throws SQLException {
		String sql="select count(*) as count from admin where id=? and pwd=? ";
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		Object object=(Object) runner.query(sql, new ScalarHandler("count"),new Object[]{admin.getId(),admin.getPwd()});
		int num=Integer.parseInt(object.toString());
		if(num>0) {	
			return true;
		}
		return false;
	}
	public Admin sessionAdmin(String id) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select id,admin_name from admin where id="+id;
		return (Admin) runner.query(sql, new BeanHandler(Admin.class));
	}
	
}
