package cn.itcast.chapter05.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountListener
 *
 */
public class CountListener implements HttpSessionListener {

	private int count=0;
	
	public void sessionCreated(HttpSessionEvent hse) {
		count++;      
		System.out.println(count+"这是加法");
		ServletContext context=hse.getSession().getServletContext();
		context.setAttribute("count", count);
	}
	
	public void sessionDestroyed(HttpSessionEvent hse) {
		count--;
		System.out.println(count+"这是减法");
		ServletContext context=hse.getSession().getServletContext();
		context.setAttribute("count", count);		
	}
	
}
