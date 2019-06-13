package cn.itcast.jdbc.example.domain;


import java.util.Date;

public class Example05 {
	public static void main(String[] args) throws Exception {
		UserDao ud=new UserDao();
		User user=new User();
		user.setId(152);
		user.setUsername("h1");
		user.setPassword("123");
		user.setEmail("213@qq.com");
		user.setBirthday(new Date());
		boolean b=ud.insert(user);
		System.out.print(new Date());
		System.out.println(b);
		
		
	}
}
