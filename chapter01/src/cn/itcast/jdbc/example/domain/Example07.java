package cn.itcast.jdbc.example.domain;

public class Example07 {

	public static void main(String[] args) throws Exception {
		UserDao ud=new UserDao();
		User user=ud.find(15);
		System.out.println("idΪ1��User�����"+user.getUsername());

	}

}
