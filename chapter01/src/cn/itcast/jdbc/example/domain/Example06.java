package cn.itcast.jdbc.example.domain;

import java.util.ArrayList;

public class Example06 {
	
	public static void main(String[] args) throws Exception {
		UserDao ud=new UserDao();
		ArrayList<User>list=ud.findAll();
		for(int i=0;i<list.size();i++) {
			System.out.println("��"+(i+1)+"�����ݵ�usernameֵΪ:"+list.get(i).getUsername());
		}
	}
}
