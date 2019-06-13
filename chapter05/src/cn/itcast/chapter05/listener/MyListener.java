package cn.itcast.chapter05.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements ServletRequestListener, HttpSessionListener, ServletContextListener {

    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("HttpSession���󱻴�����");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("ServletRequestEvent���󱻴ݻ�");
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("ServletRequestEvent���󱻴�����");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("HttpSession���󱻴ݻ�");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("ServletCOntext������");
         
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("ServletCOntext���󱻴�����");
    }
	
}
