package chapter03;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class ResultSetTest6 {

	public static void main(String[] args) throws Exception {
		testMapListHandler();

	}
	public static void testMapHander()throws Exception{
		BaseDao basedao=new BaseDao();
		String sql="select * from userss where id=?";
		Map map=(Map) basedao.query(sql, new MapHandler(), 1);
		System.out.println(map);
	}
	public static void testMapListHandler()throws Exception{
		BaseDao basedao=new BaseDao();
		String sql="select * from userss";
		List list=(List)basedao.query(sql, new MapListHandler());
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(((Map) list.get(0)).get("name"));
	}

}
