package cn.itcast.jdbc.example.domain;

public class Example09 {

	public static void main(String[] args) throws Exception {
		UserDao ud=new UserDao();
		boolean b=ud.delete(152);
		System.out.println(b);
	}
}
