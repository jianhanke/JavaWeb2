package cn.itcast.chapter05.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class MyBean
 *
 */
public class MyBean implements HttpSessionBindingListener {

    /**
     * Default constructor. 
     */
    public MyBean() {
        // TODO Auto-generated constructor stub
    }

    public void valueBound(HttpSessionBindingEvent event)  { 
    	System.out.println("MyBean对象被添加到了Session域..."+this);
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	System.out.println("MyBean对象从Session中移出了..."+this);
    }
	
}
