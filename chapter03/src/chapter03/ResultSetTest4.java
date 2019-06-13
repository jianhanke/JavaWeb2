package chapter03;

import java.util.ArrayList;

import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ResultSetTest4 {

	public static void main(String[] args) throws Exception {
		testBeanListHandler();

	}
	
	public static void testBeanListHandler() throws Exception{
		BaseDao basedao=new BaseDao();
		String sql="select * from userss";
		ArrayList<User>list=(ArrayList<User>) basedao.query(sql, new BeanListHandler(User.class));
		for(int i=0;i<list.size();i++) {
			System.out.println("µÚ"+(i+1)+"Ìõ¼ÇÂ¼username:"+list.get(i).getName());
		}
		
	}

}
