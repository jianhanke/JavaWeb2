package chapter03;

import org.apache.commons.dbutils.handlers.BeanHandler;

public class ResultSetTest3 {

	public static void main(String[] args) throws Exception {
		testBeanHandler();

	}
	public static void testBeanHandler() throws Exception{
		BaseDao basedao=new BaseDao();
		String sql="select * from userss where id=?";
		User user=(User)basedao.query(sql, new BeanHandler(User.class),1);
		System.out.println("id为1的User对象的name值为:"+user.getName());
	}

}
