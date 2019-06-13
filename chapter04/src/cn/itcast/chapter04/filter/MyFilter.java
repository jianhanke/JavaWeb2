package cn.itcast.chapter04.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {
	
    public MyFilter() {
    	 System.out.println("我是最开始大构造方法");
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.getWriter().write("Hello MyFilte<br />");
		chain.doFilter(request, response);
		
		System.out.println("最后一个回来+早知道是枣助理教练");
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("这是一个初始化测试");
	}
}
