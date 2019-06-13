package cn.itcast.jdbc.utils;

import chapter03.User;

public class DBUtilsDaoTest1 {
	private static DBUtilsDao dao=new DBUtilsDao();
	
	public static  void testInsert()throws Exception{
		User user=new User();
		user.setName("zhaoliu");
		user.setPassword("12312");
		boolean b=dao.insert(user);
		System.out.println(b);
	}
	
	public static void main(String[] args) throws Exception{
		testInsert();
	}

}
