package cn.itcast.chapter05.listener;
import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyBean2 implements HttpSessionActivationListener,Serializable{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("MyBean2�Ķ�����...");
	}
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("MyBean2�Ķ���ۻ���...");
	}
}
