package cn.itcast.chapter05.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyAttributeListener implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	String name=scae.getName();
    	System.out.println("ServletContext添加属性:"+name+"="+scae.getServletContext().getAttribute(name));
    }
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
       String name=scae.getName();
       System.out.println("ServletContext替代属性:"+name+"="+scae.getServletContext().getAttribute(name));
    }
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         String name=scae.getName();
         System.out.println("ServletContext移出:"+name);
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	String name=srae.getName();
    	System.out.println("ServletRequest移出属性"+name);
    }
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	String name=srae.getName();
    	System.out.println("ServletRequest添加属性:"+name+"="+srae.getServletRequest().getAttribute(name));
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	String name=srae.getName();
    	System.out.println("ServletRequest替代属性:"+name+"="+srae.getServletRequest().getAttribute(name));
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	String name=se.getName();
    	System.out.println("HttpSession添加属性:"+name+"="+se.getSession().getAttribute(name));
    }
    
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	String name=se.getName();
    	System.out.println("HttpSession移出属性:"+name+"="+se.getSession().getAttribute(name));
    }
    
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	String name=se.getName();
    	System.out.println("HttpSession替代属性:"+name);
    }
}
