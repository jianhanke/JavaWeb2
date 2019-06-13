package cn.itcast.jdbc.utils;

public class DBUtilsDaoTest3 {
	
	private static DBUtilsDao dao=new DBUtilsDao();
	
	public static void testdelete()throws Exception{
		boolean b=dao.delete(5);
		System.out.println(b);
	}
	
	public static void main(String[] args) throws Exception {
		testdelete();
	}

}
