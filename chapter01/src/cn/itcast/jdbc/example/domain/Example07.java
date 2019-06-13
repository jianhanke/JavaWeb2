package cn.itcast.jdbc.example.domain;

public class Example07 {

	public static void main(String[] args) throws Exception {
		UserDao ud=new UserDao();
		User user=ud.find(15);
		System.out.println("id为1的User对象的"+user.getUsername());

	}

}
