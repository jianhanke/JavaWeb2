package chapter03;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.handlers.BeanMapHandler;

public class ResultSetTest5 {

	public static void main(String[] args) throws Exception {
		testBeanMapHandler();

	}
	
	public static void testBeanMapHandler()throws Exception{
		String sql="select id,name,password from userss";
		Map<Integer,User>map=(Map<Integer,User>)BaseDao.query(sql, new BeanMapHandler<Integer,User>(User.class,"id"));
		User u=map.get(5);
		String uName=u.getName();
		String uPassword=u.getPassword();
		System.out.println("idÎª1µÄname"+uName+uPassword);
		
		Set keySet=map.keySet();
		Iterator t=keySet.iterator();
		while(t.hasNext()) {
			Object key=t.next();
			User value=map.get(key);
			System.out.println("key:"+key+",value:"+value.getName());
		}
	}

}
