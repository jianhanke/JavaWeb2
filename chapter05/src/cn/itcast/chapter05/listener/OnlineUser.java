package cn.itcast.chapter05.listener;

import java.util.HashMap;
import java.util.Map;


public class OnlineUser {
	private OnlineUser() {};
	private static OnlineUser instance=new OnlineUser();
	private Map userMap=new HashMap<>();
	public static OnlineUser getInstance() {
		return instance;
	}
	public void addUser(User user) {
		userMap.put(user.getId(),user);
	}
	public void removeUser(User user) {
		userMap.remove(user.getId());
	}
	public Map getOnlineUsers() {
		return userMap;
	}
}
