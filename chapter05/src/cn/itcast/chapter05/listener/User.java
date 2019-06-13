package cn.itcast.chapter05.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{
	private String username;
	private String password;
	private String id;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void valueBound(HttpSessionBindingEvent event) {
		OnlineUser.getInstance().addUser(this);
	}
	public void valueUnBound(HttpSessionBindingEvent event) {
		OnlineUser.getInstance().removeUser(this);
	}
	

}
