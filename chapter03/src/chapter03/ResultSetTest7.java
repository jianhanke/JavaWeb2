package chapter03;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class ResultSetTest7 {

	public static void main(String[] args) throws Exception {
		testColumnListHandler();

	}
	public static void testColumnListHandler()throws Exception{
		BaseDao basedao=new BaseDao();
		String sql="select * from userss";
		List list=(ArrayList<User>)basedao.query(sql, new ColumnListHandler("name"));
		System.out.println(list);
	}
	

}
