package cn.itcast.jdbc.example.domain;

import java.util.Date;

public class Example08 {

	public static void main(String[] args) throws Exception {
		UserDao ud=new UserDao();
		User user=new User();
		user.setId(15);
		user.setUsername("zhaoxiaoliu");
		user.setPassword("456");
		user.setEmail("fadsaf@qq.com");
		user.setBirthday(new Date());
		boolean b=ud.update(user);
		System.out.println(b);
		
		
		
	}

}
