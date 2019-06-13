package cn.itcast.jdbc.utils;

import chapter03.User;

public class DBUtilsDaoTest4 {
	private static DBUtilsDao dao=new DBUtilsDao();
	
	public static void testfind()throws Exception{
		User user=dao.find(1);
		System.out.println(user.getName()+user.getId()+user.getPassword());
		
	}
	
	public static void main(String[] args) throws Exception {
		testfind();

	}

}
