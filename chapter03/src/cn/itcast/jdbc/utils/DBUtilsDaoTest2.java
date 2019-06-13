package cn.itcast.jdbc.utils;

import chapter03.User;

public class DBUtilsDaoTest2 {
	private static DBUtilsDao dao=new DBUtilsDao();
	
	public static void main(String[] args) throws Exception {
		User user=new User();
		user.setName("zhaoliu");
		user.setPassword("65324322");
		user.setId(2);
		boolean b=dao.update(user);
		System.out.println(b);
	}

}
