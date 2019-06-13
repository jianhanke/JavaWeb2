package cn.itcast.chapter04.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class MyFilter01
 */
public class MyFilter01 implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter01() {
       System.out.println("我是01构造方法");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("Hello MyFilter01<br/>");
		chain.doFilter(request, response);
		response.getWriter().write("第一个回来测试<br/>");
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("实例化");
	}

}
