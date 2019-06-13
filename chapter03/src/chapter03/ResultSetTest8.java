package chapter03;

import org.apache.commons.dbutils.handlers.ScalarHandler;

public class ResultSetTest8 {

	public static void main(String[] args) throws Exception {
		
		testScalarHandler();
	}
	
	public static void testScalarHandler()throws Exception{
		BaseDao basedao=new BaseDao();
		String sql="select * from userss where id=?";
		Object arr=(Object)basedao.query(sql, new ScalarHandler("name"), 5);
		System.out.println(arr);
	}

}
